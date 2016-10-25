package tests;

import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import pages.LoginPage;
import utility.ConfigReader;

public class LoginTest {
	
	static ConfigReader config = new ConfigReader();
	static WebDriver driver ;
	
	
	public LoginTest(WebDriver driver)
	{
		LoginTest.driver = driver ;		
	
	}
	
	@Test
	public static void login() throws Exception
	{
		
		
		/*
		 * 
		 * Chrome driver initiation
		System.setProperty("webdriver.chrome.driver", config.getChromeDriver());
		 
		ChromeOptions options = new ChromeOptions();
		
		options.addArguments("--Disable-Extensions");
		// if browser extension are there please add option to chrome driver
		driver = new ChromeDriver(options);
		
		**/
		
		//PropertyConfigurator.configure("./Properties/Log4j.properties");
		//driver = new FirefoxDriver();
		
		//log = Logger.getLogger("LoginTest");
		driver = new FirefoxDriver();
		driver.get(config.getFlipkartWebURL());
		
		//log.info("URL is opened"+config.getFlipkartWebURL());
			
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		LoginPage logn = new LoginPage(driver);
		LogOutTest lout = new LogOutTest(driver);
		
		
		
		
				//PageFactory.initElements(driver, LoginPage.class);
		
		//To initialise the excel and pick up the cell values for username and password
		logn.init();
		
		//Assert.assertEquals(log.getlogin_Lnk_Txt(), "Log In");
		
		// click on login link in home page
		logn.getlogin_Lnk();
		
		//log.info("Clicked on Loin link on home page");
		
		System.out.println("Username text is : "+logn.getlogin_Lnk_Txt());
		// enter user name
		logn.getusername_InBx();
		
		//log.info("Entered username ...");
		
		System.out.println("password text is : "+logn.getpassword_InBx_Txt());
		
		// enter password
		logn.getpassword_InBx();
		
		//log.info("Entered username ...");
		
		System.out.println("submit button text is : "+logn.gesubmit_Btn_Txt());
		
		//click on login button
		logn.gesubmit_Btn();
		
		//log.info("Clicked on Submit button ...");
		
		 //   lout.logOut();
		
		//driver.close();
	}
	

}
