package com.sikar.data.structure.heap;

public class Heap {

	private final int MAX_SIZE = 20;
	private int[] heap ;
	private int heapSize;
	
	public Heap(){
		
		heap = new int[MAX_SIZE];
	}

	public Heap(int[] array){
		
		this();
		heap = array;
		heapSize = array.length;
	}
	
	public void push(int element){
		
		if(heapSize < MAX_SIZE){
			
			heap[heapSize] = element;
			//bubble UP the element to maintain the heap property
			bubbleUp();
			heapSize++;
		}
	}
	
	/**
	 * check the last element with its parent.
	 * Move it up if it is larger than parent.
	 */
	private void bubbleUp() {

		int childIndex = heapSize;//element is at the last
		
		int parentIndex = (childIndex-1)/2;
		
		while(childIndex > 0){
			
			//compare element with it's parent
			if(heap[childIndex] > heap[parentIndex]){
				
				swapValues(childIndex,parentIndex);
				
				childIndex = parentIndex;
				parentIndex = (childIndex-1)/2;
			}else{
				break;
			}
		}
		
	}

	public int pop(){
		
		if(heapSize == 0)
			throw new RuntimeException("No Values to delete");
		
		if(heapSize == 1){
			return heap[0];
		}
		
		int root = heap[0];
		//Replace root with last element
		heap[0] = heap[heapSize-1];
		
		//now bubble down to maintain the heap
		heapify();
		
		heapSize--;
		
		return root;
	}
	private void heapify() {

		int parentIndex = 0;
		int leftChildIndex = 2*parentIndex + 1;
		int rightChildIndex = 2*parentIndex + 2;
		
		while(leftChildIndex < heapSize){
			
			int maxIndex = leftChildIndex;
			
			if(rightChildIndex < heapSize){
				
				//compare left child & right child to find max
				if(heap[rightChildIndex] > heap[maxIndex]){
					
					maxIndex = rightChildIndex;
				}
			}
			//Compare max with Parent
			if(heap[maxIndex] > heap[parentIndex]){
				
				//Swap parent with max
				swapValues(maxIndex,parentIndex);
				
				parentIndex = leftChildIndex;
				leftChildIndex = 2*parentIndex +1;
			}
			else{
				break;
			}
		}
	}

	private void swapValues(int childIndex, int parentIndex) {

		int temp = heap[childIndex];
		heap[childIndex] = heap[parentIndex];
		heap[parentIndex] = temp;
	}

	public void heapSort(){
		
		int originalSize = heapSize;
		System.out.println();
		for(int i=0;i<originalSize;i++){
			
			int first = pop();
			heap[originalSize-i-1] = first;
		}
		heapSize = originalSize;
	}
	public void print(){
		
		System.out.println();
		for(int i=0;i<heapSize;i++){
			
			System.out.print("|"+heap[i]);
		}
	}
	public static void main(String[] args) {

		Heap heap = new Heap();
		
		heap.push(10);heap.push(2);heap.push(15);heap.push(7);heap.push(11);
		heap.push(5);heap.push(18);heap.push(10);heap.push(12);
		
		heap.print();
		
		heap.heapSort();
		
		heap.print();
		
		heap.pop();
		
		heap.heapSort();
		
		heap.print();
		
	}

}
