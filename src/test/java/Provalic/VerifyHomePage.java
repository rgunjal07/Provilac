package Provalic;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import Pages.HomePage;

import Utils.Utility;

public class VerifyHomePage {
	
	WebDriver driver;
	String testID;
    HomePage homePage;
    SoftAssert soft;
    static ExtentTest test;
    static ExtentHtmlReporter reporter ;
        
    
	@BeforeTest   
    public void setUp() {
    	reporter = new ExtentHtmlReporter("test-output/ExtendReport/Extent.html");
		ExtentReports extend = new ExtentReports();
		extend.attachReporter(reporter);		
		driver = new ChromeDriver();
		driver.get("https://pune.provilac.com/qp");
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));		                  
    }
    
    @BeforeClass
    public void createPomObject() {
    	homePage = new HomePage(driver);
//    	soft = new SoftAssert();
    }    	
    
    @Test(priority = 1)
    public void VerifyLogin() throws InterruptedException {    	
    	testID ="T01";
    	homePage.login("9923427766");
    	String exp = "QuickPay Mobile - Provilac";
    	Assert.assertEquals(homePage.getHomepageTiltle(), exp); 	
    }   
        
    @Test(priority = 2)
    public void verifyWallet() {
    	testID ="T02";
    	Assert.assertEquals(homePage.getWalleteBalance(), "₹208");
    }
   
    @Test(priority = 3)    
    public void verifyUser() {
    	testID ="T03";
    	Assert.assertEquals(homePage.getUser(), "Vishal Pawale");
    }
   
    
    @AfterMethod
	public void captureScreenshotinFailure(ITestResult result) throws IOException {
		if(ITestResult.FAILURE== result.getStatus()) {
			Utility.captureScreenshot(driver, testID);
		}
    }	
    
    @AfterClass
	public void objectClear() {
		homePage = null;
				
	}
    
	@AfterTest
	public void closeBrowser() {
		driver.close();
		driver=null;
		System.gc();
	}

}
