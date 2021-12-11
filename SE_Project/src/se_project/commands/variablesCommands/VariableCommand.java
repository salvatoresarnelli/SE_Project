/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se_project.commands.variablesCommands;

import se_project.Stack;
import se_project.VariablesDict;
import se_project.commands.OperationCommand;

/**
 * Classe astratta che rappresenta un'operazione generica su una variabile.
 * Vengono definiti due attributi, uno è il carattere su cui eseguire
 * l'operazione, l'altro è un riferimento al dizionario delle variabili.
 *
 * @author aless
 */
public abstract class VariableCommand extends OperationCommand {

    private VariablesDict dictionary;
    private Character variable;

    /**
     * restituisce la variabile su cui eseguire l'operazione.
     *
     * @return
     */
    public Character getVariable() {
        return variable;
    }

    /**
     * setta la variabile su cui eseguire l'operazione al parametro passato.
     *
     * @param variable
     */
    public void setVariable(Character variable) {
        this.variable = variable;
    }

    /**
     * setta il dizionario su cui eseguire l'operazione al parametro passato.
     *
     * @param dictionary
     */
    public void setDictionary(VariablesDict dictionary) {
        this.dictionary = dictionary;
    }

    public VariableCommand(Stack stack, VariablesDict dictionary) {
        super(stack);
        this.dictionary = dictionary;
    }

    public VariableCommand() {
        super();
        dictionary = VariablesDict.getInstance();
    }
    /**
     * restituisce il dizionario su cui eseguire l'operazione.
     *
     * @return VariablesDict
     */
    public VariablesDict getDictionary() {
        return dictionary;
    }

    /**
     * La toString della classe ColonsCommand contiene solo il nome
     * dell'operazione.
     */
    @Override
    public String toString() {
        return "VariableCommand{" + "dictionary=" + dictionary + '}';
    }

}
