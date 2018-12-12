package com.stg.danbeach.practice.framework.service;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.stg.danbeach.practice.framework.browser.Browser;
import com.stg.danbeach.practice.framework.page.DealsPage;
import com.stg.danbeach.practice.framework.page.ExplorePage;
import com.stg.danbeach.practice.framework.page.PassesPage;
import com.stg.danbeach.practice.framework.page.PlanTripPage;
import com.stg.danbeach.practice.framework.page.SnowPage;
import com.stg.danbeach.practice.framework.page.StoriesPage;

public class MenuService {
	
	/**
	 * Finds the main navigation menu that is shared by all pages.
	 * 
	 * @return the main navigation menu.
	 */
	public static WebElement findMainNavMenu() {
		List<WebElement> elements = Browser.findElementsByClassName("HeaderMain-nav");
		return elements.get(0);
	}

	/**
	 * Finds a menu link found on the main navigation menu found on every page.
	 * 
	 * @param linkText the name of the main menu link you want to find.
	 * @return the main menu link from main menu.
	 */
	public static WebElement findMainNavMenuLinkByLinkText(final String linkText) {
		WebElement element = MenuService.findMainNavMenu().findElement(By.linkText(findPageMenuName(linkText)));
		element.click();
		return element;
	}

	/**
	 * Finds a sub-link to a main menu link on the main naviagtion menu.
	 * 
	 * @param mainMenuLink the main navigation menu link you want to find a
	 *                     sub-link.
	 * @param subMenuText  the name of the sub-link to be found in the main
	 *                     navigation menu link.
	 * @return the sub-link in the main menu link.
	 */
	public static List<WebElement> findSubNavMenuByLinkText(final String mainMenuLink, final String subMenuText) {
		WebElement mainLink = MenuService.findMainNavMenuLinkByLinkText(mainMenuLink);
		return mainLink.findElements(By.linkText(subMenuText));
	}

	/**
	 * Will click any link on the current page for the given link text.
	 * 
	 * @param linkText the text in a link to be clicked.
	 */
	public static void clickHeaderLinkByText(final String linkText) {
		WebElement link = MenuService.findMainNavMenuLinkByLinkText(linkText);
		link.click(); // click link
	}

	/**
	 * Clicks a sub-menu that is found in the main menu link.
	 * 
	 * @param headerLink the main menu link that may contain the sub-menu link.
	 * @param subLink    the sub-menu to be clicked.
	 */
	public static void clickSubHeaderLinkByText(final String headerLink, final String subLink) {
		List<WebElement> subMenus = MenuService.findSubNavMenuByLinkText(headerLink, subLink);
		subMenus.get(0).click();

	}

	/**
	 * Hovers the mouse over a main menu link.
	 * 
	 * @param linkText the main menu link to be hovered upon.
	 */
	public static void hoverOnListMenu(final String linkText) {
		WebElement link = MenuService.findMainNavMenuLinkByLinkText(linkText);
		Actions action = new Actions(Browser.getDriver());
		action.moveToElement(link).click().build().perform(); 
	}

	/**
	 * Will navigate to (click) one of the header (master) links on the skiutah home
	 * page. The parameter is the value stored in the 'pageName' class variable
	 * found on each Page object class.
	 * 
	 * @param menuPageName the name of each page found in the page's 'pageName'
	 *                     class variable.
	 */
	public static void navigateToListMenu(final String menuPageName) {
		MenuService.hoverOnListMenu(menuPageName);
		MenuService.clickHeaderLinkByText(menuPageName);
	}

	/**
	 * Navigates to a sub-menu within the main navigation menu. 
	 * @param menuPageName the link in the main menu that contains the sub- menu.
	 * @param subMenuPageName the name of the sub-menu to be tested.
	 */
	public static void navigateToSubMenu(final String menuPageName, final String subMenuPageName) {
		String linkText = findPageMenuName(menuPageName);
		MenuService.hoverOnListMenu(linkText);
		MenuService.clickSubHeaderLinkByText(menuPageName, subMenuPageName);
	}
	
	
	
//////////////////////////////////////////// HELPER METHODS
////////////////////////////////////////////

	/**
	 * Sets the text used for the main list links so it can be used to navigate to
	 * that link.
	 * 
	 * @param menuPageName preset value that is part of each Page Object class.
	 * @return the text used to navigate to the main nav menu on skiutah.com
	 */
	public static String findPageMenuName(final String menuPageName) {
		String linkText = PlanTripPage.pageLinkText; // default value
		switch (menuPageName) {
		case "Deals":
			linkText = DealsPage.pageLinkText;
			break;
		case "Explore":
			linkText = ExplorePage.pageLinkText;
			break;
		case "Passes":
			linkText = PassesPage.pageLinkText;
			break;
		case "PlanTrip":
			linkText = PlanTripPage.pageLinkText;
			break;
		case "ResortsSnow":
			linkText = SnowPage.pageLinkText;
			break;
		case "Stories":
			linkText = StoriesPage.pageLinkText;
			break;
		default:
			linkText = PlanTripPage.pageLinkText; // default value
			break;
		}
		return linkText;
	}
}
