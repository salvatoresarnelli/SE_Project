/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se_project.commands.variablesCommands;

import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import se_project.ComplexNumber;
import se_project.Solver;
import se_project.VariablesDict;

/**
 *
 * @author aless
 */
public class PushVariableCommandTest {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    /**
     * Test of execute method, of class PushVariableCommand.
     */
    @Test (expected = NullPointerException.class)
    public void testExecute() throws Exception {
        System.out.println("execute");
        PushVariableCommand instance = new PushVariableCommand();
        ComplexNumber expResult = null;
        ComplexNumber result = instance.execute();
        // TODO review the generated test code and remove the default call to fail.
    }

    public void executePushWorkingTest() throws Exception {
        
        Solver solver = Solver.getInstance();
        //inserisco una variabile
        solver.getStructureStack().push(new ComplexNumber(1,1));
        //associo il valore di questa variabile alla variabile "a"
        NewVariableCommand command = new NewVariableCommand();
        command.setVariable('a');
        command.setDictionary(VariablesDict.getInstance());
        solver.resolveOperation(command);
        
        PushVariableCommand instance = new PushVariableCommand();
        instance.setVariable('a');
        assertEquals(VariablesDict.getInstance().getVariableValue('a'),solver.getStructureStack().pop());
        // TODO review the generated test code and remove the default call to fail.
    }
    /**
     * Test of toString method, of class PushVariableCommand.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        PushVariableCommand instance = new PushVariableCommand();
        String result = instance.toString();
        assertTrue(result.isEmpty());
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
