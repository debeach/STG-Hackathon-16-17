package com.stg.danbaech.practice.framework.page;

import static org.junit.Assert.assertTrue;

import java.io.File;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.stg.danbeach.practice.framework.browser.Browser;
import com.stg.danbeach.practice.framework.browser.BrowserEnum;
import com.stg.danbeach.practice.framework.page.AllDealsPage;
import com.stg.danbeach.practice.framework.page.AltaPage;
import com.stg.danbeach.practice.framework.page.DealsPage;
import com.stg.danbeach.practice.framework.page.ExplorePage;
import com.stg.danbeach.practice.framework.page.GearStorePage;
import com.stg.danbeach.practice.framework.page.GradePassportPage;
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
		assertTrue(PageServiceV1.dealsPage().isAt());
	}
	
	
	//////////////////////////////////////////////  TEST DEALS -> ALL DEALS SUB MENU LINK
	@Test
	public void navigateTo_Deals_AllDeals_HP_Test() {
		PageServiceV1.homePage().goTo();
		
		PageServiceV1.homePage().navigateToSubMenu(DealsPage.pageName, AllDealsPage.pageName);
		assertTrue(PageServiceV1.allDealsPage().isAt());
	}
	
	
	/////////////////////////////////////////////  TEST EXPLORE MAIN MENU LINK

//	@Ignore
	@Test
	public void navigateTo_Explore_HP_Test() {
		PageServiceV1.homePage().goTo();

		PageServiceV1.homePage().navigateToListMenu(ExplorePage.pageName);
		assertTrue(PageServiceV1.explorePage().isAt());
	}

	///////////////////////////////////////////  TEST EXPLORE -> GEAR STORE SUB MENU LINK
	@Test
	public void navigateTo_Explore_GearStore_HP_Test() {
		PageServiceV1.homePage().goTo();
		
		PageServiceV1.homePage().navigateToSubMenu(ExplorePage.pageName, GearStorePage.pageName);
		assertTrue(PageServiceV1.gearStorePage().isAt());
	}
	
	/////////////////////////////////////////////  TEST PASSES MAIN MENU LINK
//	@Ignore
	@Test
	public void navigateTo_Passes_HP_Test() {
		PageServiceV1.homePage().goTo();

		PageServiceV1.homePage().navigateToListMenu(PassesPage.pageName);
		assertTrue(PageServiceV1.passesPage().isAt());
	}
	
	
	//////////////////////////////////////////////////  TEST PASSES -> GRADE PASSPORT SUB MENU LINK
	@Test
	public void navigateTo_Passes_GradePassport_HP_Test() {
		PageServiceV1.homePage().goTo();
		
		PageServiceV1.homePage().navigateToSubMenu(PassesPage.pageName, GradePassportPage.pageName);
		assertTrue(PageServiceV1.gradePassportPage().isAt());
	}

	/////////////////////////////////////////////  TEST PLAN YOUR TRIP MAIN MENU LINK
//	@Ignore
	@Test
	public void navigateTo_PlanYourTrip_HP_Test() {
		PageServiceV1.homePage().goTo();

		PageServiceV1.homePage().navigateToListMenu(PlanTripPage.pageName);
		assertTrue(PageServiceV1.planTripPage().isIdTitle());
	}
	
	
	///////////////////////////////////  TEST PLAN YOUR TRIP -> LODGING SUB MENU LINK
//	@Ignore
	@Test
	public void navigateTo_PlanYourTrip_Lodging_HP_Test() {
		PageServiceV1.homePage().goTo();
		
		PageServiceV1.homePage().navigateToSubMenu(PlanTripPage.pageName, LodgingPage.pageName);
		assertTrue(PageServiceV1.lodgingPage().isAt());
	}

	
	/////////////////////////////////////////////  TEST RESORT AND SNOW MAIN MENU LINK
//	@Ignore
	@Test
	public void navigateTo_ResortAndSnow_HP_Test() {
		PageServiceV1.homePage().goTo();

		PageServiceV1.homePage().navigateToListMenu(SnowPage.pageName);
		assertTrue(PageServiceV1.snowPage().isAt());
	}
	
	
	/////////////////////////////////////////  TEST RESORT AND SNOW -> ALTA SUB MENU LINK
	@Test
	public void navigateTo_ResortAndSnow_Alta_HP_Test() {
		PageServiceV1.homePage().goTo();
		PageServiceV1.homePage().navigateToSubMenu(SnowPage.pageName, AltaPage.pageName);
		
		assertTrue(PageServiceV1.altaPage().isAt());
	}

	
	/////////////////////////////////////////////  TEST STORIES MAIN MENU LINK
//	@Ignore
	@Test
	public void navigateTo_Stories_HP_Test() {
		PageServiceV1.homePage().goTo();

		PageServiceV1.homePage().navigateToListMenu(StoriesPage.pageName);
		assertTrue(PageServiceV1.storiesPage().isAt());
	}
}
