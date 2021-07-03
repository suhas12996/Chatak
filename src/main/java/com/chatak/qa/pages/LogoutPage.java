package com.chatak.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage {
	
	 WebDriver driver;
		
	public LogoutPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
		this.driver=driver;
		
	}
	
	  	@FindBy(xpath="//input[@id='ackU']")
	  	WebElement UserName;
	
	  	@FindBy(xpath="//input[@id='ackP']")
	  	WebElement Password;
	  	
		@FindBy(xpath="//input[@id='loginSubmit']")
		WebElement SubmitButton;	

		@FindBy(xpath="//a[normalize-space()='Logout']")
		WebElement Logout;
		
		@FindBy(xpath="//label[@class='font-style-text']")
		WebElement LogoutMsg;
		
		@FindBy(xpath="//a[normalize-space()='Click here to Login again']")
		WebElement LoginLinkAftrLogout;
		
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
		
		public WebElement Logout() {
		return Logout;	}
		
		public WebElement LogoutMsg() {
		return LogoutMsg;	}
		
		public WebElement LoginLinkAftrLogout() {
		return LoginLinkAftrLogout;	}
		
		public WebElement LoginHeader() {
		return LoginHeader;
		}

}
