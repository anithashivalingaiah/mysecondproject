package com.practicefunctions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class File_upload {
	
	public static void main(String[]args) throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://cgi-lib.berkeley.edu/ex/fup.html");
		Thread.sleep(3000);
		WebElement choosefile = driver.findElement(By.xpath("//input[@name='upfile']"));
		//choosefile.click();
		//Thread.sleep(2000);
		choosefile.sendKeys("C:\\Users\\pmuniraju\\Documents\\Screenshots\\Upload_selenium.png");
		Thread.sleep(3000);
		WebElement submit = driver.findElement(By.xpath("//input[@type='submit']"));
		submit.click();
		
		/*WebElement password = driver.findElement(By.id("password_field"));
		password.sendKeys("admin123");
		WebElement login = driver.findElement(By.xpath("//button[@onclick = 'login()']"));
		login.click();
		Thread.sleep(3000);
		
		WebElement fileUpload = driver.findElement(By.xpath("//a[contains(text(), 'File Upload')]"));
		fileUpload.click();
		Thread.sleep(2000);
		WebElement uploadbox = driver.findElement(By.id("logo"));
		Thread.sleep(2000);
		uploadbox.sendKeys("C:\\Users\\pmuniraju\\Pictures\\Screenshots\\Screenshot(12).png");*/
		
		
		
	}
}
