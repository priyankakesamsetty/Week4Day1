package week4Day1Assignment;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LaernALertsandFrames {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//open url
		
		WebDriverManager.chromedriver().setup(); 
		ChromeDriver driver=new ChromeDriver(); 
		driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_confirm");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
	   //Click Try It Button
		driver.switchTo().frame("iframeResult");
		driver.findElement(By.xpath("//button [text() = 'Try it']"));
		//Click OK/Cancel in the alert
		Alert alert = driver.switchTo().alert();
		alert.accept();
		
		//Confirm the action is performed correctly by verifying the text !!
		String text = driver.findElement(By.xpath("//p [@id = 'demo']")).getText();
		System.out.println(text);
		driver.close();
	   //Hint

		//Switch to the frame
			//Then click Try It with xpath
			//Switch to the alert
			//Then perform accept / dismiss
			//Get the text using id 
			//Verify the text based on the action

	}

}
