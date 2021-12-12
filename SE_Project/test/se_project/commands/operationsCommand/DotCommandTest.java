/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se_project.commands.operationsCommand;

import org.junit.After;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import se_project.ComplexNumber;
import se_project.Solver;
import se_project.commands.operationsCommands.DotCommand;
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
public class DotCommandTest {

    ComplexNumber a, b, result;
    Solver solver;

    public DotCommandTest() {

    }

    @Before
    public void setUp() {
        a = new ComplexNumber();
        b = new ComplexNumber();
        result = new ComplexNumber();
        solver = Solver.getInstance();
    }

    @After
    public void tearDown() {
    }

    /*----------------------------PRODUCT----------------------------------------*/
    @Test
    public void testDotRPositiveIPositiveRPositiveINegative() throws InvalidNumberException, NotApplicableOperation, InvalidVariableNameException, EmptyStackException, DivisionByZeroException, VariableExistingException, Exception {

        //(Real Part >0, Imaginary Part >0) + (Real Part>0, Imaginary Part<0).
        result.setRealPart(10);
        result.setImaginaryPart(6);
        a.setRealPart(1);
        a.setImaginaryPart(4);
        b.setRealPart(2);
        b.setImaginaryPart(-2);
        solver.getStructureStack().push(b);
        solver.getStructureStack().push(a);
        DotCommand command = new DotCommand();
        solver.resolveOperation(command);
        ComplexNumber peeked = solver.getStructureStack().peek();

        assertEquals(result.getRealPart(), peeked.getRealPart(), 4);
        assertEquals(result.getImaginaryPart(), peeked.getImaginaryPart(), 4);

    }

    @Test
    public void testDotRPositiveIPositiveRNegativeIPositive() throws InvalidNumberException, NotApplicableOperation, InvalidVariableNameException, EmptyStackException, DivisionByZeroException, VariableExistingException, Exception {

        //(Real Part >0, Imaginary Part >0) + (Real Part<0, Imaginary Part>0).
        result.setRealPart(0);
        result.setImaginaryPart(6);
        a.setRealPart(1);
        a.setImaginaryPart(1);
        b.setRealPart(3);
        b.setImaginaryPart(3);
        solver.getStructureStack().push(b);
        solver.getStructureStack().push(a);
        DotCommand command = new DotCommand();
        solver.resolveOperation(command);
        ComplexNumber peeked = solver.getStructureStack().peek();

        assertEquals(result.getRealPart(), peeked.getRealPart(), 4);
        assertEquals(result.getImaginaryPart(), peeked.getImaginaryPart(), 4);
    }

    @Test
    public void testDotRPositiveIPositiveRNegativeINegative() throws InvalidNumberException, NotApplicableOperation, InvalidVariableNameException, EmptyStackException, DivisionByZeroException, VariableExistingException, Exception {

        //(Real Part >0, Imaginary Part >0) + (Real Part<0, Imaginary Part<0).
        result.setRealPart(0);
        result.setImaginaryPart(-100);
        a.setRealPart(10);
        a.setImaginaryPart(10);
        b.setRealPart(-5);
        b.setImaginaryPart(-5);
        solver.getStructureStack().push(b);
        solver.getStructureStack().push(a);
        DotCommand command = new DotCommand();
        solver.resolveOperation(command);
        ComplexNumber peeked = solver.getStructureStack().peek();

        assertEquals(result.getRealPart(), peeked.getRealPart(), 4);
        assertEquals(result.getImaginaryPart(), peeked.getImaginaryPart(), 4);
    }

    @Test
    public void testDotRPositiveINegativeRPositiveIPositive() throws InvalidNumberException, NotApplicableOperation, InvalidVariableNameException, EmptyStackException, DivisionByZeroException, VariableExistingException, Exception {

        //(Real Part >0, Imaginary Part <0) + (Real Part>0, Imaginary Part>0).
        result.setRealPart(12);
        result.setImaginaryPart(-5);
        a.setRealPart(2);
        a.setImaginaryPart(-3);
        b.setRealPart(3);
        b.setImaginaryPart(2);
        solver.getStructureStack().push(b);
        solver.getStructureStack().push(a);
        DotCommand command = new DotCommand();
        solver.resolveOperation(command);
        ComplexNumber peeked = solver.getStructureStack().peek();

        assertEquals(result.getRealPart(), peeked.getRealPart(), 4);
        assertEquals(result.getImaginaryPart(), peeked.getImaginaryPart(), 4);
    }

