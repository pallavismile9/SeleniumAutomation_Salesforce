package com.selenium.salesforce.automationHackathon;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class HomeTab extends BrowserUtilitySalesforce {

	public static void main(String[] args) throws Exception {
		BrowserUtilitySalesforce.launchBrowser("ch");
		BrowserUtilitySalesforce.loginToBrowser();
		Thread.sleep(5000);
		List<WebElement> li=driver.findElements(By.xpath("//ul[@id='tabBar']//li"));
		System.out.println(li.size());
		for(WebElement ele: li) {
			System.out.println(ele.getText());
			if(ele.getText().contains("Home")) {
				ele.click();
				break;
			}
		}
		
		Thread.sleep(5000);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		WebElement firstlastname = driver.findElement(By.xpath("//h1[@class='currentStatusUserName']//a[contains(text(),'Pallavi TekArch')]"));
		webElementToBeVisibile(firstlastname);
		System.out.println("Actual User name: " + firstlastname.getText());
		webElementToBeClickable(firstlastname);
		js.executeScript("arguments[0].click()", firstlastname);
		
		WebElement display=driver.findElement(By.xpath("//span[@id='tailBreadcrumbNode']"));
		webElementToBeVisibile(display);
		System.out.println("Actual User name after clicking: " + display.getText());
		
		WebElement edit = driver.findElement(By.xpath("//a[@class='contactInfoLaunch editLink']//img"));
		webElementToBeClickable(edit);
		js.executeScript("arguments[0].click()", edit);
		
		
		
		Thread.sleep(5000);
		//Switch to frame
		driver.switchTo().frame(driver.findElement(By.id("contactInfoContentId")));
		
		Thread.sleep(4000);
		//focus on email
		WebElement ele11=driver.switchTo().activeElement();
		System.out.println("success");
		System.out.println(ele11.getAttribute("value"));
		
		//about tab
		WebElement abouttab = driver.findElement(By.xpath("//a[contains(text(),'About')]"));
		webElementToBeClickable(abouttab);
		js.executeScript("arguments[0].click()", abouttab);
		
		Thread.sleep(2000);
		//WebElement firstname = driver.findElement(By.xpath("//input[@id='firstName']"));
		WebElement ele=driver.switchTo().activeElement();
		
		//System.out.println("firstname:" + firstname.getText());
		
		System.out.println("ele:" + ele.getText());
		
		WebElement lastname = driver.findElement(By.xpath("//input[@id='lastName']"));
		webElementToBeVisibile(lastname);
		lastname.clear();
		lastname.sendKeys("ABCD");
		
		//save All btn
		
		WebElement saveall=driver.findElement(By.xpath("//input[@class='zen-btn zen-primaryBtn zen-pas']"));
		webElementToBeClickable(saveall);
		js.executeScript("arguments[0].click()", saveall);
		
		//default content
		driver.switchTo().defaultContent();
		
		quitBrowser();

	}

}
