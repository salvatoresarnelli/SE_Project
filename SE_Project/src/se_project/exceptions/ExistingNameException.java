/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se_project.exceptions;

import java.util.LinkedList;
import se_project.ComplexNumber;

/**
 *
 * @author aless
 */
public class ExistingNameException extends Exception {
    private LinkedList<ComplexNumber> list;
    public ExistingNameException(){}
    public ExistingNameException(LinkedList<ComplexNumber> list){
    this.list = list;
    }

    public LinkedList<ComplexNumber> getList() {
        return list;
    }
    
}
