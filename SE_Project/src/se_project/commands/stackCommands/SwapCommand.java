/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se_project.commands.stackCommands;

import se_project.Stack;
import se_project.commands.Command;
import se_project.exceptions.EmptyStackException;
import se_project.exceptions.InvalidOperationException;

/**
 *
 * @author aless
 */
public class SwapCommand implements Command{

    public SwapCommand(Stack stack) {
        this.stack = stack;
    }
    private Stack stack;
    
    @Override
    public Boolean execute() throws EmptyStackException, InvalidOperationException {
        return stack.swap();
    }
        
    
}
