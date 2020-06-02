package org.automation.testcases;

import java.io.IOException;

import org.automation.base.DriverInstance;
import org.automation.datagenerators.Datagenerator;
import org.automation.pages.RegisterPage;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

//@Listeners(org.automation.listener.ModifyListener.class)
public class TC_002_RegisterAccount extends DriverInstance {
	
	@Test (dataProvider="Excel", dataProviderClass= Datagenerator.class)
	public void RegisterNewAccount(String email, String passNew, String passAgain) throws IOException {
		
		RegisterPage registerPage = new RegisterPage (driver);
		
		registerPage.clickRegister();
		registerPage.enterEmail(email);
		registerPage.enterPassword(passNew);
		registerPage.enterPasswordAgain(passAgain);
		registerPage.clickRegisterforNewAccount();
		
	}
	
	

}
