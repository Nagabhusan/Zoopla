package com.zoopla.util;

import java.io.File;
import java.io.IOException;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.zoopla.parent.WebFactory;

public class Util extends WebFactory {

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
}
