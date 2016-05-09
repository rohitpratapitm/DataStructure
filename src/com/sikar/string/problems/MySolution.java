package com.sikar.string.problems;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
//Other imports go here

//Do NOT change the class name
class MySolution {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
     
        int noOfTestCases = scanner.nextInt();
     
         for(int i=0;i<noOfTestCases;i++){
             scanner.nextLine();
            
            String alphabets = scanner.next();
                       
            scanner.nextLine();
            
            String message = scanner.next();
            
            Map<String,Character> mapper = mapAlphabets(alphabets);
            
            String decodedMessage = decodeMessage(mapper,message);
            
            System.out.println(decodedMessage);
        }
    }
    
    private static Map<String,Character> mapAlphabets(String alphabets){
        
        Map<String,Character> mapper = new HashMap<>();
        
        int count = 0;
        
        for(Character c : alphabets.toCharArray()){
            
            String key = "";
            if(count<10){
                
                key = "0"+ ++count;
            }else{
                key = key+ ++count;
            }
            
            mapper.put(key,c);
        }
        return mapper;
    }
    
    private static String decodeMessage(Map<String,Character> map,String message){
        
        StringBuilder decodedMessage = new StringBuilder();
        
        for(int i=0;i<message.length()-1;){
            
        	StringBuilder key = new StringBuilder();
        	
            key.append(message.charAt(i));
            key.append(message.charAt(i+1));
            
            decodedMessage.append(map.get(key.toString()));
            
            i = i +2;
        }
        
        return decodedMessage.toString();
    }
}
