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
public class MinusCommandTest {

    ComplexNumber a, b, result;
    Solver solver;

    public MinusCommandTest() {

    }

    @Before
    public void setUp() {
        a = new ComplexNumber();
        b = new ComplexNumber();
        result = new ComplexNumber();
        solver = Solver.getInstance();
    }

    /*----------------------------DIFFERENCE--------------------------------*/
    @Test
    public void testDifferenceRPositiveIPositiveRPositiveINegative() throws InvalidNumberException, EmptyStackException, InvalidVariableNameException, UndefinedPhaseException, DivisionByZeroException, VariableExistingException, Exception {

        //(Real Part >0, Imaginary Part >0) + (Real Part>0, Imaginary Part<0).
        result.setRealPart(-1);
        result.setImaginaryPart(6);
        a.setRealPart(1);
        a.setImaginaryPart(4);
        b.setRealPart(2);
        b.setImaginaryPart(-2);
        solver.getStructureStack().push(b);
        solver.getStructureStack().push(a);
        MinusCommand command = new MinusCommand();
        solver.resolveOperation(command);
        ComplexNumber peeked = solver.getStructureStack().peek();

        assertEquals(result.getRealPart(), peeked.getRealPart(), 4);
        assertEquals(result.getImaginaryPart(), peeked.getImaginaryPart(), 4);
    }

    @Test
    public void testDifferenceRPositiveIPositiveRNegativeIPositive() throws InvalidNumberException, EmptyStackException, InvalidVariableNameException, UndefinedPhaseException, DivisionByZeroException, VariableExistingException, Exception {
        //(Real Part >0, Imaginary Part >0) + (Real Part<0, Imaginary Part>0).
        result.setRealPart(2);
        result.setImaginaryPart(-1);
        a.setRealPart(1);
        a.setImaginaryPart(1);
        b.setRealPart(-1);
        b.setImaginaryPart(2);
        solver.getStructureStack().push(b);
        solver.getStructureStack().push(a);
        MinusCommand command = new MinusCommand();
        solver.resolveOperation(command);
        ComplexNumber peeked = solver.getStructureStack().peek();

        assertEquals(result.getRealPart(), peeked.getRealPart(), 4);
        assertEquals(result.getImaginaryPart(), peeked.getImaginaryPart(), 4);
    }

    @Test
    public void testDifferenceRPositiveIPositiveRNegativeINegative() throws InvalidNumberException, NotApplicableOperation, InvalidVariableNameException, EmptyStackException, DivisionByZeroException, VariableExistingException, Exception {
        //(Real Part >0, Imaginary Part >0) + (Real Part<0, Imaginary Part<0).
        result.setRealPart(15);
        result.setImaginaryPart(15);
        a.setRealPart(10);
        a.setImaginaryPart(10);
        b.setRealPart(-5);
        b.setImaginaryPart(-5);
        solver.getStructureStack().push(b);
        solver.getStructureStack().push(a);
        MinusCommand command = new MinusCommand();
        solver.resolveOperation(command);
        ComplexNumber peeked = solver.getStructureStack().peek();

        assertEquals(result.getRealPart(), peeked.getRealPart(), 4);
        assertEquals(result.getImaginaryPart(), peeked.getImaginaryPart(), 4);
    }

    @Test
    public void testDifferenceRPositiveINegativeRPositiveIPositive() throws InvalidNumberException, EmptyStackException, InvalidVariableNameException, UndefinedPhaseException, DivisionByZeroException, VariableExistingException, Exception {
        //(Real Part >0, Imaginary Part <0) + (Real Part>0, Imaginary Part>0).
        result.setRealPart(-1);
        result.setImaginaryPart(-5);
        a.setRealPart(2);
        a.setImaginaryPart(-3);
        b.setRealPart(3);
        b.setImaginaryPart(2);
        solver.getStructureStack().push(b);
        solver.getStructureStack().push(a);
        MinusCommand command = new MinusCommand();
        solver.resolveOperation(command);
        ComplexNumber peeked = solver.getStructureStack().peek();

        assertEquals(result.getRealPart(), peeked.getRealPart(), 4);
        assertEquals(result.getImaginaryPart(), peeked.getImaginaryPart(), 4);

    }

