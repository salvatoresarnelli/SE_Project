/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se_project;

import se_project.commands.Command;
import se_project.commands.not_implemented_yet.CommandFactory;
import se_project.commands.not_implemented_yet.VariableCommand;

/**
 *
 * @author aless
 */
public class DecoratorVariableParser extends ParserString {
    private ParserString obj;
/*
    public DecoratorVariableParser(ParserString obj) {
        this.obj = obj;
    }
    
    public Command variableRecognizer(String textString) throws ArrayIndexOutOfBoundsException {
        if(checkVariableIns(textString))
            return CommandFactory.createVariablesCommand("NewVariableCommand",textString.charAt(1));
        if(checkVariablePushed(textString))
            return CommandFactory.createVariablesCommand("PushVariableCommand",textString.charAt(1));
        
        return null;
    }    
    private boolean checkVariableIns(String txtString){
        return txtString.charAt(0)=='>' && txtString.length()==2;        
    }
    
    private boolean checkVariablePushed(String txtString){
        return txtString.charAt(0)=='<' && txtString.length()==2;        
    }
    */
}
