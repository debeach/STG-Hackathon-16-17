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
import com.stg.danbeach.practice.framework.service.v1.PageServiceV1;

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
		Browser.close();
	}
	///////////////////////////////////////////// 
	
	
	/**
	 * Test if I can get to the Home Page for Ski Utah.
	 */
	@Test
	public void goToHomePage_HP_Test() {
		PageServiceV1.homePage().goTo();
		assertTrue(PageServiceV1.homePage().isAt());
	}

	/**
	 * This test will compare only a portion of the Home Page title. The portion
	 * that is compared is the first "Ski Utah" which should not change.
	 */
	@Test
	public void isAtIdTitle_HP_Test() {
		PageServiceV1.homePage().goTo();
		assertTrue(PageServiceV1.homePage().isIdTitle());
	}

	
}
