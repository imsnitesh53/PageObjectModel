package com.learn.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.learn.qa.base.TestBase;
import com.learn.qa.pages.DashboardPage;
import com.learn.qa.pages.HomePage;
import com.learn.qa.pages.LoginPage;

public class DashboardPageTest extends TestBase {
	
	DashboardPage dashboard;
	LoginPage loginpage;
	
	
	
	public DashboardPageTest(){
		super();
	}
	
	
	@BeforeMethod
	public void setUp(){
		initialization();
		dashboard = new DashboardPage();	
	}
	
	@Test(priority=3)
	public void clickloginbutton()
	{
		 dashboard.login();
	}
	
	
	@Test(priority=1)
	public void loginPageTitleTest1(){
		String title = dashboard.validateLoginPageTitle1();
		Assert.assertEquals(title, "Welcome to Let's Kode It");
	}
	
	@Test(priority=2)
	public void learnLogoImageTest1(){
		boolean flag = dashboard.validatelearnImage();
		Assert.assertTrue(flag);
	}
	


}
