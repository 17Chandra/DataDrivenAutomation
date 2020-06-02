package org.automation.base;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.automation.assertions.Verify;
import org.automation.utility.CaptureScreenshot;
import org.automation.utility.Utility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class DriverInstance {

	public WebDriver driver;
	

	@BeforeMethod
	public void initiateDriverInstance() throws IOException {

		if (Utility.fetchPropertyValue("BrowserName").equalsIgnoreCase("Chrome")) {

			System.setProperty("webdriver.chrome.driver",
					"C:\\Apps for install\\Selenium\\WebDriver\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (Utility.fetchPropertyValue("BrowserName").equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Apps for install\\Selenium\\WebDriver\\g.exe");
			driver = new ChromeDriver();

		} else {

			System.setProperty("webdriver.chrome.driver",
					"C:\\Apps for install\\Selenium\\WebDriver\\chromedriver.exe");
			driver = new ChromeDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(Utility.fetchPropertyValue("Application_URL"));
		// static method directly call by class name. NOt need to create object.

		//boolean result = Verify.validatePageTitle(driver, Utility.fetchPropertyValue("expectedPageTitle"));
		//Assert.assertTrue(result, "Home page title  doesn't match");
		//CaptureScreenshot.takeScreenshot(driver, "EnterDataFailed");

	}

	@AfterMethod
	public void closeDriverInstance() {

		driver.quit();

	}

}
