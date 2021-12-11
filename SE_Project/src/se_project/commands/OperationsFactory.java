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
import se_project.commands.variablesCommands.DiffVariableCommand;
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
import se_project.commands.stackCommands.SwapCommand;
import se_project.commands.trascendental.CosCommand;
import se_project.commands.trascendental.SinCommand;
import se_project.commands.variablesCommands.SaveVariableCommand;

/**
 * Tale classe consente di generare instanze di Comandi "command". In
 * particolare, questi vengono generati ma non sono ancora applicabili, in
 * quanto il loro target viene definito solo dall'oggetto che si occuperà di
 * eseguire e gestire la loro esecuzione.
 *
 * @author aless
 */
public class OperationsFactory {

    public OperationsFactory() {

    }

    /**
     * Questo metodo consente di generare un comando, a partire da una stringa
     * passatagli come parametro.
     * Esempio: 
     * - getOperationCommand("+") restituisce un'instanza di PlusCommand.
     * - getOperationCommand("save") restituisceun'instanza di SaveVariableCommand
     *
     * @param type
     * @return OperationCommand
     * @throws se_project.exceptions.OperationNotFoundException
     */
    public OperationCommand getOperationCommand(String type) throws OperationNotFoundException {
        if (type.startsWith(">") && type.length() == 2) {
            type = "NewVariableCommand";
        }
        if (type.startsWith("<") && type.length() == 2) {
            type = "PushVariableCommand";
        }
        if (type.startsWith("+") && type.length() == 2 && type.charAt(1) != '-') {
            type = "SumVariableCommand";
        }
        if (type.startsWith("-") && type.length() == 2) {
            type = "DiffVariableCommand";
        }
        if (type.equals("save")) {
            type = "SaveVariableCommand";
        }
        if (type.equals("+")) {
            return new PlusCommand();
        }
        if (type.equals("-")) {
            return new MinusCommand();
        }
        if (type.equals("*")) {
            return new DotCommand();
        }
        if (type.equals(":")) {
            return new ColonsCommand();
        }
        if (type.equals("+-")) {
            return new SignCommand();
        }
        if (type.equals("sqrt")) {
            return new SqrtCommand();
        }
        if (type.equals("swap")) {
            return new SwapCommand();
        }
        if (type.equals("drop")) {
            return new DropCommand();
        }
        if (type.equals("dup")) {
            return new DuplicateCommand();
        }
        if (type.equals("clear")) {
            return new ClearCommand();
        }
        if (type.equals("over")) {
            return new OverCommand();
        }
        if (type.equals("NewVariableCommand")) {
            return new NewVariableCommand();
        }
        if (type.equals("PushVariableCommand")) {
            return new PushVariableCommand();
        }
        if (type.equals("SumVariableCommand")) {
            return new SumVariableCommand();
        }
        if (type.equals("DiffVariableCommand")) {
            return new DiffVariableCommand();
        }
        if (type.equals("sin")) {
            return new SinCommand();
        }
        if (type.equals("cos")) {
            return new CosCommand();
        }
        if (type.equals("SaveVariableCommand")) {
            return new SaveVariableCommand();
        }

        throw new OperationNotFoundException();
    }
    /**
     * Questo metodo consente di generare un comando, a partire da una stringa
     * passatagli come parametro e una mappa Stringa->Operazioni.
     * In particolare, consente di individuare se un comando richiesto
     * è uno dei comandi già esistenti, oppure è un comando contenuto nella tabella 
     * passata come parametro.
     * Nel caso in cui questo viene riconosciuto, viene restituito un'instanza del
     * comando.
     * 
     * Esempio: 
     *  Supponendo che dict sia come definito in tabella:
     *                __________________________________
     *               |               |lista delle opera-|
     *               |nome operazione|      zioni       |
     *               |______________ |__________________|
     *               |    sum        |     + + +        |
     *               |_______________|__________________| 
     *               |   diffsum     |     - sum        |
     *               |_______________|__________________|
     *               
     * 
     * - getOperationCommand("+",dict): restituisce un'instanza di PlusCommand;
     * 
     * - getOperationCommand("save",dict): restituisce un'instanza di
     *                                     SaveVariableCommand;
     * 
     * - getOperationCommand("sum",dict): restituisce un'instanza di
     *                                    ExecuteUserDefinedOperationCommand in
     *                                    cui la CommandList è + + +;
     * 
     * - getOperationCommand("sum",dict): restituisce un'instanza di
     *                                    ExecuteUserDefinedOperationCommand in
     *                                    cui la CommandList è - + + +;
     *
     * @param type
     * @param table
     * @return OperationCommand
     * @throws se_project.exceptions.OperationNotFoundException
     */
    public OperationCommand getOperationCommand(String type, HashMap<String, OperationCommand> table) throws OperationNotFoundException {
        try {
            return getOperationCommand(type);
        } catch (OperationNotFoundException ex) {
            if (table.containsKey(type)) {
                return table.get(type);
            }

            throw new OperationNotFoundException();
        }

    }
}
