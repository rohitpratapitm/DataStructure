package com.sikar.data.structure.graph;

import java.util.List;
import java.util.Set;

public class Facebook extends Graph {

	public boolean addUser(String aUserName){
		
		if(super.addVertex(aUserName)){
			return true;
		}
		else{
			System.out.println("User "+aUserName+" already exist");
		}
		return false;
	}
	
	/**
	 * Suggest first level friends of friends
	 * 
	 * @param aUserName
	 */
	public Set<Vertex> suggestFriends(String aUserName){
		
		return getSecondLevelNeighbours(aUserName);
	}
	
	public List<Vertex> getFriendList(String aUserName){
	
		return getConnections(aUserName);
	}
	
	public List<Vertex> getMutualFriends(String aUser1,String aUser2){
		return super.getCommonVertices(aUser1, aUser2);
	}
}
