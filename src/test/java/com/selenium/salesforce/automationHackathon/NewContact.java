package com.selenium.salesforce.automationHackathon;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class NewContact extends BrowserUtilitySalesforce{

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
		//New button
		Thread.sleep(5000);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		WebElement newcontact = driver.findElement(By.xpath("//input[@name='new']"));
		webElementToBeClickable(newcontact);
		js.executeScript("arguments[0].click()", newcontact);
		
		Thread.sleep(5000);
		
		//firstname textbox
		WebElement firstname=driver.findElement(By.xpath("//input[@id='name_firstcon2']"));
		webElementToBeVisibile(firstname);
		firstname.clear();
		firstname.sendKeys("Pallavi");
		
		//lastname
		WebElement lastname=driver.findElement(By.xpath("//input[@id='name_lastcon2']"));
		webElementToBeVisibile(lastname);
		lastname.clear();
		lastname.sendKeys("PM");
		
		//save button
		WebElement save=driver.findElement(By.xpath("//div[contains(@class,'pbBottomButtons')]//input[1]"));
		webElementToBeClickable(save);
		js.executeScript("arguments[0].click()", save);
		

	}

}
