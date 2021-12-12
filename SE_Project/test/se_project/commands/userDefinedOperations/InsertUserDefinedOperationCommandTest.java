/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se_project.commands.userDefinedOperations;

import java.util.HashMap;
import java.util.LinkedList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import se_project.OperationDict;
import se_project.Stack;
import se_project.commands.OperationCommand;
import se_project.commands.operationsCommands.ColonsCommand;
import se_project.commands.operationsCommands.MinusCommand;
import se_project.commands.operationsCommands.PlusCommand;
import se_project.commands.variablesCommands.SumVariableCommand;

/**
 *
 * @author emanu
 */
public class InsertUserDefinedOperationCommandTest {
    private InsertUserDefinedOperationCommand insertUserDefinedOperationCommand;
    private HashMap<String, OperationCommand> commandDict = new HashMap<>();
    private LinkedList<OperationCommand> commandList = new LinkedList<>();
    private Stack stack;
    
    public InsertUserDefinedOperationCommandTest() {
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
        commandList.add(new PlusCommand(stack));
        commandList.add(new ColonsCommand(stack));
        commandList.add(new MinusCommand(stack));
        insertUserDefinedOperationCommand = new InsertUserDefinedOperationCommand("operazioneUno", commandList, commandDict);
        
        
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test del metodo GetName, il quale torna il nome dell'operazione
     * definita dall'utente.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        //InsertUserDefinedOperationCommand instance = null;
        String expResult = "operazioneUno";
        String result = insertUserDefinedOperationCommand.getName();
        assertArrayEquals(expResult.toCharArray(), result.toCharArray());
      
    }

    /**
     * Test of getCommandList method, of class InsertUserDefinedOperationCommand.
     */
    @Test
    public void testGetCommandList() {
       System.out.println("getCommandList");
        insertUserDefinedOperationCommand = new InsertUserDefinedOperationCommand("provaDue", null, commandDict);
        LinkedList<OperationCommand> expResult = null;
        LinkedList<OperationCommand> result = insertUserDefinedOperationCommand.getCommandList();
        assertEquals(expResult, result);
        insertUserDefinedOperationCommand = new InsertUserDefinedOperationCommand("prova", commandList, commandDict);
        expResult = commandList;
        result = insertUserDefinedOperationCommand.getCommandList();
        assertArrayEquals(expResult.toArray(), result.toArray());
    }

    /**
     * Test del metodo Execute in cui viene salvata l'operazione definita dall'utente.
     */
    @Test
    public void testExecute() throws Exception {
        System.out.println("execute");
        commandList = new LinkedList<>();
        PlusCommand plusCommand = new PlusCommand();
        commandList.add(plusCommand);
        insertUserDefinedOperationCommand = new InsertUserDefinedOperationCommand("provadue", commandList, commandDict);
        ExecuteUserDefinedOperationCommand result = (ExecuteUserDefinedOperationCommand) insertUserDefinedOperationCommand.execute();
        ExecuteUserDefinedOperationCommand get = (ExecuteUserDefinedOperationCommand) commandDict.get("provadue");
        assertArrayEquals(commandList.toArray(), get.getCommandList().toArray());
    }

  
    
}
