package com.sikar.data.structure.linkedlist;

import com.sikar.data.structure.linkedlist.problems.Node;

public class LinkedList {

	private Node first;
	
	Node last;
	
	int size;
	
	public LinkedList(){
		
		setFirst(null);
		last = null;
	}
	
	public int getSize(){
		return size;
	}
	public Node getHeader(){
		return getFirst();
	}
	public void add(int data){
		
		Node l = last;
		
		Node newNode = new Node(data);
		
		last = newNode;
		
		if(l == null){
			
			setFirst(newNode);
		}
		else{
			l.setNext(newNode);
		}
		size++;
	}
	
	public void removeFirst(){
		
		Node f = getFirst();
		Node next = f.getNext();
		setFirst(next);
		
		if(next == null){
			
			last = null;
					
		}else{
			
		}
		
		size--;
	}
	
	public void reverse(){
		
		Node current = getFirst();
		Node prev = null;
		Node next = null;
		
		while(current != null){
			
			next = current.getNext();
			
			current.setNext(prev);
			
			prev = current;
			
			current = next;
			
		}
		
		setFirst(prev);
	}

	public void print(){
		
		Node current = getFirst();
		
		System.out.println();
		while(current != null){
			
			System.out.print(current);
			
			current = current.getNext();
		}
	}
	
	public void printForward(Node node){
		
		if(node != null){

			System.out.print(node);
			
			printForward(node.getNext());
		}
		else{
			System.out.println();
		}
	}
	
	public void printReverse(Node node){
		
		if(node != null){
			
			printReverse(node.getNext());
			System.out.print(node);
		}
	}
	
	public void reverseRecursion(Node node){
		
		Node next;
		
		if(node.getNext() == null){
			
			setFirst(node);
			
			return;
		}
		reverseRecursion(node.getNext());
		next = node.getNext();
		next.setNext(node);
		node.setNext(null);
	}
	public static void main(String args[]){
		
		LinkedList list = new LinkedList();
		
		//list.add(10);list.add(20);list.add(30);list.add(40);
		
//		list.print();
//		
//		list.reverse();
//		list.reverseRecursion(list.first);
		
		list.add(10);list.add(15);list.add(8);list.add(12);list.add(10);list.add(5);
		list.add(4);list.add(1);list.add(7);list.add(6);
		list.print();

		
		list.print();
		
	}
	
	public void swap(Node n1,Node n2){
		
		add(10);add(20);add(30);add(40);
		//Node n
		Node temp1 = n1.getNext();
		Node temp2 = n2.getNext();
		
		n1.setNext(temp2);
		n2.setNext(temp1);
	}

	public Node getFirst() {
		return first;
	}

	public void setFirst(Node first) {
		this.first = first;
	}
}


