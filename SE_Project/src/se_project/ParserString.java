/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se_project;



/**
 *
 * @author emanu
 */
public class ParserString {
    private final String operation  = "__OPERATION__";
    private final String complex_number = "__NUMBER__";
    private final String invalid_insert = "__INVALID__";
    private final String continue_checking = "__CHECKING__";
    
/**
 *Il metodo ritorna la stringa in cui sono stati eliminati gli spazi bianchi
 * ed elimina anche un eventuale + o - presente all'inizio di essa.
 * @author emanu
 * @param text , stringa da dover modificare.
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
 *Il metodo riconosce se nella stringa è presente un operazione tra:
 * "addiction", "substraction", "multiplication", "division",
 * "square root", "invert sign"
 * 
 * @author emanu
 * @param text la stringa da dover controllare
 * @return      IL metodo torna la costante operation se i confronti con almeno una stringa citata prima ha successo, invalid_operation altrimenti.
 */
    public String checkOperation(String text){
        String possible_operation = text.toLowerCase();
        if(possible_operation.equals("addition") || possible_operation.equals("substraction") || possible_operation.equals("multiplication") || possible_operation.equals("division")|| possible_operation.equals("square root")|| possible_operation.equals("invert sign"))return operation;
        return invalid_insert;
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
        }catch(NumberFormatException ex){
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
        try{
            if(text.contains("j")){
                String [] split = text.split("j");
                if(split.length ==1){
                    double image = Double.parseDouble(split[0]);
                    return true;
                }
        }
        }catch(NumberFormatException ex){
        }
        try {
            if(text.contains("j")){
                String [] split = text.split("j");
                double image = Double.parseDouble(split[1]);
                return true;
             }
        return false;
        }
        catch(NumberFormatException e) { 
            return false;
        }
    }
/**
 *Il metodo controlla se la stringa data in input è un solo numero reale o immaginario.
 * @author emanu
 * @param text , stringa da controllare.
 * @return      ritorna complex_number  se la stringa è un numero, continue_checking altrimenti.
 * 
 */
    public String checkPossibleOneNumber(String text){
        if(this.checkPossiblePartReal(text)) return complex_number;
        return this.checkPossiblePartImaginary(text) ? complex_number : continue_checking;
        
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
        if(text.contains("+") || text.contains("-")){
            String replaceAll = text.replaceAll(" ", "");
            String [] scanner = replaceAll.split("\\+|\\-");
            if(scanner.length > 2) return invalid_insert;
            if(this.checkPossiblePartReal(scanner[0]))
                return this.checkPossiblePartImaginary(scanner[1]) ? complex_number: invalid_insert;
            if(this.checkPossiblePartImaginary(scanner[0]))
                 return this.checkPossiblePartReal(scanner[1]) ? complex_number: invalid_insert;
            return invalid_insert;
                 }
        return continue_checking;
    }
/**
 *Il metodo controlla se la stringa data in input è un numero complesso, un numero reale, un numero puramente immaginario, un'operazione..
 * @author emanu
 * @param text , stringa da dover controllare.
 * @return      ritorna complex_number se la stringa è un numero complesso,un
 *              numero reale o un numero puramente immaginario; ritorna operation
 *              se la stringa text contiene un'operazione, invalid_insert altrimenti.
 * 
 */
    public String parserString(String text){
        if(text.length() == 0) return invalid_insert;
        text = clearString(text);
        if(text.startsWith("+") || text.startsWith("-")) return invalid_insert;
        String return_value = checkComplexNumber(text);
        if (!(return_value.equals(continue_checking))) return return_value;
        return_value = checkPossibleOneNumber(text);
        return return_value.equals(continue_checking) ?  checkOperation(text): return_value;
 }
    
    
    
    

}

