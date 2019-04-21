package com.yash.manager;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {

	private static DriverManager driverM;

	private String name;

	private DriverManager() {

		System.out.println("Driver manager initiated");
	}

	public static DriverManager getDriverManagerInstance() {

		if (null == driverM) {
			driverM = new DriverManager();
		}
		return driverM;
	}
	
	public void setName(String name){
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
