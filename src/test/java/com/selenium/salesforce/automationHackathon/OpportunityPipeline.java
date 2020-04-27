package com.selenium.salesforce.automationHackathon;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class OpportunityPipeline extends BrowserUtilitySalesforce  {

	public static void main(String[] args) throws Exception {
		BrowserUtilitySalesforce.launchBrowser("ch");
		BrowserUtilitySalesforce.loginToBrowser();
		
		Thread.sleep(5000);
		List<WebElement> li=driver.findElements(By.xpath("//ul[@id='tabBar']//li"));
		System.out.println(li.size());
		for(WebElement ele: li) {
			System.out.println(ele.getText());
			if(ele.getText().contains("Opportunities")) {
				ele.click();
				break;
			}
		}
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement opptypipeline=driver.findElement(By.xpath("//a[contains(text(),'Opportunity Pipeline')]"));
		webElementToBeClickable(opptypipeline);
		js.executeScript("arguments[0].click()", opptypipeline);
		System.out.println("success1");
		//a[contains(text(),'Opportunity Pipeline')]

	}

}
