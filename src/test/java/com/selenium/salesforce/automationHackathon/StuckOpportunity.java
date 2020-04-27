package com.selenium.salesforce.automationHackathon;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class StuckOpportunity extends BrowserUtilitySalesforce {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
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
		WebElement stuckopptypipeline=driver.findElement(By.xpath("//a[contains(text(),'Stuck Opportunities')]"));
		webElementToBeClickable(stuckopptypipeline);
		js.executeScript("arguments[0].click()", stuckopptypipeline);
		System.out.println("success1");
		//a[contains(text(),'Opportunity Pipeline')]



	}

}
