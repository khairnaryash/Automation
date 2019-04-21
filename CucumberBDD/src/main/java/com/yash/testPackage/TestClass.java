package com.yash.testPackage;

import java.util.Map;

import org.junit.Assert;

import com.yash.Data.TestContext;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * For testing purpose
 * @author Yashodeep
 *
 */
public class TestClass {

	
	private TestContext testData;

	public TestClass(TestContext data) {
		testData = data;
	}

	@Given("^I want to write a step with name as \"([^\"]*)\"$")
	public void testMethod1(String name) {
		System.out.println("Inside method testMethod1, name passed : " + name);
		System.out.println("File initiated : " + testData.getFileManager().getName());
		System.out.println("Driver name : " + testData.getDriverManager().getName());
	}

	
	@When("^I complete action$")
	public void testMethod2() {
		System.out.println("Inside method testMethod2");
	}

	@And("^some other action$")
	public void testMethod3() {
		System.out.println("Inside method testMethod3");
	}

	@And("^yet another action$")
	public void testMethod4() {
		System.out.println("Inside method testMethod4");
	}

	@Then("^I validate the outcomes$")
	public void testMethod5() {
		System.out.println("Inside method testMethod5");
	}

	@Given("^User is on Home Page$")
	public void userIsOnHomePage() throws Throwable {
		System.out.println("Inside method userIsOnHomePage ");
	}

	@When("^User Navigate to LogIn Page$")
	public void userNavigateToLogInPage() throws Throwable {
		System.out.println("Inside method userNavigateToLogInPage ");
	}

	@And("^User enters Credentials to LogIn$")
	public void userEntersCredentialsToLogIn(DataTable table) throws Throwable {
		System.out.println("Inside method userNavigateToLogInPage ");
		// List<List<String>> data = table.raw();
		// System.out.println("User name : " +data.get(0).get(0));
		// System.out.println("User password : " +data.get(0).get(1));

		// List<UserData> userData = table.asList(UserData.class);
		// System.out.println("User name : " +userData.get(0).getName());
		// System.out.println("User password : "
		// +userData.get(0).getPassword());

		Map<String, String> data = table.asMap(String.class, String.class);
		System.out.println("User name : " + data.get("name"));
		System.out.println(data.get("testuser_1"));
		System.out.println(data.get("testuser_2"));

	}

	@Then("^Message displayed Login Successfully$")
	public void messageDisplayedLoginSuccessfully() throws Throwable {
		System.out.println("Inside method messageDisplayedLoginSuccessfully ");
		// throw new Exception();
		Thread.sleep(2000);
		Assert.assertTrue("**********failing this test case********", false);

	}
	

}
