/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se_project.commands.userDefinedOperations;

import java.util.HashMap;
import java.util.LinkedList;
import se_project.commands.OperationCommand;

/**
 * La classe InsertUserDefinedOperationCommand rapprensenta l'azione di
 * definizione di un'operazione definita dall'utente.
 *
 * @author aless
 */
public class InsertUserDefinedOperationCommand extends OperationCommand {

    private LinkedList<OperationCommand> commandList;
    private String name;
    private HashMap<String, OperationCommand> commandDict;

    public InsertUserDefinedOperationCommand(String name, LinkedList<OperationCommand> commandList,
            HashMap<String, OperationCommand> commandDict) {
        this.commandList = commandList;
        this.name = name;
        this.commandDict = commandDict;
    }

    public String getName() {
        return name;
    }

    public LinkedList<OperationCommand> getCommandList() {
        return commandList;
    }

    /**
     * Viene inserita una coppia nome opearazione e un comando
     * "ExecuteUserDefinedOperationCommand" che contiene l'insieme delle
     * operazioni da eseguire.
     * @return 
     * @throws java.lang.Exception
     */
    @Override
    public Object execute() throws Exception {
        return commandDict.put(name, new ExecuteUserDefinedOperationCommand(name, commandList));
    }

    /**
     * La toString della classe ColonsCommand contiene solo il nome
     * dell'operazione.
     */
    @Override
    public String toString() {
        return commandList.toString();
    }

}
