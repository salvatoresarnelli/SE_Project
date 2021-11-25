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
    private final ParserString parser = new ParserString();
    private final String operation  = "__OPERATION__";
    private final String complex_number = "__COMPLEX__NUMBER__";
    private final String single_number = "__SINGLENUMBER__";
    
   

  public void initialize(URL url, ResourceBundle rb) {
        textArea.setOnKeyPressed((KeyEvent event) -> {
        if (event.getCode().equals(KeyCode.ENTER)) 
            buttonPush.fire();
    }
    );
    }    

    @FXML
    private void ActionPush(ActionEvent event) {
        String text = textArea.getText();
        String code = parser.parserString(text);
        ComplexNumber n = new ComplexNumber(0,0);
        if(code.equals(complex_number))
            n = parser.recognizeComplexNumber(text);
        if(code.equals(single_number))
            n = parser.recognizeNumber(text);
        System.out.println(code);
        
        /*
        if(code.equals(operation)){
            switch(text){
                case "addition":
                    
                    break;
                case "substraction":
                    
                    break;
                case "multiplication":
                    break;
                case "division":
                    break;
                case "square root":
                    break;
                case "invert sign":
                    break;
                     
            }
        }
        */
        
        textArea.clear(); 
        
    }
    
}
