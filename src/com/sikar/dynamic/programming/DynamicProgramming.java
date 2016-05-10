package com.sikar.dynamic.programming;

public class DynamicProgramming {

	
	public static int noOfDistinctSteps(int number){
		
		if(number == 1){
			return 1;
		}
		
		if(number == 2){
			
			return 2;
		}
		
		return noOfDistinctSteps(number-1)+noOfDistinctSteps(number-2);
	}
	
	public static void main(String args[]){
		
		//System.out.println(noOfDistinctSteps(5));
		
		int a[] = {9,9,9,9,9,9,9,7};
		
		System.out.println(find_lighter(a,0,a.length-1));
	}
	

public static int find_lighter(int a[],int start, int end){

	if(start == end)
		return start;
   //divide this array into three.
   int length = end-start+1;
   
   int remainder = length%3;
   int sizeOfRemainder = 0;
   if(remainder == 0){
	   
   }
   else{
	   sizeOfRemainder = remainder;
   }
   
   int parts = (end+1-start)/3;
   
   int firstStart = start;
   int firstEnd = firstStart + parts-1;

   int secondStart = firstEnd +1;
   int secondEnd   = secondStart +parts -1;

   int thirdStart = secondEnd+1;
   int thirdEnd =  a.length-1;
   
   //calculate sum
   int sum1 = sum(a,firstStart,firstEnd);
   int sum2 = sum(a,secondStart,secondEnd);
   int sum3 = sum(a,thirdStart,thirdEnd);
   
   if(sum1 == sum2){
		//sum3 has the lighter
		return find_lighter(a,thirdStart,thirdEnd);
   }
   else if(sum1 > sum2){
		//sum2 has the lighter
		return find_lighter(a,secondStart,secondEnd);
   }else{
		//sum1 has the lighter
		return find_lighter(a,firstStart,firstEnd);
   }
}
   public static int sum(int a[],int start, int end){
		
		int sum = 0;
		for(int i=start;i<=end;i++){
			sum = sum + a[i];
		}
		return sum;
	}
}
