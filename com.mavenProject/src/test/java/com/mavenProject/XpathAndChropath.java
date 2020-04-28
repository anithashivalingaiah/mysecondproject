package com.mavenProject;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class XpathAndChropath {
	
	public static void main(String[] args) throws Exception {
		
		WebDriver dr = null;
		WebDriverManager.chromedriver().setup();
		dr = new ChromeDriver();
		//dr.get("https://www.google.com");
		dr.manage().window().maximize();
		//Thread.sleep(2000);
		dr.get("https://www.macys.com");
		//WebElement menu = dr.findElement(By.xpath("//input[@placeholder='Search or enter web ID']"));
		//WebElement contains = dr.findElement(By.xpath("//button[contains(@aria-label, 'Submit product search')]"));
		//Thread.sleep(2000);
		//contains.click();
		//WebElement drop = dr.findElement(By.id("shopByDepartmentDropdownList"));
		//WebElement caret = dr.findElement(By.id("showByDepartmentCaret"));
		//Thread.sleep(2000);
		//caret.click();
		//Select menu = new Select(drop);
		//menu.selectByIndex(2);
		//menu.selectByValue("Open sale & clearance flyout");
		Thread.sleep(2000);
		WebElement signInElement= dr.findElement(By.xpath("//span[contains(text(), 'Sign In')]"));
		signInElement.click();
		//Actions elementAction = new Actions(dr);
		//elementAction.moveToElement(signInElement).build().perform();
		
		//WebElement orderHistoryElement = dr.findElement(By.xpath("/html/body/header/div/div/div/section[1]/div/div/div[3]/nav/ul/li/ul/li[3]/a")) ;
		//elementAction.moveToElement(orderHistoryElement).build().perform();
		//elementAction.click(orderHistoryElement).build().perform();


		/*Select account2 = new Select(signInElement);
		
		//account2.selectByIndex(1);
		account2.selectByVisibleText("Profile");
		//account2.
		
		Actions myAccountAction = new Actions(dr);*/
	//	myAccountAction.contextClick(account2) ;
		//((WebElement) account2).click();
		//("//span[contains(text(), 'Sign In')]"));
		//sign.click();
		
				
		
		//dr.quit();
		
	}
	

}
