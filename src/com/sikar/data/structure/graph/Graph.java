package com.sikar.data.structure.graph;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

public abstract class Graph {

	List<Vertex> graph ;
	
	public Graph(){
		
		graph = new ArrayList<Vertex>();
	}
	
	public boolean addVertex(String aVertexName){
		
		//check if Vertex already exist
		for(Vertex vertex:graph){
			
			if(vertex.getId().equals(aVertexName)){
				System.out.println("Vertex already exist");
				return false;
			}
		}
		
		return graph.add(new Vertex(aVertexName));
	}
	
	public int indexOf(String aVertexName){
		
		for(int index=0;index < graph.size();index++){
			
			Vertex vertex = graph.get(index);
			
			if(vertex.getId().equals(aVertexName)){
				return index;
			}
		}
		throw new NoSuchElementException("Vertex "+aVertexName+" doesn't exist. Add the Vertex first.");
	}
	
	public void makeFriends(String aSourceVertex,String aDestinationVertex,int aWeight){
		
		//1. Check if users are present in the set or not.
		int sourceIndex = indexOf(aSourceVertex);
		
		int destinationIndex = indexOf(aDestinationVertex);
			
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
	
	public List<Vertex> getConnections(String aId){
		
		int sourceIndex = indexOf(aId);
		
		Vertex sourceVertex = graph.get(sourceIndex);
		
		return getConnections(sourceVertex);
	}
	
	/**
	 * Return list of 2nd level connections
	 * @param aVertexId
	 * @return
	 */
	//TODO make it generic by passing the level id 
	public Set<Vertex> getSecondLevelNeighbours(String aVertexId){
		
		int sourceIndex = indexOf(aVertexId);
		
		Vertex user = graph.get(sourceIndex);
		
		List<Edge> edgeList = user.getEdges();
		
		Set<Vertex> connections = new HashSet<>(edgeList.size());
		
		for(Edge edge:edgeList){
			
			int directFriendIndex = edge.getIndex();
			
			Vertex friend = graph.get(directFriendIndex);
			if(friend.isActive()){
				connections.addAll(getConnections(friend));
			}
		}
		connections.remove(user);

		connections.removeAll(getConnections(user));
		return connections;
	}
	
//	public void getNeighbours(String aVertexId,int aLevel,Set<Vertex> aConnections){
//		
//		if(aLevel == 1){
//			
//			List<Vertex> firstLevelConnections =getConnections(aVertexId); 
//			aConnections.addAll(firstLevelConnections);
//		}
//		
//		else if (aLevel == 2){
//			getNeighbours(aVertexId,aLevel-1,aConnections);
//			
//			Iterator<Vertex> iterator = aConnections.iterator();
//			
//			while(iterator.hasNext()){
//				
//				getNeighbours(iterator.next().getId(), aLevel, aConnections);
//			}
//		}
//	}
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

	
	public List<Vertex> getCommonVertices(String aUser1,String aUser2){
		
		//1. Check if users are present in the set or not.
		int user1Index = indexOf(aUser1);
		
		int user2Index = indexOf(aUser2);
			
		Vertex user1 = graph.get(user1Index);
		
		Vertex user2 = graph.get(user2Index);
		
		//Get friends of user1
		List<Vertex> user1FriendList = getConnections(user1);
		
		//Get friends of user2
		List<Vertex> user2FriendList = getConnections(user2);
		
		//If User1 and User2 are friends then 
		if(user1.isConnected(user2Index)){
			
			user1FriendList.remove(user2);//remove user 2 from user1's friend list
			user2FriendList.remove(user1);//remove user 1 from user2's friend list
		}
		//find common friends from two lists
		user1FriendList.retainAll(user2FriendList);
		
		return user1FriendList;
				
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
		
		//Get vertex
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
