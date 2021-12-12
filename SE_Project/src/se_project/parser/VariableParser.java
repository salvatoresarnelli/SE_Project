/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se_project.parser;

import se_project.VariablesDict;
import se_project.VariablesStack;
import se_project.commands.OperationCommand;
import se_project.exceptions.OperationNotFoundException;
import se_project.commands.variablesCommands.DiffVariableCommand;
import se_project.commands.variablesCommands.NewVariableCommand;
import se_project.commands.variablesCommands.PushVariableCommand;
import se_project.commands.variablesCommands.SaveVariableCommand;
import se_project.commands.variablesCommands.SumVariableCommand;
import se_project.exceptions.CollisionException;
import se_project.exceptions.InvalidVariableNameException;
import se_project.exceptions.NonExistingVariable;

/**
 * Decoratore del ParserString, in grado di riconoscere le operazioni sulle
 * variabili.
 *
 * @author aless
 */
public class VariableParser extends ParserString {

    private ParserString parser;
    private VariablesDict dict;
    private VariablesStack variablesStack;

    public VariableParser(ParserString parser) {
        this.parser = parser;
        dict = VariablesDict.getInstance();
        variablesStack = VariablesStack.getInstance();

    }

    public VariablesDict getDict() {
        return dict;
    }

    /**
     * Il metodo parse è in grado di riconoscere se: o la string passata come
     * parametro è un inserimento di una variabile.o la string passata come
     * parametro è una push di una variabile.o la string passata è un comando
     * [+][nome_var] o la string passata è un comando [-][nome_var] o la string
     * passata è un comando save
     *
     *
     * @param text
     * @return OperationCommand
     * @throws se_project.exceptions.OperationNotFoundException
     */
    @Override
    public OperationCommand parse(String text) throws ArrayIndexOutOfBoundsException, OperationNotFoundException, Exception {
        if (checkVariableSave(text)) {
            SaveVariableCommand command = (SaveVariableCommand) parser.getFactory().getOperationCommand("SaveVariableCommand");
            command.setDictionary(dict);
            command.setVariablesStack(variablesStack);
            return command;

        }
        
        String textString = text.replaceAll(" ", "");

        if (checkVariableIns(textString)) {
            char c = textString.charAt(1);
            NewVariableCommand command = (NewVariableCommand) parser.getFactory().getOperationCommand("NewVariableCommand");

            command.setVariable(c);
            command.setDictionary(dict);
            return command;
        }
        if (checkVariablePushed(textString)) {
            char c = textString.charAt(1);

            PushVariableCommand command = (PushVariableCommand) parser.getFactory().getOperationCommand("PushVariableCommand");
            command.setVariable(c);
            command.setDictionary(dict);
            return command;
        }

        if (checkVariableDiff(textString)) {
            char c = textString.charAt(1);
            if (c == 'j') {
                throw new CollisionException(textString);
            }
            DiffVariableCommand command = (DiffVariableCommand) parser.getFactory().getOperationCommand("DiffVariableCommand");
            command.setVariable(c);
            command.setDictionary(dict);
            return command;

        }

        if (checkVariableSum(textString)) {
            char c = textString.charAt(1);
            if (c == 'j') {
                throw new CollisionException(textString);
            }
            SumVariableCommand command = (SumVariableCommand) parser.getFactory().getOperationCommand("SumVariableCommand");
            command.setVariable(c);
            command.setDictionary(dict);

            return command;

        }


        return parser.parse(textString);
    }

    /**
     * Verifica se la stringa passata rispetta la sintassi dell'inserimento:
     * >[lettera].
     *
     */
    private boolean checkVariableIns(String txtString) {
        return txtString != null && txtString.length() == 2 && txtString.charAt(0) == '>'
                && Character.isAlphabetic(txtString.charAt(1));
    }

    /**
     * Verifica se la stringa passata rispetta la sintassi della push:
     * <[lettera].
     *
     */
    private boolean checkVariablePushed(String txtString) {
        return txtString != null && txtString.length() == 2 && txtString.charAt(0) == '<' && Character.isAlphabetic(txtString.charAt(1));
    }

    /**
     * Verifica se la stringa passata rispetta la sintassi della somma del
     * valore di una variabile: +[lettera].
     *
     */
    private boolean checkVariableSum(String txtString) {
        try {
            return txtString != null && txtString.length() == 2 && txtString.charAt(0) == '+' && dict.getVariableValue(txtString.charAt(1)) != null;
        } catch (NonExistingVariable | InvalidVariableNameException ex) {
            return false;
        }
    }

    /**
     * Verifica se la stringa passata rispetta la sintassi della differenza del
     * valore di una variabile: -[lettera].
     *
     */
    private boolean checkVariableDiff(String txtString) throws NonExistingVariable, InvalidVariableNameException {
        try {
            return txtString != null && txtString.length() == 2 && txtString.charAt(0) == '-' && dict.getVariableValue(txtString.charAt(1)) != null;
        } catch (NonExistingVariable ex) {
            return false;
        }
    }

    /**
     * Verifica se la stringa passata rispetta la sintassi del salvataggio:
     * save.
     *
     */
    private boolean checkVariableSave(String textString) {
        if(textString==null)
            return false;
        StringBuffer sb = new StringBuffer(textString);
        textString = textString.trim();
        if(textString.length()<4)
            return false;
        
        String afterSave = textString.substring(4).replaceAll(" ", "");
        if(afterSave.length()!=0)
            return false;
        textString = textString.replaceAll(" ","");
        return textString.equals("save");

    }

}
