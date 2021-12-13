/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se_project;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 *
 * @author aless Questa classe mantiene uno stack di Record, mantenendo un
 * dizionario di variabili. Tale classe è un singleton.
 */
public class VariablesStack {

    private LinkedList<Record> history;
    private static VariablesStack instance = null;

    /**
     * Costruttore privato.
     */
    private VariablesStack() {
        history = new LinkedList<>();
    }

    /**
     * Crea un'instanza dello stack delle variabili se non esiste.Se invece
     * esiste, ne restituisce l'instanza.
     *
     * @return
     */
    public static VariablesStack getInstance() {
        // Crea l'oggetto solo se NON esiste:
        if (instance == null) {
            instance = new VariablesStack();
        }
        return instance;
    }

    /**
     * Prende un variablesDict come parametro.Ogni variabile contenuta nel
     * dizionario viene aggiunta al record. Per ogni variabile assente nel
     * dictionary si associa null. Il record viene inserito nello storico delle
     * variabili.
     *
     * @param dictionary
     */
    public void pushVariablesSnapShot(VariablesDict dictionary) {
        HashMap<Character, ComplexNumber> currentMap = new HashMap<>();
        for (char var = 'a'; var <= 'z'; var++) {
            if (dictionary.getTable().containsKey(var)) {
                currentMap.put(var, dictionary.getTable().get(var));
            } else {
                currentMap.put(var, null);
            }
        }
        history.addLast(new Record(currentMap));
    }

    /**
     * 
     * @return Record
     * @throws NoSuchElementException
     * Rimuove l'ultimo record inserito nello stack e lo restituisce.
     * Viene lanciata un'eccezione se lo stack è vuoto.
     */
    public Record popVariableSnapShot() throws NoSuchElementException {
        return history.removeLast();
    }

    /**
     * Resituisce un'iteratore a partire dall'indice index passato come parametro.
     * @param index
     * @return 
     */
    public Iterator<Record> iterator(int index) throws IndexOutOfBoundsException {
       return history.listIterator(index);
    }

    /**
     * Resituisce il numero di elementi contenuti nello stack.
     * @return int
     */
    public int length() {
        return history.size();
    }

    /**
     *Questo metodo restituisce l'ultimo elemento dello stack.
     * @return Record
     */
    public Record last(){
        return history.get(0);
    }
     /**
     *Questo metodo restituisce l' elemento in cima allo stack.
     * @return Record
     */
    public Record top(){
        return history.get(length()-1);
    } 
}
