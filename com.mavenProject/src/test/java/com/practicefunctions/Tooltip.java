package com.practicefunctions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Tooltip {
	
public static void main(String[]args) throws Exception {
		String extooltipright = "Right", extooltipleft = "Left", extooltiptop = "Top", extooltipbottom= "Bottom";
		
		
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
		
		//below is the script for intractions tab on qa-tekarchwebportal:
		
		WebElement intractions = driver.findElement(By.xpath("//button[contains(text(), 'Intractions')]"));
		Actions act = new Actions(driver);
		act.moveToElement(intractions).build().perform();		
		WebElement tooltip = driver.findElement(By.xpath("//a[contains(@href, './tooltip.html')]"));
		tooltip.click();
		Thread.sleep(3000);
		
		WebElement tooltipright = driver.findElement(By.xpath("//div[@class='tooltipr']"));
		act.moveToElement(tooltipright).build().perform();
		WebElement actualtooltipright= driver.findElement(By.xpath("//span[@class='tooltiptextr']"));
		String resulttextr = actualtooltipright.getText();
		System.out.println(resulttextr);
		if(extooltipright.equals(resulttextr)) {
			System.out.println("test case passed");
			
		WebElement tooltipleft = driver.findElement(By.xpath("//div[@class='tooltipl']"));
		act.moveToElement(tooltipleft).build().perform();
		WebElement actualtooltipleft = driver.findElement(By.xpath("//span[@class='tooltiptextl']"));
		String resulttextl = actualtooltipleft.getText();
		System.out.println(resulttextl);
		if(extooltipleft.equals(resulttextl)) {
			System.out.println("test case passed");
		}
		
		WebElement tooltiptop = driver.findElement(By.xpath("//div[@class='tooltipt']"));
		act.moveToElement(tooltiptop).build().perform();
		WebElement acualtopText = driver.findElement(By.xpath("//span[@class='tooltiptextt']"));
		String resulttextt =acualtopText.getText();
		if(extooltiptop.equals(resulttextt)) {
			System.out.println("test case passed");
		}
		
		WebElement tooltipbottom = driver.findElement(By.xpath("//div[@class='tooltipb']"));
		act.moveToElement(tooltipbottom).build().perform();
		WebElement actualbottomText = driver.findElement(By.xpath("//span[@class='tooltiptextb']"));
		String resultbtext = actualbottomText.getText();
		if(extooltipbottom.equals(resultbtext)) {
			System.out.println("test case passed");
		}			
		}		
		}

}
