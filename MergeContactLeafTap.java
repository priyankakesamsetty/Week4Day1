package week4Day1Assignment;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContactLeafTap {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		 //1. Launch URL "http://leaftaps.com/opentaps/control/login"
		 WebDriverManager.chromedriver().setup(); 
		 ChromeDriver driver=new ChromeDriver(); 
		 driver.get("http://leaftaps.com/opentaps/control/login");
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		 
		 //2. Enter UserName and Password Using Id Locator
		 driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
		 driver.findElement(By.id("password")).sendKeys("crmsfa");
		 
		 //3. Click on Login Button using Class Locator
		 driver.findElement(By.className("decorativeSubmit")).click();
		 
		 //4. Click on CRM/SFA Link
		 driver.findElement(By.linkText("CRM/SFA")).click();
		 
		 //5. Click on contacts Button
		 driver.findElement(By.xpath("//a [text()='Contacts']")).click();
		 
		 //6. Click on Merge Contacts using Xpath Locator
		 driver.findElement(By.xpath("//a [text()='Merge Contacts']")).click();
		 
		 //7. Click on Widget of From Contact
		 driver.findElement(By.xpath("(//img [@alt ='Lookup'])[1]")).click();
		 
		 Thread.sleep(2000);
		 
		 //8. Click on First Resulting Contact
		 driver.getWindowHandles();
		 Set<String> allWindowsHandle = driver.getWindowHandles();
		 List<String> allWindowsHandleList = new ArrayList<String>(allWindowsHandle);
		 String newWindow = allWindowsHandleList.get(1);	 
		 
		 driver.switchTo().window(newWindow);
		 System.out.println(driver.getCurrentUrl());
		 driver.manage().window().maximize();
		 String text = driver.findElement(By.xpath("(//a [@class = 'linktext'])[1]")).getText();
		 driver.findElement(By.xpath("(//a [@class = 'linktext'])[1]")).click();
		 System.out.println("Clicked :" +text);
		 
		 //Return to the main Window
		 driver.switchTo().window(allWindowsHandleList.get(0));		 
		 
		 //9. Click on Widget of To Contact
		 driver.findElement(By.xpath("(//img [@alt ='Lookup'])[2]")).click();
		 
		 Thread.sleep(2000);
		 
		 //10. Click on Second Resulting Contact
		 driver.getWindowHandles();
		 Set<String> allWindowsHandle1 = driver.getWindowHandles();
		 List <String> allWindowsHandleList1 = new ArrayList <String>(allWindowsHandle1);
		 String newWindow1 = allWindowsHandleList1.get(1);
		 
		 driver.switchTo().window(newWindow1);
		 driver.manage().window().maximize();
		 System.out.println(driver.getCurrentUrl());
		 String text1 = driver.findElement(By.xpath("(//a [@class = 'linktext'])[6]")).getText();
		 driver.findElement(By.xpath("(//a [@class = 'linktext'])[6]")).click();
		 System.out.println("Clicked :" +text1);
		 
		 //Return to the main Window
		 driver.switchTo().window(allWindowsHandleList.get(0));		 
		 
		 //11. Click on Merge button using Xpath Locator
		 driver.findElement(By.xpath("//a[text()='Merge']")).click();
		 
		 //12. Accept the Alert
		 Alert alert = driver.switchTo().alert();
		 alert.accept();
		 
		 //13. Verify the title of the page
		 System.out.println(driver.getTitle());
	}


	}

