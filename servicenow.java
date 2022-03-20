package week4Day1Assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class servicenow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Step1: Load ServiceNow application URL
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.get("https://dev77120.service-now.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		
		
		//Step2: Enter username (Check for frame before entering the username)
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.id("user_name")).sendKeys("admin");
		
		
		//Step3: Enter password 
		
		driver.findElement(By.id("user_password")).sendKeys("yaO6DqerR6SK");
		//Step4: Click Login
		driver.findElement(By.id("sysverb_login")).click();
		//Step5: Search “incident “ Filter Navigator
		driver.findElement(By.id("filter")).sendKeys("incident");
		driver.findElement(By.id("filter")).sendKeys(Keys.ENTER);
		//Step6: Click “All”
		driver.findElement(By.xpath("(//div [text() = 'All'])[2]")).click();
		//Step7: Click New button
		
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.xpath("//button [@id = 'sysverb_new']")).click();
		
		//Step8: Select a value for Caller and Enter value for short_description
		
		driver.findElement(By.xpath("//button[@id = 'lookup.incident.caller_id']")).click();
		//Step9: Read the incident number and save it a variable
		//Step10: Click on Submit button
		//Step 11: Search the same incident number in the next search screen as below
		//Step12: Verify the incident is created successful and take snapshot of the created incident.
	}

}
