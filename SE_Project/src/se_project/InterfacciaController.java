/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se_project;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import javafx.scene.control.ListView;
import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.Spliterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import se_project.DecoratorParserOperation;
import se_project.exceptions.DivisionByZeroException;
import se_project.exceptions.EmptyStackException;
import se_project.exceptions.InvalidNumberException;
import se_project.exceptions.InvalidOperationException;
import se_project.exceptions.NotApplicableOperation;
import se_project.exceptions.UndefinedPhaseException;

/**
 * FXML Controller class
 *
 * @author emanu
 */
public class InterfacciaController implements Initializable {

    /*Vengono definite una linked list contenente i comandi passati precedentemente
    nella casella di testo, un indice contenente l'indice attuale della lista e un 
    list iterator per iterare tale lista.*/
    LinkedList<String> prevs;
    int index = 0;
    ListIterator<String> it;

    @FXML
    private TextField inputField;
    @FXML
    private Button buttonPush;
    @FXML
    private ListView<ComplexNumber> listView;
    private final Solver solver = Solver.getInstance();
    private final ParserString parser = new ParserString();
    private final DecoratorParserOperation decoratorParserOperation = new DecoratorParserOperation(parser);
    private final String operation = "__OPERATION__";
    private final String operation_stack = "__OPERATION_STACK__";
    private final String complex_number = "__COMPLEX__NUMBER__";
    private final String single_number = "__SINGLENUMBER__";
    private final String invalid_insert = "__INVALID__";
    private final String still_name_inserted = "__NAME__";
    private ObservableList<ComplexNumber> observableList;
    protected ListProperty<ComplexNumber> listProperty = new SimpleListProperty<>();
    @FXML
    private SplitMenuButton splitMenuButton;
    @FXML
    private MenuItem buttonClear;
    @FXML
    private MenuItem buttonDrop;
    @FXML
    private MenuItem buttonDuplicate;
    @FXML
    private MenuItem buttonSwap;
    @FXML
    private MenuItem buttonOver;

    public void initialize(URL url, ResourceBundle rb) {
        observableList = FXCollections.observableArrayList();

        /*si inizilizzano lista e iteratore*/
        prevs = new LinkedList<>();
        it = prevs.listIterator();
        inputField.setOnKeyPressed((KeyEvent event) -> {
            String tmp;
            /*se è stato premuto enter, si passa la stringa scritta nella casella 
            di testo al parser*/
            if (event.getCode().equals(KeyCode.ENTER)) {
                buttonPush.fire();
            }
            /*se è stata premuta freccia su, si prende il comando passato precedentemente a 
            quello in cui si sta iterando. Se non ci sono comandi precedenti, non fa nulla.*/
            if (event.getCode().equals(KeyCode.UP)) {
                try {
                    it = prevs.listIterator(index);

                    tmp = it.previous();
                    if (!tmp.isEmpty()) {
                        inputField.setText(tmp);
                    }
                    index--;
                } catch (IndexOutOfBoundsException | NoSuchElementException ex) {
                    index = 0;

                }
            }
            /*se è stata premuta freccia giù, si prende il comando passato successivamente a 
            quello in cui si sta iterando. Se non ci sono comandi successivi, si inserisce la
            stringa vuota nella casella di testo.*/
            if (event.getCode().equals(KeyCode.DOWN)) {
                try {
                    it = prevs.listIterator(index);

                    tmp = it.next();
                    if (!tmp.isEmpty()) {
                        inputField.setText(tmp);
                    }
                    index++;
                } catch (IndexOutOfBoundsException | NoSuchElementException ex) {
                    inputField.setText("");
                    index = prevs.size();

                }

            }

        });

        observableList.addAll(solver.getStructureStack().getStack());
        listView.setItems(observableList);

    }

