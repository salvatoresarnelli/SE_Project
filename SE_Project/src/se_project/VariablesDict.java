/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se_project;

import java.util.HashMap;
import se_project.exceptions.InvalidValueException;
import se_project.exceptions.InvalidVariableNameException;
import se_project.exceptions.NonExistingVariable;
import se_project.exceptions.VariableExistingException;

/**
 *
 * @author aless
 *
 * Tale oggetto è un singleton che contiene una mappatura di Caratteri e Numeri
 * complessi. Dove ogni carattere è una variabile e il numero complesso
 * associatogli è il valore.
 *
 */
public class VariablesDict {

    private static VariablesDict instance = null;
    private final HashMap<Character, ComplexNumber> table;

    /**
     * Costruttore invisibile in cui viene inzializzata la mappa.
     */
    private VariablesDict() {
        table = new HashMap<>();
    }

    /**
     * Crea il variablesDict se non esiste.Restituisce il variablesDict creato
     * precedentemente Se esiste già un'instanza di esso.
     *
     * @return VariablesDict
     */
    public static VariablesDict getInstance() {
        // Crea l'oggetto solo se NON esiste:
        if (instance == null) {
            instance = new VariablesDict();
        }
        return instance;
    }

    /**
     * Tale metodo è un metodo di utility che consente di controllare se
     * l'eventuale carattere passato rispetta i parametri della classe. La
     * variabile deve essere una lettera minuscola. Se non vengono rispettati
     * tali parametri, viene lanciata un'Eccezione.
     *
     * @return VariablesDict
     * @throws InvalidVariableNameException
     */
    private void checkName(char var) throws InvalidVariableNameException {
        if (!((var >= 'a') && (var <= 'z'))) {
            throw new InvalidVariableNameException();
        }
    }

    /**
     * Tale metodo è un metodo di utility che consente di controllare se
     * l'eventuale numero complesso passato rispetta i parametri della classe.
     * In particolare, se il numero complesso è un puntatore a null, viene
     * lanciata un'Eccezione.
     *
     * @return VariablesDict
     * @throws InvalidVariableNameException
     */
    private void checkValue(ComplexNumber value) throws InvalidValueException {
        if (value == null) {
            throw new InvalidValueException();
        }
    }

    /**
     *
     * @param var
     * @param value
     * @throws InvalidValueException
     * @throws VariableExistingException
     * @throws InvalidVariableNameException Verifica se la variabile var ha un
     * valore ammissibile. Verficica se value ha un valore ammissibile. Lancia
     * un'eccezione se la variabile già esiste. Altrimenti crea una entry avente
     * come chiave la variabile e come valore il numerocomplesso passato come
     * parametro.
     */
    public void setVariable(char var, ComplexNumber value) throws InvalidValueException, VariableExistingException, InvalidVariableNameException {
        checkName(var);
        checkValue(value);
        if (table.containsKey(var)) {
            throw new VariableExistingException();
        } else {
            table.put(var, value);
        }
    }

    /**
     *
     * @param var
     * @param value
     * @throws InvalidVariableNameException Verifica se la variabile var ha un
     * valore ammissibile. Crea una entry avente come chiave la variabile e come
     * valore il numerocomplesso passato come parametro.
     */
    public void forceSettingVariable(char var, ComplexNumber value) throws InvalidVariableNameException {
        checkName(var);
        table.put(var, value);
    }

    /**
     *
     * @param var
     * @return ComplexNumber
     * @throws InvalidVariableNameException Verifica se la variabile var ha un
     * valore ammissibile. Se la variabile non è presente viene lanciata
     * un'eccezione, altrimenti restituisce il numero complesso associato alla
     * variabile passata.
     * @throws se_project.exceptions.NonExistingVariable
     */
    public ComplexNumber getVariableValue(char var) throws InvalidVariableNameException, NonExistingVariable {
        checkName(var);
        if (!table.containsKey(var)) {
            throw new NonExistingVariable();
        }
        return table.get(var);
    }

    /**
     *
     * @return HashMap<Character,ComplexNumber>
     * restituisce l'hashmap contentente chiavi e numeri complessi.
     */
    public HashMap<Character, ComplexNumber> getTable() {
        return table;
    }

    /**
     *
     * @param c
     * @return ComplexNumber rimuove una variabile se conntenuta nella tabella.
     * restituisce il numero rimosso, null se il numero non è presente.
     */

    public ComplexNumber remove(char c) {
        if (table.containsKey(c)) {
            return table.remove(c);
        }
        return null;
    }
}
