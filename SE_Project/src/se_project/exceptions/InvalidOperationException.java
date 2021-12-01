/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package se_project.exceptions;

/**
 *
 * @author Salvatore
 */
public class InvalidOperationException extends Exception{

    /**
     * Creates a new instance of <code>InvalidOperationException</code> without
     * detail message.
     */
    public InvalidOperationException() {
    }

    /**
     * Constructs an instance of <code>InvalidOperationException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public InvalidOperationException(String msg) {
        super(msg);
    }
}
