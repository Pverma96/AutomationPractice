package com.automationPractice.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automationPractice.BaseTest.TestBase;

public class SignInPage extends TestBase {

	@FindBy(css = "#email")
	private WebElement email;

	@FindBy(css = "#passwd")
	private WebElement pwd;

	@FindBy(css = "#SubmitLogin")
	private WebElement submitLogin;

	public SignInPage() {

		PageFactory.initElements(driver, this);
	}
	
	public String validateSignInPageTitle() {
		
		return driver.getTitle();
	}

	public MyAccountPage userSignIn(String username ,String password) {

		email.sendKeys(username);
		pwd.sendKeys(password);
		submitLogin.click();

		return new MyAccountPage();
	}

}
