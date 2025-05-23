package com.swaglabs.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/resources/Features", 
				glue= {"com.swaglabs.stepDefinition"},
				plugin= {"pretty", // Designing the reports
						"html:reports/cucumber_report.html", // BDD Report
					    "json:target/myjson.json", // Json report
					    "junit:target/Cucumber.xml", // BDD report in XML format
					    "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"} // Extent Report
)
public class TestNGRunner extends AbstractTestNGCucumberTests {
    
}
