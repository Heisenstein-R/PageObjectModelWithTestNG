package com.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import com.qa.base.TestBase;

public class TestUtil extends TestBase {

	public static long PAGE_LOAD_TIMEOUT = 30;
	public static long IMPLICITLY_WAIT = 30;

	public static String TEST_DATA_FILE_PATH = "C:\\Users\\91938\\eclipse-workspace\\POMTesting\\"
			+ "src\\main\\java\\com\\qa\\testdata\\FreeCRMContactsData.xlsx";
	public static FileInputStream file = null;
	public static XSSFWorkbook workbook = null;

	public static Object[][] getTestData(String sheetName) {

		try {
			file = new FileInputStream(TEST_DATA_FILE_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		try {
			workbook = new XSSFWorkbook(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		XSSFSheet sheet = workbook.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int j = 0; j < sheet.getRow(0).getLastCellNum(); j++) {
				data[i][j] = sheet.getRow(i + 1).getCell(j).toString();
			}
		}
		return data;
	}

	public static void TakeScreenShotWhenFailed(String MethodName) throws IOException {
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String userDirectory = System.getProperty("user.dir");
//		FileHandler.copy(srcFile, new File(userDirectory + "\\Screenshots\\" + MethodName+"_" +System.currentTimeMillis()+ ".png"));
		FileHandler.copy(srcFile, new File(userDirectory + "\\Screenshots\\" + MethodName + ".png"));
	}

}
