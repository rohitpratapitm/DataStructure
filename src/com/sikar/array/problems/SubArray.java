package com.sikar.array.problems;

import java.util.HashMap;
import java.util.Map;

public class SubArray {

	public static void subArrayWith0Sum(int[] array){
		
		int sum = 0;
		
		Map<Integer,Integer> map = new HashMap<>();
		
		for(int i=0;i<array.length;i++){
			
			sum = sum + array[i];
			
			if(array[i] ==0 || sum==0 || map.get(sum) != null){
				System.out.println("True");
				return;
			}
			
			map.put(sum, i);
		}
		System.out.println("False");
	}
	
	public static void main(String args[]){
		
		int[] array = {4,2,-3,1,6};
		
		subArrayWith0Sum(array);
	}
}
