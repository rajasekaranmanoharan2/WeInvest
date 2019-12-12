package com.qa.pages;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Testpage 
{
	  WebDriver driver;
	  String tab1;
	  String tab2;
	  String tabRec1;
  	  String tabOth2;
	  
	  public Testpage(WebDriver driver)
	  { 
	            this.driver=driver; 
	  }		

	@FindBy(xpath="//a[@data-id='79' and text()='Explore Investment Ideas']") 
	WebElement btnAllWeatherStrategy;
	
	@FindBy(xpath="//div[@class='col-xs-6']/a[text()= 'Customize Portfolio']") 
	WebElement btnCustomizePortifolio;	
	
	@FindBy(xpath="//div[@class='col-md-2']/a[text()='Customise']")
	WebElement btnCustomize;	
	
	@FindBy(xpath="//div[@class='col-md-2'][2]/a")
	WebElement btnReset;
	
	@FindBy(xpath="//div[@class='col-md-6'and text()='US EQUITIES']/following::div[1]/div/a")
	WebElement btnAddStock;
	
	@FindBy(xpath="//a[text()='BT Group plc']/following::div[@class='col-md-3 text-center'][2]/button[@data-allocation-name='US EQUITIES']")
	WebElement btnAddStockBT;
	
	@FindBy(xpath="//*[@id='modal-1']/div/div/div[3]/button")
	WebElement btnDone;		
	
	@FindBy(xpath="//*[@id='customise-portfolio']/div/div[2]/div/div[3]/div/div[15]/div[3]/a")
	WebElement btGroup;		
	
	@FindBy(xpath="//a[@data-toggle='tab' and contains(text(),'Portfolio recommendations based on your preferences')]")
	WebElement tabPortfolio;	
	
	@FindBy(xpath="//a[@data-toggle='tab' and contains(text(),'other portfolio')]")
	WebElement tabOtherPortfolio;
	
	@FindBy(xpath="//*[@id='page-top']/div[3]/section/div[2]/div[3]/ul[2]/li[1]/a")
	WebElement tabRecom;
	
	@FindBy(xpath="//*[@id='page-top']/div[3]/section/div[2]/div[3]/ul[2]/li[2]/a")
	WebElement tabOthers;
	
    public void clickAllWeatherStrategy()
    {
    	btnAllWeatherStrategy.click();     	
    }

    
    public void clickCustPortifoloio()
    {
    	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    	btnCustomizePortifolio.click();
    }

  
    public void clickCustomize()
    {
    	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    	btnCustomize.click();   	
    }    
    
    public void readText()
    {
    	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    	String getText = btnReset.getText();
    	
    	if(getText.contains("Reset"))
    	{
    		System.out.println("Text changed to “Reset”");
    	}  
    } 
    
    public void clickAddStock()
    {
    	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    	btnAddStock.click();  	
    }  
    
    public void clickAddStockBT()
    {
    	WebDriverWait wait=new WebDriverWait(driver, 20);
    	WebElement btnAddStockBT;
    	btnAddStockBT= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath( "//a[text()='BT Group plc']/following::div[@class='col-md-3 text-center'][2]/button[@data-allocation-name='US EQUITIES']")));    			   
    	btnAddStockBT.click();
     	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    	btnDone.click();    	
    } 
    
    public void checkBTGroupAdded()
    {
    	WebDriverWait wait=new WebDriverWait(driver, 20);
    	WebElement btGroup1;
    	btGroup1= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath( "//*[@id='customise-portfolio']/div/div[2]/div/div[3]/div/div[15]/div[3]/a")));
    	
    	String txt = driver.findElement(By.xpath("//*[@id='customise-portfolio']/div/div[2]/div/div[3]/div/div[15]/div[3]/a")).getText(); 	
    	System.out.println(txt);
    	if(txt.contains("BT Group plc"))
    	{
    		System.out.println("Test B done");
    	}
    	else
    	{
    		System.out.println("Test B not done");
    	}
    	
     }  
    
    public void checkTabs()
    {    	
    	String tab3= tabPortfolio.getText();
    	String tab4 = tabOtherPortfolio.getText();
    	
    	tab1= tab3.replaceAll("\\D", "");
    	tab2 =tab4.replaceAll("\\D", "");    	  
		
    	if(tab1.contains("Portfolio recommendations"))
    	{
    		System.out.println("Step 2.a Pass");
    	}
    	
    	if(tab2.contains("other portfolio"))
    	{
    		System.out.println("Step 2.b Pass");
    	}
     }  
    
        
    public void resizeBrowser()
    {
    	Dimension d = new Dimension(375,667);
      	driver.manage().window().setSize(d);    	
     } 
    
    
    public void checkResizeTabs()
    {
		String tabRec= tabRecom.getText();
    	String tabOth = tabOthers.getText();       	
    	tabRec1 = tabRec.replaceAll("\\D", "");
     	tabOth2 = tabOth.replaceAll("\\D", "");
     }  

    public void checkXY()
    {    
    	if(Integer.parseInt(tab1)==Integer.parseInt(tabRec1))
    	{
       		if(Integer.parseInt(tab2)==Integer.parseInt(tabOth2))
        	{
        		System.out.println("Step 4 Pass");
        	}    		    		
    	}    	
     }  
    
    public void doTaskB() throws IOException, InterruptedException
	{		    	   	
    	this.clickAllWeatherStrategy();
    	this.clickCustPortifoloio();
    	this.clickCustomize();
    	this.readText();
    	this.clickAddStock();
    	this.clickAddStockBT();
    	this.checkBTGroupAdded();      
  	} 
    
    public void doTaskC() throws IOException, InterruptedException
  	{	
    	this.checkTabs();
    	this.resizeBrowser();
    	this.checkResizeTabs();
    	this.checkXY();
  	}
}
