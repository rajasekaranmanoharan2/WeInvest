package com.qa.base;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase 
{	
	public static WebDriver driver = null;
	
	@BeforeTest
	public void browserSetup()
	{								
		WebDriverManager.chromedriver().setup();
		 
        driver = new ChromeDriver();
				
	    driver.manage().window().maximize();
	    
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);  
	    
	    driver.navigate().to("https://sfo-demo.herokuapp.com/model-portfolio");
				
	}
	
	@AfterTest
	public void afterSuite()
	{
		driver.quit();
	}

}