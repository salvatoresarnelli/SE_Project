/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se_project.commands.not_implemented_yet;

import se_project.ComplexNumber;
import se_project.Stack;
import se_project.commands.Command;
import se_project.VariablesDict;

/**
 *
 * @author aless
 */
public abstract class VariableCommand implements Command{
    private final Stack stack;
    private final VariablesDict dictionary;
    
    public VariableCommand(Stack stack,VariablesDict dictionary) {
        this.stack = stack;
        this.dictionary = dictionary;
    }
    

   

    public Stack getStack() {
        return stack;
    }

    public VariablesDict getDictionary() {
        return dictionary;
    }
}
