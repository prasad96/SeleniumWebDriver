package tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.ProductPage;

public class TestPriceRange {
	WebDriver driver ;
	JavascriptExecutor js = (JavascriptExecutor)driver ;
	
	@Test
	public void SetPriceRange() throws Exception
	{
		driver = new FirefoxDriver () ;
		OpenBrowser browser = new OpenBrowser(driver) ;
		ProductPage productPrice = new ProductPage(driver) ;
		HomePage homepage = new HomePage(driver) ;
		
		browser.openBrowser("http://flipkart.com");
		
		driver.manage().window().maximize();
		
		Thread.sleep(2000);
		Actions build = new Actions (driver);
		
		build.moveToElement(homepage.getElectronics_Lnk()).perform();
		
		Thread.sleep(2000);
		
		build.moveToElement(homepage.getSamsung_Lnk()).click().perform();
		
		Thread.sleep(2000);
		
		Assert.assertEquals("Mobiles",productPrice.getproductName_Lbl().getText()) ;
		
		// set min price
		productPrice.getminPrice_DrpDwn().click();
		
		Select minPrice = new Select (productPrice.getminPrice_DrpDwn());
		
		minPrice.selectByValue("2000"); 
		
		// set max price
		productPrice.getmaxPrice_DrpDwn().click();
		
		Select maxPrice = new Select (productPrice.getmaxPrice_DrpDwn());
		
		maxPrice.selectByValue("10000");
		
		//Assert.assertEquals("2000-10000",productPrice.getpriceFilter_Lnk().getText() );			 
			
			
			WebDriverWait wait = new WebDriverWait(driver,20);

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='_1vC4OE _2rQ-NK']")));
			
			System.out.println("element located");
			 List<WebElement> priceLinks = (List<WebElement>) driver.findElements(By.xpath("//div[@class='_1vC4OE _2rQ-NK']")) ;
			
			  System.out.println("Total links are : "+priceLinks.size());
			  List<WebElement> count = driver.findElements(By.xpath("//*[@class='_33m_Yg']"));
			 // js.executeScript("window.scrollBy(0,250)", "") ;
			  
			  for (int i = 0 ; i< count.size();i++){
				  
			for (WebElement ele : priceLinks ){
				
				System.out.println("-----");
				String name = ele.getText() ;
				name = name.substring(1) ;
				name = name.replaceAll(",", "") ;
			    
			  //  System.out.println(name);
				int pricelink = Integer.parseInt(name) ;
				
				
					if (pricelink > 2000 && pricelink < 10000){
						
						System.out.println("price is in range");
						System.out.println(pricelink);				
						
					}
					else{
						System.out.println("price is out of range");
						System.out.println(name);
					}						
				
			}			
			
			  WebElement nextButton = driver.findElement(By.xpath("//*[@class='_1JKxvj _31rYcN']/div[2]"));
			  
			  js.executeScript("arguments[0].scrollIntoView();", nextButton);
			  nextButton.click();
	    }
         
			  
	}
	
}
