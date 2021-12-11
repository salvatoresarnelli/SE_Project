/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se_project.parser;

import se_project.exceptions.ExistingNameException;
import se_project.exceptions.InvalidNameException;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Set;
import se_project.OperationDict;
import se_project.commands.Command;
import se_project.commands.userDefinedOperations.ExecuteUserDefinedOperationCommand;
import se_project.commands.userDefinedOperations.InsertUserDefinedOperationCommand;
import se_project.commands.OperationCommand;
import se_project.exceptions.OperationNotFoundException;
import se_project.commands.variablesCommands.VariableCommand;
import se_project.exceptions.DivisionByZeroException;
import se_project.exceptions.EmptyStackException;
import se_project.exceptions.InvalidNumberException;
import se_project.exceptions.InvalidOperationException;
import se_project.exceptions.NotApplicableOperation;
import se_project.exceptions.UndefinedPhaseException;

/**La classe UserDefinedOperationParser viene utilizzata come decoratore di un ParserString definito in precendenza,
 * in particolare VariableParser, per aggiungere nuove funzionalità ad esso. In particolare, l'UserDefinedOperationParser
 * permette di creare e di inserire nuove operazioni definite dall'utente. Le operazione verranno salvate in una struttura
 * dati, definita come un HashMap<String,OperationCommand> che presenti come chiave il nome dell'operazione definita dall'utente,
 * la quale non deve presentare caratteri alfanumerici e deve avere una lunghezza maggiore di 1; come value, invece, saranno presenti
 * tutti i comandi associati all'operazione
 *
 * 
 */
public class UserDefinedOperationParser extends ParserString {

    private final ParserString parserString;
    private final OperationDict operationDict;
    private final LinkedList<String> linkedList;

    /**
     * Il costruttore del decorator prende in ingresso un parser string e
     * inizializza successivamente una hashMap che salva le operazione definite
     * dall'utente, in cui la chiave è il nome dell'operazione e il value è una
     * LinkedList<String> in cui sono salvate le operazioni associate.
     *
     * @param parserString, parser che verrà decorato.
     *
     */
    public UserDefinedOperationParser(ParserString parserString) {
        this.parserString = parserString;
        operationDict = OperationDict.getInstance();
        linkedList = new LinkedList<>();
        Collections.addAll(linkedList, "+", "-", "+-", "sqrt", "*", ":", "dup", "swap", "over", "drop");

    }

    /**
     * Il costruttore del decorator prende in ingresso un parser string e
     * inizializza successivamente una hashMap che salva le operazione definite
     * dall'utente, in cui la chiave è il nome dell'operazione e il value è una
     * LinkedList<String> in cui sono salvate le operazioni associate. In questo
     * caso il costruttore prende in ingresso anche un HashMap già definito, con
     * alcune operazioni già definite
     *
     * @param parserString, parser che verrà decorato.
     * @param hashMap1 , hash che,prima di essere salvato, deve essere
     * controllato affinché rispetti tutte le condizioni definite
     * precedentemente.
     * @throws InvalidNameException, il metodo lancia l'eccezione nel momento in
     * cui viene passata un hashMap che non rispecchia tutti i requisiti
     * definiti precedentemente.
     *
     */
    /*
    public UserDefinedOperationParser(ParserString parserString, HashMap<String, OperationCommand> hashMap1) throws InvalidNameException {
        this.parserString = parserString;
        hashMap1.keySet().stream().filter((s) -> (!this.checkName(s))).forEachOrdered((_item) -> {
            throw new InvalidNameException();
        });
        operationDict.setHashMap(hashMap1);
        linkedList = new LinkedList<>();
        Collections.addAll(linkedList, "+", "-", "+-", "sqrt", "*", ":", "dup", "swap", "over", "drop");
    }

    /**
     * Il metodo prende in ingresso una stringa da dover formattare, eliminando
     * eventuali \n e i primi due caratteri.
     *
     * @param text la stringa da dover formattare.
     * @throws StringIndexOutBoundsException, nel momento in cui la stringa
     * passata ha size <2
     * @return string stringa formattata.
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
     * Il metodo prende una stringa da dover formattare,controllando se sono
     * presenti all'interno di essa caratteri alfanumerici
     *
     * @param text, Stringa da dover formattare.
     * @return string stringa formattata.
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
     * Il metodo prende una stringa da dover formattare,controllando se sono
     * presenti all'interno di essa spazi iniziali, eliminandoli eventualmente.
     *
     * @param text, Stringa da dover formattare.
     * @return string stringa formattata.
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

    /**
     * Il metodo prende una stringa in ingresso. Il metodo ritorna un
     * InsertUserDefinedOperationCommand se il pattern della stringa passata è
     * corretto. Di seguito un'esempio: >>NomeFunzione $ func + - + Il pattern
     * prevede una sintassi in cui vengono definiti all'inizio due caratteri
     * maggiore, poi successivamente il nome della funzione, un delimitatore, e
     * tutte le operazioni che si vogliono associare al nome della funzione. Le
     * operazioni che possono essere associate sono: "+", "-", "+-", "sqrt",
     * "*", ":", "dup", "swap", "over", "drop" e anche le operazioni già
     * definite precedentemente.
     *
     *
     * @param text, Stringa da dover controllare
     * @return InsertUserDefinedOperationCommand , comando utilizzato per
     * inserire l'operazione.
     * @throws ExistingNameException, il metodo lancia un'eccezione se il nome
     * dell'operazione che si vuole inserire, è già presente.
     *
     */

