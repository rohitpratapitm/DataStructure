package com.sikar.string.problems;

public class MyString {

	/**
	 * 1.1 Implement an algorithm to determine if a string has all unique characters. What
	 * 
	 * This method is CASE-SENSITIVE.
	 * 
	 * Complexity : O(n) where n is the length of string
	 * @param aString
	 * @return
	 */
	public static boolean isUniqueChars(String str) {
		if (str.length() > 128) {
			return false;
		}
		int checker = 0;
		for (int i = 0; i < str.length(); i++) {
			int val = str.charAt(i) - 'a';
			if ((checker & (1 << val)) > 0) return false;
			checker |= (1 << val);
		}
		return true;
	}
	
	public static boolean areUniqueCharacters(String aString) {

		
		boolean areUnique = true;

		if(aString == null || aString.isEmpty()){
			
			return false;
		}
		// store character frequency in an array
		boolean[] characters = new boolean[26];
		
		for (int i = 0; i < aString.length(); i++) {

			//If the frequency is greater than 0 , that means the character is repeating.
			if (characters[i]) {
				
				return false;
				
			} else {//put 1
				
				characters[i] = true;
			}
		}
		//If you reaches here, that means all the characters are unique.
		return areUnique;
	}

	/**
	 * 1.2 Implement a function void reverse which reverses a null terminated string.
	 * 
	 * Complexity : O(n/2) where n is the length of string
	 * 
	 * @param aString
	 * @return reverse string , null otherwise
	 */
	public static String reverse(String aString) {

		// Validation
		if (aString != null && !aString.isEmpty()) {

			char[] characters = aString.toCharArray();

			for (int startIndex = 0, endIndex = characters.length - 1; startIndex < endIndex; startIndex++, endIndex--) {
				
				swapCharacters(characters, startIndex, endIndex);
			}
			return new String(characters);
		}
		return null;
	}
	
