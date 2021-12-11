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
 * Tale classe rappresenta il comando di "push variable", ovvero la capacità di prendere 
 * una variabile dalla memoria e di inserirne il valore nello stack.
 * 
 * @author aless
 */
public class PushVariableCommand extends VariableCommand{
    public PushVariableCommand(Character variable, VariableCommand command) {
    }
    public PushVariableCommand() {
    super();
    }
/**
 * Tale metodo prende il valore della variabile variable dal dizionario delle 
 * variabili e aggiunge allo stack.
 * 
     * @throws se_project.exceptions.InvalidVariableNameException
 */

    @Override
    public ComplexNumber execute() throws InvalidVariableNameException, NonExistingVariable  {
        VariablesDict dict = super.getDictionary();
        ComplexNumber c = dict.getVariableValue(super.getVariable());
        Stack stack = super.getTarget();
        stack.push(c);
        return c;
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
