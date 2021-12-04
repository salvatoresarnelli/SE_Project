/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se_project.parser;

import se_project.commands.Command;
import se_project.commands.OperationCommand;

/**
 *
 * @author aless
 */
public interface AbstractParserString {
    
    public abstract <T extends OperationCommand> T parse(String text) throws Exception;
}
