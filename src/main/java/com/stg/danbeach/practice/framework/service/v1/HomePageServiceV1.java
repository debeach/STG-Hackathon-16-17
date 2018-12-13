package com.stg.danbeach.practice.framework.service.v1;

import java.awt.AWTException;
import java.awt.Robot;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.stg.danbeach.practice.framework.browser.Browser;
import com.stg.danbeach.practice.framework.page.HomePage;

public class HomePageServiceV1 {

	public static void clickCompareResorts() throws AWTException {
		//*[@id="ski-utah-welcome-map"]/div/div[2]/div[4]/label/span[1]
//		WebElement temp = HomePageServiceV1.findHomePage().findElement(By.xpath("*[@id=\"ski-utah-welcome-map\"]/div/div[2]/div[4]/label/span[1]"));
		WebElement temp = HomePageServiceV1.findCompareResortsMenu(); // .click();
		System.out.println("x " + temp.getAttribute("class"));
		System.out.println("x " + temp.getText());
		JavascriptExecutor jse = (JavascriptExecutor) Browser.getDriver();
		jse.executeScript("window.scrollTo(0,document.body.getElementByClassName('map-Container').height(100%);");
		
//		HomePageServiceV1.findHomePage().findElement(By.className("map-Compare-selected--distance")).click();
	}

	/**
	 * Navigates the UI to the Home Page link and clicks it.
	 */
	public static void clickHomePageLink() {
		HomePageServiceV1.findHomePageLink().click();
	}

	/**
	 * Navigates the UI to the Miles from Airport link and clicks it.
	 */
	public static void clickMilesFromAirportLink() {
		HomePageServiceV1.findMilesFromAirportMenu().click();
	}

	public static WebElement findCompareResortsMenu() {
		return HomePageServiceV1.findHomePage().findElement(By.className("map-Container-compare"))
				.findElement(By.className("map-Compare-selected--reset"));  // map-Compare-menuLabel
//		return Browser.findElementsByClassName("map-Container-compare").get(0);
	}

	public static WebElement findHomePage() {
		return Browser.findElementById("main").findElement(By.className("map-Container"));
	}

	public static WebElement findHomePageLink() {
		return Browser.findElementsByClassName("HeaderMain-logo").get(0);
	}

	/**
	 * Navigates the UI to the Home Page, then to the Compare Resorts, then
	 * navigates to the Miles from Airport link.
	 * 
	 * @return the Miles from Airport link
	 */
	public static WebElement findMilesFromAirportMenu() {
		return HomePageServiceV1.findCompareResortsMenu().findElement(By.className("map-Compare-label--distance"));
//		WebElement compareResorts = HomePageServiceV1.findCompareResortsMenu();
//		return compareResorts.findElement(By.className("map-Compare-label--distance"));
	}

	public static void hoverHomePageLink() {
		WebElement link = Browser.findElementsByClassName(HomePage.homePageLogoClassName).get(0);
		Actions action = new Actions(Browser.getDriver());
		action.moveToElement(link).click().build().perform();
	}

	public static void navigateToCompareResorts() throws AWTException {
		HomePageServiceV1.navigateToHomePage();
		HomePageServiceV1.clickCompareResorts();
	}

	public static void navigateToHomePage() {
		HomePageServiceV1.hoverHomePageLink();
		HomePageServiceV1.clickHomePageLink();
	}

	public static void navigateToMilesToAirport() throws AWTException {
		HomePageServiceV1.navigateToCompareResorts();
		HomePageServiceV1.clickMilesFromAirportLink();
	}
}
