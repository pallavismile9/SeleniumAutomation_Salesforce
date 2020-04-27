package com.selenium.salesforce.automationHackathon;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class RecentContacts extends BrowserUtilitySalesforce {

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
		
		WebElement recentcreated=driver.findElement(By.xpath("//select[@id='hotlist_mode']"));
		Select dropdown=new Select(recentcreated);
		dropdown.selectByVisibleText("Recently Created");
		
		WebElement recent = driver.findElement(By.xpath("//h3[contains(text(),'Recent Contacts')]"));
		webElementToBeVisibile(recent);
		System.out.println(recent.getText());
	}

}
