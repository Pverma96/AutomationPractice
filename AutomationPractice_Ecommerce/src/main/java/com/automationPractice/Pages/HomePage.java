package com.automationPractice.Pages;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automationPractice.BaseTest.TestBase;

public class HomePage extends TestBase {

	@FindBy(css = "a.login")
	private WebElement signin;

	@FindBy(xpath = "//ul[@id='homefeatured']//li//span[contains(text(),'More')]")
	private List<WebElement> moreBtn;

	public HomePage() {

		PageFactory.initElements(driver, this);
	}

	public SignInPage gotoSignIn() {

		signin.click();
		return new SignInPage();
	}

	public MorePage viewMoreInfoOfRandomProduct() {

		Random random = new Random();
		int randomProduct = random.nextInt(moreBtn.size());
		
		//moreBtn is hidden. So using JavaScript Executor.
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", moreBtn.get(randomProduct));
		
		

		return new MorePage();
	}

}
