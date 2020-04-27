package com.selenium.salesforce.automationHackathon;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class AccountView extends BrowserUtilitySalesforce {

	public static void main(String[] args) throws Exception {
		 BrowserUtilitySalesforce.launchBrowser("ch");
		 BrowserUtilitySalesforce.loginToBrowser();
			
			Thread.sleep(5000);
			List<WebElement> li=driver.findElements(By.xpath("//ul[@id='tabBar']//li"));
			System.out.println(li.size());
			for(WebElement ele: li) {
				System.out.println(ele.getText());
				if(ele.getText().contains("Accounts")) {
					ele.click();
					break;
				}
			}
			
			//create new view
			Thread.sleep(5000);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			WebElement newview = driver.findElement(By.xpath("//a[contains(text(),'Create New View')]"));
			webElementToBeClickable(newview);
			js.executeScript("arguments[0].click()", newview);
			
			//test account view name
			Thread.sleep(2000);
			WebElement viewname = driver.findElement(By.xpath("//input[@id='fname']"));
			webElementToBeVisibile(viewname);
			viewname.clear();
			viewname.sendKeys("TestAccount");
			
			//uniquename
			WebElement uniquename = driver.findElement(By.xpath("//input[@id='devname']"));
			webElementToBeVisibile(uniquename);
			uniquename.clear();
			uniquename.sendKeys("TestAccount");
			
			//save btn
			WebElement save =driver.findElement(By.xpath("//div[@class='pbBottomButtons']//input[@name='save']"));
			webElementToBeClickable(save);
			js.executeScript("arguments[0].click()", save);
			
			quitBrowser();
	}

}
