/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package other;

/**
 *
 * @author Salvatore
 */
public class VariableSet {
    private final String variable;
    private final String value;
    
    /** Metodo costruttore della classe VariableSet
    *   @author Salvatore Sarnelli
    *   @param String variable, String value
    *   @return VariableSet
    *   
    */

    public VariableSet(String variable, String value) {
        this.variable = variable;
        this.value = value;
    }
    
    /** Metodo che ritorna il nome della variabile
    *   @author Salvatore Sarnelli
    *   @param 
    *   @return String   
    */    

    public String getVariable() {
        return variable;
    }
    
    /** Metodo che ritorna il valore associato alla variabile
    *   @author Salvatore Sarnelli
    *   @param 
    *   @return String
    */
    
    public String getValue() {
        return value;
    }
    
}
