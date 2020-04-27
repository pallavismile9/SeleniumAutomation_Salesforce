package com.selenium.salesforce.automationHackathon;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class LeadNewButton extends BrowserUtilitySalesforce {

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
		
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement newbtn=driver.findElement(By.xpath("//input[@name='new']"));
		webElementToBeClickable(newbtn);
		js.executeScript("arguments[0].click()", newbtn);
		System.out.println("success");
		
		Thread.sleep(5000);
		
		WebElement lastname = driver.findElement(By.xpath("//input[@id='name_lastlea2']"));
		webElementToBeVisibile(lastname);
		lastname.clear();
		lastname.sendKeys("Modi");
		
		WebElement company = driver.findElement(By.xpath("//input[@id='lea3']"));
		webElementToBeVisibile(company);
		company.clear();
		company.sendKeys("Healthcare");
		//input[@id='lea3']
		
		WebElement leadstatus= driver.findElement(By.xpath("//select[@id='lea13']"));
		Select drpdwn1=new Select(leadstatus);
		drpdwn1.selectByValue("Working - Contacted");
		
		Thread.sleep(2000);
		//JavascriptExecutor js=(JavascriptExecutor)driver;
		WebElement save=driver.findElement(By.xpath("//div[contains(@class,'pbBottomButtons')]//input[1]"));
		webElementToBeClickable(save);
		js.executeScript("arguments[0].click()", save);
		System.out.println("success1");
		//div[contains(@class,'pbBottomButtons')]//input[1]
	}

}
