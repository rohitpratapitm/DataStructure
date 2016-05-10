package com.sikar.data.structure.graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

class Vertex{
	
	private String mId;
	private boolean active;
	
	private List<Edge> mEdges;
	
	public Vertex(String aId){
		
		this.mEdges = new LinkedList<Edge>();
		this.mId = aId;
		this.active = true;
	}

	public String getId() {
		return mId;
	}

	public void setId(String aId) {
		this.mId = aId;
	}

	public List<Edge> getEdges() {
		return mEdges;
	}

	public void setEdges(List<Edge> aEdges) {
		this.mEdges = aEdges;
	}
	
	public boolean addEdge(int aDestinationVertexIndex, int aWeight){
		
		if(active){
			Edge edge = new Edge(aDestinationVertexIndex,aWeight);
			return mEdges.add(edge);
		}
		return false;
	}
	
	public boolean isConnected(int aDestinationIndex) {
		
		return mEdges.contains(new Edge(aDestinationIndex,-1));
	}

	public boolean removeEdge(int aDestinationVertexIndex){
		
		Iterator<Edge> itr = mEdges.iterator();
		
		while(itr.hasNext()){
			
			Edge edge = itr.next();
			
			if(aDestinationVertexIndex == edge.getIndex()){
				itr.remove();
				return true;
			}
		}
		return false;
	}
	
	public void removeAll(){
		
		mEdges.clear();
	}
	
	@Override
	public int hashCode(){
		
		int result = 1;
		return  31 * result + mId.hashCode();
	}
	
	@Override
	public boolean equals(Object aVertex){
		
		if(this == aVertex){
			return true;
		}
		else if (aVertex == null || getClass() != aVertex.getClass()){
			return false;
		}
		
		Vertex vertex = (Vertex)aVertex;
		
		return mId.equals(vertex.mId);
	}
	
	@Override
	public String toString(){
		return mId;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
}