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

	public static WebDriver getDriver() {
		return driver;
	}

	/**
	 * Close the opened browser.
	 */
	public static void close() {
		driver.close();
	}
	/////////////////////////////////////////////
	
	public static WebElement findElementByClassName(final String className) {
		return driver.findElement(By.className(className));
	}
	
	public static WebElement findElementByName(final String name) {
		return driver.findElement(By.name(name));
	}
	
	
	/**
	 * Finds all elements on a page that are associated with the given class name.
	 * 
	 * @param className the class name that may be associated with elements
	 * @return a List of WebElements that are associated with the given class name.
	 */
	public static List<WebElement> findElementsByClassName(final String className) {
		return driver.findElements(By.className(className)); 
	}
	
	public static List<WebElement> findElementsByLinkText(final String linkText){
		return driver.findElements(By.linkText(linkText));
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
