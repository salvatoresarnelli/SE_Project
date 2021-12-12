/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se_project.commands.operationsCommand;

import java.util.LinkedList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import se_project.ComplexNumber;
import se_project.Operations;
import se_project.Solver;
import se_project.commands.operationsCommands.DotCommand;
import se_project.commands.operationsCommands.SignCommand;
import se_project.commands.operationsCommands.SqrtCommand;
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
public class SqrtCommandTest {
     ComplexNumber a;
    Solver solver;

    public SqrtCommandTest() {

    }

    @Before
    public void setUp() {
        a = new ComplexNumber();
        solver = Solver.getInstance();
    }

     /*----------------------------SQRT----------------------------------------*/
    @Test
    public void testSqrtRNegativeIZero() throws InvalidNumberException, NotApplicableOperation, InvalidVariableNameException, UndefinedPhaseException, DivisionByZeroException, VariableExistingException, Exception {

        LinkedList<ComplexNumber> expectedResults = new LinkedList<>();
        expectedResults.add(new ComplexNumber(0, 2));
        expectedResults.add(new ComplexNumber(0, -2));
        a.setRealPart(-4);
        a.setImaginaryPart(0);
        solver.getStructureStack().push(a);
        SqrtCommand command = new SqrtCommand();
        solver.resolveOperation(command);
        LinkedList<ComplexNumber> actualResults = new LinkedList<>();
        for(int i=0;i<2;i++)
               actualResults.add(solver.getStructureStack().pop());
        expectedResults.forEach(number -> {
            assertTrue(actualResults.contains(number));
        });
    }

    @Test
    public void testSqrtRPositiveIZero() throws InvalidNumberException, NotApplicableOperation, InvalidVariableNameException, UndefinedPhaseException, DivisionByZeroException, VariableExistingException, Exception {

        LinkedList<ComplexNumber> expectedResults = new LinkedList<>();
        expectedResults.add(new ComplexNumber(2, 0));
        expectedResults.add(new ComplexNumber(-2, 0));
        a.setRealPart(4);
        a.setImaginaryPart(0);
        solver.getStructureStack().push(a);
        SqrtCommand command = new SqrtCommand();
        solver.resolveOperation(command);
        LinkedList<ComplexNumber> actualResults = new LinkedList<>();
        for(int i=0;i<2;i++)
               actualResults.add(solver.getStructureStack().pop());
        expectedResults.forEach(number -> {
            assertTrue(actualResults.contains(number));
        });
    }

    @Test
    public void testSqrtRZeroIPositive() throws InvalidNumberException, NotApplicableOperation, InvalidVariableNameException, UndefinedPhaseException, DivisionByZeroException, VariableExistingException, Exception {

        LinkedList<ComplexNumber> expectedResults = new LinkedList<>();
        expectedResults.add(new ComplexNumber(1.4142, 1.4142));
        expectedResults.add(new ComplexNumber(-1.4142, -1.4142));
        a.setRealPart(0);
        a.setImaginaryPart(4);
        solver.getStructureStack().push(a);
        SqrtCommand command = new SqrtCommand();
        solver.resolveOperation(command);
        LinkedList<ComplexNumber> actualResults = new LinkedList<>();
        for(int i=0;i<2;i++)
               actualResults.add(solver.getStructureStack().pop());
        expectedResults.forEach(number -> {
            assertTrue(actualResults.contains(number));
        });
    }

    @Test
    public void testSqrtRZeroINegative() throws InvalidNumberException, NotApplicableOperation, InvalidVariableNameException, UndefinedPhaseException, DivisionByZeroException, VariableExistingException, Exception {

        LinkedList<ComplexNumber> expectedResults = new LinkedList<>();
        expectedResults.add(new ComplexNumber(1.4142, -1.4142));
        expectedResults.add(new ComplexNumber(-1.4142, 1.4142));
        a.setRealPart(0);
        a.setImaginaryPart(-4);
      solver.getStructureStack().push(a);
        SqrtCommand command = new SqrtCommand();
        solver.resolveOperation(command);
        LinkedList<ComplexNumber> actualResults = new LinkedList<>();
        for(int i=0;i<2;i++)
               actualResults.add(solver.getStructureStack().pop());
        expectedResults.forEach(number -> {
            assertTrue(actualResults.contains(number));
        });
    }

