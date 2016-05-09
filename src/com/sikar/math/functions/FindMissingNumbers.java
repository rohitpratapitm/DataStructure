package com.sikar.math.functions;

import java.util.ArrayList;
import java.util.List;

public class FindMissingNumbers {

	public static List<Integer> findMissingNumbers(int[] a){
		
		if(a.length <=0 ){
			return null;
		}
		List<Integer> missing = new ArrayList<Integer>(2);
		
		if(a[0] != 1){
			missing.add(1);
		}
		
		if(missing.size() == 1){

			int sum = findSum(a) ;//sum of n-2 numbers
			
			int sumOfN = findSumOfN(a.length+2);//sum of n numbers
			
			missing.add(sumOfN-sum-missing.get(0));
		}
		
		if(missing.size() == 2){
			return missing;
		}
		
		byte[] attendance = new byte[a.length+2];
		
		for(int i=1;i<a.length;i++){
			
			if(a[i] != a[i-1]+1){
				
				attendance[a[i-1]+1] = 1;
			}
		}
		
		for(int i=0;i<attendance.length;i++){
			
			if(attendance[i] == 1){
				
				missing.add(i);
			}
		}
		return missing;
	}
	
	
	private static int findSumOfN(int n) {

		return n*(n+1)/2;
	}


	private static int findSum(int[] a) {
		
		int sum = 0;
		
		for(int i=0;i<a.length ;i++){
			
			sum += a[i];
		}
		return sum;
	}


	public static void main(String[] args) {
		
		int a[] = {1,2,3,5,6,7,9,10};
		
		System.out.println(findMissingNumbers(a));
		
		int b[] = {2,3,4,5,6,7,9,10};
		
		System.out.println(findMissingNumbers(b));
		
		int c[] = {2,3,4,5,6,7,8,9};
		
		System.out.println(findMissingNumbers(c));
	}

}
