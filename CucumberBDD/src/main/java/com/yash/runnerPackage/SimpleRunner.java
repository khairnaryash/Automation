package com.yash.runnerPackage;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(glue = "com.yash.TestPackage" , features= "Features", tags = "@tag1, @tag3")
public class SimpleRunner { 

}

// Just for testing purpose and running test case in eclipse
