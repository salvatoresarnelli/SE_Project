/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se_project.commands;

import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import se_project.ComplexNumber;
import se_project.Stack;
import se_project.commands.OperationCommand;

/**
 *
 * @author aless
 */
public class InsertNumberCommandTest{
    private Stack stack;

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
        stack = new Stack();
        stack.push(new ComplexNumber(3, 3));
        stack.push(new ComplexNumber(4 , 3));
        
    }

    @After
    public void tearDown() throws Exception {
    }

    /**
     * Test del metodo Execute in cui viene inserito un numero complesso
     * all'interno dello stack presente all'interno dell'oggetto.
     */
    @Test
    public void testExecute() throws Exception {
        System.out.println("execute");
        InsertNumberCommand instance = new InsertNumberCommand(new ComplexNumber(0, 3), stack);
        Object expResult = true;
        Object result = instance.execute();
        assertEquals(expResult, result);
        assertEquals(stack.pop().getRealPart(), 0, 0);
        assertEquals(stack.pop().getImaginaryPart(), 3, 0);
        instance = new InsertNumberCommand(new ComplexNumber(3, 3), stack);
        result = instance.execute();
        assertEquals(expResult, result);
        assertEquals(stack.pop().getRealPart(), 3, 0);
        assertEquals(stack.pop().getImaginaryPart(), 3 , 0);
        
        
    }

    /**
     *  * Test del metodo GetNumber utilizzato per ottenere il numero presente all'interno del comando.
     */
    @Test
    public void testGetNumber() {
        System.out.println("getNumber");
        InsertNumberCommand instance = new InsertNumberCommand(new ComplexNumber(6, 7));
        ComplexNumber expResult = new ComplexNumber(6, 7);
        ComplexNumber result = instance.getNumber();
        assertEquals(expResult, result);
       
    }

    
}
