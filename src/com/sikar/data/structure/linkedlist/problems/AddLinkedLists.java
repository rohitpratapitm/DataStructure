package com.sikar.data.structure.linkedlist.problems;

import com.sikar.data.structure.linkedlist.LinkedList;;

public class AddLinkedLists {

	
	public static LinkedList addLists(LinkedList one,LinkedList two){
		
		if(one == null || one.getSize() == 0){
			return two;
		}
		else if(two == null || two.getSize() == 0){
			return one;
		}
		
		LinkedList three = new LinkedList();
		
		one.reverse();
		two.reverse();
		
		Node node1 = one.getHeader();
		Node node2 = two.getHeader();
		
		int carry = 0;
		
		while(true){
			
			int value1 = 0;
			int value2 = 0;
			
			if(node1 == null){
				value1 = 0;
			}else{
				value1 = node1.getValue();
				node1 = node1.getNext();
			}
			
			if(node2 == null){
				value2 = 0;
			}else{
				value2 = node2.getValue();
				node2 = node2.getNext();
			}
			
			
			int sum = value1 + value2 + carry;
			
			int value3 = sum%10;
			
			carry = sum/10;
			
			three.add(value3);
			
			if(node1 == null && node2 == null){
				break;
			}
		}
		
		three.reverse();
		
		return three;
	}
	
	public static void main(String args[]){
		
		LinkedList one = new LinkedList();
		
		LinkedList two = new LinkedList();
		
		//Storing number 12345
		one.add(1);one.add(2);one.add(3);one.add(4);one.add(5);
		
		//Storing number 678
		two.add(6);two.add(7);two.add(8);
		
		//Sum should be 12345+678 = 13023
		LinkedList three = addLists(one, two);
		
		three.print();
		System.out.println(three);
	}
}
