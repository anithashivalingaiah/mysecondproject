package com.mavenProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WrtingXpath {
	
	public static void main(String[]args) throws Exception {
		
		String Expectedtip = "Advanced Search";
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.ebay.com");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		//WebDriverWait wait = new WebDriverWait(driver, 2);
		//wait.withTimeout(2);
		WebElement dropdown = driver.findElement(By.xpath("//select[@aria-label='Select a category for search']"));
		Select dropdownmenu = new Select(dropdown);
		dropdownmenu.selectByVisibleText("Books");
		Thread.sleep(5000);
		WebElement search = driver.findElement(By.xpath("//input[@class='btn btn-prim gh-spr']"));
		search.click();
		WebElement catalog = driver.findElement(By.xpath("//a[contains(@href, 'https://www.ebay.com/b/Catalogs/118254/bn_1857664')]"));
		catalog.click();
		//WebElement globalsearch = driver.findElement(By.xpath("//input[@class='gh-tb ui-autocomplete-input']"));
		//globalsearch.sendKeys("rugs");
		//WebElement search2 = driver.findElement(By.xpath("//input[@class='btn btn-prim gh-spr']"));
		//search2.click();
		WebElement advanced = driver.findElement(By.xpath("//a[contains(@href, 'https://www.ebay.com/sch/ebayadvsearch')]"));
		String actualtip = advanced.getAttribute("title");
		Thread.sleep(2000);
		Actions act = new Actions(driver);
		act.clickAndHold().moveToElement(advanced).build().perform();
		//act.moveToElement(advanced).build().perform();
		//WebElement tooltip = driver.findElement(By.xpath("//a[@title='Advanced Search']"));
		
		System.out.println("actualtip is" + actualtip);
		if(actualtip.equals(Expectedtip)) {
			System.out.println("test case passed");
		}
		
		
	}

}