    @Test
    public void testDotRPositiveINegativeRPositiveINegative() throws InvalidNumberException, NotApplicableOperation, InvalidVariableNameException, EmptyStackException, DivisionByZeroException, VariableExistingException, Exception {

        //(Real Part >0, Imaginary Part <0) + (Real Part>0, Imaginary Part<0).
        result.setRealPart(6);
        result.setImaginaryPart(-17);
        a.setRealPart(4);
        a.setImaginaryPart(-3);
        b.setRealPart(3);
        b.setImaginaryPart(-2);
        solver.getStructureStack().push(b);
        solver.getStructureStack().push(a);
        DotCommand command = new DotCommand();
        solver.resolveOperation(command);
        ComplexNumber peeked = solver.getStructureStack().peek();

        assertEquals(result.getRealPart(), peeked.getRealPart(), 4);
        assertEquals(result.getImaginaryPart(), peeked.getImaginaryPart(), 4);
    }

    @Test
    public void testDotRPositiveINegativeRNegativeIPositive() throws InvalidNumberException, NotApplicableOperation, InvalidVariableNameException, EmptyStackException, DivisionByZeroException, VariableExistingException, Exception {

        //(Real Part >0, Imaginary Part <0) + (Real Part<0, Imaginary Part>0).
        result.setRealPart(4);
        result.setImaginaryPart(7);
        a.setRealPart(1);
        a.setImaginaryPart(-2);
        b.setRealPart(-2);
        b.setImaginaryPart(3);
        solver.getStructureStack().push(b);
        solver.getStructureStack().push(a);
        DotCommand command = new DotCommand();
        solver.resolveOperation(command);
        ComplexNumber peeked = solver.getStructureStack().peek();

        assertEquals(result.getRealPart(), peeked.getRealPart(), 4);
        assertEquals(result.getImaginaryPart(), peeked.getImaginaryPart(), 4);
    }

    @Test
    public void testDotRPositiveINegativeRNegativeINegative() throws InvalidNumberException, NotApplicableOperation, InvalidVariableNameException, EmptyStackException, DivisionByZeroException, VariableExistingException, Exception {

        //(Real Part >0, Imaginary Part <0) + (Real Part<0, Imaginary Part<0).
        result.setRealPart(-11);
        result.setImaginaryPart(+3);
        a.setRealPart(1);
        a.setImaginaryPart(-3);
        b.setRealPart(-2);
        b.setImaginaryPart(-3);
        solver.getStructureStack().push(b);
        solver.getStructureStack().push(a);
        DotCommand command = new DotCommand();
        solver.resolveOperation(command);
        ComplexNumber peeked = solver.getStructureStack().peek();

        assertEquals(result.getRealPart(), peeked.getRealPart(), 4);
        assertEquals(result.getImaginaryPart(), peeked.getImaginaryPart(), 4);
    }

    @Test
    public void testDotRNegativeIPositiveRPositiveIPositive() throws InvalidNumberException, NotApplicableOperation, InvalidVariableNameException, EmptyStackException, DivisionByZeroException, VariableExistingException, Exception {
        //(Real Part <0, Imaginary Part >0) + (Real Part>0, Imaginary Part>0).
        result.setRealPart(-21);
        result.setImaginaryPart(1);
        a.setRealPart(-3);
        a.setImaginaryPart(2);
        b.setRealPart(5);
        b.setImaginaryPart(3);
        solver.getStructureStack().push(b);
        solver.getStructureStack().push(a);
        DotCommand command = new DotCommand();
        solver.resolveOperation(command);
        ComplexNumber peeked = solver.getStructureStack().peek();

        assertEquals(result.getRealPart(), peeked.getRealPart(), 4);
        assertEquals(result.getImaginaryPart(), peeked.getImaginaryPart(), 4);
    }

