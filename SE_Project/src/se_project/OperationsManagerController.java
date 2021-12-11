/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se_project;

import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerBasicCloseTransition;
import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;
import javafx.application.Platform;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import other.OperationSet;
import se_project.commands.OperationCommand;
import se_project.commands.userDefinedOperations.ExecuteUserDefinedOperationCommand;
import se_project.commands.variablesCommands.VariableCommand;

/**
 *
 * @author emanu
 */
public class OperationsManagerController implements Initializable {

    @FXML
    private TableView<OperationSet> tableViewOperations;
    @FXML
    private TableColumn<OperationSet, String> nameColumn;
    @FXML
    private TableColumn<OperationSet, String> operationColumn;
    private ObservableList<OperationSet> observableList;
    @FXML
    private AnchorPane pane;
    @FXML
    private JFXHamburger hamburger;
    @FXML
    private JFXDrawer drawer;
    private VBox box;
    @FXML
    private Button buttonRemove;
    private OperationDict operationDict;
    
    private InterfacciaController interfacciaController;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        nameColumn.setCellValueFactory(new PropertyValueFactory("nameOperation"));
        operationColumn.setCellValueFactory(new PropertyValueFactory("listOperation"));
        nameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        operationColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        observableList = FXCollections.observableArrayList();
        operationDict = OperationDict.getInstance();

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
                                pane.getChildren().setAll(homePage);
                                break;
                            case "Salva Funzione":
                                interfacciaController = this.loadController();
                                interfacciaController.saveFunctions();
                                break;

                            case "Carica Funzione":
                                interfacciaController = this.loadController();
                                interfacciaController.uploadFunctions();
                                break;

                            case "Gestione Operazioni":
                                Node opManager = FXMLLoader.load(getClass().getResource("OperationsManager.fxml"));
                                pane.getChildren().setAll(opManager);
                                break;

                            case "Gestione Variabili":
                                Node varManager = FXMLLoader.load(getClass().getResource("VariablesManager.fxml"));
                                pane.getChildren().setAll(varManager);
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
        this.setObservableList();
        tableViewOperations.setItems(observableList);
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

    private void setObservableList() {
        if (operationDict.getNames().isEmpty()) {
            return;
        }
        observableList.clear();
        String s = "";
        for (String name : operationDict.getNames()) {
            OperationSet operationSet;
            LinkedList<OperationCommand> supportList = operationDict.getOperations(name).getCommandList();
            for (OperationCommand command : supportList) {
                if (command instanceof ExecuteUserDefinedOperationCommand) {
                    s += " " + ((ExecuteUserDefinedOperationCommand) command).getName();
                } else if (command instanceof VariableCommand) {
                    s += " " + ((VariableCommand) command).toString();
                } else {
                    s += " " + command.toString();
                }
            }
            s += "\n";

            operationSet = new OperationSet(name, s);

            observableList.add(operationSet);
            s = "";
        }

    }

  
    @FXML
    private void actionButtonRemove(ActionEvent event) {
        OperationSet selectedItem = tableViewOperations.getSelectionModel().getSelectedItem();
        for(String name : operationDict.getNames()){
            if(operationDict.getOperationString(name).contains(selectedItem.getNameOperation())){
                this.alert("Errore!", "Impossibile eliminare l'operazione", "L'operazione "+ selectedItem.getNameOperation() +  "è presente anche in " + name);
                return;
                
            }
            
        }
        operationDict.removeOperation(selectedItem.getNameOperation());
        this.setObservableList();
       
    }
    
    public InterfacciaController loadController() throws IOException {
            Parent root;
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("calculator.fxml"));
            root = fxmlLoader.load();
            InterfacciaController interfacciaController = fxmlLoader.getController();
            return interfacciaController;
    }
}
