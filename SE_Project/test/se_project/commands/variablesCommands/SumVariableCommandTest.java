/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se_project.commands.variablesCommands;

import org.junit.After;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import se_project.ComplexNumber;
import se_project.Solver;
import se_project.VariablesDict;
import se_project.exceptions.DivisionByZeroException;
import se_project.exceptions.EmptyStackException;
import se_project.exceptions.InterruptedExecutionException;
import se_project.exceptions.InvalidNumberException;
import se_project.exceptions.InvalidValueException;
import se_project.exceptions.InvalidVariableNameException;
import se_project.exceptions.NonExistingVariable;
import se_project.exceptions.UndefinedPhaseException;
import se_project.exceptions.VariableExistingException;

/**
 *
 * @author pionp
 */
public class SumVariableCommandTest {
    
    VariablesDict dict;
    Solver solver;

    public SumVariableCommandTest() {

    }

    @Before
    public void setUp() {
        dict =  VariablesDict.getInstance();
        solver = Solver.getInstance();
    }

    @After
    public void tearDown() {
    }

    /*----------------------------SUMVARIABLE----------------------------------------*/
    @Test
    public void sumVariableCommandTest_1() throws VariableExistingException, InvalidVariableNameException, NonExistingVariable, InvalidValueException, InvalidNumberException, EmptyStackException, UndefinedPhaseException, DivisionByZeroException, InterruptedExecutionException, Exception {
        //Variable x + (Real Part >0 + Imaginary Part >0)
        solver.getStructureStack().push(new ComplexNumber(1,1));
        SumVariableCommand command = new SumVariableCommand();
        command.setDictionary(dict);
        command.setVariable('x');
        dict.forceSettingVariable('x', new ComplexNumber(1,1));
        solver.resolveOperation(command);
        ComplexNumber number = new ComplexNumber(2,2);
        solver.getStructureStack().push(number);
        ComplexNumber result = dict.getVariableValue('x');      
        assertEquals(result,number);
    }
    
    @Test
    public void sumVariableCommandTest_2() throws VariableExistingException, InvalidVariableNameException, NonExistingVariable, InvalidValueException, InvalidNumberException, EmptyStackException, UndefinedPhaseException, DivisionByZeroException, InterruptedExecutionException, Exception {
        //Variable x + (Real Part <0 + Imaginary Part <0)
        solver.getStructureStack().push(new ComplexNumber(1,1));
        SumVariableCommand command = new SumVariableCommand();
        command.setDictionary(dict);
        command.setVariable('x');
        dict.forceSettingVariable('x', new ComplexNumber(-1,-1));
        solver.resolveOperation(command);
        ComplexNumber number = new ComplexNumber(0,0);
        solver.getStructureStack().push(number);
        ComplexNumber result = dict.getVariableValue('x');      
        assertEquals(result,number);
    }
    
    @Test
    public void sumVariableCommandTest_3() throws VariableExistingException, InvalidVariableNameException, NonExistingVariable, InvalidValueException, InvalidNumberException, EmptyStackException, UndefinedPhaseException, DivisionByZeroException, InterruptedExecutionException, Exception {
        //Variable x + (Real Part >0 + Imaginary Part <0)
        solver.getStructureStack().push(new ComplexNumber(1,1));
        SumVariableCommand command = new SumVariableCommand();
        command.setDictionary(dict);
        command.setVariable('x');
        dict.forceSettingVariable('x', new ComplexNumber(1,-1));
        solver.resolveOperation(command);
        ComplexNumber number = new ComplexNumber(2,0);
        solver.getStructureStack().push(number);
        ComplexNumber result = dict.getVariableValue('x');      
        assertEquals(result,number);
    }
    
    @Test
    public void sumVariableCommandTest_4() throws VariableExistingException, InvalidVariableNameException, NonExistingVariable, InvalidValueException, InvalidNumberException, EmptyStackException, UndefinedPhaseException, DivisionByZeroException, InterruptedExecutionException, Exception {
        //Variable x + (Real Part <0 + Imaginary Part >0)
        solver.getStructureStack().push(new ComplexNumber(1,1));
        SumVariableCommand command = new SumVariableCommand();
        command.setDictionary(dict);
        command.setVariable('x');
        dict.forceSettingVariable('x', new ComplexNumber(-1,1));
        solver.resolveOperation(command);
        ComplexNumber number = new ComplexNumber(0,2);
        solver.getStructureStack().push(number);
        ComplexNumber result = dict.getVariableValue('x');      
        assertEquals(result,number);
    }
    
    @Test
    public void sumVariableCommandTest_5() throws VariableExistingException, InvalidVariableNameException, NonExistingVariable, InvalidValueException, InvalidNumberException, EmptyStackException, UndefinedPhaseException, DivisionByZeroException, InterruptedExecutionException, Exception {
        //Variable x + (Real Part >0 + Imaginary Part =0)
        solver.getStructureStack().push(new ComplexNumber(1,1));
        SumVariableCommand command = new SumVariableCommand();
        command.setDictionary(dict);
        command.setVariable('x');
        dict.forceSettingVariable('x', new ComplexNumber(1,0));
        solver.resolveOperation(command);
        ComplexNumber number = new ComplexNumber(2,1);
        solver.getStructureStack().push(number);
        ComplexNumber result = dict.getVariableValue('x');      
        assertEquals(result,number);
    }
    
    @Test
    public void sumVariableCommandTest_6() throws VariableExistingException, InvalidVariableNameException, NonExistingVariable, InvalidValueException, InvalidNumberException, EmptyStackException, UndefinedPhaseException, DivisionByZeroException, InterruptedExecutionException, Exception {
        //Variable x + (Real Part =0 + Imaginary Part >0)
        solver.getStructureStack().push(new ComplexNumber(1,1));
        SumVariableCommand command = new SumVariableCommand();
        command.setDictionary(dict);
        command.setVariable('x');
        dict.forceSettingVariable('x', new ComplexNumber(0,1));
        solver.resolveOperation(command);
        ComplexNumber number = new ComplexNumber(1,2);
        solver.getStructureStack().push(number);
        ComplexNumber result = dict.getVariableValue('x');      
        assertEquals(result,number);
    }
}
