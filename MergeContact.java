package week4Day1Assignment;

import java.time.Duration;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContact {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		
		//login
		  WebElement name=  driver.findElement(By.id("username"));
	       name.sendKeys("Demosalesmanager");
	       WebElement password =driver.findElement(By.id("password"));
	       password.sendKeys("crmsfa");
	       WebElement login =driver.findElement(By.className("decorativeSubmit"));
	       login.click();
	       driver.findElement(By.linkText("CRM/SFA")).click();
	       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	       //contacts
	       driver.findElement(By.xpath("//a[(text()='Contacts')]")).click(); 
	       driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();
	     WebElement tabledata=  driver.findElement(By.xpath("//table[@name='ComboBox_partyIdFrom']"));
	     System.out.println(tabledata);       
	     driver.findElement(By.xpath("//img[@alt='Lookup']")).click();
	     //switchtonewwindow
	     //String firstwindow = driver.getWindowHandle();
	     //System.out.println("parent window"+firstwindow);
	     Set <String > allwindows= driver.getWindowHandles();
	     System.out.println(allwindows);
	     Iterator <String> I1 = allwindows.iterator();
	     String parent_window =I1.next();
	     System.out.println(parent_window);
	     
	     String second_window=I1.next();
	     System.out.println(second_window);
	     
	     driver.switchTo().window(second_window);
	     System.out.println("switched to second window");
	     //List<String>allwindowslist= new ArrayList<String>(allwindows);
	    //driver.switchTo().window(allwindowslist.get(1));
	    Thread.sleep(100);
	    driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a)[1]")).click();
	
	    //switchbacktohomewindow
	    driver.switchTo().window(parent_window);
	   
	    driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]")).click();
	    //switchtonewwindow
	    //Thread.sleep(300);
	    //Set <String > allwindows1= driver.getWindowHandles();
	     //System.out.println(allwindows1);
	    // List<String>allwindowslist1= new ArrayList<String>(allwindows1);
	   // driver.switchTo().window(allwindowslist1.get(1));
	    Set<String> Second_Iterationwindows= driver.getWindowHandles();
	    Iterator<String> I2= Second_Iterationwindows.iterator();
	    String Firsttwindow=I2.next();
	    String secondwindow=I2.next();
	    driver.switchTo().window(secondwindow);
	    		Thread.sleep(200);
	    driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a)[2]")).click();
	    driver.switchTo().window(Firsttwindow);
	    driver.findElement(By.xpath("//a[@class='buttonDangerous']")).click();
	    driver.switchTo().alert().accept();
	    System.out.println("contatcs are merged");
	    System.out.println(driver.getTitle());
	     }

}
