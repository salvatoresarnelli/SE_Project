/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se_project;

import java.util.LinkedList;
import se_project.*;
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

    public Stack getStructureStack() {
        return this.stack;
    }
 
    public void resolveOperation(String text) throws NotApplicableOperation, InvalidNumberException,
            EmptyStackException, UndefinedPhaseException, DivisionByZeroException {

        switch (text) {
            case "addition":
                stack.push(new PlusCommand(this.stack).execute());
                                break;

            case "+":
                stack.push(new PlusCommand(this.stack).execute());                break;

            case "substraction":
                stack.push(new MinusCommand(this.stack).execute());
                                break;

            case "-":
                stack.push(new MinusCommand(this.stack).execute());
                                break;

            case "multiplication":
                stack.push((new DotCommand(this.stack)).execute());
                                break;

            case "*":
                stack.push((new DotCommand(this.stack)).execute());
                                break;

            case "division":
                stack.push(new ColonsCommand(this.stack).execute());
            case ":":
                stack.push(new ColonsCommand(this.stack).execute());
            case "invert sign":
                stack.push(new SignCommand(this.stack).execute());
                                break;

            case "+-":
                stack.push(new SignCommand(this.stack).execute());
                                break;

            case "sqrt":
                stack.push(new SqrtCommand(this.stack).execute());
                                break;

            case "square root":
                stack.push(new SqrtCommand(this.stack).execute());
                break;
            default: throw new InvalidNumberException();
        }
    }

    public boolean resolveOperationStack(String text) throws InvalidOperationException, EmptyStackException {
        switch (text) {
            case "clear":
                return new ClearCommand(stack).execute();
            case "dup":
                return new DuplicateCommand(stack).execute();
            case "drop":
                return new DropCommand(stack).execute();
            case "swap":
                return new SwapCommand(stack).execute();
            case "over":
                return new OverCommand(stack).execute();
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