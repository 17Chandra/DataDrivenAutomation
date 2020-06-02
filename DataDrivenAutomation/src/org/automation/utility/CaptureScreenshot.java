package org.automation.utility;

import java.io.File;
import java.util.Calendar;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

public class CaptureScreenshot {

	static String filename = null;

	public static void takeScreenshot(WebDriver driver, String name) {
		try {
			Calendar c = Calendar.getInstance();
			TakesScreenshot screenshot = (TakesScreenshot) driver;
			filename = "./Screenshots/" + name + c.getTime().toString().replace(":", "").replace(" ", "") + ".png";
			File f = screenshot.getScreenshotAs(OutputType.FILE);
			File fd = new File(filename); // File is a class.
			

			FileUtils.copyFile(f, fd); // FileUtils is a class from apache.commons.io.downloaded in maven POM.
		} catch (Exception e) {
			System.out.println("Not able to takescreenshot");

		}

		attachScreenshotToReport();

	}

//attach screenshot to reportNG
	public static void attachScreenshotToReport() {

		try {
			System.setProperty("org.uncommons.reportng.escape-output", "false");
		
			File f = new File(filename);
			Reporter.log("<br>  <img src='" + f.getAbsolutePath() + "' height='100' width='100' /><br>");
			Reporter.log("<a href=" + f + "></a>");
		} catch (Exception e) {

			System.out.println("Not able to attach screenshot");

		}

	}
}
