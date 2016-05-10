package com.sikar.data.structure.stack.algorithms.problems;

import java.util.Stack;

public class QueueBuiltOnStacks {

	private Stack<Integer> mInbox;
	
	private Stack<Integer> mOutbox;
	
	public QueueBuiltOnStacks(){
		
		mInbox = new Stack<>();
		mOutbox = new Stack<>();
	}
	
	public void enqueue(Integer aValue){
		
		mInbox.push(aValue);
		System.out.println("Enqueue : "+ aValue);
	}
	
	public void shuffle() {

		if (mOutbox.isEmpty()) {
			
			System.out.println("Before Shuffle");
			System.out.println("Inbox is : "+mInbox);
			System.out.println("Outbox is : "+mOutbox);

			while (!mInbox.isEmpty()) {
				
				mOutbox.push(mInbox.pop());
			}
			System.out.println("After Shuffle");
			System.out.println("Inbox is : "+mInbox);
			System.out.println("Outbox is : "+mOutbox);
		}
	}
	
	public Integer peek(){
		
		shuffle();
		int peek = mOutbox.peek();
		System.out.println("Peek () is : "+peek);
		return peek;
	}
	
	public Integer dequeue(){
		
		shuffle();
		int peek = mOutbox.pop();
		System.out.println("Dequeued : "+ peek);
		return peek;
	}
	
	public static void main(String args[]){
		
		QueueBuiltOnStacks queue = new QueueBuiltOnStacks();
		
		queue.enqueue(10);queue.enqueue(20);queue.enqueue(30);
		
		queue.dequeue(); queue.enqueue(40);queue.dequeue();
		
		queue.enqueue(50);queue.peek();queue.peek();queue.dequeue();
		
		queue.peek();queue.enqueue(100);
	}
}
