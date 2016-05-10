package com.sikar.array.problems;

public class GeeksForGeeks {

	
	/**
	 * Q1) In a sorted array every number is present twice, only one number is present one time.
	 *  You have to find the number occurring once. Expected complexity : O(log N)
	Ex : 101, 101, 200, 200, 301, 450, 450
	Output : 301	
	 */
	
	public int findSingleOccurence(int[] a){
		
		int low = 0;
		int high = a.length;
		
		//Since each number is present 2 times, the length of the array must be divisible by 2.
		if(a.length % 2 == 0){
			return -1;
		}
		//if not then the array has 1 unique number
		return binarySearch(a,low,high-1);
	}

	private int binarySearch(int[] a, int low, int high) {
		
		while(low !=high){
			
			int mid = (low+high)/2;
			
			//all the number in right half are in pairs
			if(a[mid] == a[mid +1]){
				//search in left
				high = mid-1;
			}
			//that means all the number in left half are in pairs
			else if(a[mid] == a[mid-1]){
				//search in right
				low = mid+1;
			}
			
			else{
				//right half and left half both has even pairs, this the number then.
				return a[mid];
			}
		}
		return a[low];
	}
	
	/**
	 * Given an array of integers. Find a peak element in it. An array element
	 * is peak if it is NOT smaller than its neighbors. For corner elements, we
	 * need to consider only one neighbor. For example, for input array 
	 * {5, 10,20, 15}, 20 is the only peak element. For input array 
	 * {10, 20, 15, 2, 23,90, 67}, there are two peak elements: 20 and 90. Note that we need to
	 * return any one peak element.
	 * 
	 * Following corner cases give better idea about the problem. 1) If input
	 * array is sorted in strictly increasing order, the last element is always
	 * a peak element. For example, 50 is peak element in {10, 20, 30, 40, 50}.
	 * 2) If input array is sorted in strictly decreasing order, the first
	 * element is always a peak element. 100 is the peak element in {100, 80,60, 50, 20}. 
	 * 3)If all elements of input array are same, every element is
	 * a peak element.
	 * 
	 * @param args
	 */
	
	public int findPeek(int[] a){
		
		int low = 0;
		
		int high = a.length-1;
		
		while(low <= high){
			
			int mid = (low+high)/2;
			
			if(mid == a.length-1 || mid == 0 || a[mid] >= a[mid+1] && a[mid] >= a[mid-1]){
				return a[mid];
			}
			else if(a[mid] < a[mid+1]){
				
				//look right
				low = mid+1;
			}
			else if( a[mid] < a[mid-1]){
				
				high = mid -1;
			}
		}
		return a[low];
	}
	
	public static void main(String args[]){
		
		//int[] a = {101,101,200,200,450,450,501};
		
		//int[] a = {101,101,201,201,301,450,450,501,501};
		
		GeeksForGeeks tools = new GeeksForGeeks();
		
//		System.out.println(tools.findSingleOccurence(a));
		
		int[] a = {5, 10,20, 15};
		
		System.out.println("20: "+tools.findPeek(a));
		
		int[] b = {10, 20, 15, 2, 23,90, 67};
		
		System.out.println("20-90: "+tools.findPeek(b));
		
		int[] c = {10, 20, 30, 40, 50};
		
		System.out.println("50 : "+tools.findPeek(c));
		
		int[] d = {100, 80,60, 50, 20};
		
		System.out.println("100 : "+tools.findPeek(d));
		
		int[] e = {10,10,10,10};
		
		System.out.println("10 : "+tools.findPeek(e));
	}
}
