/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se_project;

import java.util.HashMap;
import se_project.exceptions.InvalidVariableNameException;
import se_project.exceptions.NonExistingVariable;
import se_project.exceptions.VariableExistingException;

/**
 *
 * @author aless
 */
public class VariablesDict {

    private HashMap<Character, ComplexNumber> table;

    public VariablesDict() {
        table = new HashMap<>();
    }

    private void checkName(char var) throws InvalidVariableNameException {
        if (!((var >= 'a') && (var <= 'z'))) {
            throw new InvalidVariableNameException();
        }
    }

    public void setVariable(char var, ComplexNumber value) throws VariableExistingException, InvalidVariableNameException {
        checkName(var);
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

}
