/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se_project;

import java.util.LinkedList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.rules.ExpectedException;
import se_project.exceptions.EmptyStackException;
import se_project.exceptions.InvalidOperationException;
import sun.rmi.runtime.Log;

/**
 *
 * @author Salvatore Sarnelli
 */
public class StackTest {

    Stack stack;

    public StackTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        stack = new Stack();
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of push method, of class Stack.
     */
    @Test
    public void testPush() {
        ComplexNumber c = new ComplexNumber(1, 2);
        boolean expResult = true;
        boolean result = stack.push(c);

        assertEquals(expResult, result);

        ComplexNumber c2 = null;
        boolean result2 = stack.push(c2);
        assertNotEquals(result2, expResult);

    }

    /**
     * Test of size method, of class Stack.
     */
    @Test
    public void testSize() {
        int expected = 0;
        int result = stack.size();
        assertEquals(expected, result);

        stack.push(new ComplexNumber(1, 0));
        int expected2 = 1;
        int result2 = stack.size();
        assertEquals(expected2, result2);

    }

    /**
     * Test of pop method, of class Stack.
     */
    @Test
    public void testPop() throws Exception {
        ComplexNumber c = new ComplexNumber(2, 4);
        ComplexNumber expResult = c;
        boolean ris = stack.push(c);
        ComplexNumber result = stack.pop();
        assertEquals(expResult, result);

    }

    /**
     * Test of pop method expecting an Empty Stack Exception, of class Stack
     */
    @Test(expected = EmptyStackException.class)
    public void testPopException() throws Exception {
        ComplexNumber result = stack.pop();
    }

    /**
     * Test of peek method, of class Stack.
     */
    @Test
    public void testPeek() throws Exception {
        ComplexNumber c = new ComplexNumber(3, 0);
        ComplexNumber expected = c;
        boolean success = stack.push(c);
        ComplexNumber result = stack.peek();
        assertEquals(expected, result);

    }

    /**
     * Test of peek method expecting an Empty Stack Exception, of class Stack
     */
    @Test(expected = EmptyStackException.class)
    public void testPeekException() throws Exception {
        ComplexNumber result = stack.peek();
    }

    /**
     * Test of isEmpty method, of class Stack.
     */
    @Test
    public void testIsEmpty() {
        boolean expected = true;
        boolean result = stack.isEmpty();
        assertEquals(expected, result);

        boolean ret = stack.push(new ComplexNumber(0, 0));
        boolean result2 = stack.isEmpty();
        assertNotEquals(expected, result2);
    }

    /**
     * Test of fromListToStack method, of class Stack
     */
    @Test
    public void testFromListToStack() {
        boolean expected = true;
        LinkedList<ComplexNumber> list = new LinkedList<>();
        list.addLast(new ComplexNumber(0, 0));

        list.addLast(new ComplexNumber(3, 6));

        boolean result = stack.fromListToStack(list);
        assertEquals(expected, result);

        boolean result2 = stack.fromListToStack(null);
        assertNotEquals(expected, result2);
    }

    /**
     * Test of clear method, of class Stack
     */
    @Test
    public void testClear() throws EmptyStackException {
        boolean expected = true;
        boolean num1_return = stack.push(new ComplexNumber(1, 4));
        boolean num2_return = stack.push(new ComplexNumber(0, 5));

        boolean clear_return = stack.clear();
        assertEquals(expected, clear_return);

        boolean num3_return = stack.push(new ComplexNumber(0, 0));
        boolean num4_return = stack.push(new ComplexNumber(6, 11));
        ComplexNumber c = stack.pop();
        boolean clear_return_2 = stack.clear();
        assertEquals(expected, clear_return_2);

    }

    /**
     * Test of clear method expecting an Empty Stack Exception, of class Stack
     */
    @Test(expected = EmptyStackException.class)
    public void testClearException() throws EmptyStackException {
        boolean result = stack.clear();
    }

    /**
     * Test of duplicate method , of class Stack
     */
    @Test
    public void testDuplicate() throws EmptyStackException {
        boolean expected = true;
        boolean num1_return = stack.push(new ComplexNumber(3, 6));

        boolean result = stack.duplicate();
        assertEquals(expected, result);
    }

    /**
     * Test of duplicate method expecting an Empty Stack Exception, of class
     * Stack
     */
    @Test(expected = EmptyStackException.class)
    public void testDuplicateException() throws EmptyStackException {
        stack.duplicate();
    }

    /**
     * Test of drop method, of class Stack
     */
    @Test
    public void testDrop() throws EmptyStackException {
        boolean expected = true;
        boolean num1_return = stack.push(new ComplexNumber(3, 0));
        boolean num2_return = stack.push(new ComplexNumber(5, 2));

        boolean drop_return = stack.drop();
        assertEquals(expected, drop_return);
    }

    /**
     * Test of drop method expecting an Empty Stack Exception, of class Stack
     */
    @Test(expected = EmptyStackException.class)
    public void testDropException() throws EmptyStackException {
        stack.drop();
    }

    /**
     * Test of swap method, of class Stack
     */
    @Test
    public void testSwap() throws InvalidOperationException, EmptyStackException {
        boolean expected = true;
        boolean num1_result = stack.push(new ComplexNumber(3, 1));
        boolean num2_result = stack.push(new ComplexNumber(6, 2));

        boolean swap_result = stack.swap();
        assertEquals(expected, swap_result);
    }

    /**
     * Test of swap method expecting an Empty Stack Exception, of class Stack
     */
    @Test(expected = InvalidOperationException.class)
    public void testSwapException() throws InvalidOperationException, EmptyStackException {
        boolean num1_result = stack.push(new ComplexNumber(7, 9));
        stack.swap();
    }

    /**
     * Test of over method, of class Stack
     */
    @Test
    public void testOver() throws EmptyStackException, InvalidOperationException {

        boolean expected = true;
        boolean num1_result = stack.push(new ComplexNumber(5, 15));
        boolean num2_result = stack.push(new ComplexNumber(9, 31));

        boolean result_over = stack.over();
        assertEquals(expected, result_over);
    }

    /**
     * Test of over method expecting an Empty Stack Exception, of class Stack
     */
    @Test(expected = InvalidOperationException.class)
    public void testOverException() throws EmptyStackException, InvalidOperationException {
        boolean num1_result = stack.push(new ComplexNumber(20, 6));
        stack.over();
    }

}
