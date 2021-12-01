/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se_project;

import javafx.scene.control.ListView;
import java.net.URL;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.Spliterator;
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
import se_project.exceptions.DivisionByZeroException;
import se_project.exceptions.EmptyStackException;
import se_project.exceptions.InvalidNumberException;
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
    private final String complex_number = "__COMPLEX__NUMBER__";
    private final String single_number = "__SINGLENUMBER__";
    private final String invalid_insert = "__INVALID__";
    private final String still_name_inserted = "__NAME__";
    private ObservableList<ComplexNumber> observableList;
    protected ListProperty<ComplexNumber> listProperty = new SimpleListProperty<>();
    @FXML
    private SplitMenuButton splitMenuButton;

    public void initialize(URL url, ResourceBundle rb) {
        observableList = FXCollections.observableList(solver.getStructureStack().getStack());
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

        listProperty.set(observableList);
    }

    @FXML
    private void ActionPush(ActionEvent event) throws NotApplicableOperation, InvalidNumberException, EmptyStackException, UndefinedPhaseException {
        String text = inputField.getText();
        if (!text.isEmpty()) {
            prevs.addLast(text);
            index = prevs.size();
        }
        if (decoratorParserOperation.getNames() != null && decoratorParserOperation.getNames().contains(text)) {
            inputField.clear();
            LinkedList<String> operations = decoratorParserOperation.getOperations(text);
            operations.forEach((op) -> {
                try {
                    if (decoratorParserOperation.getNames().contains(op)) {
                        LinkedList<String> execute = decoratorParserOperation.getOperations(op);

                        for (String s : execute) {
                            if (s.equals("square root") || s.equals("sqrt")) {
                                observableList.addAll(solver.squareRoot());

                            } else {
                                observableList.add(solver.resolveOperation(s));
                            }
                        }
                        return;
                    }
                    if (op.equals("square root") || op.equals("sqrt")) {
                        observableList.addAll(solver.squareRoot());

                    } else {
                        observableList.add(solver.resolveOperation(op));
                        System.out.println("ciao");
                    }

                } catch (DivisionByZeroException ex) {
                    this.Alert("Errore!", "Operazione non ammissibile", "Non si può dividere per 0");

                } catch (NotApplicableOperation | InvalidNumberException | EmptyStackException | UndefinedPhaseException ex) {
                    this.Alert("Errore!", "Operazione non ammissibile", " ");
                }
            });
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
            observableList.add(n);
        }
        if (code.equals(single_number)) {
            n = decoratorParserOperation.recognizeNumber(text);
            observableList.add(n);
        }
        if (code.equals(operation)) {
            try {
                if (text.equals("square root") || text.equals("sqrt")) {
                    observableList.addAll(solver.squareRoot());
                } else {
                    n = solver.resolveOperation(text);
                    observableList.add(n);
                }

            } catch (DivisionByZeroException ex) {
                this.Alert("Errore!", "Operazione non ammissibile", "Non si può dividere per 0");
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
                    System.out.println(menuItem.getText());
                    if (menuItem.getText().equals(possible_name)) {
                        menuItemDelete = menuItem;
                    }
                }
                splitMenuButton.getItems().remove(menuItemDelete);
                decoratorParserOperation.parserString(text);
                this.inizializeMenuButton(possible_name);

            } else;
        }

        listView.itemsProperty().bind(listProperty);
        inputField.clear();
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

    @FXML
    private void ActionPush(KeyEvent event) {
    }

    public void inizializeMenuButton(String code) {
        MenuItem choice = new MenuItem(code);
        splitMenuButton.getItems().add(choice);
        choice.setOnAction((e) -> {
            inputField.clear();
            LinkedList<String> operations = decoratorParserOperation.getOperations(code);
            operations.forEach((op) -> {
                try {
                    if (decoratorParserOperation.getNames().contains(op)) {
                        LinkedList<String> execute = decoratorParserOperation.getOperations(op);
                        System.out.println(execute);
                        for (String s : execute) {
                            if (s.equals("square root") || s.equals("sqrt")) {
                                observableList.addAll(solver.squareRoot());

                            } else {
                                observableList.add(solver.resolveOperation(s));
                            }
                        }
                        return;
                    }
                    if (op.equals("square root") || op.equals("sqrt")) {
                        observableList.addAll(solver.squareRoot());

                    } else {
                        observableList.add(solver.resolveOperation(op));
                    }

                } catch (DivisionByZeroException ex) {
                    this.Alert("Errore!", "Operazione non ammissibile", "Non si può dividere per 0");

                } catch (NotApplicableOperation | InvalidNumberException | EmptyStackException | UndefinedPhaseException ex) {
                    this.Alert("Errore!", "Operazione non ammissibile", " ");
                }
            });

        });
    }
}
