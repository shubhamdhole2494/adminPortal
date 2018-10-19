package com.reInvent.adminPortalTestBase;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.relevantcodes.extentreports.ExtentReports;

public class testBase {
	
	public WebDriver driver;
	String baseurl = "https://qa-portal.reinvent2017.com/index.html#/";
	String browsers = "chrome";
	public static Properties config = new Properties();
	public static FileInputStream fis;
	String os = System.getProperty("os.name").toLowerCase();
	
	
	public void init() throws Exception {
		
		selectBrowser(browsers);
		getURL(baseurl);
		
	}

	
	public void selectBrowser(String browser) {
		if (browser.equalsIgnoreCase("firefox")) {

			driver = new FirefoxDriver();

		} else if (browser.equalsIgnoreCase("chrome")) {

			//driver = new ChromeDriver();
			if (os.contains("mac")) {
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver");
			} else {

				System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "/drivers/chromedriver.exe");
			}
			driver = new ChromeDriver();

		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}
	
	public void getURL(String url) {

		driver.get(url);
		//driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}
	
	public void loadPropertiesFile() throws Exception {

		

		fis = new FileInputStream(System.getProperty("user.dir") + "/adminPortal/src/main/java/config/Config.properties");
		config.load(fis);

		//adminPortal/src/main/java/config/Config.properties
	}
	
	public static ExtentReports getReportInstance() {
		ExtentReports extent;
		String Path = System.getProperty("user.dir") + "/Reports/report.html";
		extent = new ExtentReports(Path, false);
		//extent.addSystemInfo("Selenium Version", "2.52").addSystemInfo("Platform", "Mac");
		return extent;
	}
}
