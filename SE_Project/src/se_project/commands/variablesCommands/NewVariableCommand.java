/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se_project.commands.variablesCommands;

import se_project.ComplexNumber;
import se_project.Stack;
import se_project.VariablesDict;
import se_project.exceptions.EmptyStackException;
import se_project.exceptions.InvalidValueException;
import se_project.exceptions.InvalidVariableNameException;
import se_project.exceptions.VariableExistingException;

/**
 * Classe che rappresenta l'operazione di inserimento di una variabile.
 * @author aless
 */
public class NewVariableCommand extends VariableCommand {


    public NewVariableCommand() {
    }

    public NewVariableCommand(Character variable) {
        super();
        super.setVariable(variable);}

    public NewVariableCommand(Character variable, Stack stack, VariablesDict dict) {
        super(stack, dict);

        super.setVariable(variable);
    }

    /**
     * Il metodo execute prende il carattere definito come attributo della classe (variable)
     * e l'elemento in cima allo stack.
     * nel dizionario viene settata una entry variabile(character) -> (valore)
     * Viene lanciata un'eccezione se la variabile è già presente.
     * 
     * Si riaggiunge l'elemento rimosso dallo stack.
     * 
     * @return 
     * @throws se_project.exceptions.EmptyStackException
     * @throws se_project.exceptions.InvalidVariableNameException
     * @throws se_project.exceptions.VariableExistingException
     * @throws se_project.exceptions.InvalidValueException
     */
    @Override
    public ComplexNumber execute() throws EmptyStackException, InvalidVariableNameException, VariableExistingException, InvalidValueException {
        Stack stack = super.getTarget();
        ComplexNumber complex = stack.pop();
        try{
            super.getDictionary().setVariable(super.getVariable(), complex);
        }catch(InvalidVariableNameException ex){
            throw ex;
        }finally{
        stack.push(complex); 
        }

        return complex;
    }
     /**
     * La toString della classe ColonsCommand contiene solo il nome
     * dell'operazione.
     */
    @Override
    public String toString(){
        return ">" + super.getVariable();
    }
   
}
