package salesforce_test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import salesforce_utility.Login_helper;
import salesforce_utility.UserDataExcel;

public class UserMenuDropDownTest extends UserDataExcel{
	
	String userxpath = "//input[@id='username']";
	String passxpath = "//input[@id='password']";
	WebElement userMenubutton;
	

	public UserMenuDropDownTest() throws Exception {
		super();		
	}

	public void TC05UserMenu() throws Exception {
		
		Login_helper helper = new Login_helper();
		UserDataExcel excel = new UserDataExcel();
		helper.launchApplication(getcelllaunch(), getcelllogin());
		helper.login(getcellUser(), getcellPassword(), userxpath, passxpath);
		WebElement login = helper.getDriver().findElement(By.xpath("//input[@id='Login']"));
		login.click();
		Thread.sleep(3000);
		this.userMenubutton  = helper.getDriver().findElement(By.id("userNavLabel"));
		userMenubutton.click();
		}
	
	public void TC06MyProfile() throws Exception {
		
		Login_helper helper = new Login_helper();
		UserDataExcel excel = new UserDataExcel();
		helper.launchApplication(getcelllaunch(), getcelllogin());
		helper.login(getcellUser(), getcellPassword(), userxpath, passxpath);
		WebElement login = helper.getDriver().findElement(By.xpath("//input[@id='Login']"));
		login.click();
		Thread.sleep(3000);
		WebElement userMenubutton = helper.getDriver().findElement(By.id("userNavLabel"));
		userMenubutton.click();
		//TC05UserMenu();
		Actions act = new Actions(helper.getDriver());
		act.moveToElement(userMenubutton).build().perform();
		WebElement myProfileButton = helper.getDriver().findElement(By.xpath("//a[@title='My Profile']"));
		myProfileButton.click();
		Thread.sleep(2000);
		WebElement editArrow = helper.getDriver().findElement(By.xpath("//a[@id='moderatorMutton']"));
		editArrow.click();
		act.moveToElement(editArrow).build().perform();
		WebElement editProfileButton = helper.getDriver().findElement(By.xpath("//a[@title='Edit Profile']"));
		editProfileButton.click();
		helper.getDriver().switchTo().frame(helper.getDriver().findElement(By.id("aboutMeContentId")));
		Thread.sleep(3000);
		WebElement aboutTab = helper.getDriver().findElement(By.xpath("//a[contains(text(),'About')]"));
		aboutTab.click();
		WebElement lastNamefld = helper.getDriver().findElement(By.xpath("//input[@class='lastName zen-inputFull zen-input']"));
		lastNamefld.click();
		lastNamefld.clear();
		lastNamefld.sendKeys(excel.getcelllastName());
		WebElement saveAllButton = helper.getDriver().findElement(By.xpath("//input[@value='Save All']"));
		saveAllButton.click();
		Thread.sleep(2000);
		helper.getDriver().switchTo().activeElement();
		WebElement postTab = helper.getDriver().findElement(By.xpath("//span[contains(@class,'publisherattachtext')]"
				+ "[contains(text(),'Post')]"));		
		postTab.click();
		Thread.sleep(2000);
		helper.getDriver().switchTo().frame(helper.getDriver().findElement(By.xpath("//iframe[@class='cke_wysiwyg_frame cke_reset']")));
		WebElement textFld = helper.getDriver().findElement(By.xpath("//body[contains(@class, 'chatterPublisher')]"));
		textFld.click();
		Thread.sleep(2000);
		textFld.sendKeys("salesforce is the best.");
		helper.getDriver().switchTo().defaultContent();
		//helper.getDriver().switchTo().activeElement();
		/***********not sure what's wrong, but getting errors*********/
		WebElement shareTextButton = helper.getDriver().findElement(By.xpath("//input[@onclick='chatter.getPublisher().submit();']"));
		shareTextButton.click();
		Thread.sleep(2000);
		WebElement fileTab = helper.getDriver().findElement(By.xpath("//li/a[@id='publisherAttachContentPost']"));
		fileTab.click();
		Thread.sleep(2000);
		WebElement uploadFileButton = helper.getDriver().findElement(By.xpath("//a[@id='chatterUploadFileAction']"));
		uploadFileButton.click();
		Thread.sleep(2000);
		
		try {
			WebElement chooseFile = helper.getDriver().findElement(By.xpath("//*[@id='chatterFile']"));
		//WebElement chooseFile = helper.getDriver().findElement(By.xpath("//tr[contains(@class,'chatterFileRowChrome')]//div[contains(@class,'requiredBlock')]"));
			//WebElement chooseFile = helper.getDriver().findElement(By.xpath("//*[@id='chatterFile']"));
		/**	act.moveToElement(chooseFile).build().perform();
			act.contextClick();
			act.click();
			**/
			//chooseFile.click();
			chooseFile.sendKeys("C:\\Users\\pmuniraju\\Documents\\Screenshots\\for_upload_tekarch.png");
			chooseFile.submit();
		}
		catch (Exception e){
			e.printStackTrace();
					}
		WebElement shareButton = helper.getDriver().findElement(By.xpath("//input[@id='publishersharebutton']"));
		shareButton.click();
		Thread.sleep(2000);
		WebElement addPhoto = helper.getDriver().findElement(By.xpath("//a[@id='uploadLink']"));
		act.moveToElement(addPhoto).build().perform();
		addPhoto.click();
		//WebElement linkTab = helper.getDriv.er().findElement(By.xpath("//a[@id='publisherAttachContentPost']"));
		//linkTab.click();
		
	}
	public void TC07mySettingsPersonalLink() throws Exception {
		Login_helper helper = new Login_helper();
		UserDataExcel excel = new UserDataExcel();
		//JavascripExecuter je = (JavascripExecuter)helper.getDriver();
		helper.launchApplication(getcelllaunch(), getcelllogin());
		helper.login(getcellUser(), getcellPassword(), userxpath, passxpath);
		WebElement login = helper.getDriver().findElement(By.xpath("//input[@id='Login']"));
		login.click();
		Thread.sleep(3000);
		
		this.userMenubutton  = helper.getDriver().findElement(By.id("userNavLabel"));
		userMenubutton.click();
		Thread.sleep(2000);
		Actions act = new Actions(helper.getDriver());
		WebElement mySettings = helper.getDriver().findElement(By.xpath("//a[@title='My Settings']"));
		mySettings.click();
		WebElement personalTab = helper.getDriver().findElement(By.id("PersonalInfo_font"));
		personalTab.click();
		WebElement loginHistory = helper.getDriver().findElement(By.xpath("//span[@id='LoginHistory_font']"));
		loginHistory.click();		
		
		Thread.sleep(2000);				
		WebElement displayTab = helper.getDriver().findElement(By.xpath("//span[@id='DisplayAndLayout_font']"));
		act.moveToElement(displayTab).build().perform();
		displayTab.click();
		WebElement customiseTab = helper.getDriver().findElement(By.xpath("//span[@id='CustomizeTabs_font']"));
		customiseTab.click();
		Thread.sleep(2000);
		WebElement customAppSelect= helper.getDriver().findElement(By.xpath("//select[@onchange='javascript:tabSetSelChange(this);']"));
		customAppSelect.click();
		Select customiseTabList = new Select(customAppSelect);
		customiseTabList.selectByValue("02u5w000001bvUL");
		Thread.sleep(2000);
		WebElement availTabs = helper.getDriver().findElement(By.xpath("//select[@name='duel_select_0']"));
		Select availTabsList = new Select(availTabs);
		Thread.sleep(5000);
		
		/**********along with "report" another tab "file" gets added automatically, need to manually remover
		 * "report" and run it again, it works**********/
		
		availTabsList.selectByValue("report");
		Thread.sleep(2000);
		WebElement arrowAdd = helper.getDriver().findElement(By.xpath("//a[@id='duel_select_0_right']"));
		arrowAdd.click();
		WebElement saveButton = helper.getDriver().findElement(By.xpath("//input[@class='btn primary']"));
		saveButton.click();
		/**********reports got added but not showing in the salesforce top page part*********/
		
		WebElement emailTab = helper.getDriver().findElement(By.xpath("//span[@id='EmailSetup_font']"));
		emailTab.click();
		WebElement emailSettings = helper.getDriver().findElement(By.xpath("//a[@id='EmailSettings_font']"));
		emailSettings.click();
		WebElement emailName = helper.getDriver().findElement(By.xpath("//input[@id='sender_name']"));
		emailName.click();
		emailName.clear();
		emailName.sendKeys(excel.getcellfullName());
		WebElement emailId = helper.getDriver().findElement(By.xpath("//div[@class='requiredInput']//input[@id='sender_email']"));
		emailId.click();
		emailId.clear();		
		emailId.sendKeys(excel.getcellemailId());		
		WebElement radioButton = helper.getDriver().findElement(By.xpath("//input[@id='auto_bcc1']"));
		System.out.println(radioButton.isSelected()); 
		WebElement saveEmail = helper.getDriver().findElement(By.xpath("//input[@class='btn primary']"));
		saveEmail.click();
		Thread.sleep(2000);
		
		WebElement calendarAndReminder = helper.getDriver().findElement(By.xpath("//a/span[@id='CalendarAndReminders_font']"));
		//act.moveToElement(calendarAndReminder).build().perform();
		calendarAndReminder.click();
		WebElement activityReminder = helper.getDriver().findElement(By.xpath("//span[@id='Reminders_font']"));
		activityReminder.click();
		WebElement popUpWindow = helper.getDriver().findElement(By.xpath("//input[@value='Open a Test Reminder']"));
		popUpWindow.click();		
	}
	
