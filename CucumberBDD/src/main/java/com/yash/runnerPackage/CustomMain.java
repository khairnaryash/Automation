package com.yash.runnerPackage;

import com.yash.manager.RunManager;

public class CustomMain {

	public static void main(String[] argv) throws Exception {

		 RunManager.runner(Thread.currentThread().getContextClassLoader());
		 
	}
		
}