package com.sikar.interview.salesforce.practice;

public class Interview {

	
	public static char firstNonRepeatedCharacterInString(String s) throws Exception{
		
		if(s != null && s.length()>0){
			s = s.toLowerCase();
			for(int index=0;index<s.length();index++){
				
				char c = s.charAt(index);
				
				if(s.indexOf(c, index+1) < 0){
					return c;
				}
			}
		}
		throw new Exception("Not found");
	}
	
	public static char firstNotRepeatedCharacterInStringWithoutStringAPI(String s){
		
		//CHECKS
		final class CharCount {
			
			int count;
			int index;
			
			CharCount(int aCount,int aIndex){
				count = aCount;
				index = aIndex;
			}
		}
		s = s.replaceAll("[\\s]", "").toLowerCase();
		CharCount[] array = new CharCount[26];
		
		for(int index=0;index<s.length();index++){
			
			char ch = s.charAt(index);
			
			int charIndex = ch-'a';
			
			//store the first occurence
			if(array[charIndex] == null){
				array[charIndex] = new CharCount(1,index);
			}
			else{
				array[charIndex].count++;
			}
		}
		
		//find the minimum index in the array
		int min = 26;
		
		for(int i=0;i<array.length;i++){
			
			if(array[i] != null && array[i].count == 1 && array[i].index < min){
				min = array[i].index;
			}
		}
		
		return s.charAt(min);
	}
	
	public static void main(String args[]){
		
		String s = "Salesforce is the best company to work for";
		
		try {
			System.out.println(firstNonRepeatedCharacterInString(s));
			System.out.println(firstNotRepeatedCharacterInStringWithoutStringAPI(s));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
