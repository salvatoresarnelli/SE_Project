/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se_project.commands.stackCommands;

import se_project.Stack;
import se_project.commands.OperationCommand;
import se_project.exceptions.EmptyStackException;

/**
 * @author aless 
 * Questa classe rappresenta un'operazione di Clear sullostack.
 * Essa, essendo un'operazione, estende la classe OperationCommand, ereditandone
 * un'instanza dello stack. è presente un'ulteriore attributo, "name", che
 * rappresenta il nome dell'operazione.
 */
public class ClearCommand extends OperationCommand {

    private String name = "Clear";

    public ClearCommand(Stack stack) {
        super(stack);
    }

    public ClearCommand() {
    }

    /**
     * Il metodo execute esegue la clear dello stack, rimuovendone tutti gli
     * elementi.
     *
     * @return LinkedList<>
     * @throws se_project.exceptions.EmptyStackException
     */
    @Override
    public Boolean execute() throws EmptyStackException {
        return super.getTarget().clear();

    }

    /**
     * La toString della classe ColonsCommand contiene solo il nome
     * dell'operazione.
     */
    @Override
    public String toString() {
        return name;
    }

}
