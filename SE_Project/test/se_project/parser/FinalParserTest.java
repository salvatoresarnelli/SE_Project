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
import se_project.ComplexNumber;
import se_project.OperationDict;
import se_project.Solver;
import se_project.VariablesDict;
import se_project.commands.InsertNumberCommand;
import se_project.commands.userDefinedOperations.ExecuteUserDefinedOperationCommand;
import se_project.commands.OperationCommand;
import se_project.commands.stackCommands.ClearCommand;
import se_project.commands.stackCommands.DropCommand;
import se_project.commands.stackCommands.DuplicateCommand;
import se_project.commands.stackCommands.OverCommand;
import se_project.commands.stackCommands.SwapCommand;
import se_project.exceptions.OperationNotFoundException;
import se_project.commands.userDefinedOperations.InsertUserDefinedOperationCommand;
import se_project.commands.variablesCommands.DiffVariableCommand;
import se_project.commands.variablesCommands.NewVariableCommand;
import se_project.commands.variablesCommands.PushVariableCommand;
import se_project.commands.variablesCommands.RestoreVariableCommand;
import se_project.commands.variablesCommands.SaveVariableCommand;
import se_project.commands.variablesCommands.SumVariableCommand;
import se_project.exceptions.CollisionException;
import se_project.exceptions.ExistingNameException;
import se_project.exceptions.InvalidNameException;
import se_project.exceptions.InvalidVariableNameException;
import se_project.exceptions.NonExistingVariable;

/**
 *
 * La classe FinalParserTest testa il flusso di esecuzione di tutti i
 * decoratori, in quanto sono stati testati i singoli decoratori, ma non
 * insieme. Così da accorgersi se,nel momento in cui viene decorato un parser,
 * si perdono alcune funzionalità del parser decorato.
 */
public class FinalParserTest {

    private final String invalid_insert = "__INVALID__";
    private UserDefinedOperationParser decoratorParserOperation = new UserDefinedOperationParser(new VariableParser(new StackOperationParser(new OperationParser(new ComplexNumberParser(new ParserString())))));
    private OperationDict operationDict;
    private OperationCommand result;
    private String input;
    private final String complex_number = "__COMPLEX__NUMBER__";
    private final String single_number = "__SINGLENUMBER__";
    private final String continue_checking = "__CHECKING__";
    private Solver solver;
    

    public FinalParserTest() {
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
        HashMap<String, LinkedList<String>> map = new HashMap<>();
        LinkedList<String> linkedList = new LinkedList<>();
        Collections.addAll(linkedList, "+", "-", "*");
        map.put("prova", linkedList);
        map.put("provadue", linkedList);
        operationDict = OperationDict.getInstance();
        input = new String();
        solver = Solver.getInstance();
        solver.getStructureStack().push(new ComplexNumber(1, 1));

    }

    @After
    public void tearDown() {
    }

    /**
     * Test del metodo Parse. Tale metodo prende in ingresso una stringa da
     * dover controllare. In particolare è stata definita per implementare nuove
     * funzionalità rispetto agli altri parser. In particolare, per la
     * definizione di operazioni
     */
    @Test
    public void testParseForUserDefinedOperationParser() throws Exception {
        System.out.println("parse");
        String textString = ">>somma $ + + ";
        InsertUserDefinedOperationCommand expResult;
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
    }

