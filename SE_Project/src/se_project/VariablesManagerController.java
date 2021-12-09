/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package se_project;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URL;
import java.util.Map;
import java.util.Observable;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
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
import javafx.util.Callback;
import other.VariableSet;

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


    /**
     * Initializes the controller class.
     */
    public void initialize(URL url, ResourceBundle rb) {   
        variablesColumn.setCellValueFactory(new PropertyValueFactory("variable"));
        valuesColumn.setCellValueFactory(new PropertyValueFactory("value"));
        variablesColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        valuesColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        observableList = FXCollections.observableArrayList();
    }   
    
    public void setObservableList(ObservableList<VariableSet> list) {
        observableList = list;
        variablesTableView.setItems(list);
    }

   
}
