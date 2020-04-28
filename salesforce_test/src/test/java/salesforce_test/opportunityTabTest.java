package salesforce_test;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import salesforce_utility.Login_helper;
import salesforce_utility.UserDataExcel;

public class opportunityTabTest extends UserDataExcel {
	String userxpath = "//input[@id='username']";
	String passxpath = "//input[@id='password']";

	public opportunityTabTest() throws Exception {
		super();
		}
	
	public void TC15opportunityDropDown() throws Exception {
		
		Login_helper helper = new Login_helper();
		UserDataExcel excel = new UserDataExcel();
		helper.launchApplication(getcelllaunch(), getcelllogin());
		helper.login(getcellUser(), getcellPassword(), userxpath, passxpath);
		WebElement login = helper.getDriver().findElement(By.xpath("//input[@id='Login']"));
		login.click();
		Thread.sleep(3000);
		WebElement oppTab = helper.getDriver().findElement(By.xpath("//li[@id='Opportunity_Tab']"));
		oppTab.click();
		Thread.sleep(2000);
		List<WebElement> oppDropDown = helper.getDriver().findElements(By.xpath("//select[@title='View:']"));
		//((WebElement) oppDropDown).click();
		for(int i=0; i<oppDropDown.size(); i++) {
			System.out.println(oppDropDown.get(i).getText());
		}
		/***********not clicking on oppdropdown**********/
	}
	
	public void TC16createNewOpp() throws Exception {
		Login_helper helper = new Login_helper();
		UserDataExcel excel = new UserDataExcel();
		helper.launchApplication(getcelllaunch(), getcelllogin());
		helper.login(getcellUser(), getcellPassword(), userxpath, passxpath);
		WebElement login = helper.getDriver().findElement(By.xpath("//input[@id='Login']"));
		login.click();
		Thread.sleep(3000);
		WebElement oppTab = helper.getDriver().findElement(By.xpath("//li[@id='Opportunity_Tab']"));
		oppTab.click();
		Thread.sleep(2000);
		WebElement newOpp = helper.getDriver().findElement(By.xpath("//input[@value=' New ']"));
		newOpp.click();
		Thread.sleep(2000);
		WebElement oppNameFld = helper.getDriver().findElement(By.xpath("//input[@id='opp3']"));
		oppNameFld.click();
		oppNameFld.sendKeys("TravelWorld travels");
		WebElement accNameFld = helper.getDriver().findElement(By.xpath("//input[@id='opp4']"));
		accNameFld.click();
		accNameFld.sendKeys("Clear Optics Pvt");
		WebElement leadSource = helper.getDriver().findElement(By.xpath("//select[@id='opp6']"));
		leadSource.click();
		Select type7 = new Select(leadSource);
		type7.selectByValue("Phone Inquiry");
		WebElement closeDate = helper.getDriver().findElement(By.xpath("//input[@id='opp9']"));
		closeDate.click();
		Thread.sleep(2000);
		WebElement pickCalendarDate = helper.getDriver().findElement(By.xpath("//td[contains(@class,'weekday')][contains(text(),'29')]"));
		Actions act = new Actions(helper.getDriver());
		act.moveToElement(pickCalendarDate).build().perform();
		pickCalendarDate.click();
		WebElement stageFld = helper.getDriver().findElement(By.xpath("//select[@id='opp11']"));
		stageFld.click();
		Select type8 = new Select(stageFld);
		type8.selectByValue("Perception Analysis");
		WebElement probabilityFld= helper.getDriver().findElement(By.xpath("//input[@id='opp12']"));
		probabilityFld.click();
		probabilityFld.sendKeys("");
		WebElement campaignSource = helper.getDriver().findElement(By.xpath("//input[@id='opp17']"));
		campaignSource.click();
		campaignSource.sendKeys("International Electrical Engineers Association Trade Show - Mar 4-5, 2002");
		WebElement saveButton = helper.getDriver().findElement(By.xpath("//td[@id='topButtonRow']//input[@value=' Save ']"));
		saveButton.click();		
	}
	
