/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se_project.parser;

import java.util.logging.Level;
import java.util.logging.Logger;
import se_project.ComplexNumber;
import se_project.commands.Command;
import se_project.commands.InsertNumberCommand;
import se_project.commands.OperationCommand;
import se_project.exceptions.OperationNotFoundException;
import se_project.commands.OperationsFactory;
import se_project.commands.operationsCommands.ColonsCommand;
import se_project.commands.operationsCommands.DotCommand;
import se_project.commands.operationsCommands.MinusCommand;
import se_project.commands.operationsCommands.PlusCommand;
import se_project.commands.operationsCommands.SignCommand;
import se_project.commands.operationsCommands.SqrtCommand;
import se_project.commands.stackCommands.ClearCommand;
import se_project.commands.stackCommands.DropCommand;
import se_project.commands.stackCommands.DuplicateCommand;
import se_project.commands.stackCommands.OverCommand;
import se_project.commands.stackCommands.SwapCommand;

/**
 *
 * @author emanu
 */
public class ParserString implements AbstractParserString {

    private OperationsFactory factory;
    
    public ParserString(){
        factory = new OperationsFactory();
    }
   
    /**
     *Il metodo controlla se la stringa data in input è un numero complesso, un numero reale, un numero puramente immaginario, un'operazione..
     * @author emanu
     * @param <T>
     * @param text , stringa da dover controllare.
     * @return      ritorna complex_number se la stringa è un numero complesso,un
     *              numero reale o un numero puramente immaginario; ritorna operation
     *              se la stringa text contiene un'operazione, invalid_insert altrimenti.
     * @throws java.lang.Exception
     * 
     */
    @Override
    public OperationCommand  parse(String text) throws NullPointerException, Exception{
        return null;
 }
    /**
     *Il metodo controlla se la stringa data in input presenta un operatore + o un operatore - .
     * @author emanu
     * @param text , stringa da dover controllare.
     * @return     ritorna l'operatore se presente, altrimenti uno carattere spazio.
     * 
     */
   
    public OperationsFactory getFactory() {
        return factory;
    }
    
}

