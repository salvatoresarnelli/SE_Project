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
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
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
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import other.OperationSet;

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
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        nameColumn.setCellValueFactory(new PropertyValueFactory("nameOperation"));
        operationColumn.setCellValueFactory(new PropertyValueFactory("listOperation"));
        nameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        operationColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        observableList = FXCollections.observableArrayList();
           
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
                            pane.getChildren().setAll(homePage);                    
                            break;
                        case "Salva Funzione":
                          Node variablesManager = FXMLLoader.load(getClass().getResource("VariablesManager.fxml"));
                            pane.getChildren().setAll(variablesManager);                    
                            break;
                        
                        case "Carica Funzione":
                            Node update = FXMLLoader.load(getClass().getResource("OperationsManager.fxml"));
                            pane.getChildren().setAll(update);
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

    public void setObservableListOperations(ObservableList<OperationSet> ob) {
        observableList = ob;
        tableViewOperations.setItems(ob);
    }


    


}
