/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se_project.commands.operationsCommand;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import se_project.ComplexNumber;
import se_project.Operations;
import se_project.Solver;
import se_project.commands.operationsCommands.DotCommand;
import se_project.commands.operationsCommands.PlusCommand;
import se_project.commands.operationsCommands.SignCommand;
import se_project.exceptions.DivisionByZeroException;
import se_project.exceptions.EmptyStackException;
import se_project.exceptions.InvalidNumberException;
import se_project.exceptions.InvalidVariableNameException;
import se_project.exceptions.NotApplicableOperation;
import se_project.exceptions.UndefinedPhaseException;
import se_project.exceptions.VariableExistingException;

/**
 *
 * @author aless
 */
public class SignCommandTest {

    ComplexNumber a, result;
    Solver solver;

    public SignCommandTest() {

    }

    @Before
    public void setUp() {
        a = new ComplexNumber();
        result = new ComplexNumber();
        solver = Solver.getInstance();
    }

    /*----------------------------SIGN----------------------------------------*/
    @Test
    public void testSignZeros() throws InvalidNumberException, EmptyStackException, InvalidVariableNameException, UndefinedPhaseException, DivisionByZeroException, VariableExistingException, Exception {

        a.setRealPart(0);
        a.setImaginaryPart(0);
        result.setImaginaryPart(0);
        result.setRealPart(0);
        solver.getStructureStack().push(a);
        SignCommand command = new SignCommand();
        solver.resolveOperation(command);
        ComplexNumber peeked = solver.getStructureStack().peek();

        assertEquals(result.getRealPart(), peeked.getRealPart(), 4);
        assertEquals(result.getImaginaryPart(), peeked.getImaginaryPart(), 4);
    }

    @Test
    public void testSignImaginaryOnly() throws InvalidNumberException, EmptyStackException, InvalidVariableNameException, UndefinedPhaseException, DivisionByZeroException, VariableExistingException, Exception {
        a.setRealPart(0);
        a.setImaginaryPart(1);
        result.setImaginaryPart(-1);
        result.setRealPart(0);
        solver.getStructureStack().push(a);
        SignCommand command = new SignCommand();
        solver.resolveOperation(command);
        ComplexNumber peeked = solver.getStructureStack().peek();

        assertEquals(result.getRealPart(), peeked.getRealPart(), 4);
        assertEquals(result.getImaginaryPart(), peeked.getImaginaryPart(), 4);
    }

    @Test
    public void testSignRealPartOnly() throws InvalidNumberException, EmptyStackException, InvalidVariableNameException, UndefinedPhaseException, DivisionByZeroException, VariableExistingException, Exception {
        a.setRealPart(1);
        a.setImaginaryPart(0);
        result.setImaginaryPart(0);
        result.setRealPart(-1);
        solver.getStructureStack().push(a);
        SignCommand command = new SignCommand();
        solver.resolveOperation(command);
        ComplexNumber peeked = solver.getStructureStack().peek();

        assertEquals(result.getRealPart(), peeked.getRealPart(), 4);
        assertEquals(result.getImaginaryPart(), peeked.getImaginaryPart(), 4);
    }

    @Test
    public void testSignComplexWithBothParts() throws InvalidNumberException, EmptyStackException, InvalidVariableNameException, UndefinedPhaseException, DivisionByZeroException, VariableExistingException, Exception {
        a.setRealPart(1);
        a.setImaginaryPart(1);
        result.setImaginaryPart(-1);
        result.setRealPart(-1);
        solver.getStructureStack().push(a);
        SignCommand command = new SignCommand();
        solver.resolveOperation(command);
        ComplexNumber peeked = solver.getStructureStack().peek();

        assertEquals(result.getRealPart(), peeked.getRealPart(), 4);
        assertEquals(result.getImaginaryPart(), peeked.getImaginaryPart(), 4);

    }
    
    
}
