package com.stg.danbeach.practice.framework.page;

import com.stg.danbeach.practice.framework.browser.Browser;

public class GradePassportPage implements iPage {

	public static final String pageName = "5th & 6th Grade Passport";
	private static final String title = "5th & 6th Grade Ski Passport - Utah Lift Tickets - Ski Utah";
	private static final String idTitle = "5th & 6th Grade Ski Passport";
	private static final String url = "https://www.skiutah.com/passes/passports";
	
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
