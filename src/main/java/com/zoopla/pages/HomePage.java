package com.zoopla.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.zoopla.constants.HomePageConstants;
import com.zoopla.parent.WebFactory;

public class HomePage extends WebFactory{
	
	@FindBy(xpath = "//a[contains(text(), 'Sign in') and @class='button button--tertiary-dark account-link__text']")
	WebElement signInBtn;
	
	@FindBy(name="q")
	WebElement searchTxt;
	
	@FindBy(xpath = "//button[text()='Search']")
	WebElement searchBtn;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String homePageTittle() {
		return driver.getTitle();
		
	}
	
	public SearchPropertyPage searchCity() {
		searchTxt.sendKeys(HomePageConstants.searchCity);
		searchBtn.click();
		return new SearchPropertyPage();
	}
	
	
}
