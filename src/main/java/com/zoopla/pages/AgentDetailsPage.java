package com.zoopla.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AgentDetailsPage extends SearchPropertyPage {

	@FindBy(xpath = "//h1[@class='bottom-half']/b")
	WebElement agentNameFromDetailsPage;

	public AgentDetailsPage() {
		PageFactory.initElements(driver, this);
	}

	public String getAgentNameFromDetailsPage() {
		agentNameFromDetailsPage.getText();
		System.out.println("Agent name from details page-----" + agentNameFromDetailsPage.getText());
		return agentNameFromDetailsPage.getText();
	}

}
