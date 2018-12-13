package com.stg.danbeach.practice.framework.page;

import com.stg.danbeach.practice.framework.browser.Browser;

public class AllDealsPage implements iPage {
	
	public static final String pageName = "All Deals";
	private static final String title = "Utah Ski Trip Deals, Discounts and Packages - Ski Utah";
	private static final String idTitle = "Utah Ski Trip Deals";
	private static final String url = "https://www.skiutah.com/deals-search";
	

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
