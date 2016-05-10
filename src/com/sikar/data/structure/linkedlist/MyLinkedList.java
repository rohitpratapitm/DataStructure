package com.sikar.data.structure.linkedlist;

import java.util.HashMap;
import java.util.Map;

import com.sikar.data.structure.linkedlist.problems.Node;

public class MyLinkedList {

	private Node root;
	
	public MyLinkedList(int aValue){
		
		root = new Node(aValue);
		
	}
	
	public MyLinkedList(Node lastDigitNode) {

		root = lastDigitNode;
	}

	public Node addNode(int aValue){
		
		if(root == null){
			root = new Node(aValue);
			return root;
		}
		else{
			Node end = new Node(aValue);
			
			Node runner = root;
			
			while(runner.getNext() != null){
				
				runner = runner.getNext();
			}
			runner.setNext(end);
			return end;
		}
	}
	
	public Node deleteNode(int aValue){
		
		Node runner = root;
		
		//handle for head/root
		if(runner.getValue() == aValue){
			
			return root.getNext();
		}
		else{
			
			//assuming runner will never be null.
			while(runner.getNext() != null){
				
				if(runner.getValue() == aValue){
					
					runner.setNext(runner.getNext().getNext());
					
					return root;
				}
			}
		}
		return null;
	}
	
	/**
	 * 2.1 Write code to remove duplicates from an unsorted linked list.
	 * 
	 * @param aRoot
	 */
	public void removeDuplicates(Node aRoot){
		
		if(aRoot == null || aRoot.getNext() == null){
			return;
		}
		
		Map<Integer,Node> memory = new HashMap<>();
		
		Node runner = aRoot;
		Node prev = null;
		while(runner != null){
			
			if(memory.containsKey(runner.getValue())){
				prev.setNext(runner.getNext());
				
			}
			else{
				memory.put(runner.getValue(), runner);
				prev = runner;
			}
			
			runner = runner.getNext();
		}
	System.out.println(root);	
			
	}
	
	public void removeDuplicatesWithoutBuffer(Node aRoot){
		
		Node current = aRoot;
		Node runner = aRoot;
		Node prev = aRoot;
		
		while(current != null){
			
			runner = current.getNext();
			
			while(runner != null){
				
				if(runner.getValue() == current.getValue()){
					//found a duplicate
					prev.setNext(runner.getNext());
				}
				else{
					prev = runner;
				}
				runner = runner.getNext();
			}
			prev = current;
			current = current.getNext();
		}
		System.out.println(root);	
	}
	
	public int getSize(Node aRoot){
		
		int size = 0;
		while(aRoot != null){
			
			size++;
			aRoot = aRoot.getNext();
		}
		return size;
	}
	/**
	 * 2.2 Implement an algorithm to find the kth to last element of a singly linked list.
	 * 
	 * @param aRoot
	 * @return
	 */
	public Node findKthLastElement(Node aRoot,int k){
		
		if(aRoot != null){
			
			int size = getSize(aRoot);
			int count = 0;
			
			Node runner = aRoot;
			
			while(runner != null){
				
				if(size-count == k){
					return runner;
				}
				count++;
				runner = runner.getNext();
			}
		}
		return null;
	}
	
	public Node findKthLastElementByRecursion(Node aRoot, int k){
	
		if(aRoot == null || k <= 0){
			return null;
		}
		
		Node p1 = aRoot;
		Node p2 = aRoot;
		
		//move p2 to k times
		for(int i=0;i<k-1;i++){
			
			if(p2 == null){
				return null;
			}
			p2 = p2.getNext();
		}
		
		if(p2 == null){
			return null;
		}
		//now start moving both till the end
		while(p2.getNext() != null){
			
			p1 = p1.getNext();
			
			p2 = p2.getNext();
		}
		
		return p1;
	}
	
	/**
	 * 2.3 Implement an algorithm to delete a node in the middle of a singly linked list, given
		only access to that node.

	 * @param aRoot
	 */
	public Node deleteFromMiddle(Node aNode){
		
		if(aNode != null){
			
			Node next = aNode.getNext();
			
			if(next != null){
				
				aNode.setValue(next.getValue());
				aNode.setNext(next.getNext());
				
				next.setNext(null);
				return aNode;
			}
			else{//This is the last node
				aNode = null;
			}
		}
		return null;
	}
	
