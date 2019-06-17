package com.learn.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.learn.qa.base.TestBase;
import com.learn.qa.pages.DashboardPage;
import com.learn.qa.pages.HomePage;
import com.learn.qa.pages.LoginPage;
import com.learn.qa.pages.LoginPageNewCre;
import com.learn.qa.util.TestUtil;

public class LoginPageNewCreTest extends TestBase {
	
	LoginPageNewCre loginpagenewcre;
	HomePage  homePage;
	DashboardPage dashboard;
	TestUtil testutil;
	
	String sheetname = "sheet1";
	
	
	
	public LoginPageNewCreTest(){
		super();
	}
	
	
	@BeforeMethod
	public void setUp(){
		initialization();
		loginpagenewcre = new LoginPageNewCre();
		dashboard = new DashboardPage();
		dashboard.login();
	}
	
	/*
	@Test(priority=1)
	public void clickloginbutton()
	{
		loginpage.login();
	}*/
	
	
	@Test(priority=1)
	public void loginPageTitleTest(){
		String title1 = loginpagenewcre.validateLoginPagenewTitle();
		Assert.assertEquals(title1, "Email Address", "Home Page titile is not matched" );
	}
	
	@Test(priority=2)
	public void crmLogoImageTest(){
		boolean flag = loginpagenewcre.validatelearnImage2();
		Assert.assertTrue(flag);
	}
	
	
	//Data read from excel code below written
	@DataProvider
	public Object[][] getCRMTestData(){
		Object data[][] = TestUtil.getTestData(sheetname);
		return data;
	}
	
	@Test(priority=3, dataProvider="getCRMTestData")
	public void loginTest1(String uname, String pword){
		//loginpagenewcre.login2(prop.getProperty("username"), prop.getProperty("password"));
		//loginpage.login1();
		loginpagenewcre.login2(uname, pword);
	}
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	

}
