package com.stg.danbeach.practice.framework.page;

import com.stg.danbeach.practice.framework.browser.Browser;

public class GearStorePage implements iPage {

	public static final String pageName = "Gear Store";
	private static final String title = "Ski Utah Gear Store | Utah Ski Gear | Utah Ski Resorts - Ski Utah";
	private static final String idTitle = "Ski Utah Gear Store";
	private static final String url = "https://www.skiutah.com/gearstore/products";
	
	@Override
	public void goTo() {
		Browser.goTo(url);
	}

	@Override
	public boolean isAt() {
		return Browser.title().equals(title);
	}

	@Override
	public boolean isIdTitle() {
		return Browser.title().indexOf(idTitle) > -1;
	}

}