    /**
     * Test of parse method, of class ComplexNumberParser.
     */
    @Test
    public void testParseForComplexNumberParser() throws Exception {
        System.out.println("parse");
        String text = "3 +3j";
        InsertNumberCommand expResult = new InsertNumberCommand(new ComplexNumber(3, 3));
        OperationCommand result = decoratorParserOperation.parse(text);
        InsertNumberCommand finalResult = (InsertNumberCommand) result;
        assertEquals(expResult.getNumber().getRealPart(), finalResult.getNumber().getRealPart(), 0);
        assertEquals(expResult.getNumber().getImaginaryPart(), finalResult.getNumber().getImaginaryPart(), 0);
        text = "3.7j +4.0";
        expResult = new InsertNumberCommand(new ComplexNumber(4.0, 3.7));
        result = decoratorParserOperation.parse(text);
        finalResult = (InsertNumberCommand) result;
        assertEquals(expResult.getNumber().getRealPart(), finalResult.getNumber().getRealPart(), 0);
        assertEquals(expResult.getNumber().getImaginaryPart(), finalResult.getNumber().getImaginaryPart(), 0);
        text = "+3.7j -44";
        expResult = new InsertNumberCommand(new ComplexNumber(-44, 3.7));
        result = decoratorParserOperation.parse(text);
        finalResult = (InsertNumberCommand) result;
        assertEquals(expResult.getNumber().getRealPart(), finalResult.getNumber().getRealPart(), 0);
        assertEquals(expResult.getNumber().getImaginaryPart(), finalResult.getNumber().getImaginaryPart(), 0);
        text = "3j3";
        expResult = null;
        result = decoratorParserOperation.parse(text);
        assertEquals(expResult, result);
        text = "hello";
        expResult = null;
        result = decoratorParserOperation.parse(text);
        assertEquals(expResult, result);
        text = "-j3.1 +9.0";
        expResult = new InsertNumberCommand(new ComplexNumber(9.0, -3.1));
        result = decoratorParserOperation.parse(text);
        finalResult = (InsertNumberCommand) result;
        assertEquals(expResult.getNumber().getRealPart(), finalResult.getNumber().getRealPart(), 0);
        assertEquals(expResult.getNumber().getImaginaryPart(), finalResult.getNumber().getImaginaryPart(), 0);
        text = "+4.0";
        expResult = new InsertNumberCommand(new ComplexNumber(4.0, 0));
        result = decoratorParserOperation.parse(text);
        finalResult = (InsertNumberCommand) result;
        assertEquals(expResult.getNumber().getRealPart(), finalResult.getNumber().getRealPart(), 0);
        assertEquals(expResult.getNumber().getImaginaryPart(), finalResult.getNumber().getImaginaryPart(), 0);
        text = "+4.0j";
        expResult = new InsertNumberCommand(new ComplexNumber(0, 4.0));
        result = decoratorParserOperation.parse(text);
        finalResult = (InsertNumberCommand) result;
        assertEquals(expResult.getNumber().getRealPart(), finalResult.getNumber().getRealPart(), 0);
        assertEquals(expResult.getNumber().getImaginaryPart(), finalResult.getNumber().getImaginaryPart(), 0);
        text = "-334.0";
        expResult = new InsertNumberCommand(new ComplexNumber(-334, 0));
        result = decoratorParserOperation.parse(text);
        finalResult = (InsertNumberCommand) result;
        assertEquals(expResult.getNumber().getRealPart(), finalResult.getNumber().getRealPart(), 0);
        assertEquals(expResult.getNumber().getImaginaryPart(), finalResult.getNumber().getImaginaryPart(), 0);

    }

    @Test
    public void parseForOperationParser() throws Exception {
        String text = "";
        OperationCommand result = decoratorParserOperation.parse(text);
        assertNull(result);
        text = "++4";
        result = decoratorParserOperation.parse(text);
        assertNull(result);
        text = "--4";
        result = decoratorParserOperation.parse(text);
        assertNull(result);
        text = "+4 +3j";
        ComplexNumber expNumber = new ComplexNumber(4, 3);
        result = decoratorParserOperation.parse(text);
        assertTrue(result instanceof InsertNumberCommand);
        assertEquals(expNumber, ((InsertNumberCommand) result).getNumber());
        text = "+4j";
        result = decoratorParserOperation.parse(text);
        assertTrue(result instanceof InsertNumberCommand);
        expNumber.setRealPart(0);
        expNumber.setImaginaryPart(4);
        assertEquals(expNumber, ((InsertNumberCommand) result).getNumber());

    }

    @Test
    public void testOverOperation() throws Exception {

        input = "over";
        result = decoratorParserOperation.parse(input);
        assertTrue(result instanceof OverCommand);
    }

    @Test
    public void testSwapOperation() throws Exception {
        input = "swap";
        result = decoratorParserOperation.parse(input);
        assertTrue(result instanceof SwapCommand);
    }

    @Test
    public void testDropOperation() throws Exception {
        input = "drop";
        result = decoratorParserOperation.parse(input);

        assertTrue(result instanceof DropCommand);
    }

    @Test
    public void testDupOperation() throws Exception {
        input = "dup";
        result = decoratorParserOperation.parse(input);
        assertTrue(result instanceof DuplicateCommand);
    }

    @Test
    public void testClearOperation() throws Exception {
        input = "clear";
        result = decoratorParserOperation.parse(input);

        assertTrue(result instanceof ClearCommand);

    }

