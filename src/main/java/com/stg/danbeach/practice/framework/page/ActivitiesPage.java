package com.stg.danbeach.practice.framework.page;

import com.stg.danbeach.practice.framework.browser.Browser;

public class ActivitiesPage implements iPage {

	public static final String pageName = "Activities";
	private static final String title = "Utah Activities and Things to Do Near Utah Ski Areas - Ski Utah";
	private static final String idTitle = "Utah Activities";
	private static final String url = "https://www.skiutah.com/members/listing/type/Activities";
	
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
