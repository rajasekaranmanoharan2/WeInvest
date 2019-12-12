package com.qa.test;

import java.io.IOException;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.qa.base.TestBase;
import com.qa.pages.Testpage;

public class TestB extends TestBase
{			
	@Test  	
	public void doInvest() throws IOException, InterruptedException
	{	
		Testpage tp = PageFactory.initElements(driver, Testpage.class); 					
		tp.doTaskB();		
	}		
}
