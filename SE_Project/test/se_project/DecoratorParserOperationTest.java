/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se_project;

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
import se_project.exceptions.InvalidNameException;

/**
 *
 * @author emanu
 */
public class DecoratorParserOperationTest {

    private final String invalid_insert = "__INVALID__";
    private DecoratorParserOperation decoratorParserOperation;
    private ParserString parserString;

    public DecoratorParserOperationTest() {
    }
    @Rule
    public ExpectedException exceptionStringException = ExpectedException.none();

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        parserString = new ParserString();
        HashMap<String, LinkedList<String>> map = new HashMap<>();
        LinkedList<String> linkedList = new LinkedList<>();
        Collections.addAll(linkedList, "+", "-", "*");
        map.put("prova", linkedList);
        map.put("provadue", linkedList);
        decoratorParserOperation = new DecoratorParserOperation(parserString, map);

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
    public void testGetOperations() {
        System.out.println("getOperations");
        String name = "prova";
        LinkedList<String> expResult = new LinkedList<>();
        expResult.add("+");
        expResult.add("-");
        expResult.add("*");
        LinkedList<String> result = decoratorParserOperation.getOperations(name);
        for (int i = 0; i < result.size(); i++) {
            assertEquals(expResult.get(i), result.get(i));
        }

        name = "invalid_insert";
        result = decoratorParserOperation.getOperations(name);
        assertEquals(null, result);

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
    public void testParserString() {
        System.out.println("parserString");
        String textString = ">>somma";
        exceptionStringException.expect(ArrayIndexOutOfBoundsException.class);
        String result = decoratorParserOperation.parserString(textString);
        textString = ">>x$ + - +";
        result = decoratorParserOperation.parserString(textString);
        assertEquals(invalid_insert, result);
        textString = ">>swap$ + - +  ";
        result = decoratorParserOperation.parserString(textString);
        assertEquals(invalid_insert, result);
        textString = ">>s0mma$ + - +  ";
        result = decoratorParserOperation.parserString(textString);
        assertEquals(invalid_insert, result);
        textString = ">>somma$";
        exceptionStringException.expect(ArrayIndexOutOfBoundsException.class);
        result = decoratorParserOperation.parserString(textString);
        textString = ">>prova$ + - +";
        exceptionStringException.expect(InvalidNameException.class);
        result = decoratorParserOperation.parserString(textString);
        textString = ">>somma$ + - prova  ";
        result = decoratorParserOperation.parserString(textString);
        assertEquals("somma", result);
        textString = ">>somma$ + - provatre  ";
        exceptionStringException.expect(InvalidNameException.class);
        result = decoratorParserOperation.parserString(textString);

    }

}
