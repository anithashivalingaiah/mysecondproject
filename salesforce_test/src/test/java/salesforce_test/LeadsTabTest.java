package salesforce_test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import salesforce_utility.Login_helper;
import salesforce_utility.UserDataExcel;

public class LeadsTabTest extends UserDataExcel {
	
	String userxpath = "//input[@id='username']";
	String passxpath = "//input[@id='password']";
	WebElement login;
	WebElement leadsTab;
	WebElement goButton;

	public LeadsTabTest() throws Exception {
		super();		
	}
	
	public void TC20leadsTab() throws Exception {
		Login_helper helper = new Login_helper();
		UserDataExcel excel = new UserDataExcel();
		helper.launchApplication(getcelllaunch(), getcelllogin());
		helper.login(getcellUser(), getcellPassword(), userxpath, passxpath);
		WebElement login = helper.getDriver().findElement(By.xpath("//input[@id='Login']"));
		login.click();
		Thread.sleep(3000);
		this.leadsTab = helper.getDriver().findElement(By.xpath("//a[@title='Leads Tab']"));
		this.leadsTab.click();
		
	}
	
	public void TC21leadsDropDown () throws Exception {
		Login_helper helper = new Login_helper();
		UserDataExcel excel = new UserDataExcel();
		helper.launchApplication(getcelllaunch(), getcelllogin());
		helper.login(getcellUser(), getcellPassword(), userxpath, passxpath);
		WebElement login = helper.getDriver().findElement(By.xpath("//input[@id='Login']"));
		login.click();
		Thread.sleep(3000);
		WebElement leadsTab = helper.getDriver().findElement(By.xpath("//a[@title='Leads Tab']"));
		leadsTab.click();
		Thread.sleep(2000);
		List<WebElement> leadsDropDown = helper.getDriver().findElements(By.xpath("//select[@id='fcf']"));
		for(int i=0; i<leadsDropDown.size(); i++) {
			System.out.println(leadsDropDown.get(i).getText());
		}
		/****************its printing the list of leads but driver not clicking on dropdown list***********/		
	}
	
	public void TC22defaultView() throws Exception {
		
		Login_helper helper = new Login_helper();
		UserDataExcel excel = new UserDataExcel();
		helper.launchApplication(getcelllaunch(), getcelllogin());
		helper.login(getcellUser(), getcellPassword(), userxpath, passxpath);
		//WebElement rememeberMe = helper.getDriver().findElement(By.xpath("//input[@type='checkbox']"));
		//rememeberMe.click();
		//Thread.sleep(2000);
		WebElement login = helper.getDriver().findElement(By.xpath("//input[@id='Login']"));
		login.click();
		Thread.sleep(3000);
		WebElement leadsTab = helper.getDriver().findElement(By.xpath("//a[@title='Leads Tab']"));
		leadsTab.click();
		Thread.sleep(2000);
		WebElement leadsDropDown = helper.getDriver().findElement(By.xpath("//select[@id='fcf']"));
		leadsDropDown.click();
		Select type13 = new Select(leadsDropDown);
		type13.selectByValue("00B5w00000DACUh");
		
		this.goButton = helper.getDriver().findElement(By.xpath("//input[@value=' Go! ']"));
		goButton.click();
		Thread.sleep(3000);
		WebElement userName = helper.getDriver().findElement(By.xpath("//div[@id='userNav-arrow']"));
		userName.click();
		WebElement logOut = helper.getDriver().findElement(By.xpath("//a[@class='menuButtonMenuLink'][@title='Logout']"));
		logOut.click();
		helper.launchApplication(getcelllaunch(), getcelllogin());
		helper.login(getcellUser(), getcellPassword(), userxpath, passxpath);
		//Thread.sleep(2000);
		this.login = helper.getDriver().findElement(By.xpath("//input[@id='Login']"));
		this.login.click();
		Thread.sleep(3000);
		this.leadsTab = helper.getDriver().findElement(By.xpath("//a[@title='Leads Tab']"));
		this.leadsTab.click();
		Thread.sleep(2000);
		this.goButton = helper.getDriver().findElement(By.xpath("//input[@value=' Go! ']"));
		this.goButton.click();
	}
	
	public void TC23todaysLeads() throws Exception {
		
		Login_helper helper = new Login_helper();
		UserDataExcel excel = new UserDataExcel();
		helper.launchApplication(getcelllaunch(), getcelllogin());
		helper.login(getcellUser(), getcellPassword(), userxpath, passxpath);
		//WebElement rememeberMe = helper.getDriver().findElement(By.xpath("//input[@type='checkbox']"));
		//rememeberMe.click();
		//Thread.sleep(2000);
		WebElement login = helper.getDriver().findElement(By.xpath("//input[@id='Login']"));
		login.click();
		Thread.sleep(3000);
		WebElement leadsTab = helper.getDriver().findElement(By.xpath("//a[@title='Leads Tab']"));
		leadsTab.click();
		Thread.sleep(2000);
		WebElement leadsDropDown = helper.getDriver().findElement(By.xpath("//select[@id='fcf']"));
		leadsDropDown.click();
		Select type13 = new Select(leadsDropDown);
		type13.selectByValue("00B5w00000DACUh");
		
		this.goButton = helper.getDriver().findElement(By.xpath("//input[@value=' Go! ']"));
		goButton.click();
		Thread.sleep(3000);		
	}
	
	public void TC24createNewLeads() throws Exception {
		Login_helper helper = new Login_helper();
		UserDataExcel excel = new UserDataExcel();
		helper.launchApplication(getcelllaunch(), getcelllogin());
		helper.login(getcellUser(), getcellPassword(), userxpath, passxpath);
		//WebElement rememeberMe = helper.getDriver().findElement(By.xpath("//input[@type='checkbox']"));
		//rememeberMe.click();
		//Thread.sleep(2000);
		WebElement login = helper.getDriver().findElement(By.xpath("//input[@id='Login']"));
		login.click();
		Thread.sleep(3000);
		WebElement leadsTab = helper.getDriver().findElement(By.xpath("//a[@title='Leads Tab']"));
		leadsTab.click();
		Thread.sleep(2000);
		WebElement newLead= helper.getDriver().findElement(By.xpath("//input[@value=' New ']"));
		newLead.click();
		WebElement lastNameFld = helper.getDriver().findElement(By.xpath("//input[@id='name_lastlea2']"));
		lastNameFld.click();
		lastNameFld.sendKeys("ABCD");
		WebElement companyNameFld = helper.getDriver().findElement(By.xpath("//input[@id='lea3']"));
		companyNameFld.click();
		companyNameFld.sendKeys("ABCD");
		WebElement saveButton = helper.getDriver().findElement(By.xpath("//td[@id='topButtonRow']//input[@value= ' Save ']"));
		saveButton.click();
		
	}
	

}
