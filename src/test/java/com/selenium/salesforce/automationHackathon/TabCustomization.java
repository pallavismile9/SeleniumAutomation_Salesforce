package com.selenium.salesforce.automationHackathon;

import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class TabCustomization extends BrowserUtilitySalesforce {

	public static void main(String[] args) throws Exception {
		BrowserUtilitySalesforce.launchBrowser("ch");
		BrowserUtilitySalesforce.loginToBrowser();
		Thread.sleep(5000);
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		WebElement alltab = driver.findElement(By.xpath("//li[@id='AllTab_Tab']//a"));
		webElementToBeClickable(alltab);
		js.executeScript("arguments[0].click()", alltab);
		
		Thread.sleep(2000);
		WebElement addtab = driver.findElement(By.xpath("//a[contains(text(),'add a tab')]"));
		webElementToBeClickable(addtab);
		js.executeScript("arguments[0].click()", addtab);
		
		WebElement removelist = driver.findElement(By.xpath("//select[@id='duel_select_1']"));
		webElementToBeVisibile(removelist);
		Select dropdown=new Select(removelist);
		dropdown.selectByValue("Workspace");
		
		WebElement removebtn=driver.findElement(By.xpath("//a[@id='duel_select_0_left']"));
		webElementToBeClickable(removebtn);
		js.executeScript("arguments[0].click()", removebtn);
		
		WebElement save= driver.findElement(By.xpath("//td[@id='bottomButtonRow']//input[contains(@name,'save')]"));
		webElementToBeClickable(save);
		js.executeScript("arguments[0].click()", save);
		
		Thread.sleep(2000);
		//click on usermenu
		WebElement usermenu = driver.findElement(By.xpath("//span[@id='userNavLabel']"));
		webElementToBeVisibile(usermenu);
		usermenu.click();
		
		//logout
		WebElement logout = driver.findElement(By.xpath("//a[contains(text(),'Logout')]"));
		webElementToBeVisibile(logout);
		logout.click();
				
		Thread.sleep(2000);	
		String sPath=System.getProperty("user.dir")+ "\\Browserdata.properties";
		Properties prop=new Properties();
		FileInputStream fi = new FileInputStream(sPath);
		prop.load(fi);
		System.getProperties().putAll(prop);
		System.getProperty("username");
		System.getProperty("password");
		
		
		 
		WebElement username = driver.findElement(By.xpath("//input[@id='username']"));
		webElementToBeVisibile(username);
		username.sendKeys(System.getProperty("username"));
		
		WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
		webElementToBeVisibile(password);
		password.sendKeys(System.getProperty("password"));
	
		WebElement login = driver.findElement(By.xpath("//input[@id='Login']"));
		webElementToBeVisibile(login);
		login.click();
		
		quitBrowser();
	
	
	}

}
