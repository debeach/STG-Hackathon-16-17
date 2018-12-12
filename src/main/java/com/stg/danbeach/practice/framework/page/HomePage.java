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

	public void goTo() {
		Browser.goTo(url);
	}

	public boolean isAt() {
		return title.equals(Browser.title());
	}

	public boolean isIdTitle() {
		return Browser.title().trim().indexOf(idTitle) > -1;
	}
	////////////////////////////////////////////

	public void navigateToListMenu(final String linkText) {
		MenuService.navigateToListMenu(linkText);
	}
	
	
	
}
