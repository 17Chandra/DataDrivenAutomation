package org.automation.assertions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Verify {

	public static boolean validateElementIsSelected(WebDriver driver, String locType, String locValue) {

		boolean result = false;
		try {

			if (locType.equalsIgnoreCase("xpath")) {

				result = driver.findElement(By.xpath(locValue)).isSelected();

			} else if (locType.equalsIgnoreCase("id")) {

				result = driver.findElement(By.id(locValue)).isSelected();

			} else if (locType.equalsIgnoreCase("name")) {

				result = driver.findElement(By.name(locValue)).isSelected();

			}

		} catch (Exception e) {

		}

		return result;

	}

	public static boolean validateElementIsEnabled(WebDriver driver, String locType, String locValue) {

		boolean result = false;
		try {

			if (locType.equalsIgnoreCase("xpath")) {

				result = driver.findElement(By.xpath(locValue)).isEnabled();

			} else if (locType.equalsIgnoreCase("id")) {

				result = driver.findElement(By.id(locValue)).isEnabled();

			} else if (locType.equalsIgnoreCase("name")) {

				result = driver.findElement(By.name(locValue)).isEnabled();

			}

		} catch (Exception e) {

		}

		return result;

	}

	public static boolean validateElementIsDisplayed(WebDriver driver, String locType, String locValue) {

		boolean result = false;
		try {

			if (locType.equalsIgnoreCase("xpath")) {

				result = driver.findElement(By.xpath(locValue)).isDisplayed();

			} else if (locType.equalsIgnoreCase("id")) {

				result = driver.findElement(By.id(locValue)).isDisplayed();

			} else if (locType.equalsIgnoreCase("name")) {

				result = driver.findElement(By.name(locValue)).isDisplayed();

			}

		} catch (Exception e) {

		}

		return result;

	}

	public static boolean validationURL(WebDriver driver, String expURL) {

		boolean result = false;
		try {

			if (driver.getCurrentUrl().equalsIgnoreCase(expURL)) {

				result = true;

			}
		} catch (Exception e) {
		

		}

		return result;

	}

	public static boolean validatePageTitle(WebDriver driver, String expTitle) {

		boolean result = false;

		try {

			if (driver.getTitle().equalsIgnoreCase(expTitle)) {

				result = true;
			}

		} catch (Exception e) {

		}

		return result;

	}

	public static String validateTextPresentOnElement(WebDriver driver, String locType, String locValue) {

		String actValue = "";
		// Check condition first - Element NOT found. if we are not able to found the
		// element, then direct execute catch exception code.
		try {

			if (locType.equalsIgnoreCase("xpath")) {
				actValue = driver.findElement(By.xpath(locValue)).getText();

			} else if (locType.equalsIgnoreCase("id")) {
				actValue = driver.findElement(By.id(locValue)).getText();

			} else if (locType.equalsIgnoreCase("name")) {
				actValue = driver.findElement(By.name(locValue)).getText();

			}
// Check second condition- Element Found but Text mismatch

		} catch (Exception e) {
		}
		// Check third condition- Element Found and Text match
		return actValue;

	}

	public static boolean validateTextOnPage(WebDriver driver, String expValue) {

		boolean result = false;
		try {
			if (driver.getPageSource().contains(expValue)) {

				result = true;

			}
		} catch (Exception e) {

		}

		return result;

	}

	public static boolean validateElementExists(WebDriver driver, String locType, String locValue) {

		boolean result = false;

		try {
			if (locType.equalsIgnoreCase("xpath")) {

				driver.findElement(By.xpath(locValue));

			} else if (locType.equalsIgnoreCase("id")) {

				driver.findElement(By.id(locValue));
			} else if (locType.equalsIgnoreCase("name")) {

				driver.findElement(By.name(locValue));

			}

			result = true; // this line will NOT execute if the element will not found. It will through
							// catch exceptions.

		} catch (Exception e) {

		}

		return result;

	}

	public static boolean validateAttribute(WebDriver driver, String locType, String locValue, String attributeName,
			String expValue) {

		boolean result = false;
		String value = "";

		try {
			if (locType.equalsIgnoreCase("xpath")) {

				value = driver.findElement(By.xpath(locValue)).getAttribute(attributeName);
			} else if (locType.equalsIgnoreCase("id")) {

				value = driver.findElement(By.id(locValue)).getAttribute(attributeName);
			}

			else if (locType.equalsIgnoreCase("name")) {

				value = driver.findElement(By.name(locValue)).getAttribute(attributeName);

			}

			if (value.equalsIgnoreCase(expValue)) {

				result = true;

			}

		} catch (Exception e) {
		}

		return result;
	}

}
