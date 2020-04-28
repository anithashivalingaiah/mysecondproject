package com.practicefunctions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DragAndDrop {
	
	public static void main(String[]args) throws Exception {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.seleniumeasy.com/test/drag-and-drop-demo.html");
		WebElement drag1from = driver.findElement(By.xpath("//span[contains(text(), 'Draggable 1')]"));
		WebElement drop1to = driver.findElement(By.id("mydropzone"));
		Thread.sleep(5000);
		Actions act = new Actions(driver);
		act.clickAndHold(drag1from).moveToElement(drop1to).release(drag1from).build().perform();
		
	}

}

