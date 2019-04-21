package com.yash.manager;

public class FileManager {
	
	private String name;
	
	public FileManager(String str){
		
		this.name = str;
		System.out.println("FileManager initiated");
		System.out.println("Value of name : " + str);
	
	}
	
	
	
	public String getName(){
		return name;
	}
}
