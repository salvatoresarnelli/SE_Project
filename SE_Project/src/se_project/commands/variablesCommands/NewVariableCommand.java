/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se_project.commands.variablesCommands;

import se_project.ComplexNumber;
import se_project.Stack;
import se_project.VariablesDict;
import se_project.exceptions.EmptyStackException;
import se_project.exceptions.InvalidValueException;
import se_project.exceptions.InvalidVariableNameException;
import se_project.exceptions.VariableExistingException;

/**
 *
 * @author aless
 */
public class NewVariableCommand extends VariableCommand {


    public NewVariableCommand() {
    }

    public NewVariableCommand(Character variable) {
        super();
        super.setVariable(variable);}

    public NewVariableCommand(Character variable, Stack stack, VariablesDict dict) {
        super(stack, dict);

        super.setVariable(variable);
    }

   
    @Override
    public ComplexNumber execute() throws EmptyStackException, InvalidVariableNameException, VariableExistingException, InvalidValueException {
        Stack stack = super.getTarget();
        ComplexNumber complex = stack.pop();
        super.getDictionary().forceSettingVariable(super.getVariable(), complex);
        stack.push(complex);

        return complex;
    }
     /**
     * La toString della classe ColonsCommand contiene solo il nome
     * dell'operazione.
     */
    @Override
    public String toString(){
        return ">" + super.getVariable();
    }
   
}
