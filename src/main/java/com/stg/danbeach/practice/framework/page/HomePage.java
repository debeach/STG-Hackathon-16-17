package com.stg.danbeach.practice.framework.page;

import java.awt.AWTException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.stg.danbeach.practice.framework.browser.Browser;
import com.stg.danbeach.practice.framework.service.v1.HomePageServiceV1;
import com.stg.danbeach.practice.framework.service.v1.MenuServiceV1;

public class HomePage implements iPage {

	public static final String pageName = "HomePage";
	public static final String homePageLogoClassName = "HeaderMain-logo";
	private static final String title = "Ski Utah | Utah Ski Resorts, Lift Tickets, Ski Passes, Maps & More! - Ski Utah";
	private static final String idTitle = "Ski Utah";
	private static final String url = "http://www.skiutah.com";

	@Override
	public void goTo() {
		Browser.goTo(url);
	}

	@Override
	public boolean isAt() {
		return title.equals(Browser.title());
	}

	@Override
	public boolean isIdTitle() {
		return Browser.title().trim().indexOf(idTitle) > -1;
	}
	////////////////////////////////////////////

	public void navigateToCompareResorts() {
		try {
			HomePageServiceV1.navigateToCompareResorts();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Navigates to the homepage link that is represented by the Ski Utah logo.
	 */
	public void navigateToHomePage() {
		HomePageServiceV1.navigateToHomePage();
	}

	/**
	 * Navigates to a link in the main menu from the home page.
	 * 
	 * @param linkText the main menu link to be clicked.
	 */
	public void navigateToListMenu(final String linkText) {
		MenuServiceV1.navigateToListMenu(linkText);
	}
	
	public void navigateToMilesToAirport() {
		try {
			HomePageServiceV1.navigateToMilesToAirport();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Navigates to a sub link in a main menu link.
	 * 
	 * @param mainMenuLink the main menu that may contain the associated sub-link.
	 * @param subMenuLink  the sub-link that is associated with the main link.
	 */
	public void navigateToSubMenu(final String mainMenuLink, final String subMenuLink) {
		MenuServiceV1.navigateToSubMenu(mainMenuLink, subMenuLink);
	}

}
