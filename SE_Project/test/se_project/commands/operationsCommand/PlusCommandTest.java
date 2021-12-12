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
import se_project.commands.operationsCommands.MinusCommand;
import se_project.commands.operationsCommands.PlusCommand;
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
public class PlusCommandTest {

    ComplexNumber a, b, result;
    Solver solver;

    public PlusCommandTest() {

    }

    @Before
    public void setUp() {
        a = new ComplexNumber();
        b = new ComplexNumber();
        result = new ComplexNumber();
        solver = Solver.getInstance();
    }

    /*----------------------------SUM-----------------------------------------*/
    @Test
    public void testSumRPositiveIPositiveRPositiveIPositive() throws InvalidNumberException, NotApplicableOperation, InvalidVariableNameException, UndefinedPhaseException, DivisionByZeroException, VariableExistingException, EmptyStackException, Exception {
        //(Real Part >0, Imaginary Part >0) + (Real Part>0, Imaginary Part>0).
        result.setRealPart(3);
        result.setImaginaryPart(3);
        a.setRealPart(1);
        a.setImaginaryPart(1);
        b.setRealPart(2);
        b.setImaginaryPart(2);
        solver.getStructureStack().push(b);
        solver.getStructureStack().push(a);
        PlusCommand command = new PlusCommand();
        solver.resolveOperation(command);
        ComplexNumber peeked = solver.getStructureStack().peek();

        assertEquals(result.getRealPart(), peeked.getRealPart(), 4);
        assertEquals(result.getImaginaryPart(), peeked.getImaginaryPart(), 4);
    }

    @Test
    public void testSumRPositiveIPositiveRPositiveINegative() throws InvalidNumberException, NotApplicableOperation, InvalidVariableNameException, UndefinedPhaseException, DivisionByZeroException, VariableExistingException, EmptyStackException, Exception {
        //(Real Part >0, Imaginary Part >0) + (Real Part>0, Imaginary Part<0).
        result.setRealPart(3);
        result.setImaginaryPart(2);
        a.setRealPart(1);
        a.setImaginaryPart(4);
        b.setRealPart(2);
        b.setImaginaryPart(-2);
        solver.getStructureStack().push(b);
        solver.getStructureStack().push(a);
        PlusCommand command = new PlusCommand();
        solver.resolveOperation(command);
        ComplexNumber peeked = solver.getStructureStack().peek();

        assertEquals(result.getRealPart(), peeked.getRealPart(), 4);
        assertEquals(result.getImaginaryPart(), peeked.getImaginaryPart(), 4);

    }

    @Test
    public void testSumRPositiveIPositiveRNegativeIPositive() throws InvalidNumberException, NotApplicableOperation, InvalidVariableNameException, UndefinedPhaseException, DivisionByZeroException, VariableExistingException, EmptyStackException, Exception {
        //(Real Part >0, Imaginary Part >0) + (Real Part<0, Imaginary Part>0).
        result.setRealPart(0);
        result.setImaginaryPart(3);
        a.setRealPart(1);
        a.setImaginaryPart(1);
        b.setRealPart(-1);
        b.setImaginaryPart(2);
        solver.getStructureStack().push(b);
        solver.getStructureStack().push(a);
        PlusCommand command = new PlusCommand();
        solver.resolveOperation(command);
        ComplexNumber peeked = solver.getStructureStack().peek();

        assertEquals(result.getRealPart(), peeked.getRealPart(), 4);
        assertEquals(result.getImaginaryPart(), peeked.getImaginaryPart(), 4);
    }

