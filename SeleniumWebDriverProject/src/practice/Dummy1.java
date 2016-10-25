package practice;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import tests.TestNewMobilePurchase;
import utility.ConfigReader;

public class Dummy1 {

	WebDriver driver ;
	ConfigReader config = new ConfigReader();
	TestNewMobilePurchase ts = new TestNewMobilePurchase(driver);
	
	
	@BeforeTest
	@Parameters({"browser"})
	
	public void setup(String browser){
		
		try{
		
		
		if (browser.equals("FF")){
			driver = new FirefoxDriver ();
			
			
			System.out.println("firefox opened");
			
		}else if (browser.equals("CH")){
			
			System.setProperty("webdriver.chrome.driver", config.getChromeDriver());
			driver = new ChromeDriver();
			
			System.out.println("Chrome opened");
			
		}else if (browser.equals("IE")){
			System.setProperty("webdriver.ie.driver", config.getIEDriver());
			driver = new InternetExplorerDriver();
			
			System.out.println("IE opened");
			
		}
		
		
		
		}catch(Exception e){
			
			System.out.println("exception occured "+e.getMessage());
		}

	}
	
	@Test
	public void setup(){
		
		driver.get("http://google.com");
	}
	
	@AfterTest
	public void closeBrowser(){
	
	driver.quit();

	}

}

