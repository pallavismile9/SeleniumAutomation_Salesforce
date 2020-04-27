package com.selenium.salesforce.automationHackathon;

import java.util.ArrayList;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserSettings extends BrowserUtilitySalesforce {

	public static void main(String[] args) throws Exception {
		BrowserUtilitySalesforce.launchBrowser("ch");
		BrowserUtilitySalesforce.loginToBrowser();
		
		WebElement usermenu = driver.findElement(By.xpath("//span[@id='userNavLabel']"));
		webElementToBeVisibile(usermenu);
		usermenu.click();
		
		WebElement mysettings = driver.findElement(By.xpath("//a[contains(text(),'My Settings')]"));
		webElementToBeVisibile(mysettings);
		mysettings.click();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		Thread.sleep(5000);
		//WebElement personal=driver.findElement(By.partialLinkText("personalInformationSetup"));
		//WebElement personal=driver.findElement(By.xpath("//div[@id='PersonalInfo']//span[@class='accordionIcon expand_icon']"));
		//WebElement personal=driver.findElement(By.xpath("(//a[contains(@href,'personalInformationSetup')])[1]"));
		//System.out.println(personal.getText());
		//WebElement personal=driver.findElement(By.xpath("//div[@id='PersonalInfo']"));
		
		//use cssSelector and JavascriptExecutor to click on personal tab
		
		WebElement personal = driver.findElement(By.cssSelector("#PersonalInfo_font"));
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(personal));
		js.executeScript("arguments[0].click()", personal);
		
		//loginhistory
		Thread.sleep(2000);
		WebElement loginhistory = driver.findElement(By.xpath("//a[@id='LoginHistory_font']"));
		WebDriverWait wait1 = new WebDriverWait(driver,30);
		wait1.until(ExpectedConditions.elementToBeClickable(loginhistory));
		js.executeScript("arguments[0].click()", loginhistory);
		
		//download
		Thread.sleep(2000);
		WebElement download = driver.findElement(By.xpath("//a[contains(text(),'Download login history for last six months, includ')]"));
		WebDriverWait wait2 = new WebDriverWait(driver,30);
		wait2.until(ExpectedConditions.elementToBeClickable(download));
		js.executeScript("arguments[0].click()", download);
		
		//displayandlayout
		Thread.sleep(2000);
		WebElement display = driver.findElement(By.cssSelector("#DisplayAndLayout_font"));
		WebDriverWait wait3 = new WebDriverWait(driver,30);
		wait3.until(ExpectedConditions.elementToBeClickable(display));
		js.executeScript("arguments[0].scrollIntoView()", display);
		js.executeScript("arguments[0].click()", display);
		
		//customize tabs
		Thread.sleep(2000);
		WebElement customizetabs = driver.findElement(By.xpath("//a[@id='CustomizeTabs_font']"));
		WebDriverWait wait4 = new WebDriverWait(driver,30);
		wait4.until(ExpectedConditions.elementToBeClickable(customizetabs));
		js.executeScript("arguments[0].click()", customizetabs);
		
		//dropdown: use Select class. multiple values selected : report and scorecard
		Thread.sleep(2000);
		WebElement dropdowntabs = driver.findElement(By.xpath("//select[@id='duel_select_0']"));
		Select dropdown=new Select(dropdowntabs);
		dropdown.selectByValue("report");
		dropdown.selectByValue("Scorecard");
		
		//add button
		Thread.sleep(2000);
		WebElement add = driver.findElement(By.cssSelector("#duel_select_0_right"));
		WebDriverWait wait5 = new WebDriverWait(driver,30);
		wait5.until(ExpectedConditions.elementToBeClickable(add));
		js.executeScript("arguments[0].click()", add);
		
		//save
		Thread.sleep(2000);
		WebElement save = driver.findElement(By.xpath("//td[@id='bottomButtonRow']//input[contains(@name,'save')]"));
		WebDriverWait wait6 = new WebDriverWait(driver,30);
		wait6.until(ExpectedConditions.elementToBeClickable(save));
		js.executeScript("arguments[0].click()", save);
		
		//emailsetup
		Thread.sleep(2000);
		WebElement email =driver.findElement(By.xpath("//div[@id='EmailSetup']//a[contains(@class,'header setupFolder')]"));
		WebDriverWait wait7 = new WebDriverWait(driver,30);
		wait7.until(ExpectedConditions.elementToBeClickable(email));
		js.executeScript("arguments[0].scrollIntoView()", email);
		js.executeScript("arguments[0].click()", email);
		
		Thread.sleep(2000);
		WebElement emailsettings = driver.findElement(By.xpath("//a[@id='EmailSettings_font']"));
		WebDriverWait wait8 = new WebDriverWait(driver,30);
		wait8.until(ExpectedConditions.elementToBeClickable(emailsettings));
		//js.executeScript("arguments[0].scrollIntoView()", emailsettings);
		js.executeScript("arguments[0].click()", emailsettings);
		
		//emailname firstname
		Thread.sleep(2000);
		WebElement emailname = driver.findElement(By.xpath("//input[@id='sender_name']"));
		webElementToBeVisibile(emailname);
		emailname.clear();
		js.executeScript("arguments[0].value='Pallavi QA'", emailname);
		
		//email address
		Thread.sleep(2000);
		WebElement emailaddress = driver.findElement(By.xpath("//input[@id='sender_email']"));
		webElementToBeVisibile(emailaddress);
		emailaddress.clear();
		js.executeScript("arguments[0].value='Pallavi.d@salesforce.com'", emailaddress);
		
		WebElement bcc = driver.findElement(By.xpath("//input[@id='auto_bcc1']"));
		if(!bcc.isSelected()) {
			bcc.click();
		}
		
		//email. alert box popups. user Alert class and accept.
		Thread.sleep(2000);
		WebElement saveemail = driver.findElement(By.xpath("//input[@name='save']"));
		WebDriverWait wait9 = new WebDriverWait(driver,30);
		wait9.until(ExpectedConditions.elementToBeClickable(saveemail));
		js.executeScript("arguments[0].click()", saveemail);
		Alert btn=driver.switchTo().alert();
		btn.accept();
		
		//calendar
		
		WebElement calendar = driver.findElement(By.xpath("//div[@id='CalendarAndReminders']//a[@class='header setupFolder']"));
		WebDriverWait wait10 = new WebDriverWait(driver,30);
		wait10.until(ExpectedConditions.elementToBeClickable(calendar));
		js.executeScript("arguments[0].scrollIntoView()", calendar);
		js.executeScript("arguments[0].click()", calendar);
		
		//activity
		WebElement activity = driver.findElement(By.xpath("//a[@id='Reminders_font']"));
		WebDriverWait wait11 = new WebDriverWait(driver,30);
		wait11.until(ExpectedConditions.elementToBeClickable(activity));
		//js.executeScript("arguments[0].scrollIntoView()", activity);
		js.executeScript("arguments[0].click()", activity);
		
		//reminder
		WebElement reminder = driver.findElement(By.xpath("//input[@id='testbtn']"));
		WebDriverWait wait12 = new WebDriverWait(driver,30);
		wait12.until(ExpectedConditions.elementToBeClickable(reminder));
		js.executeScript("arguments[0].click()", reminder);
		
		/*Thread.sleep(2000);
		//driver.get("https://na172.salesforce.com/ui/core/activity/ActivityReminderPage?at=1587852752938&test=1");
		WebElement dismissall = driver.findElement(By.xpath("//input[@id='dismiss_all']"));
		WebDriverWait wait14 = new WebDriverWait(driver,30);
		wait14.until(ExpectedConditions.elementToBeClickable(dismissall));
		js.executeScript("arguments[0].click()", dismissall);*/
		
		
		//ArrayList<String> openwindow=new ArrayList<String>(driver.getWindowHandles());
		//openwindow.size();
		//System.out.println(openwindow.size());
		//driver.switchTo().window(openwindow.get(1));
		//Thread.sleep(2000);
		//driver.close();
		//driver.switchTo().window(openwindow.get(0));
		
		quitBrowser();
	
	}

}
