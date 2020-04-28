package com.practicefunctions;

import org.openqa.selenium.WebElement;
import com.maven.UserDefinedMethods.ReusableMethods;

public class Switch_to_Alerts {
	
	public static void main(String[]args) throws Exception {
		
		/** 
		 *	Setup the Chrome driver
		 *	Launch the website
		 *	Login as a valid user
		 *	Access "Alerts" menu item from "Switch To" menu\
		 *	
		 *	setupChrome() ;
		 *	launchWeb(url)
		 *	loginUser(username, password)
		 *	accessMenu()
		 * 
		 **/
		ReusableMethods re = new ReusableMethods();
		String url = "https://qa-tekarch.firebaseapp.com";
		String username = "admin123@gmail.com" ;
		String password = "admin123" ;
		String switchToXPath = "//button[contains(text(), 'Switch')]" ;
		String alertXPath = "//a[contains(text(), 'Alert')]" ;
		String windowXPath = "//div[contains(@class, 'login')]//button[@class='bootbutton'][contains(text(), 'Window Alert')]" ;

		re.launchWeb(url);
		re.loginUser(username, password);
		//re.launchBrowser(url);
		Thread.sleep(3000);

		WebElement switchTo = re.findElementByXpathAndHover(switchToXPath) ;
		switchTo.click(); 
		
		re.findElementByXpathAndClick(alertXPath);
		Thread.sleep(2000);
		
		re.findElementByXpathAndClick(windowXPath);
		Thread.sleep(2000);
		re.acceptAlert();
		
		
		 
	}

}