    @Test
    public void testOverOperationSpaceBefore() throws Exception {

        input = " over";
        result = decoratorParserOperation.parse(input);
        assertTrue(result instanceof OverCommand);
    }

    @Test
    public void testSwapOperationSpaceBefore() throws Exception {
        input = " swap";
        result = decoratorParserOperation.parse(input);
        assertTrue(result instanceof SwapCommand);
    }

    @Test
    public void testDropOperationSpaceBefore() throws Exception {
        input = " drop";
        result = decoratorParserOperation.parse(input);

        assertTrue(result instanceof DropCommand);
    }

    @Test
    public void testDupOperationSpaceBefore() throws Exception {
        input = " dup";
        result = decoratorParserOperation.parse(input);

        assertTrue(result instanceof DuplicateCommand);
    }

    @Test
    public void testClearOperationSpaceBefore() throws Exception {
        input = " clear";
        result = decoratorParserOperation.parse(input);

        assertTrue(result instanceof ClearCommand);

    }

    @Test
    public void testOverOperationSpaceAfter() throws Exception {

        input = "over ";
        result = decoratorParserOperation.parse(input);
        assertTrue(result instanceof OverCommand);
    }

    @Test
    public void testSwapOperationSpaceAfter() throws Exception {
        input = "swap ";
        result = decoratorParserOperation.parse(input);
        assertTrue(result instanceof SwapCommand);
    }

    @Test
    public void testDropOperationSpaceAfter() throws Exception {
        input = "drop ";
        result = decoratorParserOperation.parse(input);

        assertTrue(result instanceof DropCommand);
    }

    @Test
    public void testDupOperationSpaceAfter() throws Exception {
        input = "dup ";
        result = decoratorParserOperation.parse(input);

        assertTrue(result instanceof DuplicateCommand);
    }

    @Test
    public void testClearOperationSpaceAfter() throws Exception {
        input = "clear ";
        result = decoratorParserOperation.parse(input);

        assertTrue(result instanceof ClearCommand);

    }

    @Test
    public void testOverOperationSpaceBeforeAndAfter() throws Exception {

        input = " over ";
        result = decoratorParserOperation.parse(input);
        assertTrue(result instanceof OverCommand);
    }

    @Test
    public void testSwapOperationSpaceBeforeAndAfter() throws Exception {
        input = " swap ";
        result = decoratorParserOperation.parse(input);
        assertTrue(result instanceof SwapCommand);
    }

    @Test
    public void testDropOperationSpaceBeforeAndAfter() throws Exception {
        input = " drop ";
        result = decoratorParserOperation.parse(input);
        assertTrue(result instanceof DropCommand);
    }

    @Test
    public void testDupOperationSpaceBeforeAndAfter() throws Exception {
        input = " dup ";
        result = decoratorParserOperation.parse(input);
        assertTrue(result instanceof DuplicateCommand);
    }

    @Test
    public void testClearOperationSpaceBeforeAndAfter() throws Exception {
        input = " clear ";
        result = decoratorParserOperation.parse(input);
        assertTrue(result instanceof ClearCommand);

    }

    @Test
    public void testHelloWordOperation() throws Exception {
        input = "hello word";
        result = decoratorParserOperation.parse(input);
        assertNull(result);

    }
     /**
     * Test of checkOperation method, of class ParserString.
     */
    /*-----------new variable------------*/
    @Test
    public void newVariableParseTest() throws OperationNotFoundException, Exception {
        input = ">xx";
        result = decoratorParserOperation.parse(input);
        assertNull(result);
        input = ">+";
        result = decoratorParserOperation.parse(input);
        assertNull(result);
    }

    @Test
    public void newVariableParseTestWithSpacesBefore() throws OperationNotFoundException, Exception {
        input = " >x";
        result =decoratorParserOperation.parse(input);
        assertTrue(result instanceof NewVariableCommand);
    }

    @Test
    public void newVariableParseTestWithSpacesAfter() throws OperationNotFoundException, Exception {
        input = ">x ";
        result = decoratorParserOperation.parse(input);
        assertTrue(result instanceof NewVariableCommand);

    }

    @Test
    public void newVariableParseTestWithSpacesBeforeAndAfter() throws OperationNotFoundException, Exception {
        input = " >x ";
        result = decoratorParserOperation.parse(input);
        assertTrue(result instanceof NewVariableCommand);
    }

