package com.practicefunctions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Switch_to_Alerts2 {
	
	public static void main(String[]args) throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://qa-tekarch.firebaseapp.com");
		WebElement email = driver.findElement(By.id("email_field"));
		email.sendKeys("admin123@gmail.com");
		WebElement password = driver.findElement(By.id("password_field"));
		password.sendKeys("admin123");
		WebElement login = driver.findElement(By.xpath("//button[@onclick = 'login()']"));
		login.click();
		Thread.sleep(3000);
		
		WebElement switchto = driver.findElement(By.xpath("//button[contains(text(), 'Switch')]"));
		Actions act = new Actions(driver);
		act.moveToElement(switchto).build().perform();
		switchto.click();
		Thread.sleep(2000);
		WebElement alert2 = driver.findElement(By.xpath("//a[contains(text(), 'Alert')]"));
		alert2.click();
		Thread.sleep(3000);
		
		WebElement prompt = driver.findElement(By.xpath("//button[@onclick= 'promtFunction()']"));
		prompt.click();
		Alert al;
		al= driver.switchTo().alert();
		System.out.println(al.getText());
		//al.accept();
		al.dismiss();
	}
}