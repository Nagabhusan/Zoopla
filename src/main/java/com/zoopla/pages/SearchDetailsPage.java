package com.zoopla.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchDetailsPage extends SearchPropertyPage {

	@FindBy(xpath = "//a[@data-track-label='Agent block 1']//img[@class='js-lazy-loaded']")
	WebElement agentLogo;

	@FindBy(xpath = "//div[@class='dp-sidebar-wrapper__contact']//h4")
	WebElement agentName;

	@FindBy(xpath = "//a[@data-track-label='Agent phone number 1']")
	WebElement agentPhoneNo;

	public SearchDetailsPage() {
		PageFactory.initElements(driver, this);
	}

	public boolean getLogoTxt() {
		boolean agentLogoStatus = agentLogo.isEnabled();
		System.out.println("Logo text is present -----" + agentLogoStatus);
		return agentLogoStatus;
	}

	public String getAgentName() {
		agentName.getText();
		System.out.println("Agent name -----" + agentName.getText());
		return agentName.getText();
	}

	public String getAgentPhoneNo() {
		agentPhoneNo.getText();
		System.out.println("Agent phone no -----" + agentPhoneNo.getText());
		return agentPhoneNo.getText();
	}

	public AgentDetailsPage clickOnAgentName() {
		agentName.click();
		System.out.println("clicked on agent name");
		return new AgentDetailsPage();
	}
}
