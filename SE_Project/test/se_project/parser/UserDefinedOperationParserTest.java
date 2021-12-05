/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se_project.parser;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Set;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import se_project.exceptions.InvalidNameException;
import se_project.commands.*;
import se_project.parser.UserDefinedOperationParser;
import se_project.parser.ParserString;
import java.lang.StringIndexOutOfBoundsException;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
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
import se_project.commands.userDefinedOperations.ExecuteUserDefinedOperationCommand;
import se_project.commands.OperationCommand;
import se_project.exceptions.OperationNotFoundException;
import se_project.commands.operationsCommands.DotCommand;
import se_project.commands.operationsCommands.MinusCommand;
import se_project.commands.operationsCommands.PlusCommand;
import se_project.exceptions.ExistingNameException;
import se_project.exceptions.InvalidNameException;

/**
 *
 * @author emanu
 */
/**
 *
 * @author aless
 */
public class UserDefinedOperationParserTest {
    
    private final String invalid_insert = "__INVALID__";
    private UserDefinedOperationParser decoratorParserOperation;
    private ParserString parserString;

    public UserDefinedOperationParserTest() {
    }
    @Rule
    public ExpectedException exceptionStringException = ExpectedException.none();


    @Before
    public void setUp() throws ExistingNameException, OperationNotFoundException, InvalidNameException, Exception {
        parserString = new ParserString();
        HashMap<String, LinkedList<String>> map = new HashMap<>();
        LinkedList<String> linkedList = new LinkedList<>();
        Collections.addAll(linkedList, "+", "-", "*");
        map.put("prova", linkedList);
        map.put("provadue", linkedList);
        decoratorParserOperation = new UserDefinedOperationParser(new OperationParser(new ParserString()));
        decoratorParserOperation.parse(">>prova$ + + +");
        decoratorParserOperation.parse(">>provadue$ + + +");

    }

    @After
    public void tearDown() {
    }

    /**
     * Test of clearStringOperation method, of class DecoratorParserOperation.
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
     * Test of checkName method, of class DecoratorParserOperation.
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
     * Test of removeInitialSpaces method, of class DecoratorParserOperation.
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
     * Test of getNames method, of class DecoratorParserOperation.
     */
    @Test
    public void testGetNames() {
        System.out.println("getNames");
        Set<String> expResult = new LinkedHashSet<>();
        expResult.add("prova");
        expResult.add("provadue");
        Set<String> result = decoratorParserOperation.getNames();
        assertEquals(expResult, result);

    }

    /**
     * Test of getOperations method, of class DecoratorParserOperation.
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
       ExecuteUserDefinedOperationCommand result = decoratorParserOperation.getOperations(name);
       LinkedList<OperationCommand> commandList = result.getCommandList();
       
        for (int i = 0; i < commandList.size(); i++) {
            assertTrue((Class.forName(expResult.get(i))).isInstance(commandList.get(i)));
        }

        name = "invalid_insert";
        result = decoratorParserOperation.getOperations(name);
        assertNull(result);

    }

    /**
     * Test of getOperationString method, of class DecoratorParserOperation.
     */
    /*
    @Test
    public void testGetOperationString() {
        System.out.println("getOperationString");
        String text = "prova";
        String expResult = " + - *";
        String result = decoratorParserOperation.getOperationString(text);
        System.out.println(result);
        assertEquals(true,result.equals(expResult));
        text = "invalid_insert";
        result = decoratorParserOperation.getOperationString(text);
        assertEquals(null, result);
       
    }
     */
    /**
     * Test of parserString method, of class DecoratorParserOperation.
     */
    @Test
    public void testParserString() throws ExistingNameException, OperationNotFoundException, 
            InvalidNameException, Exception {
        System.out.println("parserString");
        String textString = ">>somma";
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

}


