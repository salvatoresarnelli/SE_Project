/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se_project;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author aless
 */
public class SidePaneController implements Initializable {

    @FXML
    private VBox vbox;
    @FXML
    private Button saveButton;
    @FXML
    private Button uploadButton;
    @FXML
    private Button OperationsHandler;
    @FXML
    private Button variablesHandler;
    @FXML
    private Button homeButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void saveFunctions(ActionEvent event) {
    }

    @FXML
    private void uploadFunctions(ActionEvent event) {
    }

    @FXML
    private void operationHandlerAction(ActionEvent event) {
    }

    @FXML
    private void variablesHandlerAction(ActionEvent event) {
    }

    @FXML
    private void homeButtonAction(ActionEvent event) {
    }
    
}
