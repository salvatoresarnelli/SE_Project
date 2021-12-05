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
import se_project.commands.variablesCommands.SumVariableCommand;
import se_project.exceptions.InvalidVariableNameException;

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
    public void pushVariableParseTest() throws OperationNotFoundException, Exception {
        input = "<x";
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
    public void SumVariableParseTestUnexistingVariable() throws OperationNotFoundException, Exception {
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
    public void DiffVariableParseTestUnexistingVariable() throws OperationNotFoundException, Exception {
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
    public void JusVariableNameParseTest() throws OperationNotFoundException, Exception {
        input = "x";
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
    /*
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
     */
}
