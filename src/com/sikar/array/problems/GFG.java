package com.sikar.array.problems;

import java.util.Scanner;

public class GFG
 {
	public static void main (String[] args)
	 {
	 //code
       // Input the number of test cases you want to run
       Scanner sc = new Scanner(System.in);
       int t = sc.nextInt();

       // One by one run for all input test cases
       while (t > 0)
       {
          
       	int n = sc.nextInt();
       	
       	printNaturalNumbers(n);
       	System.out.println();
           t--;
       }
	 }

	private static void printNaturalNumbers(int n) {
		
		if(n==0){
			return;
		}
		printNaturalNumbers(n-1);
		System.out.print(n);
	}
}