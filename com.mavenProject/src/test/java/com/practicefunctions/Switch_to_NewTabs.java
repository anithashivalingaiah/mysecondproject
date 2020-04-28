package com.practicefunctions;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Switch_to_NewTabs {
	
	public static void main(String[]args) throws Exception {
		
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
		
		WebElement switchTo = driver.findElement(By.xpath("//button[contains(text(), 'Switch To')]"));
		Actions act = new Actions(driver);
		act.moveToElement(switchTo).build().perform();
		Thread.sleep(2000);
		
		WebElement windows = driver.findElement(By.xpath("//a[contains(text(), 'Windows')]"));
		windows.click();
		Thread.sleep(2000);
		WebElement newTab = driver.findElement(By.xpath("//button[contains(text(), 'Tab')]"));//click to new tab
		newTab.click();
		newTab.click();
		newTab.click();
		newTab.click();
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		driver.get("https://www.yahoo.com");
		driver.switchTo().window(tabs.get(2));		
		driver.get("https://www.macys.com");
		driver.switchTo().window(tabs.get(3));
		driver.get("https://www.amazon.com");
		driver.switchTo().window(tabs.get(4));
		driver.get("https://www.ebay.com");
		//driver.close();
		
		
 
				
		
		
	}

}
