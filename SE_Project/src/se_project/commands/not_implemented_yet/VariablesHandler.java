/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se_project.commands.not_implemented_yet;

import java.util.logging.Level;
import java.util.logging.Logger;
import se_project.Solver;
import se_project.Stack;
import se_project.commands.Command;
import se_project.exceptions.EmptyStackException;
import se_project.exceptions.InvalidVariableNameException;
import se_project.exceptions.NonExistingVariable;
import se_project.exceptions.VariableExistingException;
import se_project.VariablesDict;

/**
 *
 * @author aless
 */
public class VariablesHandler {
    private Stack stack;
    private VariablesDict dictionary;
    private static VariablesHandler instance = null;

    private VariablesHandler(Stack stack) {
        this.stack = stack;
        
    }
/*
    public static VariablesHandler getInstance(Stack stack) {
        // Crea l'oggetto solo se NON esiste:
        if (instance == null) {
            instance = new VariablesHandler(stack);
        }
        return instance;
    }
    
    public PushVariableCommand pushVariable(char variable) throws InvalidVariableNameException, 
            NonExistingVariable{
        PushVariableCommand p = new PushVariableCommand(variable, stack, dictionary);
        p.execute();
        return p;
    }
    
    public NewVariableCommand newVariable(char variable)throws EmptyStackException, 
            InvalidVariableNameException {
           
       NewVariableCommand n =new NewVariableCommand(variable,stack, dictionary);
        try {
            n.execute();
        } catch (VariableExistingException ex) {
            return n;
        }
       return null  ;
        
    }
    
    public OverrideVariableCommand overrideVariable(NewVariableCommand n)throws EmptyStackException, 
            InvalidVariableNameException { 
        OverrideVariableCommand o = new OverrideVariableCommand(n);
        o.execute();
        return o;
    }
*/
}
