package com.swaglabs.stepDefinition;

import static org.junit.Assert.assertEquals;
import java.io.IOException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.swaglabs.driverSetup.DriverSetup;
import com.swaglabs.pages.SauceLoginPage;
import com.swaglabs.parameters.ExcelReader;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;

public class SwagLabsStepDef {
	
	static WebDriver driver;
	ExcelReader er;
	DriverSetup setup;
	SauceLoginPage pf;
	
	public SwagLabsStepDef() {
		er = new ExcelReader();
	}
	
	@Given("User is on the Login Page")
	public void user_is_on_the_login_page() throws IOException {
	    setup = new DriverSetup();
	    driver = setup.getDriver();
	    pf = new SauceLoginPage(driver);
	}
	
	@When("User enters username")
	public void user_enters_username() {
		List<String> cred = er.excelReaderMethod("00");
	    pf.addUsername(cred.get(0));
	}
	
	@And("User enters password")
	public void user_enters_password() {
		List<String> credentials= er.excelReaderMethod("00");
		
		pf.addPassword(credentials.get(1));
	}
	
	@And("User clicks on Login button")
	public void user_clicks_on_login_button() {
	    pf.clickLoginButton();
	}
	
	@Then("User is redirected to Product page")
	public void user_is_redirected_to_product_page() {
		String productHeading = driver.findElement(By.className("product_label")).getText();
		assertEquals("Products", productHeading);
	}

	@When("User enters invalid {string}")
	public void user_enters_invalid(String user) {
		List<String> credentials= er.excelReaderMethod(user);
	    pf.addUsername(credentials.get(0));	
	}
	
	@Then("User will get a error message")
	public void user_will_get_a_error_message() {
		String errorText = driver.findElement(By.tagName("h3")).getText();
		assertEquals("Epic sadface: Username and password do not match any user in this service", errorText);
	}
	
	@AfterStep
	public static void tearDown(Scenario scenario) {
        final byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot, "image/png", scenario.getName());
    }
	
	@After
	public static void closeBrowser() {
		driver.quit();
	}

}
