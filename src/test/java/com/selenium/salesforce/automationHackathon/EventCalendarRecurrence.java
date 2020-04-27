package com.selenium.salesforce.automationHackathon;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class EventCalendarRecurrence extends BrowserUtilitySalesforce {

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
		
		//calendar link
		Thread.sleep(5000);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		WebElement calendarlink = driver.findElement(By.xpath("//span[@class='pageDescription']//a"));
		webElementToBeClickable(calendarlink);
		js.executeScript("arguments[0].click()", calendarlink);
		
		//time link
		Thread.sleep(5000);
		WebElement timelink = driver.findElement(By.xpath("//a[contains(text(),'4:00 PM')]"));
		webElementToBeClickable(timelink);
		js.executeScript("arguments[0].click()", timelink);
		
		//subject
		Thread.sleep(2000);
		WebElement subject = driver.findElement(By.xpath("//body[contains(@class,'ext-webkit ext-chrome sfdcBody brandQuaternaryBgr')]/div[@id='contentWrapper']/div[contains(@class,'bodyDiv brdPalette brandPrimaryBrd')]/table[@id='bodyTable']/tbody/tr/td[@id='bodyCell']/form[@id='editPage']/div[@id='ep']/div[contains(@class,'pbBody')]/div[contains(@class,'pbSubsection')]/table[contains(@class,'detailList')]/tbody/tr/td[contains(@class,'dataCol col02')]/div[contains(@class,'requiredInput')]/a[1]"));
		webElementToBeClickable(subject);
		js.executeScript("arguments[0].click()", subject);
		
		//pop up
		ArrayList<String> openwindowlist=new ArrayList(driver.getWindowHandles());
		driver.switchTo().window(openwindowlist.get(1));
		WebElement other=driver.findElement(By.xpath("//a[contains(text(),'Other')]"));
		webElementToBeClickable(other);
		js.executeScript("arguments[0].click()", other);
		driver.switchTo().window(openwindowlist.get(0));
		Thread.sleep(2000);
		
		Thread.sleep(5000);
		WebElement endtime = driver.findElement(By.xpath("//input[@id='EndDateTime_time']"));
		webElementToBeVisibile(endtime);
		endtime.click();
		Thread.sleep(2000);
		WebElement time = driver.findElement(By.xpath("//div[@id='simpleTimePicker']//div[@id='timePickerItem_38']"));
		webElementToBeClickable(time);
		js.executeScript("arguments[0].click()", time);
	
		//recurrence checkbox
		WebElement recurrence = driver.findElement(By.xpath("//input[@id='IsRecurrence']"));
		webElementToBeVisibile(recurrence);
		if(!recurrence.isSelected()) {
			recurrence.isSelected();
			recurrence.click();
		}
		Thread.sleep(2000);
		
		//radiobutton weekly
		WebElement weekly=driver.findElement(By.xpath("//input[@id='rectypeftw']"));
		webElementToBeVisibile(weekly);
		if(!weekly.isEnabled()) {
			weekly.isEnabled();
			weekly.click();
		}
		
		WebElement recurrencedate = driver.findElement(By.xpath("//input[@id='RecurrenceEndDateOnly']"));
		webElementToBeVisibile(recurrencedate);
		recurrencedate.click();
		//date picker on click
		WebElement date= driver.findElement(By.xpath("//div[@id='datePicker']//td[contains(text(),'28')]"));
		webElementToBeVisibile(date);
		date.click();
		
		//save
		WebElement save = driver.findElement(By.xpath("//div[contains(@class,'pbBottomButtons')]//input[1]"));
		webElementToBeClickable(save);
		js.executeScript("arguments[0].click()", save);
		
		Thread.sleep(2000);
		WebElement monthlyview=driver.findElement(By.xpath("//span[contains(@class,'dwmIcons')]//a[3]"));
		webElementToBeClickable(monthlyview);
		js.executeScript("arguments[0].click()", monthlyview);
		
		
		Thread.sleep(2000);
		WebElement today=driver.findElement(By.xpath("//td[contains(@class,'calToday')]"));
		webElementToBeClickable(today);
		System.out.println(today.getAttribute("value"));
		
		quitBrowser();
		
	}

}