    @Test
    public void testDotRNegativeIPositiveRPositiveINegative() throws InvalidNumberException, NotApplicableOperation, InvalidVariableNameException, EmptyStackException, DivisionByZeroException, VariableExistingException, Exception {
        //(Real Part <0, Imaginary Part >0) + (Real Part>0, Imaginary Part<0).
        result.setRealPart(3);
        result.setImaginaryPart(9);
        a.setRealPart(-1);
        a.setImaginaryPart(2);
        b.setRealPart(3);
        b.setImaginaryPart(-3);
        solver.getStructureStack().push(b);
        solver.getStructureStack().push(a);
        DotCommand command = new DotCommand();
        solver.resolveOperation(command);
        ComplexNumber peeked = solver.getStructureStack().peek();

        assertEquals(result.getRealPart(), peeked.getRealPart(), 4);
        assertEquals(result.getImaginaryPart(), peeked.getImaginaryPart(), 4);
    }

    @Test
    public void testDotRNegativeIPositiveRNegativeIPositive() throws InvalidNumberException, NotApplicableOperation, InvalidVariableNameException, EmptyStackException, DivisionByZeroException, VariableExistingException, Exception {
        //(Real Part <0, Imaginary Part >0) + (Real Part<0, Imaginary Part>0).
        result.setRealPart(-4);
        result.setImaginaryPart(-8);
        a.setRealPart(-1);
        a.setImaginaryPart(3);
        b.setRealPart(-2);
        b.setImaginaryPart(2);

        solver.getStructureStack().push(b);
        solver.getStructureStack().push(a);
        DotCommand command = new DotCommand();
        solver.resolveOperation(command);
        ComplexNumber peeked = solver.getStructureStack().peek();

        assertEquals(result.getRealPart(), peeked.getRealPart(), 4);
        assertEquals(result.getImaginaryPart(), peeked.getImaginaryPart(), 4);
    }

    @Test
    public void testDotRNegativeIPositiveRNegativeINegative() throws InvalidNumberException, NotApplicableOperation, InvalidVariableNameException, EmptyStackException, DivisionByZeroException, VariableExistingException, Exception {
        //(Real Part <0, Imaginary Part >0) + (Real Part<0, Imaginary Part<0).
        result.setRealPart(9);
        result.setImaginaryPart(-7);
        a.setRealPart(-2);
        a.setImaginaryPart(3);
        b.setRealPart(-3);
        b.setImaginaryPart(-1);
        solver.getStructureStack().push(b);
        solver.getStructureStack().push(a);
        DotCommand command = new DotCommand();
        solver.resolveOperation(command);
        ComplexNumber peeked = solver.getStructureStack().peek();

        assertEquals(result.getRealPart(), peeked.getRealPart(), 4);
        assertEquals(result.getImaginaryPart(), peeked.getImaginaryPart(), 4);
    }

    @Test
    public void testDotRNegativeINegativeRPositiveIPositive() throws InvalidNumberException, NotApplicableOperation, InvalidVariableNameException, EmptyStackException, DivisionByZeroException, VariableExistingException, Exception {
        //(Real Part <0, Imaginary Part <0) + (Real Part>0, Imaginary Part>0).
        result.setRealPart(1);
        result.setImaginaryPart(-18);
        a.setRealPart(-2);
        a.setImaginaryPart(-3);
        b.setRealPart(4);
        b.setImaginaryPart(3);
        solver.getStructureStack().push(b);
        solver.getStructureStack().push(a);
        DotCommand command = new DotCommand();
        solver.resolveOperation(command);
        ComplexNumber peeked = solver.getStructureStack().peek();

        assertEquals(result.getRealPart(), peeked.getRealPart(), 4);
        assertEquals(result.getImaginaryPart(), peeked.getImaginaryPart(), 4);
    }

    @Test
    public void testDotRNegativeINegativeRPositiveINegative() throws InvalidNumberException, NotApplicableOperation, InvalidVariableNameException, EmptyStackException, DivisionByZeroException, VariableExistingException, Exception {
        //(Real Part <0, Imaginary Part <0) + (Real Part>0, Imaginary Part<0).

        result.setRealPart(-7);
        result.setImaginaryPart(-4);
        a.setRealPart(-1);
        a.setImaginaryPart(-2);
        b.setRealPart(3);
        b.setImaginaryPart(-2);
        solver.getStructureStack().push(b);
        solver.getStructureStack().push(a);
        DotCommand command = new DotCommand();
        solver.resolveOperation(command);
        ComplexNumber peeked = solver.getStructureStack().peek();

        assertEquals(result.getRealPart(), peeked.getRealPart(), 4);
        assertEquals(result.getImaginaryPart(), peeked.getImaginaryPart(), 4);
    }

