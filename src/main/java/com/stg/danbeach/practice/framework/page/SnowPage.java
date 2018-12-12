package com.stg.danbeach.practice.framework.page;

import com.stg.danbeach.practice.framework.browser.Browser;

public class SnowPage implements iPage {

	public static final String pageLinkText = "RESORTS & SNOW";
	public static final String pageName = "ResortsSnow";
	private static final String title = "Utah Snow Report - Snow Totals at Utah Ski Resorts Ski Utah";
	private static final String idTitle = "Utah Snow Report";
	private static final String url = "https://www.skiutah.com/snowreport";
	
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