    @Test
    public void testSumRPositiveIPositiveRNegativeINegative() throws InvalidNumberException, NotApplicableOperation, InvalidVariableNameException, UndefinedPhaseException, DivisionByZeroException, VariableExistingException, EmptyStackException, Exception {
        //(Real Part >0, Imaginary Part >0) + (Real Part<0, Imaginary Part<0).
        result.setRealPart(5);
        result.setImaginaryPart(5);
        a.setRealPart(10);
        a.setImaginaryPart(10);
        b.setRealPart(-5);
        b.setImaginaryPart(-5);
        solver.getStructureStack().push(b);
        solver.getStructureStack().push(a);
        PlusCommand command = new PlusCommand();
        solver.resolveOperation(command);
        ComplexNumber peeked = solver.getStructureStack().peek();

        assertEquals(result.getRealPart(), peeked.getRealPart(), 4);
        assertEquals(result.getImaginaryPart(), peeked.getImaginaryPart(), 4);
    }

    @Test
    public void testSumRPositiveINegativeRPositiveIPositive() throws InvalidNumberException, NotApplicableOperation, InvalidVariableNameException, UndefinedPhaseException, DivisionByZeroException, VariableExistingException, EmptyStackException, Exception {
        //(Real Part >0, Imaginary Part <0) + (Real Part>0, Imaginary Part>0).
        result.setRealPart(5);
        result.setImaginaryPart(-1);
        a.setRealPart(2);
        a.setImaginaryPart(-3);
        b.setRealPart(3);
        b.setImaginaryPart(2);
        solver.getStructureStack().push(b);
        solver.getStructureStack().push(a);
        PlusCommand command = new PlusCommand();
        solver.resolveOperation(command);
        ComplexNumber peeked = solver.getStructureStack().peek();

        assertEquals(result.getRealPart(), peeked.getRealPart(), 4);
        assertEquals(result.getImaginaryPart(), peeked.getImaginaryPart(), 4);

    }

    @Test
    public void testSumRPositiveINegativeRPositiveINegative() throws InvalidNumberException, NotApplicableOperation, InvalidVariableNameException, UndefinedPhaseException, DivisionByZeroException, VariableExistingException, EmptyStackException, Exception {
        //(Real Part >0, Imaginary Part <0) + (Real Part>0, Imaginary Part<0).
        result.setRealPart(7);
        result.setImaginaryPart(-5);
        a.setRealPart(4);
        a.setImaginaryPart(-3);
        b.setRealPart(3);
        b.setImaginaryPart(-2);
        solver.getStructureStack().push(b);
        solver.getStructureStack().push(a);
        PlusCommand command = new PlusCommand();
        solver.resolveOperation(command);
        ComplexNumber peeked = solver.getStructureStack().peek();

        assertEquals(result.getRealPart(), peeked.getRealPart(), 4);
        assertEquals(result.getImaginaryPart(), peeked.getImaginaryPart(), 4);

    }

    @Test
    public void testSumRPositiveINegativeRNegativeIPositive() throws InvalidNumberException, NotApplicableOperation, InvalidVariableNameException, UndefinedPhaseException, DivisionByZeroException, VariableExistingException, EmptyStackException, Exception {

        //(Real Part >0, Imaginary Part <0) + (Real Part<0, Imaginary Part>0).
        result.setRealPart(-1);
        result.setImaginaryPart(1);
        a.setRealPart(1);
        a.setImaginaryPart(-2);
        b.setRealPart(-2);
        b.setImaginaryPart(3);
        solver.getStructureStack().push(b);
        solver.getStructureStack().push(a);
        PlusCommand command = new PlusCommand();
        solver.resolveOperation(command);
        ComplexNumber peeked = solver.getStructureStack().peek();

        assertEquals(result.getRealPart(), peeked.getRealPart(), 4);
        assertEquals(result.getImaginaryPart(), peeked.getImaginaryPart(), 4);

    }

