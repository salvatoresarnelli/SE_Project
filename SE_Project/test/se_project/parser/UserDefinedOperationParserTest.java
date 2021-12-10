/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se_project.parser;

import static org.junit.Assert.assertEquals;
import se_project.parser.UserDefinedOperationParser;
import se_project.parser.ParserString;
import java.lang.StringIndexOutOfBoundsException;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Set;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.rules.ExpectedException;
import se_project.OperationDict;
import se_project.commands.userDefinedOperations.ExecuteUserDefinedOperationCommand;
import se_project.commands.OperationCommand;
import se_project.exceptions.OperationNotFoundException;
import se_project.commands.userDefinedOperations.InsertUserDefinedOperationCommand;
import se_project.exceptions.ExistingNameException;
import se_project.exceptions.InvalidNameException;

/**
 *
 * La classe UserDefinedOperationParserTest è stata utilizzata per testare i
 * controlli fatti dalla classe UserDefinedOperationParser. Si testeranno tutti
 * i metodi pubblici presenti, in modalità white box e black box.
 */
public class UserDefinedOperationParserTest {

    private final String invalid_insert = "__INVALID__";
    private UserDefinedOperationParser decoratorParserOperation;
    private ParserString parserString;
    private OperationDict operationDict;

    public UserDefinedOperationParserTest() {
    }
    @Rule
    public ExpectedException exceptionStringException = ExpectedException.none();

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws ExistingNameException, OperationNotFoundException, InvalidNameException, Exception {
        parserString = new ParserString();
        HashMap<String, LinkedList<String>> map = new HashMap<>();
        LinkedList<String> linkedList = new LinkedList<>();
        Collections.addAll(linkedList, "+", "-", "*");
        map.put("prova", linkedList);
        map.put("provadue", linkedList);
        decoratorParserOperation = new UserDefinedOperationParser(new OperationParser(new ParserString()));
        operationDict = OperationDict.getInstance();

    }

    @After
    public void tearDown() {
    }

    /**
     * Test del metodo clearStringOperation utilizzato per rimuovere eventuali
     * \n o caratteri > presenti all'interno della stringa.Secondo la logica
     * white box si è pensato di inserire come input di test tutti gli input che
     * generassero tutti i path possibili all'interno del metodo.
     */
    @Test
    public void testClearStringOperation() {
        System.out.println("clearStringOperation");
        String text = "\n>>hello";
        String expResult = "hello";
        String result = decoratorParserOperation.clearStringOperation(text);
        assertEquals(expResult, result);
        text = "c";
        exceptionStringException.expect(StringIndexOutOfBoundsException.class);
        result = decoratorParserOperation.clearStringOperation(text);

    }

    /**
     * Test del metodo CheckName utilizzato per controllare la stringa inserita
     * dall'utente. In particolare il metodo controlla se il nome dato alla
     * funzione abbia caratteri numeri o meno.Secondo la logica white box si è
     * pensato di inserire come input di test tutti gli input che generassero
     * tutti i path possibili all'interno del metodo.
     */
    @Test
    public void testCheckName() {
        System.out.println("checkName");
        String text = "hello word";
        boolean expResult = true;
        boolean result = decoratorParserOperation.checkName(text);
        assertEquals(expResult, result);
        text = "h5llo word";
        expResult = false;
        result = decoratorParserOperation.checkName(text);
        assertEquals(expResult, result);
    }

    /**
     * Test del metodo RemoveInitialSpaces utilizzato per controllare la stringa
     * inserita dall'utente. In particolare il metodo controlla se il nome
     * presenta degli spazi all'inizio della stringa.Secondo la logica white box
     * si è pensato di inserire come input di test tutti gli input che
     * generassero tutti i path possibili all'interno del metodo.
     */
    @Test
    public void testRemoveInitialSpaces() {
        System.out.println("removeInitialSpaces");
        String text = "      hello";
        String expResult = "hello";
        String result = decoratorParserOperation.removeInitialSpaces(text);
        assertEquals(expResult, result);
        text = "";
        exceptionStringException.expect(StringIndexOutOfBoundsException.class);
        result = decoratorParserOperation.clearStringOperation(text);
        text = "hello";
        result = decoratorParserOperation.clearStringOperation(text);
        assertEquals(expResult, result);
    }

