package com.stg.danbeach.practice.framework.page;

public interface iPage {
	
	/**
	 * Navigates to the page objects page.
	 */
	public void goTo();

	/**
	 * Validates the full title for a page is correct.
	 * 
	 * @return true if the page's title matches the page object's supplied full
	 *         title.
	 */
	public boolean isAt();

	/**
	 * Validates a partial (likely unchnaging) portion of the page's title.
	 * 
	 * @return true if the page's title contains the page object's supplied partial
	 *         title.
	 */
	public boolean isIdTitle();
}
