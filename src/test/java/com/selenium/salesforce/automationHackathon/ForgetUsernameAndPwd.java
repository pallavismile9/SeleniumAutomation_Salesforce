package com.selenium.salesforce.automationHackathon;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ForgetUsernameAndPwd extends BrowserUtilitySalesforce {

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
	
		//Input wrong userid : get from properties file
		WebElement username = driver.findElement(By.xpath("//input[@id='username']"));
		webElementToBeVisibile(username);
		username.sendKeys(System.getProperty("testUid"));
		
		//Input wrong pwd:get from properties file
		WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
		webElementToBeVisibile(password);
		password.sendKeys(System.getProperty("testPwd"));
		
		//Click Login button
		WebElement login = driver.findElement(By.xpath("//input[@id='Login']"));
		webElementToBeVisibile(login);
		login.click();
		
		//Actual error message displayed
		WebElement error = driver.findElement(By.xpath("//div[@id='error']"));
		webElementToBeVisibile(error);
		System.out.println(error.getText());

	}

}
