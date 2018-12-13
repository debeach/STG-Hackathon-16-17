package com.stg.danbaech.practice.framework.page;

import static org.junit.Assert.assertTrue;

import java.io.File;

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
import com.stg.danbeach.practice.framework.service.v1.PageServiceV1;

public class SkiUtah_MainMenu_Chrome_2_45_Test {

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
		Browser.close();
	}
	/////////////////////////////////////////////////////////////////////////////////////
	
	
	///////////////////////////////////////////// TEST DEALS MAIN MENU LINK
//	@Ignore
	@Test
	public void navigateTo_Deals_HP_Test() {
		PageServiceV1.homePage().goTo();

		PageServiceV1.homePage().navigateToListMenu(DealsPage.pageName);
//		assertTrue(PageService.dealsPage().isIdTitle());
		assertTrue(PageServiceV1.dealsPage().isAt());
	}
	
	
	/////////////////////////////////////////////  TEST EXPLORE MAIN MENU LINK

//	@Ignore
	@Test
	public void navigateTo_Explore_HP_Test() {
		PageServiceV1.homePage().goTo();

		PageServiceV1.homePage().navigateToListMenu(ExplorePage.pageName);
		assertTrue(PageServiceV1.explorePage().isAt());
	}

	
	/////////////////////////////////////////////  TEST PASSES MAIN MENU LINK
//	@Ignore
	@Test
	public void navigateTo_Passes_HP_Test() {
		PageServiceV1.homePage().goTo();

		PageServiceV1.homePage().navigateToListMenu(PassesPage.pageName);
		assertTrue(PageServiceV1.passesPage().isAt());
	}

	/////////////////////////////////////////////  TEST PLAN YOUR TRIP MAIN MENU LINK
//	@Ignore
	@Test
	public void navigateTo_PlanYourTrip_HP_Test() {
		PageServiceV1.homePage().goTo();

		PageServiceV1.homePage().navigateToListMenu(PlanTripPage.pageName);
//		assertTrue(PageService.planTripPage().isAt());
		assertTrue(PageServiceV1.planTripPage().isIdTitle());
	}
	
	
	///////////////////////////////////  TEST PLAN YOUR TRIP -> LODGING SUB MENU LINK
	@Test
	public void navigateTo_PlanYourTrip_Lodging_HP_Test() {
		PageServiceV1.homePage().goTo();
		PageServiceV1.homePage().navigateToSubMenu(PlanTripPage.pageName, LodgingPage.pageName);
		assertTrue(PageServiceV1.lodgingPage().isAt());
	}

	
	/////////////////////////////////////////////  TEST RESORT AND SNOW MAIN MENU LINK
	// TODO: CURRENTLY BROKEN
//	@Ignore
	@Test
	public void navigateTo_ResortAndSnow_HP_Test() {
		PageServiceV1.homePage().goTo();

		PageServiceV1.homePage().navigateToListMenu(SnowPage.pageName);
//		assertTrue(PageService.snowPage().isIdTitle());
		assertTrue(PageServiceV1.snowPage().isAt());
	}

	
	/////////////////////////////////////////////  TEST STORIES MAIN MENU LINK
	// TODO: Broken. It works until it calls the assert. It is not able to find the
	// StoriesPage in the PageService.
//	@Ignore
	@Test
	public void navigateTo_Stories_HP_Test() {
		PageServiceV1.homePage().goTo();

		PageServiceV1.homePage().navigateToListMenu(StoriesPage.pageName);
		System.out.println("I am in stories test");
//		assertTrue(PageService.storiesPage().isIdTitle());
		assertTrue(PageServiceV1.storiesPage().isAt());
	}
}
