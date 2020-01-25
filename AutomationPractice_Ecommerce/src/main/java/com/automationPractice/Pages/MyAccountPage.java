package com.automationPractice.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automationPractice.BaseTest.TestBase;

public class MyAccountPage extends TestBase {
	
	

	@FindBy(xpath = "//a[@title='Home']")
	WebElement homeBtn;

	public MyAccountPage() {

		PageFactory.initElements(driver, this);
	}

	public void navigateToHomePage() {

		homeBtn.click();
		
		
	}
}
