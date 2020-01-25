package com.automationPractice.TestCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.automationPractice.BaseTest.TestBase;
import com.automationPractice.Pages.HomePage;
import com.automationPractice.Pages.MorePage;
import com.automationPractice.Pages.MyAccountPage;
import com.automationPractice.Pages.SignInPage;

public class HomePageTest extends TestBase {

	HomePage homepage;
	SignInPage signInPage;
	MyAccountPage myAccountPage;
	MorePage morePage;

	@BeforeMethod
	public void setup() {

		initialization();
		homepage = new HomePage();
		signInPage=homepage.gotoSignIn();
		signInPage.userSignIn(config.getProperty("username"), config.getProperty("password"));
		myAccountPage = new MyAccountPage();
		myAccountPage.navigateToHomePage();
	}

	@Test
	public void verifyMoreBtn() throws InterruptedException {
		
		morePage =homepage.viewMoreInfoOfRandomProduct();
		Thread.sleep(3000);
	}
	

	@AfterMethod
	public void teardown() {

		quitBrowser();
	}

}
