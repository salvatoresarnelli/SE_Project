/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se_project.commands;

import se_project.ComplexNumber;
import se_project.Stack;

/**
 *
 * @author aless
 */
public class InsertNumberCommand extends OperationCommand{
    private ComplexNumber number;
    public InsertNumberCommand(ComplexNumber number) {
        this.number = number;
    }

    public InsertNumberCommand(ComplexNumber c, Stack stack) {
        super(stack);
        this.number = c;
    }

    @Override
    public Object execute() throws Exception {
        return super.getTarget().push(number);
    }
    
}