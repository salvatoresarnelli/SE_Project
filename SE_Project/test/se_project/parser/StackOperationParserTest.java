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


        input = "over";
        result = ((StackOperationParser) parser).parse(input);
        assertTrue(result instanceof OverCommand);
        input = "swap";
        result = ((StackOperationParser) parser).parse(input);
        assertTrue(result instanceof SwapCommand);
        input = "drop";
        result = ((StackOperationParser) parser).parse(input);
        assertTrue(result instanceof DropCommand);
        input = "dup";
        result = ((StackOperationParser) parser).parse(input);
        assertTrue(result instanceof DuplicateCommand);
        input = "clear";
        result = ((StackOperationParser) parser).parse(input);
        assertTrue(result instanceof ClearCommand);
        input = "sqrt";
        result = ((StackOperationParser) parser).parse(input);
        assertNull(result);
        input = "hello word";
        result = ((StackOperationParser) parser).parse(input);
        assertNull(result);
        input = "\nsqrt";
        result = ((StackOperationParser) parser).parse(input);
        assertTrue(result instanceof SqrtCommand);
    }
}
