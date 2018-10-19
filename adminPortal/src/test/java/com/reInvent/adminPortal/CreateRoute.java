package com.reInvent.adminPortal;

import java.awt.Robot;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import org.openqa.selenium.Point;
import com.reInvent.adminPortalTestBase.testBase;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import objectPage.DashboardPageObject;
import objectPage.loginPageObject;

public class CreateRoute extends testBase{
	
	loginPageObject loginPage;
	DashboardPageObject db;
	ExtentReports report;
	ExtentTest test;
	
	
	@BeforeMethod
	public void setup() throws Exception {
		
		init();
		loginPage = new loginPageObject(driver, test);
		db = new DashboardPageObject(driver, test);
		loginPage.userName.sendKeys("psharma-alpha");
		loginPage.loginPassword.sendKeys("Punit@123");
		loginPage.clickOnLoginButton();
		
	}
	
	@Test
	public void createHappyPath() throws Exception {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Actions action = new Actions(driver);
		System.out.println("Done");
		Thread.sleep(5000);
		db.CreateRouteButton.click();
		driver.findElement(By.xpath("//div[contains(text(),'ARIA - MGM')]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@class='right-section']//label[1]//span[1]")).click();
		Thread.sleep(5000);
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@class='btn submit-btn shorter-btn ng-star-inserted']")).click();
		Thread.sleep(3000);
		//js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Thread.sleep(5000);
		WebElement cancel = driver.findElement(By.xpath("//button[@class='btn control-btn padded-btn']"));
		Point pi = cancel.getLocation();//1078,1344
		int xcord = pi.getX();
		int ycord = pi.getY();
		int halfOfHeight = cancel.getSize().getHeight()/2;
		int offset = halfOfHeight;
		System.out.println(xcord +","+ycord);
		Point coordinates = driver.findElement(By.xpath("//button[@class='btn control-btn padded-btn']")).getLocation();
		//action.moveByOffset(676,987).doubleClick().build().perform();
		System.out.println(coordinates);
		Robot rb = new Robot();
		rb.mouseMove(coordinates.getX(),coordinates.getY()+200);
		Thread.sleep(3000);
		action.click().build().perform();
		
	}

}
