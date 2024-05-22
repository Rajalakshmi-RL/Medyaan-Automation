package sample;

import java.sql.Time;
import java.util.Set;

import javax.swing.Action;
import javax.swing.plaf.basic.BasicSliderUI.ActionScroller;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class OnDemandWaiting {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.get("https://development.Medyaan.com");
		Thread.sleep(2000);
		driver.manage().window().maximize();
		Thread.sleep(2000);
				
		//Click sign up button
		driver.findElement(By.id("__BVID__19__BV_toggle_")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//a[@class='dropdown-item'])[1]")).click();
		Thread.sleep(2000);
		
		//Doctor Sign In page
		driver.findElement(By.cssSelector("input[name='phone']")).sendKeys("8148528062");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("input[name='password']")).sendKeys("Admin@123");
		Thread.sleep(2000);
		driver.findElement(By.className("login-button-box")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//div[@class='card consult-typecard'])[1]")).click();		
		Thread.sleep(2000);
		
		//Waiting
		driver.findElement(By.xpath("(//div[@class='text-center mt-2'])[2]//span")).click();
		String waitingAppointmentCount=driver.findElement(By.xpath("(//div[@class='text-center mt-2'])[2]//span")).getText();
		Thread.sleep(2000);
		if(waitingAppointmentCount.contains("0"))
		{
			driver.findElement(By.xpath(""));
		}
		else
		{
			WebElement waiting=driver.findElement(By.xpath("(//button[@class='btn primary-btn view-btn-size btn-secondary'])[9]"));
			JavascriptExecutor waitingJS=(JavascriptExecutor)driver;
			waitingJS.executeScript("arguments[0].scrollIntoView()", waiting);
			driver.findElement(By.xpath("(//button[@class='btn primary-btn view-btn-size btn-secondary'])[9]")).click();
			Thread.sleep(2000);
		}
		driver.findElement(By.xpath("//button[@class='btn col-4 view-ehrbtn viewehr_btn btn-secondary']")).click();	
	    JavascriptExecutor js=(JavascriptExecutor)driver;
	    js.executeScript("window.scrollBy(0,300)");
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//a[text()='Medical History']")).click();
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//a[text()='Surgery History']")).click();
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//a[text()='Family History']")).click();
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//a[text()='Allergies']")).click();
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//a[text()='Medications']")).click();
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//a[text()='Life Style']")).click();
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//a[text()='Reports']")).click();
	    Thread.sleep(2000);
	    WebElement scrol=driver.findElement(By.xpath("//b[text()='Name']"));
	    JavascriptExecutor scrolJS=(JavascriptExecutor)driver;
	    scrolJS.executeScript("arguments[0].scrollIntoView()",scrol);
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("(//button[@type='button'])[3]")).click();
	    Thread.sleep(2000);
	    //Click Accept
	    driver.findElement(By.xpath("(//button[@type='button'])[6]")).click();
	    Thread.sleep(2000);
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    

	}

}
