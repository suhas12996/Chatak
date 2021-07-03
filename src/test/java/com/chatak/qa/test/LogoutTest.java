package com.chatak.qa.test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.chatak.base.Base;
import com.chatak.qa.pages.LogoutPage;

public class LogoutTest extends Base {
	
	
	LogoutPage logoutpage;
	
	public LogoutTest(){
		super();
	}

	    @BeforeMethod
		public void initialize() throws IOException
		{
					
			initializeDriver();
			driver.get(prop.getProperty("url"));
			logoutpage = new LogoutPage(driver);	
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		}
		
		@Test(description = "Verify the application behavior when user click on Logout button.")
		public void LogoutTC001(){
			logoutpage.UserNameClick().sendKeys("kkr1");
			logoutpage.PasswordClick().sendKeys("Girmiti@1");
			logoutpage.SubmitButtonClick().click();
			logoutpage.Logout().click();
			String errtitle=logoutpage.LogoutMsg().getText();
			Assert.assertEquals(errtitle, "You have successfully logged out Click here to Login again");
		}
		
		@Test(description = "Verify user is able to navigate to login screen by clicking on the Login link available in the screen after successful logout")
		public void LogoutTC002(){
			logoutpage.UserNameClick().sendKeys("kkr1");
			logoutpage.PasswordClick().sendKeys("Girmiti@1");
			logoutpage.SubmitButtonClick().click();
			logoutpage.Logout().click();
			logoutpage.LoginLinkAftrLogout().click();
			String errtitle=logoutpage.LoginHeader().getText();
			Assert.assertEquals(errtitle, "Login");
		}
		
		@Test(description = "Verify the application behavior when user clicks on browser back button after successful logout.")
		public void LogoutTC003(){
			logoutpage.UserNameClick().sendKeys("kkr3");
			logoutpage.PasswordClick().sendKeys("Girmiti@1");
			logoutpage.SubmitButtonClick().click();
			logoutpage.Logout().click();
			driver.navigate().back();
			String errtitle=logoutpage.LogoutMsg().getText();
			Assert.assertEquals(errtitle, "You have successfully logged out Click here to Login again");
		}
		 
		@Test(description = "Verify whether UI components are visible after logout")
		public void LogoutTC005(){
			logoutpage.UserNameClick().sendKeys("kkr4");
			logoutpage.PasswordClick().sendKeys("Girmiti@1");
			logoutpage.SubmitButtonClick().click();
			logoutpage.Logout().click();
			String errtitle=logoutpage.LogoutMsg().getText();
			Assert.assertEquals(errtitle, "You have successfully logged out Click here to Login again");
		}
		
		
			@AfterMethod
			public void tearDown(){
				driver.quit();
			}


}
