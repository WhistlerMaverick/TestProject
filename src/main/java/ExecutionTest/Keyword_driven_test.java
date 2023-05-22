package ExecutionTest;

import org.testng.annotations.Test;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import KeyWordDriven.Action_Keyword;
import Utility.Constants;

public class Keyword_driven_test {

	@Test
	public void readFileAndExceute() throws IOException {

//		Read excel
		FileInputStream file = new FileInputStream(Constants.filePath);
		XSSFWorkbook wb = new XSSFWorkbook(file);
		XSSFSheet sheet = wb.getSheet("Sheet1");
		int row = sheet.getLastRowNum();
		int col = sheet.getRow(1).getLastCellNum();

		for (int i = 1; i <= row; i++) {
			ArrayList<String> tempArr = new ArrayList<String>();
			for (int j = 0; j < col; j++) {
				String cellVal = sheet.getRow(i).getCell(j).getStringCellValue();
				tempArr.add(cellVal);
			}

			String testCase = tempArr.get(0);
			String locatorAttribute = "";
			String locatorValue = "";
			if (!tempArr.get(1).equals("NA")) {
				String[] locatorArr = tempArr.get(1).split("=");
				locatorAttribute = locatorArr[0].trim();
				locatorValue = locatorArr[1].trim();
			}
			String value = tempArr.get(2);
			String keyWord = tempArr.get(3);
			
//			System.out.println(locatorAttribute.trim().equals("name") + " " + locatorAttribute);
			
			
			switch (keyWord) {
			case "enter":
				Action_Keyword.SendValue(value, locatorAttribute, locatorValue);
				break;
			case "open browser":
				Action_Keyword.OpenBrowser(value);
				break;
			case "close browser":
				Action_Keyword.CloseBrowser();
			case "click":
				Action_Keyword.Click(locatorAttribute, locatorValue);
			case "check":
				Action_Keyword.Check(value,locatorAttribute,locatorValue);
			default:
				break;
			}

		}
	}

}
