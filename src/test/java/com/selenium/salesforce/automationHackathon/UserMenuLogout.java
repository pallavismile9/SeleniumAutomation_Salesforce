package com.selenium.salesforce.automationHackathon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class UserMenuLogout extends BrowserUtilitySalesforce {

	public static void main(String[] args) throws Exception {
		BrowserUtilitySalesforce.launchBrowser("ch");
		BrowserUtilitySalesforce.loginToBrowser();
		
		WebElement usermenu = driver.findElement(By.xpath("//span[@id='userNavLabel']"));
		webElementToBeVisibile(usermenu);
		usermenu.click();
		
		WebElement logout = driver.findElement(By.xpath("//a[contains(text(),'Logout')]"));
		webElementToBeVisibile(logout);
		logout.click();

	}

}
