package com.practicefunctions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Widget_Table {
	
	public static void main(String[]args) throws Exception {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, 30);
		driver.get("https://qa-tekarch.firebaseapp.com");
		driver.manage().window().maximize();
		WebElement email = driver.findElement(By.id("email_field"));
		email.sendKeys("admin123@gmail.com");
		WebElement password = driver.findElement(By.id("password_field"));
		password.sendKeys("admin123");
		WebElement login = driver.findElement(By.xpath("//button[@onclick='login()']"));
		login.click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[contains(text(), 'Widget')]")).click();
		//wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[contains(text(), 'Table')]"))));
		WebElement table =driver.findElement(By.xpath("//a[contains(text(), 'Table')]"));
		
		/*if(driver.findElement(By.xpath("//a[contains(text(), 'Table')]")).getText().trim().contains("Table")) {
			System.out.println("passed");
		}
		else {
			System.out.println("fail");
		}*/
		//table.getText();
		table.click();		
		Thread.sleep(2000); 
		
		
		List<WebElement> firstRow= driver.findElements(By.xpath("//tbody/tr[1]"));
		for(int i=0; i<firstRow.size(); i++) {
			System.out.println(firstRow.get(i).getText()+ " ");
		}
		List<WebElement> secRow = driver.findElements(By.xpath("//tbody/tr[2]"));
		for(int i=0; i<secRow.size(); i++) {
			System.out.println(secRow.get(i).getText()+ " ");
		}
		List<WebElement> thirdRow = driver.findElements(By.xpath("//tbody/tr[3]"));
		for(int i=0; i<thirdRow.size(); i++) {
			System.out.println(thirdRow.get(i).getText()+ " ");
		}		
	}
}