    @Test
    public void testSumRPositiveINegativeRNegativeINegative() throws InvalidNumberException, NotApplicableOperation, InvalidVariableNameException, UndefinedPhaseException, DivisionByZeroException, VariableExistingException, EmptyStackException, Exception {

        //(Real Part >0, Imaginary Part <0) + (Real Part<0, Imaginary Part<0).
        result.setRealPart(-1);
        result.setImaginaryPart(-6);
        a.setRealPart(1);
        a.setImaginaryPart(-3);
        b.setRealPart(-2);
        b.setImaginaryPart(-3);
        solver.getStructureStack().push(b);
        solver.getStructureStack().push(a);
        PlusCommand command = new PlusCommand();
        solver.resolveOperation(command);
        ComplexNumber peeked = solver.getStructureStack().peek();

        assertEquals(result.getRealPart(), peeked.getRealPart(), 4);
        assertEquals(result.getImaginaryPart(), peeked.getImaginaryPart(), 4);

    }

    @Test
    public void testSumRNegativeIPositiveRPositiveIPositive() throws InvalidNumberException, NotApplicableOperation, InvalidVariableNameException, UndefinedPhaseException, DivisionByZeroException, VariableExistingException, EmptyStackException, Exception {
        //(Real Part <0, Imaginary Part >0) + (Real Part>0, Imaginary Part>0).
        result.setRealPart(2);
        result.setImaginaryPart(5);
        a.setRealPart(-3);
        a.setImaginaryPart(2);
        b.setRealPart(5);
        b.setImaginaryPart(3);
        solver.getStructureStack().push(b);
        solver.getStructureStack().push(a);
        PlusCommand command = new PlusCommand();
        solver.resolveOperation(command);
        ComplexNumber peeked = solver.getStructureStack().peek();

        assertEquals(result.getRealPart(), peeked.getRealPart(), 4);
        assertEquals(result.getImaginaryPart(), peeked.getImaginaryPart(), 4);
    }

    @Test
    public void testSumRNegativeIPositiveRPositiveINegative() throws InvalidNumberException, NotApplicableOperation, InvalidVariableNameException, UndefinedPhaseException, DivisionByZeroException, VariableExistingException, EmptyStackException, Exception {
        //(Real Part <0, Imaginary Part >0) + (Real Part>0, Imaginary Part<0).
        result.setRealPart(2);
        result.setImaginaryPart(-1);
        a.setRealPart(-1);
        a.setImaginaryPart(2);
        b.setRealPart(3);
        b.setImaginaryPart(-3);
        solver.getStructureStack().push(b);
        solver.getStructureStack().push(a);
        PlusCommand command = new PlusCommand();
        solver.resolveOperation(command);
        ComplexNumber peeked = solver.getStructureStack().peek();

        assertEquals(result.getRealPart(), peeked.getRealPart(), 4);
        assertEquals(result.getImaginaryPart(), peeked.getImaginaryPart(), 4);

    }

    @Test
    public void testSumRNegativeIPositiveRNegativeIPositive() throws InvalidNumberException, NotApplicableOperation, InvalidVariableNameException, UndefinedPhaseException, DivisionByZeroException, VariableExistingException, EmptyStackException, Exception {
        //(Real Part <0, Imaginary Part >0) + (Real Part<0, Imaginary Part>0).
        result.setRealPart(-3);
        result.setImaginaryPart(5);
        a.setRealPart(-1);
        a.setImaginaryPart(3);
        b.setRealPart(-2);
        b.setImaginaryPart(2);

        assertEquals(result, Operations.addOperation(a, b));

    }

    @Test
    public void testSumRNegativeIPositiveRNegativeINegative() throws InvalidNumberException, NotApplicableOperation, InvalidVariableNameException, UndefinedPhaseException, DivisionByZeroException, VariableExistingException, EmptyStackException, Exception {
        //(Real Part <0, Imaginary Part >0) + (Real Part<0, Imaginary Part<0).
        result.setRealPart(-5);
        result.setImaginaryPart(2);
        a.setRealPart(-2);
        a.setImaginaryPart(3);
        b.setRealPart(-3);
        b.setImaginaryPart(-1);
        solver.getStructureStack().push(b);
        solver.getStructureStack().push(a);
        PlusCommand command = new PlusCommand();
        solver.resolveOperation(command);
        ComplexNumber peeked = solver.getStructureStack().peek();

        assertEquals(result.getRealPart(), peeked.getRealPart(), 4);
        assertEquals(result.getImaginaryPart(), peeked.getImaginaryPart(), 4);

    }