	/**
	 * 13 Given two strings, write a method to decide if one is a permutation of the other
	 * 
	 * This method is CASE-SENSITIVE.
	 * 
	 * Complexity : O(n) where n is the length of string
	 * 
	 * @param aStringOne
	 * @param aStringTwo
	 * @return true if they are permutation of each other, false otherwise
	 */
	public static boolean arePermutationOfEachOther(String aStringOne, String aStringTwo){
		
		//Valiation
		if(aStringOne == null || aStringTwo == null || aStringOne.isEmpty() || aStringTwo.isEmpty()|| aStringOne.length() != aStringTwo.length()){
			return false;
		}
		
		//Store the 1st string in integer array
		int[] characters = new int[256];
		
		for(int i=0;i<aStringOne.length() ;i++){
			
			char characterOne = aStringOne.charAt(i);
			
			char characterTwo = aStringTwo.charAt(i);
			
			characters[characterOne]++;//Increment the character frequency by 1
			
			characters[characterTwo]--;//Decrement the character frequency by 1 
		}
		
		//Iterate on array and check if it has any non-zero value.
		for(int i=0;i<characters.length;i++){
		
			if(characters[i] != 0){
				return false;
			}
		}
		return true;
	}
	/**
	 * 1.4 Write a method to replace all spaces in a string with'%20'. You may assume that
		the string has sufficient space at the end of the string to hold the additional
		characters, and that you are given the "true" length of the string. (Note: if implementing
		in Java, please use a character array so that you can perform this operation
		in place.)
		EXAMPLE
		Input: "Mr John Smith
		Output: "Mr%20Dohn%20Smith"
		
		Complexity : O(n) where n is the length of the string
	 * @param aString
	 * @param aReplace
	 * @param aReplaceWith
	 * @return
	 */
	public static String replaceAll(String aString,char aReplace,String aReplaceWith){
		
		if(aString == null || aString.isEmpty() || aReplaceWith == null || aReplaceWith.isEmpty() ){
		
			return null;
		}
		//find size of the resultant array --o(n)
		//OR 
		//Use stringbuilder..when you call toString() ---o(n)
		int occurrences = 0;
		for(int i=0;i<aString.length();i++){
			
			char character = aString.charAt(i);
			
			//if character found , insert the replacement
			if(character == aReplace){
				occurrences++;
			}
		}
		if(occurrences == 0){
			return aString;
		}
		int size = aString.length() + occurrences * (aReplaceWith.length() -1);
		
		char[] characters = new char[size];
		
		for(int i=0,index=0;i<aString.length();i++){
		
			char character = aString.charAt(i);
			
			//if character found , insert the replacement
			if(character == aReplace){
				characters[index++] = '%';
				characters[index++] = '2';
				characters[index++] = '0';
			}
			else{
				characters[index++] = character;
			}
		}
		
		return new String(characters);
	}
	/**1.5 Implement a method to perform basic string compression using the counts
		of repeated characters. For example, the string aabcccccaaa would become
		a2blc5a3. If the "compressed" string would not become smaller than the original
		string, your method should return the original string.
	 * 
	 * @param aString
	 * @return
	 */
	public static String compress(String aString){

		//Validate
		if(aString != null && !aString.isEmpty()){
			
			int[] characters = new int[256];
			
			int repeatedCount = 0;
			int uniqueCount = 0;
			
			//Store character frequency
			for(int i=0;i<aString.length();i++){
			
				char character = aString.charAt(i);
				
				characters[character]++;
				
				//If any character is repeating then the compression is possible since size would be less than original.
				if(characters[character] >1){
					repeatedCount++;
					uniqueCount--;
				}else{
					uniqueCount++;
				}
			}
			
			if(repeatedCount+uniqueCount  >= aString.length()){
				return aString;
			}
			else{
				StringBuilder compressed = new StringBuilder();
				
				//Iterate on characters array and print the occurrences			
				for(int i=0;i<aString.length();){
				
					//get the character
					char character = aString.charAt(i);
					
					//get the frequency
					int frequency = characters[character];
					
					compressed.append(character);
					
					compressed.append(frequency);
					
					
					i += frequency;
					
				}
				return compressed.toString();
			}
		}
		return null;
	}
	/**
	 * 1.6 Given an image represented by an NxN matrix, where each pixel in the image is
		4 bytes, write a method to rotate the image by 90 degrees. Can you do this in
		place?

	 * @param image
	 */
	public static void rotateImageby90(int[][] image){
		
		int n = image.length;
		
		for(int row=0;row<image.length/2;row++){
			
			int first = row;
			
			int last = n-row-1;
			
			for(int i = first;i<last;i++){
				
				int offset = i - first;
				
				int topLeft = image[first][i];
				
				int topRight = image[i][last];
				
				int bottomLeft = image[last-offset][first];
				
				int bottomRight = image[last][last-offset];
				
				//save top
				int top = image[first][i];
				
				//set left->top
				image[first][i] = image[last-offset][first];
				
				//set bottom -> left
				image[last-offset][first] = image[last][last-offset];
				
				//set right ->bottom
				image[last][last-offset] = image[i][last];
				
				//set top ->right
				image[i][last] = top;
			}
		}
		
	}
	
	/*
	 * Write an algorithm such that if an element in an MxN matrix is 0, its entire row and
		column are set to 0.
	 */
	private static void setZeros(int[][] matrix){
	
		boolean[] row = new boolean[matrix.length];
		boolean[] column = new boolean[matrix[0].length];
		
		for(int rowIndex=0;rowIndex<matrix.length;rowIndex++){
			
			for(int colIndex=0;colIndex<matrix[0].length;colIndex++){
				
				if(matrix[rowIndex][colIndex] == 0){
					
					row[rowIndex] = true;
					
					column[colIndex] = true;
				}
			}
		}
		
		for(int i=0;i<row.length;i++){
			
			for(int j=0;j<column.length;j++){
				
				if(row[i] || row[j] ){
					
					matrix[i][j] = 0;
				}
			}
		}
	}
	
