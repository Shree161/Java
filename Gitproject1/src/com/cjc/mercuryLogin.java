package com.cjc;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class mercuryLogin {
	WebDriver driver;
	@BeforeSuite
	  public void openBrowser()
	  {
		System.out.println("BeforeSuite");
		  System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\91862\\\\Desktop\\\\Selenium\\\\chromedriver_win32\\\\chromedriver.exe");
		 driver =new ChromeDriver();
		 System.out.println("open chrome browser");
		 System.out.println("==============");
		
	  }
	@BeforeTest
	  public void openUrl() 
	  {
		System.out.println("BeforeTest");
		  driver.get("https://demo.guru99.com/test/newtours/login.php");
			System.out.println("open mercury login page");
			System.out.println("==============");
	 }
	  @BeforeClass
	  public void maximizeBrowser()
	  {
		    System.out.println("BeforeClass");
			driver.manage().window().maximize();
			System.out.println("maximaze screen");
			System.out.println("==============");
			
	  }
	  @BeforeMethod
	  public void getCookies()
	  {
		  System.out.println("Beforemethod");
		  Set<Cookie> co=driver.manage().getCookies();
		  	int count=co.size();
			System.out.println("count no of cookies: "+count);
			System.out.println("==============");
	  }
	 @Parameters({"un","pass"}) 
	 @Test
	  public void loginCheck(String uname,String ps ) throws InterruptedException 
	  {
		 System.out.println("Test");
		 driver.findElement(By.name("userName")).sendKeys(uname);
			System.out.println("entered username suceessful");
			
			driver.findElement(By.name("password")).sendKeys(ps);
			System.out.println("entered password suceessful");
			
			driver.findElement(By.name("submit")).click();
			System.out.println("submit button");
			Thread.sleep(1000);
			System.out.println("==============");
	  }


  @AfterMethod
  public void captureScreen() throws IOException
  {
	  System.out.println("Aftermethod");
		File scr=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFileToDirectory(scr, new File("C:\\Users\\91862\\Desktop\\Selenium\\Screenshot"));
		System.out.println("Screenshot of mercury page");
		System.out.println("==============");
  }



  @AfterClass
  public void deleteCookies()
  {
	  System.out.println("AfterClass ");
	  driver.manage().deleteAllCookies();
	  Set<Cookie> co1=driver.manage().getCookies();
	  int count1=co1.size();
	  System.out.println("count after delete cookies: "+count1);
	  System.out.println("==============");
	  
  }

  

  @AfterTest
  public void dbClose()
  {
	  System.out.println("AfterTest ");
	  System.out.println("==============");
  }

  

  @AfterSuite
  public void browserClose()
  {
	  driver.close();
	  System.out.println("AfterSuite");
	  System.out.println("==============");
	  
	  
  }
}
