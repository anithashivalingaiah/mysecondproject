package com.practicefunctions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SwitchTo_Tabs {
	
	public static void main(String[]args) throws Exception {
		
		String exLondontext = "London is the capital city of England.", exParistext="Paris is the capital of France.", 
				exTokyotext = "Tokyo is the capital of Japan.";
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://qa-tekarch.firebaseapp.com");
		//WebDriverWait wait= new WebDriverWait(driver, 30);
		driver.manage().window().maximize();
	
	WebElement email = driver.findElement(By.id("email_field"));
	email.sendKeys("admin123@gmail.com");
	WebElement password = driver.findElement(By.id("password_field"));
	password.sendKeys("admin123");
	WebElement login = driver.findElement(By.xpath("//button[@onclick='login()']"));
	login.click();
	Thread.sleep(3000);
	
	WebElement switchto= driver.findElement(By.xpath("//button[contains(text(), 'Switch')]"));
	switchto.click();
	WebElement tabs = driver.findElement(By.xpath("//a[contains(text(), 'Tabs')]"));
	tabs.click();
	Thread.sleep(2000);
	WebElement london = driver.findElement(By.xpath("//button[contains(text(), 'London')]"));
	driver.switchTo().activeElement();
	london.click();
	//System.out.println(london.getText());
	WebElement londontext = driver.findElement(By.xpath("//p[contains(text(), 'London is')]"));
	String actuallondontext= londontext.getText();
	if(actuallondontext.equals(exLondontext)) {
		System.out.println("pass");
	}
	else {
		System.out.println("fail");
	}
	
	WebElement paris = driver.findElement(By.xpath("//button[contains(text(), 'Paris')]"));
	driver.switchTo().activeElement();
	paris.click();
	WebElement paristext = driver.findElement(By.xpath("//p[contains(text(), 'Paris is')]"));
	String acualparistext= paristext.getText();
	if(acualparistext.equals(exParistext)) {
		System.out.println("pass");
	}
	else {
		System.out.println("fail");
	}
	Thread.sleep(3000);
	WebElement tokyo= driver.findElement(By.xpath("//button[contains(text(), 'Tokyo')]"));
	driver.switchTo().activeElement();
	tokyo.click();
	WebElement tokyotext = driver.findElement(By.xpath("//p[contains(text(), 'Tokyo is')]"));
	String actualtokyotext= tokyotext.getText();
	if(actualtokyotext.equals(exTokyotext)) {
		System.out.println("pass");
	}
	else {
		System.out.println("fail");
	}
	
	
	}

}
