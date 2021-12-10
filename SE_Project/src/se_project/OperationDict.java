/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se_project;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Set;
import se_project.commands.Command;
import se_project.commands.OperationCommand;
import se_project.commands.userDefinedOperations.ExecuteUserDefinedOperationCommand;
import se_project.commands.variablesCommands.VariableCommand;

/**
 *
 * @author emanu
 */
public class OperationDict {
     private static OperationDict instance = null;
    private HashMap<String, OperationCommand> hashMap;

    // Costruttore invisibile
    private OperationDict() {
            hashMap = new HashMap<>();
} 
 
    public static OperationDict getInstance() {
        // Crea l'oggetto solo se NON esiste:
        if (instance == null) {
            instance = new OperationDict();
        }
        return instance;
    }
   

    public HashMap<String, OperationCommand> getHashMap() {
        return hashMap;
    }
 /**
     **Il metodo restituisce i nomi di tutte le operazioni definite
     * dall'utente.
     *
     * @return Set<String> contenente tutti i nomi delle operazioni.
     *
     */
  public Set<String> getNames() {
        return this.getHashMap().keySet();
    }

    public void setHashMap(HashMap<String, OperationCommand> hashMap) {
        this.hashMap = hashMap;
    }
       /**
     * Il metodo prende in ingresso il nome di un operazione già definita
     * dall'utente e restituisce tutte le operazioni associate al nome.
     *
     * @param name, Nome dell'operazione.
     * @return ExecuteUserDefinedOperationCommand le operazioni associate al
     * nome, nel caso in cui esista, altrimenti return null.
     *
     */
    public ExecuteUserDefinedOperationCommand getOperations(String name) {
        LinkedList<OperationCommand> commandList;
        LinkedList<OperationCommand> ret = new LinkedList<>();

        if (this.getHashMap().get(name) instanceof ExecuteUserDefinedOperationCommand) {
            commandList = ((ExecuteUserDefinedOperationCommand) this.getHashMap().get(name)).getCommandList();
            for (OperationCommand command : commandList) {
                ExecuteUserDefinedOperationCommand tmp;
                if (command instanceof ExecuteUserDefinedOperationCommand) {
                    tmp = getOperations(((ExecuteUserDefinedOperationCommand) command).getName());
                    ret.add(tmp);
                } else {
                    ret.add(command);
                }
            }
            return new ExecuteUserDefinedOperationCommand(name, ret);

        }
        return null;
    }
      /**
     **Il metodo prende in ingresso il nome di un operazione già definita
     * dall'utente e restituisce una stringa in cui sono presenti tutte le
     * operazioni associate intervallate da uno spazio.
     *
     * @param text, Nome dell'operazione
     * @return string stringa contenente tutte operazioni intervallate da uno
     * spazio.
     *
     */
    public String getOperationString(String text) {

        String s = "";
        if (this.getHashMap().containsKey(text)) {
            //s += text + " :";
            LinkedList<OperationCommand> supportList = this.getOperations(text).getCommandList();
            for (OperationCommand command : supportList) {
                if (command instanceof ExecuteUserDefinedOperationCommand) {
                    s += " " + ((ExecuteUserDefinedOperationCommand) command).getName();
                }
                if (command instanceof VariableCommand) {
                    s += " " + ((VariableCommand) command).toString();
                } else {
                    s += " " + command.toString();
                }
            }
            s += "\n";
        }
        return s;
    }
    
       /**
     **Il metodo prende in ingresso il nome di un operazione già definita
     * dall'utente e la rimuove.Nel caso in cui non è presente return false
     *
     * @param name, Nome dell'operazione
     * @return boolean il metodo ritorna true se l'elemento era presente ed è
     * stato cancellato, false altrimenti.
     *
     */
    public boolean removeOperation(String name) {
        Command remove = this.hashMap.remove(name);
        return (remove != null);
    }
    
}
