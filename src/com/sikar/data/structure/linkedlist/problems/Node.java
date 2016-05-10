package com.sikar.data.structure.linkedlist.problems;

public class Node{
	
	private Node next;
	
	private int value;

	public Node(int aValue) {

		this.value = aValue;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
	@Override
	public String toString(){
		
		return "Node : "+this.value;
	}

}