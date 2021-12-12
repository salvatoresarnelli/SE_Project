/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se_project.commands.variablesCommands;

import java.util.NoSuchElementException;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import se_project.ComplexNumber;
import se_project.Record;
import se_project.Solver;
import se_project.VariablesDict;
import se_project.VariablesStack;

/**
 *
 * @author aless
 */
public class SaveVariableCommandTest {

    Solver solver;
    VariablesDict dictionary;
    VariablesStack stack;

    public SaveVariableCommandTest() {

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

    @Test
    public void executeWithEmptyStack() throws Exception {
        SaveVariableCommand command = new SaveVariableCommand();
        dictionary.getTable().put('a', new ComplexNumber(0, 0));
        while (stack.length() > 0) {
            stack.popVariableSnapShot();
        }
        command.setDictionary(dictionary);
        command.setVariablesStack(stack);
        command.execute();
        assertEquals(stack.length(),1);
        

    }

    @Test
    public void executeWithEmptyDict() throws Exception {
        SaveVariableCommand command = new SaveVariableCommand();
        dictionary.getTable().clear();

        command.setDictionary(dictionary);
        command.setVariablesStack(stack);
        command.execute();
        Record recorded = stack.popVariableSnapShot();
        for (char c : recorded.getDictRecord().keySet()) {
            assertNull(recorded.getDictRecord().get(c));
        }
    }

    @Test
    public void executeWithFullDict() throws Exception {

        SaveVariableCommand command = new SaveVariableCommand();
        dictionary.getTable().clear();
        int value = 1;
        for (char c = 'a'; c <= 'z'; c++) {
            dictionary.getTable().put(c, new ComplexNumber(value, 0));
            value++;
        }
        command.setDictionary(dictionary);
        command.setVariablesStack(stack);
        command.execute();
        Record recorded = stack.popVariableSnapShot();
        for (char c : recorded.getDictRecord().keySet()) {
            assertEquals(dictionary.getTable().get(c),recorded.getDictRecord().get(c));
        }
    }

}
