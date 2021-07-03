package com.chatak.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.chatak.base.*;

public class LoginPage extends Base {

	 WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
		this.driver=driver;
		
	}

		@FindBy(xpath="//span[normalize-space()='Please enter valid username']")
		WebElement UsernameErrMesg;
		
		@FindBy(xpath="//input[@id='ackU']")
		WebElement UserName;
		
		@FindBy(xpath="//input[@id='ackP']")
		WebElement Password;
		
		@FindBy(xpath="//input[@id='loginSubmit']")
		WebElement SubmitButton;		
		
		@FindBy(xpath="//span[contains(text(),'Wrong password, please enter appropriate password.')]")
		WebElement PwdErrorMesg;
		
		@FindBy(xpath="//span[@id='errorMsgUsername']")
		WebElement NoUnameErrMsg;
		
		@FindBy(xpath="//span[@id='errorMsgpassword']")
		WebElement NoPwdErrMsg;
	
		@FindBy(xpath="//span[contains(text(),'Your account is suspended. Please contact administ')]")
		WebElement BlockErrMesg;
		
		@FindBy(xpath="//td[normalize-space()='Welcome root123']")
		WebElement WelcomeMsg;

		@FindBy(xpath="//h3[normalize-space()='Login']")
		WebElement LoginHeader;
		

		
		public WebElement UserNameClick() {
		return UserName;	}
	
		public WebElement PasswordClick() {
		return Password;
		}
	
		public WebElement SubmitButtonClick() {
		return SubmitButton;
		}
		
		public WebElement UsrnameErrMesg() {
		return UsernameErrMesg;
		}	
		
		public WebElement PwdErrorMesg() {
		return PwdErrorMesg;
		}	
		
		public WebElement NoUnameErrMsg() {
		return NoUnameErrMsg;
		}		
		
		public WebElement NoPwdErrMsg() {
		return NoPwdErrMsg;
		}	
		
		public WebElement BlockErrMesg() {
		return BlockErrMesg;
		}

		public WebElement WelcomeMsg() {
		return WelcomeMsg;
		}
		
		public WebElement LoginHeader() {
		return LoginHeader;
		}
		
	}
