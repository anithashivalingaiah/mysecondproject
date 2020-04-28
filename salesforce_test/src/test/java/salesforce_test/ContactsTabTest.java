package salesforce_test;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import salesforce_utility.Login_helper;
import salesforce_utility.UserDataExcel;

public class ContactsTabTest extends UserDataExcel {
	
	String userxpath = "//input[@id='username']";
	String passxpath = "//input[@id='password']";

	public ContactsTabTest() throws Exception {
		super();		
	}
	
	public void TC25createNewContact() throws Exception {
		
		UserDataExcel excel = new UserDataExcel();
		Login_helper helper = new Login_helper();
		
		helper.launchApplication(getcelllaunch(), getcelllogin());
		helper.login(getcellUser(), getcellPassword(), userxpath, passxpath);
		WebElement login = helper.getDriver().findElement(By.xpath("//input[@id='Login']"));
		login.click();	
		WebElement contactTab = helper.getDriver().findElement(By.id("Contact_Tab"));
		contactTab.click();
		Thread.sleep(2000);
		WebElement newButton  = helper.getDriver().findElement(By.xpath("//input[@value=' New ']"));
		newButton.click();
		WebElement lastName = helper.getDriver().findElement(By.xpath("//div/input[@id='name_lastcon2']"));
		lastName.click();
		lastName.sendKeys(excel.getcelllastName());
		WebElement accName = helper.getDriver().findElement(By.xpath("//input[@id='con4']"));
		accName.click();
		accName.sendKeys("Clear Optics Pvt");
		WebElement saveButton = helper.getDriver().findElement(By.xpath("//td[@id='topButtonRow']//input[@value=' Save ']"));
		saveButton.click();
	}
	
	public void TC26createNewView() throws Exception {
		
		UserDataExcel excel = new UserDataExcel();
		Login_helper helper = new Login_helper();
		
		helper.launchApplication(getcelllaunch(), getcelllogin());
		helper.login(getcellUser(), getcellPassword(), userxpath, passxpath);
		WebElement login = helper.getDriver().findElement(By.xpath("//input[@id='Login']"));
		login.click();	
		WebElement contactTab = helper.getDriver().findElement(By.id("Contact_Tab"));
		contactTab.click();
		Thread.sleep(2000);
		WebElement createNewView = helper.getDriver().findElement(By.xpath("//span[@class='fFooter']//a[contains(text(), 'Create New View')]"));
		createNewView.click();
		WebElement viewName = helper.getDriver().findElement(By.xpath("//div/input[@id='fname']"));
		viewName.click();
		viewName.sendKeys("my priority");
		WebElement viewUnique = helper.getDriver().findElement(By.xpath("//div/input[@id='devname']"));
		viewUnique.click();
		WebElement saveButton = helper.getDriver().findElement(By.xpath("//div[@class='pbHeader']//td[@class='pbButtonb']//input[@title='Save']"));
		saveButton.click();		
	}
	
	public void TC27recentContact() throws Exception {
		UserDataExcel excel = new UserDataExcel();
		Login_helper helper = new Login_helper();
		
		helper.launchApplication(getcelllaunch(), getcelllogin());
		helper.login(getcellUser(), getcellPassword(), userxpath, passxpath);
		WebElement login = helper.getDriver().findElement(By.xpath("//input[@id='Login']"));
		login.click();	
		WebElement contactTab = helper.getDriver().findElement(By.id("Contact_Tab"));
		contactTab.click();
		Thread.sleep(2000);
		
		WebElement recentDropDown = helper.getDriver().findElement(By.xpath("//select[@id='hotlist_mode']"));
		recentDropDown.click();
		Select type14 = new Select(recentDropDown);
		type14.selectByValue("2");		
	}
	
	public void TC28MyContactsView() throws Exception {
		
		UserDataExcel excel = new UserDataExcel();
		Login_helper helper = new Login_helper();
		
		helper.launchApplication(getcelllaunch(), getcelllogin());
		helper.login(getcellUser(), getcellPassword(), userxpath, passxpath);
		WebElement login = helper.getDriver().findElement(By.xpath("//input[@id='Login']"));
		login.click();	
		WebElement contactTab = helper.getDriver().findElement(By.id("Contact_Tab"));
		contactTab.click();
		Thread.sleep(2000);
		WebElement viewDropDown = helper.getDriver().findElement(By.xpath("//span/select[@id='fcf']"));
		viewDropDown.click();
		Thread.sleep(2000);
		Select type15 = new Select(viewDropDown);		
		type15.selectByValue("00B5w00000DACVO");
		WebElement goButton = helper.getDriver().findElement(By.xpath("//input[@value=' Go! ']"));
		goButton.click();		
	}
	
