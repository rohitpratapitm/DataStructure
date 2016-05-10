package com.sikar.data.structure.graph;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Set;

import org.junit.Test;

public class Junits {

	Graph facebook = new Graph();
	
	@Test
	public void testDuplicateUsers(){
		
		//Check if graph allows duplicate users
		assertTrue(facebook.addUser("Rohit"));
		assertTrue(facebook.addUser("Alok"));
		assertEquals(2, facebook.getNumberOfUsers());
		
		assertFalse(facebook.addUser("Rohit"));
		assertEquals(2, facebook.getNumberOfUsers());
	}
	
	@Test
	public void testMakeFriends(){
		
		assertTrue(facebook.addUser("Rohit"));
		assertTrue(facebook.addUser("Alok"));
		assertTrue(facebook.addUser("Aditya"));
		
		//connect
		facebook.makeFriends("Rohit", "Alok", 50);
		
		assertTrue(facebook.areFriends("Rohit","Alok"));
		
		//connect
		facebook.makeFriends("Aditya", "Alok", 50);
		
		assertTrue(facebook.areFriends("Alok","Aditya"));
		assertFalse("Rohit and Aditya are not friends. ",facebook.areFriends("Rohit","Aditya"));
	}
	
	@Test
	public void testSuggestFriends(){
		
		assertTrue(facebook.addUser("Rohit"));
		assertTrue(facebook.addUser("Alok"));
		assertTrue(facebook.addUser("Aditya"));
		//connect
		facebook.makeFriends("Rohit", "Alok", 50);
		facebook.makeFriends("Aditya", "Alok", 50);
		
		Set<Vertex> friends = facebook.suggestFriends("Rohit");
		System.out.println("Suggested Friends for Rohit : "+friends);
		assertEquals(1,friends.size());
		assertEquals("Aditya",friends.iterator().next().getId());
	}

	@Test 
	public void testGetFriends(){
		
		facebook.addUser("Rohit");
		facebook.addUser("Alok");
		facebook.addUser("Sarath");
		facebook.addUser("Vikrant");
		facebook.addUser("Harish");
		facebook.addUser("Aditya");
		facebook.addUser("Manmohan");
		facebook.addUser("Aish");
		//Rohit
		facebook.makeFriends("Rohit", "Alok", 100);
		facebook.makeFriends("Rohit", "Aditya", 50);
		facebook.makeFriends("Rohit", "Sarath", 200);
		facebook.makeFriends("Rohit", "Vikrant", 60);
		facebook.makeFriends("Rohit", "Harish", 30);
		facebook.makeFriends("Rohit", "Aditya", 30);
		facebook.makeFriends("Rohit", "Aish", 250);
		
		//Alok
		facebook.makeFriends("Alok", "Manmohan", 100);
		facebook.makeFriends("Alok", "Aditya", 100);
		
		List<Vertex> rohitFriends = facebook.getConnections("Rohit");
		
		List<Vertex> alokFriends = facebook.getConnections("Alok");
		
		assertEquals(6,rohitFriends.size());
		
		System.out.println("Rohit Friend List:"+rohitFriends);
		
		assertEquals(3,alokFriends.size());
		System.out.println("Alok Friend List:"+alokFriends);
	}
	
	@Test
	public void testUnfriend(){
		
		facebook.addUser("Rohit");
		facebook.addUser("Alok");
		facebook.addUser("Sarath");
		facebook.addUser("Vikrant");
		facebook.addUser("Aditya");
		//Rohit
		facebook.makeFriends("Rohit", "Alok", 100);
		facebook.makeFriends("Rohit", "Aditya", 50);
		facebook.makeFriends("Rohit", "Sarath", 200);
		
		List<Vertex> rohitFriends = facebook.getConnections("Rohit");
		System.out.println("Rohit Friend List:"+rohitFriends);
		assertEquals(3,rohitFriends.size());
		
		assertFalse(facebook.unFriend("Rohit", "Vikrant"));
		assertTrue(facebook.unFriend("Rohit", "Aditya"));
		
		rohitFriends = facebook.getConnections("Rohit");
		System.out.println("Rohit Friend List:"+rohitFriends);
		assertEquals(2,rohitFriends.size());
	}
	
	@Test
	public void testRemoveUser(){
		
		facebook.addUser("Rohit");
		facebook.addUser("Alok");
		facebook.addUser("Sarath");
		facebook.addUser("Vikrant");
		facebook.addUser("Harish");
		facebook.addUser("Aditya");
		facebook.addUser("Manmohan");
		facebook.addUser("Aish");
		
		//Rohit
		facebook.makeFriends("Rohit", "Alok", 100);
		facebook.makeFriends("Rohit", "Aditya", 50);
		facebook.makeFriends("Rohit", "Sarath", 200);
		facebook.makeFriends("Rohit", "Vikrant", 60);
		facebook.makeFriends("Rohit", "Harish", 30);
		facebook.makeFriends("Rohit", "Aditya", 30);
		facebook.makeFriends("Rohit", "Aish", 250);
		
		//Alok
		facebook.makeFriends("Alok", "Manmohan", 100);
		facebook.makeFriends("Alok", "Aditya", 100);
		facebook.makeFriends("Alok", "Sarath", 100);
		facebook.makeFriends("Alok", "Vikrant", 100);
		facebook.makeFriends("Alok", "Manmohan", 100);
		
		System.out.println("Before");
		for(Vertex vertex: facebook.graph){
			
			System.out.println(vertex.getId() +"-->"+facebook.getConnections(vertex));
		}
		
		facebook.removeUser("Rohit");
		
		System.out.println("After");
		for(Vertex vertex: facebook.graph){
			
			System.out.println(vertex.getId() +"-->"+facebook.getConnections(vertex));
		}
	}
}