    @Test
    public void testDotRNegativeINegativeRNegativeIPositve() throws InvalidNumberException, NotApplicableOperation, InvalidVariableNameException, EmptyStackException, DivisionByZeroException, VariableExistingException, Exception {
        //(Real Part <0, Imaginary Part <0) + (Real Part<0, Imaginary Part>0).
        result.setRealPart(3);
        result.setImaginaryPart(-1);
        a.setRealPart(-1);
        a.setImaginaryPart(-1);
        b.setRealPart(-1);
        b.setImaginaryPart(2);
        solver.getStructureStack().push(b);
        solver.getStructureStack().push(a);
        DotCommand command = new DotCommand();
        solver.resolveOperation(command);
        ComplexNumber peeked = solver.getStructureStack().peek();

        assertEquals(result.getRealPart(), peeked.getRealPart(), 4);
        assertEquals(result.getImaginaryPart(), peeked.getImaginaryPart(), 4);
    }

    @Test
    public void testDotRNegativeINegativeRNegativeINegative() throws InvalidNumberException, NotApplicableOperation, InvalidVariableNameException, EmptyStackException, DivisionByZeroException, VariableExistingException, Exception {

        //(Real Part <0, Imaginary Part <0) + (Real Part<0, Imaginary Part<0).
        result.setRealPart(-1);
        result.setImaginaryPart(3);
        a.setRealPart(-1);
        a.setImaginaryPart(-2);
        b.setRealPart(-1);
        b.setImaginaryPart(-1);
        solver.getStructureStack().push(b);
        solver.getStructureStack().push(a);
        DotCommand command = new DotCommand();
        solver.resolveOperation(command);
        ComplexNumber peeked = solver.getStructureStack().peek();

        assertEquals(result.getRealPart(), peeked.getRealPart(), 4);
        assertEquals(result.getImaginaryPart(), peeked.getImaginaryPart(), 4);
    }

    @Test
    public void testDotRPositiveIZeroRPositiveIZero() throws InvalidNumberException, NotApplicableOperation, InvalidVariableNameException, EmptyStackException, DivisionByZeroException, VariableExistingException, Exception {

        //(Real Part >0,Im=0) + (Real Part>0,Im=0)
        result.setRealPart(1);
        result.setImaginaryPart(0);
        a.setRealPart(1);
        a.setImaginaryPart(0);
        b.setRealPart(1);
        b.setImaginaryPart(0);
        solver.getStructureStack().push(b);
        solver.getStructureStack().push(a);
        DotCommand command = new DotCommand();
        solver.resolveOperation(command);
        ComplexNumber peeked = solver.getStructureStack().peek();

        assertEquals(result.getRealPart(), peeked.getRealPart(), 4);
        assertEquals(result.getImaginaryPart(), peeked.getImaginaryPart(), 4);
    }

    @Test
    public void testDotRPositiveIZeroRNegativeIZero() throws InvalidNumberException, NotApplicableOperation, InvalidVariableNameException, EmptyStackException, DivisionByZeroException, VariableExistingException, Exception {
        //(Real Part>0, Im=0) + (Real Part<0,Im=0) 
        result.setRealPart(-4);
        result.setImaginaryPart(0);
        a.setRealPart(1);
        a.setImaginaryPart(0);
        b.setRealPart(-4);
        b.setImaginaryPart(0);
        solver.getStructureStack().push(b);
        solver.getStructureStack().push(a);
        DotCommand command = new DotCommand();
        solver.resolveOperation(command);
        ComplexNumber peeked = solver.getStructureStack().peek();

        assertEquals(result.getRealPart(), peeked.getRealPart(), 4);
        assertEquals(result.getImaginaryPart(), peeked.getImaginaryPart(), 4);
    }

