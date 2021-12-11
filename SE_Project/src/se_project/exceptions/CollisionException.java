/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se_project.exceptions;

/**
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
