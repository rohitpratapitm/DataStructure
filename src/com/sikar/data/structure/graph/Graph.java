package com.sikar.data.structure.graph;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

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
		throw new NoSuchElementException("User "+aId+" doesn't exist. Add the user first.");
	}
	
	public void makeFriends(String aSourceName,String aDestinationName,int aWeight){
		
		//1. Check if users are present in the set or not.
		int sourceIndex = indexOf(aSourceName);
		
		int destinationIndex = indexOf(aDestinationName);
			
		//Add this edge to the source and destination vertices
		Vertex source = graph.get(sourceIndex);
		
		//Check if connection already exists
		boolean isConnected = source.isConnected(destinationIndex);
		
		if(isConnected){
			System.out.println("Already Connected !");
		}
		else{
			Vertex destination = graph.get(destinationIndex);
			
			source.addEdge(destinationIndex, aWeight);
			
			destination.addEdge(sourceIndex, aWeight);
		}
	}
	
	/**
	 * Suggest first level friends of friends
	 * 
	 * @param aSource
	 */
	public Set<Vertex> suggestFriends(String aSource){
		
		int sourceIndex = indexOf(aSource);
		
		Vertex sourceVertex = graph.get(sourceIndex);
		
		List<Edge> edgeList = sourceVertex.getEdges();
		
		Set<Vertex> connections = new HashSet<>(edgeList.size());
		
		for(Edge edge:edgeList){
			
			int directFriendIndex = edge.getIndex();
			
			Vertex friendVertex = graph.get(directFriendIndex);
			if(friendVertex.isActive()){
				connections.addAll(getConnections(friendVertex));
			}
		}
		connections.remove(sourceVertex);

		connections.removeAll(getConnections(sourceVertex));
		return connections;
	}
	
	public List<Vertex> getConnections(String aId){
		
		int sourceIndex = indexOf(aId);
		
		Vertex sourceVertex = graph.get(sourceIndex);
		
		return getConnections(sourceVertex);
	}
	/**
	 * Return list of friends
	 * @param aVertex
	 * @return
	 */
	public List<Vertex> getConnections(Vertex aVertex) {
		
		if(aVertex.isActive()){
			List<Edge> edgeList = aVertex.getEdges();
			
			List<Vertex> friends = new ArrayList<>(edgeList.size());
			
			for(Edge edge: edgeList){
				
				friends.add(graph.get(edge.getIndex()));
			}
			return friends;
		}
		System.out.println(aVertex.getId() +" is inactive");
		return null;
	}

	//TODO
	public Set<Vertex> getMutualFriends(String aUser1,String aUser2){
		
		//1. Check if users are present in the set or not.
		int sourceIndex = indexOf(aUser1);
		
		int destinationIndex = indexOf(aUser2);
			
		Vertex source = graph.get(sourceIndex);
		
		return null;
				
	}
	public void removeUser(String aId){

		int index = indexOf(aId);
		
		Vertex source = graph.get(index);
		source.setActive(false);
		//1. Remove Connections for this User
		for(Vertex vertex: graph){
			
			if(vertex.isActive()){
				vertex.removeEdge(index);
			}
		}
	}

	public int getNumberOfUsers() {

		return graph.size();
	}

	public boolean areFriends(String aSourceName, String aDestinationName) {
		//1. Check if users are present in the set or not.
		int sourceIndex = indexOf(aSourceName);
		
		int destinationIndex = indexOf(aDestinationName);
			
		//Add this edge to the source and destination vertices
		Vertex source = graph.get(sourceIndex);
		
		//Check if connection already exists
		return source.isConnected(destinationIndex);
		
	}
	
	public boolean unFriend(String aSourceName, String aDestinationName){
		
		//1. Check if users are present in the set or not.
		int sourceIndex = indexOf(aSourceName);
		
		int destinationIndex = indexOf(aDestinationName);
			
		//Add this edge to the source and destination vertices
		Vertex source = graph.get(sourceIndex);
		
		return source.removeEdge(destinationIndex);
	}

	public Vertex getUser(String aSourceName) {

		//1. Check if users are present in the set or not.
		int sourceIndex = indexOf(aSourceName);
				
		return graph.get(sourceIndex);
	}
}
