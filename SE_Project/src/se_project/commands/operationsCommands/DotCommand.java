/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se_project.commands.operationsCommands;

import se_project.commands.*;
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
public class DotCommand extends OperationCommand{
    private final String name ="*";

 public DotCommand() {
        super(null);
    }
    public DotCommand(Stack stack) {
        super(stack);
    }

    @Override
    public ComplexNumber execute() throws EmptyStackException, InvalidNumberException, NotApplicableOperation {
        if (super.getTarget().size() >= 2) {
            ComplexNumber c1 = super.getTarget().pop();
            ComplexNumber c2 = super.getTarget().pop();
            ComplexNumber result = Operations.dotOperation(c1, c2);
             super.getTarget().push(result);
             return result;
        } else {
            throw new NotApplicableOperation();
        }
    }
     @Override
    public String toString() {
        return name;
    }

}
