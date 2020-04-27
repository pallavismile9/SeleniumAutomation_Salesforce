package com.selenium.salesforce.automationHackathon;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class ErrorContact extends BrowserUtilitySalesforce  {

	public static void main(String[] args) throws Exception {
		BrowserUtilitySalesforce.launchBrowser("ch");
		BrowserUtilitySalesforce.loginToBrowser();
		Thread.sleep(5000);
		List<WebElement> li=driver.findElements(By.xpath("//ul[@id='tabBar']//li"));
		System.out.println(li.size());
		for(WebElement ele: li) {
			System.out.println(ele.getText());
			if(ele.getText().contains("Contacts")) {
				ele.click();
				break;
			}
		}
		Thread.sleep(5000);
		//create new view link
		JavascriptExecutor js=(JavascriptExecutor)driver;
		WebElement newviewlink= driver.findElement(By.xpath("//a[contains(text(),'Create New View')]"));
		webElementToBeClickable(newviewlink);
		js.executeScript("arguments[0].click()", newviewlink);
		
		//view unique name
		WebElement uniquename=driver.findElement(By.xpath("//input[@id='devname']"));
		webElementToBeVisibile(uniquename);
		uniquename.clear();
		uniquename.sendKeys("Automation");
		
		//save button
		WebElement save=driver.findElement(By.xpath("//div[@class='pbHeader']//input[@name='save']"));
		webElementToBeClickable(save);
		js.executeScript("arguments[0].click()", save);
		
		WebElement error = driver.findElement(By.xpath("//div[contains(text(),'You must enter a value')]"));
		webElementToBeVisibile(error);
		System.out.println("Actual Error:" +error.getText());
	}

}