    @Test
    public void testDifferenceRPositiveINegativeRPositiveINegative() throws InvalidNumberException, EmptyStackException, InvalidVariableNameException, UndefinedPhaseException, DivisionByZeroException, VariableExistingException, Exception {
        //(Real Part >0, Imaginary Part <0) + (Real Part>0, Imaginary Part<0).
        result.setRealPart(1);
        result.setImaginaryPart(-1);
        a.setRealPart(4);
        a.setImaginaryPart(-3);
        b.setRealPart(3);
        b.setImaginaryPart(-2);
        solver.getStructureStack().push(b);
        solver.getStructureStack().push(a);
        MinusCommand command = new MinusCommand();
        solver.resolveOperation(command);
        ComplexNumber peeked = solver.getStructureStack().peek();

        assertEquals(result.getRealPart(), peeked.getRealPart(), 4);
        assertEquals(result.getImaginaryPart(), peeked.getImaginaryPart(), 4);

    }

    @Test

    public void testDifferenceRPositiveINegativeRNegativeIPositive() throws InvalidNumberException, EmptyStackException, InvalidVariableNameException, UndefinedPhaseException, DivisionByZeroException, VariableExistingException, Exception {

        //(Real Part >0, Imaginary Part <0) + (Real Part<0, Imaginary Part>0).
        result.setRealPart(3);
        result.setImaginaryPart(-5);
        a.setRealPart(1);
        a.setImaginaryPart(-2);
        b.setRealPart(-2);
        b.setImaginaryPart(3);
        solver.getStructureStack().push(b);
        solver.getStructureStack().push(a);
        MinusCommand command = new MinusCommand();
        solver.resolveOperation(command);
        ComplexNumber peeked = solver.getStructureStack().peek();

        assertEquals(result.getRealPart(), peeked.getRealPart(), 4);
        assertEquals(result.getImaginaryPart(), peeked.getImaginaryPart(), 4);

    }

    @Test

    public void testDifferenceRPositiveINegativeRNegativeINegative() throws InvalidNumberException, EmptyStackException, InvalidVariableNameException, UndefinedPhaseException, DivisionByZeroException, VariableExistingException, Exception {

        //(Real Part >0, Imaginary Part <0) + (Real Part<0, Imaginary Part<0).
        result.setRealPart(3);
        result.setImaginaryPart(0);
        a.setRealPart(1);
        a.setImaginaryPart(-3);
        b.setRealPart(-2);
        b.setImaginaryPart(-3);
        solver.getStructureStack().push(b);
        solver.getStructureStack().push(a);
        MinusCommand command = new MinusCommand();
        solver.resolveOperation(command);
        ComplexNumber peeked = solver.getStructureStack().peek();

        assertEquals(result.getRealPart(), peeked.getRealPart(), 4);
        assertEquals(result.getImaginaryPart(), peeked.getImaginaryPart(), 4);

    }

    @Test

    public void testDifferenceRNegativeIPositiveRPositiveIPositive() throws InvalidNumberException, EmptyStackException, InvalidVariableNameException, UndefinedPhaseException, DivisionByZeroException, VariableExistingException, Exception {
        //(Real Part <0, Imaginary Part >0) + (Real Part>0, Imaginary Part>0).
        result.setRealPart(-8);
        result.setImaginaryPart(-1);
        a.setRealPart(-3);
        a.setImaginaryPart(2);
        b.setRealPart(5);
        b.setImaginaryPart(3);
        solver.getStructureStack().push(b);
        solver.getStructureStack().push(a);
        MinusCommand command = new MinusCommand();
        solver.resolveOperation(command);
        ComplexNumber peeked = solver.getStructureStack().peek();

        assertEquals(result.getRealPart(), peeked.getRealPart(), 4);
        assertEquals(result.getImaginaryPart(), peeked.getImaginaryPart(), 4);
    }

    @Test

