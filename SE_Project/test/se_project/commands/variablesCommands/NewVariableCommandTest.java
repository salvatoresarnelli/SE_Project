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
 * @author aless
 */
public class NewVariableCommandTest {
        VariablesDict dict;
        Solver solver;

    public NewVariableCommandTest() {

    }

    @Before
    public void setUp() {
        dict = new VariablesDict();
        solver = Solver.getInstance();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void checkCorrectVariableNameStackNotEmptyTest() throws VariableExistingException, InvalidVariableNameException, NonExistingVariable, InvalidValueException, InvalidNumberException, EmptyStackException, UndefinedPhaseException, DivisionByZeroException, InterruptedExecutionException, Exception {
        solver.getStructureStack().push(new ComplexNumber(0,0));
        solver.getStructureStack().push(new ComplexNumber(1,1));
        solver.getStructureStack().push(new ComplexNumber(2,2));
        solver.getStructureStack().push(new ComplexNumber(3,3));
        solver.getStructureStack().push(new ComplexNumber(4,4));

        NewVariableCommand command = new NewVariableCommand();
        command.setDictionary(dict);
        command.setVariable('x');
        ComplexNumber number = solver.getStructureStack().pop();
        solver.getStructureStack().push(number);
        
        solver.resolveOperation(command);
        ComplexNumber result = dict.getVariableValue('x');
        
        assertEquals(result,number);
    }

    @Test(expected = InvalidVariableNameException.class)
    public void checkUnaccettableNameWithNumberTest() throws VariableExistingException, InvalidVariableNameException, InvalidValueException {
        char input = '2';
        ComplexNumber value = new ComplexNumber(2, 0);
        dict.setVariable(input, value);
    }

    @Test(expected = InvalidVariableNameException.class)
    public void checkUnaccettableNameWithSignTest() throws VariableExistingException, InvalidVariableNameException, InvalidValueException {
        char input = '?';
        ComplexNumber value = new ComplexNumber(2, 0);
        dict.setVariable(input, value);

    }

    @Test(expected = InvalidValueException.class)
    public void checkAccettableNameWithNullTest() throws VariableExistingException, InvalidVariableNameException, InvalidValueException {
        char input = 'a';
        dict.setVariable(input, null);

    }
    @Test(expected = NonExistingVariable.class)
    public void getNonExistingVariableTest() throws NonExistingVariable, VariableExistingException, InvalidVariableNameException, InvalidValueException {
        char input = 'a';
        dict.setVariable(input, new ComplexNumber(0,0));
        dict.getVariableValue('b');

    }
    
        @Test(expected = VariableExistingException.class)
    public void insertInExistingVariableTest() throws NonExistingVariable, VariableExistingException, InvalidVariableNameException, InvalidValueException {
        char input = 'a';
        dict.setVariable(input, new ComplexNumber(0,0));
        dict.setVariable(input,new ComplexNumber(1,1));
    }
    @Test
      public void overrideVariableTest() throws NonExistingVariable, VariableExistingException, InvalidVariableNameException, InvalidValueException {
        char input = 'c';
        ComplexNumber expected = new ComplexNumber(0,0);
        dict.setVariable(input, new ComplexNumber(10,10));
        dict.forceSettingVariable(input, new ComplexNumber(0,0));
        ComplexNumber result = dict.getVariableValue(input);
        assertEquals(expected, result);
    }

}
