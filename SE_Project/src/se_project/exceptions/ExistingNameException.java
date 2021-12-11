/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se_project.exceptions;

import java.util.LinkedList;
import se_project.ComplexNumber;

/**
 * Eccezione lanciata quando si vuole inserire una userdefined operation, ma è
 * già presente in memoria una userdefined operation con lo stesso nome.
 *
 * @author aless
 */
public class ExistingNameException extends Exception {

    private LinkedList<ComplexNumber> list;

    public ExistingNameException() {
    }

    public ExistingNameException(LinkedList<ComplexNumber> list) {
        this.list = list;
    }

    public LinkedList<ComplexNumber> getList() {
        return list;
    }

}
