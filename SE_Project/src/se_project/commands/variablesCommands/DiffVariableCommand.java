/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package se_project.commands.variablesCommands;

import se_project.ComplexNumber;
import se_project.Stack;
import se_project.VariablesDict;
import se_project.exceptions.EmptyStackException;
import se_project.exceptions.InvalidVariableNameException;
import se_project.exceptions.NonExistingVariable;

/**
 *
 * @author pionp
 */
public class DiffVariableCommand extends VariableCommand{
    
    
    public DiffVariableCommand(Character variable) {
    }
    
    public DiffVariableCommand() {
    super();
    }

    @Override
    public ComplexNumber execute() throws InvalidVariableNameException, NonExistingVariable, EmptyStackException  {
        VariablesDict dict = super.getDictionary();
        ComplexNumber c = dict.getVariableValue(super.getVariable());
        Stack stack = super.getTarget();
        ComplexNumber d = stack.peek();
        ComplexNumber c_1 = new ComplexNumber(c.getRealPart()-d.getRealPart(),c.getImaginaryPart()-d.getImaginaryPart());
        dict.forceSettingVariable(super.getVariable(), c_1);
        return c_1;
    }

    @Override
    public String toString() {
        return "-" + super.getVariable();
    }
    
}
