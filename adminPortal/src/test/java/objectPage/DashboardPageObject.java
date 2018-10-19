package objectPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;

public class DashboardPageObject {
	
	WebDriver driver;
	ExtentTest test;
	
	@FindBy(xpath="//button[@class='btn submit-btn create-btn']")
	public WebElement CreateRouteButton;
	
	public DashboardPageObject(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
		PageFactory.initElements(driver, this);
	}

}
