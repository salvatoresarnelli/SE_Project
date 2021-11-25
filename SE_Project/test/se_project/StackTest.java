/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se_project;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.rules.ExpectedException;
import se_project.exceptions.EmptyStackException;
import sun.rmi.runtime.Log;

/**
 *
 * @author Salvatore Sarnelli
 */
public class StackTest {
    
    Stack stack;
    
    @Rule
    public ExpectedException exceptionPop = ExpectedException.none();
    
    @Rule
    public ExpectedException exceptionPeek = ExpectedException.none();
    
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
        
        stack.push(new ComplexNumber(1,0));
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
        
        exceptionPop.expect(EmptyStackException.class);
        ComplexNumber result2 = stack.pop();
      
    }

    /**
     * Test of peek method, of class Stack.
     */
    @Test
    public void testPeek() throws Exception {
        ComplexNumber c = new ComplexNumber(3,0);
        ComplexNumber expected = c;
        boolean success = stack.push(c);
        ComplexNumber result = stack.peek();
        assertEquals(expected, result);
        
        ComplexNumber number = stack.pop();
        
        exceptionPeek.expect(EmptyStackException.class);
        ComplexNumber result2 = stack.peek();
    }

    /**
     * Test of isEmpty method, of class Stack.
     */
    @Test
    public void testIsEmpty() {
        boolean expected = true;
        boolean result = stack.isEmpty();
        assertEquals(expected, result);
        
        boolean ret = stack.push(new ComplexNumber(0,0));
        boolean result2 = stack.isEmpty();
        assertNotEquals(expected, result2);
    }

}