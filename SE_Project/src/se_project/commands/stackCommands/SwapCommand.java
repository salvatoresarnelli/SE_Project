/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se_project.commands.stackCommands;

import se_project.Stack;
import se_project.commands.Command;
import se_project.commands.OperationCommand;
import se_project.exceptions.EmptyStackException;
import se_project.exceptions.InvalidOperationException;

/**
 *
 * @author aless Questa classe rappresenta un'operazione di Swap sullo stack.
 * Essa, essendo un'operazione, estende la classe OperationCommand, ereditandone
 * un'instanza dello stack. è presente un'ulteriore attributo, "name", che
 * rappresenta il nome dell'operazione.
 */
public class SwapCommand extends OperationCommand {

    private String name = "swap";

    public SwapCommand(Stack stack) {
        super(stack);
    }

    public SwapCommand() {
    }

    /**
     * Il metodo execute esegue la swap sullo stack, scambiando la posizione dell'ultimo 
     * elemento presente nello stack con il penultimo.
     * Se la dimensione dello stack è minore di 2, l'operazione non è eseguibile e
     * dunque viene lanciata un'eccezione. Se la dimensione dello stack lo
     * consente, viene inserito in cima allo stack una copia del penultimo
     * elemento.
     *
     *
     * @return Boolean
     * @throws se_project.exceptions.EmptyStackException
     * @throws se_project.exceptions.InvalidOperationException
     */
    @Override
    public Boolean execute() throws EmptyStackException, InvalidOperationException {
        return super.getTarget().swap();
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
