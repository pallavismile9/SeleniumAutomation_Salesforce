package com.selenium.salesforce.automationHackathon;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class MergeAccounts extends BrowserUtilitySalesforce {

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
			WebElement reports = driver.findElement(By.xpath("//a[contains(text(),'Go to Reports')]"));
			webElementToBeClickable(reports);
			js.executeScript("arguments[0].click()", reports);
			/*
			Thread.sleep(2000);
			WebElement nothanks=driver.findElement(By.xpath("//button[@id='ext-gen54']"));
			webElementToBeClickable(nothanks);
			js.executeScript("arguments[0].click()", nothanks);*/
			
			WebElement newreport=driver.findElement(By.xpath("//div[@class='bPageTitle']//input[1]"));
			webElementToBeVisibile(newreport);
			js.executeScript("arguments[0].click()", newreport);
			
			Thread.sleep(5000);
			WebElement acct=driver.findElement(By.xpath("//span[contains(text(),'Accounts & Contacts')]"));
			//WebElement acct = driver.findElement(By.xpath("//ul[@id='ext-gen10']//li//div[contains(@class,'x-tree-node-el x-unselectable folder x-tree-node-collapsed x-tree-selected')]"));
			webElementToBeClickable(acct);
			js.executeScript("arguments[0].click()", acct);
			
			
			WebElement create = driver.findElement(By.xpath("//input[@id='thePage:rtForm:createButton']"));
			webElementToBeClickable(create);
			js.executeScript("arguments[0].click()", create);
			
			WebElement range = driver.findElement(By.xpath("//img[@id='ext-gen150']"));
			webElementToBeClickable(range);
			js.executeScript("arguments[0].click()", range);
			//input[@id='thePage:rtForm:createButton']
	
			WebElement last30days = driver.findElement(By.xpath("//div[@class='x-combo-list-item x-combo-selected']"));
			webElementToBeClickable(last30days);
			js.executeScript("arguments[0].click()", last30days);
			
			//div[@class='x-combo-list-item x-combo-selected']
			
			WebElement save = driver.findElement(By.xpath("//button[@id='ext-gen49']"));
			webElementToBeClickable(save);
			js.executeScript("arguments[0].click()", save);
			//button[@id='ext-gen49']
			
			WebElement reportname=driver.findElement(By.xpath("//input[@id='saveReportDlg_reportNameField']"));
			webElementToBeVisibile(reportname);
			reportname.clear();
			reportname.sendKeys("TekArch123");
			
			WebElement uniquename=driver.findElement(By.xpath("//input[@id='saveReportDlg_DeveloperName']"));
			webElementToBeVisibile(uniquename);
			uniquename.clear();
			uniquename.sendKeys("TekArch123");
			//input[@id='saveReportDlg_DeveloperName']
			Thread.sleep(2000);
			WebElement savereport = driver.findElement(By.xpath("//table[@id='dlgSaveReport']"));
			webElementToBeVisibile(savereport);
			js.executeScript("arguments[0].click()", savereport);
	
	}

}
