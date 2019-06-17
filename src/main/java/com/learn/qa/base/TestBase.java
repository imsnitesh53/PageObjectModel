package com.learn.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.learn.qa.util.WebEventListener;
import com.learn.qa.util.TestUtil;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	public  static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;

	
	public TestBase()
	{
		//Fetch the all the info from properties file and code use any where you want to use another project
		try {
			prop = new Properties();
		    //FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "C:/Users/nitesh/workspace/onlinetestingsite/src/main/java/com/learn/qa/config/config.properties");
			FileInputStream ip = new FileInputStream("C:/Users/nitesh/workspace/onlinetestingsite/src/main/java/com/learn/qa/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//C:/
	}
	
	//Browser launch code 
	public static void initialization(){
		String browserName = prop.getProperty("browser");
		
		if(browserName.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", "C:/Users/nitesh/workspace/webdriver/chromedriver.exe");	
			driver = new ChromeDriver(); // launch chrome
		}
		else if(browserName.equals("FF")){
			System.setProperty("webdriver.gecko.driver", "C:/Users/nitesh/workspace/geckodriverexe");	
			driver = new FirefoxDriver(); // launch mozila
		}
		
		
		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		
	
	//other things which we are using in the repetively 
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
	
	driver.get(prop.getProperty("url"));
}

}
