package com.selenium.salesforce.automationHackathon;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class MyContactView extends BrowserUtilitySalesforce {

	public static void main(String[] args) throws Exception {
		
		
			BrowserUtilitySalesforce.launchBrowser("ch");
			BrowserUtilitySalesforce.loginToBrowser();
			Thread.sleep(5000);
			List<WebElement> li=driver.findElements(By.xpath("//ul[@id='tabBar']//li"));
			System.out.println(li.size());
			for(WebElement ele: li) {
				System.out.println(ele.getText());
				if(ele.getText().contains("Contacts")) {
					ele.click();
					break;
				}
			}
			Thread.sleep(5000);
			
			WebElement mycontact=driver.findElement(By.xpath("//select[@id='fcf']"));
			webElementToBeVisibile(mycontact);
			Select dropdown=new Select(mycontact);
			dropdown.selectByValue("00B5w00000D6ukZ");
			
			}
	
			

}
