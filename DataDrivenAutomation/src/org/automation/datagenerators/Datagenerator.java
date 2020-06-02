package org.automation.datagenerators;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class Datagenerator {

	@DataProvider(name = "Excel")
	public static Object[][] excelTestDataGenerator(Method met) throws IOException {

		if (met.getName().equalsIgnoreCase("LoginFunctionality")) {

			// FileInputStream class for excel path
			// XSSFWorkbook class for read and write excel
			// XSSFSheet class for read & write particular sheet
			FileInputStream file = new FileInputStream("./TestData/TestData.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet loginSheet = workbook.getSheet("Login");
			int numberOfRows = loginSheet.getPhysicalNumberOfRows();
			Object[][] testData = new Object[numberOfRows][2];

			int i;
			for (i = 0; i < numberOfRows; i++) {

				XSSFRow row = loginSheet.getRow(i);
				XSSFCell email = row.getCell(0);
				XSSFCell pass = row.getCell(1);

				if (email.getCellType() == CellType.BLANK) {
					break;
				}

				testData[i][0] = email.getStringCellValue();
				testData[i][1] = pass.getStringCellValue();

			}

			Object[][] realData = new Object[i][2];

			for (int j = 0; j < i; j++) {

				realData[j][0] = testData[j][0];
				realData[j][1] = testData[j][1];

			}

			return realData;

		} else if (met.getName().equalsIgnoreCase("RegisterNewAccount")) {

			FileInputStream file = new FileInputStream("./TestData/TestData.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet newAccountSheet = workbook.getSheet("NewAccount");
			int numberOfRows = newAccountSheet.getPhysicalNumberOfRows();
			Object[][] testData = new Object[numberOfRows][3];

			for (int i = 0; i < numberOfRows; i++) {

				XSSFRow row = newAccountSheet.getRow(i);
				XSSFCell emailNew = row.getCell(0);
				XSSFCell passNew = row.getCell(1);
				XSSFCell passAgain = row.getCell(2);

				testData[i][0] = emailNew.getStringCellValue();
				testData[i][1] = passNew.getStringCellValue();
				testData[i][2] = passAgain.getStringCellValue();
			}
			return testData;
		}

		else {

			Object[][] testData = new Object[2][3];
			return testData;

		}

	}

	/*
	 * @DataProvider(name = "credentials") public Object[][] testDataGenerator() {
	 * 
	 * Object[][] data = { { "email1", "pass1" }, { "email2", "pass2", }, {
	 * "khinchi.chandra@gmail.com", "Banshi1980" } }; return data;
	 * 
	 * }
	 */

}
