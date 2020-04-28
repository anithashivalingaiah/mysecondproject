package com.practicefunctions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DoubleAndSingleClick {
	
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
		WebElement intractions = driver.findElement(By.xpath("//button[contains(text(), 'Intractions')]"));
		Actions act = new Actions(driver);
		act.moveToElement(intractions).build().perform();
		
		Thread.sleep(3000);
		WebElement mousehover = driver.findElement(By.xpath("//a[contains(@href, './mousehover.html')]"));
		Thread.sleep(2000);
		WebElement doubleClick = driver.findElement(By.xpath("//div/a[contains(text(), 'Double Click')]"));
		doubleClick.click();//this is taking to 'tabs' on 'switch to' screen which is wrong
		Thread.sleep(2000);
		WebElement singleclick = driver.findElement(By.xpath("//button[contains(text(), 'single Click')]"));
		singleclick.click();
		

}
}
