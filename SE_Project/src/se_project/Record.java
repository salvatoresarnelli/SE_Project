/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se_project;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;

/**
 *
 * @author aless
 */
    public class Record{
    private HashMap<Character,ComplexNumber> dictRecord;
    private LocalDateTime date;
    
    
    public Record( HashMap<Character,ComplexNumber> dictRecord){
        this.dictRecord = dictRecord;
        date = LocalDateTime.now();
    }

        public HashMap<Character, ComplexNumber> getDictRecord() {
            return dictRecord;
        }

        public LocalDateTime getDate() {
            return date;
        }
            }