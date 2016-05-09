package com.sikar.sorting.algorithms.problems;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;


public class TopKFrequentItems  {

	public static void findTopK(int a[],int k){
		
		if(a == null || a.length == 0 || k <= 0){
			return;
		}
		
		final class IntFrequency implements Comparable<IntFrequency> {
	        Integer word;
	        int freq;

	        public IntFrequency(final Integer w, final int c) {
	            word = w;
	            freq = c;
	        }

	        @Override
	        public int compareTo(final IntFrequency other) {
	            return Integer.compare(this.freq, other.freq);
	        }
	        
	        @Override
	        public String toString(){
	        	return "Key:"+word+"-"+"Frequencey:"+freq;
	        }
	    }
		
		// Key is number, value is frequency
		Map<Integer,Integer> map = new HashMap<>();
		
		//Populate the hash map
		for(int i=0;i<a.length;i++){
			
			if(map.containsKey(new Integer(a[i]))){
				
				int value = map.get(a[i]);
				map.put(a[i], value+1);
			}
			else{
				map.put(a[i], 1);
			}
		}
		
		PriorityQueue<IntFrequency> maxHeap = new PriorityQueue<>(k);
		
		for(Map.Entry<Integer, Integer> entry: map.entrySet()){
			
			if(maxHeap.size() < k){
				maxHeap.add(new IntFrequency(entry.getKey(),entry.getValue()));
				
			}else if(entry.getValue() > maxHeap.peek().freq){
				maxHeap.remove();
				maxHeap.add(new IntFrequency(entry.getKey(),entry.getValue()));
			}
		}
		System.out.println("Using Max Heap");
		for(int i=0;i<k;i++){
			System.out.println(maxHeap.poll());
		}
		
		System.out.println("Using LinkedList");
		List<Map.Entry<Integer,Integer>> list = new LinkedList<>(map.entrySet());
		
		Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {

			@Override
			public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
				
				return o2.getValue().compareTo(o1.getValue());
			}
		});
		
		//print top k
		for(int i=0;i<k;i++){
			System.out.println(list.get(i).getKey()+":"+list.get(i).getValue());
		}
	}
	
	public static void sort(int[] array){

		if(array != null && array.length>0){
			
			Map<Integer,Integer> frequencyMap = new LinkedHashMap<>();
		
		for(int index=0;index<array.length ;index++){
			
				if(frequencyMap.containsKey(array[index])){
					
					int count = frequencyMap.get(array[index]);
					
					frequencyMap.put(array[index],++count);
				}
				else{
					frequencyMap.put(array[index],1);
				}
			}
			
		PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>(frequencyMap.size());
		
		List<Map.Entry<Integer,Integer>> list = new LinkedList<>(frequencyMap.entrySet());
		
		Collections.sort(list, new Comparator<Map.Entry<Integer,Integer>>(){
		
			public int compare(Map.Entry<Integer,Integer> o1, Map.Entry<Integer,Integer> o2){
			
				return o2.getValue().compareTo(o1.getValue());
			}
		});
		
		int arrayIndex=0;
		for(Map.Entry<Integer,Integer> entry: list){
			
			for(int index=0;index<entry.getValue();index++){
			
				array[arrayIndex] = entry.getKey();
				arrayIndex++;
			}
		}
		//print array
		for(int index=0;index<array.length;index++){
			System.out.println(array[index]);
		}
	}
}
	public static void main(String args[]){
		
		int a[] = {1,2,6,5,4,6,7,8,8,4,2,3,2,2,2,2,2,1,1,1,1};
		int b[] = {2,4,5,2,1,9,3,2,2,5,1,5};
		sort(b);
		//findTopK(a, 3);
	}
}
