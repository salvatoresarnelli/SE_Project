/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se_project.commands.userDefinedOperations;

import java.util.LinkedList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import se_project.ComplexNumber;
import se_project.Stack;
import se_project.commands.OperationCommand;
import se_project.commands.operationsCommands.MinusCommand;
import se_project.commands.operationsCommands.PlusCommand;
import se_project.exceptions.EmptyStackException;
import se_project.exceptions.NotApplicableOperation;

/**
 *
 * @author emanu
 */
public class ExecuteUserDefinedOperationCommandTest {

    private ExecuteUserDefinedOperationCommand instance;
    private Stack stack;
    private LinkedList<OperationCommand> list = new LinkedList<>();

    public ExecuteUserDefinedOperationCommandTest() {
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
        stack.push(new ComplexNumber(3, 4));
        stack.push(new ComplexNumber(1, 6));
        stack.push(new ComplexNumber(0, 5));
        PlusCommand plusCommand = new PlusCommand(stack);
        MinusCommand minusCommand = new MinusCommand(stack);
        
        list.add(plusCommand);
        list.add(minusCommand);

        instance = new ExecuteUserDefinedOperationCommand("sommaEdifferenza", list, stack);

    }

    @After
    public void tearDown() {
    }

    /**
     * Test del metodo GetName che ritorna il nome dell'operazione definita
     * dall'utente.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        //ExecuteUserDefinedOperationCommand instance = new ExecuteUserDefinedOperationCommand();
        String name = instance.getName();
        String expResult = "sommaEdifferenza";
        String result = instance.getName();
        assertArrayEquals(expResult.toCharArray(), result.toCharArray());

    }

    /**
     * Test del metodo Execute che esegue tutti i comandi associati al nome
     * dell'operazione.
     */
    @Test
    public void testExecute() throws Exception {
        System.out.println("execute");
        Object expResult = true;
        Object result = instance.execute();
        assertEquals(expResult, result);
        assertEquals(-2, stack.peek().getRealPart(), 0 );
        assertEquals(+7, stack.peek().getImaginaryPart(), 0);
   
       
        
    }
     @Test(expected = NotApplicableOperation.class)
    public void testExecuteException() throws Exception {
        list.add(new MinusCommand(stack));
        Object result = instance.execute();
    }

    /**
     * Test of getCommandList method, of class
     * ExecuteUserDefinedOperationCommand.
     */
    @Test
    public void testGetCommandList() {
        System.out.println("getCommandList");
        instance = new ExecuteUserDefinedOperationCommand();
        LinkedList<OperationCommand> expResult = null;
        LinkedList<OperationCommand> result = instance.getCommandList();
        assertEquals(expResult, result);
        instance = new ExecuteUserDefinedOperationCommand("prova", list);
        expResult = list;
        result = instance.getCommandList();
        assertArrayEquals(expResult.toArray(), result.toArray());
    }



}
