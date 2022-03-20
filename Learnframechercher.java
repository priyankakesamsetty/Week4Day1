package week4Day1Assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Learnframechercher {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Launchbrowser
		WebDriverManager.chromedriver().setup(); 
		 ChromeDriver driver=new ChromeDriver(); 
		 driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver");
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 
		 //Enter text in Topic
		 driver.switchTo().frame("frame1");
         driver.findElement(By.xpath("//b[@id='topic']/following::input")).sendKeys("selenium");
         driver.switchTo().frame("frame3");
         driver.findElement(By.xpath("//input[@id='a']")).click();
         driver.switchTo().defaultContent();
         driver.switchTo().frame("frame2");
        WebElement animals_Drpdown = driver.findElement(By.xpath("//select[@id='animals']"));
        Select dropdown= new Select(animals_Drpdown);
        dropdown.selectByIndex(2);
	}

}
