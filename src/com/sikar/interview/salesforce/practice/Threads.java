package com.sikar.interview.salesforce.practice;

public class Threads {

	public static void main(String[] args){
		
		Object obj = new Object();
		
		Runnable task1 = new Worker(1,obj);
		Runnable task2 = new Worker(2,obj);
		Runnable task3 = new Worker(3,obj);
		
		Thread t1 = new Thread(task1,"T1");
		Thread t2 = new Thread(task2,"T2");
		Thread t3 = new Thread(task3,"T3");
		
		t1.start();
		t2.start();
		t3.start();
	}
}

class Worker implements Runnable{

	private String name = "T1";
	private int number;
	
	private final Object sharedObject;
	
	Worker(int number,Object sharedObject){
		this.number = number;
		this.sharedObject = sharedObject;
	}
	
	@Override
	public void run() {
		
		//Acquire lock on a shared object
		synchronized (sharedObject) {
			
			int i = 0;
			while(i<20){
				if (!name.equals(Thread.currentThread().getName())) {

					try{
						sharedObject.wait();
					}catch(InterruptedException ie){
						ie.printStackTrace();
					}
				}
				else if(this.name.equals(Thread.currentThread().getName())){
					System.out.println(number);
					
					//share lock to t2
					if(Thread.currentThread().getName().equals("T1")){
						name = "T2";
					}
					else if(Thread.currentThread().getName().equals("T2")){
						name = "T3";
					}
					else{
						name = "T1";
					}
					i++;
					sharedObject.notifyAll();
				}
			}
		
		}
	}
	
	
}