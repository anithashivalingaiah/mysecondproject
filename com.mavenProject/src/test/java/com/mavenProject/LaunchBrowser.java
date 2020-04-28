package com.mavenProject;

import org.jsoup.select.Evaluator.Id;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LaunchBrowser {
	
	public static void main(String[]args) throws InterruptedException {
		
		String expectedright= "Right";
		//System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
		WebDriver driver = null;
		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();
		
		driver.get("https://www.google.com");
		driver.manage().window().maximize();
		driver.get("https://qa-tekarch.firebaseapp.com");
		//driver.close();
		Thread.sleep(5000);
		//driver.findElement(By.id("email_field")).sendKeys("admin123@gmail.com");
		//driver.findElement(By.id("password_field")).sendKeys("love");
		driver.findElement(By.xpath("//input[@placeholder='Email...']")).sendKeys("admin123@gmail.com");
		driver.findElement(By.xpath("//input[@placeholder='Password...']")).sendKeys("admin123");
		//driver.findElement(By.xpath("//div[@id='login_div']/h3")).getText();
		//System.out.println(driver.findElement(By.xpath("//div[@id='login_div']/h3")).getText());
		WebElement button = driver.findElement(By.xpath("//button[contains(text(),'Login to Account')]"));
		button.click();
		Thread.sleep(2000);
		WebElement fullname = driver.findElement(By.xpath("//input[@id='name']"));
		fullname.sendKeys("anitha");
		//fullname.sendKeys("shivalingaiah");
		//Thread.sleep(2000);
		WebElement frname = driver.findElement(By.xpath("//input[@placeholder=\"father name..\"]"));
		frname.sendKeys("Shivalingaiah");
		WebElement post = driver.findElement(By.id("postaladdress"));
		post.sendKeys("123 , magnolia ln, texas");
		WebElement personal = driver.findElement(By.id("personaladdress"));
		personal.sendKeys("123, bangalore, india");
		WebElement radio1 = driver.findElement(By.xpath("//span[1]//input[1]"));
		System.out.println(radio1.isSelected());
		WebElement radio = driver.findElement(By.xpath("//span[2]//input[1]"));
		System.out.println(radio.isSelected());
		radio.click();
		WebElement city = driver.findElement(By.id("city"));
		
		//WebElement String=null;
		Select menu = new Select(city );
		//city1.selectByVisibleText("GOA");
		//city1.selectByIndex(2);
		menu.selectByValue("patna");
		WebElement course = driver.findElement(By.id("course"));
		Select menu2 = new Select(course );
		//menu2.selectByVisibleText("MBA");
		//menu2.selectByIndex(1);
		menu2.selectByValue("bca");
		WebElement district = driver.findElement(By.id("district"));
		Select menu3 = new Select(district);
		//menu3.selectByIndex(3);
		//menu3.selectByValue("patna");
		menu3.selectByVisibleText("MUMBAI");
		WebElement state = driver.findElement(By.id("state"));
		Select menu4 = new Select(state);
		//menu4.selectByIndex(4);
		//menu4.selectByValue("mba");
		menu4.selectByVisibleText("NALANDA");
		WebElement pin = driver.findElement(By.id("pincode"));
		pin.sendKeys("34526");
		WebElement link = driver.findElement(By.id("emailid"));
		link.sendKeys("anitha@yahoo.com");
		Thread.sleep(5000);
		WebElement boot = driver.findElement(By.xpath("//button[@class='bootbutton']"));
		boot.click();
		WebElement mousehover = driver.findElement(By.xpath("//button[contains(text(), 'Intractions')]"));		
		Actions act = new Actions(driver);
		act.moveToElement(mousehover).build().perform();
		WebElement tooltip = driver.findElement(By.xpath("//a[contains(@href, './tooltip.html')]"));
		tooltip.click();
		// 
		WebDriverWait wait = new WebDriverWait(driver, 30);
		//wait.until(ExpectedConditions.visibilityOf
		WebElement toolright1 =driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[2]/div[1]"));
		//WebElement toolright=driver.findElement(By.xpath("//span[contains(text(), 'Right')]"));
		WebElement actualtoolright=driver.findElement(By.xpath("//span[@class='tooltiptextr']"));
		Actions act1 = new Actions(driver);
		act1.clickAndHold().moveToElement(actualtoolright).build().perform();
		String actualright = actualtoolright.getAttribute("title");
		System.out.println("actualright" + actualright);
		if(actualright.equals(expectedright)) {
			System.out.println("test case passed");	
			}	
	}
}
