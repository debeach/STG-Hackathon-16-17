package com.stg.danbeach.practice.framework.service.v1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.stg.danbeach.practice.framework.browser.Browser;
import com.stg.danbeach.practice.framework.page.DealsPage;
import com.stg.danbeach.practice.framework.page.ExplorePage;
import com.stg.danbeach.practice.framework.page.LodgingPage;
import com.stg.danbeach.practice.framework.page.PassesPage;
import com.stg.danbeach.practice.framework.page.PlanTripPage;
import com.stg.danbeach.practice.framework.page.SnowPage;
import com.stg.danbeach.practice.framework.page.StoriesPage;

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
	 * Clicks a sub-menu that is found in the main menu link.
	 * 
	 * @param headerLink the main menu link that may contain the sub-menu link.
	 * @param subLink    the sub-menu to be clicked.
	 */
//	public static void clickSubHeaderLinkByText(final String headerLink, final String subLink) {
//		MenuServiceV1.findSubNavMenuLinkByText(headerLink, subLink).click();
//	}
	
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
		return MenuServiceV1.findMainNavMenu().findElement(By.linkText(findPageMenuName(linkText)));
	}
	
	public static WebElement findSubMenuLinkByText(final String menuLinkText, final String subMenuLinkText) {
		return MenuServiceV1.findMainNavMenu()
		.findElement(By.linkText(findPageMenuName(menuLinkText)))
		.findElement(By.xpath("..")).findElement(By.tagName("ul"))
		.findElement(By.linkText(subMenuLinkText));
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
//	public static WebElement findSubNavMenuLinkByText(final String mainMenuLink, final String subMenuText) {
//		System.out.println("sub menu " + subMenuText);
//		WebElement mainLink = MenuServiceV1.findMainNavMenuLinkByText(mainMenuLink);
//		System.out.println("Sub menu text " + mainLink.getText());
//		System.out.println("new name is " + findPageMenuName(subMenuText));
//		WebElement subLink = mainLink.findElement(By.linkText("Lodging"));  // findPageMenuName(subMenuText)
//		System.out.println("Sub menu text 2 " + subLink);
//		return subLink;
//	}
	
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
	 * @param menuLinkText the link in the main menu that contains the sub- menu.
	 * @param subMenuLinkText the name of the sub-menu to be tested.
	 */
	public static void navigateToSubMenu(final String menuLinkText, final String subMenuLinkText) {
//		String linkText = findPageMenuName(menuPageName);
//		MenuService.clickSubHeaderLinkByText(menuPageName, subMenuPageName);
//		System.out.println(subMenuPageName);
		
		MenuServiceV1.hoverMainMenuLink(menuLinkText);
//		System.out.println(MenuServiceV1.findMainNavMenu()
//				.findElement(By.linkText(findPageMenuName(menuLinkText)))
//				.findElement(By.xpath("..")).findElement(By.tagName("ul"))
//				.findElement(By.linkText(subMenuLinkText)).getText());
//		System.out.println(MenuServiceV1.findMainNavMenu()
//				.findElement(By.linkText(findPageMenuName(menuLinkText)))
//				.findElement(By.xpath("..")).findElement(By.tagName("ul"))
//				.findElement(By.linkText(subMenuLinkText)).getTagName());
		findSubMenuLinkByText(menuLinkText, subMenuLinkText).click();
		
//		MenuServiceV1.findMainNavMenu()
//		.findElement(By.linkText(findPageMenuName(menuPageName)))
//		.findElement(By.xpath("..")).findElement(By.tagName("ul"))
//		.findElement(By.linkText(subMenuPageName)).click();
		
//		 MenuService.findMainNavMenu().findElement(By.linkText(findPageMenuName(menuPageName))).click();
//		 MenuService.findMainNavMenu().findElement(By.linkText(findPageMenuName(subMenuPageName))).click();
//		
		 
//		 MenuService.findSubNavMenuByLinkText(menuPageName, subMenuPageName);
//		MenuService.clickSubHeaderLinkByText(menuPageName, subMenuPageName);
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
		case "Lodging" :
			linkText = LodgingPage.pageLinkText;
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
