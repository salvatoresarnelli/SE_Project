/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se_project.parser;

import java.util.LinkedList;
import se_project.ComplexNumber;
import se_project.commands.Command;
import se_project.commands.InsertNumberCommand;
import se_project.commands.OperationCommand;

/**
 * La classe ComplexNumberParser permette all'utente di definire dei numeri
 * complessi. Le possibilità in cui possono essere definite sono molteplici:
 * solo parte reale +3.0 solo parte immaginaria +4j parte reale e parte
 * immaginaria +3 + 6j oppure 6j + 3 oppure j6 + 1 La classe viene definita come
 * un decoratore di un ParserString già definito, così da implementare nuove
 * funzionalità.
 *
 *
 * @author
 */
public class ComplexNumberParser extends ParserString {

    ParserString parser;
    private final String complex_number = "__COMPLEX__NUMBER__";
    private final String single_number = "__SINGLENUMBER__";
    private final String invalid_insert = "__INVALID__";
    private final String continue_checking = "__CHECKING__";

    /**
     * Il costruttore del decorator prende in ingresso un parser string e
     * inizializza successivamente un ParserString.
     *
     * @param parser, parser che verrà decorato.
     *
     */
    public ComplexNumberParser(ParserString parser) {
        this.parser = parser;
    }

    /**
     * Il metodo prende in ingresso una stringa da dover controllare. In
     * particolare controlla se l'utente sta cercando di definire un numero
     * complesso, nel caso contrario chiama il parser che viene esteso.
     *
     * @param text, Stringa da dover formattare.
     * @return OperationCommand, comando da eseguire.
     * @throws java.lang.Exception
     *
     *
     */
    
    private OperationCommand numberParser(String text) {
    
        if (text.length() == 0) {
            return null;
        }
        OperationCommand return_value;

        char first = this.checkFirstCharacter(text);
        text = clearString(text);

        if (text.startsWith("+") || text.startsWith("-")) {
            return null;
        }
        String ret = checkComplexNumber(text);
        if (ret.equals(complex_number)) {
            return new InsertNumberCommand(recognizeComplexNumber(text), null);
        }
        if (ret.equals(invalid_insert)) {
            return null;
        }
        ret = checkPossibleOneNumber(text);

        if (ret == single_number) {
           
            return new InsertNumberCommand(recognizeNumber((first + text).replaceAll(" ", "")), null);
        }
        return null;
    }
    
    @Override
    public OperationCommand parse(String text) throws NullPointerException, Exception {
        OperationCommand command;
        command = numberParser(text);
        if(command !=null){
             return command;
        }
        return parser.parse(text);
    }

    /**
     * Il metodo converte una stringa data in input in un numero reale o in
     * numero puramente immaginario.
     *
     * @author emanu
     * @param text String. Stringa da dover controllare.
     * @return ComplexNumber il metodo ritorna un numero complesso.
     */
    public ComplexNumber recognizeNumber(String text) {
        String replaceAll = text.replaceAll(" ", "");
        char operator1 = this.checkFirstCharacter(text);
        text = this.clearString(replaceAll);
        if (text.contains("j")) {
            StringBuilder sb = new StringBuilder(text);
            if (sb.length() > 2) {
                return null;
            }
            if (text.equals("j")) {
                return new ComplexNumber(0, Double.parseDouble(operator1 + "1"));
            }
            if (sb.charAt(0) == 'j') {
                try {
                    double imaginary = Double.parseDouble(String.valueOf(sb.charAt(1)));
                    String finalImaginary = operator1 + String.valueOf(imaginary);
                    return new ComplexNumber(0, Double.parseDouble(finalImaginary));

                } catch (NumberFormatException e) {

                }

            }
            if (sb.charAt(1) == 'j') {
                try {
                    double imaginary = Double.parseDouble(String.valueOf(sb.charAt(0)));
                    String finalImaginary = operator1 + String.valueOf(imaginary);
                    return new ComplexNumber(0, Double.parseDouble(finalImaginary));
                } catch (NumberFormatException e) {
                    return null;
                }
            }

        } else {
            double real = Double.parseDouble(operator1 + text);
            return new ComplexNumber(real, 0);
        }
        return null;
    }

    /**
     * Il metodo converte una stringa data in input in un numero complesso.
     *
     * @author emanu
     * @param text , stringa da dover controllare.
     * @return ritorna un numero complesso.
     */
    public ComplexNumber recognizeComplexNumber(String text) {
        text = text.replaceAll(" ", "");
        char operator1 = this.checkFirstCharacter(text);
        text = this.clearString(text);

        char operator2 = ' ';
        if (text.contains("+")) {
            operator2 = '+';
        }
        if (text.contains("-")) {
            operator2 = '-';
        }
        String[] scanner = text.split("\\+|\\-");
        text = scanner[0];
        if (text.contains("j")) {
            StringBuilder sb = new StringBuilder(text);
            if (sb.length() > 2) {
                return null;
            }

            if (text.equals("j")) {
                double real = Double.parseDouble(String.valueOf(operator2 + scanner[1]));
                return new ComplexNumber(real, Double.parseDouble(operator1 + "1"));

            }

            if (sb.charAt(0) == 'j') {
                try {
                    double imaginary = Double.parseDouble(operator1 + String.valueOf(sb.charAt(1)));
                    double real = Double.parseDouble(String.valueOf(operator2 + scanner[1]));
                    return new ComplexNumber(real, imaginary);

                } catch (NumberFormatException e) {

                }
            }
            if (sb.charAt(1) == 'j') {
                try {
                    double imaginary = Double.parseDouble(operator1 + String.valueOf(sb.charAt(0)));
                    double real = Double.parseDouble(operator2 + scanner[1]);
                    return new ComplexNumber(real, imaginary);

                } catch (NumberFormatException e) {

                }
            }
        } else {
            double real = Double.parseDouble(operator1 + scanner[0]);
            text = scanner[1];
            if (text.contains("j")) {
                StringBuilder sb = new StringBuilder(text);
                if (sb.length() > 2) {
                    return null;
                }
                if (text.equals("j")) {
                    return new ComplexNumber(real, Double.parseDouble(operator2 + "1"));
                }
                if (sb.charAt(0) == 'j') {
                    try {
                        double imaginary = Double.parseDouble(operator2 + String.valueOf(sb.charAt(1)));
                        return new ComplexNumber(real, imaginary);

                    } catch (NumberFormatException e) {

                    }
                }
                if (sb.charAt(1) == 'j') {
                    try {
                        double imaginary = Double.parseDouble(operator2 + String.valueOf(sb.charAt(0)));
                        return new ComplexNumber(real, imaginary);

                    } catch (NumberFormatException e) {

                    }
                }
            }
        }
        return null;
    }

