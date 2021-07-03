package com.chatak.qa.test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.NoSuchElementException;

import com.chatak.base.*;
import com.chatak.qa.pages.LoginPage;

public class LoginTest extends Base {
	
	LoginPage loginPage;
	
	public LoginTest(){
		super();
	}

		@BeforeMethod
		public void initialize() throws IOException
		{
					
			initializeDriver();
			driver.get(prop.getProperty("url"));
			loginPage = new LoginPage(driver);	
		}

		@Test(description = "Verify whether user is able to Login with invalid Username and valid Password")
		public void LoginTC003(){
			 loginPage.UserNameClick().sendKeys("root1");
			 loginPage.PasswordClick().sendKeys("Girmiti@123");
			 loginPage.SubmitButtonClick().click();
			 String errtitle=loginPage.UsrnameErrMesg().getText();
			 Assert.assertEquals(errtitle, "Please enter valid username");
		}


		@Test(description = "Verify whether user is able to Login with valid Username and invalid Password")
		public void LoginTC004(){
			 loginPage.UserNameClick().sendKeys("root123");
			 loginPage.PasswordClick().sendKeys("Girmiti");
			 loginPage.SubmitButtonClick().click();
			 String errtitle=loginPage.PwdErrorMesg().getText();
			 Assert.assertEquals(errtitle, "Wrong password, please enter appropriate password.You have2 attempt(s) left.");
		}
		 
		@Test(description = "Verify whether user is able to Login with invalid Username and invalid Password")
		public void LoginTC005(){
			 loginPage.UserNameClick().sendKeys("root1");
			 loginPage.PasswordClick().sendKeys("Girmit123");
			 loginPage.SubmitButtonClick().click();
			 String errtitle=loginPage.UsrnameErrMesg().getText();
			 Assert.assertEquals(errtitle, "Please enter valid username"); 
		}
		
		@Test(description = "Verify whether user is able to login without passing any values to username and password fields")
		public void LoginTC006(){
			 loginPage.UserNameClick().sendKeys("");
			 loginPage.PasswordClick().sendKeys("");
			 loginPage.SubmitButtonClick().click();
			 String errtitle=loginPage.NoUnameErrMsg().getText();
			 Assert.assertEquals(errtitle, "Username is required ");
			
		}	

		@Test(description = "Verify whether user is able to login with blank Username and Valid Password")
		public void LoginTC007(){
			 loginPage.UserNameClick().sendKeys("");
			 loginPage.PasswordClick().sendKeys("Girmit@123");
			 loginPage.SubmitButtonClick().click();
			 String errtitle=loginPage.NoUnameErrMsg().getText();
			 Assert.assertEquals(errtitle, "Username is required ");	
		}	
		
		
		@Test(description = "Verify whether user is able to login with valid Username and blank Password")
		public void LoginTC008(){
			 loginPage.UserNameClick().sendKeys("root123");
			 loginPage.PasswordClick().sendKeys("");
			 loginPage.SubmitButtonClick().click();
			 String errtitle=loginPage.NoPwdErrMsg().getText();
			 Assert.assertEquals(errtitle, "Password is required ");
		}

		@Test(description = "Verify the error message when a blocked user is trying to login")
		public void LoginTC013(){
			 loginPage.UserNameClick().sendKeys("bro123");
			 loginPage.PasswordClick().sendKeys("Girmiti@1");
			 loginPage.SubmitButtonClick().click();
			 String errtitle=loginPage.BlockErrMesg().getText();
			 Assert.assertEquals(errtitle, "Your account is suspended. Please contact administrator.");
		}

		@Test(description = "Verify whether user is able to login, when user is in suspended status")
		public void LoginTC015(){
			 loginPage.UserNameClick().sendKeys("bro123");
			 loginPage.PasswordClick().sendKeys("Girmiti@1");
			 loginPage.SubmitButtonClick().click();
			 String errtitle=loginPage.BlockErrMesg().getText();
			 Assert.assertEquals(errtitle, "Your account is suspended. Please contact administrator.");
		}

		@Test(description = "Verify whether user is able to login, when user is in deleted")
		public void LoginTC016(){
			 loginPage.UserNameClick().sendKeys("bro123");
			 loginPage.PasswordClick().sendKeys("Girmiti@1");
			 loginPage.SubmitButtonClick().click();
			 String errtitle=loginPage.BlockErrMesg().getText();
			 Assert.assertEquals(errtitle, "Your account is suspended. Please contact administrator.");
		}
		
		@Test(description = "Verify the application behavior after clicking on Refresh button")
		public void LoginTC_017(){
			 loginPage.UserNameClick().sendKeys("root123");
			 loginPage.PasswordClick().sendKeys("Girmiti@12");
			 loginPage.SubmitButtonClick().click();
			 driver.navigate().refresh();
			 String errtitle=loginPage.LoginHeader().getText();
			 Assert.assertEquals(errtitle, "Login");
		}

		 @Test(description = "Verify whether user is able to Login with valid Username and Password")
		public void LoginTC002(){
			 loginPage.UserNameClick().sendKeys("root123");
			 loginPage.PasswordClick().sendKeys("Girmiti@12");
			 loginPage.SubmitButtonClick().click();
			 String errtitle=loginPage.WelcomeMsg().getText();
			 Assert.assertEquals(errtitle, "Welcome root123");
		}
		 
		 
			@AfterMethod
			public void tearDown(){
				driver.quit();
			}
}