    @Test
    public void testSumRNegativeINegativeRPositiveIPositive() throws InvalidNumberException, NotApplicableOperation, InvalidVariableNameException, UndefinedPhaseException, DivisionByZeroException, VariableExistingException, EmptyStackException, Exception {
        //(Real Part <0, Imaginary Part <0) + (Real Part>0, Imaginary Part>0).
        result.setRealPart(2);
        result.setImaginaryPart(0);
        a.setRealPart(-2);
        a.setImaginaryPart(-3);
        b.setRealPart(4);
        b.setImaginaryPart(3);
        solver.getStructureStack().push(b);
        solver.getStructureStack().push(a);
        PlusCommand command = new PlusCommand();
        solver.resolveOperation(command);
        ComplexNumber peeked = solver.getStructureStack().peek();

        assertEquals(result.getRealPart(), peeked.getRealPart(), 4);
        assertEquals(result.getImaginaryPart(), peeked.getImaginaryPart(), 4);
    }

    @Test
    public void testSumRNegativeINegativeRPositiveINegative() throws InvalidNumberException, NotApplicableOperation, InvalidVariableNameException, UndefinedPhaseException, DivisionByZeroException, VariableExistingException, EmptyStackException, Exception {

        //(Real Part <0, Imaginary Part <0) + (Real Part>0, Imaginary Part<0).
        result.setRealPart(2);
        result.setImaginaryPart(-4);
        a.setRealPart(-1);
        a.setImaginaryPart(-2);
        b.setRealPart(3);
        b.setImaginaryPart(-2);
        solver.getStructureStack().push(b);
        solver.getStructureStack().push(a);
        PlusCommand command = new PlusCommand();
        solver.resolveOperation(command);
        ComplexNumber peeked = solver.getStructureStack().peek();

        assertEquals(result.getRealPart(), peeked.getRealPart(), 4);
        assertEquals(result.getImaginaryPart(), peeked.getImaginaryPart(), 4);

    }

    @Test
    public void testSumRNegativeINegativeRNegativeIPositve() throws InvalidNumberException, NotApplicableOperation, InvalidVariableNameException, UndefinedPhaseException, DivisionByZeroException, VariableExistingException, EmptyStackException, Exception {
        //(Real Part <0, Imaginary Part <0) + (Real Part<0, Imaginary Part>0).
        result.setRealPart(-2);
        result.setImaginaryPart(1);
        a.setRealPart(-1);
        a.setImaginaryPart(-1);
        b.setRealPart(-1);
        b.setImaginaryPart(2);
        solver.getStructureStack().push(b);
        solver.getStructureStack().push(a);
        PlusCommand command = new PlusCommand();
        solver.resolveOperation(command);
        ComplexNumber peeked = solver.getStructureStack().peek();

        assertEquals(result.getRealPart(), peeked.getRealPart(), 4);
        assertEquals(result.getImaginaryPart(), peeked.getImaginaryPart(), 4);

    }

    @Test
    public void testSumRNegativeINegativeRNegativeINegative() throws InvalidNumberException, NotApplicableOperation, InvalidVariableNameException, UndefinedPhaseException, DivisionByZeroException, VariableExistingException, EmptyStackException, Exception {

        //(Real Part <0, Imaginary Part <0) + (Real Part<0, Imaginary Part<0).
        result.setRealPart(-2);
        result.setImaginaryPart(-3);
        a.setRealPart(-1);
        a.setImaginaryPart(-2);
        b.setRealPart(-1);
        b.setImaginaryPart(-1);
        solver.getStructureStack().push(b);
        solver.getStructureStack().push(a);
        PlusCommand command = new PlusCommand();
        solver.resolveOperation(command);
        ComplexNumber peeked = solver.getStructureStack().peek();

        assertEquals(result.getRealPart(), peeked.getRealPart(), 4);
        assertEquals(result.getImaginaryPart(), peeked.getImaginaryPart(), 4);

    }

