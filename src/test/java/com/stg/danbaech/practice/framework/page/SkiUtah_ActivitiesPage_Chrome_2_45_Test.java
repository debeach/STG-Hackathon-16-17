package com.stg.danbaech.practice.framework.page;

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
//		Browser.close();
	}
	///////////////////////////////////////////// 
	
	@Test
	public void searchForActivities_HappyPath_Test() {
		// go to home page
		PageServiceV1.activitiesPage().goTo();
		
		// set selector What
		String what = "Transportation";
		String resort = "Brighton";
		String category = "Entertainment";
		
//		List<WebElement> select =  Browser.getDriver().findElements(By.tagName("select")));
		Select whatSelect = new Select(Browser.getDriver().findElement(By.name("filter-category-select")));
		whatSelect.selectByVisibleText(what);
		System.out.println(whatSelect.getFirstSelectedOption().toString());
		Select resortSelect = new Select(Browser.getDriver().findElement(By.name("filter-resort-select")));
		resortSelect.selectByVisibleText(resort);
		Select categorySelect = new Select(Browser.getDriver().findElement(By.name("filter-sub-category-select")));
		categorySelect.selectByVisibleText(category);
	}
}
