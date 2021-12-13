/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se_project.parser;

import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import se_project.ComplexNumber;
import se_project.commands.InsertNumberCommand;
import se_project.commands.OperationCommand;

/**
 * La classe complexNumberParserText è stata utilizzata per testare i controlli
 * fatti dalla classe ComplexNumberParser. Si testeranno tutti i metodi pubblici
 * presenti, in modalità white box e black box.
 *
 */
public class ComplexNumberParserTest {

    private ParserString parser;
    private OperationCommand result;
    private String input;
    private final String complex_number = "__COMPLEX__NUMBER__";
    private final String single_number = "__SINGLENUMBER__";
    private final String invalid_insert = "__INVALID__";
    private final String continue_checking = "__CHECKING__";

    public ComplexNumberParserTest() {

    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
        input = new String();
    }

    @After
    public void tearDown() {
    }

    /**
     * Test del metodo clearString utilizzato per rimuovere eventuali \n
     * presenti all'interno della stringa. Inoltre, ai fini del controllo,
     * elimina anche un eventuale segno + o - presente all'inizio della stringa.
     * Secondo la logica white box si è pensato di inserire come input di test
     * tutti gli input che generassero tutti i path possibili all'interno del
     * metodo.
     */
    @Test
    public void testClearString() {
        parser = new ComplexNumberParser(new ParserString());
        input = "+3 -3j";
        String expResult = "3 -3j";
        String result = ((ComplexNumberParser) parser).clearString(input);
        assertEquals(expResult, result);
        input = "-3 +3j";
        expResult = "3 +3j";
        result = ((ComplexNumberParser) parser).clearString(input);
        assertEquals(expResult, result);
        input = "\n3 +3j";
        expResult = "3 +3j";
        result = ((ComplexNumberParser) parser).clearString(input);
        assertEquals(expResult, result);
        input = "\n+3 +3j";
        expResult = "3 +3j";
        result = ((ComplexNumberParser) parser).clearString(input);
        assertEquals(expResult, result);

    }

