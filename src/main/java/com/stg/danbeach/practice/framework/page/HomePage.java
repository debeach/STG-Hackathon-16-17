package com.stg.danbeach.practice.framework.page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.stg.danbeach.practice.framework.browser.Browser;
import com.stg.danbeach.practice.framework.service.MenuService;

public class HomePage implements iPage {

	public static final String pageName = "HomePage";
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

	/**
	 * Navigates to a link in the main menu from the home page.
	 * 
	 * @param linkText the main menu link to be clicked.
	 */
	public void navigateToListMenu(final String linkText) {
		MenuService.navigateToListMenu(linkText);
	}
	
	public  void navigateToSubMenu(final String mainMenuLink, final String subMenuLink) {
		MenuService.navigateToSubMenu(mainMenuLink, subMenuLink);
	}

}
