package salesforce_test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import salesforce_utility.Login_helper;
import salesforce_utility.UserDataExcel;

public class AccountsTabTest extends UserDataExcel{
	
	String userxpath = "//input[@id='username']";
	String passxpath = "//input[@id='password']";

	public AccountsTabTest() throws Exception {
		super();		
	}
	
	public void TC10CreateAcc() throws Exception {
		
		Login_helper helper = new Login_helper();
		UserDataExcel excel = new UserDataExcel();
		helper.launchApplication(getcelllaunch(), getcelllogin());
		helper.login(getcellUser(), getcellPassword(), userxpath, passxpath);
		WebElement login = helper.getDriver().findElement(By.xpath("//input[@id='Login']"));
		login.click();
		Thread.sleep(3000);
		WebElement accountsTab = helper.getDriver().findElement(By.xpath("//li[@id='Account_Tab']"));
		accountsTab.click();
		/****************the user name does not appear by default when you click on "accounts" tab *******/
		 
		WebElement newAccButton = helper.getDriver().findElement(By.xpath("//td/input[@class='btn']"));
		Thread.sleep(3000);
		newAccButton.click();		
		WebElement accNameFld = helper.getDriver().findElement(By.xpath("//input[@id='acc2']"));
		accNameFld.click();
		accNameFld.sendKeys("Clear Optics Pvt");
		WebElement typeDropDown = helper.getDriver().findElement(By.xpath("//select[@id='acc6']"));
		typeDropDown.click();
		Thread.sleep(2000);
		Select type = new Select(typeDropDown);
		type.selectByValue("Technology Partner");
		WebElement priorityDropDown = helper.getDriver().findElement(By.xpath("//select[@id='00N5w00000HeVYm']"));
		priorityDropDown.click();
		Select type2 = new Select(priorityDropDown);
		type2.selectByIndex(1);
		WebElement saveAccButton = helper.getDriver().findElement(By.xpath("//td[@class='pbButton']//input[@value=' Save ']"));
		saveAccButton.click();
		
	}
	
	public void TC11createNewView() throws Exception {
		Login_helper helper = new Login_helper();
		UserDataExcel excel = new UserDataExcel();
		helper.launchApplication(getcelllaunch(), getcelllogin());
		helper.login(getcellUser(), getcellPassword(), userxpath, passxpath);
		WebElement login = helper.getDriver().findElement(By.xpath("//input[@id='Login']"));
		login.click();
		
		WebElement accountsTab = helper.getDriver().findElement(By.xpath("//li[@id='Account_Tab']"));
		accountsTab.click();
		Thread.sleep(3000);
		
		/****************the user name does not appear by default when you click on "accounts" tab *******/
		
		WebElement newView = helper.getDriver().findElement(By.xpath("//a[contains(text(), 'Create New View')]"));
		newView.click();
		Thread.sleep(2000);
		WebElement viewName = helper.getDriver().findElement(By.xpath("//input[@id='fname']"));
		viewName.click();		
		viewName.sendKeys("My first");		
		WebElement uniqueViewName= helper.getDriver().findElement(By.xpath("//input[@id='devname']"));
		uniqueViewName.click();
		uniqueViewName.sendKeys("My_first");
		WebElement saveButton= helper.getDriver().findElement(By.xpath("//div[@class='pbHeader']//input[@name='save']"));
		saveButton.click();
		
		/***********need to delete the "new view" after everytime the program is executed, as duplicate names
		  			will not be accepted***********/		 
		
	}
	
	public void TC12editView() throws Exception {
		Login_helper helper = new Login_helper();
		UserDataExcel excel = new UserDataExcel();
		helper.launchApplication(getcelllaunch(), getcelllogin());
		helper.login(getcellUser(), getcellPassword(), userxpath, passxpath);
		WebElement login = helper.getDriver().findElement(By.xpath("//input[@id='Login']"));
		login.click();
		
		WebElement accountsTab = helper.getDriver().findElement(By.xpath("//li[@id='Account_Tab']"));
		accountsTab.click();
		Thread.sleep(3000);
		
		/****************the user name does not appear by default when you click on "accounts" tab *******/
		/*WebElement createnewView = helper.getDriver().findElement(By.xpath("//a[contains(text(), 'Create New View')]"));
		createnewView.click();
		Thread.sleep(2000);
		WebElement viewName = helper.getDriver().findElement(By.xpath("//input[@id='fname']"));
		viewName.click();		
		viewName.sendKeys("My first");		
		WebElement uniqueViewName= helper.getDriver().findElement(By.xpath("//input[@id='devname']"));
		uniqueViewName.click();
		uniqueViewName.sendKeys("My_first");
		WebElement saveButton= helper.getDriver().findElement(By.xpath("//div[@class='pbHeader']//input[@name='save']"));
		saveButton.click();*/
		
		WebElement viewNameDropDown = helper.getDriver().findElement(By.xpath("//select[@id='fcf']"));
		Select type3 = new Select(viewNameDropDown);
		type3.selectByVisibleText("My first");
		Thread.sleep(3000);
		WebElement editView = helper.getDriver().findElement(By.xpath("//span/a[contains(text(), 'Edit')]"));
		editView.click();
		//WebElement editSelectedView = helper.getDriver().findElement(By.xpath("//div/a[contains(text(), 'Edit')]"));
		//editSelectedView.click();
		WebElement editViewName = helper.getDriver().findElement(By.xpath("//input[@id='fname']"));
		editViewName.click();
		editViewName.clear();
		editViewName.sendKeys("new my view");
		Thread.sleep(2000);
		WebElement fieldDropDown = helper.getDriver().findElement(By.xpath("//select[@id='fcol1']"));
		Select type4 = new Select(fieldDropDown);
		type4.selectByValue("ACCOUNT.NAME");
		WebElement operatorDropDown = helper.getDriver().findElement(By.xpath("//select[@title='Operator 1']"));
		Select type5 = new Select(operatorDropDown);
		type5.selectByValue("c");
		WebElement valueFld = helper.getDriver().findElement(By.xpath("//input[@id='fval1']"));
		valueFld.sendKeys("U");
		WebElement availableFlds = helper.getDriver().findElement(By.xpath("//select[@id='colselector_select_0']"));
		Select type6 = new Select(availableFlds);
		Thread.sleep(2000);
		type6.selectByValue("ACCOUNT.LAST_ACTIVITY");
		WebElement addArrow = helper.getDriver().findElement(By.xpath("//a[@id='colselector_select_0_right']"));
		addArrow.click();
		WebElement saveButton =helper.getDriver().findElement(By.xpath("//div[3]//table[1]//tbody[1]//tr[1]//td[2]//input[1]"));
		saveButton.click();
		/**********"account names" are not showing according to value "a" or "A"***********/
		
	}
	public void TC13mergeAccounts() throws Exception {
		Login_helper helper = new Login_helper();
		UserDataExcel excel = new UserDataExcel();
		helper.launchApplication(getcelllaunch(), getcelllogin());
		helper.login(getcellUser(), getcellPassword(), userxpath, passxpath);
		WebElement login = helper.getDriver().findElement(By.xpath("//input[@id='Login']"));
		login.click();
		
		WebElement accountsTab = helper.getDriver().findElement(By.xpath("//li[@id='Account_Tab']"));
		accountsTab.click();
		Thread.sleep(3000);
		
		WebElement mergeAcc = helper.getDriver().findElement(By.xpath("//a[contains(text(), 'Merge Accounts')]"));
		mergeAcc.click();
		/***********need to do autolist***********/
		
	}
	
	public void TC14createAccReport() {
		
		/************calendar: need to work on this**********/
	}
	
	

}
