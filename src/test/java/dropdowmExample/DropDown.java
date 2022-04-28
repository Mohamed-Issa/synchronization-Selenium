package dropdowmExample;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class DropDown {
	
	
	
	public static void main(String args[]) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		
	
		
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		Select drpCountry = new Select(driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency")));
		drpCountry.selectByIndex(2);
		
		
	
		System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
		System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));

		if (driver.findElement(By.id("Div1")).getAttribute("style").contains("1")) {
			System.out.println("it's enable");
			Assert.assertTrue(true);
		} else Assert.assertTrue(false);
		
		
		
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.xpath("//a[@value='BLR']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id=\"glsctl00_mainContent_ddl_destinationStation1_CTNR\"] //a[@value='MAA']")).click();
		
	    //div[@id="glsctl00_mainContent_ddl_destinationStation1_CTNR"] //a[@value='MAA']
		//driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();
			
		
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-hover")).click();	
		
		
		
			
		driver.findElement(By.id("autosuggest")).sendKeys("ind");
		Thread.sleep(3000);	
		List<WebElement> options = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
		for (WebElement option : options) {
			if (option.getText().equalsIgnoreCase("india")) {
				option.click();
				break;
			}
		}
		
		
		
		Assert.assertFalse(driver.findElement(By.cssSelector("input[id*=chk_friendsandfamily")).isSelected());
	
		driver.findElement(By.cssSelector("input[id*=chk_friendsandfamily")).click();
		Assert.assertTrue(driver.findElement(By.cssSelector("input[id*=chk_friendsandfamily")).isSelected());
	
		Assert.assertEquals(driver.findElements(By.cssSelector("input[type='checkbox'")).size(), 6);
	
		
		
		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(2000);
		for (int i=0; i<4 ; ++i) {
			driver.findElement(By.id("hrefIncAdt")).click();
		}
		driver.findElement(By.id("btnclosepaxoption")).click();
		
	
		
		driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();
		

		
	}

}