    @Test
    public void testSumRPositiveIZeroRPositiveIZero() throws InvalidNumberException, NotApplicableOperation, InvalidVariableNameException, UndefinedPhaseException, DivisionByZeroException, VariableExistingException, EmptyStackException, Exception {

        //(Real Part >0,Im=0) + (Real Part>0,Im=0)
        result.setRealPart(2);
        result.setImaginaryPart(0);
        a.setRealPart(1);
        a.setImaginaryPart(0);
        b.setRealPart(1);
        b.setImaginaryPart(0);
        solver.getStructureStack().push(b);
        solver.getStructureStack().push(a);
        PlusCommand command = new PlusCommand();
        solver.resolveOperation(command);
        ComplexNumber peeked = solver.getStructureStack().peek();

        assertEquals(result.getRealPart(), peeked.getRealPart(), 4);
        assertEquals(result.getImaginaryPart(), peeked.getImaginaryPart(), 4);
    }

    @Test
    public void testSumRPositiveIZeroRNegativeIZero() throws InvalidNumberException, NotApplicableOperation, InvalidVariableNameException, UndefinedPhaseException, DivisionByZeroException, VariableExistingException, EmptyStackException, Exception {
        //(Real Part>0, Im=0) + (Real Part<0,Im=0) 
        result.setRealPart(-3);
        result.setImaginaryPart(0);
        a.setRealPart(1);
        a.setImaginaryPart(0);
        b.setRealPart(-4);
        b.setImaginaryPart(0);
        solver.getStructureStack().push(b);
        solver.getStructureStack().push(a);
        PlusCommand command = new PlusCommand();
        solver.resolveOperation(command);
        ComplexNumber peeked = solver.getStructureStack().peek();

        assertEquals(result.getRealPart(), peeked.getRealPart(), 4);
        assertEquals(result.getImaginaryPart(), peeked.getImaginaryPart(), 4);

    }

    @Test
    public void testSumRNegativeIZeroRNegativeIZero() throws InvalidNumberException, NotApplicableOperation, InvalidVariableNameException, UndefinedPhaseException, DivisionByZeroException, VariableExistingException, EmptyStackException, Exception {
        //(Real Part<0, Im =0) + (Real Part<0, Im=0)
        result.setRealPart(-3);
        result.setImaginaryPart(0);
        a.setRealPart(-1);
        a.setImaginaryPart(0);
        b.setRealPart(-2);
        b.setImaginaryPart(0);
        solver.getStructureStack().push(b);
        solver.getStructureStack().push(a);
        PlusCommand command = new PlusCommand();
        solver.resolveOperation(command);
        ComplexNumber peeked = solver.getStructureStack().peek();

        assertEquals(result.getRealPart(), peeked.getRealPart(), 4);
        assertEquals(result.getImaginaryPart(), peeked.getImaginaryPart(), 4);

    }

    @Test
    public void testSumRZeroIPositiveRZeroIPositive() throws InvalidNumberException, NotApplicableOperation, InvalidVariableNameException, UndefinedPhaseException, DivisionByZeroException, VariableExistingException, EmptyStackException, Exception {
        // (Real Part=0, Im>0) + (Real Part=0, Im>0)
        result.setRealPart(0);
        result.setImaginaryPart(2);
        a.setRealPart(0);
        a.setImaginaryPart(1);
        b.setRealPart(0);
        b.setImaginaryPart(1);
        solver.getStructureStack().push(b);
        solver.getStructureStack().push(a);
        PlusCommand command = new PlusCommand();
        solver.resolveOperation(command);
        ComplexNumber peeked = solver.getStructureStack().peek();

        assertEquals(result.getRealPart(), peeked.getRealPart(), 4);
        assertEquals(result.getImaginaryPart(), peeked.getImaginaryPart(), 4);

    }

