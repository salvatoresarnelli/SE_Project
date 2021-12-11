/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se_project.commands.operationsCommands;

import se_project.ComplexNumber;
import se_project.Operations;
import se_project.Stack;
import se_project.commands.OperationCommand;
import se_project.exceptions.DivisionByZeroException;
import se_project.exceptions.EmptyStackException;
import se_project.exceptions.InvalidNumberException;
import se_project.exceptions.NotApplicableOperation;
import se_project.exceptions.UndefinedPhaseException;

/**
 *
 * @author aless 
 * Questa classe rappresenta un'operazione di divisione degli
 * ultimi due numeri complessi contenuti nello stack. Essa, essendo
 * un'operazione, estende la classe OperationCommand, ereditandone un'instanza
 * dello stack. è presente un'ulteriore attributo, "name", che rappresenta il
 * nome dell'operazione.
 *
 */
public class ColonsCommand extends OperationCommand {

    private final String name = ":";

    public ColonsCommand() {
        super(null);
    }

    public ColonsCommand(Stack stack) {
        super(stack);
    }

    /**
     * Il metodo execute esegue la divisione tra l'ultimo e il penultimo
     * elemento presente nello stack.
     *
     * Se la dimensione dello stack è minore di 2, l'operazione non è eseguibile
     * e dunque viene lanciata un'eccezione. Nel caso in cui la size sia
     * maggiore o ugale a due, si prendono, rimuovendogli, gli ultimi due
     * elementi contenuti nello stack e si richiama il metodo statico
     * "divisionOperation" della classe Operations. Se il divisore ha modulo
     * uguale a zero, viene lanciata un'eccezione e si ripopola lo stack con gli
     * elementi rimossi. Se l'operazione va a buon fine, si inserisce nello
     * stack il risultato.
     *
     *
     * @return a ComplexNumber
     * @throws se_project.exceptions.NotApplicableOperation
     * @throws se_project.exceptions.InvalidNumberException
     * @throws se_project.exceptions.UndefinedPhaseException
     * @throws se_project.exceptions.DivisionByZeroException
     * @throws se_project.exceptions.EmptyStackException
     */
    @Override
    public ComplexNumber execute() throws NotApplicableOperation, InvalidNumberException, UndefinedPhaseException, DivisionByZeroException, EmptyStackException {

        if (super.getTarget().size() >= 2) {
            ComplexNumber c1 = super.getTarget().pop();
            ComplexNumber c2 = super.getTarget().pop();
            ComplexNumber result;
            try {
                result = Operations.divisionOperation(c1, c2);
                super.getTarget().push(result);
                return result;
            } catch (DivisionByZeroException ex) {

                super.getTarget().push(c2);
                super.getTarget().push(c1);
                throw new DivisionByZeroException();
            }
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
