package com.sikar.data.structure.graph;

class Edge{
	
	private int mIndex;
	private int mWeight;
	
	public Edge(int aIndex, int aWeight){
		
		this.mIndex = aIndex;
		this.mWeight = aWeight;
	}

	public int getIndex() {
		return mIndex;
	}
	public void setIndex(int aIndex) {
		this.mIndex = aIndex;
	}
	public int getWeight() {
		return mWeight;
	}
	public void setWeight(int aWeight) {
		this.mWeight = aWeight;
	}
	
	@Override
	public int hashCode(){
		
		int result = 1;
		result =  31 * result + mIndex;
		return result;
	}
	
	@Override
	public boolean equals(Object aEdge){
		
		if(this == aEdge){
			return true;
		}
		else if(aEdge == null || getClass() != aEdge.getClass()){
			return false;
		}
		Edge edge = (Edge)aEdge;
		
		if(this.mIndex == edge.mIndex ){
			return true;
		}
		return false;
	}
	
	@Override
	public String toString(){
		
		return mIndex+"("+mWeight+")";
	}
}