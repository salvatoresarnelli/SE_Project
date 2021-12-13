/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se_project.commands.variablesCommands;

import se_project.VariablesDict;
import se_project.VariablesStack;

import se_project.commands.variablesCommands.VariableCommand;

/**
 * Tale classe rappresenta il comando che consente di salvare nella cronologia
 * delle variabili lo stato corrente del dizionario.
 *
 * @author aless
 */
public class SaveVariableCommand extends VariableCommand {

    private VariablesStack variablesStack;
    private VariablesDict dictionary;

    public void setVariablesStack(VariablesStack stack) {
        this.variablesStack = stack;
    }

    public SaveVariableCommand() {
    }

    @Override
    public void setDictionary(VariablesDict dictionary) {
        this.dictionary = dictionary;
    }

    /**
     * Il metodo execute richiama il metodo pushVariableSnapShot dello stack
     * delle variabili.In cui viene creata una copia delle coppie
     * variabile-valore e memorizzata in un record.
     *
     * @throws java.lang.Exception
     */
    @Override
    public Object execute() throws Exception {
        variablesStack.pushVariablesSnapShot(dictionary);
        return true;
    }
    
    @Override 
    public String toString(){
    return "save";
    }
}