    public void testDifferenceRNegativeIPositiveRPositiveINegative() throws InvalidNumberException, EmptyStackException, InvalidVariableNameException, UndefinedPhaseException, DivisionByZeroException, VariableExistingException, Exception {
        //(Real Part <0, Imaginary Part >0) + (Real Part>0, Imaginary Part<0).
        result.setRealPart(-4);
        result.setImaginaryPart(5);
        a.setRealPart(-1);
        a.setImaginaryPart(2);
        b.setRealPart(3);
        b.setImaginaryPart(-3);
        solver.getStructureStack().push(b);
        solver.getStructureStack().push(a);
        MinusCommand command = new MinusCommand();
        solver.resolveOperation(command);
        ComplexNumber peeked = solver.getStructureStack().peek();

        assertEquals(result.getRealPart(), peeked.getRealPart(), 4);
        assertEquals(result.getImaginaryPart(), peeked.getImaginaryPart(), 4);

    }

    @Test

    public void testDifferenceRNegativeIPositiveRNegativeIPositive() throws InvalidNumberException, EmptyStackException, InvalidVariableNameException, UndefinedPhaseException, DivisionByZeroException, VariableExistingException, Exception {
        //(Real Part <0, Imaginary Part >0) + (Real Part<0, Imaginary Part>0).
        result.setRealPart(1);
        result.setImaginaryPart(1);
        a.setRealPart(-1);
        a.setImaginaryPart(3);
        b.setRealPart(-2);
        b.setImaginaryPart(2);

        solver.getStructureStack().push(b);
        solver.getStructureStack().push(a);
        MinusCommand command = new MinusCommand();
        solver.resolveOperation(command);
        ComplexNumber peeked = solver.getStructureStack().peek();

        assertEquals(result.getRealPart(), peeked.getRealPart(), 4);
        assertEquals(result.getImaginaryPart(), peeked.getImaginaryPart(), 4);

    }

    @Test

    public void testDifferenceRNegativeIPositiveRNegativeINegative() throws InvalidNumberException, EmptyStackException, InvalidVariableNameException, UndefinedPhaseException, DivisionByZeroException, VariableExistingException, Exception {
        //(Real Part <0, Imaginary Part >0) + (Real Part<0, Imaginary Part<0).
        result.setRealPart(1);
        result.setImaginaryPart(4);
        a.setRealPart(-2);
        a.setImaginaryPart(3);
        b.setRealPart(-3);
        b.setImaginaryPart(-1);
        solver.getStructureStack().push(b);
        solver.getStructureStack().push(a);
        MinusCommand command = new MinusCommand();
        solver.resolveOperation(command);
        ComplexNumber peeked = solver.getStructureStack().peek();

        assertEquals(result.getRealPart(), peeked.getRealPart(), 4);
        assertEquals(result.getImaginaryPart(), peeked.getImaginaryPart(), 4);

    }

    @Test

    public void testDifferenceRNegativeINegativeRPositiveIPositive() throws InvalidNumberException, EmptyStackException, InvalidVariableNameException, UndefinedPhaseException, DivisionByZeroException, VariableExistingException, Exception {
        //(Real Part <0, Imaginary Part <0) + (Real Part>0, Imaginary Part>0).
        result.setRealPart(-6);
        result.setImaginaryPart(-6);
        a.setRealPart(-2);
        a.setImaginaryPart(-3);
        b.setRealPart(4);
        b.setImaginaryPart(3);
        solver.getStructureStack().push(b);
        solver.getStructureStack().push(a);
        MinusCommand command = new MinusCommand();
        solver.resolveOperation(command);
        ComplexNumber peeked = solver.getStructureStack().peek();

        assertEquals(result.getRealPart(), peeked.getRealPart(), 4);
        assertEquals(result.getImaginaryPart(), peeked.getImaginaryPart(), 4);
    }

    @Test

    public void testDifferenceRNegativeINegativeRPositiveINegative() throws InvalidNumberException, EmptyStackException, InvalidVariableNameException, UndefinedPhaseException, DivisionByZeroException, VariableExistingException, Exception {
        //(Real Part <0, Imaginary Part <0) + (Real Part>0, Imaginary Part<0).

        result.setRealPart(-4);
        result.setImaginaryPart(0);
        a.setRealPart(-1);
        a.setImaginaryPart(-2);
        b.setRealPart(3);
        b.setImaginaryPart(-2);
        solver.getStructureStack().push(b);
        solver.getStructureStack().push(a);
        MinusCommand command = new MinusCommand();
        solver.resolveOperation(command);
        ComplexNumber peeked = solver.getStructureStack().peek();

        assertEquals(result.getRealPart(), peeked.getRealPart(), 4);
        assertEquals(result.getImaginaryPart(), peeked.getImaginaryPart(), 4);

    }

