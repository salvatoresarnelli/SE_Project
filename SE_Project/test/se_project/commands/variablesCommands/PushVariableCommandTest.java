/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se_project.commands.variablesCommands;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import se_project.ComplexNumber;

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
    @Test
    public void testExecute() throws Exception {
        System.out.println("execute");
        PushVariableCommand instance = new PushVariableCommand();
        ComplexNumber expResult = null;
        ComplexNumber result = instance.execute();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class PushVariableCommand.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        PushVariableCommand instance = new PushVariableCommand();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
