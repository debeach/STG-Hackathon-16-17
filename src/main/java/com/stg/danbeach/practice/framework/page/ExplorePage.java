package com.stg.danbeach.practice.framework.page;

import com.stg.danbeach.practice.framework.browser.Browser;

public class ExplorePage implements iPage {

	public static final String pageLinkText = "EXPLORE";
	public static final String pageName = "Explore";
	private static final String title = "Utah Ski Areas 101 - Utah Ski Resort Info - Ski Utah";
	private static final String idTitle = "Utah Ski Areas 101";
	private static final String url = "https://www.skiutah.com/explore/utah-regions-101";
	
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
