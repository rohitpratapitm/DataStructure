package com.sikar.data.structure.linkedlist.problems;

import com.sikar.data.structure.linkedlist.LinkedList;

public class Palindrome{
	
	public boolean isPalindrome(Node aNode){
		
		if(aNode != null){
			
			int length = getLength(aNode);
			
			Result result = isPalindromeHelper(aNode, length);
			
			if(result != null){
				return result.isPalindrome;
			}
		}
		return false;
	}

	private Result isPalindromeHelper(Node aNode, int length) {

		if(aNode == null || length == 0 ){
			return new Result(null,true);
		}
		else if(length == 1){
			return new Result(aNode.getNext(),true);
		}
		
		Result result = isPalindromeHelper(aNode.getNext(), length-2);
		
		if(!result.isPalindrome || result.next == null){
			
			return result;
		}
		//compare result data with stack value on stack
		result.isPalindrome = result.next.getValue() == aNode.getValue();
		result.next = result.next.getNext();
		
		return result;
	}

	public static void main(String args[]){
		
		Palindrome tools = new Palindrome();
		
		LinkedList list = new LinkedList();
		
		list.add(1);list.add(2);list.add(3);list.add(4);list.add(5);
		
		list.add(6);
		
		list.add(5);list.add(5);list.add(3);list.add(2);list.add(1);
		
		System.out.println(tools.isPalindrome(list.getFirst()));
		
	}
	private int getLength(Node aNode) {

		int length = 0;
		
		while(aNode != null){
			
			aNode = aNode.getNext();
			
			length++;
		}
		return length;
	}
	
}

class Result{
	
	Node next;
	boolean isPalindrome;
	
	public Result(Node next, boolean isPalindrome){
		
		this.next = next;
		this.isPalindrome = isPalindrome;
	}
}

