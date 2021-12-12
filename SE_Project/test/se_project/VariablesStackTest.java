/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se_project;

import java.util.HashMap;
import java.util.NoSuchElementException;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import se_project.exceptions.EmptyStackException;
import se_project.exceptions.InvalidNumberException;
import se_project.exceptions.InvalidValueException;
import se_project.exceptions.InvalidVariableNameException;
import se_project.exceptions.NonExistingVariable;
import se_project.exceptions.VariableExistingException;

/**
 *
 * @author aless
 */
public class VariablesStackTest {

    VariablesStack variablesStack;
    VariablesDict dict;

    public VariablesStackTest() {

    }

    @Before
    public void setUp() {
        variablesStack = VariablesStack.getInstance();
        dict = VariablesDict.getInstance();

    }

    @After
    public void tearDown() {
    }

    @Test(expected = NullPointerException.class)
    public void pushSnapShotTest() throws InvalidValueException {
        variablesStack.pushVariablesSnapShot(null);
    }

    @Test
    public void pushSnapShotTestWorking() throws InvalidValueException, InvalidVariableNameException, VariableExistingException {
        dict.setVariable('a', new ComplexNumber(0, 0));
        variablesStack.pushVariablesSnapShot(dict);
    }
    
    @Test 
    public void popSnapShotTestWorking() throws InvalidValueException, InvalidVariableNameException, VariableExistingException {
        dict.getTable().clear();
        dict.setVariable('a', new ComplexNumber(0, 0));
        variablesStack.pushVariablesSnapShot(dict);
        Record record = variablesStack.popVariableSnapShot();
        for (char carattere : record.getDictRecord().keySet()){
            if(record.getDictRecord().get(carattere)!=null){
                assertTrue(dict.getTable().containsKey(carattere));
                assertEquals(dict.getTable().get(carattere),record.getDictRecord().get(carattere));
            }
            
        }
    }
    
        @Test (expected = NoSuchElementException.class)
    public void popSnapShotEmptyTest() throws InvalidValueException, InvalidVariableNameException, VariableExistingException {
        dict.getTable().clear();
        while(variablesStack.length()>0)
            variablesStack.popVariableSnapShot();
        Record record = variablesStack.popVariableSnapShot();
        
    }
    
    

   
}
