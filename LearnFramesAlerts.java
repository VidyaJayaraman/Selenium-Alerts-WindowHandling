package week4.day1;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnFramesAlerts {

	public static void main(String[] args) {
		
		
		// Chrome Setup and Disable Browser Notifications
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-notifications");
		
		// Launch URL
				
        ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_prompt");
	    driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
				
		//Accept Cookies
						
		driver.findElement(By.id("accept-choices")).click();
		
		// Enter into frames
		
		WebElement frameElement = driver.findElement(By.xpath("//iframe[@id='iframeResult']"));
		driver.switchTo().frame(frameElement);
		
		// Click on Try it
		
		driver.findElement(By.xpath("//h2[text()='JavaScript Prompt']/following-sibling::button")).click();
		
		//Enter into Alert
		
		Alert alert = driver.switchTo().alert();
		String text = alert.getText();
		System.out.println("Alert Text"+text);
		alert.sendKeys("vidya");
		alert.accept();
		String text2 = driver.findElement(By.xpath("//h2[text()='JavaScript Prompt']/following-sibling::p")).getText();
        if(text2.contains("vidya"))
        {
        	System.out.println("Alert validation Successful");
        }
	}
 
}
