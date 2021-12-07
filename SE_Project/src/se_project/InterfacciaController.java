/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se_project;

import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerBasicCloseTransition;
import com.jfoenix.transitions.hamburger.HamburgerNextArrowBasicTransition;
import com.jfoenix.transitions.hamburger.HamburgerSlideCloseTransition;
import static java.awt.SystemColor.menu;
import se_project.parser.UserDefinedOperationParser;
import se_project.parser.ParserString;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
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
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextField;
import javafx.scene.input.InputEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import se_project.commands.userDefinedOperations.ExecuteUserDefinedOperationCommand;
import se_project.commands.userDefinedOperations.InsertUserDefinedOperationCommand;
import se_project.commands.OperationCommand;
import se_project.exceptions.OperationNotFoundException;
import se_project.commands.variablesCommands.NewVariableCommand;
import se_project.commands.variablesCommands.OverrideVariableCommand;
import se_project.exceptions.DivisionByZeroException;
import se_project.exceptions.EmptyStackException;
import se_project.exceptions.ExistingNameException;
import se_project.exceptions.InterruptedExecutionException;
import se_project.exceptions.InvalidNumberException;
import se_project.exceptions.InvalidOperationException;
import se_project.exceptions.InvalidVariableNameException;
import se_project.exceptions.NotApplicableOperation;
import se_project.exceptions.UndefinedPhaseException;
import se_project.exceptions.VariableExistingException;
import se_project.parser.ComplexNumberParser;
import se_project.parser.OperationParser;
import se_project.parser.StackOperationParser;
import se_project.parser.VariableParser;

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
    private final UserDefinedOperationParser decoratorParserOperation = new UserDefinedOperationParser(
            new VariableParser(new StackOperationParser(new OperationParser(new ComplexNumberParser(
                    new ParserString())))));

    private ObservableList<ComplexNumber> observableList;
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
    @FXML
    private JFXHamburger hamburger;
    @FXML
    private JFXDrawer drawer ;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            VBox box = FXMLLoader.load(getClass().getResource("sidePane.fxml"));
            HamburgerBasicCloseTransition transition = new HamburgerBasicCloseTransition(hamburger);
            transition.setRate(-1);
            drawer.setSidePane(box);
            drawer.setMinWidth(0);
            hamburger.setOnMouseClicked(event -> {
                transition.setRate(transition.getRate() * -1);
                transition.play();
                if(!drawer.isOpened()){
                    drawer.setMinWidth(220);

                    drawer.open();
                }else{
                    drawer.setMinWidth(0);

                    drawer.close();
                }
            });
        } catch (IOException ex) {
            Logger.getLogger(InterfacciaController.class.getName()).log(Level.SEVERE, null, ex);
        }
            /*si inizilizzano lista e iteratore*/
            prevs = new LinkedList<>();
            it = prevs.listIterator();
            observableList = FXCollections.observableArrayList();

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
        try {
            String text = inputField.getText();
            if (!text.isEmpty()) {
                prevs.addLast(text);
                index = prevs.size();
            }
            OperationCommand code = null;
            /*  if (decoratorParserOperation.getNames() != null && decoratorParserOperation.getNames().contains(text)) {
                try {
                    userOperation(text);
                } catch (EmptyStackException | NotApplicableOperation | InvalidNumberException | UndefinedPhaseException | DivisionByZeroException | InvalidOperationException ex) {
                    this.Alert("errore", "Operazione non valida ", text);
                }
                return;
            }
            
             */
            try {
                code = decoratorParserOperation.parse(text);

            } catch (ArrayIndexOutOfBoundsException e) {
                alert("Errore!", "Operazione non valida", text + "--> L'inserimento non è valido");
                inputField.clear();
                return;
            } catch (OperationNotFoundException ex) {
                alert("Errore!", "Operazione non valida", text + "--> L'inserimento non è valido");
            } catch (NullPointerException ex) {
                alert("Errore!", "Operazione non valida", text + "--> L'inserimento non è valido");
            } catch (ExistingNameException ex) {
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
                    decoratorParserOperation.parse(text);
                    this.inizializeMenuButton(possible_name);

                }

            } catch (Exception ex) {
                alert("Errore!", "Operazione non valida", text + "--> L'inserimento non è valido");
            }

            if (code != null) {
                try {
                    solver.resolveOperation(code);
                } catch (EmptyStackException ex) {
                    alert("Errore!", "Operazione non valida", "Lo stack è vuoto!");
                } catch (NotApplicableOperation ex) {
                    alert("Errore!", "Operazione non valida", "");
                } catch (InvalidNumberException ex) {
                    alert("Errore!", "Inserito un numero non valido", text);
                } catch (InvalidVariableNameException ex) {
                    alert("Errore!", "Inserito una variabile non valida", text);
                } catch (UndefinedPhaseException ex) {
                    alert("Errore!", "Fase non definita", text);
                } catch (DivisionByZeroException ex) {
                    alert("Errore!", "Divisione per zero.", "");
                } catch (VariableExistingException ex) {
                    Alert alert = new Alert(AlertType.WARNING, "Variabile" + ((NewVariableCommand) code).getVariable() + " esistente, sovrascriverne il valore? ", ButtonType.YES, ButtonType.NO);
                    alert.showAndWait();
                    if (alert.getResult() == ButtonType.YES) {
                        OverrideVariableCommand ovc = new OverrideVariableCommand((NewVariableCommand) code);
                        solver.resolveOperation(ovc);
                    }

                } catch (InterruptedExecutionException ex) {
                    Alert alert = new Alert(AlertType.WARNING, "L'esecuzione della funzione è stata interrotta a causa del seguente errore:" + ex.getExceptionCause()
                            + "\nContinuare? ", ButtonType.YES, ButtonType.NO);
                    alert.showAndWait();
                    if (alert.getResult() == ButtonType.YES) {

                    }
                    if (alert.getResult() == ButtonType.NO) {
                        //solver.rollBack(ex.getRollBackList());
                    }
                }
                if (code instanceof InsertUserDefinedOperationCommand) {
                    if (decoratorParserOperation.getNames().contains(
                            ((InsertUserDefinedOperationCommand) code).getName())) {
                        this.inizializeMenuButton(((InsertUserDefinedOperationCommand) code).getName());

                    }
                }
            } else {
                alert("Attenzione!", "impossibile eseguire l'operazione richiesta.", "operazione sconosciuta.");
            }

            observableList.clear();
            observableList.addAll(solver.getStructureStack().getStack());
            inputField.clear();

        } catch (InvalidNumberException ex) {
            alert("Errore!", "Operazione non valida", "L'inserimento non è valido");
        } catch (EmptyStackException ex) {
            alert("Errore!", "Operazione non valida", "Stack vuoto");
        } catch (UndefinedPhaseException ex) {
            alert("Errore!", "Operazione non valida", "fase non definita");
        } catch (DivisionByZeroException ex) {
            alert("Errore!", "Operazione non valida", "Divisione per zero");
        } catch (Exception ex) {
            alert("Errore!", "Operazione non valida", "Si è verificato un errore...");
        }
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

    public void alert(String title, String headerText, String contentText) {
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
                //this.userOperation(code);
                decoratorParserOperation.parse(code);
            } catch (EmptyStackException | NotApplicableOperation | InvalidNumberException | UndefinedPhaseException | DivisionByZeroException | InvalidOperationException ex) {
                alert("errore", "Operazione non valida ", code);

            } catch (ExistingNameException ex) {
                Logger.getLogger(InterfacciaController.class
                        .getName()).log(Level.SEVERE, null, ex);
            } catch (OperationNotFoundException ex) {
                Logger.getLogger(InterfacciaController.class
                        .getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(InterfacciaController.class
                        .getName()).log(Level.SEVERE, null, ex);
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

    @FXML
    public void saveFunctions() {
        PrintWriter pw = null;
        try {
            FileChooser fc = new FileChooser();
            fc.setTitle("Save functions ...");
            fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("text file", "*.txt"));
            File file = fc.showSaveDialog(new Stage());
            pw = new PrintWriter(file);
            String s = "";
            s = decoratorParserOperation.getNames().stream().map((name) -> name + " " + decoratorParserOperation.getOperationString(name) + " \n").reduce(s, String::concat);

            pw.write(s);
            pw.close();

        } catch (FileNotFoundException ex) {
            this.alert("Impossibile effettuare il salvataggio sul file", "Errore", " ");
        } finally {
            pw.close();
        }
    }

    @FXML
    private void ActionPush(KeyEvent event) {
    }
    
            
    

}
