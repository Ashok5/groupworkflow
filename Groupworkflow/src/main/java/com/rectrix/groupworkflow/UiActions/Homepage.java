package com.rectrix.groupworkflow.UiActions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {
	
	WebDriver driver;
	
	String user = "admin1";
	String pass = "admin1";
	
	
	@FindBy(id="User_Name_Validate") WebElement userID;
	@FindBy(id="password") WebElement passID;
	@FindBy(id="disabledsubmit") WebElement lgnButton;
	@FindBy(xpath="//a[contains(@href,'logout')]") WebElement logout;
	
	@FindBy(id="adminnav") WebElement adminNav;
	@FindBy(id="loginapp") WebElement userMang;

	
	public Homepage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void login(){
		
		userID.clear();
		userID.sendKeys(user);
		passID.clear();
		passID.sendKeys(pass);
		lgnButton.click();
		
	}
	
	public void logout() {
		
		logout.click();
		
	}
}
