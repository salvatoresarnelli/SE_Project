/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se_project;

import org.junit.After;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import se_project.exceptions.InvalidNumberException;
import se_project.exceptions.InvalidValueException;
import se_project.exceptions.InvalidVariableNameException;
import se_project.exceptions.NonExistingVariable;
import se_project.exceptions.VariableExistingException;

/**
 *
 * @author aless
 */
public class VariablesDictTest {

    VariablesDict dict;

    public VariablesDictTest() {

    }

    @Before
    public void setUp() {
        dict = new VariablesDict();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void checkCorrectVariableNameTest() throws VariableExistingException, InvalidVariableNameException, NonExistingVariable, InvalidValueException {
        char input = 'x';
        ComplexNumber value = new ComplexNumber(2, 0);
        dict.setVariable(input, value);
        ComplexNumber number = dict.getVariableValue(input);
        assertEquals(value, number);

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
   

    /*
    private void checkName(char var) throws InvalidVariableNameException {
        if (!((var >= 'a') && (var <= 'z'))) {
            throw new InvalidVariableNameException();
        }
    }

    public void setVariable(char var, ComplexNumber value) throws VariableExistingException, InvalidVariableNameException {
        checkName(var);
        if (table.containsKey(var)) {
            throw new VariableExistingException();
        } else {
            table.put(var, value);
        }
    }

    public void forceSettingVariable(char var, ComplexNumber value) throws InvalidVariableNameException {
        checkName(var);
        table.put(var, value);
    }

    public ComplexNumber getVariableValue(char var) throws InvalidVariableNameException, NonExistingVariable {
        checkName(var);
        if(!table.containsKey(var))
            throw new NonExistingVariable();
        return table.get(var);
    }
     */
   

}
