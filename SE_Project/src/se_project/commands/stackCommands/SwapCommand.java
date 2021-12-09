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
import se_project.exceptions.InvalidOperationException;

/**
 *
 * @author aless
 */
public class SwapCommand extends OperationCommand{
    private String name = "swap";

    public SwapCommand(Stack stack) {
        super(stack);
    }

    public SwapCommand() {
    }
    
    @Override
    public Boolean execute() throws EmptyStackException, InvalidOperationException {
        return super.getTarget().swap();
    }

    public String toString() {
        return name;
    }
        
    
}
