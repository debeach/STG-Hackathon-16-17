package com.stg.danbeach.practice.framework.page;

import java.util.List;

import com.stg.danbeach.practice.framework.browser.Browser;

public class ActivitiesPage implements iPage {

	public static final String pageName = "Activities";
	
	private static final String activitySelect = "Transportation";
	private static final String categorySelect = "Group Shuttles";
	private static final String idTitle = "Utah Activities";
	private static final Integer numberOfResults = new Integer(5);
	private static final String resortSelect = "Brighton";
	private static final String title = "Utah Activities and Things to Do Near Utah Ski Areas - Ski Utah";
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
	/////////////////////////////////////////////
	
	
	public static String getActivityselect() {
		return activitySelect;
	}

	public static String getCategoryselect() {
		return categorySelect;
	}

//	public static Integer getNumberofresults() {
//		return numberOfResults;
//	}

	public static String getResortselect() {
		return resortSelect;
	}
	/////////////////////////////////////////////
	
	// TODO: MAKE THIS MORE VERSITILE SO IT CAN HANDLE DIFFERENT SEARCHES.
	// MAYBE PASS IN THE SEARCH PARAMETERS AND THE RESULTS AND COMPARE THEM.
	// NEED THIS FOR PARAMETERIZED SEARCHES.
	/**
	 * Validates searchForActivities_HappyPath_Test()t has found the proper results.
	 * It will search Brighton has 5 choices for Transportation of Group Shuttles. 
	 * @param results the results of the search done in the ActivitiesServiceV1.
	 * @return true if the number of results is 5
	 */
	public Boolean isSearch(List<String> results) {
		// TODO: ADD CHECKING INDIVIDUAL TITLE HERE LATER
		return results.size() == this.numberOfResults.intValue();
	}
	
	
}
