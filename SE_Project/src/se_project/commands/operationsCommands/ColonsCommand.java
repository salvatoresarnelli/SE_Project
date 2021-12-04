/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se_project.commands.operationsCommands;

import se_project.ComplexNumber;
import se_project.Operations;
import se_project.Stack;
import se_project.commands.Command;
import se_project.commands.OperationCommand;
import se_project.exceptions.DivisionByZeroException;
import se_project.exceptions.EmptyStackException;
import se_project.exceptions.InvalidNumberException;
import se_project.exceptions.NotApplicableOperation;
import se_project.exceptions.UndefinedPhaseException;

/**
 *
 * @author aless
 */
public class ColonsCommand extends OperationCommand {
    private final String name =":";
public ColonsCommand() {
        super(null);
    }

    public ColonsCommand(Stack stack) {
        super(stack);
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

        if (super.getTarget().size() >= 2) {
            ComplexNumber c1 = super.getTarget().pop();
            ComplexNumber c2 = super.getTarget().pop();
            ComplexNumber result;
            try {
                result = Operations.divisionOperation(c1, c2);
                super.getTarget().push(result);
                return result;
            } catch (DivisionByZeroException ex) {

                super.getTarget().push(c2);
                super.getTarget().push(c1);
                throw new DivisionByZeroException();
            }
        } else {
            throw new NotApplicableOperation();
        }
    }
 @Override
    public String toString() {
        return name;
    }
}
