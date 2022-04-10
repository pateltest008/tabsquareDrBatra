package com.qa.stepdef;

import java.util.List;
import java.util.Map;

import com.qa.pages.BookAppointmentPage;
import com.qa.pages.HomePage;
import com.qa.pages.ImmunityPage;
import com.qa.util.BaseClass;

import cucumber.api.java.en.Given;

public class Stepdefs extends BaseClass {
	HomePage home = new HomePage();
	ImmunityPage immunity = new ImmunityPage();
	BookAppointmentPage appointment =new BookAppointmentPage();

	@Given("^I am on the \"([^\"]*)\"'s home page$")
	public void i_am_on_the_s_home_page(String url) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		AssertonPage(url);
	}

	@Given("^I Hoverover \"([^\"]*)\" menu$")
	public void i_Hoverover_menu(String text) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		home.hoverOver(text);
	}

	@Given("^I click on \"([^\"]*)\" option under \"([^\"]*)\" submenu$")
	public void i_click_on_option_under_submenu(String ChildSubMenu, String SubMenu) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		home.clickOnSubMenu(SubMenu);
		home.clickOnChildSubMenu(ChildSubMenu, SubMenu);
	}

	@Given("^I am on the \"([^\"]*)\" page$")
	public void i_am_on_the_page(String page) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		AssertonPage(page.toLowerCase());
	}

	@Given("^I click on the chatbot$")
	public void i_click_on_the_chatbot() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		immunity.ClickOnChatBot();
	}
	
	@Given("^I close chatbot$")
	public void i_close_chatbot() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    immunity.closeChatBot();
	}
	
	@Given("^I click on the \"([^\"]*)\" field$")
	public void i_click_on_the_field(String fieldName) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		clickOnFieldWithText(fieldName);
	}
	
	@Given("^I enter below details$")
	public void i_enter_below_details(List<Map<String, String>> table) throws Throwable {
	    appointment.EnterDetailsforAppointment(table);
	}
	
	@Given("^I can see \"([^\"]*)\" button$")
	public void i_can_see_button(String buttonName) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		appointment.AssertElement(buttonName);
	}

}
