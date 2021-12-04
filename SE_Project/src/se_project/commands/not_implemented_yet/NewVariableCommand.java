/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se_project.commands.not_implemented_yet;

import se_project.ComplexNumber;
import se_project.Stack;
import se_project.VariablesDict;
import se_project.exceptions.EmptyStackException;
import se_project.exceptions.InvalidVariableNameException;
import se_project.exceptions.VariableExistingException;

/**
 *
 * @author aless
 */
public class NewVariableCommand extends VariableCommand {

    private Character variable;

    public NewVariableCommand() {
    }

    public NewVariableCommand(Character variable) {
        this.variable = variable;
    }

    public NewVariableCommand(Character variable, Stack stack, VariablesDict dict) {
        super(stack, dict);

        this.variable = variable;
    }

    public void setDictionary(VariablesDict dict) {
        super.setDictionary(dict);
    }

    public void setVariable(Character variable) {
        this.variable = variable;
    }

    public VariablesDict getDictionary() {
        return super.getDictionary();
    }

    public Stack getTarget() {
        return super.getTarget();
    }

    public Character getVariable() {
        return variable;
    }

    public ComplexNumber execute() throws EmptyStackException, InvalidVariableNameException, VariableExistingException {
        Stack stack = super.getTarget();
        ComplexNumber complex = stack.pop();
        try {
            super.getDictionary().setVariable(variable, complex);
        } catch (VariableExistingException ex) {
            stack.push(complex);

            throw new VariableExistingException();
        }
        stack.push(complex);

        return complex;
    }


    /*
    NewVariableCommand(Character variable, VariableCommand command) {
        
    }
     */
}
