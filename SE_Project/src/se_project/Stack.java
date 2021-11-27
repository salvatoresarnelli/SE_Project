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

public class Stack {
    private LinkedList<ComplexNumber> stack;
    
    /**
     * Metodo costruttore della classe Stack.
     * @author Salvatore Sarnelli
     * @param  
     * @return stack
     * 
     */

    public Stack() {
        stack = new LinkedList<>() ;
    }
    
    /**
    * Il metodo si occupa di ritornare lo stack
    * @author Salvatore Sarnelli
    * @param 
    * @return      
    */

    public LinkedList<ComplexNumber> getStack() {
        return stack;
    }
    
    /**
    * Il metodo si occupa di inserire un nuovo numero 
    * complesso alla fine dello stack.
    * @author Salvatore Sarnelli
    * @param ComplexNumber c , numero complesso da dover inserire.
    * @return true se l'inserimento è stato effettuato
    *         correttamente, false altrimenti.  
    */
    
    public boolean push(ComplexNumber c) {
        if(c == null) return false;
        stack.addLast(c);
        return true;
    }
    
    /**
    * Il metodo si occupa di restituire la dimensione dello stack.
    * @author Salvatore Sarnelli
    * @param 
    * @return dimensione dello stack.           
    */

    public int size() {
        return stack.size();
    }
    
    /**
    * Il metodo si occupa di rimuovere un numero complesso dalla fine
    * dello stack.
    * @author Salvatore Sarnelli
    * @param 
    * @return numero complesso rimosso dallo stack.    
    * @throws EmptyStackException se si senta di rimuovere un elemento 
    *         dallo stack vuoto
    */
    
    public ComplexNumber pop() throws EmptyStackException{
        if(isEmpty()) throw new EmptyStackException();
        ComplexNumber c = stack.removeLast();
        return c;
    }
    
    /**
    * Il metodo si occupa di leggere il valore dell'ultimo
    * elemento nello stack, senza rimuoverlo.
    * @author Salvatore Sarnelli
    * @param 
    * @return numero complesso letto dallo stack. 
    * @throws EmptyStackException se si senta di rimuovere un elemento 
    *         dallo stack vuoto.
    */
    
    public ComplexNumber peek() throws EmptyStackException {
        if(isEmpty()) throw new EmptyStackException();
        return stack.getLast();
    }
    
    /**
    * Il metodo si occupa di verificare se lo stack è vuoto.
    * @author Salvatore Sarnelli
    * @param 
    * @return true, se lo stack è vuoto, false altrimenti.
    */
    
    public boolean isEmpty() {
        return size() == 0;
    }
    
    /**
    * Il metodo si occupa di stampare gli elementi dello stack.
    * @author Salvatore Sarnelli
    * @param 
    * @return elementi dello stack.
    */
    
    @Override
    public String toString() {
        return "stack = " + stack;
    }
    
    /**
    * Il metodo si occupa di inserire nello stack una lista di numeri complessi.
    * @author Salvatore Sarnelli
    * @param  LinkedList<ComplexNumber> list
    * @return true, se gli elementi sono stati inseriti correttamente,
    *         false altrimenti.
    */    
    
    public boolean fromListToStack(LinkedList<ComplexNumber> list) {
        if(list == null) return false;
        for(ComplexNumber c: list) {
            stack.addLast(c);
        }
        return true;

    }
}
