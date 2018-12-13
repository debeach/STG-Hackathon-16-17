package com.stg.danbeach.practice.framework.page;

import com.stg.danbeach.practice.framework.browser.Browser;

public class AltaPage implements iPage {

	public static final String pageName = "Alta";
	public static final String resortName = "Alta";
	private static final String title = "Alta Ski Resort - Map, Weather & Information - Ski Utah";
	private static final String idTitle = "Alta Ski Resort";
	private static final String url = "https://www.skiutah.com/members/alta?_ct=Menu+Bar";
	
	
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
