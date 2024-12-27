package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class BrowserSetUp {
	public static void launchBrowser(String browserName) {
		if(browserName.equals("Chrome")) {
			System.setProperty("WebDriver.chrome.driver","src\\test\\resources\\BrowserFiles\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();						
		}
		
		if(browserName.equals("Edge")) {
			System.setProperty("WebDriver.edge.driver","src\\test\\resources\\BrowserFiles\\msedgedriver.exe");
			WebDriver driver = new EdgeDriver();			
		}
	}
	
}
