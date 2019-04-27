package com.zoopla.testpages;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.zoopla.constants.HomePageConstants;
import com.zoopla.pages.AgentDetailsPage;
import com.zoopla.pages.HomePage;
import com.zoopla.pages.SearchDetailsPage;
import com.zoopla.pages.SearchPropertyPage;
import com.zoopla.parent.WebFactory;

@Listeners(com.zoopla.util.MyListener.class)

public class ZooplaTest extends WebFactory {

	SearchPropertyPage searchPropertyPage;
	HomePage homePage;
	SearchDetailsPage searchDetailsPage;
	AgentDetailsPage agentDetailsPage;
	String actAgentName;
	
	public ZooplaTest() {
		super();
	}
	
	@BeforeMethod
	public void initBrowser() {
		initialization();
		homePage = new HomePage();
		searchPropertyPage = new SearchPropertyPage();
		searchDetailsPage = new SearchDetailsPage();
		agentDetailsPage = new AgentDetailsPage();

		
	}

	@Test (priority=1)
	public void verifyHomePageTittle() {	
		String tittle = homePage.getHomePageTittle();
		System.out.println(tittle);
		Assert.assertEquals(tittle, HomePageConstants.homePageTittle, "Tittle mismatched");
	}
	
	@Test (priority=2)
	public void validatePropertyPriceDESC(){
		homePage.searchCity(HomePageConstants.searchCity);
		searchPropertyPage.propertyPriceSortingDESC();
	}
	
	@Test (priority=3)
	public void getAgentDetailsFifthProperty(){
		homePage.searchCity(HomePageConstants.searchCity);
		searchPropertyPage.clickOnFifthPropertyPriceDESC();
		actAgentName = searchDetailsPage.getAgentName();
		searchDetailsPage.getAgentPhoneNo();
		searchDetailsPage.getLogoTxt();
		searchDetailsPage.clickOnAgentName();
	}	
	
	@Test (priority=4)
	public void validateAgentDetails(){
		homePage.searchCity(HomePageConstants.searchCity);
		searchPropertyPage.clickOnFifthPropertyPriceDESC();
		actAgentName = searchDetailsPage.getAgentName();
		searchDetailsPage.getAgentPhoneNo();
		searchDetailsPage.getLogoTxt();
		searchDetailsPage.clickOnAgentName();
		String agentDetails = agentDetailsPage.getAgentNameFromDetailsPage();
		Assert.assertEquals(actAgentName, agentDetails, "Agent name not matched");
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}
	
}
