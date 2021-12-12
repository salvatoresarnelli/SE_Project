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
public class DropCommandTest {

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
        stack.push(new ComplexNumber(3, 6));
        stack.push(new ComplexNumber(6, 1));
        stack.push(new ComplexNumber(9, 6));
        stack.push(new ComplexNumber(10, 0));

        stack_empty = new Stack();
    }

    @After
    public void tearDown() throws Exception {
    }

    /**
     * Test of execute method, of class DropCommand.
     */
    @Test
    public void testExecute() throws Exception {
        System.out.println("execute");
        DropCommand instance = new DropCommand(stack);
        Boolean expResult = true;
        Boolean result = instance.execute();
        assertEquals(expResult, result);
        assertEquals(expResult, stack.drop());
    }

    @Test(expected = EmptyStackException.class)
    public void testExecuteWithException() throws EmptyStackException {
        DropCommand instance = new DropCommand(stack_empty);
        Boolean result = instance.execute();
    }

}
