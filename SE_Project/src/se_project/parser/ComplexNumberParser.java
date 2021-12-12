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
     * complesso.
     *
     * @param text, Stringa da dover formattare.
     * @return OperationCommand, comando da eseguire.
     *
     *
     *
     */
    private OperationCommand numberParser(String text) {

        if (text.length() == 0) {
            return null;
        }
        OperationCommand return_value;
        //per semplicità viene pulita la stringa, eliminando temporaneamente l'operatore iniziale
        //se presente, ed eventuali \n.
        char first = this.checkFirstCharacter(text);
        text = clearString(text);
        //se il testo inizia ancora con un operatore, c'è un errore nell'input.
        //esempio : ++3.
        if (text.startsWith("+") || text.startsWith("-")) {
            return null;
        }
        //viene controllato se la stringa data in input è un numero complesso attraverso il metodo
        //checkComplexNumber, in caso positivo viene definito il comando InsertNumberCommand
        String ret = checkComplexNumber(text);

        if (ret.equals(complex_number)) {
            return new InsertNumberCommand(recognizeComplexNumber(text), null);
        }
        if (ret.equals(invalid_insert)) {
            return null;
        }
        ret = checkPossibleOneNumber(text);
        /*
        si è cercata di fare la differenza tra un numero complesso, definito completo, il quale contiene sia parte immaginaria 
        che reale, ed un single_number, il quale è un numero puramente reale o puramente immaginario.
         */

        if (ret == single_number) {

            ComplexNumber recognizeNumber = recognizeNumber((first + text).replaceAll(" ", ""));
            if(recognizeNumber == null) return null;
            return new InsertNumberCommand(recognizeNumber((first + text).replaceAll(" ", "")), null);
        }
        return null;
    }

    /**
     * Il metodo prende in ingresso una stringa da dover controllare. In
     * particolare controlla se l'utente sta cercando di definire un numero
     * complesso, nel caso contrario chiama il parser che viene esteso.
     *
     * @param text, Stringa da dover formattare.
     * @return OperationCommand, comando da eseguire.
     * @throws java.lang.Exception , NullPointerException
     *
     *
     */
    @Override
    public OperationCommand parse(String text) throws NullPointerException, Exception {
        //Il metodo è un override del Parser che viene decorato ed esteso. Vengono implementate
        //funzionalità aggiuntive, come quelle appunto di riconoscere un numero dato in input.
        OperationCommand command;
        command = numberParser(text);
        if (command != null) {
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
        //vengono eliminati gli spazi nella stringa.
        String replaceAll = text.replaceAll(" ", "");
        //viene eliminato l'operatore + o - se presente.
        char operator1 = this.checkFirstCharacter(text);
        text = this.clearString(replaceAll);
        //se il numero contiene una j, allora potrebbe essere un numero immaginario
        if (text.contains("j")) {
            StringBuilder sb = new StringBuilder(text);
          
            //se la stringa data in input contiene solamente j, l'utente sta cercando di definire
            //il numero complesso 0 +1j.
            if (text.equals("j")) {
                return new ComplexNumber(0, Double.parseDouble(operator1 + "1"));
            }
            //qui viene controllata la posizione di j, in quanto potrebbe essere presente sia come primo carattere
            // esempio --> 3j ; oppure come secondo carattere --> j3
            if (sb.charAt(0) == 'j') {
                try {
                    text = text.replaceAll("j", "");
                    double imaginary = Double.parseDouble(String.valueOf(text));
                    String finalImaginary = operator1 + String.valueOf(imaginary);
                    return new ComplexNumber(0, Double.parseDouble(finalImaginary));

                } catch (NumberFormatException e) {

                }

            }
            if (sb.charAt(text.length()-1) == 'j') {
                try {
                    text = text.replaceAll("j","");
                    double imaginary = Double.parseDouble(String.valueOf(text));
                    String finalImaginary = operator1 + String.valueOf(imaginary);
                    return new ComplexNumber(0, Double.parseDouble(finalImaginary));
                } catch (NumberFormatException e) {
                    return null;
                }
            }

        }//se non contiene una j, allora l'utente potrebbe voler definire un numero puramente reale.
        else {
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
        //vengono eliminati gli spazi nella stringa.
        text = text.replaceAll(" ", "");
        //viene eliminato l'operatore + o - se presente.
        char operator1 = this.checkFirstCharacter(text);
        text = this.clearString(text);
        //viene salvato anche l'operatore presente all'interno della string, in quanto dopo la split, verrà perso.
        char operator2 = ' ';
        if (text.contains("+")) {
            operator2 = '+';
        }
        if (text.contains("-")) {
            operator2 = '-';
        }
        //viene splittato sull'operatore e si coprono tutte le casistiche possibili 
        // parte reale + parte immaginaria o parte immaginaria + parte reale
        // parte reale - parte immaginaria o parte immaginaria - parte reale
        String[] scanner = text.split("\\+|\\-");
        text = scanner[0];
        //se text contiene una j, allora ci troviamo nel caso immaginaria + o - quella reale.
        if (text.contains("j")) {
            StringBuilder sb = new StringBuilder(text);

              //se la stringa data in input contiene solamente j, l'utente sta cercando di definire
            //il numero complesso parte reale +1j.
            if (text.equals("j")) {
                double real = Double.parseDouble(String.valueOf(operator2 + scanner[1]));
                return new ComplexNumber(real, Double.parseDouble(operator1 + "1"));

            }
              //qui viene controllata la posizione di j, in quanto potrebbe essere presente sia come primo carattere
            // esempio --> 3j ; oppure come secondo carattere --> j3
            if (sb.charAt(0) == 'j') {
                try {
                     //se è presente come primo carattere, si cerca di convertire in double il numero in posizione 1
                    //nel caso in cui non si riesca a tradurre, viene catturata l'eccezione e si va avanti.
                    text = text.replaceAll("j", "");
                    double imaginary = Double.parseDouble(operator1 + String.valueOf(text));
                    double real = Double.parseDouble(String.valueOf(operator2 + scanner[1]));
                    return new ComplexNumber(real, imaginary);

                } catch (NumberFormatException e) {

                }
            }
                //ragionamento simmetrico rispetto al precedente.
            if (sb.charAt(text.length()-1) == 'j') {
                try {
                    text = text.replaceAll("j", "");
                    double imaginary = Double.parseDouble(operator1 + String.valueOf(text));
                    double real = Double.parseDouble(operator2 + scanner[1]);
                    return new ComplexNumber(real, imaginary);

                } catch (NumberFormatException e) {

                }
            }
        } //nel caso in cui il text non conteneva una j, allora l'utente potrebbe voler inserire
        //parte reale + o - parte immaginaria.
        else {
            //si converte la stringa in un double.
            double real = Double.parseDouble(operator1 + scanner[0]);
            text = scanner[1];
              //se text contiene una j, allora potrebbe essere un numero complesso.
            if (text.contains("j")) {
                     //se la lunghezza di sb è >2 significa che non è stato inserito correttamente
            //il numero complesso.
                StringBuilder sb = new StringBuilder(text);
                if (sb.length() > 2) {
                    return null;
                }
                 //se la stringa data in input contiene solamente j, l'utente sta cercando di definire
            //il numero complesso parte reale +1j.
                if (text.equals("j")) {
                    return new ComplexNumber(real, Double.parseDouble(operator2 + "1"));
                }
                 //qui viene controllata la posizione di j, in quanto potrebbe essere presente sia come primo carattere
            // esempio --> 3j ; oppure come secondo carattere --> j3
                if (sb.charAt(0) == 'j') {
                    try {
                        double imaginary = Double.parseDouble(operator2 + String.valueOf(sb.charAt(1)));
                        return new ComplexNumber(real, imaginary);

                    } catch (NumberFormatException e) {

                    }
                }
                //ragionamento simmetrico rispetto al precedente.
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
            //vengono eliminati gli spazi presenti nella stringa.
            String replaceAll = text.replaceAll(" ", "");
            //viene fatta la split sull'operatore presente nella stringa.
            String[] scanner = replaceAll.split("\\+|\\-");
                      //se la lunghezza di scanner è >2 significa che non è stato inserito correttamente
            //il numero complesso.
            if (scanner.length > 2) {
                return invalid_insert;
            }
            //scanner[0] potrebbe essere un numero reale + un numero immaginario oppure il contrario. 
            if (this.checkPossiblePartReal(scanner[0])) {
                //se scanner[0] è un numero reale, allora viene controllato che scanner[1] sia un numero immaginario.
                try {
                    String element = scanner[1];
                    //l'eccezione viene lanciata nel caso in cui scanner[1], nel caso in cui esso non esista.
                } catch (ArrayIndexOutOfBoundsException e) {
                    return invalid_insert;
                }
                return this.checkPossiblePartImaginary(scanner[1]) ? complex_number : invalid_insert;
            }
              //scanner[0] potrebbe essere un numero immaginario + un numero reale oppure il contrario. 
            if (this.checkPossiblePartImaginary(scanner[0])) {
           //se scanner[0] è un numero immaginario, allora viene controllato che scanner[1] sia un numero reale.
                try {
                    String element = scanner[1];
                      //l'eccezione viene lanciata nel caso in cui scanner[1], nel caso in cui esso non esista.
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
            //si cerca di convertire la stringa in double. In caso di successo, 
            //il metodo torna true. Nel caso in cui viene lanciata un'eccezione,
            //allora il metodo torna false;
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
        if (text.equals("j") || text.equals("-j")) {
            return true;
        }
        if (text.contains("j")) {

            StringBuilder sb = new StringBuilder(text);
          
            if ( (text.charAt(0) == '.') || text.charAt(text.length()-1) == '.') {
                return false;
            }
            int jCount=0;
            int pointCount=0;
            for (int i = 0; i < text.length(); i++) {
                if(sb.charAt(i)=='j'){
                    jCount++;
                }
                if(sb.charAt(i)=='.'){
                pointCount++;
                }
                if ((sb.charAt(i) > '9' || sb.charAt(i) < '0') && (sb.charAt(i) != '.') && (sb.charAt(i)!='j')) {
                    return false;
                }
            }
            if(jCount>1 || pointCount>1)
                return false;
            
            text = text.replaceAll("j", "");

            try {
                Double.parseDouble(text);
            } catch (NumberFormatException ex) {
                return false;
            }
            return true;
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
        //se è solo un numero, allora viene controllato che esso sia un numero puramente reale o puramente immaginario.
        if (this.checkPossiblePartReal(text)) {
            return single_number;
        }

        return this.checkPossiblePartImaginary(text) ? single_number : invalid_insert;
    }

    public char checkFirstCharacter(String text) {
        //viene pulita la stringa, eliminando gli eventuali /n
        // e il primo carattere se è un operatore + o - 
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
