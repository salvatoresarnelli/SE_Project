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

    @Override
    public OperationCommand parse(String text) throws ArrayIndexOutOfBoundsException, OperationNotFoundException, Exception {
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
            if(c=='j'){
                throw new CollisionException(textString);
            }
            DiffVariableCommand command = (DiffVariableCommand) parser.getFactory().getOperationCommand("DiffVariableCommand");
            command.setVariable(c);
            command.setDictionary(dict);
            return command;

        }

        if (checkVariableSum(textString)) {
            char c = textString.charAt(1);
             if(c=='j'){
                throw new CollisionException(textString);
            }
            SumVariableCommand command = (SumVariableCommand) parser.getFactory().getOperationCommand("SumVariableCommand");
            command.setVariable(c);
            command.setDictionary(dict);
           
                return command;

        }
        if (checkVariableSave(textString)) {
            SaveVariableCommand command = (SaveVariableCommand) parser.getFactory().getOperationCommand("SaveVariableCommand");
            command.setDictionary(dict);
            command.setVariablesStack(variablesStack);
                return command;
            
                
        }

        return parser.parse(textString);
    }

    private boolean checkVariableIns(String txtString) {
        return txtString.charAt(0) == '>' && txtString.length() == 2 && Character.isAlphabetic(txtString.charAt(1));
    }

    private boolean checkVariablePushed(String txtString) {
        return txtString.charAt(0) == '<' && txtString.length() == 2 && Character.isAlphabetic(txtString.charAt(1));
    }

    private boolean checkVariableSum(String txtString) {
        try {
            return txtString.charAt(0) == '+' && txtString.length() == 2 && dict.getVariableValue(txtString.charAt(1)) != null;
        } catch (NonExistingVariable | InvalidVariableNameException ex) {
            return false;
        }
    }

    private boolean checkVariableDiff(String txtString) throws NonExistingVariable, InvalidVariableNameException {
        try {
            return txtString.charAt(0) == '-' && txtString.length() == 2 && dict.getVariableValue(txtString.charAt(1)) != null;
        } catch (NonExistingVariable ex) {
            return false;
        }
    }

    private boolean checkVariableSave(String textString) {
        return textString.equals("save");

    }

}