    @Test

    public void testDifferenceRNegativeINegativeRNegativeIPositve() throws InvalidNumberException, EmptyStackException, InvalidVariableNameException, UndefinedPhaseException, DivisionByZeroException, VariableExistingException, Exception {
        //(Real Part <0, Imaginary Part <0) + (Real Part<0, Imaginary Part>0).
        result.setRealPart(0);
        result.setImaginaryPart(-3);
        a.setRealPart(-1);
        a.setImaginaryPart(-1);
        b.setRealPart(-1);
        b.setImaginaryPart(2);
        solver.getStructureStack().push(b);
        solver.getStructureStack().push(a);
        MinusCommand command = new MinusCommand();
        solver.resolveOperation(command);
        ComplexNumber peeked = solver.getStructureStack().peek();

        assertEquals(result.getRealPart(), peeked.getRealPart(), 4);
        assertEquals(result.getImaginaryPart(), peeked.getImaginaryPart(), 4);

    }

    @Test
    public void testDifferenceRNegativeINegativeRNegativeINegative() throws InvalidNumberException, EmptyStackException, InvalidVariableNameException, UndefinedPhaseException, DivisionByZeroException, VariableExistingException, Exception {

        //(Real Part <0, Imaginary Part <0) + (Real Part<0, Imaginary Part<0).
        result.setRealPart(0);
        result.setImaginaryPart(-1);
        a.setRealPart(-1);
        a.setImaginaryPart(-2);
        b.setRealPart(-1);
        b.setImaginaryPart(-1);
        solver.getStructureStack().push(b);
        solver.getStructureStack().push(a);
        MinusCommand command = new MinusCommand();
        solver.resolveOperation(command);
        ComplexNumber peeked = solver.getStructureStack().peek();

        assertEquals(result.getRealPart(), peeked.getRealPart(), 4);
        assertEquals(result.getImaginaryPart(), peeked.getImaginaryPart(), 4);

    }

    @Test

    public void testDifferenceRPositiveIZeroRPositiveIZero() throws InvalidNumberException, EmptyStackException, InvalidVariableNameException, UndefinedPhaseException, DivisionByZeroException, VariableExistingException, Exception {

        //(Real Part >0,Im=0) + (Real Part>0,Im=0)
        result.setRealPart(0);
        result.setImaginaryPart(0);
        a.setRealPart(1);
        a.setImaginaryPart(0);
        b.setRealPart(1);
        b.setImaginaryPart(0);
        solver.getStructureStack().push(b);
        solver.getStructureStack().push(a);
        MinusCommand command = new MinusCommand();
        solver.resolveOperation(command);
        ComplexNumber peeked = solver.getStructureStack().peek();

        assertEquals(result.getRealPart(), peeked.getRealPart(), 4);
        assertEquals(result.getImaginaryPart(), peeked.getImaginaryPart(), 4);
    }

    @Test
    public void testDifferenceRPositiveIZeroRNegativeIZero() throws InvalidNumberException, EmptyStackException, InvalidVariableNameException, UndefinedPhaseException, DivisionByZeroException, VariableExistingException, Exception {
        //(Real Part>0, Im=0) + (Real Part<0,Im=0) 
        result.setRealPart(5);
        result.setImaginaryPart(0);
        a.setRealPart(1);
        a.setImaginaryPart(0);
        b.setRealPart(-4);
        b.setImaginaryPart(0);
        solver.getStructureStack().push(b);
        solver.getStructureStack().push(a);
        MinusCommand command = new MinusCommand();
        solver.resolveOperation(command);
        ComplexNumber peeked = solver.getStructureStack().peek();

        assertEquals(result.getRealPart(), peeked.getRealPart(), 4);
        assertEquals(result.getImaginaryPart(), peeked.getImaginaryPart(), 4);

    }

    @Test