    @Test
    public void newVariableButItsANumber() throws OperationNotFoundException, Exception {
        input = ">1";
        result = decoratorParserOperation.parse(input);
        assertNull(result);
    }
    /*------------Push Variable-----------------*/
    @Test
    public void pushVariableParseTest() throws OperationNotFoundException, Exception {
        input = "<x";
        result = decoratorParserOperation.parse(input);
        assertTrue(result instanceof PushVariableCommand);
    }

    @Test
    public void pushVariableParseTestWithSpacesBefore() throws OperationNotFoundException, Exception {
        input = " <x";
        result = decoratorParserOperation.parse(input);
        assertTrue(result instanceof PushVariableCommand);
    }

    @Test
    public void pushVariableParseTestWithSpacesAfter() throws OperationNotFoundException, Exception {
        input = "<x ";
        result = decoratorParserOperation.parse(input);
        assertTrue(result instanceof PushVariableCommand);
    }

    @Test
    public void pushVariableParseTestWithSpacesBeforeAndAfter() throws OperationNotFoundException, Exception {
        input = " <x ";
        result = decoratorParserOperation.parse(input);
        assertTrue(result instanceof PushVariableCommand);
    }

    @Test
    public void invalidPushVariableParseTest() throws OperationNotFoundException, Exception {
        input = "<xx";
        result = decoratorParserOperation.parse(input);
        assertNull(result);
        input = "<+";
        result = decoratorParserOperation.parse(input);
        assertNull(result);
    }

    @Test
    public void pushVariableButItsANumber() throws OperationNotFoundException, Exception {
        input = "<1";
        result = decoratorParserOperation.parse(input);
        assertNull(result);
    }

    /*--------------------- +var------------------------------------*/

    @Test
    public void SumVariableParseTestUnexistingVariable() throws OperationNotFoundException, Exception {
        VariablesDict.getInstance().getTable().clear();
        input = "+x";
        result = decoratorParserOperation.parse(input);
        assertNull(result);

    }

    @Test
    public void SumVariableParseTest() throws OperationNotFoundException, Exception {
        input = ">x";
        result =decoratorParserOperation.parse(input);
        solver.resolveOperation(result);

        input = "+x";
        result = decoratorParserOperation.parse(input);
        assertTrue(result instanceof SumVariableCommand);
    }

    @Test
    public void SumVariableJNonExistingParseTest() throws OperationNotFoundException, Exception, NonExistingVariable {
        VariablesDict.getInstance().getTable().clear();

        input = "+j";
        result = decoratorParserOperation.parse(input);
        assertEquals(true, result instanceof InsertNumberCommand);
    }

    @Test(expected = CollisionException.class)
    public void SumVariableJExistingParseTest() throws OperationNotFoundException, Exception {
        VariablesDict.getInstance().getTable().clear();

        solver.getStructureStack().push(new ComplexNumber(1, 1));
        input = ">j";
        result = decoratorParserOperation.parse(input);
        solver.resolveOperation(result);

        input = "+j";
        result = decoratorParserOperation.parse(input);
    }

    public void SumVariableButItsANumber() throws OperationNotFoundException, Exception {

        input = "+1";
        result = decoratorParserOperation.parse(input);
        assertNull(result);
    }

    /*--------------------- -var ------------------------------------*/
    @Test
    public void DiffVariableParseTestUnexistingVariable() throws OperationNotFoundException, Exception {
        VariablesDict.getInstance().getTable().clear();

        input = "-x";
        result = decoratorParserOperation.parse(input);
        assertNull(result);

    }

    @Test
    public void DiffVariableParseTest() throws OperationNotFoundException, Exception {
        input = ">x";
        result =decoratorParserOperation.parse(input);
        solver.resolveOperation(result);
        input = "-x";
        result = decoratorParserOperation.parse(input);
        assertTrue(result instanceof DiffVariableCommand);
    }

    @Test
    public void DiffVariableJNonExistingParseTest() throws OperationNotFoundException, Exception {
        VariablesDict.getInstance().getTable().clear();

        input = "-j";
        result = decoratorParserOperation.parse(input);
        assertEquals(true, result instanceof  InsertNumberCommand);

    }

    @Test(expected = CollisionException.class)
    public void DiffVariableJExistingParseTest() throws OperationNotFoundException, Exception {
        VariablesDict.getInstance().getTable().clear();

        input = ">j";
        result =decoratorParserOperation.parse(input);
        solver.resolveOperation(result);

        input = "-j";
        result = decoratorParserOperation.parse(input);
    }