    /**
     * Il metodo controlla se la stringa data in input è un numero complesso.
     *
     * @author emanu
     * @param text , stringa da dover controllare.
     * @return ritorna un ComplexNumber se la stringa è un numero complesso,
     * ritorna continue_checking se la stringa passata non è un numero,
     * altrimenti invalid_insert.
     *
     */
    public String checkComplexNumber(String text) {

        if (text.contains("+") || text.contains("-")) {
            String replaceAll = text.replaceAll(" ", "");
            String[] scanner = replaceAll.split("\\+|\\-");
            if (scanner.length > 2) {
                return invalid_insert;
            }
            if (this.checkPossiblePartReal(scanner[0])) {
                try {
                    String element = scanner[1];
                } catch (ArrayIndexOutOfBoundsException e) {
                    return invalid_insert;
                }
                return this.checkPossiblePartImaginary(scanner[1]) ? complex_number : invalid_insert;
            }

            if (this.checkPossiblePartImaginary(scanner[0])) {
                try {
                    String element = scanner[1];
                } catch (ArrayIndexOutOfBoundsException e) {
                    return invalid_insert;
                }
                return this.checkPossiblePartReal(scanner[1]) ? complex_number : invalid_insert;

            }

            return invalid_insert;
        }
        return continue_checking;
    }

    /**
     * Il metodo ritorna la stringa in cui sono stati eliminati gli spazi
     * bianchi ed elimina anche un eventuale + o - presente all'inizio di essa.
     *
     * @author emanu
     * @param text, stringa da dover modificare.
     * @return stringa che è stata modificata
     *
     */
    public String clearString(String text) {
        text = text.replaceAll("\\n", "");
        if (text.startsWith("+") || text.startsWith("-")) {
            StringBuilder sb = new StringBuilder(text);
            // Removing the first character
            // of a string
            sb.deleteCharAt(0);

            // Converting StringBuilder into a string
            // and return the modified string
            return sb.toString();
        }
        return text;
    }

    /**
     * Il metodo controlla se la stringa data in input è un numero reale.
     *
     * @author emanu
     * @param text , stringa da dover controllare.
     * @return ritorna true se la stringa è un numero reale, false altrimenti.
     *
     */
    public boolean checkPossiblePartReal(String text) {
        try {
            double real = Double.parseDouble(text);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    /**
     * Il metodo controlla se la stringa data in input è un numero immaginario .
     *
     * @author emanu
     * @param text , stringa da dover controllare.
     * @return ritorna true se la stringa è un numero immaginario, false
     * altrimenti.
     *
     */
    public boolean checkPossiblePartImaginary(String text) {
        text = this.clearString(text);
        text = text.replaceAll(" ", "");
        if (text.contains("j")) {
            StringBuilder sb = new StringBuilder(text);
            if (sb.length() > 2) {
                return false;
            }

            if (sb.charAt(0) == 'j' && sb.length() == 1) {
                return true;
            }
            if (sb.charAt(0) == 'j') {

                try {
                    double imaginary = Double.parseDouble(String.valueOf(sb.charAt(1)));

                    return true;

                } catch (NumberFormatException e) {

                }

            }

            if (sb.charAt(1) == 'j') {
                try {
                    double imaginary = Double.parseDouble(String.valueOf(sb.charAt(0)));
                    return true;

                } catch (NumberFormatException e) {
                    return false;
                }

            }
        }
        return false;
    }

    /**
     * Il metodo controlla se la stringa data in input è un solo numero reale o
     * immaginario.
     *
     * @author emanu
     * @param text , stringa da controllare.
     * @return ritorna complex_number se la stringa è un numero,
     * continue_checking altrimenti.
     *
     */
    public String checkPossibleOneNumber(String text) {
        if (this.checkPossiblePartReal(text)) {
            return single_number;
        }

        return this.checkPossiblePartImaginary(text) ? single_number : invalid_insert;
    }

    public char checkFirstCharacter(String text) {
        text = text.replaceAll("\\n", "");
        if (text.startsWith("+") || text.startsWith("-")) {
            StringBuilder sb = new StringBuilder(text);
            // Removing the first character
            // of a string
            return sb.charAt(0);
        }
        return ' ';
    }

  
}
