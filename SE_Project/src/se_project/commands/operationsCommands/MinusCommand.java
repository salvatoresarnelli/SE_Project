/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se_project.commands.operationsCommands;

import se_project.commands.*;
import se_project.ComplexNumber;
import se_project.Operations;
import se_project.Stack;
import se_project.exceptions.EmptyStackException;
import se_project.exceptions.InvalidNumberException;
import se_project.exceptions.NotApplicableOperation;

/**
 *
 * @author aless Questa classe rappresenta un'operazione di sottrazione degli
 * ultimi due numeri complessi contenuti nello stack. Essa, essendo
 * un'operazione, estende la classe OperationCommand, ereditandone un'instanza
 * dello stack. è presente un'ulteriore attributo, "name", che rappresenta il
 * nome dell'operazione.
 *
 */
public class MinusCommand extends OperationCommand {

    private final String name = "-";

    public MinusCommand() {
        super(null);
    }

    public MinusCommand(Stack stack) {
        super(stack);
    }

    /**
     * Il metodo execute esegue la differenza tra l'ultimo e il penultimo
     * elemento presente nello stack.Se la dimensione dello stack è minore di 2,
     * l'operazione non è eseguibile e dunque viene lanciata un'eccezione.Nel
     * caso in cui la size sia maggiore o ugale a due, si prendono,
     * rimuovendogli, gli ultimi due elementi contenuti nello stack e si
     * richiama il metodo statico "differenceOperation" della classe Operations.
     *
     * Se l'operazione va a buon fine, si inserisce nello stack il risultato.
     *
     *
     * @return a ComplexNumber
     * @throws se_project.exceptions.NotApplicableOperation
     * @throws se_project.exceptions.InvalidNumberException
     * @throws se_project.exceptions.EmptyStackException
     */
    @Override
    public ComplexNumber execute() throws EmptyStackException, InvalidNumberException, NotApplicableOperation {
        if (super.getTarget().size() >= 2) {
            ComplexNumber c1 = super.getTarget().pop();
            ComplexNumber c2 = super.getTarget().pop();
            ComplexNumber result = Operations.differenceOperation(c1, c2);
            super.getTarget().push(result);
            return result;
        } else {
            throw new NotApplicableOperation();
        }
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
