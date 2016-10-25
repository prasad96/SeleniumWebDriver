package tests;

import org.openqa.selenium.WebDriver;

public class OpenBrowser {
	
	WebDriver driver ;
	
	public OpenBrowser (WebDriver driver)
	{
		this.driver = driver ;
	}
	public void openBrowser(String url)
	{
		driver.get(url);
		
		System.out.println(driver.getCurrentUrl()+" opened success fully");
	}

}
