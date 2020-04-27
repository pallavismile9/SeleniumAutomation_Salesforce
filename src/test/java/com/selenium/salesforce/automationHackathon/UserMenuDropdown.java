package com.selenium.salesforce.automationHackathon;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class UserMenuDropdown extends BrowserUtilitySalesforce{

	public static void main(String[] args) throws Exception {
		BrowserUtilitySalesforce.launchBrowser("ch");
		BrowserUtilitySalesforce.loginToBrowser();
		
		WebElement usermenu = driver.findElement(By.xpath("//span[@id='userNavLabel']"));
		Thread.sleep(2000);
		webElementToBeVisibile(usermenu);
		usermenu.click();
		
		//To get all the values of the usermenu dropdown--xpath is imp here--take a note
		List<WebElement> list = driver.findElements(By.xpath("//div[@id='userNav-menuItems']//a"));
		for(WebElement ele:list)
		{
			System.out.println(ele.getAttribute("title"));
		}
		//div[@id='userNav-menuItems']//a
		
		quitBrowser();
		
		

	}

}
