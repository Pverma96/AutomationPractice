/**
 * 
 */
package com.automationPractice.BaseTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.automationPractice.Utilities.ExcelReader;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;



/**
 * @author vermap6
 *
 */
public class TestBase {
	
	

	public static WebDriver driver;
	public static Properties config;
	private static FileInputStream fis;
	public static ExcelReader excel = new ExcelReader(System.getProperty("user.dir")+"\\src\\test\\resources\\excel\\testdata.xlsx");
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest test;
	
	

	public static void initialization() {

		config = new Properties();
		try {
			fis = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\main\\java\\com\\automationPractice\\config\\Config.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			config.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (config.getProperty("browser").equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\chromedriver.exe");
			driver = new ChromeDriver();

		} else if (config.getProperty("browser").equals("Firefox")) {

			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\chromedriver.exe");
			driver = new FirefoxDriver();
		}

		driver.get(config.getProperty("baseUrl"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

	}

	public static void quitBrowser() {

		driver.quit();

	}


}
