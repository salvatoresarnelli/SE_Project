/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package se_project;

import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerBasicCloseTransition;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URL;
import java.util.Map;
import java.util.Observable;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.util.Callback;
import other.VariableSet;
import se_project.commands.OperationCommand;
import se_project.commands.variablesCommands.DiffVariableCommand;
import se_project.commands.variablesCommands.SumVariableCommand;
import se_project.commands.variablesCommands.VariableCommand;
import se_project.exceptions.DivisionByZeroException;
import se_project.exceptions.EmptyStackException;
import se_project.exceptions.InterruptedExecutionException;
import se_project.exceptions.InvalidNumberException;
import se_project.exceptions.InvalidVariableNameException;
import se_project.exceptions.NonExistingVariable;
import se_project.exceptions.UndefinedPhaseException;
import se_project.exceptions.VariableExistingException;

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
    private ListView<?> listView;
    @FXML
    private Button addVarButton;
    @FXML
    private Button removeVarButton;
    @FXML
    private Button searchVarButton;

    /**
     * Initializes the controller class.
     */
    public void initialize(URL url, ResourceBundle rb) { 
        dictionary = VariablesDict.getInstance();
        solver = Solver.getInstance();
       observableList = FXCollections.observableArrayList();
        updateTable();

        variablesColumn.setCellValueFactory(new PropertyValueFactory("variable"));
        valuesColumn.setCellValueFactory(new PropertyValueFactory("value"));
        variablesColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        valuesColumn.setCellFactory(TextFieldTableCell.forTableColumn());
           variablesTableView.setItems(observableList);
        try {
            box= FXMLLoader.load(getClass().getResource("sidePane.fxml"));
        }catch(IOException ex){
        alert("unable to reach sidepane.fxml", "","");
        }
        for (Node n: box.getChildren()){
            if(n.getAccessibleText() !=null){
                n.addEventHandler(MouseEvent.MOUSE_CLICKED, e->{
                    
                    try {
                      switch(n.getAccessibleText()){ 
                          
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

    public void updateTable(){
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

        
    }
    
    public void setObservableList(ObservableList<VariableSet> list) {
        observableList = list;
        variablesTableView.setItems(list);
    }

    private void sumDiffResolveCommand(VariableCommand command){
        VariableSet selected = variablesTableView.getSelectionModel().getSelectedItem();
        if(selected!=null){
            String readVariable = selected.getVariable();
            command.setVariable(readVariable.charAt(0));
        }else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle( "Non riesco ad eseguire l'operazione");
            alert.setHeaderText("Variabile non valida");
            return;
        }
        try {
            solver.resolveOperation(command);
        } catch (InvalidNumberException ex) {
            Logger.getLogger(VariablesManagerController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (EmptyStackException ex) {
            Logger.getLogger(VariablesManagerController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UndefinedPhaseException ex) {
            Logger.getLogger(VariablesManagerController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DivisionByZeroException ex) {
            Logger.getLogger(VariablesManagerController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidVariableNameException ex) {
            Logger.getLogger(VariablesManagerController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (VariableExistingException ex) {
            Logger.getLogger(VariablesManagerController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedExecutionException ex) {
            Logger.getLogger(VariablesManagerController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(VariablesManagerController.class.getName()).log(Level.SEVERE, null, ex);
        }
        updateTable();
    }
    @FXML
    private void plusVarButtonActionPush(ActionEvent event) {
        SumVariableCommand command = new SumVariableCommand();
        sumDiffResolveCommand(command);
    }

    @FXML
    private void minusVarButtonActionPush(ActionEvent event) {
        DiffVariableCommand command = new DiffVariableCommand();
        sumDiffResolveCommand(command);
        
    }

    @FXML
    private void saveButtonActionPush(ActionEvent event) {
    }

    @FXML
    private void loadButtonActionPush(ActionEvent event) {
    }

    @FXML
    private void addVarButtonAction(ActionEvent event) {
    }

    @FXML
    private void removeVarButtonAction(ActionEvent event) {
    }

    @FXML
    private void searchVarButtonAction(ActionEvent event) {
    }

   
}
