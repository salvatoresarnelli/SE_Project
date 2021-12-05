/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se_project;

import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import se_project.*;
import se_project.commands.Command;
import se_project.commands.OperationCommand;
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

import se_project.exceptions.DivisionByZeroException;
import se_project.exceptions.EmptyStackException;
import se_project.exceptions.InterruptedExecutionException;
import se_project.exceptions.InvalidNumberException;
import se_project.exceptions.InvalidOperationException;
import se_project.exceptions.InvalidVariableNameException;
import se_project.exceptions.NotApplicableOperation;
import se_project.exceptions.UndefinedPhaseException;
import se_project.exceptions.VariableExistingException;

/**
 *
 * @author aless
 */
public class Solver {

    private Stack stack;
    private static Solver instance = null;

    private Solver(Stack stack) {
        this.stack = stack;
    }

    public static Solver getInstance() {
        // Crea l'oggetto solo se NON esiste:
        if (instance == null) {
            instance = new Solver(new Stack());
        }
        return instance;
    }

    public Stack getStructureStack() {
        return this.stack;
    }
 
    public void resolveOperation(Command text) throws NotApplicableOperation, InvalidNumberException,
            EmptyStackException, UndefinedPhaseException, DivisionByZeroException, 
            InvalidVariableNameException,VariableExistingException, InterruptedExecutionException,
            Exception{
            ((OperationCommand)text).setTarget(stack);
            text.execute();
       
    }
    
    /*public void rollBack(LinkedList<ComplexNumber> list){
        try {
            stack.clear();
        } catch (EmptyStackException ex) {
        }
        for( ComplexNumber complex : list){
            stack.push(complex);
        }
        
    }
    */
}