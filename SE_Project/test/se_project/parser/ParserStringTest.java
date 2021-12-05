/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se_project.parser;

import se_project.parser.ParserString;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import se_project.ComplexNumber;
import static org.junit.Assert.*;
import se_project.commands.InsertNumberCommand;
import se_project.commands.OperationCommand;
import se_project.commands.operationsCommands.ColonsCommand;
import se_project.commands.operationsCommands.DotCommand;
import se_project.commands.operationsCommands.MinusCommand;
import se_project.commands.operationsCommands.PlusCommand;
import se_project.commands.operationsCommands.SignCommand;
import se_project.commands.operationsCommands.SqrtCommand;
import se_project.parser.ComplexNumberParser;
import se_project.parser.OperationParser;

/**
 *
 * @author emanu
 */
public class ParserStringTest {

    private ParserString parser;
    private OperationCommand result;
    private String input;
    private final String complex_number = "__COMPLEX__NUMBER__";
    private final String single_number = "__SINGLENUMBER__";
    private final String invalid_insert = "__INVALID__";
    private final String continue_checking = "__CHECKING__";

    public ParserStringTest() {

    }

    @Before
    public void setUp() {
        input = new String();
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of checkOperation method, of class ParserString.
     */
    @Test
    public void testCheckOperation() {

        parser = new OperationParser(new ParserString());

        input = "+";
        result = ((OperationParser) parser).checkOperation(input);
        assertTrue(result instanceof PlusCommand);
        input = "-";
        result = ((OperationParser) parser).checkOperation(input);
        assertTrue(result instanceof MinusCommand);
        input = "*";
        result = ((OperationParser) parser).checkOperation(input);
        assertTrue(result instanceof DotCommand);
        input = ":";
        result = ((OperationParser) parser).checkOperation(input);
        assertTrue(result instanceof ColonsCommand);
        input = "+-";
        result = ((OperationParser) parser).checkOperation(input);
        assertTrue(result instanceof SignCommand);
        input = "sqrt";
        result = ((OperationParser) parser).checkOperation(input);
        assertTrue(result instanceof SqrtCommand);
        input = "hello word";
        result = ((OperationParser) parser).checkOperation(input);
        assertNull(result);
        input = "\nsqrt";
        result = ((OperationParser) parser).checkOperation(input);
        assertTrue(result instanceof SqrtCommand);
    }

    @Test
    public void testCheckPossibilePartReal() {
        String text = "+3";
        boolean expResult = true;
        ComplexNumberParser parser = new ComplexNumberParser(new ParserString());
        boolean result = parser.checkPossiblePartReal(text);
        assertEquals(expResult, result);
        text = "+3helloword";
        expResult = false;
        result = parser.checkPossiblePartReal(text);
        assertEquals(expResult, result);
    }

    /**
     * Test of checkPossiblePartImaginary method, of class ParserString.
     */
    @Test
    public void testCheckPossiblePartImaginary() {
        ComplexNumberParser parser = new ComplexNumberParser(new ParserString());

        String text = "+3j";
        boolean expResult = true;
        boolean result = parser.checkPossiblePartImaginary(text);
        assertEquals(expResult, result);
        text = "+3jhelloword";
        expResult = false;
        result = parser.checkPossiblePartImaginary(text);
        assertEquals(expResult, result);
        text = "+3";
        expResult = false;
        result = parser.checkPossiblePartImaginary(text);
        assertEquals(expResult, result);
    }

    /**
     * Test of checkPossibleOneNumber method, of class ParserString.
     */
    @Test
    public void testCheckPossibleOneNumber() {
        ComplexNumberParser parser = new ComplexNumberParser(new ParserString());

        String text = "4j";
        String expResult = "__SINGLENUMBER__";
        String result = parser.checkPossibleOneNumber(text);
        assertEquals(expResult, result);
        text = "+4";
        result = parser.checkPossibleOneNumber(text);
        assertEquals(expResult, result);
        text = "4hello";
        expResult = "__INVALID__";
        result = parser.checkPossibleOneNumber(text);
        assertEquals(expResult, result);

    }

    /**
     * Test of checkComplexNumber method, of class ParserString.
     */
    @Test
    public void testCheckComplexNumber() {
        ComplexNumberParser parser = new ComplexNumberParser(new ParserString());
        //se la condizione fallisce del primo if
        String text = "4";
        String expResult = continue_checking;
        String result = parser.checkComplexNumber(text);
        assertEquals(expResult, result);
        // se la condizione si verifica nel secondo if
        text = "4 +4j + 3";
        result = parser.checkComplexNumber(text);
        expResult = invalid_insert;
        assertEquals(expResult, result);
        //se viene catturata l'eccezione
        text = "+4,ld +4j";
        result = parser.checkComplexNumber(text);
        assertEquals(expResult, result);
        // se il secondo valore non contiene j 
        text = "+4 +7";
        result = parser.checkComplexNumber(text);
        assertEquals(expResult, result);
        // se contiene più j 
        text = "+4 +3j hello";
        result = parser.checkComplexNumber(text);
        assertEquals(expResult, result);
        text = "4 +3j";
        expResult = complex_number;
        result = parser.checkComplexNumber(text);
        assertEquals(expResult, result);
        text = "4j +3";
        expResult = complex_number;
        result = parser.checkComplexNumber(text);
        assertEquals(expResult, result);
        text = "4j +3j";
        expResult = invalid_insert;
        result = parser.checkComplexNumber(text);
        assertEquals(expResult, result);
        text = "+4 +dkdkdj";
        expResult = invalid_insert;
        result = parser.checkComplexNumber(text);
        assertEquals(expResult, result);

    }

    /**
     * Test of parserString_ method, of class ParserString.
     */
    @Test
    public void testParserString() throws Exception {
        ComplexNumberParser parser = new ComplexNumberParser(new ParserString());

        String text = "";
        
        OperationCommand result = parser.parse(text);
        assertNull(result);
        text = "++4";
        result = parser.parse(text);
        assertNull(result);
        text = "--4";
        result = parser.parse(text);
        assertNull(result);
        text = "+4 +3j";
        ComplexNumber expNumber = new ComplexNumber(4,3);
        result = parser.parse(text);
        assertTrue(result instanceof InsertNumberCommand);
        assertEquals(expNumber,((InsertNumberCommand)result).getNumber());
        text = "+4j";
        result = parser.parse(text);
        assertTrue(result instanceof InsertNumberCommand);
        expNumber.setRealPart(0);
        expNumber.setImaginaryPart(4);
        assertEquals(expNumber,((InsertNumberCommand)result).getNumber());

    }

    /**
     * Test of checkPossiblePartReal method, of class ParserString.
     */
    @Test
    public void testCheckPossiblePartReal() {
        ComplexNumberParser parser = new ComplexNumberParser(new ParserString());
        String text = "+4";
        boolean expResult = true;
        boolean result = parser.checkPossiblePartReal(text);
        assertEquals(expResult, result);
        text = "+4ldlsl";
        expResult = false;
        result = parser.checkPossiblePartReal(text);
        assertEquals(expResult, result);

    }

    /**
     * Test of checkFirstCharacter method, of class ParserString.
     */
    @Test
    public void testCheckFirstCharacter() {
        ComplexNumberParser parser = new ComplexNumberParser(new ParserString());
        String text = "+4";
        char expResult = '+';
        char result = parser.checkFirstCharacter(text);
        assertEquals(expResult, result);
        text = "4";
        expResult = ' ';
        result = parser.checkFirstCharacter(text);
        assertEquals(expResult, result);
        text = "-4";
        expResult = '-';
        result = parser.checkFirstCharacter(text);
        assertEquals(expResult, result);
        text = "\n+4\n";
        expResult = '+';
        result = parser.checkFirstCharacter(text);
        assertEquals(expResult, result);
    }

    /**
     * Test of recognizeComplexNumber method, of class ParserString.
     */
    @Test
    public void testRecognizeComplexNumber() {
        ComplexNumberParser parser = new ComplexNumberParser(new ParserString());
        String text = "+3 +3j";
        ComplexNumber expResult = new ComplexNumber(3, 3);
        ComplexNumber result = parser.recognizeComplexNumber(text);
        assertEquals(expResult.getRealPart(), result.getRealPart(), 0);
        assertEquals(expResult.getImaginaryPart(), result.getImaginaryPart(), 0);
        text = "-3 +5j";
        expResult = new ComplexNumber(-3, 5);
        result = parser.recognizeComplexNumber(text);
        assertEquals(expResult.getRealPart(), result.getRealPart(), 0);
        assertEquals(expResult.getImaginaryPart(), result.getImaginaryPart(), 0);
        text = "-3j +4";
        expResult = new ComplexNumber(4, -3);
        result = parser.recognizeComplexNumber(text);
        assertEquals(expResult.getRealPart(), result.getRealPart(), 0);
        assertEquals(expResult.getImaginaryPart(), result.getImaginaryPart(), 0);
        text = "3j -4";
        expResult = new ComplexNumber(-4, 3);
        result = parser.recognizeComplexNumber(text);
        assertEquals(expResult.getRealPart(), result.getRealPart(), 0);
        assertEquals(expResult.getImaginaryPart(), result.getImaginaryPart(), 0);

    }

    /**
     * Test of recognizeNumber method, of class ParserString.
     */
    @Test
    public void testRecognizeNumber() {
        ComplexNumberParser parser = new ComplexNumberParser(new ParserString());
        String text = "+3j";
        ComplexNumber expResult = new ComplexNumber(0, 3);
        ComplexNumber result = parser.recognizeNumber(text);
        assertEquals(expResult.getRealPart(), result.getRealPart(), 0);
        assertEquals(expResult.getImaginaryPart(), result.getImaginaryPart(), 0);
        text = "+3";
        expResult = new ComplexNumber(+3, 0);
        result = parser.recognizeNumber(text);
        assertEquals(expResult.getRealPart(), result.getRealPart(), 0);
        assertEquals(expResult.getImaginaryPart(), result.getImaginaryPart(), 0);
        text = "-3j";
        expResult = new ComplexNumber(0, -3);
        result = parser.recognizeNumber(text);
        assertEquals(expResult.getRealPart(), result.getRealPart(), 0);
        assertEquals(expResult.getImaginaryPart(), result.getImaginaryPart(), 0);
        text = "-3";
        expResult = new ComplexNumber(-3, 0);
        result = parser.recognizeNumber(text);
        assertEquals(expResult.getRealPart(), result.getRealPart(), 0);
        assertEquals(expResult.getImaginaryPart(), result.getImaginaryPart(), 0);

    }

}
