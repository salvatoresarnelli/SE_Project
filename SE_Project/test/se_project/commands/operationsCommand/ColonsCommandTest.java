/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se_project.commands.operationsCommand;

import java.util.LinkedList;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import se_project.ComplexNumber;
import se_project.Operations;
import se_project.Solver;
import se_project.commands.operationsCommands.ColonsCommand;
import se_project.commands.operationsCommands.DotCommand;
import se_project.exceptions.DivisionByZeroException;
import se_project.exceptions.InvalidNumberException;
import se_project.exceptions.InvalidVariableNameException;
import se_project.exceptions.NotApplicableOperation;
import se_project.exceptions.UndefinedPhaseException;
import se_project.exceptions.VariableExistingException;

/**
 *
 * @author aless
 */
public class ColonsCommandTest {

    ComplexNumber a, b, result;
    Solver solver;

    public ColonsCommandTest() {

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

    /*----------------------------DIVISION----------------------------------------*/
    @Test
    public void testDivisionRPositiveIPositiveRPositiveINegative() throws InvalidNumberException, UndefinedPhaseException, DivisionByZeroException, NotApplicableOperation, InvalidVariableNameException, VariableExistingException, Exception {
        //(Real Part >0, Imaginary Part >0) + (Real Part>0, Imaginary Part<0).
        result.setRealPart(-0.7500);
        result.setImaginaryPart(1.2500);
        a.setRealPart(1);
        a.setImaginaryPart(4);
        b.setRealPart(2);
        b.setImaginaryPart(-2);
        solver.getStructureStack().push(b);
        solver.getStructureStack().push(a);
        ColonsCommand command = new ColonsCommand();
        solver.resolveOperation(command);
        ComplexNumber peeked = solver.getStructureStack().peek();

        assertEquals(result.getRealPart(), peeked.getRealPart(), 4);
        assertEquals(result.getImaginaryPart(), peeked.getImaginaryPart(), 4);

    }

    @Test
    public void testDivisionRPositiveIPositiveRNegativeIPositive() throws InvalidNumberException, UndefinedPhaseException, DivisionByZeroException, NotApplicableOperation, InvalidVariableNameException, VariableExistingException, Exception {
        //(Real Part >0, Imaginary Part >0) + (Real Part<0, Imaginary Part>0).
        result.setRealPart(0.2);
        result.setImaginaryPart(-0.6);
        a.setRealPart(1);
        a.setImaginaryPart(1);
        b.setRealPart(-1);
        b.setImaginaryPart(2);
        solver.getStructureStack().push(b);
        solver.getStructureStack().push(a);
        ColonsCommand command = new ColonsCommand();
        solver.resolveOperation(command);
        ComplexNumber peeked = solver.getStructureStack().peek();

        assertEquals(result.getRealPart(), peeked.getRealPart(), 4);
        assertEquals(result.getImaginaryPart(), peeked.getImaginaryPart(), 4);
    }

    @Test
    public void testDivisionRPositiveIPositiveRNegativeINegative() throws InvalidNumberException, UndefinedPhaseException, DivisionByZeroException, NotApplicableOperation, InvalidVariableNameException, VariableExistingException, Exception {
        //(Real Part >0, Imaginary Part >0) + (Real Part<0, Imaginary Part<0).
        result.setRealPart(-2);
        result.setImaginaryPart(0);
        a.setRealPart(10);
        a.setImaginaryPart(10);
        b.setRealPart(-5);
        b.setImaginaryPart(-5);
        solver.getStructureStack().push(b);
        solver.getStructureStack().push(a);
        ColonsCommand command = new ColonsCommand();
        solver.resolveOperation(command);
        ComplexNumber peeked = solver.getStructureStack().peek();

        assertEquals(result.getRealPart(), peeked.getRealPart(), 4);
        assertEquals(result.getImaginaryPart(), peeked.getImaginaryPart(), 4);

    }

    @Test
    public void testDivisionRPositiveINegativeRPositiveIPositive() throws InvalidNumberException, UndefinedPhaseException, DivisionByZeroException, NotApplicableOperation, InvalidVariableNameException, VariableExistingException, Exception {
        //(Real Part >0, Imaginary Part <0) + (Real Part>0, Imaginary Part>0).
        result.setRealPart(0);
        result.setImaginaryPart(-1);
        a.setRealPart(2);
        a.setImaginaryPart(-3);
        b.setRealPart(3);
        b.setImaginaryPart(2);
        solver.getStructureStack().push(b);
        solver.getStructureStack().push(a);
        ColonsCommand command = new ColonsCommand();
        solver.resolveOperation(command);
        ComplexNumber peeked = solver.getStructureStack().peek();

        assertEquals(result.getRealPart(), peeked.getRealPart(), 4);
        assertEquals(result.getImaginaryPart(), peeked.getImaginaryPart(), 4);

    }

    @Test

    public void testDivisionRPositiveINegativeRPositiveINegative() throws InvalidNumberException, UndefinedPhaseException, DivisionByZeroException, NotApplicableOperation, InvalidVariableNameException, VariableExistingException, Exception {    //(Real Part >0, Imaginary Part <0) + (Real Part>0, Imaginary Part<0).
        result.setRealPart(1.3846);
        result.setImaginaryPart(-0.0769);
        a.setRealPart(4);
        a.setImaginaryPart(-3);
        b.setRealPart(3);
        b.setImaginaryPart(-2);
        solver.getStructureStack().push(b);
        solver.getStructureStack().push(a);
        ColonsCommand command = new ColonsCommand();
        solver.resolveOperation(command);
        ComplexNumber peeked = solver.getStructureStack().peek();

        assertEquals(result.getRealPart(), peeked.getRealPart(), 4);
        assertEquals(result.getImaginaryPart(), peeked.getImaginaryPart(), 4);
    }

    @Test

    public void testDivisionRPositiveINegativeRNegativeIPositive() throws InvalidNumberException, UndefinedPhaseException, DivisionByZeroException, NotApplicableOperation, InvalidVariableNameException, VariableExistingException, Exception {
        //(Real Part >0, Imaginary Part <0) + (Real Part<0, Imaginary Part>0).
        result.setRealPart(-0.6154);
        result.setImaginaryPart(0.077);
        a.setRealPart(1);
        a.setImaginaryPart(-2);
        b.setRealPart(-2);
        b.setImaginaryPart(3);
        solver.getStructureStack().push(b);
        solver.getStructureStack().push(a);
        ColonsCommand command = new ColonsCommand();
        solver.resolveOperation(command);
        ComplexNumber peeked = solver.getStructureStack().peek();

        assertEquals(result.getRealPart(), peeked.getRealPart(), 4);
        assertEquals(result.getImaginaryPart(), peeked.getImaginaryPart(), 4);
    }

    @Test

    public void testDivisionRPositiveINegativeRNegativeINegative() throws InvalidNumberException, UndefinedPhaseException, DivisionByZeroException, NotApplicableOperation, InvalidVariableNameException, VariableExistingException, Exception {
        //(Real Part >0, Imaginary Part <0) + (Real Part<0, Imaginary Part<0).
        result.setRealPart(0.5385);
        result.setImaginaryPart(0.6923);
        a.setRealPart(1);
        a.setImaginaryPart(-3);
        b.setRealPart(-2);
        b.setImaginaryPart(-3);
        solver.getStructureStack().push(b);
        solver.getStructureStack().push(a);
        ColonsCommand command = new ColonsCommand();
        solver.resolveOperation(command);
        ComplexNumber peeked = solver.getStructureStack().peek();

        assertEquals(result.getRealPart(), peeked.getRealPart(), 4);
        assertEquals(result.getImaginaryPart(), peeked.getImaginaryPart(), 4);
    }

    @Test

    public void testDivisionRNegativeIPositiveRPositiveIPositive() throws InvalidNumberException, UndefinedPhaseException, DivisionByZeroException, NotApplicableOperation, InvalidVariableNameException, VariableExistingException, Exception {
        //(Real Part <0, Imaginary Part >0) + (Real Part>0, Imaginary Part>0).
        result.setRealPart(-0.2647);

        result.setImaginaryPart(0.5588);
        a.setRealPart(-3);
        a.setImaginaryPart(2);
        b.setRealPart(5);
        b.setImaginaryPart(3);
        solver.getStructureStack().push(b);
        solver.getStructureStack().push(a);
        ColonsCommand command = new ColonsCommand();
        solver.resolveOperation(command);
        ComplexNumber peeked = solver.getStructureStack().peek();

        assertEquals(result.getRealPart(), peeked.getRealPart(), 4);
        assertEquals(result.getImaginaryPart(), peeked.getImaginaryPart(), 4);

    }

    @Test

    public void testDivisionRNegativeIPositiveRPositiveINegative() throws InvalidNumberException, UndefinedPhaseException, DivisionByZeroException, NotApplicableOperation, InvalidVariableNameException, VariableExistingException, Exception {

        //(Real Part <0, Imaginary Part >0) + (Real Part>0, Imaginary Part<0).
        result.setRealPart(-0.5000);
        result.setImaginaryPart(0.1667);
        a.setRealPart(-1);
        a.setImaginaryPart(2);
        b.setRealPart(3);
        b.setImaginaryPart(-3);
        solver.getStructureStack().push(b);
        solver.getStructureStack().push(a);
        ColonsCommand command = new ColonsCommand();
        solver.resolveOperation(command);
        ComplexNumber peeked = solver.getStructureStack().peek();

        assertEquals(result.getRealPart(), peeked.getRealPart(), 4);
        assertEquals(result.getImaginaryPart(), peeked.getImaginaryPart(), 4);

    }

    @Test

    public void testDivisionRNegativeIPositiveRNegativeIPositive() throws InvalidNumberException, UndefinedPhaseException, DivisionByZeroException, NotApplicableOperation, InvalidVariableNameException, VariableExistingException, Exception {

        //(Real Part <0, Imaginary Part >0) + (Real Part<0, Imaginary Part>0).
        result.setRealPart(1.0000);
        result.setImaginaryPart(-0.5);
        a.setRealPart(-1);
        a.setImaginaryPart(3);
        b.setRealPart(-2);
        b.setImaginaryPart(2);
        solver.getStructureStack().push(b);
        solver.getStructureStack().push(a);
        ColonsCommand command = new ColonsCommand();
        solver.resolveOperation(command);
        ComplexNumber peeked = solver.getStructureStack().peek();

        assertEquals(result.getRealPart(), peeked.getRealPart(), 4);
        assertEquals(result.getImaginaryPart(), peeked.getImaginaryPart(), 4);

    }

    @Test

    public void testDivisionRNegativeIPositiveRNegativeINegative() throws InvalidNumberException, UndefinedPhaseException, DivisionByZeroException, NotApplicableOperation, InvalidVariableNameException, VariableExistingException, Exception {
        //(Real Part <0, Imaginary Part >0) + (Real Part<0, Imaginary Part<0).
        result.setRealPart(0.3000);
        result.setImaginaryPart(-1.1000);
        a.setRealPart(-2);
        a.setImaginaryPart(3);
        b.setRealPart(-3);
        b.setImaginaryPart(-1);
        solver.getStructureStack().push(b);
        solver.getStructureStack().push(a);
        ColonsCommand command = new ColonsCommand();
        solver.resolveOperation(command);
        ComplexNumber peeked = solver.getStructureStack().peek();

        assertEquals(result.getRealPart(), peeked.getRealPart(), 4);
        assertEquals(result.getImaginaryPart(), peeked.getImaginaryPart(), 4);

    }

    @Test

    public void testDivisionRNegativeINegativeRPositiveIPositive() throws InvalidNumberException, UndefinedPhaseException, DivisionByZeroException, NotApplicableOperation, InvalidVariableNameException, VariableExistingException, Exception {
        //(Real Part <0, Imaginary Part <0) + (Real Part>0, Imaginary Part>0).
        result.setRealPart(-0.6800);
        result.setImaginaryPart(-0.2400);
        a.setRealPart(-2);
        a.setImaginaryPart(-3);
        b.setRealPart(4);
        b.setImaginaryPart(3);
        solver.getStructureStack().push(b);
        solver.getStructureStack().push(a);
        ColonsCommand command = new ColonsCommand();
        solver.resolveOperation(command);
        ComplexNumber peeked = solver.getStructureStack().peek();

        assertEquals(result.getRealPart(), peeked.getRealPart(), 4);
        assertEquals(result.getImaginaryPart(), peeked.getImaginaryPart(), 4);
    }

    @Test

    public void testDivisionRNegativeINegativeRPositiveINegative() throws InvalidNumberException, UndefinedPhaseException, DivisionByZeroException, NotApplicableOperation, InvalidVariableNameException, VariableExistingException, Exception {
        //(Real Part <0, Imaginary Part <0) + (Real Part>0, Imaginary Part<0).

        result.setRealPart(0.0769);
        result.setImaginaryPart(-0.6154);
        a.setRealPart(-1);
        a.setImaginaryPart(-2);
        b.setRealPart(3);
        b.setImaginaryPart(-2);
        solver.getStructureStack().push(b);
        solver.getStructureStack().push(a);
        ColonsCommand command = new ColonsCommand();
        solver.resolveOperation(command);
        ComplexNumber peeked = solver.getStructureStack().peek();

        assertEquals(result.getRealPart(), peeked.getRealPart(), 4);
        assertEquals(result.getImaginaryPart(), peeked.getImaginaryPart(), 4);

    }

    @Test
    public void testDivisionRNegativeINegativeRNegativeIPositve() throws InvalidNumberException, UndefinedPhaseException, DivisionByZeroException, NotApplicableOperation, InvalidVariableNameException, VariableExistingException, Exception {
        //(Real Part <0, Imaginary Part <0) + (Real Part<0, Imaginary Part>0).
        result.setRealPart(-0.2000);
        result.setImaginaryPart(0.6000);
        a.setRealPart(-1);
        a.setImaginaryPart(-1);
        b.setRealPart(-1);
        b.setImaginaryPart(2);
        solver.getStructureStack().push(b);
        solver.getStructureStack().push(a);
        ColonsCommand command = new ColonsCommand();
        solver.resolveOperation(command);
        ComplexNumber peeked = solver.getStructureStack().peek();

        assertEquals(result.getRealPart(), peeked.getRealPart(), 4);
        assertEquals(result.getImaginaryPart(), peeked.getImaginaryPart(), 4);

    }

    @Test

    public void testDivisionRNegativeINegativeRNegativeINegative() throws InvalidNumberException, UndefinedPhaseException, DivisionByZeroException, NotApplicableOperation, InvalidVariableNameException, VariableExistingException, Exception {

        //(Real Part <0, Imaginary Part <0) + (Real Part<0, Imaginary Part<0).
        result.setRealPart(1.5000);
        result.setImaginaryPart(0.5000);
        a.setRealPart(-1);
        a.setImaginaryPart(-2);
        b.setRealPart(-1);
        b.setImaginaryPart(-1);
        solver.getStructureStack().push(b);
        solver.getStructureStack().push(a);
        ColonsCommand command = new ColonsCommand();
        solver.resolveOperation(command);
        ComplexNumber peeked = solver.getStructureStack().peek();

        assertEquals(result.getRealPart(), peeked.getRealPart(), 4);
        assertEquals(result.getImaginaryPart(), peeked.getImaginaryPart(), 4);

    }

    @Test

    public void testDivisionRPositiveIZeroRPositiveIZero() throws InvalidNumberException, UndefinedPhaseException, DivisionByZeroException, NotApplicableOperation, InvalidVariableNameException, VariableExistingException, Exception {

        //(Real Part >0,Im=0) + (Real Part>0,Im=0)
        result.setRealPart(1);
        result.setImaginaryPart(0);
        a.setRealPart(1);
        a.setImaginaryPart(0);
        b.setRealPart(1);
        b.setImaginaryPart(0);
        solver.getStructureStack().push(b);
        solver.getStructureStack().push(a);
        ColonsCommand command = new ColonsCommand();
        solver.resolveOperation(command);
        ComplexNumber peeked = solver.getStructureStack().peek();

        assertEquals(result.getRealPart(), peeked.getRealPart(), 4);
        assertEquals(result.getImaginaryPart(), peeked.getImaginaryPart(), 4);
    }

    @Test
    public void testDivisionRPositiveIZeroRNegativeIZero() throws InvalidNumberException, UndefinedPhaseException, DivisionByZeroException, NotApplicableOperation, InvalidVariableNameException, VariableExistingException, Exception {
        //(Real Part>0, Im=0) + (Real Part<0,Im=0) 
        result.setRealPart(-0.25);
        result.setImaginaryPart(0);
        a.setRealPart(1);
        a.setImaginaryPart(0);
        b.setRealPart(-4);
        b.setImaginaryPart(0);
        solver.getStructureStack().push(b);
        solver.getStructureStack().push(a);
        ColonsCommand command = new ColonsCommand();
        solver.resolveOperation(command);
        ComplexNumber peeked = solver.getStructureStack().peek();

        assertEquals(result.getRealPart(), peeked.getRealPart(), 4);
        assertEquals(result.getImaginaryPart(), peeked.getImaginaryPart(), 4);

    }

    @Test

    public void testDivisionRNegativeIZeroRNegativeIZero() throws InvalidNumberException, UndefinedPhaseException, DivisionByZeroException, NotApplicableOperation, InvalidVariableNameException, VariableExistingException, Exception {
        //(Real Part<0, Im =0) + (Real Part<0, Im=0)
        result.setRealPart(0.5);
        result.setImaginaryPart(0);
        a.setRealPart(-1);
        a.setImaginaryPart(0);
        b.setRealPart(-2);
        b.setImaginaryPart(0);
        solver.getStructureStack().push(b);
        solver.getStructureStack().push(a);
        ColonsCommand command = new ColonsCommand();
        solver.resolveOperation(command);
        ComplexNumber peeked = solver.getStructureStack().peek();

        assertEquals(result.getRealPart(), peeked.getRealPart(), 4);
        assertEquals(result.getImaginaryPart(), peeked.getImaginaryPart(), 4);

    }

    @Test

    public void testDivisionRZeroIPositiveRZeroIPositive() throws InvalidNumberException, UndefinedPhaseException, DivisionByZeroException, NotApplicableOperation, InvalidVariableNameException, VariableExistingException, Exception {
        // (Real Part=0, Im>0) + (Real Part=0, Im>0)
        result.setRealPart(1);
        result.setImaginaryPart(0);
        a.setRealPart(0);
        a.setImaginaryPart(1);
        b.setRealPart(0);
        b.setImaginaryPart(1);
        solver.getStructureStack().push(b);
        solver.getStructureStack().push(a);
        ColonsCommand command = new ColonsCommand();
        solver.resolveOperation(command);
        ComplexNumber peeked = solver.getStructureStack().peek();

        assertEquals(result.getRealPart(), peeked.getRealPart(), 4);
        assertEquals(result.getImaginaryPart(), peeked.getImaginaryPart(), 4);

    }

    @Test(expected = DivisionByZeroException.class)

    public void testDivisionRZeroIZeroRZeroIZero() throws InvalidNumberException, UndefinedPhaseException, DivisionByZeroException, NotApplicableOperation, InvalidVariableNameException, VariableExistingException, Exception {
        //(Real Part=0,Im =0) + (Real Part=0, Im=0)
        a.setRealPart(0);
        a.setImaginaryPart(0);
        b.setRealPart(0);
        b.setImaginaryPart(0);
        solver.getStructureStack().push(b);
        solver.getStructureStack().push(a);
        ColonsCommand command = new ColonsCommand();
        solver.resolveOperation(command);

    }

    @Test

    public void testDivisionRNonZeroIZeroRZeroINonZero() throws InvalidNumberException, UndefinedPhaseException, DivisionByZeroException, NotApplicableOperation, InvalidVariableNameException, VariableExistingException, Exception {
        //(Real Part!=0,Im =0) + (Real Part=0, Im!=0)
        result.setRealPart(0);
        result.setImaginaryPart(-0.3333);
        a.setRealPart(1);
        a.setImaginaryPart(0);
        b.setRealPart(0);
        b.setImaginaryPart(3);
        solver.getStructureStack().push(b);
        solver.getStructureStack().push(a);
        ColonsCommand command = new ColonsCommand();
        solver.resolveOperation(command);
        ComplexNumber peeked = solver.getStructureStack().peek();

        assertEquals(result.getRealPart(), peeked.getRealPart(), 4);
        assertEquals(result.getImaginaryPart(), peeked.getImaginaryPart(), 4);

    }

    @Test

    public void testDivisionOpposite() throws InvalidNumberException, UndefinedPhaseException, DivisionByZeroException, NotApplicableOperation, InvalidVariableNameException, VariableExistingException, Exception {

//(Real Part=A,Im =B) + (Real Part=-A, Im=-B)
        result.setRealPart(1);
        result.setImaginaryPart(0);
        a.setRealPart(6);
        a.setImaginaryPart(7);
        b.setRealPart(6);
        b.setImaginaryPart(7);
        solver.getStructureStack().push(b);
        solver.getStructureStack().push(a);
        ColonsCommand command = new ColonsCommand();
        solver.resolveOperation(command);
        ComplexNumber peeked = solver.getStructureStack().peek();

        assertEquals(result.getRealPart(), peeked.getRealPart(), 4);
        assertEquals(result.getImaginaryPart(), peeked.getImaginaryPart(), 4);
    }


}
