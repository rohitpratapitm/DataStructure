package com.sikar.data.structures.impl;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.concurrent.locks.ReentrantLock;

public class MyQueue implements Queue<Integer>{
	
	private static final int MAX_CAPACITY = 500;
	
	private int[] array ;
	
	private int capacity;
	
	private int size;
	
	private int top, rear;

	
	public MyQueue(){
		
		capacity = 50;
		
		array = new int[capacity];
	}

	public MyQueue(int aCapacity){
		
		if(aCapacity <= 0 || aCapacity > MAX_CAPACITY){
			
			throw new IllegalArgumentException("Capacity value should be in range");
		}
		
		capacity = aCapacity;
		
		array = new int[capacity];
	}
	
	
	@Override
	public int size() {

		return size;
	}

	@Override
	public boolean isEmpty() {

		return size == 0;
	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterator<Integer> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends Integer> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}
	
	private void grow() {
		//regrow the array
		int newCapacity = capacity * 2;
		
		System.out.println("Current capacity is "+capacity);
		
		if(newCapacity > MAX_CAPACITY){
			//Can't regrow to this capacity
			//log.warn
			throw new OutOfMemoryError("Can't regrow array to new capacity of "+newCapacity);
		}
		
		capacity = newCapacity;
		
		System.out.println("Resized array with a new capacity of "+capacity);
		array = Arrays.copyOf(array,capacity);
	}
	
	@Override
	public boolean add(Integer e) {

		if(offer(e)){
			return true;
		}
		else{
			throw new IllegalStateException("Queue is full");
		}
	}

	@Override
	public boolean offer(Integer e) {

		final ReentrantLock lock = new ReentrantLock();
		
		lock.lock();
		
		try{
			if(size == capacity){
				return false;
			}
			else{
				enqueue(e);
				return true;
			}
		}finally{
			lock.unlock();
		}
	}

	private void enqueue(Integer e) {

		array[size] = e;
		size++;
	}

	@Override
	public Integer remove() {
		
		if(size == 0){
			throw new NoSuchElementException("Queue is empty"); 
		}
		else{
			return poll();
		}
	}

	@Override
	public Integer poll() {

		if(size > 0){
			return array[0];
			
		}
		return null;
	}

	@Override
	public Integer element() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer peek() {
		// TODO Auto-generated method stub
		return null;
	} 

}
