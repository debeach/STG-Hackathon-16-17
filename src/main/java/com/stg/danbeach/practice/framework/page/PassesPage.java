package com.stg.danbeach.practice.framework.page;

import com.stg.danbeach.practice.framework.browser.Browser;

public class PassesPage implements iPage {

	public static final String pageLinkText = "PASSES";
	public static final String pageName = "Passes";
	private static final String title = "2018 - 2019 Utah Ski Resorts Season Passes - Ski Utah";
	private static final String idTitle = "Utah Ski Resorts Season Passes";
	private static final String url = "https://www.skiutah.com/resort-season-passes";
	
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
