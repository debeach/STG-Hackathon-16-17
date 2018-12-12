package com.stg.danbeach.practice.framework.page;

import com.stg.danbeach.practice.framework.browser.Browser;

public class HomePage implements iPage {

	public static final String pageName = "HomePage";
	private static final String title = "Ski Utah | Utah Ski Resorts, Lift Tickets, Ski Passes, Maps & More! - Ski Utah";
	private static final String idTitle = "Ski Utah";
	private static final String url = "http://www.skiutah.com";

	public void goTo() {
		Browser.goTo(url);
	}

	public boolean isAt() {
		return title.equals(Browser.title());
	}

	public boolean isIdTitle() {
		return Browser.title().trim().indexOf(idTitle) > -1;
	}

	/**
	 * Will navigate to (click) one of the header (master) links on the skiutah home
	 * page. The parameter is the value stored in the 'pageName' class variable
	 * found on each Page object class.
	 * 
	 * @param menuPageName the name of each page found in the page's 'pageName'
	 *                     class variable.
	 */
	public void navigateToListMenu(final String menuPageName) { 
		System.out.println("HomePage " + menuPageName);
		String linkText = PlanTripPage.pageLinkText;
		switch (menuPageName) {
		case "Deals":
			linkText = DealsPage.pageLinkText;
			break;
		case "Explore":
			linkText = ExplorePage.pageLinkText;
			break;
		case "Passes":
			linkText = PassesPage.pageLinkText;
			break;
		case "PlanTrip":
			linkText = PlanTripPage.pageLinkText;
			break;
		case "ResortsSnow":
			linkText = SnowPage.pageLinkText;
			break;
		case "Stories":
			linkText = StoriesPage.pageLinkText;
			break;
		default:
			linkText = PlanTripPage.pageLinkText;
			break;
		}

		System.out.println("HomePage linkText " + linkText);
		Browser.clickHeaderLinkByText(linkText);
		System.out.println("HomePage linkText after click header");
	}
}
