package com.yash.Data;


import com.yash.manager.DriverManager;
import com.yash.manager.FileManager;


public class TestContext {
	
	private FileManager f ;
	private DriverManager d;
	
	public TestContext(){
		
		f= new FileManager("fileName");
		d =  DriverManager.getDriverManagerInstance();
	}
	
	public FileManager getFileManager(){
		return f;
	}
	

	public DriverManager getDriverManager(){
		return d;
	}
	
}
