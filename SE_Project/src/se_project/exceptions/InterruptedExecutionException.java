/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se_project.exceptions;

import java.util.LinkedList;
import se_project.ComplexNumber;
import se_project.commands.userDefinedOperations.ExecuteUserDefinedOperationCommand;

/**
 *
 * @author aless
 */ 
public class InterruptedExecutionException extends Exception{
    private ExecuteUserDefinedOperationCommand command; 
    private LinkedList<ComplexNumber> rollBackList;
    private String exceptionCause;

    public InterruptedExecutionException(ExecuteUserDefinedOperationCommand command, LinkedList<ComplexNumber> rollBackList,String exceptionCause) {
        this.command = command;
        this.rollBackList = rollBackList;
        this.exceptionCause = exceptionCause;
    }

    public String getExceptionCause() {
        return exceptionCause;
    }

    public ExecuteUserDefinedOperationCommand getCommand() {
        return command;
    }

    public LinkedList<ComplexNumber> getRollBackList() {
        return rollBackList;
    }
    
    
   
}
