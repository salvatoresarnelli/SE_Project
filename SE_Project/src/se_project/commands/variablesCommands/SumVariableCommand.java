/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package se_project.commands.variablesCommands;

import se_project.ComplexNumber;
import se_project.Stack;
import se_project.VariablesDict;
import se_project.commands.operationsCommands.PlusCommand;
import se_project.exceptions.EmptyStackException;
import se_project.exceptions.InvalidVariableNameException;
import se_project.exceptions.NonExistingVariable;
import se_project.exceptions.VariableExistingException;

/**
 * Classe che rappresenta l'operazione di aggiornamento del valore di una variabile
 * sommandola all'ultimo elemento contenuto nello stack.
 * @author pionp
 * 
 */
public class SumVariableCommand extends VariableCommand {

    public SumVariableCommand(Character variable) {
    }

    public SumVariableCommand() {
        super();
    }

    /**
     * Prende il valore associato alla variabile dal dizionario, prende
     * l'elemento in cima allo stack e aggiorna il valore associato alla
     * variabile con il valore della variabile - il valore in cima allo stack.
     *
     * @return
     * @throws se_project.exceptions.InvalidVariableNameException
     * @throws se_project.exceptions.NonExistingVariable
     * @throws se_project.exceptions.EmptyStackException
     */
    @Override
    public ComplexNumber execute() throws InvalidVariableNameException, NonExistingVariable, EmptyStackException {
        VariablesDict dict = super.getDictionary();
        ComplexNumber c = dict.getVariableValue(super.getVariable());
        Stack stack = super.getTarget();
        ComplexNumber d = stack.peek();
        ComplexNumber c_1 = new ComplexNumber(c.getRealPart() + d.getRealPart(), c.getImaginaryPart() + d.getImaginaryPart());
        dict.forceSettingVariable(super.getVariable(), c_1);
        return c_1;
    }

    /**
     * La toString della classe ColonsCommand contiene solo il nome
     * dell'operazione.
     *
     * @return String
     */
    @Override
    public String toString() {
        return "+" + super.getVariable();
    }

}
