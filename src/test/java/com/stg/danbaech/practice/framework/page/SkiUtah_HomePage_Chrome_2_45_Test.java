package com.stg.danbaech.practice.framework.page;

import static org.junit.Assert.assertTrue;

import java.io.File;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.stg.danbeach.practice.framework.browser.Browser;
import com.stg.danbeach.practice.framework.browser.BrowserEnum;
import com.stg.danbeach.practice.framework.page.DealsPage;
import com.stg.danbeach.practice.framework.page.ExplorePage;
import com.stg.danbeach.practice.framework.page.LodgingPage;
import com.stg.danbeach.practice.framework.page.PassesPage;
import com.stg.danbeach.practice.framework.page.PlanTripPage;
import com.stg.danbeach.practice.framework.page.SnowPage;
import com.stg.danbeach.practice.framework.page.StoriesPage;
import com.stg.danbeach.practice.framework.service.PageService;

public class SkiUtah_HomePage_Chrome_2_45_Test {

	@BeforeClass
	public static void setupTests() {

		// Setup WebDriver
		File relativePath = new File(BrowserEnum.CHROME_2_45.getLocation());
		String absolutePath = relativePath.getAbsolutePath();
		System.setProperty(BrowserEnum.CHROME_2_45.getDriver(), absolutePath);

		// Set WebDriver for test.
		Browser.setBrowser(BrowserEnum.CHROME_2_45.getName());
	}

	@AfterClass
	public static void tearDownTests() {
//		Browser.close();
	}
	///////////////////////////////////////////// 
	
	
	/**
	 * Test if I can get to the Home Page for Ski Utah.
	 */
	@Ignore
	@Test
	public void goToHomePage_Test() {
		PageService.homePage().goTo();
		assertTrue(PageService.homePage().isAt());
	}

	/**
	 * This test will compare only a portion of the Home Page title. The portion
	 * that is compared is the first "Ski Utah" which should not change.
	 */
	@Ignore
	@Test
	public void isAtIdTitle_Test() {
		PageService.homePage().goTo();
		assertTrue(PageService.homePage().isIdTitle());
	}

	@Ignore
	@Test
	public void navigateTo_Deals_Test() {
		PageService.homePage().goTo();

		PageService.homePage().navigateToListMenu(DealsPage.pageName);
//		assertTrue(PageService.dealsPage().isIdTitle());
		assertTrue(PageService.dealsPage().isAt());
	}

	@Ignore
	@Test
	public void navigateTo_Explore_Test() {
		PageService.homePage().goTo();

		PageService.homePage().navigateToListMenu(ExplorePage.pageName);
		assertTrue(PageService.explorePage().isAt());
	}

	@Ignore
	@Test
	public void navigateTo_Passes_Test() {
		PageService.homePage().goTo();

		PageService.homePage().navigateToListMenu(PassesPage.pageName);
		assertTrue(PageService.passesPage().isAt());
	}

	@Ignore
	@Test
	public void navigateTo_PlanYourTrip_Test() {
		PageService.homePage().goTo();

		PageService.homePage().navigateToListMenu(PlanTripPage.pageName);
//		assertTrue(PageService.planTripPage().isAt());
		assertTrue(PageService.planTripPage().isIdTitle());
	}
	
	@Test
	public void navigateTo_PlanYourTrip_Lodging_Test() {
		PageService.homePage().goTo();
		PageService.homePage().navigateToSubMenu(PlanTripPage.pageName, LodgingPage.pageName);
	}

	// TODO: CURRENTLY BROKEN
	@Ignore
	@Test
	public void navigateTo_ResortAndSnow_Test() {
		PageService.homePage().goTo();

		PageService.homePage().navigateToListMenu(SnowPage.pageName);
//		assertTrue(PageService.snowPage().isIdTitle());
		assertTrue(PageService.snowPage().isAt());
	}

	// TODO: Broken. It works until it calls the assert. It is not able to find the
	// StoriesPage in the PageService.
	@Ignore
	@Test
	public void navigateTo_Stories_Test() {
		PageService.homePage().goTo();

		PageService.homePage().navigateToListMenu(StoriesPage.pageName);
		System.out.println("I am in stories test");
//		assertTrue(PageService.storiesPage().isIdTitle());
		assertTrue(PageService.storiesPage().isAt());
	}
}