	public Node partition2(Node aRoot, int aValue){
		
		if(aRoot == null || aRoot.getNext() == null){
			return null;
		}
		
		Node beforeStart = null;
		Node afterStart = null;
		
		Node current = aRoot;
		
		while(current != null){
			
			Node nextAddress = current.getNext();
			
			//break the link
			current.setNext(null);
			
			//compare if it is smaller
			if(current.getValue() < aValue){
				//add to the beginning
				current.setNext(beforeStart);
				beforeStart = current;
				
			}else{ // if it is bigger
				//add to the beginning of afterStart
				current.setNext(afterStart);
				afterStart = current;
			}
			current = nextAddress;
		}
		
		if(beforeStart == null){
			return afterStart;
		}
		
		//Need to merge the list , but we don't know the end of the smaller list.
		//find end of the first list
		Node head = beforeStart;
		while(beforeStart.getNext() != null){
			
			beforeStart = beforeStart.getNext();
		}
		
		beforeStart.setNext(afterStart);
		
		return head;
	}
	
	public Node partition(Node aRoot, int aValue){
		
		if(aRoot == null || aRoot.getNext() == null){
			return null;
		}
		
		Node beforeStart = null;
		Node beforeEnd = null;
		
		Node afterStart = null; 
		Node afterEnd = null;
		
		Node current = aRoot;
		
		while(current.getNext() != null){
			
			//1. Save the next node address
			Node nextNodeAddress = current.getNext();
			
			//2. Break the link
			current.setNext(null);
			
			//3.Check if this node is less
			if(current.getValue() < aValue){
				
				//a. check if this is the first node
				if(beforeStart == null){
					
					//initialize our list containing smaller values with this node being the head
					beforeStart = current;
					beforeEnd = beforeStart;
				}
				else{
					//set this node at the end of our smaller value list
					beforeEnd.setNext(current);
					beforeEnd = current;
				}
			}
			//if it is greater than add it to list containing greater values
			else{
				
				//a. check if it is the first node
				if(afterStart == null){
					
					afterStart = current;
					afterEnd = afterStart;
				}
				else{
					//Add it to the end of the list
					afterEnd.setNext(current);
					afterEnd = current;
				}
			}
			current = nextNodeAddress;
		}
		
		//if there is no smaller elements then return the list of greater elements
		if(beforeStart == null){
			return afterStart;
		}
		
		//merge the list
		beforeEnd.setNext(afterStart);
		
		return beforeStart;
		
	}
	
	public Node oddEven(Node aRoot){
		
		if(aRoot == null || aRoot.getNext() == null){
			
			return null;
		}
		
		Node oddStart = null;
		Node oddEnd = null;
		
		Node evenStart = null;
		Node evenEnd = null;
		
		Node current = aRoot;
		
		while( current != null){
			
			Node nextAddress = current.getNext();
			
			//break the link
			current.setNext(null);
			
			//check for even
			if(current.getValue() % 2 == 0){
				
				//check if this is the first value
				if(evenStart == null){
					
					evenStart = current;
					evenEnd = evenStart;
				}
				else{
					//add it the to end of the even list
					evenEnd.setNext(current);
					evenEnd = current;
				}
			}
			else{//for odd nodes
				
				//check if this is the first odd node
				if(oddStart == null){
					
					oddStart = current;
					oddEnd = oddStart;
				}
				else{
					//add it to the end
					oddEnd.setNext(current);
					oddEnd = current;
				}
			}
			current = nextAddress;
		}
		
		if(oddStart == null){
			return evenStart;
		}
		
		//merge the list
		oddEnd.setNext(evenStart);
		
		return oddStart;
	}
	
