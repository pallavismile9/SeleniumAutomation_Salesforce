package com.selenium.salesforce.automationHackathon;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class QuarterlySummaryOpportunity extends BrowserUtilitySalesforce {

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
		
		Thread.sleep(5000);
		WebElement interval=driver.findElement(By.xpath("//select[@id='quarter_q']"));
		Select drpdwn=new Select(interval);
		drpdwn.selectByValue("curnext1");
		
		WebElement include=driver.findElement(By.xpath("//select[@id='open']"));
		Select drpdwn1=new Select(include);
		drpdwn1.selectByValue("open");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement report=driver.findElement(By.xpath("//table[@class='opportunitySummary']//input[@name='go']"));
		webElementToBeClickable(report);
		js.executeScript("arguments[0].click()", report);
		System.out.println("success1");
		

	}

}
