/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se_project;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

/**
 *
 * @author emanu
 */
public class OperationsManagerController implements Initializable{

    @FXML
    private ListView<String> listViewOperations;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }
    
    public void setObservableListOperations(ObservableList<String> ob){
        listViewOperations.setItems(ob);
    }

    
}
