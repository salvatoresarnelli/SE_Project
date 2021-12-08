/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package se_project;

import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import se_project.exceptions.InvalidVariableNameException;
import se_project.exceptions.NonExistingVariable;

/**
 *
 * @author Salvatore Sarnelli
 */
public class VisualizeVariables {
    private VariablesDict dict;

    public VisualizeVariables() {
        dict = new VariablesDict();
    }
    
    public void visualize() throws InvalidVariableNameException, NonExistingVariable {
        for(Character ch : dict.getTable().keySet()) {
            ComplexNumber c = dict.getVariableValue(ch);
        }
    }
    
}
