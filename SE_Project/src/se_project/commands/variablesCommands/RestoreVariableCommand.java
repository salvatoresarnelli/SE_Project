/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se_project.commands.variablesCommands;

import java.util.HashMap;
import se_project.ComplexNumber;
import se_project.Record;
import se_project.VariablesDict;
import se_project.VariablesStack;

/**
 * Tale classe rappresenta il comando che consente di salvare nella cronologia
 * delle variabili lo stato corrente del dizionario.
 *
 * @author aless
 */
public class RestoreVariableCommand extends VariableCommand {

    private VariablesStack variablesStack;
    private VariablesDict dictionary;

    public void setVariablesStack(VariablesStack stack) {
        this.variablesStack = stack;
    }

    public RestoreVariableCommand() {
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
         Record r;
        ComplexNumber c;
            r = variablesStack.popVariableSnapShot();
            VariablesDict.getInstance().getTable().clear();
            for (Character ch : r.getDictRecord().keySet()) {
                c = r.getDictRecord().get(ch);
                if (c != null) {
                    VariablesDict.getInstance().getTable().put(ch, c);

                }
            }
        
        return true;
    }

    public String toString(){
        return "restore";
    }
}
