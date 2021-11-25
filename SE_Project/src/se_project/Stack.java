/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se_project;

import se_project.exceptions.EmptyStackException;
import java.util.LinkedList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Salvatore Sarnelli
 */

//TO DO: aggiornare con Complex number quando c'è il toString in ComplexNumber
public class Stack {
    private LinkedList<ComplexNumber> stack;

    public Stack() {
        stack = new LinkedList<>() ;
    }
    
    public boolean push(ComplexNumber c) {
        if(c == null) return false;
        stack.addLast(c);
        return true;
    }
    
    public int size() {
        return stack.size();
    }
    
    public ComplexNumber pop() throws EmptyStackException{
        if(isEmpty()) throw new EmptyStackException();
        ComplexNumber c = stack.removeLast();
        return c;
    }
    
    public ComplexNumber peek() throws EmptyStackException {
        if(isEmpty()) throw new EmptyStackException();
        return stack.getLast();
    }
    
    public boolean isEmpty() {
        return size() == 0;
    }
    
    @Override
    public String toString() {
        return "stack = " + stack;
    }

}
