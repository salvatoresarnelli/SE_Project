/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se_project.commands.stackCommands;

import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import se_project.ComplexNumber;
import se_project.Stack;
import se_project.exceptions.EmptyStackException;
import se_project.exceptions.InvalidOperationException;

/**
 *
 * @author aless
 */
public class OverCommandTest {

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
        stack.push(new ComplexNumber(3, 8));
        stack.push(new ComplexNumber(10, 4));
        stack.push(new ComplexNumber(9, 21));
        stack.push(new ComplexNumber(2, 7));

        stack_empty = new Stack();
    }

    @After
    public void tearDown() throws Exception {
    }

    /**
     * Test of execute method, of class OverCommand.
     */
    @Test
    public void testExecute() throws Exception {
        System.out.println("execute");
        OverCommand instance = new OverCommand(stack);
        Boolean expResult = true;
        Boolean result = instance.execute();
        assertEquals(expResult, result);
        assertEquals(expResult, stack.over());
    }

    @Test(expected = EmptyStackException.class)
    public void testExecuteWithEmptyStackException() throws EmptyStackException, InvalidOperationException {
        OverCommand instance = new OverCommand(stack_empty);
        Boolean result = instance.execute();
    }

    @Test(expected = InvalidOperationException.class)
    public void testExecuteWithInvalidOperationException() throws EmptyStackException, InvalidOperationException {
        OverCommand instance = new OverCommand(stack_empty);
        stack_empty.push(new ComplexNumber(3, 7));
        Boolean result = instance.execute();
    }

}
