package salesforce_test;

public class SalesforceTestRunner{

	public static void main(String[] args) throws Exception {
		
		login_test test1 = new login_test();
		UserMenuDropDownTest test2 = new UserMenuDropDownTest();
		AccountsTabTest test3 = new AccountsTabTest();
		opportunityTabTest test4 = new opportunityTabTest();
		LeadsTabTest test5 = new LeadsTabTest();
		ContactsTabTest test6 = new ContactsTabTest();
		RandonScenariosTest test7 = new RandonScenariosTest();
	
		//test1.errorMessageTest();
		//test1.errorMessageTest();
		//test1.LoginToSalesforce();
		//test1.CheckRememberMe();
		//test1.forgotPassword();
		//test1.validateForgotPassword();
		//test2.TC05UserMenu();
		test2.TC06MyProfile();
		//test2.TC07mySettingsPersonalLink();
		//test2.TC08DeveloperConsole();
		//test2.TC09LogOutFromUserMenu();
		//test3.TC10CreateAcc();
		//test3.TC11createNewView();
		//test3.TC12editView();
		//?source=lex
		//test3.TC13mergeAccounts();
		//test4.TC15opportunityDropDown();
		//test4.TC16createNewOpp();
		//test4.TC17oppPipelineReport();
		//test4.TC18stuckOppReport();
		//test4.TC19quarterlySummary();
		//test5.TC20leadsTab();
		////test5.TC21leadsDropDown();
		//test5.TC22defaultView();
		//test5.TC23todaysLeads();
		//test5.TC24createNewLeads();
		//test6.TC25createNewContact();
		//test6.TC26createNewView();
		//test6.TC27recentContact();
		//test6.TC28MyContactsView();
		//test6.TC29viewContactName();
		//test6.TC30newViewErrorMessage();
		//test6.TC31checkCancelInNewView();
		//test6.TC32checkSaveAndNew();
		//test7.TC33verifyFirstLastName();
		//test7.TC34verifyLastNameUpdatedEverywhere();
		//test7.TC35tabCustomisation();
		//test7.TC36blockingEventCalendar();
		
	}
	
	
	
	
	
	
}
