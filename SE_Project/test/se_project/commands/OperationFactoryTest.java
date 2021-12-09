/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se_project.commands;

import se_project.exceptions.OperationNotFoundException;
import se_project.commands.userDefinedOperations.ExecuteUserDefinedOperationCommand;
import java.util.HashMap;
import java.util.LinkedList;
import org.junit.After;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import se_project.ComplexNumber;
import se_project.commands.variablesCommands.DiffVariableCommandTest;
import se_project.commands.variablesCommands.NewVariableCommand;
import se_project.commands.variablesCommands.PushVariableCommand;
import se_project.commands.variablesCommands.SumVariableCommand;
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

/**
 *
 * @author aless
 */
public class OperationFactoryTest {

    OperationsFactory factory;
    HashMap<String, OperationCommand> commandTable;

    public OperationFactoryTest() {
    }

    @Before
    public void setUp() {
        commandTable = new HashMap<>();
        factory = new OperationsFactory();

    }

    @After
    public void tearDown() {
    }

    @Test
    public void testPlusCreation() throws OperationNotFoundException {
        OperationCommand result = factory.getOperationCommand("+", commandTable);
        assertTrue(result instanceof PlusCommand);
    }

    @Test
    public void testMinusCreation() throws OperationNotFoundException {
        OperationCommand result = factory.getOperationCommand("-", commandTable);
        assertTrue(result instanceof MinusCommand);
    }

    @Test
    public void testDotCreation() throws OperationNotFoundException {
        OperationCommand result = factory.getOperationCommand("*", commandTable);
        assertTrue(result instanceof DotCommand);
    }

    @Test
    public void testColonsCreation() throws OperationNotFoundException {
        OperationCommand result = factory.getOperationCommand(":", commandTable);
        assertTrue(result instanceof ColonsCommand);
    }

    @Test
    public void testSignCreation() throws OperationNotFoundException {
        OperationCommand result = factory.getOperationCommand("+-", commandTable);
        assertTrue(result instanceof SignCommand);
    }

    @Test
    public void testSqrtCreation() throws OperationNotFoundException {
        OperationCommand result = factory.getOperationCommand("sqrt", commandTable);
        assertTrue(result instanceof SqrtCommand);
    }

    @Test
    public void testUserDefinedOperationCreation() throws OperationNotFoundException {
        LinkedList<OperationCommand> commandList = new LinkedList<>();
        commandList.add(new MinusCommand());
        commandList.add(new PlusCommand());
        commandTable.put("prova", new ExecuteUserDefinedOperationCommand("prova", commandList));
        OperationCommand result = factory.getOperationCommand("prova", commandTable);
        assertTrue(result instanceof ExecuteUserDefinedOperationCommand);
        LinkedList<OperationCommand> resultCommandList = ((ExecuteUserDefinedOperationCommand) result).getCommandList();
        for (int i = 0; i < resultCommandList.size(); i++) {
            assertTrue((resultCommandList.get(i)).getClass().isInstance((commandList.get(i))));
        }
    }

    @Test
    public void testVariableInsertCreation() throws OperationNotFoundException {

        OperationCommand result = factory.getOperationCommand("NewVariableCommand", commandTable);
        assertTrue(result instanceof NewVariableCommand);
    }

    @Test
    public void testVariablePushOperationCreation() throws OperationNotFoundException {
        OperationCommand result = factory.getOperationCommand("PushVariableCommand", commandTable);
        assertTrue(result instanceof PushVariableCommand);

    }

    @Test
    public void testVariableSumCreation() throws OperationNotFoundException {

        OperationCommand result = factory.getOperationCommand("SumVariableCommand", commandTable);
        assertTrue(result instanceof SumVariableCommand);

    }

    @Test
    public void testVariableDifferenceCreation() throws OperationNotFoundException {

        OperationCommand result = factory.getOperationCommand("DiffVariableCommand", commandTable);
        assertTrue(result instanceof DiffVariableCommand);

    }

    @Test
    public void testSwapOperationCreation() throws OperationNotFoundException {
        OperationCommand result = factory.getOperationCommand("DiffVariableCommand", commandTable);
        assertTrue(result instanceof DiffVariableCommand);
    }

    @Test
    public void testClearOperationCreation() throws OperationNotFoundException {
        OperationCommand result = factory.getOperationCommand("clear", commandTable);
        assertTrue(result instanceof ClearCommand);
    }

    @Test
    public void testDropOperationCreation() throws OperationNotFoundException {
        OperationCommand result = factory.getOperationCommand("drop", commandTable);
        assertTrue(result instanceof DropCommand);
    }

    @Test
    public void testDupOperationCreation() throws OperationNotFoundException {
        OperationCommand result = factory.getOperationCommand("dup", commandTable);
        assertTrue(result instanceof DuplicateCommand);
    }

    @Test
    public void testOverOperationCreation() throws OperationNotFoundException {
        OperationCommand result = factory.getOperationCommand("over", commandTable);
        assertTrue(result instanceof OverCommand);
    }

    @Test(expected = OperationNotFoundException.class)
    public void UndefinedCommandCreation() throws OperationNotFoundException {
        OperationCommand result = factory.getOperationCommand("GenericCommand", commandTable);
    }
    @Test(expected = NullPointerException.class)
    public void NullCommandCreation() throws OperationNotFoundException {
        OperationCommand result = factory.getOperationCommand(null, commandTable);
    }
    

}
