package week4Day1Assignment;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonOneplusShopping {

	public static void main(String[] args) {
		//1.Load the uRL https://www.amazon.in/
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	    //2.search as oneplus 9 pro 
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Oneplus pro9");
		driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
	    //3.Get the price of the first product
		List<WebElement> AllResults=driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
		String First_Result=AllResults.get(0).getText();
		System.out.println(First_Result);
		List<WebElement>price=driver.findElements(By.xpath("//span[@class='a-price-whole']"));
		String price_firstresult=price.get(0).getText();
		System.out.println("price of " + First_Result +" is  " +price_firstresult);
		//4. Print the number of customer ratings for the first displayed product
		List<WebElement>No_of_Ratings=driver.findElements(By.xpath("//span[@class='a-size-base s-underline-text']"));
		String Rating_for_firstresult=No_of_Ratings.get(0).getText();
		System.out.println("No_of_Ratings for" + First_Result + "are   " + Rating_for_firstresult);
		//5. click on the stars 
		List<WebElement>No_of_stars=driver.findElements(By.xpath("//i[@class='a-icon a-icon-star-small a-star-small-4-5 aok-align-bottom']"));
		Actions builder = new Actions(driver);
		builder.moveToElement(No_of_stars.get(0)).click().perform();
		String globalratings=driver.findElement(By.xpath("//span[@class='a-size-base a-color-secondary totalRatingCount']")).getText();
		System.out.println("No of globalratings  " +globalratings);
		//No_of_stars.get(0).click();
		//System.out.println("clicked on the first stars");
		//6. Get the percentage of ratings for the 5 star.
		WebElement rating_table = driver.findElement(By.xpath("//table[@id='histogramTable']"));
		List<WebElement> ratingtable_Rows= rating_table.findElements(By.tagName("tr"));
		
		for(int i=0;i<ratingtable_Rows.size();i++)
		{
			
			List<WebElement> ratingtable_column= driver.findElements(By.tagName("td"));
			String five_starratingpercent= ratingtable_column.get(i).getText();
			if(five_starratingpercent.contains("%"))
			{
				System.out.println("Percentage of 5 star rating is   " +five_starratingpercent);
				break;
			}
			
		}
		
		//7. Click the first text link of the first image
		
		WebElement first_Result=driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[1]"));
		
		first_Result.click();
		Set<String> Windowhandles= driver.getWindowHandles();
		Iterator<String> iterator = Windowhandles.iterator();
		String parentwindow = iterator.next();
		String childwindow = iterator.next();
		driver.switchTo().window(childwindow);
		//8. Click 'Add to Cart' button
		driver.findElement(By.id("add-to-cart-button")).click();
		
		
		//9. Get the cart subtotal and verify if it is correct
		driver.switchTo().window(parentwindow);
		
		String cartValue = driver.findElement(By.xpath("(//span [@class = 'a-size-medium a-color-base sc-price sc-white-space-nowrap'])[1]")).getText();
		System.out.println("The Cart Value is : " +cartValue);
		if  (cartValue.contains(price_firstresult)) 
		  {
		  System.out.println("cart is corretcly updated"); 
		  }

	}

}
