package com.stg.danbeach.practice.framework.service.v1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.stg.danbeach.practice.framework.browser.Browser;

public class MenuServiceV1 {

	/**
	 * Will click any link on the current page for the given link text.
	 * 
	 * @param linkText the text in a link to be clicked.
	 */
	public static void clickHeaderLinkByText(final String linkText) {
		MenuServiceV1.findMainNavMenuLinkByText(linkText).click();
	}

	/**
	 * Finds the main navigation menu that is shared by all pages.
	 * 
	 * @return the main navigation menu.
	 */
	public static WebElement findMainNavMenu() {
		return Browser.findElementsByClassName("HeaderMain-nav").get(0);
	}

	/**
	 * Finds a menu link found on the main navigation menu found on every page.
	 * 
	 * @param linkText the name of the main menu link you want to find.
	 * @return the main menu link from main menu.
	 */
	public static WebElement findMainNavMenuLinkByText(final String linkText) {
		return MenuServiceV1.findMainNavMenu().findElement(By.linkText(linkText.toUpperCase())); // findPageMenuName(linkText)
	}

	/**
	 * Finds a main menu - sub menu link by the link text.
	 * 
	 * @param menuLinkText    the main menu link
	 * @param subMenuLinkText the sub menu link
	 * @return the sub menu link.
	 */
	public static WebElement findSubMenuLinkByText(final String menuLinkText, final String subMenuLinkText) {
		return MenuServiceV1.findMainNavMenu().findElement(By.linkText(menuLinkText.toUpperCase()))  
				.findElement(By.xpath("..")).findElement(By.tagName("ul")).findElement(By.linkText(subMenuLinkText));  // findPageMenuName(menuLinkText)
	}

	/**
	 * Hovers the mouse over a main menu link.
	 * 
	 * @param linkText the main menu link to be hovered upon.
	 */
	public static void hoverMainMenuLink(final String linkText) {
		WebElement link = MenuServiceV1.findMainNavMenuLinkByText(linkText);
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
		MenuServiceV1.hoverMainMenuLink(menuPageName);
		MenuServiceV1.clickHeaderLinkByText(menuPageName);
	}

	/**
	 * Navigates to a sub-menu within the main navigation menu.
	 * 
	 * @param menuLinkText    the link in the main menu that contains the sub- menu.
	 * @param subMenuLinkText the name of the sub-menu to be tested.
	 */
	public static void navigateToSubMenu(final String menuLinkText, final String subMenuLinkText) {
		MenuServiceV1.hoverMainMenuLink(menuLinkText);
		findSubMenuLinkByText(menuLinkText, subMenuLinkText).click();
	}

}
