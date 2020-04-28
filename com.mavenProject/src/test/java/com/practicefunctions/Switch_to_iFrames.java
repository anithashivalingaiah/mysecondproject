package com.practicefunctions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Switch_to_iFrames {
	
	public static void main(String[]args) throws Exception {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/iframe");
		driver.manage().window().maximize();
		driver.switchTo().frame(driver.findElement(By.id("mce_0_ifr")));
		Thread.sleep(3000);
		WebElement content = driver.findElement(By.xpath("//p[contains(text(), 'content')]"));
		content.click();
		String a =content.getText();
		System.out.println(a);
		
	}

}
