package com.swaglabs.pages;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	static WebDriver driver;
	
	/* Created by: Suraj Singh
	 * This is the method to initialize the page factory*/
	public BasePage(WebDriver driver) {
		BasePage.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void waitMethod(int time, WebElement ele) {
		WebDriverWait wb = new WebDriverWait(driver,Duration.ofSeconds(time));
		wb.until(ExpectedConditions.visibilityOf(ele));
	}
}
