/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se_project.commands;

import se_project.ComplexNumber;
import se_project.Stack;

/**
 *
 * @author aless
 */
public abstract class OperationCommand implements Command {
    private Stack target;
    private ComplexNumber number;
    
    public OperationCommand() {
        
    }
    public OperationCommand(Stack stack) {
        this.target = stack;
    }

    public OperationCommand(Stack target, ComplexNumber number) {
        this.target = target;
        this.number = number;
    }

    public Stack getTarget() {
            return target;
    }

    public void setTarget(Stack target) {
        this.target = target;
    }
    
    
}
