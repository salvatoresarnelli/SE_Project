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
    private final String complex_number = "__COMPLEX__NUMBER__";
    private final String single_number = "__SINGLENUMBER__";
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
        text = text.replaceAll("\\n", "");
        if(text.equals("+") || text.equals("-") || text.equals("*") || text.equals(":")||text.equals("+-") || text.equals("sqrt")) return operation;
        String possible_operation = text.toLowerCase();
        if(possible_operation.equals("addition") || possible_operation.equals("substraction") || possible_operation.equals("multiplication") || possible_operation.equals("division")|| possible_operation.equals("square root")|| possible_operation.equals("invert sign"))return operation;
        return continue_checking;
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
        if(text.contains("j")){
            String image = text.replace("j","");
            try {
                 double image_finale = Double.parseDouble(image);
                 return true;
            } catch (NumberFormatException e) {
                return false;
            }
           
        }
        return false;
        /*
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
        */
    }
/**
 *Il metodo controlla se la stringa data in input è un solo numero reale o immaginario.
 * @author emanu
 * @param text , stringa da controllare.
 * @return      ritorna complex_number  se la stringa è un numero, continue_checking altrimenti.
 * 
 */
    public String checkPossibleOneNumber(String text){
        if(this.checkPossiblePartReal(text)) return single_number;
        return this.checkPossiblePartImaginary(text) ? single_number : invalid_insert;
        
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
            if(scanner.length >= 1) return invalid_insert;
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
        String return_value = this.checkOperation(text);
        if(return_value.equals(operation))return return_value;
        text = clearString(text);
        if(text.startsWith("+") || text.startsWith("-")) return invalid_insert;
        return_value = checkComplexNumber(text);
        if (!(return_value.equals(continue_checking))) return return_value;
        return checkPossibleOneNumber(text);
        
 }
/**
 *Il metodo controlla se la stringa data in input presenta un operatore + o un operatore - .
 * @author emanu
 * @param text , stringa da dover controllare.
 * @return     ritorna l'operatore se presente, altrimenti uno carattere spazio.
 * 
 */
    public char checkFirstCharacter(String text){
        text = text.replaceAll("\\n", "");
    if(text.startsWith("+") || text.startsWith("-")){
        StringBuilder sb = new StringBuilder(text);
        // Removing the first character
        // of a string
        return sb.charAt(0);

      }
    return ' ';
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
        if(text.contains("+")) operator2 = '+';
        if(text.contains("-")) operator2 = '-';
        String [] scanner = text.split("\\+|\\-");
        if(scanner[0].contains("j")){
            String image = scanner[0].replace("j","");
            return new ComplexNumber(Double.parseDouble( operator2 + scanner[1]), Double.parseDouble(operator1 + image));
        }
        else {
            double real = Double.parseDouble(operator1 + scanner[0]);
            String image = scanner[1].replace("j","");
            return new ComplexNumber(real , Double.parseDouble(operator2 + image));
            
            
        }
    }
   
/**
 *Il metodo converte una stringa data in input in un numero reale o in numero puramente immaginario.
 * @author emanu
 * @param text , stringa da dover controllare.
 * @return      il metodo ritorna un numero complesso. 
 */
    public ComplexNumber recognizeNumber(String text){
        String replaceAll = text.replaceAll(" ", "");
        char operator1 = this.checkFirstCharacter(text);
        text = this.clearString(text);
        if(text.contains("j")){
            String image = text.replace("j","");
            return new ComplexNumber(0, Double.parseDouble(operator1 + image));
        }
        else {
            double real = Double.parseDouble(operator1 + text);
            return new ComplexNumber(real , 0);
        
    }

    }
}

