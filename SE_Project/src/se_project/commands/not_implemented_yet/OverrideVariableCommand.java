/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se_project.commands.not_implemented_yet;

import se_project.ComplexNumber;
import se_project.Stack;
import se_project.commands.Command;
import se_project.exceptions.EmptyStackException;
import se_project.exceptions.InvalidVariableNameException;
import se_project.exceptions.VariableExistingException;
import se_project.VariablesDict;
import se_project.commands.not_implemented_yet.NewVariableCommand;

/**
 *
 * @author aless
 */
public class OverrideVariableCommand extends NewVariableCommand {
/*

    public OverrideVariableCommand(NewVariableCommand command) {
        super(command.getVariable(), command.getStack(), command.getDictionary());
    }

    @Override
    public ComplexNumber execute() throws EmptyStackException, InvalidVariableNameException {
        ComplexNumber c;
        c = super.getStack().pop();
        super.getDictionary().forceSettingVariable(super.getVariable(), c);
        super.getStack().push(c);
        return c;
    }
*/
}
