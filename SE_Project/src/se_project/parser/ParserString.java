/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se_project.parser;

import java.util.LinkedList;
import se_project.commands.Command;
import se_project.commands.OperationCommand;
import se_project.commands.OperationsFactory;

/**
 *La classe ParserString implementa una classe astratta AbstractParserString, in cui sono presenti due metodi da implementare:
 * il metodo parse e il metodo getFactory(). In tal modo, la classe si presta bene al pattern del decoratore e del factory.
 * 
 * @author emanu
 */
public class ParserString implements AbstractParserString {

    private OperationsFactory factory;
    
    public ParserString(){
        factory = new OperationsFactory();
    }
   
    @Override
    public OperationCommand  parse(String text) throws NullPointerException, Exception{
        return null;
 }
  
   
    public OperationsFactory getFactory() {
        return factory;
    }
  
    
    
}

