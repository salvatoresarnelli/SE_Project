/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package se_project.commands.trascendental;

import java.util.LinkedList;
import se_project.ComplexNumber;
import se_project.Operations;
import se_project.Stack;
import se_project.commands.OperationCommand;
import se_project.exceptions.DivisionByZeroException;
import se_project.exceptions.EmptyStackException;
import se_project.exceptions.InvalidNumberException;
import se_project.exceptions.NotApplicableOperation;
import se_project.exceptions.UndefinedPhaseException;

/**
 *
 * @author pionp
 */
public class CosCommand extends OperationCommand{
    private final String name ="cos";
    
    public CosCommand() {
        super(null);
    }
    
    public CosCommand(Stack stack) {
        super(stack);
    }
    
    @Override
    public LinkedList<ComplexNumber> execute() throws EmptyStackException, UndefinedPhaseException, NotApplicableOperation, InvalidNumberException, DivisionByZeroException {
        if (super.getTarget().size() >= 1) {
            ComplexNumber c1 = super.getTarget().pop();
            LinkedList<ComplexNumber> result = Operations.cos(c1);
            for(ComplexNumber c: result)
                 super.getTarget().push(c);
            return result;
        } else {
            throw new NotApplicableOperation();
        }

    }
     /**
     * La toString della classe ColonsCommand contiene solo il nome
     * dell'operazione.
     */
    @Override
    public String toString() {
        return name;
    }
}
