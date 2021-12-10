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
 * @author aless
 */
public class VariablesStack {
    private LinkedList<Record> history;
    private static VariablesStack instance = null;
    
    private VariablesStack(){
        history = new LinkedList<>();
    }
    
    public static VariablesStack getInstance() {
        // Crea l'oggetto solo se NON esiste:
        if (instance == null) {
            instance = new VariablesStack();
        }
        return instance;
    }
    
    public void pushVariablesSnapShot(VariablesDict dictionary){
        HashMap<Character,ComplexNumber> currentMap = new HashMap<>();
        for(char var = 'a';var!='z';var++){
            if(dictionary.getTable().containsKey(var)){
                currentMap.put(var, dictionary.getTable().get(var));
            }
            else
                currentMap.put(var, null);
        }
        history.addLast(new Record(currentMap));
    }
    
    public Record popVariableSnapShot( ) throws NoSuchElementException{
        return history.removeLast();
    }
    
    public Iterator<Record> iterator(int index){
        return history.listIterator(index);
    }
    public int length(){
    return history.size();
    }

    
}