    private InsertUserDefinedOperationCommand parseInsert(String textString) throws ArrayIndexOutOfBoundsException,
            ExistingNameException, OperationNotFoundException, Exception {
        textString = this.clearStringOperation(textString);
        String[] string = textString.split("\\$");
        String possible_name = string[0];
        possible_name = possible_name.replaceAll(" ", "");

        if (possible_name.length() <= 1 || linkedList.contains(possible_name)) {
            return null;
        }
        String possible_operations = string[1];
        if (!this.checkName(possible_name)) {
            return null;
        }
        possible_operations = this.removeInitialSpaces(possible_operations);
        LinkedList<OperationCommand> finalOperations = new LinkedList<>();

        if (!operationDict.getHashMap().containsKey(possible_name)) {
            String[] operations = possible_operations.split("\\s+");
            for (String possibile_operation : operations) {
                if (!operationDict.getHashMap().containsKey(possibile_operation)) {
                    OperationCommand parsed = parserString.parse(possibile_operation);
                    if (parsed == null) {
                        throw new InvalidNameException("operazione non definita " + possibile_operation);
                    } else {
                        finalOperations.add(parsed);
                    }
                } else {
                    finalOperations.add(super.getFactory().getOperationCommand(possibile_operation, operationDict.getHashMap()));
                }
            }

            operationDict.getHashMap().put(possible_name, new ExecuteUserDefinedOperationCommand(possible_name, finalOperations));
            return new InsertUserDefinedOperationCommand(possible_name, finalOperations, operationDict.getHashMap());
        }

        throw new ExistingNameException();

    }

    /**
     * Il metodo prende in ingresso una stringa da dover controllare. In
     * particolare controlla se l'utente sta cercando di definire un'operazione,
     * nel caso contrario chiama il parser che viene esteso.
     *
     * @param textString, Stringa da dover formattare.
     * @throws ArrayIndexOutBoundsException
     * @return OperationCommand, comando da eseguire.
     *
     *
     */
    @Override
    public OperationCommand parse(String textString) throws ArrayIndexOutOfBoundsException,
            ExistingNameException, OperationNotFoundException, InvalidNameException, Exception {
        if (textString.startsWith(">>")) {
            return parseInsert(textString);
        }
        if (operationDict.getNames() != null && operationDict.getNames().contains(textString)) {

            ExecuteUserDefinedOperationCommand userDefOp = userOperation(textString);
            if (userDefOp != null) {
              
            }
        }

        return parserString.parse(textString);
    }

    /**
     * Il metodo prende in ingresso il nome di un'operazione definita
     * precedentemente e ritorna tutti i comandi associati a quel nome.
     *
     * @param text, Nome dell'operazione
     * @throws se_project.exceptions.EmptyStackException se lo stack è vuoto.
     * @throws se_project.exceptions.NotApplicableOperation se non è possibile
     * applicare l'operazione
     * @throws se_project.exceptions.UndefinedPhaseException se la fase del
     * numero complesso non è definita.
     * @throws se_project.exceptions.DivisionByZeroException se si sta cercando
     * di fare una divisone per 0.
     * @throws se_project.exceptions.InvalidOperationException se l'operazione
     * inserita non è valida.
     * @throws se_project.exceptions.InvalidNumberException se il numero
     * inserito non è valido.
     * @return OperationCommand, comando da eseguire.
     *
     */

    public ExecuteUserDefinedOperationCommand userOperation(String text) throws EmptyStackException, NotApplicableOperation, InvalidNumberException, UndefinedPhaseException, DivisionByZeroException, InvalidOperationException {
        ExecuteUserDefinedOperationCommand operations = operationDict.getOperations(text);
        return operations;
    }


 
       /**
     **Il metodo prende in ingresso il nome di un operazione già definita
     * dall'utente e la rimuove.Nel caso in cui non è presente return false
     *
     * @param name, Nome dell'operazione
     * @return boolean il metodo ritorna true se l'elemento era presente ed è
     * stato cancellato, false altrimenti.
     *
     */

    public boolean removeOperation(String name){
        return operationDict.removeOperation(name);
    }
    
      /**
     **Il metodo ritorna un hashMap, in cui sono presenti come chiavi i nomi delle operazioni definite dall'utente
     * e come value tutti gli OperationCommand associati ai nomi.
     * @return HashMap<String, OperationCommand> il metodo ritorna true se l'elemento era presente ed è
     * 
     *
     */
    public HashMap<String, OperationCommand> getHashMap() {
        return operationDict.getHashMap();
    }
      /**
     **Il metodo ritorna un ParserString associato al decoratore.
     * @return ParserString
     * 
     *
     */
  
}
