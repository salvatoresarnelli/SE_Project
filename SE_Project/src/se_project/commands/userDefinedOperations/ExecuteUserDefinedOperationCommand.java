/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se_project.commands.userDefinedOperations;

import java.util.LinkedList;
import se_project.Stack;
import se_project.commands.OperationCommand;

/**
 *
 * @author aless
 *
 * Questa classe rappresenta l'esecuzione di un'operazione definita dall'utente.
 * Essa, essendo un'operazione, estende la classe OperationCommand, ereditandone
 * un'instanza dello stack. è presente un'ulteriore attributo, "name", che
 * rappresenta il nome dell'operazione. Contiene inoltre la lista contente le
 * operazioni associate alla userdefined operation.
 */
public class ExecuteUserDefinedOperationCommand extends OperationCommand {

    private LinkedList<OperationCommand> commandList;
    private String name;

    /**
     * Restituisce il nome dell'operazione.
     *
     * @return String
     */
    public String getName() {
        return name;
    }

    public ExecuteUserDefinedOperationCommand() {
        super();
    }

    public ExecuteUserDefinedOperationCommand(String name, LinkedList<OperationCommand> commandList) {
        super();
        this.name = name;
        this.commandList = commandList;
    }

    public ExecuteUserDefinedOperationCommand(String name, LinkedList<OperationCommand> commandList, Stack stack) {
        super(stack);
        this.name = name;
        this.commandList = commandList;
    }

    /**
     * Esegue una user defined Operation. Per ognuno dei comandi contenuti nella
     * commandList, se ne setta il target(Lo stack) e si chiama la execute
     *
     * @return
     * @throws java.lang.Exception
     */
    @Override
    public Object execute() throws Exception {

        Stack stack = super.getTarget();

        for (OperationCommand i : commandList) {
            i.setTarget(stack);

            i.execute();

        }
        return true;
    }

    /**
     * Restituisce la lista dei comandi dell'operazione. 
     * @return LinkedList
     */
    public LinkedList<OperationCommand> getCommandList() {
        return commandList;
    }

    /**
     * La toString della classe ColonsCommand contiene solo il nome
     * dell'operazione.
     */
    @Override
    public String toString() {
        return commandList.toString();
    }

}
