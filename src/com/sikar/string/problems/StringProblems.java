package com.sikar.string.problems;

public class StringProblems {

	public String subsequence(String s1,String s2){
		
		StringBuilder result = new StringBuilder();
		
		if(s1 != null && s1.length() > 0 && s2 != null && s2.length()>0){
			
			//Store s1 in a character array
			
			//Convet to lower case
			s1 = s1.toLowerCase();
			s2 = s2.toLowerCase();
			
			
			int[] s1Array = new int[26];
			
			//Store the character frequency 
			for(int index=0;index < s1.length(); index++){
				
				char c = s1.charAt(index);
				
				s1Array[c-'a']++;
				
			}
			
			//Store the result and subtract 1 when ever there is a match in second string
			for(int index=0;index< s2.length();index++){
				
				char c = s2.charAt(index);
				
				if(s1Array[c-'a'] > 0){
					result.append(c);
					s1Array[c-'a']--;
				}
				
			}
		}
		System.out.println(result.toString());
		return result.toString();
	}
	public String removeDuplicates(String s){
		
		String result = "";
		s = s.toLowerCase();
		int[] countArray = new int[26];
		
		for(int i=0;i<s.length();i++){
			
			char c = s.charAt(i);
			
			countArray[c - 'a']++;
			
		}
		
		for(int i=0;i<s.length();i++){
		
			char c = s.charAt(i);
			if(countArray[c-'a'] != 0){
				
				result += c;
				countArray[c-'a'] = 0;
			}
		}
		System.out.println(result);
		return result;
	}
	
	public static void main(String args[]){
		
		StringProblems problems = new StringProblems();
		
		problems.removeDuplicates("GeeksForGeeks");
		
		problems.subsequence("ABCDGH", "AEDFHR");
		
		problems.subsequence("AGGTAB", "GXTXAYB");
	}
}
