package com.learn.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.learn.qa.pages.HomePage;
import com.learn.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	//FindBy anotation declaire
	@FindBy(xpath="//a[contains(text(),'Login')]")
	WebElement Login;
	
	
	@FindBy(xpath="//input[@type='email']")
	WebElement username;
	
	@FindBy(xpath="//input[@type='password']")
	WebElement password;
	

	@FindBy(xpath="//input[@value='Log In']")
	WebElement Signin;

	@FindBy(xpath="//a[contains(@class,'navbar-brand header-logo')]")
	WebElement lernlogo;
	
	
	
	//Initializing the Page Objects:
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	
	
	//Actions:
	    public void login()
	    {
	    	Login.click();
	    }
	
		public String validateLoginPageTitle(){
			return driver.getTitle();
		}
		
		public boolean validateCRMImage(){
			return lernlogo.isDisplayed();
		}
		
		public HomePage login1(String un, String pwd){
			username.sendKeys(un);
			password.sendKeys(pwd);
			Signin.click();
			    	//JavascriptExecutor js = (JavascriptExecutor)driver;
			    	//js.executeScript("arguments[0].click();", loginBtn);
			    	
			return new HomePage();
		}
}
