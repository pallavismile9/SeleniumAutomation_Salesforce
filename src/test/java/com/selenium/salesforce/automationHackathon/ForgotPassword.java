package com.selenium.salesforce.automationHackathon;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ForgotPassword extends BrowserUtilitySalesforce{

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
	
		WebElement username = driver.findElement(By.xpath("//input[@id='username']"));
		webElementToBeVisibile(username);
		username.sendKeys(System.getProperty("username"));
		
		WebElement forgotpwd=driver.findElement(By.xpath("//a[@id='forgot_password_link']"));
		webElementToBeVisibile(forgotpwd);
		forgotpwd.click();
		
		WebElement uid = driver.findElement(By.xpath("//input[@id='un']"));
		webElementToBeVisibile(uid);
		uid.sendKeys(System.getProperty("username"));
		
		//System.out.println(driver.findElement(By.xpath("//a[@class='primary button wide mb16']")).getText());
		//input[@id='continue']
		
		WebElement continuebtn = driver.findElement(By.xpath("//input[@id='continue']"));
		webElementToBeVisibile(continuebtn);
		continuebtn.click();
		
		System.out.println(driver.findElement(By.xpath("//a[@class='primary button wide mb16']")).getText());
	}

}
