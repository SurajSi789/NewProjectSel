package com.swaglabs.runner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/resources/Features", 
glue= {"stepDefinition"},
plugin= {"pretty", // Designing the reports
		"html:reports/cucumber_report.html", // BDD Report
	    "json:target/myjson.json", // Json report
	    "junit:target/Cucumber.xml", // BDD report in XML format
	    "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"} // Extent Report
)

public class TestNGRunnerParallel extends AbstractTestNGCucumberTests {
	
	@Override
	@DataProvider(parallel=true)
	public Object[][] scenarios(){
		return super.scenarios();
	}
	
}