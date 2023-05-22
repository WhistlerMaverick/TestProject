package Comm_test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public String URL = "https://www.google.com/";
	public WebDriver driver;
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("----Before Method----");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("----After Method----");
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("----Before Class----");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("----After Class----");
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("----Before Test----");
		System.setProperty("webdriver.gecko.driver", "/Users/RA20463861/Documents/GeckoDriver/geckodriver");
        driver = new FirefoxDriver();
		WebDriverManager.firefoxdriver().setup();
		driver.manage().window().maximize();
		driver.get(URL);
	}

	@AfterTest
	public void afterTest() throws InterruptedException {
		System.out.println("----After Test----");
		Thread.sleep(5000);
		driver.quit();
	}

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("----Before Suite----");
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("----After Suite----");
	}
}
