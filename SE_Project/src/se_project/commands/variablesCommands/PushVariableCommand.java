/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se_project.commands.variablesCommands;

import se_project.ComplexNumber;
import se_project.Stack;
import se_project.VariablesDict;

/**
 *
 * @author aless
 */
public class PushVariableCommand extends VariableCommand{
    public PushVariableCommand(Character variable, VariableCommand command) {
    }
    public PushVariableCommand() {
    super();
    }


    @Override
    public ComplexNumber execute() throws Exception {
        VariablesDict dict = super.getDictionary();
        ComplexNumber c = dict.getVariableValue(super.getVariable());
        Stack stack = super.getTarget();
        stack.push(c);
        return c;
    }
    @Override
    public String toString(){
        return ">" + super.getVariable();
    }
    
}
