/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se_project.commands;

import se_project.ComplexNumber;
import se_project.Operations;
import se_project.Stack;
import se_project.exceptions.EmptyStackException;
import se_project.exceptions.InvalidNumberException;
import se_project.exceptions.NotApplicableOperation;

/**
 *
 * @author aless
 */
public class PlusCommand implements Command {

    private final Stack stack;
    
    public PlusCommand(Stack stack){
        this.stack=stack;
    }

    @Override
    public ComplexNumber execute() throws EmptyStackException, InvalidNumberException, NotApplicableOperation{
        if (stack.size() >= 2) {
            ComplexNumber c1 = stack.pop();
            ComplexNumber c2 = stack.pop();
            return Operations.addOperation(c1, c2);
        } else {
            throw new NotApplicableOperation();
        }
    }
}