    @Test
    public void testDotRNegativeIZeroRNegativeIZero() throws InvalidNumberException, NotApplicableOperation, InvalidVariableNameException, EmptyStackException, DivisionByZeroException, VariableExistingException, Exception {
        //(Real Part<0, Im =0) + (Real Part<0, Im=0)
        result.setRealPart(2);
        result.setImaginaryPart(0);
        a.setRealPart(-1);
        a.setImaginaryPart(0);
        b.setRealPart(-2);
        b.setImaginaryPart(0);
        solver.getStructureStack().push(b);
        solver.getStructureStack().push(a);
        DotCommand command = new DotCommand();
        solver.resolveOperation(command);
        ComplexNumber peeked = solver.getStructureStack().peek();

        assertEquals(result.getRealPart(), peeked.getRealPart(), 4);
        assertEquals(result.getImaginaryPart(), peeked.getImaginaryPart(), 4);
    }

    @Test
    public void testDotRZeroIPositiveRZeroIPositive() throws InvalidNumberException, NotApplicableOperation, InvalidVariableNameException, EmptyStackException, DivisionByZeroException, VariableExistingException, Exception {
        // (Real Part=0, Im>0) + (Real Part=0, Im>0)
        result.setRealPart(-1);
        result.setImaginaryPart(0);
        a.setRealPart(0);
        a.setImaginaryPart(1);
        b.setRealPart(0);
        b.setImaginaryPart(1);
        solver.getStructureStack().push(b);
        solver.getStructureStack().push(a);
        DotCommand command = new DotCommand();
        solver.resolveOperation(command);
        ComplexNumber peeked = solver.getStructureStack().peek();

        assertEquals(result.getRealPart(), peeked.getRealPart(), 4);
        assertEquals(result.getImaginaryPart(), peeked.getImaginaryPart(), 4);
    }

    @Test
    public void testDotRZeroIZeroRZeroIZero() throws InvalidNumberException, NotApplicableOperation, InvalidVariableNameException, EmptyStackException, DivisionByZeroException, VariableExistingException, Exception {
        //(Real Part=0,Im =0) + (Real Part=0, Im=0)
        result.setRealPart(0);
        result.setImaginaryPart(0);
        a.setRealPart(0);
        a.setImaginaryPart(0);
        b.setRealPart(0);
        b.setImaginaryPart(0);
        solver.getStructureStack().push(b);
        solver.getStructureStack().push(a);
        DotCommand command = new DotCommand();
        solver.resolveOperation(command);
        ComplexNumber peeked = solver.getStructureStack().peek();

        assertEquals(result.getRealPart(), peeked.getRealPart(), 4);
        assertEquals(result.getImaginaryPart(), peeked.getImaginaryPart(), 4);
    }

    @Test
    public void testDotRNonZeroIZeroRZeroINonZero() throws InvalidNumberException, NotApplicableOperation, InvalidVariableNameException, EmptyStackException, DivisionByZeroException, VariableExistingException, Exception {
        //(Real Part!=0,Im =0) + (Real Part=0, Im!=0)
        result.setRealPart(0);
        result.setImaginaryPart(3);
        a.setRealPart(1);
        a.setImaginaryPart(0);
        b.setRealPart(0);
        b.setImaginaryPart(3);
        solver.getStructureStack().push(b);
        solver.getStructureStack().push(a);
        DotCommand command = new DotCommand();
        solver.resolveOperation(command);
        ComplexNumber peeked = solver.getStructureStack().peek();

        assertEquals(result.getRealPart(), peeked.getRealPart(), 4);
        assertEquals(result.getImaginaryPart(), peeked.getImaginaryPart(), 4);
    }

    @Test
    public void testDotOpposite() throws InvalidNumberException, NotApplicableOperation, InvalidVariableNameException, EmptyStackException, DivisionByZeroException, VariableExistingException, Exception {
        //(Real Part=A,Im =B) + (Real Part=A, Im=B)
        result.setRealPart(1);
        result.setImaginaryPart(0);
        a.setRealPart(1);
        a.setImaginaryPart(2);
        b.setRealPart(0.2);
        b.setImaginaryPart(-0.4);
        solver.getStructureStack().push(b);
        solver.getStructureStack().push(a);
        DotCommand command = new DotCommand();
        solver.resolveOperation(command);
        ComplexNumber peeked = solver.getStructureStack().peek();

        assertEquals(result.getRealPart(), peeked.getRealPart(), 4);
        assertEquals(result.getImaginaryPart(), peeked.getImaginaryPart(), 4);
    }



}
