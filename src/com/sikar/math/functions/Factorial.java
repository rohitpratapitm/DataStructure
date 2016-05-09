package com.sikar.math.functions;

import java.util.Scanner;

public class Factorial {
    
    private static final int MAX_SIZE = 10000;
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
     
        int noOfTestCases = scanner.nextInt();
     
         for(int i=0;i<noOfTestCases;i++){
             scanner.nextLine();
            
            int n = scanner.nextInt();
            
            numOfZeroes(n);
        }
    }
    
    private static void numOfZeroes(int n){
        
       int size = 1;
    	
		int[] result = new int[MAX_SIZE];
		
		result[0] = 1;
		for(int x = 2; x <= n; x++){
			
			size = multiply(x,result,size);
		}
		
        int count = 0;
		for(int i=0;i<size;i++){
			
            if(result[i] == 0){
                count ++ ;
            }
            else{
                break;
            }
		}
        System.out.println(count);
    }
    
   private static int multiply(int x, int[] result, int size) {

    	int carry = 0;
		
		for(int i=0;i<size;i++){
			
			int product = result[i] * x + carry;
			result[i] = product % 10;//Store last digit of product in result
			carry = product /10;//Put rest in carry
		}
		try{
			while(carry>0){
				
				result[size] = carry % 10;//put last digit of carry in result
				carry = carry/10;
				size++;
				
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		return size;
	}
}
