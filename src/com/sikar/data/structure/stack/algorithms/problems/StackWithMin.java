package com.sikar.data.structure.stack.algorithms.problems;

import java.util.Stack;

public class StackWithMin extends Stack<Integer> {
	private static final long serialVersionUID = 1L;
	
	Stack<Integer> minStack = new Stack<Integer>();

	@Override
	public Integer push(Integer aValue){
		
		if(aValue <= min()){
			minStack.push(aValue);
		}
		return super.push(aValue);
	}

	public Integer min(){
		
		if(minStack.isEmpty()){
			//return the largest integer value
			return Integer.MAX_VALUE;
		}
		else{
			return minStack.peek();
		}
	}

	@Override
	public Integer pop(){
		
		int value = super.pop();
		
		if(value == min()){
			minStack.pop();
		}
		return value;
	}
	
	public static void main(String[] args) {

		StackWithMin stack = new StackWithMin();
		
		System.out.println("Pushed : "+stack.push(5));
		System.out.println("Min is : "+stack.min());
		System.out.println("Pushed : "+stack.push(6));
		System.out.println("Min is : "+stack.min());
		System.out.println("Pushed : "+stack.push(3));
		System.out.println("Min is : "+stack.min());
		System.out.println("Pushed : "+stack.push(7));
		System.out.println("Min is : "+stack.min());
		System.out.println("Popped : "+stack.pop());
		System.out.println("Min is : "+stack.min());
		System.out.println("Popped : "+stack.pop());
		System.out.println("Min is : "+stack.min());
		System.out.println("Popped : "+stack.pop());
		System.out.println("Min is : "+stack.min());
	}
}
