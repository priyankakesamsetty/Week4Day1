package week4Day1Assignment;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnAlertandWindowHandling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//1. Load https://www.irctc.co.in/
		WebDriverManager.chromedriver().setup(); 
		ChromeDriver driver=new ChromeDriver(); 
		driver.get("https://www.irctc.co.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		//2. Click on OK button in the dialog  
		
		driver.findElement(By.xpath("//button [text() = 'OK']")).click();
		
		//3. Click on FLIGHTS link 
		driver.findElement(By.xpath("//span [@class = 'allcircle circleone']")).click();
		 Set<String> totalWindowsHandle = driver.getWindowHandles();
		 List <String> totalWindowsHandleList = new ArrayList <String>(totalWindowsHandle);
		//4. Go to the Flights tab
		 driver.switchTo().window(totalWindowsHandleList.get(1));
		 driver.findElement(By.xpath("//button [@class ='izooto-optin--cta izooto-optin--cta-later']")).click();
		//5. Print the customer care email id
		 
		 driver.findElement(By.xpath("//a [text() = 'Contact Us']")).click();
			String email = driver.findElement((By.xpath("//a [contains (text() , '@irctc.co.in')]" ))).getText();
			System.out.println("The Customer care email id is : " +email);
		//6. Close the First tab(Train ticket booking) alone

	}

}
