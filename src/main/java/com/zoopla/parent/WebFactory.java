package com.zoopla.parent;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebFactory {

	public static Properties prop;
	public static WebDriver driver;

	public WebFactory() {

		try {
			prop = new Properties();
			FileInputStream inputFile = new FileInputStream(
					"D:\\Selenium\\selenium_oxygen\\ZooplaExercise\\src\\" + "resources\\java\\config.properties");
			prop.load(inputFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void initialization() {
		String browserName = prop.getProperty("browserName");

		if (browserName.equals("FF") || browserName.equals("Firefox") || browserName.equals("FIREFOX")) {
			System.setProperty("webdriver.gecko.driver",
					"D:\\Selenium\\selenium_oxygen\\ZooplaExercise\\src\\resources\\java\\drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browserName.equals("chrome") || browserName.equals("Chrome") || browserName.equals("CHROME")) {
			System.setProperty("webdriver.chrome.driver",
					"D:\\Selenium\\selenium_oxygen\\ZooplaExercise\\src\\resources\\java\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}
}