    public void testDifferenceRNegativeIZeroRNegativeIZero() throws InvalidNumberException, EmptyStackException, InvalidVariableNameException, UndefinedPhaseException, DivisionByZeroException, VariableExistingException, Exception {
        //(Real Part<0, Im =0) + (Real Part<0, Im=0)
        result.setRealPart(1);
        result.setImaginaryPart(0);
        a.setRealPart(-1);
        a.setImaginaryPart(0);
        b.setRealPart(-2);
        b.setImaginaryPart(0);
        solver.getStructureStack().push(b);
        solver.getStructureStack().push(a);
        MinusCommand command = new MinusCommand();
        solver.resolveOperation(command);
        ComplexNumber peeked = solver.getStructureStack().peek();

        assertEquals(result.getRealPart(), peeked.getRealPart(), 4);
        assertEquals(result.getImaginaryPart(), peeked.getImaginaryPart(), 4);

    }

    @Test

    public void testDifferenceRZeroIPositiveRZeroIPositive() throws InvalidNumberException, EmptyStackException, InvalidVariableNameException, UndefinedPhaseException, DivisionByZeroException, VariableExistingException, Exception {
        // (Real Part=0, Im>0) + (Real Part=0, Im>0)
        result.setRealPart(0);
        result.setImaginaryPart(0);
        a.setRealPart(0);
        a.setImaginaryPart(1);
        b.setRealPart(0);
        b.setImaginaryPart(1);
        solver.getStructureStack().push(b);
        solver.getStructureStack().push(a);
        MinusCommand command = new MinusCommand();
        solver.resolveOperation(command);
        ComplexNumber peeked = solver.getStructureStack().peek();

        assertEquals(result.getRealPart(), peeked.getRealPart(), 4);
        assertEquals(result.getImaginaryPart(), peeked.getImaginaryPart(), 4);

    }

    @Test

    public void testDifferenceRZeroIZeroRZeroIZero() throws InvalidNumberException, EmptyStackException, InvalidVariableNameException, UndefinedPhaseException, DivisionByZeroException, VariableExistingException, Exception {
        //(Real Part=0,Im =0) + (Real Part=0, Im=0)
        result.setRealPart(0);
        result.setImaginaryPart(0);
        a.setRealPart(0);
        a.setImaginaryPart(0);
        b.setRealPart(0);
        b.setImaginaryPart(0);
        solver.getStructureStack().push(b);
        solver.getStructureStack().push(a);
        MinusCommand command = new MinusCommand();
        solver.resolveOperation(command);
        ComplexNumber peeked = solver.getStructureStack().peek();

        assertEquals(result.getRealPart(), peeked.getRealPart(), 4);
        assertEquals(result.getImaginaryPart(), peeked.getImaginaryPart(), 4);

    }

    @Test

    public void testDifferenceRNonZeroIZeroRZeroINonZero() throws InvalidNumberException, EmptyStackException, InvalidVariableNameException, UndefinedPhaseException, DivisionByZeroException, VariableExistingException, Exception {
        //(Real Part!=0,Im =0) + (Real Part=0, Im!=0)
        result.setRealPart(1);
        result.setImaginaryPart(-3);
        a.setRealPart(1);
        a.setImaginaryPart(0);
        b.setRealPart(0);
        b.setImaginaryPart(3);
        solver.getStructureStack().push(b);
        solver.getStructureStack().push(a);
        MinusCommand command = new MinusCommand();
        solver.resolveOperation(command);
        ComplexNumber peeked = solver.getStructureStack().peek();

        assertEquals(result.getRealPart(), peeked.getRealPart(), 4);
        assertEquals(result.getImaginaryPart(), peeked.getImaginaryPart(), 4);

    }

    @Test

    public void testDifferenceOpposite() throws InvalidNumberException, EmptyStackException, InvalidVariableNameException, UndefinedPhaseException, DivisionByZeroException, VariableExistingException, Exception {
        //(Real Part=A,Im =B) + (Real Part=-A, Im=-B)
        result.setRealPart(0);
        result.setImaginaryPart(0);
        a.setRealPart(6);
        a.setImaginaryPart(7);
        b.setRealPart(6);
        b.setImaginaryPart(7);
        solver.getStructureStack().push(b);
        solver.getStructureStack().push(a);
        MinusCommand command = new MinusCommand();
        solver.resolveOperation(command);
        ComplexNumber peeked = solver.getStructureStack().peek();

        assertEquals(result.getRealPart(), peeked.getRealPart(), 4);
        assertEquals(result.getImaginaryPart(), peeked.getImaginaryPart(), 4);

    }
    
    


}
