package com.stg.danbaech.practice.framework.page;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.stg.danbeach.practice.framework.browser.Browser;
import com.stg.danbeach.practice.framework.browser.BrowserEnum;
import com.stg.danbeach.practice.framework.page.ActivitiesPage;
import com.stg.danbeach.practice.framework.service.v1.ActivitiesServiceV1;
import com.stg.danbeach.practice.framework.service.v1.PageServiceV1;

public class SkiUtah_ActivitiesPage_Chrome_2_45_Test {

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

	@Test
	public void searchForActivities_HappyPath_Test() {
		// go to Activities page
		PageServiceV1.activitiesPage().goTo();
		
		List<String> results = ActivitiesServiceV1.searchActivities(
				ActivitiesPage.getActivityselect()
				, ActivitiesPage.getResortselect()
				, ActivitiesPage.getCategoryselect());
		
		assertTrue(PageServiceV1.activitiesPage().isSearch(results));
	}
}
