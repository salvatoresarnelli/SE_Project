/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se_project;

import java.time.LocalDateTime;
import java.util.HashMap;

/**
 *
 * @author aless
 *
 * Tale classe è una tupla in cui è memorizzato lo stato corrente del dizionario
 * e il momento in cui è stata richiesta una copia del suo contenuto. La classe
 * ha due attributi privati: -una hashmap contenente le coppie
 * carattere(variabile) e un numero complesso. -una data.
 */
public class Record {

    private final HashMap<Character, ComplexNumber> dictRecord;
    private final LocalDateTime date;

    /**
     *
     * Il costruttore di tale classe prevede che venga passato un'istanza di una
     * mappa carattere-numero complesso.La data si ottiene con il metodo statico
     * now() della classe LocalDateTime.
     *
     * @param dictRecord
     */
    public Record(HashMap<Character, ComplexNumber> dictRecord) {
        this.dictRecord = dictRecord;
        date = LocalDateTime.now();
    }

    /**
     *
     * Restituisce la hasmap memorizzata nel record.
     *
     * @return HashMap<Character,ComplexNumber>
     */
    public HashMap<Character, ComplexNumber> getDictRecord() {
        return dictRecord;
    }

    /**
     *
     * Restituisce la data memorizzata nel record.
     *
     * @return LocalDateTime
     */
    public LocalDateTime getDate() {
        return date;
    }
}
