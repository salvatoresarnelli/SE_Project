/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se_project.commands;

import se_project.ComplexNumber;
import se_project.Stack;

/**
 * Questa classe rappresenta un'operazione di inserimento di un numero
 * complesso. Essa, essendo un'operazione, estende la classe OperationCommand,
 * ereditandone un'instanza dello stack. è presente un'ulteriore attributo,
 * "number", che è un numbero complesso (instanza di ComplexNumber), che
 * rappresenta il numero complesso da inserire nello stack.
 *
 *
 * @author aless
 */
public class InsertNumberCommand extends OperationCommand {

    private ComplexNumber number;

    public InsertNumberCommand(ComplexNumber number) {
        this.number = number;
    }

    public InsertNumberCommand(ComplexNumber c, Stack stack) {
        super(stack);
        this.number = c;
    }

    /**
     *
     * Inserisce la variabile "number" nello stack.
     * 
     * @return 
     * @throws java.lang.Exception
     */
    @Override
    public Object execute() throws Exception {
        return super.getTarget().push(number);
    }

    /**
     * Resituisce number.
     * @return ComplexNumber
     */
    public ComplexNumber getNumber() {
        return number;
    }

}