    @FXML
    private void ActionPush(ActionEvent event) {
        String text = inputField.getText();
        if (!text.isEmpty()) {
            prevs.addLast(text);
            index = prevs.size();
        }
        if (decoratorParserOperation.getNames() != null && decoratorParserOperation.getNames().contains(text)) {
            try {
                this.userOperation(text);
            } catch (EmptyStackException | NotApplicableOperation | InvalidNumberException | UndefinedPhaseException | DivisionByZeroException | InvalidOperationException ex) {
                this.Alert("errore", "Operazione non valida ", text);
            }
            return;
        }
        String code = invalid_insert;
        try {
            code = decoratorParserOperation.parserString(text);
        } catch (ArrayIndexOutOfBoundsException e) {
            this.Alert("Errore!", "Operazione non valida", text + "--> L'inserimento non è valido");
            inputField.clear();
            return;
        }

        ComplexNumber n;
        if (code.equals(complex_number)) {
            n = decoratorParserOperation.recognizeComplexNumber(text);
            //observableList.add(n);
            solver.getStructureStack().push(n);
        }
        if (code.equals(single_number)) {
            n = decoratorParserOperation.recognizeNumber(text);
            //observableList.add(n);
            solver.getStructureStack().push(n);
        }
        if (code.equals(operation)) {
              try {
                solver.resolveOperation(text);
            } catch (DivisionByZeroException ex) {
                this.Alert("Errore!", "Operazione non ammissibile", "Non si può dividere per 0");
            } catch (NotApplicableOperation ex) {
                this.Alert("Errore!", "Operazione non ammissibile", "Mancano gli operandi");
            } catch (InvalidNumberException ex) {
                this.Alert("Errore!", "Operazione non ammissibile", "");
            } catch (EmptyStackException ex) {
                this.Alert("Errore!", "Operazione non ammissibile", "Lo stack è vuoto!");
            } catch (UndefinedPhaseException ex) {
                this.Alert("Errore!", "Operazione non ammissibile", "La fase non è definita.");
            }
        }

        if (code.equals(operation_stack)) {
            try {
                try {
                    solver.resolveOperationStack(text);
                } catch (EmptyStackException ex) {
                this.Alert("Errore!", "Operazione non ammissibile", "Lo stack è vuoto!");
                }
            } catch (InvalidOperationException ex) {
                this.Alert("Errore!", "Operazione non ammissibile", "");
            }
        }
        if (code.equals(invalid_insert)) {
            this.Alert("Inserimento non valido", "L'elemento inserito non è corretto , riprovare", text + " --> L'inserimento non è valido");
        }
        if (decoratorParserOperation.getNames().contains(code)) {
            this.inizializeMenuButton(code);

        }
        if (code.equals(still_name_inserted)) {
            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Operazione già inserita");
            alert.setHeaderText("L'operazione è già stata inserita");
            alert.setContentText("Vuoi sovrascriverla?");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                String textString = decoratorParserOperation.clearStringOperation(text);
                String[] string = textString.split("\\$");
                String possible_name = string[0];
                possible_name = possible_name.replaceAll(" ", "");
                decoratorParserOperation.removeOperation(possible_name);
                Iterator<MenuItem> iterator = splitMenuButton.getItems().iterator();
                MenuItem menuItemDelete = new MenuItem();
                while (iterator.hasNext()) {
                    MenuItem menuItem = iterator.next();
                    //System.out.println(menuItem.getText());
                    if (menuItem.getText().equals(possible_name)) {
                        menuItemDelete = menuItem;
                    }
                }
                splitMenuButton.getItems().remove(menuItemDelete);
                decoratorParserOperation.parserString(text);
                this.inizializeMenuButton(possible_name);

            } else;
        }

