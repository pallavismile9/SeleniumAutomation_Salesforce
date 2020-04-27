package com.selenium.salesforce.automationHackathon;

import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class LeadsGoButton extends BrowserUtilitySalesforce {

	public static void main(String[] args) throws Exception {
		BrowserUtilitySalesforce.launchBrowser("ch");
		BrowserUtilitySalesforce.loginToBrowser();
		
		Thread.sleep(5000);
		List<WebElement> li=driver.findElements(By.xpath("//ul[@id='tabBar']//li"));
		System.out.println(li.size());
		for(WebElement ele: li) {
			System.out.println(ele.getText());
			if(ele.getText().contains("Leads")) {
				ele.click();
				break;
			}
		}
		
		Thread.sleep(2000);
		WebElement viewleads=driver.findElement(By.xpath("//select[@id='fcf']"));
		Select drpdwn1=new Select(viewleads);
		drpdwn1.selectByVisibleText("My Unread Leads");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement gobtn=driver.findElement(By.xpath("//span[contains(@class,'fBody')]//input[contains(@name,'go')]"));
		webElementToBeClickable(gobtn);
		js.executeScript("arguments[0].click()", gobtn);
		System.out.println("success1");
		
		Thread.sleep(5000);
		WebElement usermenu = driver.findElement(By.xpath("//span[@id='userNavLabel']"));
		webElementToBeVisibile(usermenu);
		usermenu.click();
		
		WebElement logout = driver.findElement(By.xpath("//a[contains(text(),'Logout')]"));
		webElementToBeVisibile(logout);
		logout.click();
		Thread.sleep(5000);
		
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
		
		
		
		Thread.sleep(5000);
		List<WebElement> li1=driver.findElements(By.xpath("//ul[@id='tabBar']//li"));
		System.out.println(li1.size());
		for(WebElement ele: li1) {
			System.out.println(ele.getText());
			if(ele.getText().contains("Leads")) {
				ele.click();
				break;
			}
		}
		
		Thread.sleep(2000);
		WebElement viewleads1=driver.findElement(By.xpath("//select[@id='fcf']"));
		Select drpdwn2=new Select(viewleads1);
		List<WebElement> li2=drpdwn2.getOptions();
		for(WebElement ele:li2) {
			
			if(ele.getText().equals("My Unread Leads")){
			System.out.println(ele.getText());
			System.out.println("TestCase Passed");
			}
			
		}
		
		
	}

}
