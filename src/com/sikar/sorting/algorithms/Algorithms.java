package com.sikar.sorting.algorithms;

public class Algorithms {

	private final int MAX_SIZE = 50;
	
	private int[] theArray = new int[MAX_SIZE];
	
	private int arraySize = 10;
	
	/*1. Worst among all
	 * 
	 * Complexity : 
	 * Worst Case : n * n = O(n2)
	 * Best Case  : n  = O(n) 
	 */
	public int[] bubbleSort(){
		
		//In each outer iteration , sorts the largest number to the end
		for(int i = arraySize-1; i > 0 ;i--){
			
			//In each inner iteration, swaps the larger number to next position.
			for(int j=0; j< i; j++){
				
				if(theArray[j] > theArray[j+1]){
					
					swapValues(j, j+1);
				}
			}
		}
		
		return theArray;
	}
	
	/*2. Better than Bubble sort
	 * 
	 * * Complexity : n(n-1)/2
	 * 
	 * Worst Case : n * n = O(n2)
	 * Best Case  : n  = O(n) 
	 */
	public int[] selectionSort(){
		
		//Search for the smallest number in the array
		for(int i = 1; i < arraySize ; i++){
			
			int minimum = i;
			
			for(int k=i;k<arraySize ;k++){
				
				//once find, saves it in the minimum spot
				if(theArray[minimum] > theArray[k]){
					minimum = k;
				}
			}
			//And then swap the minimum by putting the minimum to the start of the array.
			swapValues(i,minimum);
		}
		return theArray;
		
	}

	/*3. Better than Selection sort
	 * 
	 * * Complexity : n(n-1)/2
	 * 
	 * Worst Case : n * n = O(n2)
	 * Best Case  : n * n = O(n) 
	 */
	public int[] insertionSort(){
		
		for(int i=1 ; i < arraySize; i++){
			
			int j = i;
			
			int toInsert = theArray[i];
			
			while(j>0 && theArray[j-1] > toInsert){
				
				theArray[j] = theArray[j-1];
				j--;
			}
			
			theArray[j] = toInsert;
		}
		return theArray;
	}
	
	/*4. Better than Insertion sort
	 * 
	 * Divide & Conquerer 
	 * Maintains order
	 * 
	 * Time Complexity : nlog n
	 * Space Complexity: O(n)
	 * 
	 * Worst Case : n * log n = O(nlog n)
	 * Averg Case : n * log n = O(nlog n)
	 * Best Case  : n * log n = O(nlog n) 
	 */
	
	public void mergeSort(int[] array,int length){
		
		//base condition
		if(length < 2){
			return;
		}
		
		//divide the array into two until you get 1 element in each list
		int middleIndex = length/2;
		
		//Create left & right array
		int[] left = new int[middleIndex];
		
		int[] right = new int[length-middleIndex];
		
		//populate left and right array
		
		for(int i=0;i<middleIndex;i++){
			
			left[i] = array[i];
		}
		
		for(int i=middleIndex;i<length;i++){
			
			right[i-middleIndex] = array[i];
		}
		//divide the left half
		mergeSort(left,middleIndex);
		
		//divide the right half
		mergeSort(right,length-middleIndex);
		
		//merge
		merge(array,left,middleIndex,right,length-middleIndex);
	}
	
	private void merge(int[] array, int[] left, int leftCount, int[] right, int rightCount){
		
		int i=0,j=0,k=0;
		
		while(i<leftCount && j<rightCount){
			
			if(left[i]<right[j]){
				array[k] = left[i];
				i++;
				k++;
			}
			else{
				array[k] = right[j];
				j++;
				k++;
			}
		}
		
		//check for unattended elements in left array
		while(i<leftCount){
			array[k] = left[i];
			i++;
			k++;
		}
		while(j<rightCount){
			array[k] = right[j];
			j++;
			k++;
		}
		
	}
	
	/*5. Better than Merge sort for large number of n
	 * 
	 * Divide & Conquer
	 * In-place Sorting 
	 * Does NOT Maintains order
	 * 
	 * Time Complexity : nlog n
	 *
	 * Worst Case : n * n = O(n2)
	 * Averg Case : n * log n = O(nlog n)
	 * Best Case  : n * log n = O(nlog n)
	 * 
	 * Space Complexity: O(n)
	 * 
	 * Worst Case : n = O(n)
	 * Averg Case : log n = O(log n)
	 * Best Case  : log n = O(log n)
	 * 
	 */
	public void quickSort(int start,int end){
		
		if(start < end){//Base Condition
			//Partition
			int partitionIndex = partition(start,end);
			
			//left array
			quickSort(start,partitionIndex-1);
			
			//right array
			quickSort(partitionIndex+1,end);
		}
	}
	
	private int partition(int startIndex, int endIndex) {

		int pivot = theArray[endIndex];
		
		int partitionIndex = startIndex;
		
		for(int index=startIndex;index<endIndex;index++){
			
			if(theArray[index] <= pivot){
				
				swapValues(index,partitionIndex);
				partitionIndex++;
			}
		}
		//swap the partition index value
		swapValues(partitionIndex, endIndex);
		
		return partitionIndex;
	}

	public void generateRandomArray(){
		
		for(int i = 0; i < arraySize; i++){
			
			theArray[i] = (int)(Math.random()*10)+10;
			
		}
		
	}

	public void swapValues(int indexOne, int indexTwo){
		
		int temp = theArray[indexOne];
		theArray[indexOne] = theArray[indexTwo];
		theArray[indexTwo] = temp;
		
	}
	
	public void printArray(){
		
		System.out.println("");
		System.out.println("-------------------------------------------------------------");
		for(int i = 0; i < arraySize; i++){
			
			System.out.print("| " + theArray[i]);
		}
		System.out.println("|");
		System.out.println("-------------------------------------------------------------");
		
		for(int i = 0; i < arraySize; i++){
			
			System.out.print("  " + i+" ");
		}
		System.out.println("");
		
	}
	
	public static void main(String args[]){
		
		Algorithms algorithms = new Algorithms();
		algorithms.generateRandomArray();
		
		algorithms.printArray();
		
		//algorithms.bubbleSort();
		//algorithms.selectionSort();
		//algorithms.insertionSort();
		//algorithms.mergeSort(algorithms.theArray, algorithms.arraySize);
		algorithms.quickSort(0, algorithms.arraySize-1);
		
		algorithms.printArray();
	}
}
