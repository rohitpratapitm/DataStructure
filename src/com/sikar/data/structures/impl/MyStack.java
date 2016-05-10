package com.sikar.data.structures.impl;

import java.util.Arrays;
import java.util.EmptyStackException;

public class MyStack {
    
	private static final int MAX_SIZE = 500;
	
	private int[] array;
	
	private int capacity;
	
	private int size;
	
	/**
     * Creates an empty Stack with a default capacity of 50.
     */
    public MyStack() {
    	
    	capacity = 50;
    	array = new int[50];
    }
    
    public MyStack(int aCapacity){
    	
    	if(aCapacity <= 0 || aCapacity > MAX_SIZE){
    		throw new IllegalArgumentException("Illegal capacity value provided");
    	}
    	
    	capacity = aCapacity;
    	
    	array = new int[capacity];
    }

    /**
     * Pushes an item onto the top of this stack. This has exactly
     * the same effect as:
     * <blockquote><pre>
     * addElement(item)</pre></blockquote>
     *
     * @param   item   the item to be pushed onto this stack.
     * @return  the <code>item</code> argument.
     * @see     java.util.Vector#addElement
     */
    public int push(int item) {
    	
        if(size == capacity){
        	regrow();
        }

        array[size] = item;
        
        size++;
        
        return item;
    }

	private void regrow() {
		//regrow the array
		int newCapacity = capacity * 2;
		
		System.out.println("Current capacity is "+capacity);
		
		if(newCapacity > MAX_SIZE){
			//Can't regrow to this capacity
			//log.warn
			throw new OutOfMemoryError("Can't regrow array to new capacity of "+newCapacity);
		}
		
		capacity = newCapacity;
		
		System.out.println("Resized array with a new capacity of "+capacity);
		array = Arrays.copyOf(array,capacity);
	}

    /**
     * Removes the object at the top of this stack and returns that
     * object as the value of this function.
     *
     * @return  The object at the top of this stack (the last item
     *          of the <tt>Vector</tt> object).
     * @throws  EmptyStackException  if this stack is empty.
     */
    public int pop() {
       
    	int topOfStack = peek();
    	
    	--size;
    	
        return topOfStack;
    }

    /**
     * Looks at the object at the top of this stack without removing it
     * from the stack.
     *
     * @return  the object at the top of this stack (the last item
     *          of the <tt>Vector</tt> object).
     * @throws  EmptyStackException  if this stack is empty.
     */
    public int peek() {
     
    	if(size == 0){
    		throw new EmptyStackException();
    	}
    	
    	return array[size-1];
    }

    /**
     * Tests if this stack is empty.
     *
     * @return  <code>true</code> if and only if this stack contains
     *          no items; <code>false</code> otherwise.
     */
    public boolean empty() {
        return size == 0;
    }
    
    public String toString(){
    	
    	StringBuffer buffer = new StringBuffer();
    	buffer.append("[");
    	if(size > 0){
        	for(int i=0; i<size;i++){
        		
        		buffer.append(array[i]);
        		buffer.append(",");
        	}
        	
        	buffer.deleteCharAt(buffer.lastIndexOf(","));
    	}
    	buffer.append("]");
    	return buffer.toString();
    }
    
    public static void main(String args[]){
    	
    	MyStack stack = new MyStack(100);
    	
    	for(int i=0;i<501;i++){
    		stack.push(i+1);
    	}
    	
    	System.out.println(stack);
    }
}
