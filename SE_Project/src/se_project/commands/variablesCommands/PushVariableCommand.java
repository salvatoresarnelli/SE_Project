/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se_project.commands.variablesCommands;

import se_project.ComplexNumber;
import se_project.Stack;
import se_project.VariablesDict;
import se_project.exceptions.InvalidVariableNameException;
import se_project.exceptions.NonExistingVariable;

/**
 *
 * @author aless
 */
public class PushVariableCommand extends VariableCommand{
    private Character variable;
    public PushVariableCommand(Character variable, VariableCommand command) {
    }
    public PushVariableCommand() {
    super();
    }

    public void setVariable(Character variable) {
        this.variable = variable;
    }

    @Override
    public ComplexNumber execute() throws InvalidVariableNameException, NonExistingVariable  {
        VariablesDict dict = super.getDictionary();
        ComplexNumber c = dict.getVariableValue(variable);
        Stack stack = super.getTarget();
        stack.push(c);
        return c;
    }
    @Override
    public String toString(){
        return ">" + variable;
    }
    
}
