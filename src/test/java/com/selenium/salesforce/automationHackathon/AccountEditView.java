package com.selenium.salesforce.automationHackathon;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class AccountEditView extends BrowserUtilitySalesforce {

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
			WebElement editview = driver.findElement(By.xpath("//span[contains(@class,'fFooter')]//a[contains(text(),'Edit')]"));
			webElementToBeClickable(editview);
			js.executeScript("arguments[0].click()", editview);
			
			//test account view name
			Thread.sleep(2000);
			WebElement viewname = driver.findElement(By.xpath("//input[@id='fname']"));
			webElementToBeVisibile(viewname);
			viewname.clear();
			viewname.sendKeys("TestAccount123");
			
			//uniquename
			WebElement uniquename = driver.findElement(By.xpath("//input[@id='devname']"));
			webElementToBeVisibile(uniquename);
			uniquename.clear();
			uniquename.sendKeys("TestAccount123");
			
			//
			WebElement filterfield = driver.findElement(By.xpath("//select[@id='fcol2']"));
			webElementToBeVisibile(filterfield);
			Select dropdown=new Select(filterfield);
			dropdown.selectByValue("ACCOUNT.NAME");
			
			WebElement operator=driver.findElement(By.xpath("//select[@id='fop2']"));
			webElementToBeVisibile(operator);
			Select dropdown1=new Select(operator);
			dropdown1.selectByValue("c");
			
			WebElement value=driver.findElement(By.xpath("//input[@id='fval2']"));
			webElementToBeVisibile(value);
			value.sendKeys("T");
			
			WebElement save = driver.findElement(By.xpath("//div[3]//table[1]//tbody[1]//tr[1]//td[2]//input[1]"));
			webElementToBeVisibile(save);
			js.executeScript("arguments[0].click()", save);
			

	}

}
