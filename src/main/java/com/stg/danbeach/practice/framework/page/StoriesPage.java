package com.stg.danbeach.practice.framework.page;

import com.stg.danbeach.practice.framework.browser.Browser;

public class StoriesPage implements iPage {
	
	public static final String pageName = "Stories";
	private static final String title = "Read About the Latest Happenings on the Slopes - Ski Utah";
	private static final String idTitle = "Read About";
	private static final String url = "https://www.skiutah.com/blog";
	
	@Override
	public void goTo() {
		Browser.goTo(url);
	}

	@Override
	public boolean isAt() { 
		return Browser.title().trim().equals(title);
	}

	@Override
	public boolean isIdTitle() { 
		return Browser.title().trim().indexOf(idTitle) > -1;
	}

}
