/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package other;

/**
 *
 * @author emanu
 */
 
public class OperationSet {
    private final String nameOperation;
    private final String listOperation;
    
/** Metodo costruttore della classe OperationSet
    *   @author Salvatore Sarnelli
    *   @param  nameOperation, String listOperation
    *   
    *   
    */
    public OperationSet(String nameOperation, String listOperation) {
        this.nameOperation = nameOperation;
        this.listOperation = listOperation;
    }
/** Metodo che ritorna il nome dell'operazione
    *   @author Emanuel Senatore
    *   @param 
    *   @return String   
    */    
    public String getNameOperation() {
        return nameOperation;
    }
/** Metodo che ritorna la lista  delle operazioni
    *   @author Emanuel Senatore
    *   @param 
    *   @return String   
    */   
    public String getListOperation() {
        return listOperation;
    }
    
    
}
