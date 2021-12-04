/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se_project.commands;

import java.util.HashMap;
import java.util.LinkedList;
import se_project.ComplexNumber;
import se_project.Stack;

/**
 *
 * @author aless
 */
public class ExecuteUserDefinedOperationCommand extends OperationCommand {

    private LinkedList<OperationCommand> commandList;
    private String name;

    public String getName() {
        return name;
    }

    public ExecuteUserDefinedOperationCommand() {
        super();
    }

    public ExecuteUserDefinedOperationCommand(String name, LinkedList<OperationCommand> commandList) {
        super();
        this.name = name;
        this.commandList = commandList;
    }

    public ExecuteUserDefinedOperationCommand(String name, LinkedList<OperationCommand> commandList, Stack stack) {
        super(stack);
        this.name = name;
        this.commandList = commandList;
    }
    
    
    @Override
    public Object execute() throws Exception {
        LinkedList<ComplexNumber> rollBackList = new LinkedList<>();
        Stack stack = super.getTarget();
       
        /*if(getWeight()>stack.size())
            return false;
        */
        for (OperationCommand i : commandList) {
            i.setTarget(stack);
            i.execute();
        }
        return true;
    }

    public LinkedList<OperationCommand> getCommandList() {
        return commandList;
    }

    @Override
    public String toString() {
        return commandList.toString().replaceAll("[", "").replaceAll("]", "").replaceAll(",", "");
    }

}
