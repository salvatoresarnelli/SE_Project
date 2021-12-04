/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se_project.commands.operationsCommands;

import se_project.commands.*;
import java.util.LinkedList;
import se_project.ComplexNumber;
import se_project.Operations;
import se_project.Stack;
import se_project.exceptions.EmptyStackException;
import se_project.exceptions.InvalidNumberException;
import se_project.exceptions.NotApplicableOperation;
import se_project.exceptions.UndefinedPhaseException;

/**
 *
 * @author aless
 */
public class SqrtCommand extends OperationCommand {
        private final String name ="sqrt";

public SqrtCommand() {
        super(null);
    }
    public SqrtCommand(Stack stack) {
        super(stack);
    }
    @Override
    public LinkedList<ComplexNumber> execute() throws EmptyStackException, UndefinedPhaseException, NotApplicableOperation, InvalidNumberException {
        if (super.getTarget().size() >= 1) {
            ComplexNumber c1 = super.getTarget().pop();
            LinkedList<ComplexNumber> result = Operations.squareRoot(c1);
            for(ComplexNumber c: result)
                 super.getTarget().push(c);
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
