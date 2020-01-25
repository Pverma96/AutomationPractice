package com.automationPractice.TestCases;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.automationPractice.BaseTest.TestBase;
import com.automationPractice.Pages.SearchResultPage;

public class SearchPageTest extends TestBase {

	SearchResultPage searhResultPage;

	@BeforeMethod
	public void setup() {

		initialization();
		searhResultPage = new SearchResultPage();
	}

	@Test
	public void verifySortByOptions() {
		searhResultPage.enterSearchText();
		List<WebElement> dropDownValues = searhResultPage.check_sorting_criterion();
		String[] actualSortValues = { "--", "Price: Lowest first", "Price: Highest first", "Product Name: A to Z",
				"Product Name: Z to A", "In stock", "Reference: Lowest first", "Reference: Highest first" };

		for (int i = 0; i < dropDownValues.size(); i++) {
			System.out.println(dropDownValues.get(i).getText().toString());
		}

//		for (int i = 0; i < dropDownValues.size(); i++) {
//
//			Assert.assertEquals(actualSortValues, dropDownValues.get(i).getText(), "Options doest't Match");
//		}

	}

	@Test
	public void verifyLowtoHighSorting() {
		searhResultPage.enterSearchText();
		ArrayList<String> obtainedPrice = searhResultPage.verifySorting();
		searhResultPage.selectSortOption();

		ArrayList<String> ascSortedPrice = new ArrayList<String>();

		for (WebElement we : searhResultPage.productPrice) {

			ascSortedPrice.add(we.getText());

		}
		Assert.assertTrue(obtainedPrice.equals(ascSortedPrice));

	}

	@AfterMethod
	public void teardown() {

		quitBrowser();
	}

}
