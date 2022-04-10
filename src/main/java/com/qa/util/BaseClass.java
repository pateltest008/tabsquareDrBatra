package com.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class BaseClass {
	public static WebDriver driver;
	public static Properties prop;
	public static WebDriverWait wait;

	public BaseClass() {
		prop = new Properties();
		try {
			FileInputStream fl = new FileInputStream(
					System.getProperty("user.dir") + "/src/main/java/com" + "/qa/config/configuration.properties");
			prop.load(fl);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver.exe");
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void Initialize() {
		String browserName = prop.getProperty("browser");
		if (browserName.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (browserName.equals("FF")) {
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("url"));
	}

	public void Click(WebElement element) {
		Actions action = new Actions(driver);
		waitForElementVisibility(element);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		action.moveToElement(element).click().perform();
	}
	
	public WebElement GetCountryCode(String code) {
		String ElementString = "//li[contains(text(), \"%s\")]";
		return driver.findElement(By.xpath(String.format(ElementString, code)));
	}
	
	public void EnterValueInTextBox(WebElement element, String value) {
		waitForElementVisibility(element);
		element.sendKeys(value);
	}
	
	public void ClickOnButtonWithText(String text) {
		String ElementString = "//button[contains(text(), \"%s\")]";
		WebElement button = driver.findElement(By.xpath(String.format(ElementString, text)));
		Click(button);
	}

	public WebDriverWait waitForElementVisibility(WebElement element) {
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(element));
		return wait;
	}
	
	public WebElement getButtonElement(String name) {
		return driver.findElement(By.xpath("//button[contains(text(), \""+name+"\")]"));
	}
	
	public void switchToIFrame(WebElement element ) {
		waitForElementVisibility(element);
		driver.switchTo().frame(element);
	}
	
	public void switchToMainWindow() {
		driver.switchTo().defaultContent();
	}
	
	public void clickOnFieldWithText(String text) {
		String ElementString = "//*[contains(text(), \"%s\")]";
		Click(driver.findElement(By.xpath(String.format(ElementString, text))));
	}
	
//	public WebDriverWait waituntilTextDisplayed(String text) {
//		wait = new WebDriverWait(driver, 30);
//		String ElementString = 
//		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathExpression)));
//	}
	
	public void ScrollDownPage() {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}
	
	public void AssertonPage(String page) {
		waitForURL(page);
		waitForPageLoad();
		String expected = driver.getCurrentUrl();
		Assert.assertTrue(expected.indexOf(page)> -1);
	}
	
	public void waitForPageLoad() {
		wait = new WebDriverWait(driver, 30);
		wait.until(d -> ((JavascriptExecutor) d).executeScript("return (document.readyState === 'complete' || document.readyState === 'interactive')"));
		}
	
	public WebDriverWait waitForURL(String subUrl) {
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.urlContains(subUrl));
		return wait;
	}
}
