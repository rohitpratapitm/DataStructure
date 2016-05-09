package com.sikar.data.structure.graph;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

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
		result =  31 * result + mWeight;
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
		
		if(this.mIndex == edge.mIndex && this.mWeight == edge.mWeight){
			return true;
		}
		return false;
	}
	
	@Override
	public String toString(){
		
		return "--"+mWeight+"-->"+mIndex;
	}
}

class Vertex{
	
	private String mId;
	
	private List<Edge> mEdges;
	
	public Vertex(String aId){
		
		this.mEdges = new LinkedList<Edge>();
		this.mId = aId;
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
		
		Edge edge = new Edge(aDestinationVertexIndex,aWeight);
		return mEdges.add(edge);
	}
	
	public void removeEdge(int aDestinationVertexIndex){
		
		for(Edge edge: mEdges){
			
			
		}
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
		return mId+" : "+mEdges;
	}
}

public class Graph {

	List<Vertex> graph ;
	
	public Graph(){
		
		graph = new ArrayList<Vertex>();
	}
	
	public boolean addUser(String mUserName){
		
		//check if Vertex already exist
		for(Vertex vertex:graph){
			
			if(vertex.getId().equals(mUserName)){
				System.out.println("User already exist");
				return false;
			}
		}
		
		return graph.add(new Vertex(mUserName));
	}
	
	public int indexOf(String aId){
		
		for(int index=0;index < graph.size();index++){
			
			Vertex vertex = graph.get(index);
			
			if(vertex.getId().equals(aId)){
				return index;
			}
		}
		return -1;
	}
	
	public void makeFriends(String aSourceName,String aDestinationName,int aWeight){
		
		//1. Check if users are present in the set or not.
		int sourceIndex = indexOf(aSourceName);
		
		if(sourceIndex == -1){
			throw new NoSuchElementException("User "+aSourceName+" doesn't exist. Add the user first.");
		}
		
		int destinationIndex = indexOf(aDestinationName);
		if(destinationIndex == -1){
			throw new NoSuchElementException("User "+aDestinationName+" doesn't exist. Add the user first.");
		}
		
			
		//Add this edge to the source and destination vertices
		Vertex source = graph.get(sourceIndex);
		Vertex destination = graph.get(destinationIndex);
		
		source.addEdge(destinationIndex, aWeight);
		
		destination.addEdge(sourceIndex, aWeight);
	}
	
	/**
	 * Suggest first level friends of friends
	 * 
	 * @param aSource
	 */
	public List<Vertex> suggestFriends(String aSource){
		
		int sourceIndex = indexOf(aSource);
		
		if(sourceIndex == -1){
			throw new NoSuchElementException("User "+aSource+" doesn't exist. Add the user first.");
		}
		
		Vertex sourceVertex = graph.get(sourceIndex);
		
		List<Edge> edgeList = sourceVertex.getEdges();
		
		List<Vertex> connections = new ArrayList<>(edgeList.size());
		
		for(Edge edge:edgeList){
			
			int directFriendIndex = edge.getIndex();
			
			Vertex friendVertex = graph.get(directFriendIndex);
			
			connections.addAll(getConnections(friendVertex));
		}
		return connections;
	}
	
	/**
	 * Return list of friends
	 * @param aVertex
	 * @return
	 */
	private List<Vertex> getConnections(Vertex aVertex) {
		
		List<Edge> edgeList = aVertex.getEdges();
		
		List<Vertex> friends = new ArrayList<>(edgeList.size());
		
		for(Edge edge: edgeList){
			
			friends.add(graph.get(edge.getIndex()));
		}
		return friends;
	}

	public void removeUser(String aId){
		
		//Remove user should also remove all the connections
		
	}
	
}
