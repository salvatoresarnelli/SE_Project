/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se_project.commands.stackCommands;

import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import se_project.ComplexNumber;
import se_project.Stack;
import se_project.exceptions.EmptyStackException;

/**
 *
 * @author aless
 */
public class ClearCommandTest {

    private Stack stack;
    private Stack stack_empty;

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
        stack = new Stack();
        stack.push(new ComplexNumber(3, 4));
        stack.push(new ComplexNumber(1, 10));
        stack.push(new ComplexNumber(5, 0));
        stack.push(new ComplexNumber(3, 50));
        stack_empty = new Stack();
    }

    @After
    public void tearDown() throws Exception {
    }

    /**
     * Test of execute method, of class ClearCommand.
     */
    @Test
    public void testExecute() throws Exception {
        System.out.println("execute");
        ClearCommand instance = new ClearCommand(stack);
        Boolean expResult = true;
        Boolean result = instance.execute();
        assertEquals(expResult, result);
        assertEquals(expResult, stack.isEmpty());
    }

    @Test(expected = se_project.exceptions.EmptyStackException.class)
    public void testExecuteWithException() throws EmptyStackException {
        ClearCommand instance = new ClearCommand(stack_empty);
        Boolean result = instance.execute();
    }

}
