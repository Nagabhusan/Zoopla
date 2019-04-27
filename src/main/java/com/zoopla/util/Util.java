package com.zoopla.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.zoopla.parent.WebFactory;

public class Util extends WebFactory {
	static Workbook workBook ;
	static Sheet sheet;
	static FileInputStream fileInputStream ;
	
	public static String TESTDATA_SHEET_PATH = "D:\\Selenium\\selenium_oxygen\\ZooplaExercise"
			+ "\\src\\resources\\java\\FreeCrmTestData.xlsx";
	
	public static boolean stringContainsNumber( String s )
	{
	    return Pattern.compile( "[0-9]" ).matcher( s ).find();
	}

	public static void takeScreenshotAtEndOfTest() throws IOException {
		
		TakesScreenshot scrShot =((TakesScreenshot)driver);
		File srcFile=scrShot.getScreenshotAs(OutputType.FILE);
		File destFile=new File("D:\\Selenium\\selenium_oxygen\\ZooplaExercise\\Screenshots\\"+System.currentTimeMillis()+"error.png");
		FileUtils.copyFile(srcFile, destFile); 
	}
	
	public static Object[][] getTestData(String sheetName) throws InvalidFormatException, IOException {
		fileInputStream = new FileInputStream(TESTDATA_SHEET_PATH);
		workBook = WorkbookFactory.create(fileInputStream);
		sheet = workBook.getSheet(sheetName);
		int rowCount = sheet.getLastRowNum();
		int cellCount= sheet.getRow(0).getLastCellNum();
		
		Object[][] data = new Object[rowCount][cellCount];
		
		for(int i=1;i<rowCount; i++) {
			for(int j=0; j<cellCount; j++) {
				data[i][j]= sheet.getRow(i).getCell(j);
			}
		}
		return data;
	}
	
}
