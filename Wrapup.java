package sample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Wrapup {

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
		driver.findElement(By.id("input-85")).sendKeys("8148528062");
		Thread.sleep(2000);
		driver.findElement(By.id("input-88")).sendKeys("Admin@123");
		Thread.sleep(2000);
		driver.findElement(By.className("login-button-box")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[@class='card consult-typecard'])[1]")).click();		
		Thread.sleep(2000);
		
		//Wrapup
		driver.findElement(By.xpath("(//div[@class='text-center mt-2'])[3]//span")).click();
		String wrapupAppointmentCount=driver.findElement(By.xpath("(//div[@class='text-center mt-2'])[3]//span")).getText();
				if(wrapupAppointmentCount.contains("0"))
		{
			System.out.println(driver.findElement(By.xpath("(//p[@class='patient-waiting-fontsize'])[2]")).getText());
			
		}
		else
		{
			
		}
		

	}

}
