package com.yash.testPackage;

import java.util.concurrent.TimeUnit;

import com.yash.Data.TestContext;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class CucumberHooks {

	private TestContext testData;

	public CucumberHooks(TestContext data) {
		testData = data;
	}

	/**
	 * Runs before every scenario
	 * 
	 * @param scn
	 */
	@Before
	public void init(Scenario scn) {

		System.out.println("******* Runing Scenario : " + scn.getName() + " ********");

		
//		testData.getFileManager()
		testData.getDriverManager().setName("Chrome driver");;
	}

	/**
	 * Runs after every scenario
	 * 
	 * @param scn
	 */
	@After
	public void tearDown(Scenario scn) {
		System.out.println("********* Scenario Execution Finished : " + scn.getName() + " ***********");
		System.out.println("Status : " + scn.getStatus());
		System.out.println("Closing driver");
	}


}
