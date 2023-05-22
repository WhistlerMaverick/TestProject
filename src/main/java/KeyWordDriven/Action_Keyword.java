package KeyWordDriven;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Action_Keyword {
	public static WebDriver driver;
	public static WebDriverWait wait;
	
	public static void OpenBrowser(String URL) {
		System.setProperty("webdriver.gecko.driver", "/Users/RA20463861/Documents/GeckoDriver/geckodriver");
        driver = new FirefoxDriver();
		WebDriverManager.firefoxdriver().setup();
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		driver.get(URL);
		}
	
	public static void CloseBrowser() {
		driver.quit();
	}
	
	public static void SendValue(String content, String byOpt, String locVal ) {
		if (byOpt.equalsIgnoreCase("name")) {
			driver.findElement(By.name(locVal)).sendKeys(content);
		} else if (byOpt.equalsIgnoreCase("id")) {
			driver.findElement(By.id(locVal)).sendKeys(content);
		}
	}
	
	public static void Click(String byOpt, String locVal) {
		if (byOpt.equalsIgnoreCase("name")) {
			driver.findElement(By.name(locVal)).click();
		} else if (byOpt.equalsIgnoreCase("id")) {
			driver.findElement(By.id(locVal)).click();
		}
	}
	
	public static void Check(String checkText, String locAtr, String locVal) {
		if (locAtr.equalsIgnoreCase("xpath")) {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locVal)));
			String resText = driver.findElement(By.xpath(locVal)).getText();
			assertEquals(resText, checkText);
		} else if (locAtr.equalsIgnoreCase("id")) {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.id(locVal)));
			String resText = driver.findElement(By.id(locVal)).getText();
			assertEquals(resText, checkText);
		}
	}
	
}