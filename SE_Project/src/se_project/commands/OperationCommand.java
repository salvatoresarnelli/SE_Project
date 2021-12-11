/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se_project.commands;

import se_project.ComplexNumber;
import se_project.Stack;

/**
 * Questa classe astratta rappresenta un'operazione generica. Presenta al
 * proprio interno un'instanza dello stack, su cui verranno effettuate le
 * operazioni.
 *
 *
 * @author aless
 */
public abstract class OperationCommand implements Command {

    private Stack target;

    /**
     * Costruttore vuoto
     */
    public OperationCommand() {

    }

    /**
     * Costruttore che setta lo stack come target.
     *
     * @param stack
     */
    public OperationCommand(Stack stack) {
        this.target = stack;
    }

    /**
     * Restituisce lo stack definito come target.
     *
     * @return Stack
     */
    public Stack getTarget() {
        return target;
    }

    /**
     * Setta lo stack definito come target con il parametro passato.
     *
     * @param target
     */
    public void setTarget(Stack target) {
        this.target = target;
    }

}
