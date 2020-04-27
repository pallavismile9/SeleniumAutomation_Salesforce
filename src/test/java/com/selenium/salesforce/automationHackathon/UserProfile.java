package com.selenium.salesforce.automationHackathon;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserProfile extends BrowserUtilitySalesforce {

	public static void main(String[] args) throws Exception {
		
		BrowserUtilitySalesforce.launchBrowser("ch");
		BrowserUtilitySalesforce.loginToBrowser();
		
		//click on usermenu
		WebElement usermenu = driver.findElement(By.xpath("//span[@id='userNavLabel']"));
		webElementToBeVisibile(usermenu);
		usermenu.click();
		
		//click on myprofile
		WebElement myprofile = driver.findElement(By.xpath("//a[contains(text(),'My Profile')]"));
		webElementToBeVisibile(myprofile);
		myprofile.click();
		
		Thread.sleep(5000);
		
		//click on user menu (its javascript, used lacator css and JavascriptExecutor)
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//used cssselector:
		WebElement actbutton=driver.findElement(By.cssSelector("#moderatorMutton"));
		//WebElement actbutton = driver.findElement(By.xpath("//a[@id='moderatorMutton']"));
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(actbutton));
		//webElementToBeVisibile(actbutton);
		js.executeScript("arguments[0].click()", actbutton);
		
		//click on edit profile (use Javascript click() method)
		WebElement editprofile = driver.findElement(By.xpath("//a[contains(text(),'Edit Profile')]"));
		WebDriverWait wait1 = new WebDriverWait(driver,30);
		wait1.until(ExpectedConditions.elementToBeClickable(editprofile));
		js.executeScript("arguments[0].click()", editprofile);
		
		//webElementToBeVisibile(editprofile);
		//editprofile.click();
		
		//Switch to Frame AboutMe: 
	    driver.switchTo().frame(driver.findElement(By.id("aboutMeContentId")));
		//driver.switchTo().frame(driver.findElement(By.cssSelector("#lastName")));
		//driver.switchTo().frame(driver.findElement(By.xpath("//input[@id='lastName']")));
		Thread.sleep(5000);
		WebElement firstName = driver.findElement(By.cssSelector("#firstName"));
		WebDriverWait wait2 = new WebDriverWait(driver,30);
		wait2.until(ExpectedConditions.visibilityOf(firstName));
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		String text = (String) js1.executeScript("return arguments[0].value", firstName);
		System.out.println(text);
		//System.out.println(driver.findElement(By.xpath("//h2[@id='aboutMeTitle']")).getText());
		
		//Pass the value to lastname (Javascript Textbox)
		WebElement lastName = driver.findElement(By.cssSelector("#lastName"));
		WebDriverWait wait3 = new WebDriverWait(driver,30);
		wait3.until(ExpectedConditions.visibilityOf(lastName));
		JavascriptExecutor js2 = (JavascriptExecutor) driver;
		js2.executeScript("arguments[0].value='TekArch'", lastName);
		
		//Pass the value to AboutMe textbox( Textarea feild). Use sendKeys 
		WebElement aboutme = driver.findElement(By.cssSelector("#aboutMe"));
		WebDriverWait wait4 = new WebDriverWait(driver,30);
		wait4.until(ExpectedConditions.visibilityOf(aboutme));
		aboutme.sendKeys("QA Automation Engineer");
		
		//Click on saveAll
		WebElement saveall = driver.findElement(By.xpath("//input[contains(@class,'zen-btn zen-primaryBtn zen-pas')]"));
		webElementToBeVisibile(saveall);
		JavascriptExecutor js3 = (JavascriptExecutor) driver;
		js3.executeScript("arguments[0].click()", saveall);
		
		//Click on Add photo (Javascript enabled)
		WebElement addphoto = driver.findElement(By.cssSelector("#uploadLink"));
		WebDriverWait wait5 = new WebDriverWait(driver,30);
		wait5.until(ExpectedConditions.elementToBeClickable(addphoto));
		JavascriptExecutor js4 = (JavascriptExecutor) driver;
		js4.executeScript("arguments[0].click()", addphoto);
		
		//Switch to uploadphotoframe
		driver.switchTo().frame(driver.findElement(By.id("uploadPhotoContentId")));
		WebElement choosefile = driver.findElement(By.id("j_id0:uploadFileForm:uploadInputFile"));
		webElementToBeVisibile(choosefile);
		choosefile.sendKeys("C:\\Users\\Pallavi\\Downloads\\Jenkins.png.png");
		
		//Click on save button. use Action class to click.
		Thread.sleep(5000);
		WebElement save=driver.findElement(By.xpath("(//input[@class='btn saveButton'])[2]"));
		webElementToBeVisibile(save);
		Actions act=new Actions(driver);
		act.moveToElement(save).perform();
		act.moveToElement(save).click().perform();
		//act.click();
		//WebDriverWait wait6 = new WebDriverWait(driver,30);
		//wait6.until(ExpectedConditions.elementToBeClickable(save));
		//save.click();
		//JavascriptExecutor js5 = (JavascriptExecutor) driver;
		//String text1 = (String) js5.executeScript("return arguments[0].value", save);
		//System.out.println(text1);
		//js5.executeScript("arguments[0].click()", save);
		Thread.sleep(5000);
		
		//Crop the image. Use Actions class to crop the image
		WebElement crop = driver.findElement(By.xpath("//div[contains(@class,'imgCrop_handle imgCrop_handleNW')]"));
		webElementToBeVisibile(crop);
		Actions act_crop=new Actions(driver);
		act_crop.clickAndHold(crop).moveByOffset(60, 90).release().build().perform();

		//Save the image. Use Actions class to click 
		WebElement save_png=driver.findElement(By.xpath("//input[@id='j_id0:j_id7:save']"));
		webElementToBeVisibile(save_png);
		Actions act_png=new Actions(driver);
		act_png.moveToElement(save_png).perform();
		act_png.moveToElement(save_png).click().perform();
		
	}

}
