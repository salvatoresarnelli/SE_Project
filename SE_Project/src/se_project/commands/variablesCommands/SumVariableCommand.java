/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package se_project.commands.variablesCommands;

import se_project.ComplexNumber;
import se_project.Stack;
import se_project.VariablesDict;
import se_project.commands.operationsCommands.PlusCommand;
import se_project.exceptions.VariableExistingException;

/**
 *
 * @author pionp
 */
public class SumVariableCommand extends VariableCommand{
    
    public SumVariableCommand(Character variable, VariableCommand command) {
    }
    
    public SumVariableCommand() {
    super();
    }

    
    

    @Override
    public ComplexNumber execute() throws Exception {
        VariablesDict dict = super.getDictionary();
        ComplexNumber c = dict.getVariableValue(super.getVariable());
        Stack stack = super.getTarget();
        ComplexNumber d = stack.peek();
        ComplexNumber c_1 = new ComplexNumber(c.getRealPart()+d.getRealPart(),c.getImaginaryPart()+d.getImaginaryPart());
        dict.forceSettingVariable(super.getVariable(), c_1);
        return c_1;
    }

    @Override
    public String toString() {
        return "+" + super.getVariable();
    }
    
    
}
