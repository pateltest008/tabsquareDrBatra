package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.qa.util.BaseClass;

public class HomePage extends BaseClass{
	
	public WebElement getMenuElement(String MenuText) {
		return driver.findElement(By.xpath("//ul[contains(@class,\"navbar-nav\")]//a[contains(text(), \""+MenuText+"\")]"));
	}
	
	public WebElement getSubMenuElement(String SubMenuText) {
		return driver.findElement(By.xpath("//a[@class=\"nav-link\" and contains(text(), \""+SubMenuText+"\")]"));
	}
	
	public WebElement getChildOfSubMenuElement(String ChildSubMenuText, String SubMenuText) {
		return driver.findElement(By.xpath("//a[@class=\"nav-link\" and contains(text(), \""+SubMenuText+"\")]/parent::*/div[contains(@class, \"sub-menu-undersub-child\")]//*[contains(text(), \""+ChildSubMenuText+"\")]"));
	}
	
	public void hoverOver(String text) {
		Click(getMenuElement(text));
	}
	
	public void clickOnSubMenu(String subMenuOption) {
		Click(getSubMenuElement(subMenuOption));
	}
	
	public void clickOnChildSubMenu(String ChildsubMenuOption, String subMenuOption) {
		Click(getChildOfSubMenuElement(ChildsubMenuOption, subMenuOption));
	}	
}
