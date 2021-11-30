/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se_project.commands;

import se_project.ComplexNumber;
import se_project.Operations;
import se_project.Stack;
import se_project.exceptions.DivisionByZeroException;
import se_project.exceptions.EmptyStackException;
import se_project.exceptions.InvalidNumberException;
import se_project.exceptions.NotApplicableOperation;
import se_project.exceptions.UndefinedPhaseException;

/**
 *
 * @author aless
 */
public class ColonsCommand implements Command {

    private final Stack stack;

    public ColonsCommand(Stack stack) {
        this.stack = stack;
    }

    /**
     * @return a ComplexNumber
     * @throws se_project.exceptions.NotApplicableOperation
     * @throws se_project.exceptions.InvalidNumberException
     * @throws se_project.exceptions.UndefinedPhaseException
     * @throws se_project.exceptions.DivisionByZeroException
     * @throws se_project.exceptions.EmptyStackException
     */
    @Override
    public ComplexNumber execute() throws NotApplicableOperation, InvalidNumberException, UndefinedPhaseException, DivisionByZeroException, EmptyStackException {

        if (stack.size() >= 2) {
            ComplexNumber c1 = stack.pop();
            ComplexNumber c2 = stack.pop();
            try {
                return Operations.divisionOperation(c1, c2);
            } catch (DivisionByZeroException ex) {

                stack.push(c2);
                stack.push(c1);
                throw new DivisionByZeroException();
            }
        } else {
            throw new NotApplicableOperation();
        }
    }

}
