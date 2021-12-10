/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se_project.commands.variablesCommands;

import se_project.VariablesDict;
import se_project.VariablesStack;

/**
 *
 * @author aless
 */
public class SaveVariableCommand extends VariableCommand{
    private VariablesStack stack;
    private VariablesDict dictionary;

    public void setStack(VariablesStack stack) {
        this.stack = stack;
    }

    public SaveVariableCommand() {
    }

    public void setDictionary(VariablesDict dictionary) {
        this.dictionary = dictionary;
    }
    
    @Override
    public Object execute() throws Exception {
        stack.pushVariablesSnapShot(dictionary);
        return true;
    }
    
}
