package com.maven.UserDefinedMethods;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ReusableMethods {
	protected  WebDriver driver;
	
	public ReusableMethods() {
		WebDriverManager.chromedriver().setup();
		this.driver = new ChromeDriver() ;
	}
	
	public WebDriver getDriver() {
		return this.driver ;
	}
	
	public void launchBrowser(String url) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://qa-tekarch.firebaseapp.com");
		//WebDriverWait wait= new WebDriverWait(driver, 30);
		driver.manage().window().maximize();
		
	}
	
	
	public void launchWeb(String url) {
		this.driver.get(url);
		this.driver.manage().window().maximize();
	}
	
	public WebElement findElementByXpathAndHover(String xPath) {
		
		WebElement element = this.driver.findElement(By.xpath(xPath)) ;  
		Actions act = new Actions(this.driver);
		act.moveToElement(element).build().perform();
		return element ;
		
	}
	
	public void findElementByXpathAndClick(String xPath) {
		WebElement element = this.driver.findElement(By.xpath(xPath));  
		element.click();
	}

	public void acceptAlert() {
		Alert al;
		al =this.driver.switchTo().alert();
		System.out.println(al.getText());
		al.accept();

	}
	
	public void loginUser(String username, String password) {
		 
		WebElement emailFld = this.driver.findElement(By.id("email_field"));
		emailFld.sendKeys(username);
		WebElement passwordFld = this.driver.findElement(By.id("password_field"));
		passwordFld.sendKeys(password);
		WebElement login = this.driver.findElement(By.xpath("//button[@onclick='login()']"));
		login.click();
	
	}
	
}
