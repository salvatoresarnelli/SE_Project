/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se_project;

import se_project.exceptions.InvalidNameException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Set;

/**
 *
 * @author emanu
 */
public class DecoratorParserOperation extends ParserString {

    private final ParserString parserString;
    private final HashMap<String, LinkedList<String>> hashMap;
    private final String invalid_insert = "__INVALID__";
    private final String still_name_inserted = "__NAME__";
    private final LinkedList<String> linkedList;
     /**
     *Il costruttore del decorator prende in ingresso un parser string e inizializza successivamente una hashMap che salva 
     * le operazione definite dall'utente, in cui la chiave è il nome dell'operazione e il value è una LinkedList<String> in 
     * cui sono salvate le operazioni associate.
     * @param parserString, parser che verrà decorato.
     * 
     */
    public DecoratorParserOperation(ParserString parserString) {
        this.parserString = parserString;
        hashMap = new HashMap<>();
        linkedList = new LinkedList<>();
        Collections.addAll(linkedList, "+", "-", "+-", "sqrt", "*", ":", "dup", "swap", "over", "drop");

    }
    /**
     *Il costruttore del decorator prende in ingresso un parser string e inizializza successivamente una hashMap che salva 
     * le operazione definite dall'utente, in cui la chiave è il nome dell'operazione e il value è una LinkedList<String> in 
     * cui sono salvate le operazioni associate. In questo caso il costruttore prende in ingresso anche un HashMap già definito, con alcune operazioni già definite
     * @param parserString, parser che verrà decorato.
     * @param hashMap1 , hash che,prima di essere salvato, deve essere controllato affinché rispetti tutte le condizioni definite precedentemente.
     * @throws  InvalidNameException, il metodo lancia l'eccezione nel momento in cui viene passata un hashMap che non rispecchia tutti i requisiti definiti precedentemente.
     * 
     */
    public DecoratorParserOperation(ParserString parserString, HashMap<String, LinkedList<String>> hashMap1) throws InvalidNameException {
        this.parserString = parserString;
        hashMap1.keySet().stream().filter((s) -> (!this.checkName(s))).forEachOrdered((_item) -> {
            throw new InvalidNameException();
        });
        this.hashMap = new HashMap<>(hashMap1);
        linkedList = new LinkedList<>();
        Collections.addAll(linkedList, "+", "-", "+-", "sqrt", "*", ":", "dup", "swap", "over", "drop");
    }
    /**
     *Il metodo prende in ingresso una stringa da dover formattare, eliminando eventuale \n e i primi due caratteri.
     * @param text la stringa da dover formattare.
     * @throws  StringIndexOutBoundsException, nel momento in cui la stringa passata ha size <2
     * @return  string stringa formattata.
     * 
     */
    public String clearStringOperation(String text) throws StringIndexOutOfBoundsException {
        text = text.replaceAll("\\n", "");
        if (text.length() < 2) {
            throw new StringIndexOutOfBoundsException();
        }
        StringBuilder sb = new StringBuilder(text);
        // Removing the first character
        // of a string
        sb.delete(0, 2);
        // Converting StringBuilder into a string
        // and return the modified string
        return sb.toString();

    }
    /**
     *Il metodo prende una stringa da dover formattare,controllando se sono presenti all'interno di essa caratteri alfanumerici
     * 
     * @param text, Stringa da dover formattare.
     * @return  string stringa formattata.
     * 
     */
    public boolean checkName(String text) {

        char[] chars = text.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char c : chars) {
            if (Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }
   
     /**
     *Il metodo prende una stringa da dover formattare,controllando se sono presenti spazi iniziali definiti dall'utente.
     * @param text, Stringa da dover formattare.
     * @throws StringIndexOutOfBoundsException viene lanciata quando la stringa ha una size minore di 1 (stringa vuota).
     * @return  string stringa formattata.
     * 
     * 
     */
    public String removeInitialSpaces(String text) throws StringIndexOutOfBoundsException {
        while (text.charAt(0) == ' ') {
            StringBuilder sb = new StringBuilder(text);
            sb.delete(0, 1);
            text = sb.toString();

        }
        return text;
    }

    @Override
    public String parserString(String textString) throws ArrayIndexOutOfBoundsException {
        if (textString.startsWith(">>")) {
            textString = this.clearStringOperation(textString);
            String[] string = textString.split("\\$");
            String possible_name = string[0];
            possible_name = possible_name.replaceAll(" ", "");

            if (possible_name.length() <= 1 || linkedList.contains(possible_name)) {
                return invalid_insert;
            }
            String possible_operations = string[1];
            if (!this.checkName(possible_name)) {
                return invalid_insert;
            }
            possible_operations = this.removeInitialSpaces(possible_operations);
            if (!hashMap.containsKey(possible_name)) {
                String[] operations = possible_operations.split("\\s+");
                for (String possibile_operation : operations) {
                    if (!hashMap.containsKey(possibile_operation) && !linkedList.contains(possibile_operation)) {
                        throw new InvalidNameException("operazione non definita " + possibile_operation);
                    }
                }

                LinkedList<String> final_operations = new LinkedList<>();
                final_operations.addAll(Arrays.asList(operations));
                hashMap.put(possible_name, final_operations);
                return possible_name;
            }

            return still_name_inserted;

        }

        return parserString.parserString(textString);
    }
     /**
     *Il metodo prende in ingresso il nome di un operazione già definita dall'utente e restituisce tutte le operazioni associate al nome.
     * @param name, Nome dell'operazione.
     * @return  LinkedList<String> le operazioni associate al nome, nel caso l'operazione non esiste,return null.
     * 
     */
    public LinkedList<String> getOperations(String name) {
        return hashMap.get(name);
    }
     /**
     **Il metodo prende in ingresso il nome di un operazione già definita dall'utente e restituisce una stringa in cui sono presenti tutte le operazioni associate
     * intervallate da uno spazio.
     * 
     * @param text, Nome dell'operazione
     * @return  string stringa contenente tutte operazioni intervallate da uno spazio.
     * 
     */
    public String getOperationString(String text) {
        LinkedList<String> list = hashMap.get(text);
        if (list == null) {
            return null;
        }
        String final_string = " ";
        return list.stream().map((s) -> s + " ").reduce(final_string, String::concat);

    }
     /**
     **Il metodo restituisce i nomi di tutte le operazioni definite dall'utente.
     * @return  Set<String> contenente tutti i nomi delle operazioni.
     * 
     */
    public Set<String> getNames() {
        return hashMap.keySet();
    }
     /**
     **Il metodo prende in ingresso il nome di un operazione già definita dall'utente e la rimuove.Nel caso in cui non è presente return false
     * @param name, Nome dell'operazione
     * @return boolean il metodo ritorna true se l'elemento era presente ed è stato cancellato, false altrimenti.
     * 
     */
    public boolean removeOperation(String name) {
        LinkedList<String> remove = hashMap.remove(name);
        return (remove != null);
    }

    @Override
    public String toString() {
        String s = "";
        s = hashMap.keySet().stream().map((key) -> key + ":" + this.getOperationString(key) + "\n").reduce(s, String::concat);
        return s;
    }
    
    
    
}
