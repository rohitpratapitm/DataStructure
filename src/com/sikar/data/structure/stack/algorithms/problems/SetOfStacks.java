package com.sikar.data.structure.stack.algorithms.problems;

import java.lang.reflect.Array;
import java.util.EmptyStackException;
import java.util.Stack;

public class SetOfStacks {

	private  int MAX_NO_OF_STACKS ;
	
	private int THRESHHOLD ;
	
	private Stack<Integer>[] stacks ;
	
	private int index = 0;
	
	
	@SuppressWarnings("unchecked")
	public SetOfStacks(final int aMaxNoOfStacks,final  int aThreshold){

		this.MAX_NO_OF_STACKS = aMaxNoOfStacks;
		this.THRESHHOLD = aThreshold;
		
		stacks = (Stack<Integer>[]) Array.newInstance(Stack.class, MAX_NO_OF_STACKS);
		
		stacks[index] = new Stack<Integer>();
	}
	
	public Integer push(Integer aValue){
		
		if(stacks[index].size() == THRESHHOLD && index < stacks.length){
			
			//Create a new Stack
			stacks[++index] = new Stack<Integer>();
		}
		
		return stacks[index].push(aValue);
	}
	
	public Integer pop(){
		
		if(stacks[index].isEmpty()){
			
			stacks[index--]= null;
		}
		
		return stacks[index].pop();
	}
	
	public Integer peek(){
		
		return stacks[index].peek();
	}
	
	public Integer popAt(int aIndex){
		
		if(aIndex > aIndex){
			throw new IndexOutOfBoundsException();
		}
		
		if(stacks[aIndex].isEmpty()){
			stacks[aIndex] = null;
			throw new EmptyStackException();
		}
		
		return stacks[aIndex].pop();
	}
	
	public void print(){
		
		for(int i=0;i<stacks.length;i++){
			
			System.out.println(stacks[i]);
		}
	}
	
	public static void main(String args[]){
		
		SetOfStacks setOfStacks = new SetOfStacks(50, 10);
		
		for(int i=0;i<50;i++){
			setOfStacks.push(i);
		}
		
		setOfStacks.print();
		
		for(int i=0;i<10;i++){
			System.out.println(setOfStacks.popAt(0));
		}
		
		
		setOfStacks.print();
	}
}
