/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se_project.commands;

import java.util.HashMap;
import java.util.LinkedList;
import se_project.commands.not_implemented_yet.NewVariableCommand;
import se_project.commands.not_implemented_yet.PushVariableCommand;
import se_project.commands.operationsCommands.ColonsCommand;
import se_project.commands.operationsCommands.DotCommand;
import se_project.commands.operationsCommands.MinusCommand;
import se_project.commands.operationsCommands.PlusCommand;
import se_project.commands.operationsCommands.SignCommand;
import se_project.commands.operationsCommands.SqrtCommand;
import se_project.commands.stackCommands.ClearCommand;
import se_project.commands.stackCommands.DropCommand;
import se_project.commands.stackCommands.DuplicateCommand;
import se_project.commands.stackCommands.SwapCommand;

/**
 *
 * @author aless
 */
public class OperationsFactory {

    public HashMap<String, ExecuteUserDefinedOperationCommand> operationsTable;

    public OperationsFactory() {

    }

    public void addCommand(String name, LinkedList<OperationCommand> command) {
        ExecuteUserDefinedOperationCommand userDefinedCommand = new ExecuteUserDefinedOperationCommand(name, command);
        operationsTable.put(name, userDefinedCommand);

    }

    public OperationCommand getOperationCommand(String type) throws OperationNotFoundException {
        if(type.startsWith(">") && type.length()==2)
            type="NewVariableCommand";
        if(type.startsWith("<") && type.length()==2)
            type="PushVariableCommand";
        switch (type) {
            case "+":
                return new PlusCommand();
            case "-":
                return new MinusCommand();

            case "*":
                return new DotCommand();
            case ":":
                return new ColonsCommand();
            case "+-":
                return new SignCommand();
            case "sqrt":
                return new SqrtCommand();
            case "swap":
                return new SwapCommand();
            case "drop":
                return new DropCommand();
            case "dup":
                return new DuplicateCommand();
            case "clear":
                return new ClearCommand();
            case "NewVariableCommand":
                return new NewVariableCommand();
            case "PushVariableCommand":
                return new PushVariableCommand();
        }
        throw new OperationNotFoundException();
    }

    public OperationCommand getOperationCommand(String type, HashMap<String, OperationCommand> table) throws OperationNotFoundException {
        try {
            return getOperationCommand(type);
        }catch(OperationNotFoundException ex){
        if (table.containsKey(type)) {
            return table.get(type);
        }

        throw new OperationNotFoundException();
    }
        
    

    }
}