	public void TC17oppPipelineReport() throws Exception {
		Login_helper helper = new Login_helper();
		UserDataExcel excel = new UserDataExcel();
		helper.launchApplication(getcelllaunch(), getcelllogin());
		helper.login(getcellUser(), getcellPassword(), userxpath, passxpath);
		WebElement login = helper.getDriver().findElement(By.xpath("//input[@id='Login']"));
		login.click();
		Thread.sleep(3000);
		WebElement oppTab = helper.getDriver().findElement(By.xpath("//li[@id='Opportunity_Tab']"));
		oppTab.click();
		Thread.sleep(2000);
		WebElement oppPipelineLink = helper.getDriver().findElement(By.xpath("//li[@class='hover']//a[contains(text(), 'Opportunity')]"));
		oppPipelineLink.click();		
	}
	
	public void TC18stuckOppReport () throws Exception {
		Login_helper helper = new Login_helper();
		UserDataExcel excel = new UserDataExcel();
		helper.launchApplication(getcelllaunch(), getcelllogin());
		helper.login(getcellUser(), getcellPassword(), userxpath, passxpath);
		WebElement login = helper.getDriver().findElement(By.xpath("//input[@id='Login']"));
		login.click();
		Thread.sleep(3000);
		WebElement oppTab = helper.getDriver().findElement(By.xpath("//li[@id='Opportunity_Tab']"));
		oppTab.click();
		Thread.sleep(2000);
		WebElement stuckOpplink = helper.getDriver().findElement(By.xpath("//a[contains(text(), 'Stuck')]"));
		stuckOpplink.click();		
	}
	
	public void TC19quarterlySummary() throws Exception {
		Login_helper helper = new Login_helper();
		UserDataExcel excel = new UserDataExcel();
		helper.launchApplication(getcelllaunch(), getcelllogin());
		helper.login(getcellUser(), getcellPassword(), userxpath, passxpath);
		WebElement login = helper.getDriver().findElement(By.xpath("//input[@id='Login']"));
		login.click();
		Thread.sleep(3000);
		WebElement oppTab = helper.getDriver().findElement(By.xpath("//li[@id='Opportunity_Tab']"));
		oppTab.click();
		
		/******************there is no link for "quarterly summary"************/
		Thread.sleep(2000);
		WebElement intervalDropDown = helper.getDriver().findElement(By.xpath("//select[@id='quarter_q']"));
		intervalDropDown.click();
		Select type9 = new Select(intervalDropDown);
		type9.selectByValue("current");
		WebElement includeDropDown = helper.getDriver().findElement(By.xpath("//select[@id='open']"));
		includeDropDown.click();
		Select type10 = new Select(includeDropDown);
		type10.selectByValue("all");
		WebElement runReport = helper.getDriver().findElement(By.xpath("//input[@value='Run Report']"));
		runReport.click();
		Thread.sleep(2000);
		
		WebElement oppTabToContinue1 = helper.getDriver().findElement(By.xpath("//a[@title='Opportunities Tab']"));
		oppTabToContinue1.click();
		WebElement intervalDropDown1 = helper.getDriver().findElement(By.xpath("//select[@id='quarter_q']"));
		intervalDropDown1.click();
		Select type11 = new Select(intervalDropDown1);
		type11.selectByValue("current");
		WebElement includeDropDown1 = helper.getDriver().findElement(By.xpath("//select[@id='open']"));
		includeDropDown1.click();
		Select type12 = new Select(includeDropDown1);
		type12.selectByValue("open");
		WebElement runReport1 = helper.getDriver().findElement(By.xpath("//input[@value='Run Report']"));
		runReport1.click();
		Thread.sleep(2000);
		
		
		WebElement oppTabToContinue2 = helper.getDriver().findElement(By.xpath("//a[@title='Opportunities Tab']"));
		oppTabToContinue2.click();
		WebElement intervalDropDown2 = helper.getDriver().findElement(By.xpath("//select[@id='quarter_q']"));
		intervalDropDown2.click();
		Select type13 = new Select(intervalDropDown2);
		type13.selectByValue("next1");
		WebElement includeDropDown2 = helper.getDriver().findElement(By.xpath("//select[@id='open']"));
		includeDropDown2.click();
		Select type14 = new Select(includeDropDown2);
		type14.selectByValue("closed");
		WebElement runReport2 = helper.getDriver().findElement(By.xpath("//input[@value='Run Report']"));
		runReport2.click();		
	}

}
