package com.zoopla.testpages;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.zoopla.pages.AgentDetailsPage;
import com.zoopla.pages.HomePage;
import com.zoopla.pages.SearchDetailsPage;
import com.zoopla.pages.SearchPropertyPage;
import com.zoopla.parent.WebFactory;

@Listeners(com.zoopla.util.MyListener.class)

public class testpage extends WebFactory {

	SearchPropertyPage searchPropertyPage;
	HomePage homePage;
	SearchDetailsPage searchDetailsPage;
	AgentDetailsPage agentDetailsPage;
	String actAgentName;
	
	public testpage() {
		super();
	}
	
	@BeforeMethod
	public void initBrowser() {
		initialization();

	}

	@Test (priority=1)
	public void verifyHomePageTittle() {
		homePage = new HomePage();
		String tittle = homePage.homePageTittle();
		System.out.println(tittle);
	}
	
	@Test (priority=2)
	public void validatePropertyPriceDESC(){
		homePage.searchCity();
		searchPropertyPage = new SearchPropertyPage();
		searchPropertyPage.propertyPriceSortingDESC();
		searchPropertyPage.clickOnFifthPropertyPriceDESC();
	}
	
	@Test (priority=3)
	public void getAgentDetails(){
		searchDetailsPage = new SearchDetailsPage();
		actAgentName = searchDetailsPage.getAgentName();

		searchDetailsPage.getAgentPhoneNo();
		searchDetailsPage.getLogoTxt();
		searchDetailsPage.clickOnAgentName();
	}	
	
	@Test (priority=4)
	public void validateAgentDetails(){
		agentDetailsPage = new AgentDetailsPage();
		String agentDetails = agentDetailsPage.getAgentNameFromDetailsPage();
		Assert.assertEquals(actAgentName, agentDetails, "Agent name not matched");
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}
	
}
