/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se_project;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import se_project.commands.OperationCommand;
import se_project.commands.userDefinedOperations.ExecuteUserDefinedOperationCommand;
import se_project.exceptions.ExistingNameException;
import se_project.exceptions.InvalidNameException;
import se_project.exceptions.OperationNotFoundException;
import se_project.parser.OperationParser;
import se_project.parser.ParserString;
import se_project.parser.UserDefinedOperationParser;

/**
 ** La classe UserDefinedOperationParserTest è stata utilizzata per testare i
 * controlli fatti dalla classe UserDefinedOperationParser. Si testeranno tutti
 * i metodi pubblici presenti, in modalità white box e black box.
 * 
 */
public class OperationDictTest {
     private UserDefinedOperationParser decoratorParserOperation;
    private ParserString parserString;
    private OperationDict operationDict;
    public OperationDictTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws ExistingNameException, OperationNotFoundException, InvalidNameException, Exception {
         decoratorParserOperation = new UserDefinedOperationParser(new OperationParser(new ParserString()));
        
        operationDict = OperationDict.getInstance();
    }
    
    @After
    public void tearDown() {
    }

    /**
     *Il metodo statico permette di ottenere uno e uno solo operationDict. In tal modo, è 
     * stato definito un metodo statico che se l'oggetto è stato già istanziato, torna l'oggetto, 
     * altrimenti lo crea. L'ogetto è stato già definito nella setup , quindi il valore di ritorno è 
     * un operationDict.
     */
    @Test
    public void testGetInstance() {
        System.out.println("getInstance");
        OperationDict result = OperationDict.getInstance();
        assertEquals(operationDict, result);
     
    }

 

    /**
     *Test del metodo getNames, il quale torna un Set<String> contenente i nomi di tutte le operazioni definite dall'utente
     * 
     */
    @Test
    public void testGetNames() {
        System.out.println("getNames");
        Set<String> expResult = new HashSet<>();
        expResult.add("prova");
        expResult.add("provadue");
        //nella fase di setup sono state aggiunte due operazioni
        Set<String> result = operationDict.getNames();
        result.forEach((name) -> {
            assertTrue(expResult.contains(name));
         });
    }
    

  

/*  Test del metodo GetOperations utilizzato per conoscere tutti i commandi associati ad un operazione, di cui
        si conosce il nome. Il metodo torna un ExecuteUserDefinedOperationCommand.
     * @throws se_project.exceptions.ExistingNameException
     * @throws se_project.exceptions.OperationNotFoundException
     */
    @Test
    public void testGetOperations() throws ExistingNameException, OperationNotFoundException, InvalidNameException, Exception {
        System.out.println("getOperations");
        String name = "provatre";
        LinkedList<String> expResult = new LinkedList<>();
        expResult.add("se_project.commands.operationsCommands.PlusCommand");
        expResult.add("se_project.commands.operationsCommands.MinusCommand");
        expResult.add("se_project.commands.operationsCommands.DotCommand");

        decoratorParserOperation.parse(">>provatre$ + - *");
       ExecuteUserDefinedOperationCommand result = operationDict.getOperations(name);
       LinkedList<OperationCommand> commandList = result.getCommandList();
       
        for (int i = 0; i < commandList.size(); i++) {
            assertTrue((Class.forName(expResult.get(i))).isInstance(commandList.get(i)));
        }

        name = "invalid_insert";
        result = operationDict.getOperations(name);
        assertNull(result);

    }

    /**
     * Test del metodo GetOperationString, il quale dato un nome di un operazione definita dall'utente,
     * ritorna una stringa contenente tutte le operazioni associate a quel nome, stringa vuota altrimenti.
     */
    
    @Test
    public void testGetOperationString() throws ExistingNameException, OperationNotFoundException, InvalidNameException, Exception {
        System.out.println("getOperationString");
        String text = "provasei";
        String expResult = "+";
        decoratorParserOperation.parse(">>provasei $ + ");
        String result = operationDict.getOperationString(text);
        assertEquals(String.valueOf(result.toCharArray()[1]), expResult);
        text = "invalid_insert";
        result = operationDict.getOperationString(text);
        assertEquals("", result);
       
    }

 

 /**
     * Test del metodo RemoveOperation utilizzato per eliminare un operazione
     * definita dall'utente.
     */
    @Test
    public void testRemoveOperation() throws ExistingNameException, OperationNotFoundException, InvalidNameException, Exception {
        System.out.println("removeOperation");
        String name = "ciao";
        //provo ad eliminare un operazione non presente 
        decoratorParserOperation = new UserDefinedOperationParser(new OperationParser(new ParserString()));
        boolean expResult = false;
        boolean result = operationDict.removeOperation(name);
        assertEquals(expResult, result);
        //inserisco un'operazione e poi la elimino
        decoratorParserOperation.parse(">>sommadue $ + ");
        expResult = true;
        result = operationDict.removeOperation("sommadue");
        assertEquals(expResult, result);

    }
    
}