	/**Assume you have a method isSubstring which checks if one word is a substring
	of another. Given two strings, si and s2, write code to check Ifs2 is a rotation of si
	using only onecalltoisSubstring (e.g., "waterbottLe" is a rotation of "erbottLewat").
	 */
	public boolean isRotation(String string1,String string2){
		
		int len = string1.length();
		
		if(len == string2.length() && len > 0){
			
			string1 = string1+string1;
			
			return string1.contains(string2);
		}
		return false;
	}
	private static void swapCharacters(char[] characters, int indexOne, int indexTwo){
		
		char temp = characters[indexOne];
		characters[indexOne] = characters[indexTwo];
		characters[indexTwo] = temp;
	}

	public static void main(String args[]){
		
//		System.out.println(areUniqueCharacters(null));
//		
//		System.out.println(areUniqueCharacters(""));
//		
//		System.out.println(areUniqueCharacters("a"));
//		
//		System.out.println(areUniqueCharacters("Rohit"));
//		
//		System.out.println(areUniqueCharacters("Teeth"));
//		
//		System.out.println(reverse(null));
//		
//		System.out.println(reverse(""));
//		
//		System.out.println(reverse("a"));
//		
//		System.out.println(reverse("123456"));
//		
//		System.out.println(reverse("Rohit"));
//		
//		System.out.println(reverse("Teeth"));
//		
//		//NEGATIVE
//		System.out.println(arePermutationOfEachOther(null,""));
//		
//		System.out.println(arePermutationOfEachOther(null,"Rohot"));
//		
//		System.out.println(arePermutationOfEachOther("Rohot",null));
//		
//		System.out.println(arePermutationOfEachOther("Rohot",""));
//		
//		System.out.println(arePermutationOfEachOther(null,null));
//		
//		System.out.println(arePermutationOfEachOther("",""));
//		
//		System.out.println(arePermutationOfEachOther("Rohot","Rohits"));
//		
//		//POSITIVE
//		
//		System.out.println("True : "+arePermutationOfEachOther("rohit","troih"));
//		
//		System.out.println("True : "+arePermutationOfEachOther("a","a"));
//		
//		System.out.println("True : "+arePermutationOfEachOther("aab","aba"));
//		
//		System.out.println("True : "+arePermutationOfEachOther("bbaaa","aaabb"));
//		
//		System.out.println("False : "+arePermutationOfEachOther("Rohot","Singh"));
//		
//		System.out.println("True : "+arePermutationOfEachOther("1234","4312"));
//		
//		System.out.println("True : "+arePermutationOfEachOther("*&^%","^&%*"));
//		
//		System.out.println("False: "+arePermutationOfEachOther("!@#$%^",")(*&^%"));
//		
//		//NEGATIVE
//		System.out.println(replaceAll(null,' ',"%20"));
//		
//		System.out.println(replaceAll("",' ',"%20"));
//		
//		System.out.println(replaceAll("Rohit",' ',null));
//		
//		System.out.println(replaceAll("Rohit",' ',""));
//		
//		//POSITIVE
//		
//		System.out.println("Rohit:"+replaceAll("Rohit",' ',"%20"));
//		
//		System.out.println("R%20ohit:"+replaceAll("R ohit",' ',"%20"));
//		
//		System.out.println("%20:"+replaceAll(" ",' ',"%20"));
//		
//		System.out.println("%20%20%20%20%20:"+replaceAll("     ",' ',"%20"));
//
//		System.out.println("Rohit%20:"+replaceAll("Rohit ",' ',"%20"));
//		
//		System.out.println("Ro%20h%20it:"+replaceAll("Ro h it",' ',"%20"));
//		
//		System.out.println("R%20o%20h%20i%20t:"+replaceAll("R o h i t",' ',"%20"));
//		
//		//NEGATIVE
//		System.out.println(compress(null));
//		
//		System.out.println(compress(""));
//		
//		System.out.println("a:"+compress("a"));
//		
//		System.out.println("abc:"+compress("abc"));
//		
//		System.out.println("a2b:"+compress("aab"));
//		
//		System.out.println("a3b:"+compress("aaab"));
//		
//		System.out.println("%2*4:"+compress("%%****"));
//		
//		System.out.println("a57:"+compress("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
//		
		int[][] image = {{11,12,13,14},{15,16,17,18},{19,20,21,22},{23,24,25,26}};
		
		rotateImageby90(image);
		
		System.out.println(image);
	}
}