	public Node evenOdd(Node aRoot){
		
		if(aRoot == null || aRoot.getNext() == null){
			
			return null;
		}
		
		Node evenStart = null;
		Node oddStart = null;
		
		Node current = aRoot;
		
		while(current != null){
			
			Node nextAddress = current.getNext();
			
			//break the link
			current.setNext(null);
			
			//compare even
			if(current.getValue() % 2 == 0){
				
				current.setNext(evenStart);
				evenStart = current;
			}
			else{//odd
				current.setNext(oddStart);
				oddStart = current;
			}
			current = nextAddress;
		}
		
		if(evenStart == null){
			return oddStart;
		}
		
		//merge, since we don't know the end of the even list, find end first
		//save the root pointer
		Node head = evenStart;
		
		while(evenStart.getNext() != null){
			
			evenStart = evenStart.getNext();
		}
		
		evenStart.setNext(oddStart);
		
		return head;
	}
	
	public Node reverse(Node aRoot){
		
		if(aRoot == null || aRoot.getNext() == null){
			return null;
		}
		
		Node current = aRoot;
		Node prev = null;
		Node next = null;
		
		while(current.getNext() != null){
			
			Node nextAddress = current.getNext();
			
			//break the link
			current.setNext(prev);
			
			prev = current;
			
			current = nextAddress;
		}
		
		//reverse last node as well
		Node head = current;
		
		current.setNext(prev);
		
		return head;
	}
	
	class PartialSum{
		
		Node sum;
		int carry;
	}
	/**
	 * 7	8	9	5
	 * 0	2	3	6
	 * ----------------
	 * 				1
	 * 
	 * @param n1
	 * @param n2
	 * @param carry
	 * @return
	 */
	public Node sumOfLists(Node n1,Node n2){
		
		if(n1 == null && n2 == null){
			return null;
		}
		
		int l1 = length(n1);
		int l2 = length(n2);
		
		if(l1 < l2){
			//pad zeroes in l1
			n1 = padZeroes(n1,l2-l1);
		}
		else{
			n2 = padZeroes(n2,l1-l2);
		}
		
		//add them
		PartialSum result = addListHelper(n1,n2);
		
		if(result.carry > 0){
			return addBefore(result.sum,result.carry);
		}
		else{
			return result.sum;
		}
	}
	
	private Node addBefore(Node aRoot, int carry) {
		
		Node node = new Node(carry);

		if(aRoot !=  null){
			
			node.setNext(aRoot);			
		}
		return node;
	}

	private PartialSum addListHelper(Node n1, Node n2) {

		if(n1 == null && n2 == null){
			
			PartialSum result = new PartialSum();
			return result;
		}
		
		PartialSum result = addListHelper(n1.getNext(),n2.getNext());
		
		int sum = result.carry + n1.getValue() + n2.getValue();
		
		//get the last digit of the sum 
		int lastDigit = sum % 10;
		
		//store the last digit of the sum in a list
		result.sum = addBefore(result.sum, lastDigit);
		
		result.carry = sum / 10 ;
		
		return result;
	}

	private int length(Node n) {

		int len = 0;
		
		while(n != null){
			
			len++;
			n = n.getNext();
		}
		return len;
	}

	private Node padZeroes(Node n, int number) {
		
		Node head = null;
		
		if(n != null && number > 0){
			
			Node last = null;
			
			for(int i=0;i<number;i++){
				
				Node node = new Node(0);
				
				if(head == null){
					head = node;
				}
				else{
					last.setNext(node);
				}
				last = node;
			}
			last.setNext(n);
			
			return head;
		}
		else{
			return n;
		}
	}

	/**
	 * 2.5 You have two numbers represented by a linked list, where each node contains a
		single digit. The digits are stored in reverse order, such that the 1 's digit is at the head
		of the list. Write a function that adds the two numbers and returns the sum as a
		linked list.
	 * @param n1
	 * @param n2
	 * @return
	 */
	public Node sum(Node n1, Node n2){
		
		if(n1 == null && n2 == n1){
			return null;
		}
		
		else if(n1 == null){
			return n2;
		}
		
		else if(n2 == null){
			return n1;
		}
		
		int sum = 0;
		int carry = 0;
		
		MyLinkedList result = null;
		
		while(n1 != null || n2 != null){
			
			int value1 = 0;
			int value2 = 0;
			
			if(n1 != null){
				value1 = n1.getValue();
				n1 = n1.getNext();
			}

			if(n2 != null){
				value2 = n2.getValue();
				n2 = n2.getNext();
			}
			
			sum = value1 + value2 + carry;
			
			//get the carry
			carry = sum/10;
			
			//store the last digit 
			int lastDigit = sum%10;
			
			if(result == null){
				result = new MyLinkedList(lastDigit);
			}
			else{
				result.addNode(lastDigit);
				
			}
		}
		
		//check if carry is greater than 0
		if(carry > 0){
			//Add it to the node
			result.addNode(carry);
		}
		
		return result.reverse(result.root);
	}
	
