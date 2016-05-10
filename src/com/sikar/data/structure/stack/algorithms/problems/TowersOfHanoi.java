package com.sikar.data.structure.stack.algorithms.problems;

import java.util.Stack;

class Tower{
	
	private Stack<Integer> mDisks;
	
	private String mName;
	
	public Tower(String aName){
		
		mDisks = new Stack<>();
		
		mName = aName;
	}
	
	public void push(int aDisk){
		
		if(!mDisks.isEmpty() && mDisks.peek() < aDisk){
			System.out.println("Cannot put bigger disk : "+aDisk + " on top of smaller disk : "+mDisks.peek());
		}
		else{
			mDisks.push(aDisk);
		}
	}
	
	public void moveTopTo(Tower aTower){
		
		int top = mDisks.pop();
		
		aTower.push(top);
		
		System.out.println("Moving disk : "+ top +" from Tower "+mName+" to Tower "+aTower.mName);
	}
	
	public void moveDisks(int n, Tower aDestination, Tower aBuffer){
		
		if(n > 0){
			
			moveDisks(n-1, aBuffer, aDestination);
			
			moveTopTo(aDestination);
			
			aBuffer.moveDisks(n-1, aDestination, this);
		}
	}
	
	@Override
	public String toString(){
		
		return mDisks.toString();
	}
	
}
public class TowersOfHanoi {

	
	public static void main(String args[]){
		
		Tower[] towers = new Tower[3];
		
		towers[0] = new Tower("A");
		towers[1] = new Tower("B");
		towers[2] = new Tower("C");
		
		int n = 5;
		
		for(int i=n;i>0;i--){
			
			towers[0].push(i);
		}
		
		System.out.println(towers[0]);
		
		towers[0].moveDisks(n, towers[1], towers[2]);
		
		System.out.println(towers[1]);
	}
}
