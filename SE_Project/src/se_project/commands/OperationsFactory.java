/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se_project.commands;

import java.util.HashMap;
import java.util.LinkedList;
import se_project.commands.variables_commands.DiffVariableCommand;
import se_project.commands.variables_commands.NewVariableCommand;
import se_project.commands.variables_commands.PushVariableCommand;
import se_project.commands.variables_commands.SumVariableCommand;
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
        if(type.startsWith("+") && type.length()==2 && type.charAt(1)!='-')
            type="SumVariableCommand";
        if(type.startsWith("-") && type.length()==2)
            type="DiffVariableCommand";
        if(type.equals("+"))
                return new PlusCommand();
        if(type.equals("-"))
                return new MinusCommand();
        if(type.equals("*"))
                return new DotCommand();
        if(type.equals(":"))
                return new ColonsCommand();
        if(type.equals("+-"))
                return new SignCommand();
        if(type.equals("sqrt"))
                return new SqrtCommand();
        if(type.equals("swap"))
                return new SwapCommand();
        if(type.equals("drop"))
                return new DropCommand();
        if(type.equals("dup"))
                return new DuplicateCommand();
        if(type.equals("clear"))
                return new ClearCommand();
        if(type.equals("over"))
                return new OverCommand();
        if(type.equals("NewVariableCommand"))
                return new NewVariableCommand();
        if(type.equals("PushVariableCommand"))
                return new PushVariableCommand();
        if(type.equals("SumVariableCommand"))
                return new SumVariableCommand();
        if(type.equals("DiffVariableCommand"))
                return new DiffVariableCommand();
        
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