	public Node findStartOfCircularLinkedList(Node aRoot){
		
		if(aRoot == null){
			return null;
		}
		
		//1. First find if there is a loop or not
		Node meetingPoint = findMeetingPoint(aRoot);
		
		if(meetingPoint == null){
			return null;//there is no loop , the linked list is NOT circular. 
		}
		//2. head will be the point where meetingPoint node and runner will meet
		Node runner = aRoot;
		
		//If linked list is circular, there MUST be a node where both these pointers will match.
		while(runner != meetingPoint){
			
			runner = runner.getNext();
			meetingPoint = meetingPoint.getNext();
		}
		
		return runner;
	}
	
	private Node findMeetingPoint(Node aRoot) {

		Node slowerNode = aRoot.getNext();
		Node fasterNode = aRoot.getNext().getNext();
		
		while(slowerNode != null && fasterNode != null && fasterNode.getNext() != null){
			
			if(slowerNode == fasterNode){
				break;
			}
			slowerNode = slowerNode.getNext();
			fasterNode = fasterNode.getNext().getNext();
		}
		
		//No loop found
		if(fasterNode == null){
			return null;
		}
		
		return fasterNode;
	}

	class Result{
		
		Node node;
		boolean matched;
		
		public Result(Node node, boolean aValue){
			
			this.node = node;
			this.matched = aValue;
		}
		
	}
	public Result isPalindromeRecurse(Node aRoot, int length){
		
		//base condition
		if(aRoot.getNext() == null || length == 0){

			return new Result(null, true);
		}
		else if(length == 1){
			
			return new Result(aRoot.getNext(),true);
		}
		else if(length == 2){
			
			return new Result(aRoot.getNext().getNext(),aRoot.getValue() == aRoot.getNext().getValue());
		}
		Result result = isPalindromeRecurse(aRoot.getNext(), length-2);
		
		if(!result.matched || result.node == null){
			
			return result;
		}
		else{
			result.matched = (aRoot.getValue() == result.node.getValue());
			
			result.node = result.node.getNext();
			
			return result;
		}
	}
	

	public Result palindrome(Node aNode, int length){
		
		//found the middle
		if(aNode == null || length == 0){
			
			return new Result(null,true);
		}
		
		else if(length == 1){
			
			return new Result(aNode.getNext(),true);
		}
		
		else if(length == 2){
			
			return new Result(aNode.getNext().getNext(), aNode.getValue() == aNode.getNext().getValue());
		}
		
		Result result = palindrome(aNode.getNext(),length-2);
		
		if(!result.matched || result.node == null){
			return result;
		}
		
		result.matched = (aNode.getValue() == result.node.getValue());
		
		result.node = result.node.getNext();
		
		return result;
		
	}

	public static void alternate(Node aRoot) {

		if (aRoot == null || aRoot.getNext() == null) {
			return;
		}

		Node even = null;
		Node nextOdd = null;
		Node current = aRoot;
		Node evenStart = null;

		while (current.getNext() != null) {

			evenStart = current.getNext();
			nextOdd = current.getNext().getNext();

			//put the address of next odd node in this odd node
			current.setNext(nextOdd);

			evenStart.setNext(even);
			even = evenStart;

			// hop one node
			current = nextOdd;
		}

		nextOdd.setNext(evenStart);
	}

	public static void main(String args[]){
		
		MyLinkedList linkedList = new MyLinkedList(1);
		
		Node b = linkedList.addNode(2);
		
		Node c = linkedList.addNode(3);
		
		Node d = linkedList.addNode(4);//head
		
		Node e = linkedList.addNode(5);
		
		alternate(linkedList.root);
		
		linkedList.print(linkedList.root);
	}

	private void print(Node head) {

		while(head != null){
			System.out.println(head);
			head = head.getNext();
		}
	}
}
