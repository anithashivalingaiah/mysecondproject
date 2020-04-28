package com.practicefunctions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import io.github.bonigarcia.wdm.WebDriverManager;

public class RadioAndSelect  {
	
	public static void main(String[]args) throws Throwable  {
		
		//ReusableMethods.launchBrowser();
		
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
		WebElement radio = driver.findElement(By.xpath("//span[2]//input[1]"));
		System.out.println(radio.isSelected());
		radio.click();	
		WebElement city = driver.findElement(By.xpath("//select[@id='city']"));
		//city.click();
		Select citylist = new Select(city);
		//citylist.selectByIndex(2);
		//citylist.selectByValue("newdelhi");
		citylist.selectByVisibleText("PATNA");
		
	}
}
