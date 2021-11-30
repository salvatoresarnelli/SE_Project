/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se_project.exceptions;

/**
 *
 * @author emanu
 */
public class InvalidNameException extends RuntimeException {

    /**
     * Creates a new instance of <code>InvalidNameException</code> without
     * detail message.
     */
    public InvalidNameException() {
    }

    /**
     * Constructs an instance of <code>InvalidNameException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public InvalidNameException(String msg) {
        super(msg);
    }
}
