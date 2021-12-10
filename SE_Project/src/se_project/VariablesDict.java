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
 */
public class VariablesDict {
    private static VariablesDict instance = null;
    private HashMap<Character, ComplexNumber> table;

    // Costruttore invisibile
    private VariablesDict() {
            table = new HashMap<>();
} 
 
    public static VariablesDict getInstance() {
        // Crea l'oggetto solo se NON esiste:
        if (instance == null) {
            instance = new VariablesDict();
        }
        return instance;
    }


    private void checkName(char var) throws InvalidVariableNameException {
        if (!((var >= 'a') && (var <= 'z'))) {
            throw new InvalidVariableNameException();
        }
    }
    
    private void checkValue(ComplexNumber value)  throws InvalidValueException{
    if(value == null)
        throw new InvalidValueException();
    }


    public void setVariable(char var, ComplexNumber value) throws InvalidValueException,VariableExistingException, InvalidVariableNameException {
        checkName(var);
        checkValue(value);
        if (table.containsKey(var)) {
            throw new VariableExistingException();
        } else {
            table.put(var, value);
        }
    }

    public void forceSettingVariable(char var, ComplexNumber value) throws InvalidVariableNameException {
        checkName(var);
        table.put(var, value);
    }

    public ComplexNumber getVariableValue(char var) throws InvalidVariableNameException, NonExistingVariable {
        checkName(var);
        if(!table.containsKey(var))
            throw new NonExistingVariable();
        return table.get(var);
    }

    public HashMap<Character, ComplexNumber> getTable() {
        return table;
    }
    public ComplexNumber remove(char c){
        if(table.containsKey(c))
            return table.remove(c);
        return null;
    }
}
