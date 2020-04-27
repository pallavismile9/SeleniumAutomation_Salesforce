package com.selenium.salesforce.automationHackathon;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RememberMeAndLogout extends BrowserUtilitySalesforce {

	public static void main(String[] args) throws Exception {
		BrowserUtilitySalesforce.launchBrowser("ch");
		WebElement loginScreen = driver.findElement(By.xpath("//a[contains(text(),'Login')]"));
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(loginScreen));
		loginScreen.click();
		
		String sPath=System.getProperty("user.dir")+ "\\Browserdata.properties";
		Properties prop=new Properties();
		FileInputStream fi = new FileInputStream(sPath);
		prop.load(fi);
		System.getProperties().putAll(prop);
		//System.getProperty("username");
		WebElement username = driver.findElement(By.xpath("//input[@id='username']"));
		webElementToBeVisibile(username);
		username.sendKeys(System.getProperty("username"));
		
		
		
		WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
		webElementToBeVisibile(password);
		password.sendKeys(System.getProperty("password"));
		
		Thread.sleep(5000);
		WebElement remembercheckbox = driver.findElement(By.xpath("//input[@id='rememberUn']"));
		if(!remembercheckbox.isSelected()) {
			remembercheckbox.click();
		}
		
		WebElement login = driver.findElement(By.xpath("//input[@id='Login']"));
		webElementToBeVisibile(login);
		login.click();
		
		WebElement usermenu = driver.findElement(By.xpath("//span[@id='userNavLabel']"));
		webElementToBeVisibile(usermenu);
		usermenu.click();
		
		WebElement logout= driver.findElement(By.xpath("//a[contains(text(),'Logout')]"));
		webElementToBeVisibile(logout);
		logout.click();
		
		
		//Use getAttribute("value") to get the value of the username field.
		
		Thread.sleep(2000);
		WebElement actual_username1= driver.findElement(By.xpath("//input[@id='username']"));
		System.out.println(actual_username1.getAttribute("value"));
		
		
		
		
	}

}
