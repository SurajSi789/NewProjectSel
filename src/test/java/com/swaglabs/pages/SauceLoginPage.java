package com.swaglabs.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SauceLoginPage extends BasePage {
	
	public SauceLoginPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id="user-name")
	private WebElement username;
	
	public void addUsername(String user) {
		username.sendKeys(user);
	}
	
	@FindBy(name="password")
	private WebElement password;
	
	public void addPassword(String pass) {
		password.sendKeys(pass);		
	}
	
	@FindBy(xpath="//input[@id='login-button']")
	private WebElement logBtn;
	
	public void clickLoginButton() {
		logBtn.click();		
	}

}
