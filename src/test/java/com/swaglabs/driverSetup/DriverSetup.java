package com.swaglabs.driverSetup;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.swaglabs.parameters.PropertiesReader;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverSetup {

	WebDriver driver;
	
	public WebDriver getDriver() throws IOException {
		
		PropertiesReader cfs = new PropertiesReader();
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.get(cfs.getMainURL());
		driver.manage().window().maximize();
		
		return driver;
	}
	
}
