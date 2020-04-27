package com.selenium.salesforce.automationHackathon;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Opportunity extends BrowserUtilitySalesforce {

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
		Thread.sleep(10000);
		//driver.manage().deleteAllCookies();
		/*driver.navigate().refresh();
		WebElement crt=driver.findElement(By.xpath("//div[@id='createNewButton']"));
		webElementToBeClickable(crt);
		System.out.println("success");*/
		
		
		
		//driver.manage().deleteAllCookies();
		//driver.switchTo().activeElement();
		/*WebElement pge = driver.findElement(By.xpath("//h2[contains(@class,'pageDescription')]"));
		webElementToBeVisibile(pge);
		Thread.sleep(5000);
		System.out.println(pge.getText());
		*/
		
		//New Oppty
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement newopp=driver.findElement(By.xpath("//input[@name='new']"));
		webElementToBeClickable(newopp);
		js.executeScript("arguments[0].click()", newopp);
		
		WebElement opptyname = driver.findElement(By.xpath("//input[@id='opp3']"));
		webElementToBeVisibile(opptyname);
		opptyname.clear();
		opptyname.sendKeys("Apple");
		
		
		WebElement acctname = driver.findElement(By.xpath("//a[@id='opp4_lkwgt']"));
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		webElementToBeClickable(acctname);
		js1.executeScript("arguments[0].click()", acctname);
		
		//Accountname:---note : 2 frames
		ArrayList<String> openwindow=new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(openwindow.get(1));
		driver.switchTo().frame(driver.findElement(By.id("searchFrame")));
		WebElement gobtn= driver.findElement(By.xpath("//input[@name='go']"));
		webElementToBeClickable(gobtn);
		js.executeScript("arguments[0].click()", gobtn);
		System.out.println("success");
		driver.switchTo().defaultContent();
		
		Thread.sleep(5000);
		driver.switchTo().frame(driver.findElement(By.id("resultsFrame")));
		WebElement tek=driver.findElement(By.xpath("//a[contains(@class,'dataCell')]"));
		webElementToBeClickable(tek);
		js.executeScript("arguments[0].click()", tek);
		System.out.println("success1");
		driver.switchTo().window(openwindow.get(0));
		
		//closedate
		WebElement closedate=driver.findElement(By.xpath("//a[contains(text(),'4')]"));
		webElementToBeClickable(closedate);
		js.executeScript("arguments[0].click()", closedate);
		System.out.println("success2");
		
		//stage
		WebElement stage=driver.findElement(By.xpath("//select[@id='opp11']"));
		Select drpdwn=new Select(stage);
		drpdwn.selectByValue("Prospecting");
		
		//save
		
		WebElement save=driver.findElement(By.xpath("//div[contains(@class,'pbBottomButtons')]//input[1]"));
		webElementToBeClickable(save);
		js.executeScript("arguments[0].click()", save);
		System.out.println("success3");
		
		//List<WebElement> newoppty = driver.findElements(By.xpath("//form[@id='hotlist']//table//tbody//tr//td"));
		//System.out.println(newoppty.size());
		//for(WebElement ele: newoppty) {
		
			 //System.out.println(ele.getText());
			/*if(ele.getText().trim().equals("New")){
			JavascriptExecutor js = (JavascriptExecutor) driver;
			
			webElementToBeClickable(ele);
			js.executeScript("arguments[0].click()", newoppty);
			//newoppty.click();
		}*/
			//}
		//js.executeScript("arguments[0].click()", newoppty);
	}

}
