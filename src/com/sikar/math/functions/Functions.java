package com.sikar.math.functions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Functions {

	Map<Integer,Long> memory = new HashMap<>();
	
	public int factorial(int number){
		
		if(number == 1){
			return 1;
		}
		
		return number * factorial(number-1);
	}
	
	//sum of first n natural numbers
	public int triangularNumber(int number){
		
		if(number == 0)
			return 0;
		
		return number + triangularNumber(number-1);
	}
	
	/*A list of numbers where the next number is sum of previous two numbers
	 * 1 1 2 3 5 8 13 21 ....
	 */
	public long fibonacci(int number){

		if(number < 2){
			return number;
		}
		else if (memory.containsKey(number)){
			
			return memory.get(number);
		}
		else{
			long fibonacciValue = fibonacci(number-1) + fibonacci(number-2) ;
			
			memory.put(number, fibonacciValue);
			
			return fibonacciValue;
		} 	
	}
	
	public void printFibonacci(){
		
		System.out.print(1+" ");
		
		List<Long> keys = new ArrayList<>(memory.values());

		for(int i=keys.size()-1;i>=0;i--){

			System.out.print(keys.get(i));
			System.out.print(" ");
		}
		
	}
	
	public void printFibonacciReverse(){
		
		List<Long> keys = new ArrayList<>(memory.values());

		for(int i=keys.size()-1;i>=0;i--){

			System.out.print(keys.get(i));
			System.out.print(" ");
		}
		System.out.print(1+" ");
	}
	
	public static double power(int base, int power){
		
		double result = 1;
		
		for(int i=0;i<power/2;i++){
			
			result = result * base;
			
		}
		
		return result * result ;
	}
	
	public static boolean isPrime(int number){
		
		if(number < 2){
			return false;
		}
		
		Double squareRoot = Math.sqrt(number);
		
		for(int i=2;i<=squareRoot.intValue();i++){
			
			if(number % i == 0){
				return false;
			}
		}
		return true;
		
	}
	public static void main(String args[]){
		
		Functions tools = new Functions();
		
		int number = 10;
				
		//System.out.println("Factorial of "+number+" is : "+ tools.factorial(number));
		
		//System.out.println("Triangular number of "+number+" is : "+ tools.triangularNumber(number));
		
		tools.fibonacci(number);
		
		tools.printFibonacci();
		System.out.println();
		tools.printFibonacciReverse();
		
		System.out.println(power(2,4));
		
		System.out.println(isPrime(19));
	}
}
