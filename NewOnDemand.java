package sample;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NewOnDemand {
	
	public static void main(String[] args) throws InterruptedException, AWTException {
		
		
		WebDriver driver= new ChromeDriver();
		
		driver.get("https://development.medyaan.com/");
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
		
		//Reset Password- click back button
		driver.findElement(By.xpath("//div[@class='text-end']/button")).click();
		Thread.sleep(3000);
		
		//DashBoard page - Click On demand consultation
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
		driver.findElement(By.xpath("(//div[@class='mt-3']/button[@class='btn primary-btn continue-btn-size btn-secondary'])[1]")).click();
		Thread.sleep(2000);
		}
		
     	//Appointment page - Click EHR
		driver.findElement(By.xpath("//a[text()='EHR']")).click();
		Thread.sleep(2000);

	/*	//Click vitals
		driver.findElement(By.xpath("(//div[@class='row emraccordionrow'])[1]")).click();
		Thread.sleep(2000);
		//Click Edit button
		driver.findElement(By.xpath("(//button[@type='button'])[1]")).click();
		Thread.sleep(2000);
		//Click Blood pressure systolic (mm Hg)
		driver.findElement(By.xpath("(//input[@class='profile-input  form-control'])[1]")).clear();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@class='profile-input  form-control'])[1]")).sendKeys("110");
		Thread.sleep(2000);
		//Click Blood pressure diastolic (mm Hg)
		driver.findElement(By.xpath("(//input[@class='profile-input  form-control'])[2]")).clear();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@class='profile-input  form-control'])[2]")).sendKeys("90");
		Thread.sleep(2000);
		//Height
		driver.findElement(By.xpath("(//input[@class='profile-input form-control'])[1]")).clear();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@class='profile-input form-control'])[1]")).sendKeys("130");
		Thread.sleep(2000);
		//Weight
		driver.findElement(By.xpath("(//input[@class='profile-input form-control'])[2]")).clear();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@class='profile-input form-control'])[2]")).sendKeys("40");
		Thread.sleep(2000);
		//Temperature
		driver.findElement(By.xpath("(//input[@class='profile-input form-control'])[3]")).clear();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@class='profile-input form-control'])[3]")).sendKeys("86");
		Thread.sleep(2000);
		//Pulse Rate(BPM)
		driver.findElement(By.xpath("(//input[@class='profile-input  form-control'])[3]")).clear();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@class='profile-input  form-control'])[3]")).sendKeys("60");
		Thread.sleep(2000);
		//BMI
		driver.findElement(By.xpath("(//input[@class='profile-input form-control'])[4]")).sendKeys("");
		Thread.sleep(2000);
		//Waist circumference >40 inches
		driver.findElement(By.id("infowaistcircumference")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//*[text()='Yes'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//*[text()='No'])[1]")).click();
		Thread.sleep(2000);
		WebElement scrollDown=driver.findElement(By.xpath("(//div[@class='col-style-align'])[1]"));
		JavascriptExecutor scrollDownJS=(JavascriptExecutor)driver;
		scrollDownJS.executeScript("arguments[0].scrollIntoView()", scrollDown);
		Thread.sleep(2000);
		//Triglycerides >150
		driver.findElement(By.id("infotriglycerides")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//*[text()='Yes'])[2]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//*[text()='No'])[2]")).click();
		Thread.sleep(2000);
		//Fast blood glucose >100
		driver.findElement(By.id("infobloodglucose")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//*[text()='Yes'])[3]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//*[text()='No'])[3]")).click();
		Thread.sleep(2000);
		//SPO2 level
		driver.findElement(By.xpath("(//input[@class='profile-input  form-control'])[4]")).clear();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@class='profile-input  form-control'])[4]")).sendKeys("40");
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[@class='text_align'] //button[@class='btn primary-btn submit-btn-size btn-secondary'])[1]")).click();
		Thread.sleep(2000);
		//Scroll up
		WebElement scrl=driver.findElement(By.xpath("(//div[@class='row emraccordionrow'])[1]"));
		JavascriptExecutor jsE=(JavascriptExecutor)driver;
		jsE.executeScript("arguments[0].scrollIntoView();",scrl);
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[@class='row emraccordionrow'])[1]")).click();
		Thread.sleep(2000);
		
		//Medical History
		driver.findElement(By.xpath("(//div[@class='row emraccordionrow'])[2]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//button[@type='button'])[4]")).click();
		Thread.sleep(2000);
		//Heart Diseases-Stents in heart
		driver.findElement(By.xpath("//*[text()='Stents in heart']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[text()='Stents in heart']")).click();
		Thread.sleep(2000);
		//Heart Diseases-Heart murmurs
		driver.findElement(By.xpath("//*[text()='Heart murmurs']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[text()='Heart murmurs']")).click();
		Thread.sleep(2000);
		//Heart Diseases-Irregular heart beat problem
		driver.findElement(By.xpath("//*[text()='Irregular heart beat problem']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[text()='Irregular heart beat problem']")).click();
		Thread.sleep(2000);
		//Heart Diseases-Hospitalized for heart attack
		driver.findElement(By.xpath("//*[text()='Hospitalized for heart attack']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[text()='Hospitalized for heart attack']")).click();
		Thread.sleep(2000);
		//Heart Diseases-Others
		driver.findElement(By.xpath("(//*[text()='Others'])[1]")).click();
		Thread.sleep(2000);	
		driver.findElement(By.xpath("//p[@id='validation']/preceding-sibling::input")).clear();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//p[@id='validation']/preceding-sibling::input")).sendKeys("Heart Diseases"); 
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//*[text()='Others'])[1]")).click();
		Thread.sleep(2000);
		
		//Respiratory problems-COPD
		driver.findElement(By.xpath("//*[text()='COPD']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[text()='COPD']")).click();
		Thread.sleep(2000);
		//Respiratory problems-Asthma
		driver.findElement(By.xpath("//*[text()='Asthma']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[text()='Asthma']")).click();
		Thread.sleep(2000);
		//Respiratory problems-Sinus allergies
		driver.findElement(By.xpath("//*[text()='Sinus allergies']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[text()='Sinus allergies']")).click();
		Thread.sleep(2000);
		//Respiratory problems-Home oxygen use
		driver.findElement(By.xpath("//*[text()='Home oxygen use']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[text()='Home oxygen use']")).click();
		Thread.sleep(2000);
		//Respiratory problems-Sleep apnea
		driver.findElement(By.xpath("//*[text()='Sleep apnea']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[text()='Sleep apnea']")).click();
		Thread.sleep(2000);
		//Respiratory problems-Others
		driver.findElement(By.xpath("(//*[text()='Others'])[2]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//p[@id='validation']/preceding-sibling::input")).clear(); 
		Thread.sleep(2000);
		driver.findElement(By.xpath("//p[@id='validation']/preceding-sibling::input")).sendKeys("Respiratory problems"); 
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//*[text()='Others'])[2]")).click();
		Thread.sleep(2000);
		
		//Liver disease-Hepatitis A
		driver.findElement(By.xpath("//*[text()='Hepatitis A']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[text()='Hepatitis A']")).click();
		Thread.sleep(2000);
		//Liver disease-Hepatitis B
		driver.findElement(By.xpath("//*[text()='Hepatitis B']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[text()='Hepatitis B']")).click();
		Thread.sleep(2000);
		//Liver disease-Hepatitis C
		driver.findElement(By.xpath("//*[text()='Hepatitis C']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[text()='Hepatitis C']")).click();
		Thread.sleep(2000);
		//Liver disease-Liver failure
		driver.findElement(By.xpath("//*[text()='Liver failure']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[text()='Liver failure']")).click();
		Thread.sleep(2000);
		//Liver disease-Liver transplant
		driver.findElement(By.xpath("//*[text()='Liver transplant']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[text()='Liver transplant']")).click();
		Thread.sleep(2000);
		//Liver disease-Others
		driver.findElement(By.xpath("(//*[text()='Others'])[3]")).click();
		Thread.sleep(2000);	
		driver.findElement(By.xpath("//p[@id='validation']/preceding-sibling::input")).clear();
		Thread.sleep(2000);	
		driver.findElement(By.xpath("//p[@id='validation']/preceding-sibling::input")).sendKeys("Liver disease");
		Thread.sleep(2000);	
		driver.findElement(By.xpath("(//*[text()='Others'])[3]")).click();
		Thread.sleep(2000);
		
		//Kidney disease-Dialysis
		driver.findElement(By.xpath("//*[text()='Dialysis']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[text()='Dialysis']")).click();
		Thread.sleep(2000);
		//Kidney disease-Kidney stones
		driver.findElement(By.xpath("//*[text()='Kidney stones']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[text()='Kidney stones']")).click();
		Thread.sleep(2000);
		//Kidney disease-Others
		driver.findElement(By.xpath("(//*[text()='Others'])[4]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//p[@id='validation']/preceding-sibling::input")).clear();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//p[@id='validation']/preceding-sibling::input")).sendKeys("Kidney disease");
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//*[text()='Others'])[4]")).click();
		Thread.sleep(2000);
		
		//Gastrointestinal problems-Bleeding in stool 
		WebElement GPScroll=driver.findElement(By.xpath("(//div[@class='profile-align-style']/label[@class='label-profile med-text'])[8]"));
		jsE.executeScript("arguments[0].scrollIntoView();",GPScroll);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[text()='Bleeding in stool']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[text()='Bleeding in stool']")).click();
		Thread.sleep(2000);
		//Gastrointestinal problems-Blood vomiting
		driver.findElement(By.xpath("//*[text()='Blood vomiting']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[text()='Blood vomiting']")).click();
		Thread.sleep(2000);
		//Gastrointestinal problems-Chronic diarrhea
		driver.findElement(By.xpath("//*[text()='Chronic diarrhea']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[text()='Chronic diarrhea']")).click();
		Thread.sleep(2000);
		//Gastrointestinal problems-Constipation
		driver.findElement(By.xpath("//*[text()='Constipation']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[text()='Constipation']")).click();
		Thread.sleep(2000);
		//Gastrointestinal problems-Others
		driver.findElement(By.xpath("(//*[text()='Others'])[5]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//p[@id='validation']/preceding-sibling::input")).clear();
		Thread.sleep(2000);	
		driver.findElement(By.xpath("//p[@id='validation']/preceding-sibling::input")).sendKeys("Gastrointestinal problems");
		Thread.sleep(2000);	
		driver.findElement(By.xpath("(//*[text()='Others'])[5]")).click();
		Thread.sleep(2000);
				
		//Brain Stroke
		driver.findElement(By.xpath("(//*[text()=\"Yes\"])[4]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//*[text()=\"No\"])[4]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//*[text()=\"Yes\"])[5]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//*[text()=\"No\"])[5]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//*[text()=\"Yes\"])[6]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//*[text()=\"No\"])[6]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//*[text()=\"Yes\"])[7]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//*[text()=\"No\"])[7]")).click();
		Thread.sleep(2000);
		WebElement diabetes=driver.findElement(By.xpath("(//*[@class='profile-input  form-control'])[5]"));
		diabetes.clear();
		Thread.sleep(2000);
		diabetes.sendKeys("Diabetes Mellitus - Details");
		Thread.sleep(2000);
		WebElement subclinic=driver.findElement(By.xpath("(//*[@class='profile-input  form-control'])[6]"));
		subclinic.clear();
		Thread.sleep(2000);
		subclinic.sendKeys("Subclinical Hypothyroidism");
		Thread.sleep(2000);
		WebElement asthma=driver.findElement(By.xpath("(//*[@class='profile-input  form-control'])[7]"));
		asthma.clear();
		Thread.sleep(2000);
		asthma.sendKeys("Asthma");
		Thread.sleep(2000);
		WebElement dys=driver.findElement(By.xpath("(//*[@class='profile-input  form-control'])[8]"));
		dys.clear();
		Thread.sleep(2000);
		dys.sendKeys("Dyslipidemia");
		Thread.sleep(2000);
		WebElement coronary=driver.findElement(By.xpath("(//*[@class='profile-input  form-control'])[9]"));
		coronary.clear();
		Thread.sleep(2000);
		coronary.sendKeys("Coronary Artery Disease");
		Thread.sleep(2000);
		WebElement tuber=driver.findElement(By.xpath("(//*[@class='profile-input  form-control'])[10]"));
		tuber.clear();
		Thread.sleep(2000);
		tuber.sendKeys("Tuberculosis");
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//*[@class='custom-control-input'])[39]")).sendKeys("Brain Stroke");
		Thread.sleep(2000);
		//Submit
		driver.findElement(By.xpath("(//button[@type='button'])[6]")).click();
		Thread.sleep(2000);
		//Scroll up
		WebElement scrl1=driver.findElement(By.xpath("(//div[@class='row emraccordionrow'])[2]"));
		JavascriptExecutor jsE1=(JavascriptExecutor)driver;
		jsE1.executeScript("arguments[0].scrollIntoView();",scrl1);
		driver.findElement(By.xpath("(//div[@class='row emraccordionrow'])[2]")).click();
		Thread.sleep(2000);
		
		//Surgery History
		driver.findElement(By.xpath("(//div[@class='row emraccordionrow'])[3]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//button[@type='button'])[7]")).click();
		Thread.sleep(2000);
		//Surgery History-Tonsils removal
		driver.findElement(By.xpath("//*[text()='Tonsils removal']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[text()='Tonsils removal']")).click();
		Thread.sleep(2000);
		//Surgery History-Thyroid surgery
		driver.findElement(By.xpath("//*[text()='Thyroid surgery']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[text()='Thyroid surgery']")).click();
		Thread.sleep(2000);
		//Surgery History-Heart surgery
		driver.findElement(By.xpath("//*[text()='Heart surgery']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[text()='Heart surgery']")).click();
		Thread.sleep(2000);
		//Surgery History-Gall bladder removal
		driver.findElement(By.xpath("//*[text()='Gall bladder removal']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[text()='Gall bladder removal']")).click();
		Thread.sleep(2000);
		//Surgery History-Appendix surgery
		driver.findElement(By.xpath("//*[text()='Appendix surgery']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[text()='Appendix surgery']")).click();
		Thread.sleep(2000);
		//Surgery History-Knee/hip Replacement
		driver.findElement(By.xpath("//*[text()='Knee/hip Replacement']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[text()='Knee/hip Replacement']")).click();
		Thread.sleep(2000);
		//Surgery History-Others
		driver.findElement(By.xpath("(//*[text()='Others'])[6]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@class='otherText form-control'])[1]")).sendKeys("Surgery");
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//*[text()='Others'])[6]")).click();
		Thread.sleep(2000);
		//submit button
		driver.findElement(By.xpath("(//button[@type='button'])[9]")).click();
		Thread.sleep(2000);
		//Scroll up
		WebElement scrol=driver.findElement(By.xpath("(//div[@class='row emraccordionrow'])[3]"));
		JavascriptExecutor jsEx=(JavascriptExecutor)driver;
		jsEx.executeScript("arguments[0].scrollIntoView();",scrol);
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[@class='row emraccordionrow'])[3]")).click();
		Thread.sleep(2000);
		
		//Family History
		driver.findElement(By.xpath("(//div[@class='row emraccordionrow'])[4]")).click();
		Thread.sleep(2000);
		//Click Edit button
		driver.findElement(By.xpath("(//button[@type='button'])[10]")).click();
		Thread.sleep(2000);
		//Bleeding disorder
		driver.findElement(By.xpath("//*[text()='Bleeding disorder']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[text()='Bleeding disorder']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[text()='Stroke']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[text()='Stroke']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[text()='Cancer']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[text()='Cancer']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[text()='Diabetes']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[text()='Diabetes']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[text()='Heart disease']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[text()='Heart disease']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//*[text()='Others'])[7]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//p[@id='validation']/preceding-sibling::input")).sendKeys("Surgery");
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//*[text()='Others'])[7]")).click();
		Thread.sleep(2000);
		//submit button
		driver.findElement(By.xpath("(//button[@type='button'])[12]")).click();
		Thread.sleep(2000);
		//Scroll up
		WebElement scr=driver.findElement(By.xpath("(//div[@class='row emraccordionrow'])[3]"));
		JavascriptExecutor JS=(JavascriptExecutor)driver;
		JS.executeScript("arguments[0].scrollIntoView();",scr);
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[@class='row emraccordionrow'])[4]")).click();
		Thread.sleep(2000);
		
		//Allergies
		driver.findElement(By.xpath("(//div[@class='row emraccordionrow'])[5]")).click();
		Thread.sleep(2000);
		//Edit button
		driver.findElement(By.xpath("(//button[@type='button'])[13]")).click();
		Thread.sleep(2000);
		//Drug allergy
		driver.findElement(By.xpath("//*[text()='Penicillin']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[text()='Penicillin']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[text()='Bactrim']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[text()='Bactrim']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[text()='Tetracycline']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[text()='Tetracycline']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//*[text()='Others'])[8]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//p[@id='validation']/preceding-sibling::input")).sendKeys("Drug Allergy");
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//*[text()='Others'])[8]")).click();
		Thread.sleep(2000);
		
		//Allergies
		driver.findElement(By.xpath("//*[text()='Pollen']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[text()='Pollen']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[text()='Dust mites']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[text()='Dust mites']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[text()='Mold']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[text()='Mold']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[text()='Animal dander and Cockroaches']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[text()='Animal dander and Cockroaches']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[text()='Insect sting']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[text()='Insect sting']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[text()='Latex']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[text()='Latex']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//*[text()='Others'])[9]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//p[@id='validation']/preceding-sibling::input")).clear();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//p[@id='validation']/preceding-sibling::input")).sendKeys("Allergies");
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//*[text()='Others'])[9]")).click();
		Thread.sleep(2000);
		//submit button
		driver.findElement(By.xpath("(//button[@type='button'])[15]")).click();
		Thread.sleep(2000);
		//scroll
		WebElement alergyscroll=driver.findElement(By.xpath("(//div[@class='row emraccordionrow'])[4]"));
		JavascriptExecutor JSE=(JavascriptExecutor)driver;
		JSE.executeScript("arguments[0].scrollIntoView();",alergyscroll);
		driver.findElement(By.xpath("(//div[@class='row emraccordionrow'])[5]")).click();
		Thread.sleep(2000);

		//OnExamination
		driver.findElement(By.xpath("(//div[@class='row emraccordionrow'])[6]")).click();
		Thread.sleep(2000);
		//Edit button
		driver.findElement(By.xpath("(//button[@type='button'])[16]")).click();
		Thread.sleep(2000);
		//Per Abdomen
		WebElement PerAbdomen=driver.findElement(By.xpath("(//*[@class='profile-input  form-control'])[11]"));
		PerAbdomen.clear();
		Thread.sleep(2000);
		PerAbdomen.sendKeys("Per Abdomen");
		Thread.sleep(2000);
		//Chorionic Villus Sampling
		WebElement Chorionic=driver.findElement(By.xpath("(//*[@class='profile-input  form-control'])[12]"));
		Chorionic.clear();
		Thread.sleep(2000);
		Chorionic.sendKeys("Chorionic Villus Sampling");
		Thread.sleep(2000);
		//Central Nervous System
		WebElement Central=driver.findElement(By.xpath("(//*[@class='profile-input  form-control'])[13]"));
		Central.clear();
		Thread.sleep(2000);
		Central.sendKeys("Central Nervous System");
		Thread.sleep(2000);
		//Reed Sternberg
		WebElement Reed=driver.findElement(By.xpath("(//*[@class='profile-input  form-control'])[14]"));
		Reed.clear();
		Thread.sleep(2000);
		Reed.sendKeys("Reed Sternberg");
		//Submit
		driver.findElement(By.xpath("(//button[@type='button'])[18]")).click();
		Thread.sleep(2000);
		//scroll
		WebElement OE_scr=driver.findElement(By.xpath("(//div[@class='row emraccordionrow'])[5]"));
		Thread.sleep(2000);
		JavascriptExecutor OE_js=(JavascriptExecutor)driver;
		OE_js.executeScript("arguments[0].scrollIntoView();",OE_scr);
		driver.findElement(By.xpath("(//div[@class='row emraccordionrow'])[6]")).click();
		Thread.sleep(2000);

		//Medications
		driver.findElement(By.xpath("(//div[@class='row emraccordionrow'])[7]")).click();
		Thread.sleep(2000);
		//Click Add button
		driver.findElement(By.xpath("(//button[@type='button'])[19]")).click();
		Thread.sleep(3000);
		WebElement Medbox=driver.findElement(By.xpath("//div[@id='scrolltoviewId']"));
		JavascriptExecutor m_js=(JavascriptExecutor)driver;
		m_js.executeScript("arguments[0].scrollIntoView();",Medbox);
		Thread.sleep(2000);
		//Search Medicine
		WebElement SearchMedicine=driver.findElement(By.xpath("//*[@id='searchInput']"));
		Thread.sleep(2000);
		SearchMedicine.sendKeys("dolo");
		Thread.sleep(2000);
		//driver.findElement(By.xpath("//li[text()[normalize-space()='Dolo|Tablet|dolo']]")).click();
		driver.findElement(By.xpath("//div[@id='suggestions']//li[4]")).click();
		//Intake
		WebElement Intake=driver.findElement(By.xpath("//*[@id='intake']"));
		Intake.click();
		Thread.sleep(2000);
		Intake.sendKeys("Before food");
		//Number of days
		WebElement number=driver.findElement(By.xpath("//*[@id='medicinecount']"));
		number.clear();
		Thread.sleep(2000);
		number.sendKeys("8");
		//Morning
		WebElement morning=driver.findElement(By.xpath("//*[@id='medmorn']"));
		morning.click();
		Thread.sleep(2000);
		morning.sendKeys("2");
		//Afternoon
		WebElement afternoon=driver.findElement(By.xpath("//*[@id='medafter']"));
		afternoon.click();
		Thread.sleep(2000);
		afternoon.sendKeys("1");
		//Night
		WebElement night=driver.findElement(By.xpath("//*[@id='mednight']"));
		night.click();
		Thread.sleep(2000);
		night.sendKeys("3");
		//Additional comments
		WebElement addcomnt=driver.findElement(By.xpath("//*[@id='notes']"));
		addcomnt.clear();
		Thread.sleep(2000);
		addcomnt.sendKeys("Additional comments@1234%*");
		//Submit
		driver.findElement(By.xpath("//div[@class='text-center mb-4']/button[2]")).click();
		Thread.sleep(2000);
		//Edit button
		WebElement sd=driver.findElement(By.xpath("(//div[@class='row emraccordionrow'])[6]"));
		JavascriptExecutor JiS=(JavascriptExecutor)driver;
		JiS.executeScript("arguments[0].scrollIntoView();", sd);
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[@class='row emraccordionrow'])[7]")).click();
		Thread.sleep(2000);
		
		//Lifestyle
		driver.findElement(By.xpath("(//div[@class='row emraccordionrow'])[8]")).click();
		Thread.sleep(2000);
		//Edit button
		driver.findElement(By.xpath("(//button[@class='btn primary-btn edit-btn-size btn-secondary'])[7]")).click();
		Thread.sleep(2000);
		//Scroll up
		WebElement lifeScroll=driver.findElement(By.xpath("(//div[@class='row emraccordionrow'])[7]"));
		JavascriptExecutor lifeJS=(JavascriptExecutor)driver;
		lifeJS.executeScript("arguments[0].scrollIntoView();",lifeScroll);
		Thread.sleep(2000);
		//Lives alone
		driver.findElement(By.xpath("//*[text()='Lives alone']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[text()='Lives alone']")).click();
		Thread.sleep(2000);
		//Private residence
		driver.findElement(By.xpath("//*[text()='Private residence']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[text()='Private residence']")).click();
		Thread.sleep(2000);
		//Lives with family
		driver.findElement(By.xpath("//*[text()='Lives with family']")).click();
		Thread.sleep(2000);	
		driver.findElement(By.xpath("//*[text()='Lives with family']")).click();
		Thread.sleep(2000);
		//Assisted living
		driver.findElement(By.xpath("//*[text()='Assisted living']")).click();
		Thread.sleep(2000);	
		driver.findElement(By.xpath("//*[text()='Assisted living']")).click();
		Thread.sleep(2000);
		//Nursing home
		driver.findElement(By.xpath("//*[text()='Nursing home']")).click();
		Thread.sleep(2000);	
		driver.findElement(By.xpath("//*[text()='Nursing home']")).click();
		Thread.sleep(2000);
		//Submit button
		driver.findElement(By.xpath("(//div[@class='text_align'] //button[@class='btn primary-btn submit-btn-size btn-secondary'])[4]")).click();
		Thread.sleep(2000);
		
		
		//Appointment History
		driver.findElement(By.xpath("(//div[@class='row emraccordionrow'])[9]")).click();
		Thread.sleep(2000);		
		String AppointmentHistory=driver.findElement(By.xpath("(//span[@class='ag-paging-row-summary-panel'])[2]/span[@ref='lbFirstRowOnPage']")).getText();
		System.out.println(AppointmentHistory);		
		if(AppointmentHistory.equals("0"))
		{
			System.out.println("No record found");
		}
		else
		{
		WebElement ApHis, notes, DD, Page;
		DD=driver.findElement(By.xpath("(//div[@class='row emraccordionrow'])[8]"));
		JavascriptExecutor DDJS=(JavascriptExecutor)driver;
		DDJS.executeScript("arguments[0].scrollIntoView();", DD);
		Thread.sleep(2000);		
		driver.findElement(By.xpath("(//a[@class='view-btn'])[1]")).click();
		Thread.sleep(3000);
		notes=driver.findElement(By.xpath("//b[text()='NOTES']"));
		JavascriptExecutor notesJS=(JavascriptExecutor)driver;
		notesJS.executeScript("arguments[0].scrollIntoView();", notes);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@class='close']")).click();
		Thread.sleep(2000);
		ApHis=driver.findElement(By.xpath("//div[@class='ag-paging-panel ag-unselectable']"));
		JavascriptExecutor ApHisJS=(JavascriptExecutor)driver;
		ApHisJS.executeScript("arguments[0].scrollIntoView();", ApHis);
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//span[@class='ag-icon ag-icon-next'])[2]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//span[@class='ag-icon ag-icon-previous'])[2]")).click();
		Thread.sleep(2000);
		Page=driver.findElement(By.xpath("//*[text()='1']"));
		JavascriptExecutor pageJS=(JavascriptExecutor)driver;		
		pageJS.executeScript("arguments[0].scrollIntoView();", Page);
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//span[@class='ag-icon ag-icon-next'])[2]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//span[@class='ag-icon ag-icon-previous'])[2]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//span[@class='when-opened'])[9]")).click();
		Thread.sleep(2000);
		}
		
		//Reports
		driver.findElement(By.xpath("(//div[@class='row emraccordionrow'])[10]")).click();
		Thread.sleep(2000);			
		driver.findElement(By.xpath("//*[@title=\"Click here, to attach reports\"]")).click();
		Thread.sleep(2000);			
		WebElement SelectDisease=driver.findElement(By.xpath("//*[@id='prof_style_id']"));
		Select Select=new Select(SelectDisease);
		Select.selectByIndex(3);
		driver.findElement(By.xpath("//*[text()='UPLOAD ']")).click();
	    //Upload Functionalities
		String file = "\"C:\\Users\\RajalakshmiRajasekar\\Downloads\\image (1).png\"";
	    StringSelection selection = new StringSelection(file);
	    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);
	    Thread.sleep(5000);
	    
	    //Robot Class for Performing the Keyboard actions
	    Robot robot = new Robot();
	    robot.keyPress(KeyEvent.VK_CONTROL);
	    robot.keyPress(KeyEvent.VK_V);
	    robot.keyRelease(KeyEvent.VK_CONTROL);
	    robot.keyRelease(KeyEvent.VK_V);
	    Thread.sleep(5000);
	    robot.keyPress(KeyEvent.VK_ENTER);
	    robot.keyRelease(KeyEvent.VK_ENTER);
		        
	   Thread.sleep(5000);     
       WebElement reportsSc, scrolup;
       reportsSc=driver.findElement(By.xpath("//div[@class='col-12 close-button']"));
 	   JavascriptExecutor RptJS, scrlupJS;
 	   RptJS=(JavascriptExecutor)driver;
 	   RptJS.executeScript("arguments[0].scrollIntoView()",reportsSc);
 	   Thread.sleep(5000);	        
	   driver.findElement(By.xpath("(//div[@align='right']//button[@type='button'])[3]")).click();
	   Thread.sleep(2000);
	   scrolup=driver.findElement(By.xpath("//h3"));
	   scrlupJS=(JavascriptExecutor)driver;
	   scrlupJS.executeScript("arguments[0].scrollIntoView()",scrolup);
	   List<WebElement> Delete=driver.findElements(By.cssSelector("div[class='files-card m-2 p-2 card_file']>svg[data-icon='trash']>path"));
	   System.out.println(Delete.size());
	   //System.out.println(Delete.get(0).getAttribute("d"));
	   Thread.sleep(5000);
	  // Actions action=new Actions(driver);
	   //Thread.sleep(5000);
	   //action.moveToElement(Delete.get(0)).click().build().perform();
	   //Thread.sleep(3000);
       driver.findElement(By.xpath("(//div[@class='row emraccordionrow']/a)[10]")).click();
	   Thread.sleep(2000);	
	   driver.findElement(By.xpath("//div[@class='col-12 close-button']//button")).click();
	   Thread.sleep(2000);
*/	   
	 //Notes - Symptoms)
	   driver.findElement(By.xpath("//div[@class='nav-bar col-auto p-0']/div[3]")).click();
	   Thread.sleep(2000);
	   WebElement Symptoms=driver.findElement(By.xpath("(//textarea[@class='form-control form-control'])[1]"));
	   Symptoms.click();
	   Thread.sleep(2000);
	   Symptoms.clear();
	   Thread.sleep(2000);
	   Symptoms.sendKeys("Vomit");
	   Thread.sleep(2000);
	   //Medical History
	   WebElement MedHis=driver.findElement(By.xpath("(//textarea[@class='form-control form-control'])[2]"));
	   MedHis.click();
	   Thread.sleep(2000);
	   MedHis.clear();
	   Thread.sleep(2000);
	   MedHis.sendKeys("Spo2 Level : 40, Height : 130 cm, Weight : 40 kgs, Pulse Rate (Bpm) : 60, Temperature : 86 °F, Fast Blood Glucose >100 : No, Triglycerides >150 : No, Waist Circumference >40 Inches : No, Blood Pressure Systolic (Mm Hg) : 110, Blood Pressure Diastolic (Mm Hg) : 90.");
	   Thread.sleep(2000);
	   WebElement scrl=driver.findElement(By.xpath("//div[@id='infoinvestigations']"));
	   JavascriptExecutor scrollDnJS=(JavascriptExecutor)driver;
	   scrollDnJS.executeScript("arguments[0].scrollIntoView()", scrl);
	   //Chief complaints
	   WebElement Chiefcomplaints=driver.findElement(By.xpath("(//textarea[@class='form-control form-control'])[3]"));
	   Chiefcomplaints.click();
	   Thread.sleep(2000);
	   Chiefcomplaints.clear();
	   Thread.sleep(2000);
	   Chiefcomplaints.sendKeys("Fever");
	   Thread.sleep(2000);
	   //Diagnosis
	   WebElement Diagnosis=driver.findElement(By.xpath("(//textarea[@class='form-control form-control'])[4]"));
	   Diagnosis.click();
	   Thread.sleep(2000);
	   Diagnosis.clear();
	   Thread.sleep(2000);
	   Diagnosis.sendKeys("Diagnosis");
	   Thread.sleep(2000);
	   scrl=driver.findElement(By.xpath("//div[@id='infotreatmentPlan']"));
	   scrollDnJS.executeScript("arguments[0].scrollIntoView()", scrl);
	   Thread.sleep(2000);
	   //Treatment plan
	   WebElement TreatmentPlan=driver.findElement(By.xpath("(//textarea[@class='form-control form-control'])[5]"));
	   TreatmentPlan.click();
	   Thread.sleep(2000);
	   TreatmentPlan.clear();
	   Thread.sleep(2000);
	   TreatmentPlan.sendKeys("Treatment Plan");
	   Thread.sleep(2000);
	   //Advices     
	   WebElement Advices=driver.findElement(By.xpath("(//textarea[@class='form-control form-control'])[6]"));
	   Advices.click();
	   Thread.sleep(2000);
	   Advices.clear();
	   Thread.sleep(2000);
	   Advices.sendKeys("Advices");
	   Thread.sleep(2000);
	   
	   WebElement NotesScroll=driver.findElement(By.xpath("//div[@class='col-12 notes-button']"));
	   JavascriptExecutor notesJS=(JavascriptExecutor)driver;
	   notesJS.executeScript("arguments[0].scrollIntoView()", NotesScroll);
	   //Doctor
	   WebElement Doctor=driver.findElement(By.xpath("(//div[@class='py-2 col-6'])[1]/div//div/div/input"));
	   Doctor.click();
	   Thread.sleep(2000);
	   Doctor.clear();
	   Thread.sleep(2000);
	   Doctor.sendKeys("Mari Selvam");
	   Thread.sleep(2000);
	   //Department
	   WebElement Department=driver.findElement(By.xpath("(//div[@class='py-2 col-6'])[2]/div//div/div/input"));
	   Department.click();
	   Thread.sleep(2000);
	   Advices.clear();
	   Thread.sleep(2000);
	   Department.sendKeys("General");
	   Thread.sleep(2000);
	   driver.findElement(By.xpath("//ul/li")).click();
	   Thread.sleep(2000);
	   //Date
	   driver.findElement(By.xpath("(//div[@class='py-2 col-6'])[3]//div//div//input")).click();
	   Thread.sleep(2000);
	   driver.findElement(By.xpath("//div[@class='el-date-picker__header']//span[1]")).click();
	   Thread.sleep(2000);
	   //Click Year
	   driver.findElement(By.xpath("//div[@class='el-picker-panel__content']/table[2]//tbody/tr[2]/td[2]")).click();
	   Thread.sleep(2000);
	   //Click Month
	   driver.findElement(By.xpath("(//table[@class='el-month-table']/tbody//tr[3]//a)[1]")).click();
	   Thread.sleep(2000);
	   //Click Date
	   driver.findElement(By.xpath("(//tr[@class='el-date-table__row'])[3]//td[3]")).click();
	   Thread.sleep(2000);
	   //Time
	   driver.findElement(By.xpath("//div[@class='mx-datepicker']/div//input")).click();
	   Thread.sleep(2000);
	   //Hours scroll down
	   WebElement hourscrollDown, hourscrolltop;
	   hourscrollDown=driver.findElement(By.xpath("(//div[@class='mx-scrollbar-wrap']/ul/li)[12]"));
	   JavascriptExecutor hoursJS, HourJS;
	   hoursJS=(JavascriptExecutor)driver;
	   hoursJS.executeScript("arguments[0].scrollIntoView()", hourscrollDown);
	   Thread.sleep(2000);
	   hourscrolltop=driver.findElement(By.xpath("(//div[@class='mx-scrollbar-wrap']/ul/li)[1]"));
	   HourJS=(JavascriptExecutor)driver;
	   HourJS.executeScript("arguments[0].scrollIntoView()", hourscrolltop);
	   Thread.sleep(2000);
	   //Click hour
	   driver.findElement(By.xpath("(//div[@class='mx-scrollbar-wrap']/ul/li)[1]")).click();
	   Thread.sleep(2000);
	   //Minute scroll down and up
	   WebElement minutescrollDown, minutescrollup;
	   minutescrollDown=driver.findElement(By.xpath("(//div[@class='mx-scrollbar-wrap'])[2]/ul//li[7]"));
	   JavascriptExecutor MinJS, minJS;
	   MinJS=(JavascriptExecutor)driver;
	   MinJS.executeScript("arguments[0].scrollIntoView()", minutescrollDown);
	   Thread.sleep(2000);
	   minutescrollup=driver.findElement(By.xpath("(//div[@class='mx-scrollbar-wrap'])[2]/ul//li[1]"));
	   minJS=(JavascriptExecutor)driver;
	   minJS.executeScript("arguments[0].scrollIntoView()", minutescrollup);
	   Thread.sleep(2000);
	   //Click minute
	   driver.findElement(By.xpath("(//div[@class='mx-scrollbar-wrap'])[2]/ul/li[4]")).click();
	   Thread.sleep(2000);
	   //Click AM and PM
	   driver.findElement(By.xpath("((//div[@class='mx-scrollbar-wrap'])[3]/ul/li)[2]")).click();
	   Thread.sleep(2000);
	   driver.findElement(By.xpath("((//div[@class='mx-scrollbar-wrap'])[3]/ul/li)[1]")).click();
	   Thread.sleep(2000);
	   //Click Continue button
	   driver.findElement(By.xpath("//div[@class='col-12 notes-button']/button[2]")).click();
	   Thread.sleep(2000);
	   
	 //RX Module
	   //searchMedicine
	   WebElement searchMedicine=driver.findElement(By.cssSelector("input[id='searchInput']"));
	   searchMedicine.click();
	   Thread.sleep(2000);
	   searchMedicine.clear();
	   Thread.sleep(2000);
	   searchMedicine.sendKeys("dolo");
	   Thread.sleep(2000);
	   driver.findElement(By.xpath("//div[@id='suggestions']/ul//li[11]")).click();
	   Thread.sleep(2000);
	   WebElement intakeFood=driver.findElement(By.cssSelector("select[id='intakefood']"));
	   Thread.sleep(2000);
	   intakeFood.click();
	   Thread.sleep(2000);
	   intakeFood.sendKeys("Just before food");
	   Thread.sleep(2000);
	   //Composition
	   WebElement composition=driver.findElement(By.xpath("(//input[@class='rx-input form-control'])[2]"));
	   composition.click();
	   Thread.sleep(2000);
	   composition.clear();
	   Thread.sleep(2000);
	   composition.sendKeys("Composition");
	   Thread.sleep(2000);
	   //Number of days 
	   WebElement no_of_Days=driver.findElement(By.cssSelector("#medicinecount"));
	   Thread.sleep(2000);
	   no_of_Days.click();
	   Thread.sleep(2000);
	   no_of_Days.clear();
	   Thread.sleep(2000);
	   no_of_Days.sendKeys("6");
	   Thread.sleep(2000);
	   //Morning
	   driver.findElement(By.cssSelector("#medmorn")).click();
	   Thread.sleep(2000);
	   driver.findElement(By.xpath("//select[@id='medmorn']/option[4]")).click();
	   Thread.sleep(2000);	   
	   //Afternoon
	   driver.findElement(By.cssSelector("#mednoon")).click();
	   Thread.sleep(2000);
	   driver.findElement(By.xpath("//select[@id='mednoon']/option[3]")).click();
	   Thread.sleep(2000);
	   //Night
	   driver.findElement(By.cssSelector("#mednight")).click();
	   Thread.sleep(2000);
	   driver.findElement(By.xpath("//select[@id='mednight']/option[5]")).click();
	   Thread.sleep(2000);
	   //Additional comments
	   driver.findElement(By.xpath("//textarea[@placeholder='(Eg:2 tablespoon a time)']")).sendKeys("Additional Comments");
	   Thread.sleep(2000);
	   //Add button
	   driver.findElement(By.xpath("//button[@id='add-btn']")).click();
	   Thread.sleep(2000);
	   WebElement rxscroll=driver.findElement(By.xpath("//div[@class='rxcontinue pt-2']"));
	   JavascriptExecutor rxJS=(JavascriptExecutor)driver;
	   rxJS.executeScript("arguments[0].scrollIntoView()", rxscroll);
	   Thread.sleep(2000);
	   driver.findElement(By.xpath("//button[@class='btn primary-btn continue-btn-size btn-secondary']")).click();
	   
	   //Lab
	   driver.findElement(By.xpath("(//div[@class='nav-item'])[5]")).click();
	   Thread.sleep(2000);
	   driver.findElement(By.xpath("//select[@class='custom-select']")).click();
	   Thread.sleep(2000);
	   driver.findElement(By.cssSelector("option[value='Blood Test']")).click();
	   Thread.sleep(2000);
	   driver.findElement(By.cssSelector("#searchInput")).sendKeys("Blood");
	   Thread.sleep(2000);
	   driver.findElement(By.xpath("//div[text()='Blood Test']")).click();
	   Thread.sleep(2000);
	   driver.findElement(By.cssSelector("button[id='add-btn']")).click();
	   Thread.sleep(2000);
	   driver.findElement(By.xpath("//div[@class='text-center mt-3']/button[2]")).click();
	   Thread.sleep(2000);
	   
	   //Summary
	   driver.findElement(By.xpath("(//div[@class='nav-item'])[6]")).click();
	   Thread.sleep(2000);
	   WebElement summary=driver.findElement(By.xpath("(//label[@class='label-profile'])[5]"));
	   JavascriptExecutor summaryJS=(JavascriptExecutor)driver;
	   summaryJS.executeScript("arguments[0].scrollIntoView()", summary);
	   Thread.sleep(2000);
	   //WebElement LAB=driver.findElement(By.xpath("//th[contains(text(),'Investigation')]"));
	   //summaryJS.executeScript("arguments[0].scrollIntoView()", LAB);
	  // Thread.sleep(2000);
	   driver.findElement(By.xpath("//div[@class='text-center pt-3']/button[2]")).click();
	   Thread.sleep(2000);
	   driver.findElement(By.xpath("//div[@class='el-message-box__btns']/button[2]")).click();
	   Thread.sleep(2000);
	   driver.findElement(By.xpath("(//div[@class='vue-star-rating'])[2]/span[3]")).click();
	   Thread.sleep(2000);
	   driver.findElement(By.xpath("//div[@class='pl-0 col-sm-6']/input[@type='text']")).sendKeys("Nothing");
	   Thread.sleep(2000);
	   driver.findElement(By.xpath("//textarea[@name='text']")).sendKeys("Good");
	   Thread.sleep(2000);
	   driver.findElement(By.xpath("//div[@class='btn_center col']/button")).click();
	   Thread.sleep(2000);
	   scrl=driver.findElement(By.xpath("//div[@class='labTestsTable']"));
	   scrollDnJS.executeScript("arguments[0].scrollIntoView()", scrl);
	   driver.findElement(By.xpath("//button[@class='btn dropdown-toggle btn-primary']")).click();
	   Thread.sleep(2000);
	   driver.findElement(By.xpath("//ul[@class='dropdown-menu show']//li[1]")).click();
	   Thread.sleep(2000);   
	   Set <String> handles = driver.getWindowHandles();	   
	   Iterator<String> it = handles.iterator();	   
	   String parentWindow = it.next();	   
	   String childWindow = it.next();	   
	   driver.switchTo().window(childWindow);	   
	   try {
		   Thread.sleep(2000);
	   }catch (InterruptedException e) {
		   e.printStackTrace();
	   }	   
	   try {
		   Robot robot1 = new Robot();		   
		   robot1.keyPress(KeyEvent.VK_ENTER);
		   robot1.keyRelease(KeyEvent.VK_ESCAPE);
	   } catch(AWTException e) {
		   e.printStackTrace();
	   }	   
	   driver.close();
	   
	   driver.switchTo().window(parentWindow);
  

	}
	
}
