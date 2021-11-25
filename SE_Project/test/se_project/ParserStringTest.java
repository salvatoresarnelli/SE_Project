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

/**
 *
 * @author emanu
 */
public class ParserStringTest {
    private final String operation  = "__OPERATION__";
    private final String complex_number = "__COMPLEX__NUMBER__";
    private final String single_number = "__SINGLENUMBER__";
    private final String invalid_insert = "__INVALID__";
    private final String continue_checking = "__CHECKING__";
    private ParserString parser;
    
    public ParserStringTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
         parser = new ParserString();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of clearString method, of class ParserString.
     */
    @Test
    public void testClearString() {
        System.out.println("clearString");
        String text = "+3 -3j";
        String expResult = "3 -3j";
        String result = parser.clearString(text);
        assertEquals(expResult, result);
        text = "-3 +3j";
        expResult = "3 +3j";
        result = parser.clearString(text);
        assertEquals(expResult, result);
        text = "\n3 +3j";
        expResult = "3 +3j";
        result = parser.clearString(text);
        assertEquals(expResult, result);
        text = "\n+3 +3j";
        expResult = "3 +3j";
        result = parser.clearString(text);
        assertEquals(expResult, result);
       
    }

    /**
     * Test of checkOperation method, of class ParserString.
     */
    @Test
    public void testCheckOperation() {
        System.out.println("checkOperation");
        String text = "addition";
        String expResult = operation;
        String result = parser.checkOperation(text);
        assertEquals(expResult, result);
        text = "substraction";
        result = parser.checkOperation(text);
        assertEquals(expResult, result);
        text = "multiplication";
        result = parser.checkOperation(text);
        assertEquals(expResult, result);
        text = "division";
        result = parser.checkOperation(text);
        assertEquals(expResult, result);
        text = "square root";
        result = parser.checkOperation(text);
        assertEquals(expResult, result);
        text = "invert sign";
        result = parser.checkOperation(text);
        assertEquals(expResult, result);
        text = "+";
        result = parser.checkOperation(text);
        assertEquals(expResult, result);
        text = "-";
        result = parser.checkOperation(text);
        assertEquals(expResult, result);
        text = "*";
        result = parser.checkOperation(text);
        assertEquals(expResult, result);
        text = ":";
        result = parser.checkOperation(text);
        assertEquals(expResult, result);
        text = "+-";
        result = parser.checkOperation(text);
        assertEquals(expResult, result);
        text = "sqrt";
        result = parser.checkOperation(text);
        assertEquals(expResult, result);
        text = "hello word";
        result = parser.checkOperation(text);
        expResult = continue_checking;
        assertEquals(expResult, result);
        text = "\nsqrt";
        expResult = operation;
        result = parser.checkOperation(text);
        assertEquals(expResult, result);
    }
    @Test
    public void testCheckPossibilePartReal() {
        System.out.println("checkPossibilePartReal");
        String text = "+3";
        boolean expResult = true;
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
        System.out.println("checkPossibilePartImaginary");
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
        System.out.println("checkPossibleOneNumber");
        String text = "4j";
        String expResult = single_number;
        String result = parser.checkPossibleOneNumber(text);
        assertEquals(expResult, result);
        text = "+4";
        result = parser.checkPossibleOneNumber(text);
        assertEquals(expResult, result);
        text = "4hello";
        expResult = invalid_insert;
        result = parser.checkPossibleOneNumber(text);
        assertEquals(expResult, result);
        
    
    }

    /**
     * Test of checkComplexNumber method, of class ParserString.
     */
    @Test
    public void testCheckComplexNumber() {
        System.out.println("checkComplexNumber");
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
    public void testParserString() {
        System.out.println("parserString_");
        String text = "";
        String expResult = invalid_insert;
        String result = parser.parserString(text);
        assertEquals(expResult, result);
        text = "++4";
        expResult = invalid_insert;
        result = parser.parserString(text);
        assertEquals(expResult, result);
        text = "--4";
        expResult = invalid_insert;
        result = parser.parserString(text);
        assertEquals(expResult, result);
        text = "+4 +3j";
        expResult = complex_number;
        result = parser.parserString(text);
        assertEquals(expResult, result);
        text = "+4j";
        expResult = single_number;
        result = parser.parserString(text);
        assertEquals(expResult, result);
        text = "addition";
        expResult = operation;
        result = parser.parserString(text);
        assertEquals(expResult, result);
    }

    /**
     * Test of checkPossiblePartReal method, of class ParserString.
     */
    @Test
    public void testCheckPossiblePartReal() {
        System.out.println("checkPossiblePartReal");
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
        System.out.println("checkFirstCharacter");
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
        System.out.println("recognizeComplexNumber");
        String text = "+3 +3j";
        ComplexNumber expResult = new ComplexNumber(3, 3);
        ComplexNumber result = parser.recognizeComplexNumber(text);
        assertEquals(expResult.getRealPart(),result.getRealPart(),0);
        assertEquals(expResult.getImaginaryPart(), result.getImaginaryPart(),0);
        text = "-3 +5j";
        expResult = new ComplexNumber(-3, 5);
        result = parser.recognizeComplexNumber(text);
        assertEquals(expResult.getRealPart(),result.getRealPart(),0);
        assertEquals(expResult.getImaginaryPart(), result.getImaginaryPart(),0);
        text = "-3j +4";
        expResult = new ComplexNumber(4, -3);
        result = parser.recognizeComplexNumber(text);
        assertEquals(expResult.getRealPart(),result.getRealPart(),0);
        assertEquals(expResult.getImaginaryPart(), result.getImaginaryPart(),0);
        text = "3j -4";
        expResult = new ComplexNumber(-4, 3);
        result = parser.recognizeComplexNumber(text);
        assertEquals(expResult.getRealPart(),result.getRealPart(),0);
        assertEquals(expResult.getImaginaryPart(), result.getImaginaryPart(),0);
       
       
    }

    /**
     * Test of recognizeNumber method, of class ParserString.
     */
    @Test
    public void testRecognizeNumber() {
        System.out.println("recognizeNumber");
        String text = "+3j";
        ComplexNumber expResult = new ComplexNumber(0, 3);
        ComplexNumber result = parser.recognizeNumber(text);
        assertEquals(expResult.getRealPart(),result.getRealPart(),0);
        assertEquals(expResult.getImaginaryPart(), result.getImaginaryPart(),0);
        text = "+3";
        expResult = new ComplexNumber(+3, 0);
        result = parser.recognizeNumber(text);
        assertEquals(expResult.getRealPart(),result.getRealPart(),0);
        assertEquals(expResult.getImaginaryPart(), result.getImaginaryPart(),0);
        text = "-3j";
        expResult = new ComplexNumber(0, -3);
        result = parser.recognizeNumber(text);
        assertEquals(expResult.getRealPart(),result.getRealPart(),0);
        assertEquals(expResult.getImaginaryPart(), result.getImaginaryPart(),0);
        text = "-3";
        expResult = new ComplexNumber(-3, 0);
        result = parser.recognizeNumber(text);
        assertEquals(expResult.getRealPart(),result.getRealPart(),0);
        assertEquals(expResult.getImaginaryPart(), result.getImaginaryPart(),0);
       
    }
   
    

}
