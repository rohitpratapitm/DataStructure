package com.sikar.array.problems;

public class ReverseArrayByGroupSize {

/**
 * Given a array of integer and group size, reverse array by group size, example as follows: 
[1, 2, 3, 4, 5, 6], 1 -> [1, 2, 3, 4, 5, 6] 
[1, 2, 3, 4, 5, 6], 2 -> [2, 1, 4, 3, 6, 5] 
[1, 2, 3, 4, 5, 6], 3 -> [3, 2, 1, 6, 5, 4] 
[1, 2, 3, 4, 5, 6, 7, 8], 3 -> [3, 2, 1, 6, 5, 4, 8, 7] 
Design test cases for you API
 */

	public void reverseArrayByGroupSize(int[] a, int groupSize){
		
		if(groupSize < 2){
			return;
		}
		int end = groupSize-1;
		for(int i=0;i<a.length;){
			
			reverseArray(a, i, end);
			i = i+groupSize;
			end = end+groupSize;
		}
		if(a.length%groupSize != 0){
			
			int rem = a.length%groupSize;
			reverseArray(a, a.length-rem, a.length-1);
		}
	}
	
	public void reverseArray(int[] a,int start,int end){
		
		if(start >=0 && end < a.length){
			
			for(int i=start;i<=end;i++,end--){
				
				swap(a,i,end);
			}
		}
	}
	
	public void swap(int[] a, int indexOne,int indexTwo){
		
		int temp = a[indexOne];
		a[indexOne] = a[indexTwo];
		a[indexTwo] = temp;
	}
	
	public void print(int[] a){
		
		for(int i=0;i<a.length;i++){
			System.out.println(a[i]);
		}
	}
	public static void main(String args[]){
		
		ReverseArrayByGroupSize tool = new ReverseArrayByGroupSize();
		
		int a[] = {1, 2, 3, 4, 5, 6};
		
		tool.reverseArrayByGroupSize(a, 4);
		
		tool.print(a);
	}
}