    @Test
    public void testSumRZeroIZeroRZeroIZero() throws InvalidNumberException, NotApplicableOperation, InvalidVariableNameException, UndefinedPhaseException, DivisionByZeroException, VariableExistingException, EmptyStackException, Exception {
        //(Real Part=0,Im =0) + (Real Part=0, Im=0)
        result.setRealPart(0);
        result.setImaginaryPart(0);
        a.setRealPart(0);
        a.setImaginaryPart(0);
        b.setRealPart(0);
        b.setImaginaryPart(0);
        solver.getStructureStack().push(b);
        solver.getStructureStack().push(a);
        PlusCommand command = new PlusCommand();
        solver.resolveOperation(command);
        ComplexNumber peeked = solver.getStructureStack().peek();

        assertEquals(result.getRealPart(), peeked.getRealPart(), 4);
        assertEquals(result.getImaginaryPart(), peeked.getImaginaryPart(), 4);

    }

    @Test
    public void testSumRNonZeroIZeroRZeroINonZero() throws InvalidNumberException, NotApplicableOperation, InvalidVariableNameException, UndefinedPhaseException, DivisionByZeroException, VariableExistingException, EmptyStackException, Exception {
        //(Real Part!=0,Im =0) + (Real Part=0, Im!=0)
        result.setRealPart(1);
        result.setImaginaryPart(3);
        a.setRealPart(1);
        a.setImaginaryPart(0);
        b.setRealPart(0);
        b.setImaginaryPart(3);
        solver.getStructureStack().push(b);
        solver.getStructureStack().push(a);
        PlusCommand command = new PlusCommand();
        solver.resolveOperation(command);
        ComplexNumber peeked = solver.getStructureStack().peek();

        assertEquals(result.getRealPart(), peeked.getRealPart(), 4);
        assertEquals(result.getImaginaryPart(), peeked.getImaginaryPart(), 4);

    }

    @Test
    public void testSumOpposite() throws InvalidNumberException, NotApplicableOperation, InvalidVariableNameException, UndefinedPhaseException, DivisionByZeroException, VariableExistingException, EmptyStackException, Exception {
        //(Real Part=A,Im =B) + (Real Part=-A, Im=-B)
        result.setRealPart(0);
        result.setImaginaryPart(0);
        a.setRealPart(6);
        a.setImaginaryPart(7);
        b.setRealPart(-6);
        b.setImaginaryPart(-7);
        solver.getStructureStack().push(b);
        solver.getStructureStack().push(a);
        PlusCommand command = new PlusCommand();
        solver.resolveOperation(command);
        ComplexNumber peeked = solver.getStructureStack().peek();

        assertEquals(result.getRealPart(), peeked.getRealPart(), 4);
        assertEquals(result.getImaginaryPart(), peeked.getImaginaryPart(), 4);

    }

    @Test
    public void testDifferenceRPositiveIPositiveRPositiveIPositive() throws InvalidNumberException, NotApplicableOperation, InvalidVariableNameException, UndefinedPhaseException, DivisionByZeroException, VariableExistingException, EmptyStackException, Exception {
        //(Real Part >0, Imaginary Part >0) + (Real Part>0, Imaginary Part>0).
        result.setRealPart(-1);
        result.setImaginaryPart(-1);
        a.setRealPart(1);
        a.setImaginaryPart(1);
        b.setRealPart(2);
        b.setImaginaryPart(2);
        solver.getStructureStack().push(b);
        solver.getStructureStack().push(a);
        PlusCommand command = new PlusCommand();
        solver.resolveOperation(command);
        ComplexNumber peeked = solver.getStructureStack().peek();

        assertEquals(result.getRealPart(), peeked.getRealPart(), 4);
        assertEquals(result.getImaginaryPart(), peeked.getImaginaryPart(), 4);
    }
    
    
}
