package com.stg.danbeach.practice.framework.page;

import com.stg.danbeach.practice.framework.browser.Browser;

public class StoriesPage implements iPage {
	
	public static final String pageLinkText = "STORIES";
	public static final String pageName = "Stories";
	private static final String title = "Read About the Latest Happenings on the Slopes - Ski Utah";
	private static final String idTitle = "Ski Utah"; //"Read About the Latest";
	private static final String url = "https://www.skiutah.com/blog";
	
	@Override
	public void goTo() {
		Browser.goTo(url);
	}

	@Override
	public boolean isAt() { 
		System.out.println("StoriesPage title isAt() " + Browser.title());
		return Browser.title().trim().equals(title);
	}

	@Override
	public boolean isIdTitle() { 
		System.out.println("StoriesPage title isIdTitle() " + Browser.title());
		return Browser.title().indexOf(idTitle) > -1;
	}

}
