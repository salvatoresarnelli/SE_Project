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
public class CosCommandTest {
    
    ComplexNumber a, result;
    Solver solver;
    
    public CosCommandTest() {

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

    /*----------------------------COS----------------------------------------*/
    @Test
    public void testCosCommandNegative_Negative() throws InvalidNumberException, DivisionByZeroException, NotApplicableOperation, InvalidVariableNameException, UndefinedPhaseException, VariableExistingException, Exception {
        //cos(Real Part <0, Imaginary Part <0).
        result.setRealPart(11.331026594588057);
        result.setImaginaryPart(7.45511362411162);
        a.setRealPart(-5.7);
        a.setImaginaryPart(-3.3);
        solver.getStructureStack().push(a);
        CosCommand command = new CosCommand();
        solver.resolveOperation(command);
        ComplexNumber peeked = solver.getStructureStack().peek();
        assertEquals(result.getRealPart(), peeked.getRealPart(), 4);
        assertEquals(result.getImaginaryPart(), peeked.getImaginaryPart(), 4);
    }
    
    @Test
    public void testCosCommandNPositive_Positive() throws InvalidNumberException, DivisionByZeroException, NotApplicableOperation, InvalidVariableNameException, UndefinedPhaseException, VariableExistingException, Exception {
        //cos(Real Part >0, Imaginary Part >0).
        result.setRealPart(-6.038390978838917);
        result.setImaginaryPart(+1.0547126729205143);
        a.setRealPart(9.6);
        a.setImaginaryPart(2.5);
        solver.getStructureStack().push(a);
        CosCommand command = new CosCommand();
        solver.resolveOperation(command);
        ComplexNumber peeked = solver.getStructureStack().peek();
        assertEquals(result.getRealPart(), peeked.getRealPart(), 4);
        assertEquals(result.getImaginaryPart(), peeked.getImaginaryPart(), 4);
    }
    
    @Test
    public void testCosCommandPositive_Negative() throws InvalidNumberException, DivisionByZeroException, NotApplicableOperation, InvalidVariableNameException, UndefinedPhaseException, VariableExistingException, Exception {
        //cos(Real Part >0, Imaginary Part <0).
        result.setRealPart(-6.038390978838917);
        result.setImaginaryPart(-1.0547126729205143);
        a.setRealPart(9.6);
        a.setImaginaryPart(-2.5);
        solver.getStructureStack().push(a);
        CosCommand command = new CosCommand();
        solver.resolveOperation(command);
        ComplexNumber peeked = solver.getStructureStack().peek();
        assertEquals(result.getRealPart(), peeked.getRealPart(), 4);
        assertEquals(result.getImaginaryPart(), peeked.getImaginaryPart(), 4);
    }
    
    @Test
        public void testCosCommandNegative_Positive() throws InvalidNumberException, DivisionByZeroException, NotApplicableOperation, InvalidVariableNameException, UndefinedPhaseException, VariableExistingException, Exception {
        //cos(Real Part <0, Imaginary Part >0).
        result.setRealPart(11.331026594588057);
        result.setImaginaryPart(-7.45511362411162);
        a.setRealPart(-5.7);
        a.setImaginaryPart(3.3);
        solver.getStructureStack().push(a);
        CosCommand command = new CosCommand();
        solver.resolveOperation(command);
        ComplexNumber peeked = solver.getStructureStack().peek();
        assertEquals(result.getRealPart(), peeked.getRealPart(), 4);
        assertEquals(result.getImaginaryPart(), peeked.getImaginaryPart(), 4);
    }
    @Test
    public void testCosCommandPNegative_1() throws InvalidNumberException, DivisionByZeroException, NotApplicableOperation, InvalidVariableNameException, UndefinedPhaseException, VariableExistingException, Exception {
        //cos(Real Part <0, Imaginary Part =0).         
        a.setRealPart(-6.7);
        result.setRealPart(0.9143831482353194);
        solver.getStructureStack().push(a);
        CosCommand command = new CosCommand();
        solver.resolveOperation(command);
        ComplexNumber peeked = solver.getStructureStack().peek();
        assertEquals(result.getRealPart(), peeked.getRealPart(), 4);
        assertEquals(result.getImaginaryPart(), peeked.getImaginaryPart(), 4);
    }
    
    @Test
    public void testCosCommandPositive_1() throws InvalidNumberException, DivisionByZeroException, NotApplicableOperation, InvalidVariableNameException, UndefinedPhaseException, VariableExistingException, Exception {
        //cos(Real Part =0, Imaginary Part >0).         
        a.setImaginaryPart(8.8);
        result.setRealPart(3317.1220785054825);
        solver.getStructureStack().push(a);
        CosCommand command = new CosCommand();
        solver.resolveOperation(command);
        ComplexNumber peeked = solver.getStructureStack().peek();
        assertEquals(result.getRealPart(), peeked.getRealPart(), 4);
        assertEquals(result.getImaginaryPart(), peeked.getImaginaryPart(), 4);
    }
    
    @Test
    public void testCosCommandNegative_2() throws InvalidNumberException, DivisionByZeroException, NotApplicableOperation, InvalidVariableNameException, UndefinedPhaseException, VariableExistingException, Exception {
        //cos(Real Part =0, Imaginary Part <0).         
        a.setImaginaryPart(-3.4);
        result.setRealPart(14.998736658678668);
        solver.getStructureStack().push(a);
        CosCommand command = new CosCommand();
        solver.resolveOperation(command);
        ComplexNumber peeked = solver.getStructureStack().peek();
        assertEquals(result.getRealPart(), peeked.getRealPart(), 4);
        assertEquals(result.getImaginaryPart(), peeked.getImaginaryPart(), 4);
    }
    
    @Test
    public void testCosCommandPositive_2() throws InvalidNumberException, DivisionByZeroException, NotApplicableOperation, InvalidVariableNameException, UndefinedPhaseException, VariableExistingException, Exception {
        //cos(Real Part <0, Imaginary Part =0).         
        a.setRealPart(0.8);
        result.setRealPart(0.6967067093471654);
        solver.getStructureStack().push(a);
        CosCommand command = new CosCommand();
        solver.resolveOperation(command);
        ComplexNumber peeked = solver.getStructureStack().peek();
        assertEquals(result.getRealPart(), peeked.getRealPart(), 4);
        assertEquals(result.getImaginaryPart(), peeked.getImaginaryPart(), 4);
    }
}