    /**
     * Test del metodo GetNames utilizzato per controllare se il metodo ritorna
     * correttamente un Set di chiavi presenti all'interno dell' HasMap.
     */
    @Test
    public void testGetNames() throws ExistingNameException, OperationNotFoundException, InvalidNameException, Exception {
        System.out.println("getNames");
        Set<String> expResult = new LinkedHashSet<>();
        expResult.add("prova");
        expResult.add("provadue");
        decoratorParserOperation = new UserDefinedOperationParser(new OperationParser(new ParserString()));
        decoratorParserOperation.parse(">>prova $ + - + ");
        decoratorParserOperation.parse(">>provadue $ + + ");
        Set<String> result = operationDict.getNames();
        assertEquals(expResult, result);

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
        decoratorParserOperation = new UserDefinedOperationParser(new OperationParser(new ParserString()));
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
     * Test del metodo ParserString utilizzato per controllare la stringa
     * inserita dall'utente. In particolare il metodo controlla se il nome
     * presenta degli spazi all'inizio della stringa.Secondo la logica white box
     * si è pensato di inserire come input di test tutti gli input che
     * generassero tutti i path possibili all'interno del metodo.
     */
    @Test
    public void testParserString() throws ExistingNameException, OperationNotFoundException,
            InvalidNameException, Exception {
        System.out.println("parserString");
        String textString = ">>somma";
        decoratorParserOperation = new UserDefinedOperationParser(new OperationParser(new ParserString()));
        exceptionStringException.expect(ArrayIndexOutOfBoundsException.class);
        OperationCommand result = decoratorParserOperation.parse(textString);
        textString = ">>x$ + - +";
        result = decoratorParserOperation.parse(textString);
        assertEquals(null, result);
        textString = ">>swap$ + - +  ";
        result = decoratorParserOperation.parse(textString);
        assertEquals(null, result);
        textString = ">>s0mma$ + - +  ";
        result = decoratorParserOperation.parse(textString);
        assertEquals(null, result);
        textString = ">>somma$";
        exceptionStringException.expect(ArrayIndexOutOfBoundsException.class);
        result = decoratorParserOperation.parse(textString);
        textString = ">>prova$ + - +";
        exceptionStringException.expect(InvalidNameException.class);
        result = decoratorParserOperation.parse(textString);
        textString = ">>somma$ + - prova  ";
        result = decoratorParserOperation.parse(textString);
        assertEquals("somma", result);
        textString = ">>somma$ + - provatre  ";
        exceptionStringException.expect(InvalidNameException.class);
        result = decoratorParserOperation.parse(textString);

    }

    /**
     * Test del metodo UserOperation utilizzato per controllare la stringa
     * inserita dall'utente. In particolare il metodo controlla se il nome è un
     * operazione definita dall'utente.
     */
    @Test
    public void testUserOperation() throws Exception {
        System.out.println("userOperation");
        String text = ">>provaquattro $ + ";
        //inserisco prima un operazione.
        decoratorParserOperation = new UserDefinedOperationParser(new OperationParser(new ParserString()));
        decoratorParserOperation.parse(text);
        ExecuteUserDefinedOperationCommand result = decoratorParserOperation.userOperation("provaquattro");
        LinkedList<String> expResult = new LinkedList<>();
        expResult.add("se_project.commands.operationsCommands.PlusCommand");
        for (int i = 0; i < expResult.size(); i++) {
            assertTrue((Class.forName(expResult.get(i))).isInstance(result.getCommandList().get(i)));
        }

    }

    /**
     * Test del metodo Parse. Tale metodo prende in ingresso una stringa da
     * dover controllare. In particolare è stata definita per implementare nuove
     * funzionalità rispetto agli altri parser. In particolare, per la
     * definizione di operazioni
     */
    @Test
    public void testParse() throws Exception {
        System.out.println("parse");
        String textString = ">>somma $ + + ";
        InsertUserDefinedOperationCommand expResult;
        decoratorParserOperation = new UserDefinedOperationParser(new OperationParser(new ParserString()));
        OperationCommand result = decoratorParserOperation.parse(textString);
        //il metodo quando l'utente inserisce un operazione chiama parseInsert, testata precedentemente.
        assertTrue(result instanceof InsertUserDefinedOperationCommand);
        //se l'utente invece scrive il nome di un operazione,il metodo torna i comandi ad esso associati.
        textString = "somma";
        LinkedList<String> expResultList = new LinkedList<>();
        expResultList.add("se_project.commands.operationsCommands.PlusCommand");
        expResultList.add("se_project.commands.operationsCommands.PlusCommand");
        ExecuteUserDefinedOperationCommand ex = (ExecuteUserDefinedOperationCommand) decoratorParserOperation.parse(textString);
        for (int i = 0; i < ex.getCommandList().size(); i++) {
            assertTrue((Class.forName(expResultList.get(i))).isInstance(ex.getCommandList().get(i)));
        }

        //l'altro caso in cui viene chiamato il metodo parse sul parserString, è stato già testato in 
        //tutti i parser presenti e questo valore cambia a seconda del parser utilizzato.
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
        boolean result = decoratorParserOperation.removeOperation(name);
        assertEquals(expResult, result);
        //inserisco un'operazione e poi la elimino
        decoratorParserOperation.parse(">>sommauno $ + ");
        expResult = true;
        result = decoratorParserOperation.removeOperation("sommauno");
        assertEquals(expResult, result);

    }

}





















