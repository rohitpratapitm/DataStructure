package com.sikar.data.structure.stack.algorithms.problems;

import java.util.Stack;

public class OrderedStack {

	/**
	 * Complexity is o(n2) N-SQUARE
	 * 
	 * Because there was a restriction to use only 1 extra stack
	 * @param aStack
	 * @return
	 */
	public static Stack<Integer> sortAscending(Stack<Integer> aStack){
		
		if(aStack != null && aStack.size() > 1){
			
			Stack<Integer> buffer = new Stack<>();
			
			while(!aStack.isEmpty()){
				
				int temp = aStack.pop();
				
				while(!buffer.isEmpty() && temp < buffer.peek()){
					
					aStack.push(buffer.pop());
				}
				buffer.push(temp);
			}
			return buffer;
		}
		return aStack;
	}
	
	public static void mergeSort(Stack<Integer> aStack){
		
		if(aStack == null || aStack.size() < 2){
			
			return ;
		}
			
		int mid = aStack.size()/2;
		
		//Create left stack
		Stack<Integer> left = new Stack<Integer>();
		Stack<Integer> right = new Stack<Integer>();
		
		//populate left stack
		for(int i=0;i<mid;i++){
			left.push(aStack.pop());
		}
		
		while(!aStack.isEmpty()){
			right.push(aStack.pop());
		}
		
		mergeSort(left);
		mergeSort(right);
		merge(left,right,aStack);
	}
	
	public static void merge(Stack<Integer> aLeft,Stack<Integer> aRight,Stack<Integer> aDestination){
		
		while(!aLeft.isEmpty() && !aRight.isEmpty()){
			
			if(aLeft.peek() < aRight.peek()){
				
				aDestination.push(aLeft.pop());
			}
			else {
				
				aDestination.push(aRight.pop());
			}
		}
		
		while(!aLeft.isEmpty()){
			
			aDestination.push(aLeft.pop());
		}
		
		while(!aRight.isEmpty()){
			
			aDestination.push(aRight.pop());
		}
		reverse(aDestination);
	}
	
	private static void reverse(Stack<Integer> aDestination) {

		if(aDestination.isEmpty()){
			return;
		}
		
		int temp = aDestination.pop();
		reverse(aDestination);
		insert(aDestination,temp);
	}

	private static void insert(Stack<Integer> aDestination, int temp) {

		if(aDestination.isEmpty()){
			aDestination.push(temp);
		}
		else{
			int tmp = aDestination.pop();
			insert(aDestination,tmp);
			aDestination.push(tmp);
		}
	}

	public static void main(String[] args) {

		Stack<Integer> source = new Stack<>();
		
		source.push(7);source.push(8);source.push(3);source.push(6);
		source.push(5);source.push(2);
		
		//System.out.println(sortAscending(source));
		
		mergeSort(source);
		
		System.out.println(source);
	}

}
