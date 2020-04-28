package salesforce_utility;

import org.apache.poi.EmptyFileException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Login_helper extends UserDataExcel{
	
	WebDriver driver;
	
	public Login_helper() throws Exception {
		WebDriverManager.chromedriver().setup();
		this.driver = new ChromeDriver();		
	}
	
	public WebDriver getDriver() {
		return this.driver;
		
	}
	
	
	public void launchApplication(String launchurl, String loginurl) throws Exception {
		UserDataExcel excel = new UserDataExcel();		
		this.driver.get(excel.getcelllaunch());	
		this.driver.manage().window().maximize();
		this.driver.get(excel.getcelllogin());
		
	}
	
	public void login(String username, String password, String userxpath, String passxpath) throws Exception {
		
		WebElement userfield = this.driver.findElement(By.xpath(userxpath));
		userfield.sendKeys(username);
		WebElement passfield  = this.driver.findElement(By.xpath(passxpath));
		passfield.sendKeys(password);
		
		//return ele1;
		
	}

}
