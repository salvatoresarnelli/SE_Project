/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se_project.parser;

import se_project.commands.OperationCommand;
import se_project.commands.stackCommands.ClearCommand;
import se_project.commands.stackCommands.DropCommand;
import se_project.commands.stackCommands.DuplicateCommand;
import se_project.commands.stackCommands.OverCommand;
import se_project.commands.stackCommands.SwapCommand;

/**
 *
 * @author aless
 */
public class StackOperationParser extends ParserString{
    private ParserString parser;
    
    public StackOperationParser(ParserString parser) {
        this.parser = parser;
    }

    @Override
    public OperationCommand parse(String text) throws NullPointerException, Exception {
         if (text.length() == 0) {
            return null;
        }
        OperationCommand returnValue = checkOperationStack(text);
        if (returnValue != null) {
            return returnValue;
        }
        if(parser!=null)
            return parser.parse(text);
        else return null;
    }    
    
    public OperationCommand checkOperationStack(String text) {
        text = text.replaceAll("\\n", "");
        String possible_operation = text.toLowerCase();
        if(possible_operation.equals("clear"))
            return new ClearCommand(null);
        if(possible_operation.equals("dup")) 
            return new DuplicateCommand(null);
        if(possible_operation.equals("drop"))
            return new DropCommand(null);
        if( possible_operation.equals("over"))
            return new OverCommand(null);
        if(possible_operation.equals("swap"))
            return new SwapCommand(null);
        return null;
    }
    

    
}