    @Test
    public void testSqrtRPositiveIPositive() throws InvalidNumberException, NotApplicableOperation, InvalidVariableNameException, UndefinedPhaseException, DivisionByZeroException, VariableExistingException, Exception {

        LinkedList<ComplexNumber> expectedResults = new LinkedList<>();
        expectedResults.add(new ComplexNumber(1.5538, 0.6436));
        expectedResults.add(new ComplexNumber(-1.5538, -0.6436));
        a.setRealPart(2);
        a.setImaginaryPart(2);
       solver.getStructureStack().push(a);
        SqrtCommand command = new SqrtCommand();
        solver.resolveOperation(command);
        LinkedList<ComplexNumber> actualResults = new LinkedList<>();
        for(int i=0;i<2;i++)
               actualResults.add(solver.getStructureStack().pop());
        expectedResults.forEach(number -> {
            assertTrue(actualResults.contains(number));
        });
    }

    @Test
    public void testSqrtRNegativeIPositive() throws InvalidNumberException, NotApplicableOperation, InvalidVariableNameException, UndefinedPhaseException, DivisionByZeroException, VariableExistingException, Exception {

        LinkedList<ComplexNumber> expectedResults = new LinkedList<>();
        expectedResults.add(new ComplexNumber(0.6436, 1.5538));
        expectedResults.add(new ComplexNumber(-0.6436, -1.5538));
        a.setRealPart(-2);
        a.setImaginaryPart(2);
        solver.getStructureStack().push(a);
        SqrtCommand command = new SqrtCommand();
        solver.resolveOperation(command);
        LinkedList<ComplexNumber> actualResults = new LinkedList<>();
        for(int i=0;i<2;i++)
               actualResults.add(solver.getStructureStack().pop());
        expectedResults.forEach(number -> {
            assertTrue(actualResults.contains(number));
        });
    }

    @Test 
    public void testSqrtPhaseUndefined() throws InvalidNumberException, NotApplicableOperation, InvalidVariableNameException, UndefinedPhaseException, DivisionByZeroException, VariableExistingException, Exception {

        LinkedList<ComplexNumber> expectedResults = new LinkedList<>();
        expectedResults.add(new ComplexNumber(0, 0));
        a.setRealPart(0);
        a.setImaginaryPart(0);
        solver.getStructureStack().push(a);
        SqrtCommand command = new SqrtCommand();
        solver.resolveOperation(command);
        LinkedList<ComplexNumber> actualResults = new LinkedList<>();
        actualResults.add(solver.getStructureStack().pop());
        expectedResults.forEach(number -> {
            assertTrue(actualResults.contains(number));
        });
    }

    @Test
    public void testSqrtRNegativeINegative() throws InvalidNumberException, NotApplicableOperation, InvalidVariableNameException, UndefinedPhaseException, DivisionByZeroException, VariableExistingException, Exception {

        LinkedList<ComplexNumber> expectedResults = new LinkedList<>();

        expectedResults.add(new ComplexNumber(0.6436, -1.5538));
        expectedResults.add(new ComplexNumber(-0.6436, +1.5538));
        a.setRealPart(-2);
        a.setImaginaryPart(-2);
        solver.getStructureStack().push(a);
        SqrtCommand command = new SqrtCommand();
        solver.resolveOperation(command);
        LinkedList<ComplexNumber> actualResults = new LinkedList<>();
        for(int i=0;i<2;i++)
               actualResults.add(solver.getStructureStack().pop());
        expectedResults.forEach(number -> {
            assertTrue(actualResults.contains(number));
        });
    }
 
}