    /**
     * Test del metodo CheckPossibilePartReal utilizzato per controllare se
     * l'utente ha cercato di inserire un numero puramente reale.Secondo la
     * logica white box si è pensato di inserire come input di test tutti gli
     * input che generassero tutti i path possibili all'interno del metodo. La
     * stringa data in input una volta è un numero puramente reale, una volta è
     * una stringa che non è possibile considerare come un numero.
     */

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
     * Test del metodo CheckPossibilePartImaginary utilizzato per controllare se
     * l'utente ha cercato di inserire un numero puramente immaginario.Secondo
     * la logica white box si è pensato di inserire come input di test tutti gli
     * input che generassero tutti i path possibili all'interno del metodo. La
     * stringa data in input una volta è un numero puramente immaginario, una
     * volta è una stringa che non è possibile considerare come un numero
     * immaginario.
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
     * Test del metodo CheckPossibileOneNumber utilizzato per controllare se
     * l'utente ha cercato di inserire un numero, che esso sia immaginario o
     * puramente reale .Secondo la logica white box si è pensato di inserire
     * come input di test tutti gli input che generassero tutti i path possibili
     * all'interno del metodo. La stringa data in input una volta è un numero
     * puramente immaginario, una volta è una stringa che non è possibile
     * considerare come un numero immaginario, una volta un numero reale, una
     * volta un numero puramente immaginario con la sola variabile j.
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
        text = "+j";
        result = parser.checkPossibleOneNumber(text);
        assertEquals(expResult, result);
        text = "4hello";
        expResult = "__INVALID__";
        result = parser.checkPossibleOneNumber(text);
        assertEquals(expResult, result);

    }

    /**
     *    * Test del metodo CheckComplexNumber utilizzato per controllare se
     * l'utente ha cercato di inserire un numero complesso completo, con parte
     * sia immaginaria che reale .Secondo la logica white box si è pensato di
     * inserire come input di test tutti gli input che generassero tutti i path
     * possibili all'interno del metodo. La stringa data in input una volta è un
     * numero complesso completo , una volta è una stringa che non è possibile
     * considerare come un numero immaginario, una volta un numero reale.
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
        text = "4.0 +3.0j";
        expResult = complex_number;
        result = parser.checkComplexNumber(text);
        assertEquals(expResult, result);
        text = "4j +3";
        expResult = complex_number;
        result = parser.checkComplexNumber(text);
        assertEquals(expResult, result);
        text = "j10 +3";
        expResult = complex_number;
        result = parser.checkComplexNumber(text);
        assertEquals(expResult, result);
      
    }

    /**
     * Test del metodo CheckFirstCharacter utilizzato per controllare cosa ha
     * inserito l'utente come primo carattere. .Secondo la logica white box si è
     * pensato di inserire come input di test tutti gli input che generassero
     * tutti i path possibili all'interno del metodo. La stringa data in input
     * una volta è un numero puramente reale in cui è presente come primo
     * carattere un segno più , una volta è un numero puramente reale in cui è
     * presente come primo carattere un segno meno , e una volta una stringa con
     * vari \n.
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
     * * Test del metodo RecognizeComplexNumber utilizzato per controllare se
     * la stringa inserita è un numero complesso completo, con parte reale e
     * parte immaginaria. Si sono distinti i casi in cui sono inseriti un numero
     * complesso completo , o un numero puramente reale o puramente immaginario,
     * considerato come un single number. Il metodo inoltre ritorna, dopo aver
     * letto la stringa, l'ogetto ComplexNumber, definito dall'utente .Secondo
     * la logica white box si è pensato di inserire come input di test tutti gli
     * input che generassero tutti i path possibili all'interno del metodo. La
     * stringa data in input una volta è sempre un numero complesso completo,
     * scritto però in varie varianti: Prima parte reale e poi immaginaria, poi
     * parte immaginaria e poi reale, poi un numero complesso di questo tipo -->
     * j4 + 3.
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
        text = "j3 -4";
        expResult = new ComplexNumber(-4, 3);
        result = parser.recognizeComplexNumber(text);
        assertEquals(expResult.getRealPart(), result.getRealPart(), 0);
        assertEquals(expResult.getImaginaryPart(), result.getImaginaryPart(), 0);
        text = "j33 -44";
        expResult = new ComplexNumber(-44, 33);
        result = parser.recognizeComplexNumber(text);
        assertEquals(expResult.getRealPart(), result.getRealPart(), 0);
        assertEquals(expResult.getImaginaryPart(), result.getImaginaryPart(), 0);
        text = "j33.0 -4.0";
        expResult = new ComplexNumber(-4, 33);
        result = parser.recognizeComplexNumber(text);
        assertEquals(expResult.getRealPart(), result.getRealPart(), 0);
        assertEquals(expResult.getImaginaryPart(), result.getImaginaryPart(), 0);
        text = "1 +33.3j";
        expResult = new ComplexNumber(1, 33.3);
        result = parser.recognizeComplexNumber(text);
        assertEquals(expResult.getRealPart(), result.getRealPart(), 0);
        assertEquals(expResult.getImaginaryPart(), result.getImaginaryPart(), 0);

    }

    /**
     * * Test del metodo RecognizeNumber utilizzato per controllare se la
     * stringa inserita è un numero puramente immaginario o reale. Si sono
     * distinti i casi in cui sono inseriti un numero puramente immaginario , o
     * un numero puramente reale , considerato come un single number. Il metodo
     * inoltre ritorna, dopo aver letto la stringa, l'ogetto ComplexNumber,
     * definito dall'utente. .Secondo la logica white box si è pensato di
     * inserire come input di test tutti gli input che generassero tutti i path
     * possibili all'interno del metodo. La stringa data in input una volta + un
     * numero puramente reale, un numero puramente immaginario.
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
        text = "-33";
        expResult = new ComplexNumber(-33, 0);
        result = parser.recognizeNumber(text);
        assertEquals(expResult.getRealPart(), result.getRealPart(), 0);
        assertEquals(expResult.getImaginaryPart(), result.getImaginaryPart(), 0);
        text = "+33";
        expResult = new ComplexNumber(+33, 0);
        result = parser.recognizeNumber(text);
        assertEquals(expResult.getRealPart(), result.getRealPart(), 0);
        assertEquals(expResult.getImaginaryPart(), result.getImaginaryPart(), 0);
        text = "+33j";
        expResult = new ComplexNumber(0, 33);
        result = parser.recognizeNumber(text);
        assertEquals(expResult.getRealPart(), result.getRealPart(), 0);
        assertEquals(expResult.getImaginaryPart(), result.getImaginaryPart(), 0);
        text = "-33";
        expResult = new ComplexNumber(-33, 0);
        result = parser.recognizeNumber(text);
        assertEquals(expResult.getRealPart(), result.getRealPart(), 0);
        assertEquals(expResult.getImaginaryPart(), result.getImaginaryPart(), 0);

    }

    /**
     * Test of parse method, of class ComplexNumberParser.
     */
    @Test
    public void testParse() throws Exception {
        System.out.println("parse");
        String text = "3 +3j";
        ComplexNumberParser parser = new ComplexNumberParser(new ParserString());
        InsertNumberCommand expResult = new InsertNumberCommand(new ComplexNumber(3, 3));
        OperationCommand result = parser.parse(text);
        InsertNumberCommand finalResult = (InsertNumberCommand) result;
        assertEquals(expResult.getNumber().getRealPart(), finalResult.getNumber().getRealPart(), 0);
        assertEquals(expResult.getNumber().getImaginaryPart(), finalResult.getNumber().getImaginaryPart(), 0);
        text = "3.7j +4.0";
        expResult = new InsertNumberCommand(new ComplexNumber(4.0, 3.7));
        result = parser.parse(text);
        finalResult = (InsertNumberCommand) result;
        assertEquals(expResult.getNumber().getRealPart(), finalResult.getNumber().getRealPart(), 0);
        assertEquals(expResult.getNumber().getImaginaryPart(), finalResult.getNumber().getImaginaryPart(), 0);
        text = "+3.7j -44";
        expResult = new InsertNumberCommand(new ComplexNumber(-44, 3.7));
        result = parser.parse(text);
        finalResult = (InsertNumberCommand) result;
        assertEquals(expResult.getNumber().getRealPart(), finalResult.getNumber().getRealPart(), 0);
        assertEquals(expResult.getNumber().getImaginaryPart(), finalResult.getNumber().getImaginaryPart(), 0);
        text = "3j3";
        expResult = null;
        result = parser.parse(text);
       
        assertEquals(expResult, result);
        text = "hello";
        expResult = null;
        result = parser.parse(text);
        assertEquals(expResult, result);
        text = "-j3.1 +9.0";
        expResult = new InsertNumberCommand(new ComplexNumber(9.0, -3.1));
        result = parser.parse(text);
        finalResult = (InsertNumberCommand) result;
        assertEquals(expResult.getNumber().getRealPart(), finalResult.getNumber().getRealPart(), 0);
        assertEquals(expResult.getNumber().getImaginaryPart(), finalResult.getNumber().getImaginaryPart(), 0);
        text = "+4.0";
        expResult = new InsertNumberCommand(new ComplexNumber(4.0, 0));
        result = parser.parse(text);
        finalResult = (InsertNumberCommand) result;
        assertEquals(expResult.getNumber().getRealPart(), finalResult.getNumber().getRealPart(), 0);
        assertEquals(expResult.getNumber().getImaginaryPart(), finalResult.getNumber().getImaginaryPart(), 0);
        text = "+4.0j";
        expResult = new InsertNumberCommand(new ComplexNumber(0, 4.0));
        result = parser.parse(text);
        finalResult = (InsertNumberCommand) result;
        assertEquals(expResult.getNumber().getRealPart(), finalResult.getNumber().getRealPart(), 0);
        assertEquals(expResult.getNumber().getImaginaryPart(), finalResult.getNumber().getImaginaryPart(), 0);
        text = "-334.0";
        expResult = new InsertNumberCommand(new ComplexNumber(-334, 0));
        result = parser.parse(text);
        finalResult = (InsertNumberCommand) result;
        assertEquals(expResult.getNumber().getRealPart(), finalResult.getNumber().getRealPart(), 0);
        assertEquals(expResult.getNumber().getImaginaryPart(), finalResult.getNumber().getImaginaryPart(), 0);

    }

}
