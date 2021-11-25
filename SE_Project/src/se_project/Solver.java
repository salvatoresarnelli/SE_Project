/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se_project;

import java.util.LinkedList;
import se_project.*;
import se_project.exceptions.DivisionByZeroException;
import se_project.exceptions.InvalidNumberException;
import se_project.exceptions.NotApplicableOperation;
import se_project.exceptions.UndefinedPhaseException;

/**
 *
 * @author aless
 */
public class Solver {

    LinkedList<ComplexNumber> stack;
    private static Solver instance = null;

    private Solver(LinkedList<ComplexNumber> stack) {
        this.stack = stack;
    }

    public static Solver getInstance() {
        // Crea l'oggetto solo se NON esiste:
        if (instance == null) {
            instance = new Solver(new LinkedList<>());
        }
        return instance;
    }

    public ComplexNumber sum() throws NotApplicableOperation, InvalidNumberException {
        if (stack.size() >= 2) {
            ComplexNumber c1 = stack.pop();
            ComplexNumber c2 = stack.pop();
            return Operations.addOperation(c1, c2);
        } else {
            throw new NotApplicableOperation();
        }
    }

    public ComplexNumber dot() throws NotApplicableOperation, InvalidNumberException {
        if (stack.size() >= 2) {
            ComplexNumber c1 = stack.pop();
            ComplexNumber c2 = stack.pop();
            return Operations.dotOperation(c1, c2);
        } else {
            throw new NotApplicableOperation();
        }
    }

    public ComplexNumber difference() throws NotApplicableOperation, InvalidNumberException {
        if (stack.size() >= 2) {
            ComplexNumber c1 = stack.pop();
            ComplexNumber c2 = stack.pop();
            return Operations.differenceOperation(c1, c2);
        } else {
            throw new NotApplicableOperation();
        }
    }

    public ComplexNumber division() throws NotApplicableOperation, InvalidNumberException, UndefinedPhaseException, DivisionByZeroException {
        if (stack.size() >= 2) {
            ComplexNumber c1 = stack.pop();
            ComplexNumber c2 = stack.pop();
            return Operations.divisionOperation(c1, c2);
        } else {
            throw new NotApplicableOperation();
        }
    }

    public ComplexNumber sign() throws NotApplicableOperation, InvalidNumberException {
        if (stack.size() >= 1) {
            ComplexNumber c1 = stack.pop();
            return Operations.signOperation(c1);
        } else {
            throw new NotApplicableOperation();
        }
    }

}
