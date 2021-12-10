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
import se_project.exceptions.InvalidOperationException;

/**
 *
 * @author Salvatore Sarnelli
 */
public class Stack {

    private final LinkedList<ComplexNumber> stack;

    /**
     * Metodo costruttore della classe Stack.
     *
     * @author Salvatore Sarnelli
     * @param
     *
     */
    public Stack() {
        stack = new LinkedList<>();
    }

    /**
     * Il metodo si occupa di ritornare lo stack
     *
     * @author Salvatore Sarnelli
     * @param
     * @return
     */
    public LinkedList<ComplexNumber> getStack() {
        return stack;
    }

    /**
     * Il metodo si occupa di inserire un nuovo numero complesso alla fine dello
     * stack.
     *
     * @author Salvatore Sarnelli
     * @param c
     * @return true se l'inserimento è stato effettuato correttamente, false
     * altrimenti.
     */
    public boolean push(ComplexNumber c) {
        if (c == null) {
            return false;
        }
        stack.addLast(c);
        return true;
    }

    public boolean push(LinkedList<ComplexNumber> c) {
        if (c == null) {
            return false;
        }
        for (ComplexNumber number : c) {
            push(number);
        }
        return true;
    }

    /**
     * Il metodo si occupa di restituire la dimensione dello stack.
     *
     * @author Salvatore Sarnelli
     * @param
     * @return dimensione dello stack.
     */
    public int size() {
        return stack.size();
    }

    /**
     * Il metodo si occupa di rimuovere un numero complesso dalla fine dello
     * stack.
     *
     * @author Salvatore Sarnelli
     * @param
     * @return numero complesso rimosso dallo stack.
     * @throws EmptyStackException se si senta di rimuovere un elemento dallo
     * stack vuoto
     */
    public ComplexNumber pop() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        ComplexNumber c = stack.removeLast();
        return c;
    }

    /**
     * Il metodo si occupa di leggere il valore dell'ultimo elemento nello
     * stack, senza rimuoverlo.
     *
     * @author Salvatore Sarnelli
     * @param
     * @return numero complesso letto dallo stack.
     * @throws EmptyStackException se si tenta di rimuovere un elemento dallo
     * stack vuoto.
     */
    public ComplexNumber peek() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return stack.getLast();
    }

    /**
     * Il metodo si occupa di verificare se lo stack è vuoto.
     *
     * @author Salvatore Sarnelli
     * @param
     * @return true, se lo stack è vuoto, false altrimenti.
     */
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Il metodo si occupa di stampare gli elementi dello stack.
     *
     * @author Salvatore Sarnelli
     * @param
     * @return elementi dello stack.
     */
    @Override
    public String toString() {
        return "stack = " + stack;
    }

    /**
     * Il metodo si occupa di inserire nello stack una lista di numeri
     * complessi.
     *
     * @author Salvatore Sarnelli
     * @param list
     * @return true, se gli elementi sono stati inseriti correttamente, false
     * altrimenti.
     */
    public boolean fromListToStack(LinkedList<ComplexNumber> list) {
        if (list == null) {
            return false;
        }
        for (ComplexNumber c : list) {
            stack.addLast(c);
        }
        return true;

    }

    /**
     * Il metodo si occupa di rimuovere tutti gli elementi dallo stack.
     *
     * @author Salvatore Sarnelli
     * @param
     * @return true se l'operazione di clear viene effettuata con successo.
     * @throws EmptyStackException se lo stack è vuoto.
     */
    public boolean clear() throws EmptyStackException {
        if (this.isEmpty()) {
            throw new EmptyStackException();
        }
        this.stack.clear();
        return true;
    }

    /**
     * Il metodo si occupa di duplicare l'ultimo elemento dello stack.
     *
     * @author Salvatore Sarnelli
     * @param
     * @return true se l'operazione di duplicazione viene effettuata con
     * successo.
     * @throws EmptyStackException se lo stack è vuoto.
     */
    public boolean duplicate() throws EmptyStackException {
        if (this.isEmpty()) {
            throw new EmptyStackException();
        }
        this.push(this.peek());
        return true;
    }

    /**
     * Il metodo si occupa di rimuovere l'ultimo elemento dallo stack.
     *
     * @author Salvatore Sarnelli
     * @param
     * @return true se l'operazione di rimozione viene effettuata con successo.
     * @throws EmptyStackException se lo stack è vuoto.
     */
    public boolean drop() throws EmptyStackException {
        if (this.isEmpty()) {
            throw new EmptyStackException();
        }
        this.pop();
        return true;
    }

    /**
     * Il metodo si occupa di scambiare gli ultimi due elementi dello stack.
     *
     * @author Salvatore Sarnelli
     * @param
     * @return true se l'operazione di scambio viene effettuata con successo.
     * @throws EmptyStackException se lo stack è vuoto;
     * InvalidOperationException se nello stack è presente un solo elemento.
     */
    public boolean swap() throws InvalidOperationException, EmptyStackException {
        if (this.isEmpty() || this.size() == 1) {
            throw new InvalidOperationException();
        }
        ComplexNumber last = this.pop();
        ComplexNumber before_last = this.pop();
        this.push(last);
        this.push(before_last);
        return true;
    }

    /**
     * Il metodo si occupa di copiare il valore del penultimo elemento dello
     * stack e di inserirlo alla fine dello stack.
     *
     * @author Salvatore Sarnelli
     * @param
     * @return true se l'operazione di over viene effettuata con successo.
     * @throws EmptyStackException se lo stack è vuoto; EmptyStackException se
     * nello stack è presente un solo elemento.
     */
    public boolean over() throws EmptyStackException, InvalidOperationException {
        if (this.size() == 1) {
            throw new InvalidOperationException();
        }
        ComplexNumber last = this.pop();
        ComplexNumber before_last = this.peek();
        this.push(last);
        this.push(before_last);
        return true;
    }

}
