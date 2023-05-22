package Comm_test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNGPC1 extends BaseClass {
	@Test
	public void Google() {
		WebElement search = driver.findElement(By.xpath("//*[@id=\"APjFqb\"]"));
		String val1 = "Testing";
		String val2 = "Java";
		String val3 = "Maven";
		search.sendKeys(val1 +  " " + val2 + " " + val3);
		search.sendKeys(Keys.ENTER);
	}

	@Test
//	@Ignore
	public void D() {
		System.out.println("This is the D");
	}

}
