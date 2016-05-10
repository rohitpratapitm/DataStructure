package com.sikar.array.problems;

public class ValueFinder {

	/*Possible values
	 * {10,11/9,12/8,13/7,14/6,15/5,16/4,17/3,18/2}
	 */
	
	public static boolean exists(int array[],int number){
		
		boolean exists = false;
		
		if(array.length > 0){
			
			int difference = Math.abs(number - array[0]);
			
			if(difference < array.length && array[difference] == number){
				exists = true;
			}
		}
		return exists; 
	}
	
	public static void main(String[] args) {
		
		//Say a[i] = a[i+1] + 1;
		int array[] = {10,11,12,13,14,15,16,17,18};
		
		System.out.println(ValueFinder.exists(array, 15));
		
		//Negative
		System.out.println(ValueFinder.exists(array, 1));
		//Say a[i] = a[i-1] - 1;
		int[] array2 = {10,9,8,7,6,5,4,3,2};
		
		System.out.println(ValueFinder.exists(array2, 2));
		
		//Negative
		System.out.println(ValueFinder.exists(array2, 15));
		
		//Say a[i] = a[i-1] +1 1;
		int[] array3 = {10,11,10,7,6,5,4,3,2};
		
		System.out.println(ValueFinder.exists(array3, 2));
		
	}

}
