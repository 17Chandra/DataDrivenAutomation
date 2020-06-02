package org.automation.pages;

import java.io.IOException;

import org.automation.assertions.Verify;
import org.automation.utility.CaptureScreenshot;
import org.automation.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {

		this.driver = driver;

	}

	public void enterEmail(String email) throws IOException {

		try {
			driver.findElement(By.xpath(Utility.fetchElementValue("login_email"))).sendKeys(email);

		} catch (Exception e) {

			System.out.println("****************Exception********************");
			e.printStackTrace();
			CaptureScreenshot.takeScreenshot(driver, "EnterDataFailed");

		}

	}

	public void enterPassword(String pass) throws IOException {

		try {

			driver.findElement(By.xpath(Utility.fetchElementValue("login_password"))).sendKeys(pass);
		} catch (Exception e) {

			System.out.println("****************Exception********************");
			e.printStackTrace();
			CaptureScreenshot.takeScreenshot(driver, "EnterDataFailed");

		}

	}

	public void clicLogin() throws IOException {

		try {

			driver.findElement(By.xpath(Utility.fetchElementValue("login_button"))).click();

			// boolean result = Verify.validateTextOnPage(driver,
			// Utility.fetchPropertyValue("Expected_TextOnPage"));
			// Assert.assertTrue(result);
		}

		catch (Exception e) {
			System.out.println("************Exception*************");
			e.printStackTrace();
			CaptureScreenshot.takeScreenshot(driver, "EnterDataFailed");

		}

	}

	public void clicLogout() throws IOException {

		try {
			
			driver.findElement(By.xpath(Utility.fetchElementValue("logout_button"))).click();

		}

		catch (Exception e) {
			System.out.println("************Exception*************");
			e.printStackTrace();
			CaptureScreenshot.takeScreenshot(driver, "EnterDataFailed");

		}

	}

}
