/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se_project.commands.stackCommands;

import se_project.Stack;
import se_project.commands.Command;
import se_project.commands.OperationCommand;
import se_project.exceptions.EmptyStackException;

/**
 *
 * @author aless
 */
public class DropCommand extends OperationCommand{
    private String name = "drop";

    
    public DropCommand(Stack stack) {
       super(stack);
    }

    public DropCommand() {
    }
    @Override
    public Boolean execute() throws EmptyStackException {
        return super.getTarget().drop();
    }

    public String toString() {
        return name;
    }
    
}

