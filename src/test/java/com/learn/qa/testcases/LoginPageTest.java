
package com.learn.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.learn.qa.pages.DashboardPage;
import com.learn.qa.pages.HomePage;
import com.learn.qa.pages.LoginPage;
import com.learn.qa.base.TestBase;

public class LoginPageTest extends TestBase {
	
	LoginPage loginpage;
	HomePage  homePage;
	DashboardPage dashboard;
	
	
	
	public LoginPageTest(){
		super();
	}
	
	
	@BeforeMethod
	public void setUp(){
		initialization();
		loginpage = new LoginPage();
		dashboard = new DashboardPage();
		loginpage = dashboard.login();
	}
	
	/*
	@Test(priority=1)
	public void clickloginbutton()
	{
		loginpage.login();
	}*/
	
	
	@Test(priority=1)
	public void loginPageTitleTest(){
		String title1 = loginpage.validateLoginPageTitle();
		Assert.assertEquals(title1, "Email Address", "Home Page titile is not matched" );
	}
	
	@Test(priority=2)
	public void crmLogoImageTest(){
		boolean flag = loginpage.validateCRMImage();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3)
	public void loginTest(){
		loginpage.login1(prop.getProperty("username"), prop.getProperty("password"));
		//loginpage.login1();
	}
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
}
