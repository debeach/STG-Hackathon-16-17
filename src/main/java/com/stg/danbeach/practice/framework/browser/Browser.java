package com.stg.danbeach.practice.framework.browser;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Browser {
	private static WebDriver driver;

	/**
	 * Will click any link on the current page for the given link text.
	 * 
	 * @param linkText the text in a link to be clicked.
	 */
	public static void clickHeaderLinkByText(final String linkText) {  
		List<WebElement> links = driver.findElement(By.className("HeaderMain-nav")).findElements(By.linkText(linkText.toUpperCase()));
		System.out.println("number of links " + links.size());
		System.out.println("BrowserPage " + linkText);
		System.out.println("text is " + links.get(0).getText());
		links.get(0).click(); // open drop down
		// TODO: THE SECOND CLICK KILLS THE STORIES TEST. MAY HAVE TO ACCOUNT FOR IT WITH AN IF.
		links.get(0).click(); // click link
		System.out.println("AFTER BOTH CLICKS");
//		for(WebElement element: links) {
//			System.out.println(element.getText().trim());
//		}
		
		
		//		Actions action = new Actions(driver);
//		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
////		WebElement menuLink = driver.findElement(By.linkText(linkText));
//		WebElement menuLink = driver.findElement(By.xpath("//a[@title='" + linkText + "']"));
//		action.moveToElement(menuLink).click();
		
//		menuLink.click();
	}

	/**
	 * Close the opened browser.
	 */
	public static void close() {
		driver.close();
	}

	/**
	 * Navigate to the URL page requested.
	 * 
	 * @param url the URL page requested.
	 */
	public static void goTo(final String url) {
		driver.get(url);
	}

	
	/**
	 * Set what WebDriver you need for the test.
	 * 
	 * @param browserName the name of the desired browser.
	 */
	public static void setBrowser(final String browserName) {
		switch (browserName) {
		case "Chrome":
			driver = new ChromeDriver();
			break;
		case "Firefox":
			driver = new FirefoxDriver();
			break;
		default:
			driver = new ChromeDriver();
			break;
		}
	}

	/**
	 * Returns the current page title.
	 * 
	 * @return the current page title.
	 */
	public static String title() {
		return driver.getTitle();
	}

}
