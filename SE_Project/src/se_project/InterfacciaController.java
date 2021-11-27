/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se_project;

import javafx.scene.control.ListView;
import java.net.URL;
import java.util.Collection;
import java.util.Observable;
import java.util.ResourceBundle;
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
import javafx.scene.control.TextArea;
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
    @FXML
    private TextArea textArea;
    @FXML 
    private TextField inputField;
    @FXML
    private Button buttonPush;
    @FXML
    private ListView<ComplexNumber> listView;
    private final Solver solver = Solver.getInstance();
    private final ParserString parser = new ParserString();
    private final String operation  = "__OPERATION__";
    private final String complex_number = "__COMPLEX__NUMBER__";
    private final String single_number = "__SINGLENUMBER__";
    private final String invalid_insert = "__INVALID__";
    private ObservableList<ComplexNumber> observableList;
    protected ListProperty<ComplexNumber> listProperty = new SimpleListProperty<>();

    public void initialize(URL url, ResourceBundle rb) {
        observableList = FXCollections.observableList(solver.getStructureStack().getStack());

        inputField.setOnKeyPressed((KeyEvent event) -> {
        if (event.getCode().equals(KeyCode.ENTER)) 
                buttonPush.fire();
        });
        listProperty.set(observableList);
    }

    @FXML
    private void ActionPush(ActionEvent event) throws NotApplicableOperation, InvalidNumberException, EmptyStackException, UndefinedPhaseException, DivisionByZeroException {
        String text = inputField.getText();
            String code = parser.parserString(text);
        ComplexNumber n;
        if (code.equals(complex_number)) {
            n = parser.recognizeComplexNumber(text);
            observableList.add(n);
        }
        if (code.equals(single_number)) {
            n = parser.recognizeNumber(text);

            observableList.add(n);
        }
        if (code.equals(operation)) {
            n = solver.resolveOperation(text);
            observableList.add(n);
        }
         if(code.equals(invalid_insert)){
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Inserimento non valido");
                alert.setHeaderText("L'elemento inserito non è corretto , riprovare");
                alert.setContentText(text + " --> L'inserimento non è valido");
                alert.showAndWait().ifPresent(rs -> {
                    if (rs == ButtonType.OK);


        });
         }

        listView.itemsProperty().bind(listProperty);
        inputField.clear();
        

        
    }
     

}
