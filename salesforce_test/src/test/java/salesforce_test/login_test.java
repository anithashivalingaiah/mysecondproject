package salesforce_test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import salesforce_utility.Login_helper;
import salesforce_utility.UserDataExcel;

public class login_test extends UserDataExcel {	
	
	/*launch salesforce app
	 * login by using username and password
	 * check for error message by using blank password field 
	 * 	
	
	/*launch method
	 * login method using username and password	
	*/
	
	public login_test() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	
	String userxpath = "//input[@id='username']";
	String passxpath = "//input[@id='password']";
	String loginxpath = "//input[@id='Login']";
	String password = "";	
	
	public void errorMessageTest() throws Exception {
		
		UserDataExcel excel = new UserDataExcel();
		Login_helper helper = new Login_helper();
		
		helper.launchApplication(excel.getcelllaunch(), excel.getcelllogin());		
		helper.login(excel.getcellUser(), password, userxpath, passxpath);
		WebElement login = helper.getDriver().findElement(By.xpath("//input[@id='Login']"));
		login.click();
	}
	
	public void LoginToSalesforce() throws Exception {
		UserDataExcel excel = new UserDataExcel();
		Login_helper helper = new Login_helper();
		
		helper.launchApplication(getcelllaunch(), getcelllogin());
		helper.login(getcellUser(), getcellPassword(), userxpath, passxpath);
		WebElement login = helper.getDriver().findElement(By.xpath("//input[@id='Login']"));
		login.click();		
	}
	
	public void CheckRememberMe() throws Exception {
		String ExpectedUName = "anitha81@salesforce.com";
		UserDataExcel excel = new UserDataExcel();
		Login_helper helper = new Login_helper();
		
		helper.launchApplication(getcelllaunch(), getcelllogin());
		helper.login(getcellUser(), getcellPassword(), userxpath, passxpath);
		WebElement rememeberMe = helper.getDriver().findElement(By.xpath("//input[@type='checkbox']"));
		rememeberMe.click();
		Thread.sleep(2000);
		WebElement login = helper.getDriver().findElement(By.xpath("//input[@id='Login']"));
		login.click();
		Thread.sleep(2000);
		WebElement userMenu = helper.getDriver().findElement(By.xpath("//div[@id='userNavButton']"));
		userMenu.click();
		WebElement clickLogout = helper.getDriver().findElement(By.xpath("//a[@title='Logout']"));
		clickLogout.click();
		if(helper.getcellUser().equals(ExpectedUName)) {
			System.out.println("Test case passed as user name matches.");
		}		
	}
	
	public void forgotPassword() throws Exception {
		
		/**********theres no login error message to validate***********/
		
		UserDataExcel excel = new UserDataExcel();
		Login_helper helper = new Login_helper();
		helper.launchApplication(getcelllaunch(), getcelllogin());
		helper.login(getcellUser(), password, userxpath, passxpath);
		WebElement forgotPasswordclick = helper.getDriver().findElement(By.id("forgot_password_link"));
		
		forgotPasswordclick.click();
		Thread.sleep(2000);
		WebElement userNameAgain = helper.getDriver().findElement(By.xpath("//input[@id='un']"));
		userNameAgain.sendKeys(helper.getcellUser());
		WebElement continuefld = helper.getDriver().findElement(By.xpath("//input[@id='continue']"));
		continuefld.click();			
	}
	
	public void validateForgotPassword() throws Exception {
		String exerrorMessage = "Please check your username and password."
								+ " If you still can't log in, contact your Salesforce administrator.";
		UserDataExcel excel = new UserDataExcel();
		Login_helper helper = new Login_helper();
		helper.launchApplication(getcelllaunch(), getcelllogin());
		Thread.sleep(3000);
		WebElement wrongUser = helper.getDriver().findElement(By.xpath(userxpath));		
		wrongUser.sendKeys("123");
		WebElement wrongPass = helper.getDriver().findElement(By.xpath(passxpath));		
		wrongPass.sendKeys("22131");
		WebElement login = helper.getDriver().findElement(By.xpath("//input[@id='Login']"));
		login.click();
		WebElement errorMessage = helper.getDriver().findElement(By.xpath("//div[@id='error']"));
		String actualerrorMessage =errorMessage.getText();
		if(actualerrorMessage.equals(exerrorMessage)) {
			System.out.println("Test case is passed.");
		}
		//System.out.println(errorMessage.getText());
	}
}
