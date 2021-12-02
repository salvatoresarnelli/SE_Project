/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se_project;

import java.util.LinkedList;
import se_project.*;
import se_project.exceptions.DivisionByZeroException;
import se_project.exceptions.EmptyStackException;
import se_project.exceptions.InvalidNumberException;
import se_project.exceptions.InvalidOperationException;
import se_project.exceptions.NotApplicableOperation;
import se_project.exceptions.UndefinedPhaseException;

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
    public Stack getStructureStack(){
        return this.stack;
    }
    public ComplexNumber resolveOperation(String text) throws NotApplicableOperation, InvalidNumberException, EmptyStackException, UndefinedPhaseException, DivisionByZeroException {
        
        switch(text){
            case "addition":
                return this.sum();
            case "+":
                return this.sum();
            case "substraction":
                return this.difference();
            case "-":
                return  this.difference();
            case "multiplication":
                return this.dot();
            case "*":
                return  this.dot();
            case "division":
                return this.division();
            case ":":
                return this.division();
            case "invert sign":
                return this.sign();
            case "+-":
                return this.sign();         
                
            }
        throw new InvalidNumberException();
    }
    
    public boolean resolveOperationStack(String text) throws  InvalidOperationException, EmptyStackException {
        switch(text) {
            case "clear":
                return this.clear();
            case "dup":
                return this.duplicate();
            case "drop":
                return this.drop();
            case "swap":
                return this.swap();
            case "over":
                return this.over();
        }
        throw new InvalidOperationException();
    }
    
    public ComplexNumber sum() throws NotApplicableOperation, InvalidNumberException, EmptyStackException {
        if (stack.size() >= 2) {
            ComplexNumber c1 = stack.pop();
            ComplexNumber c2 = stack.pop();
            return Operations.addOperation(c1, c2);
        } else {
            throw new NotApplicableOperation();
        }
    }

    public ComplexNumber dot() throws NotApplicableOperation, InvalidNumberException, EmptyStackException {
        if (stack.size() >= 2) {
            ComplexNumber c1 = stack.pop();
            ComplexNumber c2 = stack.pop();
            return Operations.dotOperation(c1, c2);
        } else {
            throw new NotApplicableOperation();
        }
    }

    public ComplexNumber difference() throws NotApplicableOperation, InvalidNumberException, EmptyStackException {
        if (stack.size() >= 2) {
            ComplexNumber c1 = stack.pop();
            ComplexNumber c2 = stack.pop();
            return Operations.differenceOperation(c1, c2);
        } else {
            throw new NotApplicableOperation();
        }
    }

    public ComplexNumber division() throws NotApplicableOperation, InvalidNumberException, UndefinedPhaseException, DivisionByZeroException, EmptyStackException {
        if (stack.size() >= 2) {
            ComplexNumber c1 = stack.pop();
            ComplexNumber c2 = stack.pop();
            return Operations.divisionOperation(c1, c2);
        } else {
            throw new NotApplicableOperation();
        }
    }

    public ComplexNumber sign() throws NotApplicableOperation, InvalidNumberException, EmptyStackException {
        if (stack.size() >= 1) {
            ComplexNumber c1 = stack.pop();
            return Operations.signOperation(c1);
        } else {
            throw new NotApplicableOperation();
        }
    }

    public LinkedList<ComplexNumber> squareRoot() throws EmptyStackException, NotApplicableOperation, InvalidNumberException{
        if (stack.size() >= 1) {
            System.out.println("ciao sono nella radice");
            ComplexNumber c1 = stack.pop();
            return Operations.squareRoot(c1);
        } else {
            throw new NotApplicableOperation();
        }
        
    }
    
    public boolean clear() throws EmptyStackException {
        return stack.clear();
    }
    
    public boolean swap() throws EmptyStackException, InvalidOperationException {
        return stack.swap();
    }
    
    public boolean drop() throws EmptyStackException {
        return stack.drop();
    }
    
    public boolean over() throws EmptyStackException, InvalidOperationException {
        return stack.over();
    }
    
    public boolean duplicate() throws EmptyStackException {
        return stack.duplicate();
    }

}
