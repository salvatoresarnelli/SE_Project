/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package se_project.commands.variablesCommands;

import java.util.NoSuchElementException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import se_project.ComplexNumber;
import se_project.Record;
import se_project.Solver;
import se_project.VariablesDict;
import se_project.VariablesStack;

/**
 *
 * @author Salvatore Sarnelli
 */
public class RestoreVariableCommandTest {
    
    Solver solver;
    VariablesDict dictionary;
    VariablesStack stack;
    
    public RestoreVariableCommandTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        solver = Solver.getInstance();
        dictionary = VariablesDict.getInstance();
        stack = VariablesStack.getInstance();
    }
    
    @After
    public void tearDown() {
    }
    
    /** Test nel caso in cui lo stack delle variabili sia vuoto
    * 
    */
    
    @Test(expected = NoSuchElementException.class)
    public void executeWithEmptyStack() throws Exception {
    RestoreVariableCommand command = new RestoreVariableCommand();
    command.setDictionary(dictionary);
    command.setVariablesStack(stack);
    command.execute();
    
    }
    
    @Test
    public void executeWithFullStack() throws Exception {
        RestoreVariableCommand command = new RestoreVariableCommand();
        dictionary.getTable().clear();
        int value = 1;
        for (char c = 'a'; c <= 'z'; c++) {
            dictionary.getTable().put(c, new ComplexNumber(value, 0));
            value++;
        }
        stack.pushVariablesSnapShot(dictionary);
        command.setDictionary(dictionary);
        command.setVariablesStack(stack);
        Object result = command.execute();
        assertEquals(result, true);
        assertEquals(stack.length(), 0);
    }
    
}
