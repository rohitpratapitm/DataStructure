package com.sikar.string.problems;

public class Practice {

	class FrequencyWithIndex{
		
		private int mFrequency;
		private final int mIndex;
		private char mCharacter;
			
		public FrequencyWithIndex(int aFrequency,int aIndex,char aCharacter){
			
			this.mFrequency = aFrequency;
			this.mIndex = aIndex;
			this.mCharacter = aCharacter;
		}
		public int getFrequency(){
			return this.mFrequency;
		}
		public int getIndex(){
			return this.mIndex;
		}
		public void incrementFrequency(){
			this.mFrequency++;
		}
		
		@Override
		public String toString(){
			return mCharacter+" at index "+mIndex+" occurred "+mFrequency;
		}
	}
		
	public Character findFirstNonRepeatedCharacter(String aString){
		
		if(aString == null || aString.isEmpty()){
			return null;
		}
		//create an array of 256 characters OR 26 if there are only alphabets
		FrequencyWithIndex[] array = new FrequencyWithIndex[26];

		char[] characterArray = aString.toLowerCase().trim().toCharArray();
		
		for(int index=0;index<characterArray.length;index++){
			
			char c = characterArray[index];
			
			if(c == ' '){
				continue;
			}
			int arrayIndex = c-'a';
			if(array[arrayIndex] == null){
				//Create an object
				FrequencyWithIndex frequencyWithIndex = new FrequencyWithIndex(1,index,c);
				//store it in array
				array[arrayIndex] = frequencyWithIndex;
			}
			else{
				//get the old object and increment the frequencyWithIndex
				FrequencyWithIndex frequencyWithIndex = array[arrayIndex];
				frequencyWithIndex.incrementFrequency();
			}
		}
		
		//Find the minimum index
		//say the minimum is the largest index
		int min = array.length;
		
		for(int i=0;i<array.length;i++){
			System.out.println(array[i]);
			if(array[i] != null && array[i].getFrequency() == 1 && min > array[i].getIndex()){
				min = array[i].getIndex();
			}
		}
		
		return aString.charAt(min);
	}
	
	public static void main(String args[]){
		
		Practice practice = new Practice();
		System.out.println(practice.findFirstNonRepeatedCharacter("Sales Force is the best compnay to work for"));
		
	}
}
