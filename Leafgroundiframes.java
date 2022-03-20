package week4Day1Assignment;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Leafgroundiframes {

	public static void main(String[] args) {
		//Launch URL
	
		WebDriverManager.chromedriver().setup(); 
		ChromeDriver driver=new ChromeDriver(); 
		driver.get("http://leafground.com/pages/frame.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		//Find the number of frames
	 List<WebElement>iframes =driver.findElements(By.tagName("iframe"));	
	 System.out.println("No of iframes in the website are"  +iframes.size());
	 driver.close();
		 // - find the Elements by tagname - iframe
		 // - Store it in a list
		  //- Get the size of the list. (This gives the count of the frames visible to the main page)


	}

}
