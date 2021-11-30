/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se_project;
import se_project.exceptions.InvalidNameException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Set;

/**
 *
 * @author emanu
 */
public class DecoratorParserOperation extends  ParserString{
    private final ParserString parserString;
    private final HashMap<String, LinkedList<String>> hashMap;
    private final String invalid_insert = "__INVALID__";
    private final LinkedList<String> linkedList;

    public DecoratorParserOperation(ParserString parserString) {
        this.parserString = parserString;
        hashMap = new HashMap<>();
        linkedList = new LinkedList<>();
        Collections.addAll(linkedList, "+" , "-", "+-", "sqrt", "*", ":", "dup", "swap", "over", "drop");
 
    }
    public DecoratorParserOperation(ParserString parserString , HashMap<String, LinkedList<String>> hashMap1) throws  InvalidNameException{
        this.parserString = parserString;
        hashMap1.keySet().stream().filter((s) -> (!this.checkName(s))).forEachOrdered((_item) -> {
            throw new InvalidNameException();
        });
        this.hashMap = new HashMap<>(hashMap1);
        linkedList = new LinkedList<>();
        Collections.addAll(linkedList, "+" , "-", "+-", "sqrt", "*", ":", "dup", "swap", "over", "drop");
    }
            
    
    public String clearStringOperation(String text) throws StringIndexOutOfBoundsException{
        text = text.replaceAll("\\n", "");
        if(text.length() < 2)
            throw  new StringIndexOutOfBoundsException();
        StringBuilder sb = new StringBuilder(text);
        // Removing the first character
        // of a string
        sb.delete(0, 2);
        // Converting StringBuilder into a string
        // and return the modified string
        return sb.toString();
 
    }
    public boolean checkName(String text){
        
        char[] chars = text.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(char c : chars){
            if(Character.isDigit(c)){
               return false;
         }
      }
       return true;
    }
    public String removeInitialSpaces(String text) throws StringIndexOutOfBoundsException{
        while(text.charAt(0) == ' '){
            StringBuilder sb = new StringBuilder(text);
            sb.delete(0, 1);
            text = sb.toString();

        }
        return text;
    }
    @Override
    public  String parserString(String textString) throws  ArrayIndexOutOfBoundsException{
        if(textString.startsWith(">>")){
            textString = this.clearStringOperation(textString);
            String[] string = textString.split("\\$");
            String possible_name = string[0];
            if(possible_name.length() <= 1 || linkedList.contains(possible_name))
                return invalid_insert;
            String possible_operations = string[1];
            if(!this.checkName(possible_name)) return invalid_insert;
            possible_operations = this.removeInitialSpaces(possible_operations);
            if(!hashMap.containsKey(string[0])){
                String [] operations = possible_operations.split("\\s+");
                for(String possibile_operation : operations){
                    if(!hashMap.containsKey(possibile_operation) && !linkedList.contains(possibile_operation)) 
                        throw  new InvalidNameException("operazione non definita " + possibile_operation);
                }
                
                LinkedList<String> final_operations = new LinkedList<>();
                final_operations.addAll(Arrays.asList(operations));
                hashMap.put(possible_name, final_operations);
                return possible_name;
            }
            throw new InvalidNameException("nome già utilizzato");
            
            

        }
     
     return parserString.parserString(textString);
    }
    public LinkedList<String> getOperations(String name){
      return hashMap.get(name);
    }
    public String getOperationString(String text){
        LinkedList<String> list = hashMap.get(text);
        if(list == null) return null;
        String final_string = " ";
        return list.stream().map((s) -> s + " ").reduce(final_string, String::concat);
        
        
    }
   public Set<String> getNames(){
       return hashMap.keySet();
   }
   
}
