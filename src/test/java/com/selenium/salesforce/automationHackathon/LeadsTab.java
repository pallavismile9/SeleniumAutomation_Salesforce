package com.selenium.salesforce.automationHackathon;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class LeadsTab extends BrowserUtilitySalesforce {

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
		List<WebElement> li1=drpdwn1.getOptions();
		for(WebElement ele:li1) {
		System.out.println(ele.getText());}
		
		
		

	}

}
