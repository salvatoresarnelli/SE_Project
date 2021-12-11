/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package se_project;

import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerBasicCloseTransition;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import java.awt.Color;
import java.io.IOException;
import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import other.VariableSet;
import se_project.commands.variablesCommands.DiffVariableCommand;
import se_project.commands.variablesCommands.SumVariableCommand;
import se_project.commands.variablesCommands.VariableCommand;
import se_project.exceptions.DivisionByZeroException;
import se_project.exceptions.EmptyStackException;
import se_project.exceptions.InterruptedExecutionException;
import se_project.exceptions.InvalidNumberException;
import se_project.exceptions.InvalidVariableNameException;
import se_project.exceptions.NonExistingVariable;
import se_project.exceptions.OperationNotFoundException;
import se_project.exceptions.UndefinedPhaseException;
import se_project.exceptions.VariableExistingException;
import se_project.parser.VariableParser;
import se_project.parser.ParserString;

/**
 * FXML Controller class
 *
 * @author Salvatore Sarnelli
 */
public class VariablesManagerController implements Initializable {

    @FXML
    private TableView<VariableSet> variablesTableView;
    @FXML
    private TableColumn<VariableSet, String> variablesColumn;
    @FXML
    private TableColumn<VariableSet, String> valuesColumn;

    private ObservableList<VariableSet> observableList;

    private VariablesDict dictionary;
    private Solver solver;
    @FXML
    private Button plusVarButton;
    @FXML
    private Button minusVarButton;
    @FXML
    private Button loadButton;
    private VBox box;
    @FXML
    private HBox hbox;
    @FXML
    private Button saveButton1;
    @FXML
    private JFXHamburger hamburger;
    @FXML
    private JFXDrawer drawer;
    @FXML
    private ListView<ComplexNumber> listView;
    @FXML
    private Button addVarButton;
    @FXML
    private Button removeVarButton;
    @FXML
    private FontAwesomeIconView leftArrow;
    @FXML
    private FontAwesomeIconView rightArrow;
    private VariablesStack variablesStack;
    private ListIterator<Record> iterator;
    private int index;
    @FXML
    private TableColumn<?, ?> raw;
    @FXML
    private TextField input;
    @FXML
    private FontAwesomeIconView doubleRight;
    @FXML
    private FontAwesomeIconView doubleLeft;
    @FXML
    private Button pushVariableButton;

