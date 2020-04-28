package salesforce_test;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import salesforce_utility.Login_helper;
import salesforce_utility.UserDataExcel;

public class RandonScenariosTest extends UserDataExcel {
	
	String userxpath = "//input[@id='username']";
	String passxpath = "//input[@id='password']";

	public RandonScenariosTest() throws Exception {
		super();		
	}
	
	public void TC33verifyFirstLastName() throws Exception {
		
		UserDataExcel excel = new UserDataExcel();
		Login_helper helper = new Login_helper();
		
		helper.launchApplication(getcelllaunch(), getcelllogin());
		helper.login(getcellUser(), getcellPassword(), userxpath, passxpath);
		WebElement login = helper.getDriver().findElement(By.xpath("//input[@id='Login']"));
		login.click();	
		Thread.sleep(2000);
		WebElement homeTab = helper.getDriver().findElement(By.xpath("//a[@title='Home Tab']"));
		homeTab.click();
		Thread.sleep(2000);		
		WebElement userlink = helper.getDriver().findElement(By.xpath("//h1[@class='currentStatusUserName']"));
		Actions act = new Actions(helper.getDriver());
		act.moveToElement(userlink).build().perform();
		userlink.click();
		WebElement userIconOnTop = helper.getDriver().findElement(By.xpath("//span[@id='userNavLabel']"));
		userIconOnTop.click();
		WebElement myProfile= helper.getDriver().findElement(By.xpath("//a[@title='My Profile']"));
		myProfile.click();
		/**************not sure how to verify that "my profile and userlink" are landing on the same page************/
		}
	
	public void TC34verifyLastNameUpdatedEverywhere() throws Exception {
		
		UserDataExcel excel = new UserDataExcel();
		Login_helper helper = new Login_helper();
		
		helper.launchApplication(getcelllaunch(), getcelllogin());
		helper.login(getcellUser(), getcellPassword(), userxpath, passxpath);
		WebElement login = helper.getDriver().findElement(By.xpath("//input[@id='Login']"));
		login.click();	
		Thread.sleep(2000);
		WebElement homeTab = helper.getDriver().findElement(By.xpath("//a[@title='Home Tab']"));
		homeTab.click();
		Thread.sleep(2000);	
		WebElement firstLastUser = helper.getDriver().findElement(By.xpath("//h1[@class='currentStatusUserName']"));
		firstLastUser.click();
		Thread.sleep(2000);
		WebElement pecilIcon = helper.getDriver().findElement(By.xpath("//a[@class='contactInfoLaunch editLink']"));
		pecilIcon.click();
		Thread.sleep(2000);
		WebElement iframe = helper.getDriver().findElement(By.xpath("//iframe[@id='contactInfoContentId']"));
		helper.getDriver().switchTo().frame(iframe);
		WebElement aboutTab = helper.getDriver().findElement(By.xpath("//li[@id='aboutTab']"));
		aboutTab.click();
		WebElement lastName = helper.getDriver().findElement(By.xpath("//input[@id='lastName']"));		
		lastName.click();	
		lastName.clear();
		lastName.sendKeys("ABcd");
		WebElement saveAll = helper.getDriver().findElement(By.xpath("//input[@value='Save All']"));
		saveAll.click();
		helper.getDriver().switchTo().defaultContent();
		WebElement userMenuOnTop= helper.getDriver().findElement(By.xpath("//div[@id='userNavButton']/span[contains(text(), 'ABcd')]"));
		userMenuOnTop.click();	
		
		/********* the code is working not sure how to verify,**********/
	}
	
	public void TC35tabCustomisation() throws Exception {
		
		UserDataExcel excel = new UserDataExcel();
		Login_helper helper = new Login_helper();
		
		helper.launchApplication(getcelllaunch(), getcelllogin());
		helper.login(getcellUser(), getcellPassword(), userxpath, passxpath);
		WebElement login = helper.getDriver().findElement(By.xpath("//input[@id='Login']"));
		login.click();	
		Thread.sleep(2000);
		WebElement allTabs = helper.getDriver().findElement(By.xpath("//img[@title='All Tabs']"));
		allTabs.click();
		Thread.sleep(2000);
		WebElement customiseMyTabs = helper.getDriver().findElement(By.xpath("//input[@value='Customize My Tabs']"));
		customiseMyTabs.click();
		WebElement selectedTabs = helper.getDriver().findElement(By.xpath("//select[@id='duel_select_1']"));
		selectedTabs.click();
		Select type16 = new Select(selectedTabs);
		type16.selectByValue("Chatter");
		WebElement removeArrow = helper.getDriver().findElement(By.xpath("//a[@id='duel_select_0_left']"));
		removeArrow.click();
		WebElement saveButton= helper.getDriver().findElement(By.xpath("//td[@id='bottomButtonRow']//input[@value=' Save ']"));
		saveButton.click();
		Thread.sleep(2000);
		WebElement userMenuOnTop = helper.getDriver().findElement(By.xpath("//div[@id='userNavMenu']"));
		//Actions act = new Actions(helper.getDriver());
		//act.moveToElement(userMenuOnTop).build().perform();
		userMenuOnTop.click();
		WebElement logOutLink = helper.getDriver().findElement(By.xpath("//a[@title='Logout']"));
		logOutLink.click();
		
		/**************very inconsistant behaviour, sometimes code works, sometimes gives errors**********/		
		
	}
	
	public void TC36blockingEventCalendar() throws Exception {
		
		UserDataExcel excel = new UserDataExcel();
		Login_helper helper = new Login_helper();
		
		helper.launchApplication(getcelllaunch(), getcelllogin());
		helper.login(getcellUser(), getcellPassword(), userxpath, passxpath);
		WebElement login = helper.getDriver().findElement(By.xpath("//input[@id='Login']"));
		login.click();	
		Thread.sleep(2000);
		WebElement homeTab = helper.getDriver().findElement(By.xpath("//a[@title='Home Tab']"));
		homeTab.click();
		Thread.sleep(2000);	
		WebElement currentDateLink = helper.getDriver().findElement(By.xpath("//a[contains(text(), 'Tuesday April 28, 2020')]"));
		currentDateLink.click();
		Thread.sleep(2000);
		WebElement timeLink= helper.getDriver().findElement(By.xpath("//div[@id='p:f:j_id25:j_id61:28:j_id64']"));
		timeLink.click();
		WebElement subjectCombo = helper.getDriver().findElement(By.xpath("//img[@title='Subject Combo (New Window)']"));
		subjectCombo.click();
		Thread.sleep(2000);
		ArrayList<String>windowList = new ArrayList<String>(helper.getDriver().getWindowHandles());		
		helper.getDriver().switchTo().window(windowList.get(1));		
		WebElement newWindow = helper.getDriver().findElement(By.xpath("//h1[contains(text(), 'Select a Subject')]"));		
		WebElement otherLink = helper.getDriver().findElement(By.xpath("//a[contains(text(), 'Other')]"));
		Actions act = new Actions(helper.getDriver());
		//act.moveToElement(otherInNewWindow).build().perform();
		otherLink.click();
		//WebElement endBlock = helper.getDriver().findElement(By.xpath("//label[@for='EndDateTime']"));
		
		WebElement endTimelist= helper.getDriver().findElement(By.xpath("//span[@class='timeInput']//input[@id='EndDateTime_time']"));
		act.moveToElement(endTimelist).build().perform();
		endTimelist.click();
		/*************the driver is switching to new window, selecting the "other" element, but not able to select end time
		 * from the drop down, need to work on this***********/		
	}
			

}
