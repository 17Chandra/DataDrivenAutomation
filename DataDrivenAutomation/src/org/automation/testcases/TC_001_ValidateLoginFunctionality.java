package org.automation.testcases;

import java.io.IOException;
import org.automation.base.DriverInstance;
import org.automation.datagenerators.Datagenerator;
import org.automation.pages.LoginPage;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

//@Listeners(org.automation.listener.ModifyListener.class)
public class TC_001_ValidateLoginFunctionality extends DriverInstance {

	@Test(dataProvider = "Excel", dataProviderClass = Datagenerator.class)
	public void LoginFunctionality(String email, String pass) throws IOException {

		LoginPage login = new LoginPage(driver);
		login.enterEmail(email);
		login.enterPassword(pass);
		login.clicLogin();
		login.clicLogout();

	}

}
