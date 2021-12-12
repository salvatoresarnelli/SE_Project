/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se_project.parser;

import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import se_project.ComplexNumber;
import se_project.Solver;
import se_project.VariablesDict;
import se_project.commands.InsertNumberCommand;
import se_project.commands.OperationCommand;
import se_project.exceptions.OperationNotFoundException;
import se_project.commands.operationsCommands.ColonsCommand;
import se_project.commands.operationsCommands.DotCommand;
import se_project.commands.operationsCommands.MinusCommand;
import se_project.commands.operationsCommands.PlusCommand;
import se_project.commands.operationsCommands.SignCommand;
import se_project.commands.operationsCommands.SqrtCommand;
import se_project.commands.variablesCommands.DiffVariableCommand;
import se_project.commands.variablesCommands.NewVariableCommand;
import se_project.commands.variablesCommands.PushVariableCommand;
import se_project.commands.variablesCommands.RestoreVariableCommand;
import se_project.commands.variablesCommands.SaveVariableCommand;
import se_project.commands.variablesCommands.SumVariableCommand;
import se_project.exceptions.CollisionException;
import se_project.exceptions.ExistingNameException;
import se_project.exceptions.InvalidVariableNameException;
import se_project.exceptions.NonExistingVariable;

/**
 *
 * @author aless
 */
public class VariableParserTest {

    private ParserString parser;
    private OperationCommand result;
    private String input;
    private Solver solver;

    @Before
    public void setUp() {
        input = new String();
        parser = new VariableParser(new ParserString());
        solver = Solver.getInstance();
        solver.getStructureStack().push(new ComplexNumber(1, 1));

    }

    @After
    public void tearDown() {
    }

    /**
     * Test of checkOperation method, of class ParserString.
     */
    /*-----------new variable------------*/
    @Test
    public void newVariableParseTest() throws OperationNotFoundException, Exception {
        input = ">xx";
        result = ((VariableParser) parser).parse(input);
        assertNull(result);
        input = ">+";
        result = ((VariableParser) parser).parse(input);
        assertNull(result);
    }

    @Test
    public void newVariableParseTestWithSpacesBefore() throws OperationNotFoundException, Exception {
        input = " >x";
        result = ((VariableParser) parser).parse(input);
        assertTrue(result instanceof NewVariableCommand);
    }

    @Test
    public void newVariableParseTestWithSpacesAfter() throws OperationNotFoundException, Exception {
        input = ">x ";
        result = ((VariableParser) parser).parse(input);
        assertTrue(result instanceof NewVariableCommand);

    }

    @Test
    public void newVariableParseTestWithSpacesBeforeAndAfter() throws OperationNotFoundException, Exception {
        input = " >x ";
        result = ((VariableParser) parser).parse(input);
        assertTrue(result instanceof NewVariableCommand);
    }

    @Test
    public void newVariableButItsANumber() throws OperationNotFoundException, Exception {
        input = ">1";
        result = ((VariableParser) parser).parse(input);
        assertNull(result);
    }
    /*------------Push Variable-----------------*/
    @Test
    public void pushVariableParseTest() throws OperationNotFoundException, Exception {
        input = "<x";
        result = ((VariableParser) parser).parse(input);
        assertTrue(result instanceof PushVariableCommand);
    }

    @Test
    public void pushVariableParseTestWithSpacesBefore() throws OperationNotFoundException, Exception {
        input = " <x";
        result = ((VariableParser) parser).parse(input);
        assertTrue(result instanceof PushVariableCommand);
    }

    @Test
    public void pushVariableParseTestWithSpacesAfter() throws OperationNotFoundException, Exception {
        input = "<x ";
        result = ((VariableParser) parser).parse(input);
        assertTrue(result instanceof PushVariableCommand);
    }

    @Test
    public void pushVariableParseTestWithSpacesBeforeAndAfter() throws OperationNotFoundException, Exception {
        input = " <x ";
        result = ((VariableParser) parser).parse(input);
        assertTrue(result instanceof PushVariableCommand);
    }

