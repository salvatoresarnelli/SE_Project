/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se_project.parser;

import java.util.LinkedList;
import se_project.commands.Command;
import se_project.commands.OperationCommand;
import se_project.exceptions.OperationNotFoundException;

/**
 *
 * @author emanu
 */
public class OperationParser extends ParserString {

    ParserString parser;

    public OperationParser(ParserString parser) {
        this.parser = parser;
    }

    @Override
    public OperationCommand parse(String text) throws Exception {
        if (text.length() == 0) {
            return null;
        }
        OperationCommand returnValue = this.checkOperation(text);
        if (returnValue != null) {
            
                return returnValue;
           
        }
        if (parser != null) {
            return parser.parse(text);
        } else {
            return null;
        }
    }

    /**
     * Il metodo riconosce se nella stringa è presente un operazione tra:
     * "addiction", "substraction", "multiplication", "division", "square root",
     * "invert sign"
     *
     * @author emanu
     * @param text la stringa da dover controllare
     * @return IL metodo torna la costante operation se i confronti con almeno
     * una stringa citata prima ha successo, invalid_operation altrimenti.
     */
    public OperationCommand checkOperation(String text) {
        text = text.replaceAll("\\n", "");
        if (text.equals("+") || (text.equals("-")) || (text.equals("*")) || (text.equals(":"))
                || (text.equals("+-")) || (text.equals("sqrt")) || (text.equals("sin")) || text.equals("cos") || text.equals("tan"))
            try {
            return parser.getFactory().getOperationCommand(text, null);
        } catch (OperationNotFoundException ex) {

        }
        String possible_operation = text.toLowerCase();
        return null;
     
    }

  

}
