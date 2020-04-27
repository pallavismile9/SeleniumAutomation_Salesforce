package com.selenium.salesforce.automationHackathon;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ContactEdit extends BrowserUtilitySalesforce {

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
		JavascriptExecutor js=(JavascriptExecutor)driver;
		WebElement editlink = driver.findElement(By.xpath("//span[contains(@class,'fFooter')]//a[contains(text(),'Edit')]"));
		webElementToBeClickable(editlink);
		js.executeScript("arguments[0].click()", editlink);
		
		WebElement availablefields = driver.findElement(By.xpath("//select[@id='colselector_select_0']"));
		webElementToBeVisibile(availablefields);
		Select dropdown = new Select(availablefields);
		dropdown.selectByValue("CONTACT.LAST_NAME");
		dropdown.selectByValue("ACCOUNT.ACCOUNT_ID");
		
		WebElement addbtn=driver.findElement(By.xpath("//a[@id='colselector_select_0_right']"));
		webElementToBeVisibile(addbtn);
		js.executeScript("arguments[0].click()", addbtn);
		
		WebElement save = driver.findElement(By.xpath("//div[3]//table[1]//tbody[1]//tr[1]//td[2]//input[1]"));
		webElementToBeVisibile(save);
		js.executeScript("arguments[0].click()", save);
		
		quitBrowser();
	}

}
