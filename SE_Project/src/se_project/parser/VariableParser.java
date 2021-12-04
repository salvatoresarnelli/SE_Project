/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se_project.parser;

import se_project.VariablesDict;
import se_project.parser.ParserString;
import se_project.commands.Command;
import se_project.commands.OperationCommand;
import se_project.commands.OperationNotFoundException;
import se_project.commands.not_implemented_yet.CommandFactory;
import se_project.commands.not_implemented_yet.NewVariableCommand;
import se_project.commands.not_implemented_yet.PushVariableCommand;
import se_project.commands.not_implemented_yet.VariableCommand;

/**
 *
 * @author aless
 */
public class VariableParser extends ParserString {

    private ParserString parser;
    private VariablesDict dict;

    public VariableParser(ParserString parser) {
        this.parser = parser;
        dict = new VariablesDict();

    }

    @Override
    public OperationCommand parse(String textString) throws ArrayIndexOutOfBoundsException, OperationNotFoundException, Exception {
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
        return parser.parse(textString);
    }

    private boolean checkVariableIns(String txtString) {
        return txtString.charAt(0) == '>' && txtString.length() == 2;
    }

    private boolean checkVariablePushed(String txtString) {
        return txtString.charAt(0) == '<' && txtString.length() == 2;
    }

}
