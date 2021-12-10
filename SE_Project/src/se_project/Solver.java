/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se_project;

import java.util.LinkedList;
import se_project.commands.Command;
import se_project.commands.OperationCommand;

import se_project.exceptions.DivisionByZeroException;
import se_project.exceptions.EmptyStackException;
import se_project.exceptions.InvalidNumberException;
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
 
    public void resolveOperation(Command text) throws  EmptyStackException , NotApplicableOperation , InvalidNumberException , InvalidVariableNameException, UndefinedPhaseException, DivisionByZeroException, VariableExistingException, Exception{
            LinkedList<ComplexNumber> actualStack = getStructureStack().getStack();
            ((OperationCommand)text).setTarget(stack);
            text.execute();
                
            }
       
    }
    
    