    public void DiffVariableButItsANumber() throws OperationNotFoundException, Exception {

        input = "-1";
        result = decoratorParserOperation.parse(input);
        assertNull(result);
    }

    /*---------------------Wrong Strings------------------------------------*/
    @Test
    public void JusVariableNameParseTest() throws OperationNotFoundException, Exception {
        input = "x";
        result = decoratorParserOperation.parse(input);
        assertNull(result);
    }

    @Test(expected = NullPointerException.class)
    public void nullTest() throws OperationNotFoundException, Exception {
        input = null;
        result = decoratorParserOperation.parse(input);
        assertNull(result);
    }

    @Test
    public void emptyStringTest() throws OperationNotFoundException, Exception {
        input = "";
        result = decoratorParserOperation.parse(input);
        assertNull(result);
    }

    @Test
    public void WrongNameParseTest() throws OperationNotFoundException, Exception {

        input = "xx";
        result =decoratorParserOperation.parse(input);
        assertNull(result);
    }

    @Test
    public void rhombusTest() throws OperationNotFoundException, Exception {

        input = "<>";
        result = decoratorParserOperation.parse(input);
        assertNull(result);

    }

    @Test
    public void doubleRightArrowTest() throws OperationNotFoundException, Exception {

        input = ">>";
        result = decoratorParserOperation.parse(input);
        assertNull(result);

    }

    @Test
    public void doubleLeftArrowTest() throws OperationNotFoundException, Exception {

        input = "<<";
        result =decoratorParserOperation.parse(input);
        assertNull(result);

    }

    @Test
    public void invalidVarialeSumTest() throws OperationNotFoundException, Exception {
        input = "+<";
        result =decoratorParserOperation.parse(input);
        assertNull(result);
    }

    @Test
    public void invalidVarialeDiffTest() throws OperationNotFoundException, InvalidVariableNameException, Exception {
        input = "-<";
        result = decoratorParserOperation.parse(input);
        assertNull(result);
    }

    @Test
    public void GreaterLessTest() throws OperationNotFoundException, Exception {

        input = "><";
        result = decoratorParserOperation.parse(input);
        assertNull(result);

    }

    /*---------------------Save------------------------------------*/
    @Test
    public void saveTest() throws OperationNotFoundException, Exception {

        input = "save";
        result = decoratorParserOperation.parse(input);
        assertTrue(result instanceof SaveVariableCommand);
    }

    @Test
    public void saveTestWithSpacesInside() throws OperationNotFoundException, Exception {

        input = "s a v e";
        result = decoratorParserOperation.parse(input);
        assertNull(result);
    }

    @Test
    public void saveTestWithSpacesBefore() throws OperationNotFoundException, Exception {

        input = " save";
        result = decoratorParserOperation.parse(input);
        assertTrue(result instanceof SaveVariableCommand);
    }

    @Test
    public void saveTestWithSpacesAfter() throws OperationNotFoundException, Exception {

        input = "save ";
        result = decoratorParserOperation.parse(input);
        assertTrue(result instanceof SaveVariableCommand);
    }

    @Test
    public void saveTestWithSpacesBeforeAndAfter() throws OperationNotFoundException, Exception {

        input = " save ";
        result = decoratorParserOperation.parse(input);
        assertTrue(result instanceof SaveVariableCommand);
    }

    /*---------------------Restore------------------------------------*/
    @Test
    public void restoreTest() throws OperationNotFoundException, Exception {

        input = "restore";
        result = decoratorParserOperation.parse(input);
        assertTrue(result instanceof RestoreVariableCommand);
    }

    @Test
    public void restoreTestWithSpacesInside() throws OperationNotFoundException, Exception {

        input = "r e s t o r e";
        result =decoratorParserOperation.parse(input);
        assertNull(result);
    }

    @Test
    public void restoreTestWithSpacesBefore() throws OperationNotFoundException, Exception {

        input = " restore";
        result = decoratorParserOperation.parse(input);
        assertTrue(result instanceof RestoreVariableCommand);
    }

    @Test
    public void restoreTestWithSpacesAfter() throws OperationNotFoundException, Exception {

        input = "restore ";
        result = decoratorParserOperation.parse(input);
        assertTrue(result instanceof RestoreVariableCommand);
    }

    @Test
    public void restoreTestWithSpacesBeforeAndAfter() throws OperationNotFoundException, Exception {

        input = " restore ";
        result = decoratorParserOperation.parse(input);
        assertTrue(result instanceof RestoreVariableCommand);
    }

}
