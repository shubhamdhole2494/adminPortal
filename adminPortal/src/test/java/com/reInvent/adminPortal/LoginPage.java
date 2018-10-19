package com.reInvent.adminPortal;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.reInvent.adminPortalTestBase.testBase;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import objectPage.loginPageObject;

public class LoginPage extends testBase {
	
	loginPageObject loginPage; //= PageFactory.initElements(driver, loginPageObject.class);
	ExtentReports report;
	ExtentTest test;
	ExtentTest test1;
	ExtentTest test2;
	
	@BeforeClass
	public void setReport() {
		report = testBase.getReportInstance();
		test = report.startTest("Admin Web portal Login Test case");
	}
	@BeforeMethod
	public void setup() throws Exception {
		
		//test = report.startTest("Admin Web portal Login Test case");
		init();
		loginPage = new loginPageObject(driver, test);
		//report = testBase.getReportInstance();
		//test.log(LogStatus.INFO, "Chrome Browser Open");
		
	}
	
	@Test(priority=1)
	public void loginWithValidCredentials() {
		
		test1 = report.startTest("Admin Web portal Login Test With valid Credentilas");
		test1.log(LogStatus.INFO, "Chrome Browser Open");
		//loginPage = new loginPageObject(driver, test);
		loginPage.userName.sendKeys("psharma-alpha");
		test1.log(LogStatus.INFO, "Username Entered");
		loginPage.loginPassword.sendKeys("Punit@123");
		test1.log(LogStatus.INFO, "Password Entered");
		loginPage.clickOnLoginButton();	
		test1.log(LogStatus.INFO, "Clicked on Login button");
		
		WebElement usernameText = null;

		try {	
			usernameText = driver.findElement(By.xpath("//span[contains(text(),'psharma-alpha')]"));
		} catch (NoSuchElementException e) {
			System.out.println(e.getMessage());
		}
		Assert.assertTrue(usernameText != null);
		test1.log(LogStatus.PASS, "Verified Login Process");
		//report.endTest(test);
		
	}
	@Test(priority=2)
	public void loginWithInvalidCredentilas() {
		
		test2 = report.startTest("Admin Web portal Login Test With Invalid Credentilas");
		test2.log(LogStatus.INFO, "Chrome Browser Open");
		//loginPage = new loginPageObject(driver, test);
		loginPage.userName.sendKeys("psharma-alpha");
		test2.log(LogStatus.INFO, "Username Entered");
		loginPage.loginPassword.sendKeys("123456");
		test2.log(LogStatus.INFO, "Password Entered");
		loginPage.clickOnLoginButton();	
	}
	
	@AfterMethod
	public void endTest() {
		driver.quit();
		//report.endTest(test);
		//report.flush();
	}
	
	@AfterClass
	public void TearDown() {
		
		test
			.appendChild(test1)
			.appendChild(test2);
		
		report.endTest(test);
		report.flush();
	}

}
