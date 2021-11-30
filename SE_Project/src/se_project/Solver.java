/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se_project;

import java.util.LinkedList;
import se_project.*;
import se_project.commands.ColonsCommand;
import se_project.commands.DotCommand;
import se_project.commands.MinusCommand;
import se_project.commands.PlusCommand;
import se_project.commands.SignCommand;
import se_project.exceptions.DivisionByZeroException;
import se_project.exceptions.EmptyStackException;
import se_project.exceptions.InvalidNumberException;
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
    public ComplexNumber  resolveOperation(String text) throws NotApplicableOperation, InvalidNumberException, EmptyStackException, UndefinedPhaseException, DivisionByZeroException{
        switch(text){
            case "addition":
                return new PlusCommand(stack).execute();
            case "+":
                return new PlusCommand(stack).execute();
            case "substraction":
                return new MinusCommand(stack).execute();
            case "-":
                return  new MinusCommand(stack).execute();
            case "multiplication":
                return new DotCommand(stack).execute();
            case "*":
                return  new DotCommand(stack).execute();
            case "division":
                return new ColonsCommand(stack).execute();
            case ":":
                return new ColonsCommand(stack).execute();
            case "invert sign":
                return new SignCommand(stack).execute();
            case "+-":
                return new SignCommand(stack).execute();         
                
            }
        throw new InvalidNumberException();
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

    public LinkedList<ComplexNumber> squareRoot() throws EmptyStackException, UndefinedPhaseException, NotApplicableOperation, InvalidNumberException{
        if (stack.size() >= 1) {
            ComplexNumber c1 = stack.pop();
            return Operations.squareRoot(c1);
        } else {
            throw new NotApplicableOperation();
        }
        
    }
    
    
}
