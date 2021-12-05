/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package se_project.commands.variablesCommands;

import se_project.ComplexNumber;
import se_project.Stack;
import se_project.VariablesDict;

/**
 *
 * @author pionp
 */
public class DiffVariableCommand extends VariableCommand{
    
    private Character variable;
    
    public DiffVariableCommand(Character variable, VariableCommand command) {
    }
    
    public DiffVariableCommand() {
    super();
    }

    public void setVariable(Character variable) {
        this.variable = variable;
    }

    @Override
    public ComplexNumber execute() throws Exception {
        VariablesDict dict = super.getDictionary();
        ComplexNumber c = dict.getVariableValue(variable);
        Stack stack = super.getTarget();
        ComplexNumber d = stack.peek();
        ComplexNumber c_1 = new ComplexNumber(c.getRealPart()-d.getRealPart(),c.getImaginaryPart()-d.getImaginaryPart());
        dict.forceSettingVariable(variable, c_1);
        return c_1;
    }
}
