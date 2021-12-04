/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se_project.parser;

import se_project.ComplexNumber;
import se_project.commands.InsertNumberCommand;
import se_project.commands.OperationCommand;

/**
 *
 * @author aless
 */
public class ComplexNumberParser extends ParserString{
    private ParserString parser;
    private final String complex_number = "__COMPLEX__NUMBER__";
    private final String single_number = "__SINGLENUMBER__";
    private final String invalid_insert = "__INVALID__";
    private final String continue_checking = "__CHECKING__";

    public ComplexNumberParser(ParserString parser) {
        this.parser = parser;
    }
    
    @Override
    public OperationCommand parse(String text) throws NullPointerException, Exception {

     if (text.length() == 0) {
            return null;
        }
     OperationCommand return_value;
        
    char first = this.checkFirstCharacter(text);
        text = clearString(text);
        
        if(text.startsWith("+") || text.startsWith("-")) 
            return null;
        
        String ret = checkComplexNumber(text);
        if (ret.equals(complex_number))
            return new InsertNumberCommand(recognizeComplexNumber(first+text),null);
        if(ret.equals(invalid_insert))
            return null;
        ret = checkPossibleOneNumber(first+text);
        if(ret==single_number)
            return new InsertNumberCommand(recognizeNumber((first+text).replaceAll(" ","")),null);
        else return null;
    }
    
   
    /**
     *Il metodo converte una stringa data in input in un numero reale o in numero puramente immaginario.
     * @author emanu
     * @param text , stringa da dover controllare.
     * @return      il metodo ritorna un numero complesso. 
     */
    public ComplexNumber recognizeNumber(String text) {
        String replaceAll = text.replaceAll(" ", "");
        char operator1 = this.checkFirstCharacter(text);
        text = this.clearString(text);
        if(text.contains("j")){
            String image = text.replace("j","");
              if(image.equals("")){
                return new ComplexNumber(0, Double.parseDouble(operator1 + "1"));
            }
            
            return new ComplexNumber(0, Double.parseDouble(operator1 + image));
        }
        else {
            double real = Double.parseDouble(operator1 + text);
            return new ComplexNumber(real , 0);
        }
    }
    
        
    /**
     *Il metodo converte una stringa data in input in un numero complesso.
     * @author emanu
     * @param text , stringa da dover controllare.
     * @return      ritorna un numero complesso.
     */
      
    public ComplexNumber recognizeComplexNumber(String text){
        String replaceAll = text.replaceAll(" ", "");
        char operator1 = this.checkFirstCharacter(text);
        text = this.clearString(replaceAll);
        char operator2 = ' ';
        if(text.contains("+")) 
            operator2 = '+';
        if(text.contains("-")) 
            operator2 = '-';
        String [] scanner = text.split("\\+|\\-");
        if(scanner[0].contains("j")) {
            String image = scanner[0].replace("j","");
            if(image.equals(""))
                image="1";
            return new ComplexNumber(Double.parseDouble( operator2 + scanner[1]), Double.parseDouble(operator1 + image));
        }
        else {
            double real = Double.parseDouble(operator1 + scanner[0]);
            String image = scanner[1].replace("j","");
            if(image.equals(""))
                image="1";
            return new ComplexNumber(real , Double.parseDouble(operator2 + image));
        }
    }
 /**
     *Il metodo controlla se la stringa data in input è un numero complesso.
     * @author emanu
     * @param text , stringa da dover controllare.
     * @return      ritorna complex_number se la stringa è un numero complesso,
     *              ritorna continue_checking se la stringa passata non è un numero
     *              altrimenti invalid_insert.
     * 
     */
    public String checkComplexNumber(String text){
        if(text.contains("+") || text.contains("-")) {
            String replaceAll = text.replaceAll(" ", "");
            String [] scanner = replaceAll.split("\\+|\\-");
            if(scanner.length > 2) 
                return invalid_insert;
            if(this.checkPossiblePartReal(scanner[0])){
                try {
                    String element = scanner[1];
                } catch (ArrayIndexOutOfBoundsException e) {
                    return  invalid_insert;
                }
                return this.checkPossiblePartImaginary(scanner[1]) ? complex_number: invalid_insert;
            }
                
            if(this.checkPossiblePartImaginary(scanner[0])){
                 try {
                    String element = scanner[1];
                } catch (ArrayIndexOutOfBoundsException e) {
                    return  invalid_insert;
                }
                return this.checkPossiblePartReal(scanner[1]) ? complex_number: invalid_insert;

            }
                
               
            return invalid_insert;
        }
        return continue_checking;
    }
     /**
     *Il metodo ritorna la stringa in cui sono stati eliminati gli spazi bianchi
     * ed elimina anche un eventuale + o - presente all'inizio di essa.
     * @author emanu
     * @param text, stringa da dover modificare.
     * @return      stringa che è stata modificata
     * 
     */
    public String clearString(String text){
        text = text.replaceAll("\\n", "");
        if(text.startsWith("+") || text.startsWith("-")){
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
     *Il metodo controlla se la stringa data in input è un numero reale.
     * @author emanu
     * @param text , stringa da dover controllare.
     * @return      ritorna true se la stringa è un numero reale, false altrimenti.
     * 
     */
    public boolean checkPossiblePartReal(String text){
        try {
            double real = Double.parseDouble(text);
            return true;
        } catch(NumberFormatException ex){
            return false;
        }
    }
   
    /**
     *Il metodo controlla se la stringa data in input è un numero immaginario .
     * @author emanu
     * @param text , stringa da dover controllare.
     * @return      ritorna true se la stringa è un numero immaginario, false altrimenti.
     * 
     */
    public boolean checkPossiblePartImaginary(String text){
        if(text.contains("j")) {
            String image = text.replace("j","").replace(" ", "");
            if(image.equals("")){
                image="1";
                return true;
            }
            if(image.equals("-")){
                image="-1";
                return true;
            }
                

            try {
                double image_finale = Double.parseDouble(image);
                return true;
            } catch (NumberFormatException e) {
                return false;
            }
           
        }
        return false;
    }
    /**
     *Il metodo controlla se la stringa data in input è un solo numero reale o immaginario.
     * @author emanu
     * @param text , stringa da controllare.
     * @return      ritorna complex_number  se la stringa è un numero, continue_checking altrimenti.
     * 
     */
    public String checkPossibleOneNumber(String text){
        if(this.checkPossiblePartReal(text)) 
            return single_number;
        return this.checkPossiblePartImaginary(text) ? single_number : invalid_insert; 
    }
    
    
    public char checkFirstCharacter(String text){
        text = text.replaceAll("\\n", "");
        if(text.startsWith("+") || text.startsWith("-")) {
            StringBuilder sb = new StringBuilder(text);
            // Removing the first character
            // of a string
            return sb.charAt(0);
        }
    return ' ';
    }

        
    
    
}