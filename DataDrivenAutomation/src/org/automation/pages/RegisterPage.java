package org.automation.pages;

import java.io.IOException;

import org.automation.utility.CaptureScreenshot;
import org.automation.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class RegisterPage {

	WebDriver driver;

	public RegisterPage(WebDriver driver) {

		this.driver = driver;

	}

	public void clickRegister() throws IOException {

		try {

			driver.findElement(By.xpath(Utility.fetchElementValue("register_but"))).click();

		} catch (Exception e) {

			System.out.println("****************Exception********************");
			e.printStackTrace();
			CaptureScreenshot.takeScreenshot(driver, "EnterDataFailed");
		}

	}

	public void enterEmail(String email) throws IOException {

		try {

			driver.findElement(By.xpath(Utility.fetchElementValue("register_email"))).sendKeys(email);

		} catch (Exception e) {

			System.out.println("****************Exception********************");
			e.printStackTrace();
			CaptureScreenshot.takeScreenshot(driver, "EnterDataFailed");
		}

	}

	public void enterPassword(String passNew) throws IOException {

		try {

			driver.findElement(By.xpath(Utility.fetchElementValue("register_password"))).sendKeys(passNew);
		} catch (Exception e) {

			System.out.println("****************Exception********************");
			e.printStackTrace();
			CaptureScreenshot.takeScreenshot(driver, "EnterDataFailed");
		}

	}

	public void enterPasswordAgain(String passAgain) throws IOException {

		try {

			driver.findElement(By.xpath(Utility.fetchElementValue("register_confirm_password"))).sendKeys(passAgain);

		} catch (Exception e) {

			System.out.println("****************Exception********************");
			e.printStackTrace();
			CaptureScreenshot.takeScreenshot(driver, "EnterDataFailed");
		}

	}

	public void clickAgreeCheckbox() throws IOException {

		try {

			driver.findElement(By.xpath(Utility.fetchElementValue("register_agree_checkbox"))).click();

		} catch (Exception e) {

			System.out.println("****************Exception********************");
			e.printStackTrace();
			CaptureScreenshot.takeScreenshot(driver, "EnterDataFailed");
		}

	}

	public void clickRegisterforNewAccount() throws IOException {

		try {

			driver.findElement(By.xpath(Utility.fetchElementValue("register_button"))).click();

		} catch (Exception e) {

			System.out.println("****************Exception********************");
			e.printStackTrace();
			CaptureScreenshot.takeScreenshot(driver, "EnterDataFailed");
		}

	}

}
