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
 * @author aless Questa classe rappresenta un'operazione di drop sullo stack.
 * Essa, essendo un'operazione, estende la classe OperationCommand, ereditandone
 * un'instanza dello stack. è presente un'ulteriore attributo, "name", che
 * rappresenta il nome dell'operazione.
 */
public class DropCommand extends OperationCommand {

    private final String name = "drop";

    public DropCommand(Stack stack) {
        super(stack);
    }

    public DropCommand() {
    }

    /**
     * Il metodo execute esegue la drop sullo stack, rimuovendo l'ultimo
     * elemento presente nello stack.Se la dimensione dello stack è minore di 1,
     * l'operazione non è eseguibile e dunque viene lanciata un'eccezione.
     * Se la dimensione dello stack lo consente, viene rimosso l'ultimo elemento.
     *
     *
     * @return Boolean
     * @throws se_project.exceptions.EmptyStackException
     */
    @Override
    public Boolean execute() throws EmptyStackException {
        return super.getTarget().drop();
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
