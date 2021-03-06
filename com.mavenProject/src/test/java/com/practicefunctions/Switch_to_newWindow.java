package com.practicefunctions;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Switch_to_newWindow {
	
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
		
		//System.out.println("Opening window  :"+driver.getWindowHandles().size());

		Thread.sleep(2000);
		WebElement newWindow = driver.findElement(By.xpath("//button[contains(text(), 'Window')]"));
		//Thread.sleep(2000);
		try {
			newWindow.click();
			Thread.sleep(2000);
			System.out.println("Opening window  :"+driver.getWindowHandles().size());
			newWindow.click();
			Thread.sleep(2000);
			System.out.println("Opening window  :"+driver.getWindowHandles().size());
			newWindow.click();
			Thread.sleep(2000);
			System.out.println("Opening window  :"+driver.getWindowHandles().size());
			newWindow.click();
			Thread.sleep(2000);
			System.out.println("Opening window  :"+driver.getWindowHandles().size());
		}catch (Exception e) {
			e.printStackTrace();
		}
		ArrayList<String> windowslist = new ArrayList<String>(driver.getWindowHandles());//this code on tekarch is written
										//for 1 new window only, so it will not open more than one.
		System.out.println("No of windows :"+windowslist.size());
		driver.switchTo().window(windowslist.get(0));
		driver.get("https://www.github.com");
		Thread.sleep(2000);		
		driver.switchTo().window(windowslist.get(1));
		driver.get("https://www.yahoo.com");
		Thread.sleep(2000);
		//driver.switchTo().window(windowslist.get(2));
		//driver.get("https://www.macys.com");
		
	}

}
