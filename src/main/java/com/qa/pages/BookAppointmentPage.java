package com.qa.pages;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.qa.util.BaseClass;

public class BookAppointmentPage extends BaseClass {

	@FindBy(id = "request_name")
	public WebElement NameTextBox;

	@FindBy(id = "request_contact_no")
	public WebElement MobileNumberTextBox;

	@FindBy(id = "request_email")
	public WebElement EmailTextBox;

	@FindBy(id = "terms_and_conditions_chk")
	public WebElement TermAndCondition;

	public BookAppointmentPage() {
		PageFactory.initElements(driver, this);
	}

	public void EnterDetailsforAppointment(List<Map<String, String>> table) {
		for (Map<String, String> map : table) {
			waitForElementVisibility(NameTextBox);
			NameTextBox.sendKeys(map.get("Name"));
			MobileNumberTextBox.sendKeys(map.get("MobileNumber"));
			EmailTextBox.sendKeys(map.get("Email"));
			if (Boolean.valueOf(map.get("TC"))) {
				Click(TermAndCondition);
			}
		}
	}
	
	public void AssertElement(String name) {
		waitForElementVisibility(getButtonElement(name));
		Assert.assertTrue(getButtonElement(name).isDisplayed());
	}
}
