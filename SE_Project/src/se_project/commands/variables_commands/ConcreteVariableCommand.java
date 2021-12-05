/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se_project.commands.variables_commands;

import se_project.Stack;
import se_project.VariablesDict;

/**
 *
 * @author aless
 */
public class ConcreteVariableCommand extends VariableCommand {

    public ConcreteVariableCommand(Stack stack, VariablesDict dictionary) {
        super(stack, dictionary);
    }

    
    @Override
    public Object execute() throws Exception {
        return null;
    }
    
}