    @Test
    public void invalidPushVariableParseTest() throws OperationNotFoundException, Exception {
        input = "<xx";
        result = ((VariableParser) parser).parse(input);
        assertNull(result);
        input = "<+";
        result = ((VariableParser) parser).parse(input);
        assertNull(result);
    }

    @Test
    public void pushVariableButItsANumber() throws OperationNotFoundException, Exception {
        input = "<1";
        result = ((VariableParser) parser).parse(input);
        assertNull(result);
    }

    /*--------------------- +var------------------------------------*/

    @Test
    public void SumVariableParseTestUnexistingVariable() throws OperationNotFoundException, Exception {
        VariablesDict.getInstance().getTable().clear();
        input = "+x";
        result = ((VariableParser) parser).parse(input);
        assertNull(result);

    }

    @Test
    public void SumVariableParseTest() throws OperationNotFoundException, Exception {
        input = ">x";
        result = ((VariableParser) parser).parse(input);
        solver.resolveOperation(result);

        input = "+x";
        result = ((VariableParser) parser).parse(input);
        assertTrue(result instanceof SumVariableCommand);
    }

    @Test
    public void SumVariableJNonExistingParseTest() throws OperationNotFoundException, Exception, NonExistingVariable {
        VariablesDict.getInstance().getTable().clear();

        input = "+j";
        result = ((VariableParser) parser).parse(input);
        assertNull(result);
    }

    @Test(expected = CollisionException.class)
    public void SumVariableJExistingParseTest() throws OperationNotFoundException, Exception {
        VariablesDict.getInstance().getTable().clear();

        solver.getStructureStack().push(new ComplexNumber(1, 1));
        input = ">j";
        result = ((VariableParser) parser).parse(input);
        solver.resolveOperation(result);

        input = "+j";
        result = ((VariableParser) parser).parse(input);
    }

    public void SumVariableButItsANumber() throws OperationNotFoundException, Exception {

        input = "+1";
        result = ((VariableParser) parser).parse(input);
        assertNull(result);
    }

    /*--------------------- -var ------------------------------------*/
    @Test
    public void DiffVariableParseTestUnexistingVariable() throws OperationNotFoundException, Exception {
        VariablesDict.getInstance().getTable().clear();

        input = "-x";
        result = ((VariableParser) parser).parse(input);
        assertNull(result);

    }

    @Test
    public void DiffVariableParseTest() throws OperationNotFoundException, Exception {
        input = ">x";
        result = ((VariableParser) parser).parse(input);
        solver.resolveOperation(result);
        input = "-x";
        result = ((VariableParser) parser).parse(input);
        assertTrue(result instanceof DiffVariableCommand);
    }

    @Test
    public void DiffVariableJNonExistingParseTest() throws OperationNotFoundException, Exception {
        VariablesDict.getInstance().getTable().clear();

        input = "-j";
        result = ((VariableParser) parser).parse(input);
        assertNull(result);

    }

    @Test(expected = CollisionException.class)
    public void DiffVariableJExistingParseTest() throws OperationNotFoundException, Exception {
        VariablesDict.getInstance().getTable().clear();

        input = ">j";
        result = ((VariableParser) parser).parse(input);
        solver.resolveOperation(result);

        input = "-j";
        result = ((VariableParser) parser).parse(input);
    }

    public void DiffVariableButItsANumber() throws OperationNotFoundException, Exception {

        input = "-1";
        result = ((VariableParser) parser).parse(input);
        assertNull(result);
    }

    /*---------------------Wrong Strings------------------------------------*/
    @Test
    public void JusVariableNameParseTest() throws OperationNotFoundException, Exception {
        input = "x";
        result = ((VariableParser) parser).parse(input);
        assertNull(result);
    }

    @Test(expected = NullPointerException.class)
    public void nullTest() throws OperationNotFoundException, Exception {
        input = null;
        result = ((VariableParser) parser).parse(input);
        assertNull(result);
    }

