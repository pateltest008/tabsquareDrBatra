package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.util.BaseClass;

public class ImmunityPage extends BaseClass {
	
	@FindBy(id ="chatNowBtn")
	public WebElement ChatBot;
	
	@FindBy(id ="kenytChatWindow")
	public WebElement IframeForChatWindow;
	
	@FindBy(xpath ="//span[contains(text(), \"close\")]")
	public WebElement CloseButtonChatBot;
	
	public ImmunityPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void closeChatBot() {
		switchToIFrame(IframeForChatWindow);
		Click(CloseButtonChatBot);
		switchToMainWindow();
	}
	
	public void ClickOnChatBot() {
		Click(ChatBot);
	}

}
