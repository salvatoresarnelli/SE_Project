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
import se_project.commands.InsertNumberCommand;
import se_project.commands.OperationCommand;
import se_project.commands.operationsCommands.ColonsCommand;
import se_project.commands.operationsCommands.DotCommand;
import se_project.commands.operationsCommands.MinusCommand;
import se_project.commands.operationsCommands.PlusCommand;
import se_project.commands.operationsCommands.SignCommand;
import se_project.commands.operationsCommands.SqrtCommand;

/**
 *
 * @author aless
 */
public class OperationParserTest {
    private ParserString parser;
    private OperationCommand result;
    private String input;
    
    
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
}
