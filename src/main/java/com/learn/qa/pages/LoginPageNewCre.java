package com.learn.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.learn.qa.base.TestBase;

public class LoginPageNewCre extends TestBase {
	

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
		public LoginPageNewCre(){
			PageFactory.initElements(driver, this);
		}
		
		
		//Actions:
		    public void login()
		    {
		    	Login.click();
		    }
		
			public String validateLoginPagenewTitle(){
				return driver.getTitle();
			}
			
			public boolean validatelearnImage2(){
				return lernlogo.isDisplayed();
			}
			
			public HomePage login2(String uname, String pword){
				username.sendKeys(uname);
				password.sendKeys(pword);
				Signin.click();
				    	//JavascriptExecutor js = (JavascriptExecutor)driver;
				    	//js.executeScript("arguments[0].click();", loginBtn);
				    	
				return new HomePage();
			}


}
