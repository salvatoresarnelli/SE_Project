/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se_project.commands;

/**
 * Quest'interfaccia astratta definisce il metodo execute.
 * @author aless
 */
public abstract interface Command {
    
    public abstract Object execute() throws Exception;
    
}
