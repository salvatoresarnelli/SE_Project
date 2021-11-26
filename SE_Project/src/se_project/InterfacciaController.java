/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se_project;

import javafx.scene.control.ListView;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
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
    private Button buttonPush;
    @FXML
    private ListView<ComplexNumber> listView;
    private final Solver solver = Solver.getInstance();
    private final ParserString parser = new ParserString();
    private final String operation  = "__OPERATION__";
    private final String complex_number = "__COMPLEX__NUMBER__";
    private final String single_number = "__SINGLENUMBER__";
    
   

    public void initialize(URL url, ResourceBundle rb) {
        textArea.setOnKeyPressed((KeyEvent event) -> {
        if (event.getCode().equals(KeyCode.ENTER)) 
            buttonPush.fire();
        });
    }    

    @FXML
    private void ActionPush(ActionEvent event) throws NotApplicableOperation, InvalidNumberException, EmptyStackException, UndefinedPhaseException, DivisionByZeroException {
        String text = textArea.getText();
        String code = parser.parserString(text);
        ComplexNumber n;
        if(code.equals(complex_number)){
            n = parser.recognizeComplexNumber(text);
            solver.getStack().push(n);
        }
        if(code.equals(single_number)) {
            n = parser.recognizeNumber(text);
            solver.getStack().push(n);
        }
        if(code.equals(operation))
            solver.resolveOperation(textArea.getText());
           
     
        
        textArea.clear(); 
        
    }
    
}