	public void TC08DeveloperConsole() throws Exception {
		Login_helper helper = new Login_helper();
		UserDataExcel excel = new UserDataExcel();
		helper.launchApplication(getcelllaunch(), getcelllogin());
		helper.login(getcellUser(), getcellPassword(), userxpath, passxpath);
		WebElement login = helper.getDriver().findElement(By.xpath("//input[@id='Login']"));
		login.click();
		Thread.sleep(3000);
		WebElement userMenubutton = helper.getDriver().findElement(By.id("userNavLabel"));
		userMenubutton.click();
		//TC05UserMenu();
		Actions act = new Actions(helper.getDriver());
		act.moveToElement(userMenubutton).build().perform();
		WebElement devConsole = helper.getDriver().findElement(By.xpath("//a[@title='Developer Console (New Window)']"));
		devConsole.click();
		ArrayList<String> newDevWindow=new ArrayList<String> (helper.getDriver().getWindowHandles());
		//System.out.println(newDevWindow.size());
		helper.getDriver().switchTo().window(newDevWindow.get(1));
		helper.getDriver().close();
				
	}
	
	public void TC09LogOutFromUserMenu() throws Exception {
		Login_helper helper = new Login_helper();
		UserDataExcel excel = new UserDataExcel();
		helper.launchApplication(getcelllaunch(), getcelllogin());
		helper.login(getcellUser(), getcellPassword(), userxpath, passxpath);
		WebElement login = helper.getDriver().findElement(By.xpath("//input[@id='Login']"));
		login.click();
		Thread.sleep(3000);
		WebElement userMenubutton = helper.getDriver().findElement(By.id("userNavLabel"));
		userMenubutton.click();
		//TC05UserMenu();
		Actions act = new Actions(helper.getDriver());
		act.moveToElement(userMenubutton).build().perform();
		WebElement logOut = helper.getDriver().findElement(By.xpath("//a[@title='Logout']"));
		logOut.click();
		
		
		
		
		
	}
}
