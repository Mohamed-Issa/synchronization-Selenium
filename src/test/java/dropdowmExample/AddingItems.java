package dropdowmExample;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AddingItems {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		WebDriverWait driverWait = new WebDriverWait(driver,Duration.ofSeconds(5));

		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

		String[] items = { "Brocolli", "Cauliflower", "Cucumber", "Beetroot" };

		addItems(driver, items);

		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		driver.findElement(By.xpath("//*[contains(text(), 'PROCEED TO CHECKOUT')]")).click();
		
		driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promoCode")));

		driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");

		driver.findElement(By.cssSelector("button.promoBtn")).click();
		
		
		
		driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
		
		
		System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());
		Assert.assertEquals(driver.findElement(By.cssSelector("span.promoInfo")).getAttribute("style")
				.equalsIgnoreCase("color: green;"), true);
		
		

	}

	public static void addItems(WebDriver driver, String[] items) {
		int j = 0;
	
		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));

		for (int i = 0; i < products.size(); ++i) {

			String name = products.get(i).getText().split("-")[0].trim();
			// String formattedName = name[0].trim();

			List<String> itemsList = Arrays.asList(items);

			if (itemsList.contains(name)) {
				++j;
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				if (j == items.length)
					break;
			}
		}

	}

}
