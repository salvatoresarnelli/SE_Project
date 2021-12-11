/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se_project.exceptions;

/**
 * Quest'eccezione viene generata nel momento in cui vi è un'ambiguità tra i
 * comandi.
 *
 * Ad esempio, inserendo +j: si può intendere l'operazione di: o +[variabile j]
 * o +j [inserimento del numero j]
 *
 * @author aless
 */
public class CollisionException extends Exception{
    public CollisionException(){
    }
    
    public CollisionException(String message){
        super(message);
    }
    
    
}