        observableList.clear();
        observableList.addAll(solver.getStructureStack().getStack());
        inputField.clear();
        System.out.println(decoratorParserOperation.toString());
    }

    @FXML
    public void numberOnText(ActionEvent ae) {
        String no = ((Button) ae.getSource()).getText();
        inputField.setText(inputField.getText() + no);
    }

    @FXML
    public void operationOnText(ActionEvent ae) {
        String no = ((Button) ae.getSource()).getText();
        inputField.setText(inputField.getText() + no);
    }

    @FXML
    void divisionOnText(ActionEvent event) {
        inputField.setText(inputField.getText() + "/");
    }

    @FXML
    void multiplicationOnText(ActionEvent event) {
        inputField.setText(inputField.getText() + "*");
    }

    @FXML
    void sqrtOnText(ActionEvent event) {
        inputField.setText(inputField.getText() + "sqrt");
    }

    @FXML
    void invertedOnText(ActionEvent event) {
        inputField.setText(inputField.getText() + "+-");
    }

    public void Alert(String title, String headerText, String contentText) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.setContentText(contentText);
        alert.showAndWait().ifPresent(rs -> {
            if (rs == ButtonType.OK);
        });

    }

    public void inizializeMenuButton(String code) {
        MenuItem choice = new MenuItem(code);
        splitMenuButton.getItems().add(choice);
        choice.setOnAction((e) -> {
            try {
                this.userOperation(code);
            } catch (EmptyStackException | NotApplicableOperation | InvalidNumberException | UndefinedPhaseException | DivisionByZeroException | InvalidOperationException ex) {
                this.Alert("errore", "Operazione non valida ", code);
            }
        });
        observableList.clear();
        observableList.addAll(solver.getStructureStack().getStack());
    }

    @FXML
    private void ActionClear(ActionEvent event) throws EmptyStackException {

        this.solver.getStructureStack().clear();
        observableList.clear();
        observableList.addAll(solver.getStructureStack().getStack());

    }

    @FXML
    private void ActionDrop(ActionEvent event) throws EmptyStackException {
        this.solver.getStructureStack().drop();
        observableList.clear();
        observableList.addAll(solver.getStructureStack().getStack());
    }

    @FXML
    private void ActionDuplicate(ActionEvent event) throws EmptyStackException {
        this.solver.getStructureStack().duplicate();
        observableList.clear();
        observableList.addAll(solver.getStructureStack().getStack());
    }

    @FXML
    private void ActionSwap(ActionEvent event) throws EmptyStackException, InvalidOperationException {
        this.solver.getStructureStack().swap();
        observableList.clear();
        observableList.addAll(solver.getStructureStack().getStack());
    }

    @FXML
    private void ActionOver(ActionEvent event) throws EmptyStackException, InvalidOperationException {
        this.solver.getStructureStack().over();
        observableList.clear();
        observableList.addAll(solver.getStructureStack().getStack());
    }

  
    public void userOperation(String text) throws EmptyStackException, NotApplicableOperation, InvalidNumberException, UndefinedPhaseException, DivisionByZeroException, InvalidOperationException {
        inputField.clear();
        LinkedList<String> operations = decoratorParserOperation.getOperations(text);
        if (operations == null) {
            return;
        }
        for (String op : operations) {
           if (decoratorParserOperation.checkOperation(op).equals(operation)) {
                this.solver.resolveOperation(op);
            } else if (decoratorParserOperation.checkOperationStack(op).equals(operation_stack)) {
                this.solver.resolveOperationStack(op);
            } else if (decoratorParserOperation.getNames().contains(op)) {
                    this.ricorsion(op);
          
                observableList.clear();
                observableList.addAll(solver.getStructureStack().getStack());

            }
            observableList.clear();
            observableList.addAll(solver.getStructureStack().getStack());

        }
    }

    public void ricorsion(String op) throws EmptyStackException, NotApplicableOperation, InvalidNumberException, DivisionByZeroException, UndefinedPhaseException, InvalidOperationException {
        if(decoratorParserOperation.getOperations(op) == null)return;
        for (String opUser : decoratorParserOperation.getOperations(op)) {
             if (decoratorParserOperation.checkOperation(opUser).equals(operation)) {
                solver.resolveOperation(opUser);

            } else if (decoratorParserOperation.checkOperationStack(opUser).equals(operation_stack)) {
                this.solver.resolveOperationStack(opUser);
            } else if (decoratorParserOperation.getNames().contains(opUser)) {
                ricorsion(opUser);
            }
            observableList.clear();
            observableList.addAll(solver.getStructureStack().getStack());

        }
        observableList.clear();
        observableList.addAll(solver.getStructureStack().getStack());

    }
    
    public void saveFunctions(){
        PrintWriter pw = null;
        try {
            ParserString parserString = new ParserString();
            DecoratorParserOperation decoratorParserOperation = null;
            HashMap<String, LinkedList<String>> map = new HashMap<>();
            LinkedList<String> linkedList = new LinkedList<>();
            Collections.addAll(linkedList, "+" , "-" , "*");
            map.put("prova",linkedList);
            map.put("provadue", linkedList);
            decoratorParserOperation = new DecoratorParserOperation(parserString, map);
            FileChooser fc = new FileChooser();
            fc.setTitle("Save functions ...");
            fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("text file", "*.txt"));
            File file = fc.showSaveDialog(new Stage());
            pw = new PrintWriter(file);
            pw.write(decoratorParserOperation.toString());
            pw.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(InterfacciaController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            pw.close();
        }
    }

}
