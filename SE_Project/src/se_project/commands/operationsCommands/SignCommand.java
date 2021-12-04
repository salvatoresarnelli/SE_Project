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
public class SignCommand extends OperationCommand {
        private final String name ="+-";

    public SignCommand() {
        super(null);
    }
    public SignCommand(Stack stack) {
        super(stack);
    }
    @Override
    public ComplexNumber execute() throws InvalidNumberException, EmptyStackException, NotApplicableOperation {
       if (super.getTarget().size() >= 1) {
            ComplexNumber c1 = super.getTarget().pop();
            ComplexNumber result = Operations.signOperation(c1);
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
