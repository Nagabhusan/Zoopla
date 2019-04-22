package com.zoopla.testpages;

import org.testng.Assert;
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

	public testpage() {
		super();
	}

	@Test
	public void verify() {
		initialization();
		homePage = new HomePage();
		String tittle = homePage.homePageTittle();
		System.out.println(tittle);
		homePage.searchCity();
		
		searchPropertyPage = new SearchPropertyPage();
		searchPropertyPage.propertyPriceSortingDESC();
		searchPropertyPage.clickOnFifthPropertyPriceDESC();

		searchDetailsPage = new SearchDetailsPage();
		String actAgentName = searchDetailsPage.getAgentName();

		searchDetailsPage.getAgentPhoneNo();
		searchDetailsPage.getLogoTxt();
		searchDetailsPage.clickOnAgentName();
		agentDetailsPage = new AgentDetailsPage();
		String agentDetails = agentDetailsPage.getAgentNameFromDetailsPage();

		Assert.assertEquals(actAgentName, agentDetails, "Agent name not matched");
		driver.close();
	}
}
