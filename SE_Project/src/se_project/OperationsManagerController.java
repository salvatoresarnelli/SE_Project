/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se_project;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
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

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        nameColumn.setCellValueFactory(new PropertyValueFactory("nameOperation"));
        operationColumn.setCellValueFactory(new PropertyValueFactory("listOperation"));
        nameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        operationColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        observableList = FXCollections.observableArrayList();
    }

    public void setObservableListOperations(ObservableList<OperationSet> ob) {
        observableList = ob;
        tableViewOperations.setItems(ob);
    }

    private void actionButtonRemoveOperation(ActionEvent event) {
        FXMLLoader fxmlLoader;
        Parent root;
        try {
            fxmlLoader = new FXMLLoader(getClass().getResource("calculator.fxml"));
            root = fxmlLoader.load();
            InterfacciaController interfacciaController = fxmlLoader.getController();
            ObservableList<OperationSet> selectedItems = tableViewOperations.getSelectionModel().getSelectedItems();
            for (OperationSet operationSet : selectedItems) {
                //interfacciaController.removeOperationByUser(operationSet.getNameOperation());
                interfacciaController.setObservableOperations(operationSet);
                observableList.remove(operationSet);
                
                
            }
        } catch (IOException ex) {
            Logger.getLogger(OperationsManagerController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    


}
