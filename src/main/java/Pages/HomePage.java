package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePage {
	private WebDriver driver;
	
	@FindBy(xpath = "//*[@id='mobileNumber']")
	private WebElement SendMobile;
	
	@FindBy(xpath = "(//*[@id='recaptcha-anchor']//div)[1]")
	private WebElement checkBox;
	
	@FindBy(xpath = "//a[@id='send-link-btn']")
	private WebElement submitBtn;
	
	@FindBy(xpath = "//*[@class='flex-fill']/strong")
	private WebElement walletBalance;
	
	@FindBy(xpath = "(//*[@data-toggle='dropdown'])[1]")
	private WebElement verifyUser;
	
	@FindBy(xpath = "//*[@type='number']")
	private WebElement textBox;
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	public void login(String num) throws InterruptedException {
		SendMobile.clear();
		SendMobile.sendKeys(num);
		driver.switchTo().frame(0);
		checkBox.click();
		Thread.sleep(3000);
		driver.switchTo().defaultContent();
		submitBtn.click();
	}
	
	public String getHomepageTiltle() {
		return driver.getTitle();
	}
	
	public String getWalleteBalance() {
		return walletBalance.getText();
	}
	
	public String getUser() {
		return verifyUser.getText();
	}
	
	public void sendRechargeAmount(String num) {
		textBox.sendKeys(num);
	}
	
	
		
	

}
