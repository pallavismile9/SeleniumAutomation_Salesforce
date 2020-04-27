package com.selenium.salesforce.automationHackathon;



import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AccountTab extends BrowserUtilitySalesforce {

	public static void main(String[] args) throws Exception  {
		
	    BrowserUtilitySalesforce.launchBrowser("ch");
		BrowserUtilitySalesforce.loginToBrowser();
		
		Thread.sleep(5000);
		/*JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement account=driver.findElement(By.xpath("//ul[@id='tabBar']//a[@class='brandPrimaryFgr']"));
		//WebElement account = driver.findElement(By.xpath("//a[@class='brandPrimaryFgr']"));
		webElementToBeClickable(account);
		js.executeScript("arguments[0].click()", account);*/
		
		List<WebElement> li=driver.findElements(By.xpath("//ul[@id='tabBar']//li"));
		System.out.println(li.size());
		for(WebElement ele: li) {
			System.out.println(ele.getText());
			if(ele.getText().contains("Accounts")) {
				ele.click();
				break;
			}
		}
		
		
		//Alert al=driver.switchTo().alert();
		//System.out.println(al.getText());
		
		
		//WebElement window= driver.switchTo().window(driver.findElement(By.xpath("//a[@id='tryLexDialogX']")));
		
/*		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement close = driver.findElement(By.xpath("//a[@id='tryLexDialogX']"));
		webElementToBeClickable(close);
		js.executeScript("arguments[0].click()", close);*/
		
		
		/*ArrayList<String> openwindow=new ArrayList<String>(driver.getWindowHandles());
		openwindow.size();
		System.out.println(openwindow.size());
		*/
		
		Thread.sleep(5000);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement newacctbtn = driver.findElement(By.xpath("//input[contains(@name,'new')]"));
		webElementToBeClickable(newacctbtn);
		js.executeScript("arguments[0].click()", newacctbtn);
		
		Thread.sleep(2000);
		WebElement acctname = driver.findElement(By.xpath("//input[@id='acc2']"));
		webElementToBeVisibile(acctname);
		acctname.sendKeys("BankOfAmerica");
		
		WebElement type = driver.findElement(By.xpath("//select[@id='acc6']"));
		webElementToBeVisibile(type);
		Select dropdown=new Select(type);
		dropdown.selectByValue("Technology Partner");
		
		WebElement priority=driver.findElement(By.xpath("//select[@id='00N5w00000HXjdQ']"));
		webElementToBeVisibile(priority);
		Select dropdown1=new Select(priority);
		dropdown1.selectByValue("High");
		
		
		WebElement save=driver.findElement(By.xpath("//div[contains(@class,'pbBottomButtons')]//input[1]"));
		webElementToBeVisibile(save);
		js.executeScript("arguments[0].click()", save);
		
		quitBrowser();
		
	}

}
