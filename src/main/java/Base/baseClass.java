package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class baseClass {
	public static WebDriver driver;

	public static void Start() {
		System.setProperty("webdriver.gecko.driver", "/Users/RA20463861/Documents/GeckoDriver/geckodriver");
		driver = new FirefoxDriver();
		WebDriverManager.firefoxdriver().setup();
		driver.manage().window().maximize();
	}

}
