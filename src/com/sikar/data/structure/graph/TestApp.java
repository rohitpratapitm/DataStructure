package com.sikar.data.structure.graph;

public class TestApp {

	public static void  main(String args[]){
		
		Graph facebook = new Graph();
		
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

		System.out.println(facebook.suggestFriends("Manmohan"));
		
	}
}
