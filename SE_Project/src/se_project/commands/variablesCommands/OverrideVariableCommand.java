/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se_project.commands.variablesCommands;

import se_project.ComplexNumber;
import se_project.exceptions.EmptyStackException;
import se_project.exceptions.InvalidVariableNameException;
import se_project.commands.variablesCommands.NewVariableCommand;

/**
 * Tale classe consente di rappresentare il comando di sovrascrittura e/o
 * forzatura della scrittura del valore di una variabile.
 *
 * @author aless
 */
public class OverrideVariableCommand extends NewVariableCommand {

    public OverrideVariableCommand(NewVariableCommand command) {
        super(command.getVariable(), command.getTarget(), command.getDictionary());
    }

    /**
     * Il metodo execute prende lo stack e associa il valore della variabile al
     * valore passatogli, independentemente se esso abbia già un valore o meno.
     *
     */
    @Override
    public ComplexNumber execute() throws EmptyStackException, InvalidVariableNameException {
        ComplexNumber c;
        c = super.getTarget().pop();
        try {
            super.getDictionary().forceSettingVariable(super.getVariable(), c);
        } finally {
            super.getTarget().push(c);
        }
        return c;
    }

}
