package com.sikar.sorting.algorithms.problems;

public class TopKElementsOnAnArray {
	
	private int[] array;
	
	public TopKElementsOnAnArray(int[] array){
		
		this.array = array;
	}

	/**
	 * Finds top k elements in array
	 * 
	 * 
	 * @param array
	 * @param k number of elements
	 */
	public void printTopKElements(int k){
				
		quickSort(array, 0, array.length-1,k);
		
		for(int i=0;i<k;i++){
			
			System.out.print(array[array.length-i-1]+" ");
		}
		
	}
	
	private void quickSort(int[] array, int startIndex, int endIndex,int k) {
		
		if(startIndex < endIndex){

			int pIndex = partition(array,startIndex,endIndex);
			
			if(pIndex == k){
				
				// the last k elements on the right of k are top k elements
				return;
			}
			
			else if( pIndex < k){
				
				//the last k elements on the right of k are top k elements
				quickSort(array,pIndex+1,endIndex,k);
			}
			else{
				//sort left array
				quickSort(array,startIndex,pIndex-1,k);
			}
		}
	}

	private int partition(int[] array, int startIndex, int endIndex) {

		int pivot = array[endIndex];
		
		int pIndex = startIndex;
		
		for(int i=startIndex;i<endIndex;i++){
			
			if(array[i] <= pivot){
				
				//swap(array[i],array[pIndex]);
				int temp = array[i];
				array[i] = array[pIndex];
				array[pIndex] = temp;
				
				pIndex++;
			}
		}
		
		//swap(array[pIndex],array[endIndex]);
		int temp = array[pIndex];
		array[pIndex] = array[endIndex];
		array[endIndex] = temp;
		
		return pIndex;
	}

	public void swap(int indexOne,int indexTwo){
		
		
	}
	
	public static void main(String[] args) {

		int array[] = { 21, 42, 10, 14, 20, 15, 18};
		
		TopKElementsOnAnArray tools = new TopKElementsOnAnArray(array);
		
		tools.printTopKElements(4);
		
		
	}

}
