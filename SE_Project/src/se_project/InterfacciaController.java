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
   

  public void initialize(URL url, ResourceBundle rb) {
        textArea.setOnKeyPressed((KeyEvent event) -> {
        if (event.getCode().equals(KeyCode.ENTER)) 
            buttonPush.fire();
    }
    );
    }    

    @FXML
    private void ActionPush(ActionEvent event) {
        System.out.println(textArea.getText());
        String code = parser.parserString(textArea.getText());
        System.out.println(code);
        textArea.clear(); 
        //System.out.println("sono l'azione del button");
        
    }
    
}
