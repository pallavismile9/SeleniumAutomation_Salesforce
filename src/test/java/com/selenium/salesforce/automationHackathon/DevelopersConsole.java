package com.selenium.salesforce.automationHackathon;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class DevelopersConsole extends BrowserUtilitySalesforce {

	public static void main(String[] args) throws Exception {
		BrowserUtilitySalesforce.launchBrowser("ch");
		BrowserUtilitySalesforce.loginToBrowser();
		
		WebElement usermenu = driver.findElement(By.xpath("//span[@id='userNavLabel']"));
		webElementToBeVisibile(usermenu);
		usermenu.click();
		
		WebElement developerconsole = driver.findElement(By.xpath("//a[contains(@class,'debugLogLink menuButtonMenuLink')]"));
		webElementToBeVisibile(developerconsole);
		developerconsole.click();
		
		Thread.sleep(5000);
		
		//Use getWindowHandles : to handle the open window 
		ArrayList<String> openwindow=new ArrayList<String>(driver.getWindowHandles());
		openwindow.size();
		System.out.println(openwindow.size());
		driver.switchTo().window(openwindow.get(1));
		Thread.sleep(2000);
		driver.close();
		driver.switchTo().window(openwindow.get(0));
	quitBrowser();
	
		
		
	}

}
