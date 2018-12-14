package com.stg.danbeach.practice.framework.service.v1;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.stg.danbeach.practice.framework.browser.Browser;

public class ActivitiesServiceV1 {

	public static List<String> searchActivities(final String activity, final String resort, final String category) {

		// Get selects
		Select whatSelect = new Select(Browser.findElementByName("filter-category-select"));
		Select resortSelect = new Select(Browser.findElementByName("filter-resort-select"));
		Select categorySelect = new Select(Browser.findElementByName("filter-sub-category-select"));

		whatSelect.selectByVisibleText(activity);
		resortSelect.selectByVisibleText(resort);
		categorySelect.selectByVisibleText(category);

		// CLICK/SUBMIT BUTTON
		Browser.findElementByClassName("ListingFilter").findElement(By.name("filter-form-submit")).click();
		
		// GET RESULTS
		List<WebElement> results = Browser.getDriver().findElement(By.id("load-more-items"))
				.findElement(By.className("js-listing-results-view--list"))
				.findElements(By.className("ListingResults-item"));
		System.out.println("num of elements " + results.size());

		List<String> resultList = new ArrayList();
		
		for (WebElement element : results) {
			String title = element.findElement(By.className("ListingItem-title")).findElement(By.tagName("a"))
					.getText();
			resultList.add(title);
			System.out.println(title);
		}
		return resultList;
	}

}
