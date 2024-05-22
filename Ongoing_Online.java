package sample;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Ongoing_Online {

	public static void main(String[] args) throws InterruptedException {
		
		//Open Browser
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
		
		//DashBoard page 
		//Click On demand consultation
		driver.findElement(By.xpath("(//div[@class='card consult-typecard'])[1]")).click();		
		Thread.sleep(2000);
		
		//Ongoing
		driver.findElement(By.xpath("(//div[@class='text-center mt-2'])[1]")).click();
		Thread.sleep(2000);
		String ongoingAppointmentCount=driver.findElement(By.xpath("(//div[@class='card type-card'])[1]//span")).getText();
		System.out.println(ongoingAppointmentCount);
		if(ongoingAppointmentCount.equals("0"))
		{
			System.out.println(driver.findElement(By.xpath("(//p[@class='patient-waiting-fontsize'])[1]")).getText());
		}
		else {			
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//button[@type='button'])[6]")).click();
		Thread.sleep(2000);
		//Click Setting button
		driver.findElement(By.cssSelector("div[role='Settings']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//li[@role='presentation']/a[1]")).click();
		Thread.sleep(2000);
		//Connection setting
		WebElement DSP, RD, TTM, Mode;//Dominant Speaker Priority, Render Dimension (Low Priority), Track TransferOff Mode:
		
		
		}

	}

}
