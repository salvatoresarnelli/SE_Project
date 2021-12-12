/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se_project.parser;

import org.junit.After;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import se_project.commands.OperationCommand;
import se_project.commands.operationsCommands.ColonsCommand;
import se_project.commands.operationsCommands.DotCommand;
import se_project.commands.operationsCommands.MinusCommand;
import se_project.commands.operationsCommands.PlusCommand;
import se_project.commands.operationsCommands.SignCommand;
import se_project.commands.operationsCommands.SqrtCommand;
import se_project.commands.stackCommands.ClearCommand;
import se_project.commands.stackCommands.DropCommand;
import se_project.commands.stackCommands.DuplicateCommand;
import se_project.commands.stackCommands.OverCommand;
import se_project.commands.stackCommands.SwapCommand;

/**
 *
 * @author aless
 */
public class StackOperationParserTest {

    private StackOperationParser parser;
    private OperationCommand result;
    private String input;

    @Before
    public void setUp() {
        input = new String();
        parser = new StackOperationParser(new ParserString());

    }

    @After
    public void tearDown() {
    }

    @Test
    public void testCheckOperation() throws Exception {
    }

    @Test
    public void testOverOperation() throws Exception {

        input = "over";
        result = ((StackOperationParser) parser).parse(input);
        assertTrue(result instanceof OverCommand);
    }

    @Test
    public void testSwapOperation() throws Exception {
        input = "swap";
        result = ((StackOperationParser) parser).parse(input);
        assertTrue(result instanceof SwapCommand);
    }

    @Test
    public void testDropOperation() throws Exception {
        input = "drop";
        result = ((StackOperationParser) parser).parse(input);

        assertTrue(result instanceof DropCommand);
    }

    @Test
    public void testDupOperation() throws Exception {
        input = "dup";
        result = ((StackOperationParser) parser).parse(input);

        assertTrue(result instanceof DuplicateCommand);
    }
    @Test
    public void testClearOperation() throws Exception {
        input  = "clear";
    result  = ((StackOperationParser) parser).parse(input);

    assertTrue(result 
    
    
    instanceof ClearCommand);
    
    }
    
    @Test
    public void testOverOperationSpaceBefore() throws Exception {

        input = " over";
        result = ((StackOperationParser) parser).parse(input);
        assertTrue(result instanceof OverCommand);
    }

    @Test
    public void testSwapOperationSpaceBefore() throws Exception {
        input = " swap";
        result = ((StackOperationParser) parser).parse(input);
        assertTrue(result instanceof SwapCommand);
    }

    @Test
    public void testDropOperationSpaceBefore() throws Exception {
        input = " drop";
        result = ((StackOperationParser) parser).parse(input);

        assertTrue(result instanceof DropCommand);
    }

    @Test
    public void testDupOperationSpaceBefore() throws Exception {
        input = " dup";
        result = ((StackOperationParser) parser).parse(input);

        assertTrue(result instanceof DuplicateCommand);
    }
    @Test
    public void testClearOperationSpaceBefore() throws Exception {
        input  = " clear";
    result  = ((StackOperationParser) parser).parse(input);

    assertTrue(result 
    
    
    instanceof ClearCommand);
    
    }
    
    
    @Test
    public void testOverOperationSpaceAfter() throws Exception {

        input = "over ";
        result = ((StackOperationParser) parser).parse(input);
        assertTrue(result instanceof OverCommand);
    }

    @Test
    public void testSwapOperationSpaceAfter() throws Exception {
        input = "swap ";
        result = ((StackOperationParser) parser).parse(input);
        assertTrue(result instanceof SwapCommand);
    }

    @Test
    public void testDropOperationSpaceAfter() throws Exception {
        input = "drop ";
        result = ((StackOperationParser) parser).parse(input);

        assertTrue(result instanceof DropCommand);
    }

    @Test
    public void testDupOperationSpaceAfter() throws Exception {
        input = "dup ";
        result = ((StackOperationParser) parser).parse(input);

        assertTrue(result instanceof DuplicateCommand);
    }
    @Test
    public void testClearOperationSpaceAfter() throws Exception {
        input  = "clear ";
    result  = ((StackOperationParser) parser).parse(input);

    assertTrue(result 
    
    
    instanceof ClearCommand);
    
    }
    
    @Test
    public void testOverOperationSpaceBeforeAndAfter() throws Exception {

        input = " over ";
        result = ((StackOperationParser) parser).parse(input);
        assertTrue(result instanceof OverCommand);
    }

    @Test
    public void testSwapOperationSpaceBeforeAndAfter() throws Exception {
        input = " swap ";
        result = ((StackOperationParser) parser).parse(input);
        assertTrue(result instanceof SwapCommand);
    }

    @Test
    public void testDropOperationSpaceBeforeAndAfter() throws Exception {
        input = " drop ";
        result = ((StackOperationParser) parser).parse(input);

        assertTrue(result instanceof DropCommand);
    }

    @Test
    public void testDupOperationSpaceBeforeAndAfter() throws Exception {
        input = " dup ";
        result = ((StackOperationParser) parser).parse(input);

        assertTrue(result instanceof DuplicateCommand);
    }
    @Test
    public void testClearOperationSpaceBeforeAndAfter() throws Exception {
        input  = " clear ";
    result  = ((StackOperationParser) parser).parse(input);

    assertTrue(result 
    
    
    instanceof ClearCommand);
    
    }
    
    
    @Test
    public void testHelloWordOperation() throws Exception {
    input  = "hello word";
    result  = ((StackOperationParser) parser).parse(input);

    assertNull(result);
    
    }
        
}
