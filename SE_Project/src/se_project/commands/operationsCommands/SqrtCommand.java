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
public class SqrtCommand implements Command {

    private final Stack stack;

    public SqrtCommand(Stack stack) {
        this.stack = stack;
    }

    @Override
    public LinkedList<ComplexNumber> execute() throws EmptyStackException, UndefinedPhaseException, NotApplicableOperation, InvalidNumberException {
        if (stack.size() >= 1) {
            ComplexNumber c1 = stack.pop();
            return Operations.squareRoot(c1);
        } else {
            throw new NotApplicableOperation();
        }

    }
}
