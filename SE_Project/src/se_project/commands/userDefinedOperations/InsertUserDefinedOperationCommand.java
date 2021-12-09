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

    @Override
    public Object execute() throws Exception {
        return commandDict.put(name, new ExecuteUserDefinedOperationCommand(name, commandList));
    }

    @Override
    public String toString() {
        return commandList.toString();
    }

}
