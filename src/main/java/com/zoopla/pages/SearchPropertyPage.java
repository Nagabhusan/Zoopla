package com.zoopla.pages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.zoopla.util.Util;

public class SearchPropertyPage extends HomePage {

	List<String> propertyPriceListStr = new ArrayList<String>();
	List<Integer> price = new ArrayList<Integer>();

	public SearchPropertyPage() {
		PageFactory.initElements(driver, this);
	}

	List<WebElement> propertyPriceList = driver.findElements(By.xpath(
			"//li[starts-with(@id,'listing_')]//child::div//child::div[2]//child::a[@class='listing-results-price text-price']"));

	public List<Integer> propertyPriceSortingDESC() {
		int listSize = propertyPriceList.size();
		System.out.println(listSize);
		for (int i = 0; i < listSize; i++) {
			if (Util.stringContainsNumber(propertyPriceList.get(i).getText()) == true) {
				String removeSplChar = propertyPriceList.get(i).getText().substring(1).split(" ")[0];
				String removeComma = removeSplChar.replace(",", "");
				propertyPriceListStr.add(removeComma);
				price.add(Integer.parseInt(propertyPriceListStr.get(i)));
			}

		}

		Collections.sort(price);
		System.out.println("---------------DESC sorted list---------------------");
		Collections.sort(price, Collections.reverseOrder());
		for (int i = 0; i < price.size(); i++) {
			System.out.println(price.get(i));
		}

		return price;
	}

	public SearchDetailsPage clickOnFifthPropertyPriceDESC() {
		String FifthPropertyPriceDESC = price.get(4).toString();
		System.out.println("Fifth highest price found ------ " + FifthPropertyPriceDESC);
		int flag = 0;
		for (WebElement propertyPrice : propertyPriceList) {
			if ((propertyPrice.getText().substring(1).split(" ")[0].replace(",", "")).equals(FifthPropertyPriceDESC)) {
				JavascriptExecutor executor = (JavascriptExecutor) driver;
				executor.executeScript("arguments[0].click();", propertyPrice);
				System.out.println("Fifth property clicked");
				flag = flag + 1;
			}
			if (flag > 0) {
				break;
			}
		}
		return new SearchDetailsPage();
	}

}