    @Test
    public void emptyStringTest() throws OperationNotFoundException, Exception {
        input = "";
        result = ((VariableParser) parser).parse(input);
        assertNull(result);
    }

    @Test
    public void WrongNameParseTest() throws OperationNotFoundException, Exception {

        input = "xx";
        result = ((VariableParser) parser).parse(input);
        assertNull(result);
    }

    @Test
    public void rhombusTest() throws OperationNotFoundException, Exception {

        input = "<>";
        result = ((VariableParser) parser).parse(input);
        assertNull(result);

    }

    @Test
    public void doubleRightArrowTest() throws OperationNotFoundException, Exception {

        input = ">>";
        result = ((VariableParser) parser).parse(input);
        assertNull(result);

    }

    @Test
    public void doubleLeftArrowTest() throws OperationNotFoundException, Exception {

        input = "<<";
        result = ((VariableParser) parser).parse(input);
        assertNull(result);

    }

    @Test
    public void invalidVarialeSumTest() throws OperationNotFoundException, Exception {
        input = "+<";
        result = ((VariableParser) parser).parse(input);
        assertNull(result);
    }

    @Test(expected = InvalidVariableNameException.class)
    public void invalidVarialeDiffTest() throws OperationNotFoundException, InvalidVariableNameException, Exception {
        input = "-<";
        result = ((VariableParser) parser).parse(input);
        assertNull(result);
    }

    @Test
    public void GreaterLessTest() throws OperationNotFoundException, Exception {

        input = "><";
        result = ((VariableParser) parser).parse(input);
        assertNull(result);

    }

    /*---------------------Save------------------------------------*/
    @Test
    public void saveTest() throws OperationNotFoundException, Exception {

        input = "save";
        result = ((VariableParser) parser).parse(input);
        assertTrue(result instanceof SaveVariableCommand);
    }

    @Test
    public void saveTestWithSpacesInside() throws OperationNotFoundException, Exception {

        input = "s a v e";
        result = ((VariableParser) parser).parse(input);
        assertNull(result);
    }

    @Test
    public void saveTestWithSpacesBefore() throws OperationNotFoundException, Exception {

        input = " save";
        result = ((VariableParser) parser).parse(input);
        assertTrue(result instanceof SaveVariableCommand);
    }

    @Test
    public void saveTestWithSpacesAfter() throws OperationNotFoundException, Exception {

        input = "save ";
        result = ((VariableParser) parser).parse(input);
        assertTrue(result instanceof SaveVariableCommand);
    }

    @Test
    public void saveTestWithSpacesBeforeAndAfter() throws OperationNotFoundException, Exception {

        input = " save ";
        result = ((VariableParser) parser).parse(input);
        assertTrue(result instanceof SaveVariableCommand);
    }

    /*---------------------Restore------------------------------------*/
    @Test
    public void restoreTest() throws OperationNotFoundException, Exception {

        input = "restore";
        result = ((VariableParser) parser).parse(input);
        assertTrue(result instanceof RestoreVariableCommand);
    }

    @Test
    public void restoreTestWithSpacesInside() throws OperationNotFoundException, Exception {

        input = "r e s t o r e";
        result = ((VariableParser) parser).parse(input);
        assertNull(result);
    }

    @Test
    public void restoreTestWithSpacesBefore() throws OperationNotFoundException, Exception {

        input = " restore";
        result = ((VariableParser) parser).parse(input);
        assertTrue(result instanceof RestoreVariableCommand);
    }

    @Test
    public void restoreTestWithSpacesAfter() throws OperationNotFoundException, Exception {

        input = "restore ";
        result = ((VariableParser) parser).parse(input);
        assertTrue(result instanceof RestoreVariableCommand);
    }

    @Test
    public void restoreTestWithSpacesBeforeAndAfter() throws OperationNotFoundException, Exception {

        input = " restore ";
        result = ((VariableParser) parser).parse(input);
        assertTrue(result instanceof RestoreVariableCommand);
    }


}
