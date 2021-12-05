/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se_project.commands.variables_commands;

import se_project.ComplexNumber;
import se_project.Stack;
import se_project.commands.Command;
import se_project.exceptions.EmptyStackException;
import se_project.exceptions.InvalidVariableNameException;
import se_project.exceptions.VariableExistingException;
import se_project.VariablesDict;
import se_project.commands.variables_commands.NewVariableCommand;

/**
 *
 * @author aless
 */
public class OverrideVariableCommand extends NewVariableCommand {

    public OverrideVariableCommand(NewVariableCommand command) {
        super(command.getVariable(), command.getTarget(), command.getDictionary());
    }

    @Override
    public ComplexNumber execute() throws EmptyStackException, InvalidVariableNameException {
        ComplexNumber c;
        c = super.getTarget().pop();
        super.getDictionary().forceSettingVariable(super.getVariable(), c);
        super.getTarget().push(c);
        return c;
    }

}
