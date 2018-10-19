package objectPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class loginPageObject {
	
	WebDriver driver;
	ExtentTest test;
	
	@FindBy(xpath="//input[@placeholder='Username']")
	public WebElement userName;
	
	@FindBy(xpath="//input[@placeholder='Password']")
	public WebElement loginPassword;
	
	@FindBy(xpath="//button[@type='submit']")
	public WebElement loginButton;
	
	public loginPageObject(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnLoginButton() {

		loginButton.click();
		//test.log(LogStatus.INFO, "Clicked on Login button");

	}
	
	public void enterUsername(String userName1) {
		
		userName.sendKeys(userName1);
	}
	
	
	
	

}
