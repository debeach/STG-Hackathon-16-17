package com.stg.danbeach.practice.framework.page;

import com.stg.danbeach.practice.framework.browser.Browser;

public class LodgingPage implements iPage {

	public static final String pageName = "Lodging";
	private static final String title = "Lodging and Accommodations Near Utah Ski Resorts - Ski Utah";
	private static final String idTitle = "Lodging and Accommodations";
	private static final String url = "https://www.skiutah.com/members/listing/type/lodging";
	
	
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
