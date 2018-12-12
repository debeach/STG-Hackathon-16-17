package com.stg.danbeach.practice.framework.page;

import com.stg.danbeach.practice.framework.browser.Browser;

public class PlanTripPage implements iPage {

	public static final String pageLinkText = "PLAN YOUR TRIP";
	public static final String pageName = "PlanTrip";
	private static final String title = "Utah Ski Trip Planner - Resorts, Lodging & Activities Ski Utah";
	private static final String idTitle = "Utah Ski Trip Planner";
	private static final String url = "https://www.skiutah.com/trip-planner";
	
	public void goTo() {
		Browser.goTo(url);
	}

	public boolean isAt() {
		return title.equals(Browser.title());
	}
	
	public boolean isIdTitle() {
		return Browser.title().indexOf(idTitle) > -1;
	}

}
