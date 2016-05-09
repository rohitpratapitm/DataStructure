package com.sikar.string.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class FirstNonRepeatingCharacterInString {

	
	//Find a first non-repeated character in a string
	//input : "Salesforce is the best company to work for"
	//output : l

	public static char findFirstNonRepeatedCharacter(String s) throws IllegalArgumentException{
		
		if(s == null || s.isEmpty()){
			throw new IllegalArgumentException("input is null");
		}
		
		final class CountIndex{
			int count;
			int index;
			
			public CountIndex (int count,int index){
					this.count = count;
					this.index = index;
			}
		}
		
		CountIndex[] countIndexArray = new CountIndex[256];
		
		for(int i=0;i<s.length();i++){
		
			char c = s.charAt(i);
			
			countIndexArray[c] = new CountIndex(0,0);
			countIndexArray[c].count++;
			
			//store the first occurence
			if(countIndexArray[c].count == 1){
				countIndexArray[c].index = i;
			}
		}
		
		int result = 256;
		//find the least index
		for(int i=0;i<countIndexArray.length;i++){
			if (countIndexArray[i] != null && countIndexArray[i].count == 1 && result > countIndexArray[i].index){
				result = countIndexArray[i].index;
			}	
		}
		return s.charAt(result);
	}
	
	public static char findFirstNonRepeatedCharacterUsingStringAPI(String s){
		
		int i = 0;
		for(char c: s.toCharArray()){
			
			if(s.indexOf(c, ++i) < 0){
				return c;
			}
		}
		return (Character)null;
	}
	/*
	 * * Using LinkedHashMap to find first non repeated character of String *
	 * Algorithm : * Step 1: get character array and loop through it to build a
	 * * hash table with char and their count. * Step 2: loop through
	 * LinkedHashMap to find an entry with * value 1, that's your first
	 * non-repeated character, * as LinkedHashMap maintains insertion order.
	 */

	public static char firstNonRepeatedCharacterInString(String input){
		
		//1. Loop over character array and put it in LinkedHashMap
		Map<Character,Integer> counts = new LinkedHashMap<>();
		
		for(char character: input.toCharArray()){
			
			counts.put(character, counts.containsKey(character)? counts.get(character)+1 : 1);
		}
		
		for(Entry<Character,Integer> entry : counts.entrySet()){
			
			if(entry.getValue() == 1){
				return entry.getKey();
			}
		}
		
		throw new RuntimeException("no value found");
	}
	
	/*
	 * * Finds first non repeated character in a String in just one pass. * It
	 * uses two storage to cut down one iteration, standard space vs time *
	 * trade-off.Since we store repeated and non-repeated character separately,
	 * * at the end of iteration, first element from List is our first non *
	 * repeated character from String.
	 */
	public static char firstNonRepeatedCharacterInOnePass(String input){
		
		Set<Character> repeated = new HashSet<>();
		List<Character> nonRepeated = new ArrayList<>();
		
		for(Character c: input.toCharArray()){
			
			if(repeated.contains(c)){
				continue;
			}
			
			if(nonRepeated.contains(c)){
				nonRepeated.remove((Character)c);
				repeated.add(c);
			}
			else{
				nonRepeated.add(c);
			}
		}
		
		if(nonRepeated.size() == 0){
			throw new RuntimeException("No letter found");
		}
		return nonRepeated.get(0);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String [] input = {"PART"," SMART"," TAP"," RATE"," TARE"," POT"," PAT"," RATED"," MARTS"," MARS"," TARP"," TOP"," TIM"," APT"};
		String [] output = new String[input.length];
		
		Map<String,List<String>> map = new LinkedHashMap<>(); 
		
		for(int i=0;i<input.length;i++){
			
			String anagramKey = anagramKey(input[i]);
			
			if(!map.containsKey(anagramKey)){
				
				map.put(anagramKey, new ArrayList<String>());
			}
			map.get(anagramKey).add(input[i]);
		}
		System.out.println(map.values());
		
		System.out.println(findFirstNonRepeatedCharacter("Salesforce is the best company to work"));
		
		System.out.println(findFirstNonRepeatedCharacterUsingStringAPI("salesforce is the best company to work"));
	}

	private static String anagramKey(String aWord){
		
		if(aWord == null || aWord.isEmpty()){
			return null;
		}
		aWord = aWord.toLowerCase();
		
		char[] array = aWord.toCharArray();
		
		Arrays.sort(array);
		
		return new String(array);
		
	}
	private static void print(String[] input) {
		// TODO Auto-generated method stub
		System.out.println();
		for(int i=0;i<input.length;i++){
			System.out.print(input[i]);
		}
	}

	public static boolean areAnagrams(String one, String two){
		
		if(one == null || two == null || one.length() != two.length()){
			return false;
		}
		one = one.replaceAll("[\\s]", "").toLowerCase();
		two = two.replaceAll("[\\s]", "").toLowerCase();
		
		int[] charFrequency = new int[256];
		
		for(int i=0;i<one.length();i++){
			
			charFrequency[one.charAt(i)]++;
			charFrequency[two.charAt(i)]--;
		}
		
		for(int i=0;i<one.length();i++){
			
			if(charFrequency[one.charAt(i)] != 0){
				return false;
			}
		}
		return true;
	}
}
