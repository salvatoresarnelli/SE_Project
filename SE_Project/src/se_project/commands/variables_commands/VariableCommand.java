/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se_project.commands.variables_commands;

import se_project.ComplexNumber;
import se_project.Stack;
import se_project.commands.Command;
import se_project.VariablesDict;
import se_project.commands.OperationCommand;

/**
 *
 * @author aless
 */
public abstract class VariableCommand extends OperationCommand{
    private VariablesDict dictionary;

    public void setDictionary(VariablesDict dictionary) {
        this.dictionary = dictionary;
    }
    
    public VariableCommand(Stack stack,VariablesDict dictionary) {
        super(stack);
        this.dictionary = dictionary;
    }
    
public VariableCommand() {
    super();
    dictionary = new VariablesDict();
    }

    public VariablesDict getDictionary() {
        return dictionary;
    }
}
