package tests;

import org.openqa.selenium.WebDriver;

public class CloseBrowser {
	
	WebDriver driver ;
	
	public void closeBrowser(WebDriver driver)
	{
		this.driver = driver ; 
		
		driver.close();
	}

}