    /**
     * Initializes the controller class.
     */
    public void initialize(URL url, ResourceBundle rb) {
        dictionary = VariablesDict.getInstance();
        variablesStack = VariablesStack.getInstance();
        solver = Solver.getInstance();
        observableList = FXCollections.observableArrayList();
        updateTable();
        raw.setCellValueFactory(new PropertyValueFactory("date"));

        variablesColumn.setCellValueFactory(new PropertyValueFactory("variable"));
        valuesColumn.setCellValueFactory(new PropertyValueFactory("value"));
        variablesColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        valuesColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        variablesTableView.setItems(observableList);
        index = variablesStack.length();
        listView.setItems(FXCollections.observableList(solver.getStructureStack().getStack()));
        iterator = (ListIterator<Record>) variablesStack.iterator(index);
        try {
            box = FXMLLoader.load(getClass().getResource("sidePane.fxml"));
        } catch (IOException ex) {
            alert("unable to reach sidepane.fxml", "", "");
        }
        for (Node n : box.getChildren()) {
            if (n.getAccessibleText() != null) {
                n.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {

                    try {
                        switch (n.getAccessibleText()) {

                            case "home":
                                Node homePage = FXMLLoader.load(getClass().getResource("calculator.fxml"));
                                hbox.getChildren().setAll(homePage);
                                break;
                            case "Salva Funzione":
                                Node variablesManager = FXMLLoader.load(getClass().getResource("VariablesManager.fxml"));
                                hbox.getChildren().setAll(variablesManager);
                                break;

                            case "Carica Funzione":
                                Node update = FXMLLoader.load(getClass().getResource("OperationsManager.fxml"));
                                hbox.getChildren().setAll(update);
                                break;

                            case "Gestione Operazioni":
                                Node opManager = FXMLLoader.load(getClass().getResource("OperationsManager.fxml"));
                                hbox.getChildren().setAll(opManager);
                                break;

                            case "Gestione Variabili":
                                Node varManager = FXMLLoader.load(getClass().getResource("VariablesManager.fxml"));
                                hbox.getChildren().setAll(varManager);
                                break;

                        }
                    } catch (Exception ee) {
                        System.out.println("Error");
                    }
                });
            }
        }
        HamburgerBasicCloseTransition transition = new HamburgerBasicCloseTransition(hamburger);
        transition.setRate(-1);
        drawer.setSidePane(box);
        drawer.setVisible(false);
        //drawer.setMinWidth(0);
        hamburger.setOnMouseClicked(event -> {
            transition.setRate(transition.getRate() * -1);
            transition.play();
            if (!drawer.isOpened()) {
                // drawer.setMinWidth(220);
                // drawer.setVisible(true);
                drawer.open();

                drawer.setVisible(true);
            } else {
                //  drawer.setMinWidth(0);
                drawer.close();
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        drawer.setVisible(false);
                    }
                });

            }
        });
    }

    public void alert(String title, String headerText, String contentText) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.setContentText(contentText);
        alert.showAndWait().ifPresent(rs -> {
            if (rs == ButtonType.OK);
        });

    }

    public void updateTable() {
        VariableSet variableSet;
        observableList.clear();
        for (Character ch : dictionary.getTable().keySet()) {
            ComplexNumber value;
            try {
                value = dictionary.getVariableValue(ch);
                variableSet = new VariableSet(ch.toString(), value.toString());
                observableList.add(variableSet);

            } catch (InvalidVariableNameException | NonExistingVariable ex) {

            }

        }
        raw.setText("Aggiornata a: Ora");
    }

    public void setObservableList(ObservableList<VariableSet> list) {
        observableList = list;
        variablesTableView.setItems(list);
    }

    private void sumDiffResolveCommand(VariableCommand command) {
        VariableSet selected = variablesTableView.getSelectionModel().getSelectedItem();
        if (selected != null) {
            String readVariable = selected.getVariable();
            command.setVariable(readVariable.charAt(0));
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Non riesco ad eseguire l'operazione");
            alert.setHeaderText("Variabile non valida");
            return;
        }
        try {
            solver.resolveOperation(command);
        } catch (InvalidNumberException ex) {
            showLightPane("Numero non valido.");
        } catch (EmptyStackException ex) {
            showLightPane("Attenzione, lo stack è vuoto!");
        } catch (UndefinedPhaseException ex) {
            showLightPane("La fase di questo numero non è definita.");
        } catch (DivisionByZeroException ex) {
            showLightPane("Attenzione, la divisione per zero non è ammessa");
        } catch (InvalidVariableNameException ex) {
            showLightPane("Il nome della variabile non è ammissibile!");
        } catch (VariableExistingException ex) {
            showLightPane("La variabile è già esistente");
        } catch (InterruptedExecutionException ex) {
            showLightPane("Si è verificato un errore..");
        } catch (Exception ex) {
            showLightPane("Si è verificato un errore..");
        }
        updateTable();
    }

    @FXML
    private void plusVarButtonActionPush(ActionEvent event) {
        if (index != variablesStack.length()) {
            alert("Attenzione!", "Non posso effettuare quest'operazione su una variabile salvata in memoria!", "Passa ad una delle variabili correnti e riprova");
        } else {
            SumVariableCommand command = new SumVariableCommand();
            sumDiffResolveCommand(command);
        }
    }

    @FXML
    private void minusVarButtonActionPush(ActionEvent event) {
        if (index != variablesStack.length()) {
            alert("Attenzione!", "Non posso effettuare quest'operazione su una variabile salvata in memoria!", "Passa ad una delle variabili correnti e riprova");
        } else {
            DiffVariableCommand command = new DiffVariableCommand();
            sumDiffResolveCommand(command);
        }
    }

    @FXML
    private void saveButtonActionPush(ActionEvent event) {
        variablesStack.pushVariablesSnapShot(dictionary);
        showLightPane("Salvataggio effettuato con successo!");
        index++;

    }

    @FXML
    private void loadButtonActionPush(ActionEvent event) {
        Record r;
        ComplexNumber c;
        try {
            r = variablesStack.popVariableSnapShot();
            dictionary.getTable().clear();
            for (Character ch : r.getDictRecord().keySet()) {
                c = r.getDictRecord().get(ch);
                if (c != null) {
                    dictionary.getTable().put(ch, c);

                }
            }
            index = variablesStack.length();
            updateTable();
            showLightPane("Caricamento effettuato con successo!");

        } catch (NoSuchElementException ex) {
            showLightPane("Impossibile recuperare lo stato precedente delle variabili.");
        }
    }

    @FXML
    private void addVarButtonAction(ActionEvent event) {

        String inputText = input.getText();
        if (inputText != null && !inputText.isEmpty()) {

            VariableParser parser = new VariableParser(new ParserString());
            try {
                VariableCommand command = (VariableCommand) parser.parse(">" + inputText);
                solver.resolveOperation(command);
            } catch (OperationNotFoundException ex) {
                showLightPane("Parametro non valido");

            } catch (Exception ex) {
                showLightPane("Impossibile eseguire l'operazione richiesta.");
            }
            input.clear();
            updateTable();
        } else {
            showLightPane("Inserire il nome di una variabile nella casella di testo prima di procedere.");

        }
    }

    @FXML
    private void removeVarButtonAction(ActionEvent event) {
        String inputText = input.getText();
        if (inputText != null && !inputText.isEmpty()) {
            inputText = inputText.replaceAll(" ", "");
            if (inputText.length() == 1) {

                dictionary.remove(inputText.charAt(0));
            }
            input.clear();
        } else {
            showLightPane("Inserire il nome di una variabile nella casella di testo prima di procedere.");
        }
        updateTable();

    }

    @FXML
    private void leftArrowAction(MouseEvent event) {
        try {
            iterator = (ListIterator<Record>) variablesStack.iterator(index);
            Record read = iterator.next();
            HashMap<Character, ComplexNumber> map = read.getDictRecord();
            index++;
            VariableSet variableSet;
            observableList.clear();
            for (Character ch : map.keySet()) {
                ComplexNumber value;
                value = map.get(ch);
                if (value != null) {
                    variableSet = new VariableSet(ch.toString(), value.toString());
                } else {
                    variableSet = new VariableSet(ch.toString(), "Nessun valore disponibile.");
                }

                observableList.add(variableSet);

            }
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String formatDateTime = read.getDate().format(formatter);
            raw.setText("Aggiornata a: " + formatDateTime);
        } catch (NoSuchElementException ex) {
            updateTable();
        }
    }

    @FXML
    private void rightArrowAction(MouseEvent event) {
        try {

            iterator = (ListIterator<Record>) variablesStack.iterator(index);
            Record read = iterator.previous();
            HashMap<Character, ComplexNumber> map = read.getDictRecord();
            index--;
            VariableSet variableSet;
            observableList.clear();
            for (Character ch : map.keySet()) {
                ComplexNumber value;
                value = map.get(ch);
                if (value != null) {
                    variableSet = new VariableSet(ch.toString(), value.toString());
                } else {
                    variableSet = new VariableSet(ch.toString(), "Nessun valore disponibile.");
                }

                observableList.add(variableSet);

            }
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String formatDateTime = read.getDate().format(formatter);
            raw.setText("Aggiornata a: " + formatDateTime);

        } catch (NoSuchElementException ex) {

        }
    }

    @FXML
    private void doubleRightAction(MouseEvent event) {
        HashMap<Character, ComplexNumber> map = dictionary.getTable();
        Record read = null;
        try{
        if (variablesStack.length() > 0) {
                index =0;
                read = variablesStack.last();
                map = read.getDictRecord();
                VariableSet variableSet;
                observableList.clear();
                for (Character ch : map.keySet()) {
                    ComplexNumber value;
                    value = map.get(ch);
                    if (value != null) {
                        variableSet = new VariableSet(ch.toString(), value.toString());
                    } else {
                        variableSet = new VariableSet(ch.toString(), "Nessun valore disponibile.");
                    }

                    observableList.add(variableSet);

                }
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                String formatDateTime = read.getDate().format(formatter);
                raw.setText("Aggiornata a: " + formatDateTime);
            }
            } catch (NoSuchElementException ex) {

            }
        
    }

    @FXML
    private void doubleLeftAction(MouseEvent event) {
        index = variablesStack.length();
        updateTable();
    }

    @FXML
    private void pushVariableAction(ActionEvent event) {

        String inputText = input.getText();
        if (inputText != null && !inputText.isEmpty()) {

            VariableParser parser = new VariableParser(new ParserString());
            try {
                VariableCommand command = (VariableCommand) parser.parse("<" + inputText);
                solver.resolveOperation(command);
            } catch (OperationNotFoundException ex) {
                showLightPane("Parametro non valido.");
            } catch (Exception ex) {
                showLightPane("Impossibile eseguire l'operazione richiesta.");
            }
            input.clear();
            updateTable();
        } else {
            showLightPane("Inserire il nome di una variabile nella casella di testo prima di procedere");
        }
        listView.setItems(FXCollections.observableList(solver.getStructureStack().getStack()));

    }

    private void showLightPane(String msg) {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                JOptionPane pane = new JOptionPane(msg, JOptionPane.INFORMATION_MESSAGE);

                JDialog dialog = pane.createDialog(null);
                dialog.setModal(false);
                dialog.setLocation(500, 380);

                int intValue = Integer.parseInt("FCFCDA", 16);
                Color aColor = new Color(intValue);
                pane.setBackground(aColor);
                dialog.setBackground(aColor);
                dialog.setVisible(true);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                    Logger.getLogger(VariablesManagerController.class.getName()).log(Level.SEVERE, null, ex);
                }

                dialog.setVisible(false);
            }
        });

    }
}
