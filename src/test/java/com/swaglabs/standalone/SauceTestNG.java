package com.swaglabs.standalone;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import com.swaglabs.driverSetup.DriverSetup;
import com.swaglabs.pages.SauceLoginPage;

public class SauceTestNG {

	WebDriver driver;
	SauceLoginPage sf;
	
	@BeforeMethod
	public void setUp() throws IOException {
		DriverSetup setup = new DriverSetup();
		driver = setup.getDriver();
		sf = new SauceLoginPage(driver);		
	}
	
	@Test
	public void performLogin() throws InterruptedException, IOException {
		sf.addUsername("standard_user");
		sf.addPassword("secret_sauce");
		sf.clickLoginButton();
		
		// Interface used to take the screenshot
		TakesScreenshot ts = (TakesScreenshot)driver;

		// Assingning path to store the screenshot
		String path = System.getProperty("user.dir")+"//screenshots//image.png";
		
		// To store screenshot as a file
		File src = ts.getScreenshotAs(OutputType.FILE);
		
		// Passing the end-path to File class
		File destination = new File(path);
		
		// To store the screenshot in the destination path
		FileUtils.copyFile(src, destination);
		
		
		Thread.sleep(3000);
		String productHeading = driver.findElement(By.className("product_label")).getText();
		assertEquals("Products", productHeading);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
