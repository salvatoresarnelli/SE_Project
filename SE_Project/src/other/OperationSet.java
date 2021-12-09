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

    public OperationSet(String nameOperation, String listOperation) {
        this.nameOperation = nameOperation;
        this.listOperation = listOperation;
    }

    public String getNameOperation() {
        return nameOperation;
    }

    public String getListOperation() {
        return listOperation;
    }
    
    
}
