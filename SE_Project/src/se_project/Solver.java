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
    /**
     * Questa classe è un singleton. Rappresenta il risolutore delle operazioni.
     * è l'unica classe ad avere lo stack e dunque in grado di eseguire 
     * operazioni su di esso.
     */
    private final Stack stack;
    private static Solver instance = null;
    
    /**
     * Costruttore privato, viene richiamato solo una volta nella getInstance.
     * Qui viene settato lo stack.
     */
    private Solver(Stack stack) {
        this.stack = stack;
    }
    /**
     * Crea il solver se non esiste.Restituisce il solver creato precedentemente 
 Se esiste già un'instanza di esso.
     * 
     * @return Solver
     */
    public static Solver getInstance() {
        // Crea l'oggetto solo se NON esiste:
        if (instance == null) {
            instance = new Solver(new Stack());
        }
        return instance;
    }
    
    /**
     * Resituisce lo stack.
     * @return Stack
     */
    public Stack getStructureStack() {
        return this.stack;
    }
    /**
     * @param command
     * @throws se_project.exceptions.EmptyStackException
     * @throws se_project.exceptions.NotApplicableOperation
     * @throws se_project.exceptions.InvalidNumberException
     * @throws se_project.exceptions.InvalidVariableNameException
     * @throws se_project.exceptions.UndefinedPhaseException
     * @throws se_project.exceptions.DivisionByZeroException
     * @throws se_project.exceptions.VariableExistingException
     * 
     * Questo metodo prende come parametro un comando, ne setta lo stack come target.
     * E ne richiede l'esecuzione.
     */
    public void resolveOperation(Command command) throws  EmptyStackException , NotApplicableOperation , InvalidNumberException , InvalidVariableNameException, UndefinedPhaseException, DivisionByZeroException, VariableExistingException, Exception{
            ((OperationCommand)command).setTarget(stack);
            command.execute();
                
            }
       
    }
    
    
