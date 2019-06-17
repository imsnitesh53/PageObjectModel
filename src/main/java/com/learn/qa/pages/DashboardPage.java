package com.learn.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.learn.qa.base.TestBase;

public class DashboardPage extends TestBase {
	
	//FindBy anotation declaire
		@FindBy(xpath="//a[contains(text(),'Login1')]")
		WebElement Login;
		

		@FindBy(xpath="//a[contains(@class,'navbar-brand header-logo')]")
		WebElement lernlogo;
		
		
		
		//Initializing the Page Objects:
		public DashboardPage(){
			PageFactory.initElements(driver, this);
		}
		
		
		//Actions:
		    public LoginPage login()
		    {
		    	Login.click();
		    	
		    	return new LoginPage();
		    }
		
			public String validateLoginPageTitle1(){
				return driver.getTitle();
			}
			
			public boolean validatelearnImage(){
				return lernlogo.isDisplayed();
			}
			
		

}
