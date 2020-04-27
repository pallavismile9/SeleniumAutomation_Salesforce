package com.selenium.salesforce.automationHackathon;

public class LaunchApp extends BrowserUtilitySalesforce{

	public static void main(String[] args) throws Exception {
		BrowserUtilitySalesforce.launchBrowser("ch");
		Thread.sleep(5000);
		System.getProperty("username");
		System.getProperty("password");
		BrowserUtilitySalesforce.loginToBrowser();
		

	}
	

}