	public void TC29viewContactName() throws Exception {
		UserDataExcel excel = new UserDataExcel();
		Login_helper helper = new Login_helper();
		
		helper.launchApplication(getcelllaunch(), getcelllogin());
		helper.login(getcellUser(), getcellPassword(), userxpath, passxpath);
		WebElement login = helper.getDriver().findElement(By.xpath("//input[@id='Login']"));
		login.click();	
		WebElement contactTab = helper.getDriver().findElement(By.id("Contact_Tab"));
		contactTab.click();
		Thread.sleep(2000);
		WebElement recentItem = helper.getDriver().findElement(By.xpath("//div[@id='mru0035w000033b1kU']"));
		Actions act = new Actions(helper.getDriver());
		//act.moveToElement(recentItem).build().perform();
		recentItem.click();
		ArrayList<String> windowlist = new ArrayList<String>(helper.getDriver().getWindowHandles());
		helper.getDriver().switchTo().window(windowlist.get(0));
		
		WebElement tinyWindow = helper.getDriver().findElement(By.xpath("//div[contains(@class,'mruList individualPalette')]"
				+ "//div[2]//div[1]//div[1]//div[1]//div[1]//div[1]//table[1]//tbody[1]//tr[1]//td[2]//input[1]"));
		act.moveToElement(tinyWindow).build().perform();
		tinyWindow.click();
		/******************not sure what the recent contact is present, but the recent items on left side, opens a 
		 * small window, not able to switch to that, also this "recent item" is a dynamic element**********/		
		
	}
	
	public void TC30newViewErrorMessage() throws Exception {
		
		UserDataExcel excel = new UserDataExcel();
		Login_helper helper = new Login_helper();
		
		helper.launchApplication(getcelllaunch(), getcelllogin());
		helper.login(getcellUser(), getcellPassword(), userxpath, passxpath);
		WebElement login = helper.getDriver().findElement(By.xpath("//input[@id='Login']"));
		login.click();	
		WebElement contactTab = helper.getDriver().findElement(By.id("Contact_Tab"));
		contactTab.click();
		Thread.sleep(2000);
		WebElement createNewView = helper.getDriver().findElement(By.xpath("//span[@class='fFooter']//a[contains(text(), 'Create New View')]"));
		createNewView.click();
		WebElement viewUnique = helper.getDriver().findElement(By.xpath("//div/input[@id='devname']"));
		viewUnique.click();
		viewUnique.sendKeys("EFGH");
		WebElement saveButton = helper.getDriver().findElement(By.xpath("//div[@class='pbHeader']//td[@class='pbButtonb']//input[@title='Save']"));
		saveButton.click();		
		
	}
	
	public void TC31checkCancelInNewView() throws Exception {
		
		UserDataExcel excel = new UserDataExcel();
		Login_helper helper = new Login_helper();
		
		helper.launchApplication(getcelllaunch(), getcelllogin());
		helper.login(getcellUser(), getcellPassword(), userxpath, passxpath);
		WebElement login = helper.getDriver().findElement(By.xpath("//input[@id='Login']"));
		login.click();	
		WebElement contactTab = helper.getDriver().findElement(By.id("Contact_Tab"));
		contactTab.click();
		Thread.sleep(2000);
		WebElement createNewView = helper.getDriver().findElement(By.xpath("//span[@class='fFooter']//a[contains(text(), 'Create New View')]"));
		createNewView.click();
		WebElement viewName = helper.getDriver().findElement(By.xpath("//div/input[@id='fname']"));
		viewName.click();
		viewName.sendKeys("ABCD");
		WebElement viewUnique = helper.getDriver().findElement(By.xpath("//div/input[@id='devname']"));
		viewUnique.click();
		viewUnique.sendKeys("EFGH");
		WebElement cancelButton = helper.getDriver().findElement(By.xpath("//div[@class='pbHeader']//input[@class='btn']"));
		cancelButton.click();		
	}
	
	public void TC32checkSaveAndNew( ) throws Exception {
		
		UserDataExcel excel = new UserDataExcel();
		Login_helper helper = new Login_helper();
		
		helper.launchApplication(getcelllaunch(), getcelllogin());
		helper.login(getcellUser(), getcellPassword(), userxpath, passxpath);
		WebElement login = helper.getDriver().findElement(By.xpath("//input[@id='Login']"));
		login.click();	
		WebElement contactTab = helper.getDriver().findElement(By.id("Contact_Tab"));
		contactTab.click();
		Thread.sleep(2000);
		WebElement newButton  = helper.getDriver().findElement(By.xpath("//input[@value=' New ']"));
		newButton.click();
		Thread.sleep(2000);
		WebElement lastName = helper.getDriver().findElement(By.xpath("//div/input[@id='name_lastcon2']"));
		lastName.click();
		lastName.sendKeys("Indian");
		WebElement accName = helper.getDriver().findElement(By.xpath("//input[@id='con4']"));
		accName.click();
		accName.sendKeys("Global Media");
		WebElement saveAndNew = helper.getDriver().findElement(By.xpath("//div[@class='pbHeader']//input[@value='Save & New']"));
		saveAndNew.click();
		
		/*********it fails, as the account name "Gloabal Media" does not exist in the database*********/
		
		
	}

}
