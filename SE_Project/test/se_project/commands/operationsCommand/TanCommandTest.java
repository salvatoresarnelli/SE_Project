package se_project.commands.operationsCommand;

import java.util.LinkedList;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import se_project.ComplexNumber;
import se_project.Operations;
import se_project.Solver;
import se_project.commands.OperationCommand;
import se_project.commands.trascendental.CosCommand;
import se_project.commands.trascendental.SinCommand;
import se_project.commands.trascendental.TanCommand;
import se_project.exceptions.DivisionByZeroException;
import se_project.exceptions.InvalidNumberException;
import se_project.exceptions.InvalidVariableNameException;
import se_project.exceptions.NotApplicableOperation;
import se_project.exceptions.UndefinedPhaseException;
import se_project.exceptions.VariableExistingException;
import se_project.parser.ComplexNumberParser;
import se_project.parser.ParserString;

/**
 *
 * @author pionp
 */
public class TanCommandTest {
    
    ComplexNumber a, result;
    Solver solver;
    
    public TanCommandTest() {

    }

    @Before
    public void setUp() {
        
        a = new ComplexNumber();
        result = new ComplexNumber();
        solver = Solver.getInstance();
    
    }

    @After
    public void tearDown() {
    }

    /*----------------------------TAN----------------------------------------*/
    @Test
    public void testTanCommandNegative_Negative() throws InvalidNumberException, DivisionByZeroException, NotApplicableOperation, InvalidVariableNameException, UndefinedPhaseException, VariableExistingException, Exception {
        //tan(Real Part <0, Imaginary Part <0).
        result.setRealPart(0.0024985707289502767);
        result.setImaginaryPart(-0.9989268648704096);
        a.setRealPart(-5.7);
        a.setImaginaryPart(-3.3);
        solver.getStructureStack().push(a);
        TanCommand command = new TanCommand();
        solver.resolveOperation(command);
        ComplexNumber peeked = solver.getStructureStack().peek();
        assertEquals(result.getRealPart(), peeked.getRealPart(), 4);
        assertEquals(result.getImaginaryPart(), peeked.getImaginaryPart(), 4);
    }
    
    @Test
    public void testTanCommandNPositive_Positive() throws InvalidNumberException, DivisionByZeroException, NotApplicableOperation, InvalidVariableNameException, UndefinedPhaseException, VariableExistingException, Exception {
        //tan(Real Part >0, Imaginary Part >0).
        result.setRealPart(0.004568446118239934);
        result.setImaginaryPart(+0.9874122587394989);
        a.setRealPart(9.6);
        a.setImaginaryPart(2.5);
        solver.getStructureStack().push(a);
        TanCommand command = new TanCommand();
        solver.resolveOperation(command);
        ComplexNumber peeked = solver.getStructureStack().peek();
        assertEquals(result.getRealPart(), peeked.getRealPart(), 4);
        assertEquals(result.getImaginaryPart(), peeked.getImaginaryPart(), 4);
    }
    
    @Test
    public void testTanCommandPositive_Negative() throws InvalidNumberException, DivisionByZeroException, NotApplicableOperation, InvalidVariableNameException, UndefinedPhaseException, VariableExistingException, Exception {
        //tan(Real Part >0, Imaginary Part <0).
        result.setRealPart(0.004568446118239934);
        result.setImaginaryPart(-0.9874122587394989);
        a.setRealPart(9.6);
        a.setImaginaryPart(-2.5);
        solver.getStructureStack().push(a);
        TanCommand command = new TanCommand();
        solver.resolveOperation(command);
        ComplexNumber peeked = solver.getStructureStack().peek();
        assertEquals(result.getRealPart(), peeked.getRealPart(), 4);
        assertEquals(result.getImaginaryPart(), peeked.getImaginaryPart(), 4);
    }
    
    @Test
        public void testTanCommandNegative_Positive() throws InvalidNumberException, DivisionByZeroException, NotApplicableOperation, InvalidVariableNameException, UndefinedPhaseException, VariableExistingException, Exception {
        //tan(Real Part <0, Imaginary Part >0).
        result.setRealPart(0.0024985707289502767);
        result.setImaginaryPart(0.9989268648704096);
        a.setRealPart(-5.7);
        a.setImaginaryPart(3.3);
        solver.getStructureStack().push(a);
        TanCommand command = new TanCommand();
        solver.resolveOperation(command);
        ComplexNumber peeked = solver.getStructureStack().peek();
        assertEquals(result.getRealPart(), peeked.getRealPart(), 4);
        assertEquals(result.getImaginaryPart(), peeked.getImaginaryPart(), 4);
    }
    @Test
    public void testTanCommandPNegative_1() throws InvalidNumberException, DivisionByZeroException, NotApplicableOperation, InvalidVariableNameException, UndefinedPhaseException, VariableExistingException, Exception {
        //tan(Real Part <0, Imaginary Part =0).         
        a.setRealPart(-6.7);
        result.setRealPart(-0.4427574167327162);
        solver.getStructureStack().push(a);
        TanCommand command = new TanCommand();
        solver.resolveOperation(command);
        ComplexNumber peeked = solver.getStructureStack().peek();
        assertEquals(result.getRealPart(), peeked.getRealPart(), 4);
        assertEquals(result.getImaginaryPart(), peeked.getImaginaryPart(), 4);
    }
    
    @Test
    public void testTanCommandPositive_1() throws InvalidNumberException, DivisionByZeroException, NotApplicableOperation, InvalidVariableNameException, UndefinedPhaseException, VariableExistingException, Exception {
        //tan(Real Part =0, Imaginary Part >0).         
        a.setImaginaryPart(8.8);
        result.setImaginaryPart(0.999999954559081);
        solver.getStructureStack().push(a);
        TanCommand command = new TanCommand();
        solver.resolveOperation(command);
        ComplexNumber peeked = solver.getStructureStack().peek();
        assertEquals(result.getRealPart(), peeked.getRealPart(), 4);
        assertEquals(result.getImaginaryPart(), peeked.getImaginaryPart(), 4);
    }
    
    @Test
    public void testTanCommandNegative_2() throws InvalidNumberException, DivisionByZeroException, NotApplicableOperation, InvalidVariableNameException, UndefinedPhaseException, VariableExistingException, Exception {
        //tan(Real Part =0, Imaginary Part <0).         
        a.setImaginaryPart(-3.4);
        result.setImaginaryPart(-0.9977749279342795);
        solver.getStructureStack().push(a);
        TanCommand command = new TanCommand();
        solver.resolveOperation(command);
        ComplexNumber peeked = solver.getStructureStack().peek();
        assertEquals(result.getRealPart(), peeked.getRealPart(), 4);
        assertEquals(result.getImaginaryPart(), peeked.getImaginaryPart(), 4);
    }
    
    @Test
    public void testTanCommandPositive_2() throws InvalidNumberException, DivisionByZeroException, NotApplicableOperation, InvalidVariableNameException, UndefinedPhaseException, VariableExistingException, Exception {
        //tan(Real Part >0, Imaginary Part =0).         
        a.setRealPart(0.8);
        result.setRealPart(1.0296385570503641);
        solver.getStructureStack().push(a);
        TanCommand command = new TanCommand();
        solver.resolveOperation(command);
        ComplexNumber peeked = solver.getStructureStack().peek();
        assertEquals(result.getRealPart(), peeked.getRealPart(), 4);
        assertEquals(result.getImaginaryPart(), peeked.getImaginaryPart(), 4);
    }
}