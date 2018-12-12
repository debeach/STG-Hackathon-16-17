package com.stg.danbeach.practice.framework.service;

import com.stg.danbeach.practice.framework.page.DealsPage;
import com.stg.danbeach.practice.framework.page.ExplorePage;
import com.stg.danbeach.practice.framework.page.HomePage;
import com.stg.danbeach.practice.framework.page.PassesPage;
import com.stg.danbeach.practice.framework.page.PlanTripPage;
import com.stg.danbeach.practice.framework.page.SnowPage;
import com.stg.danbeach.practice.framework.page.StoriesPage;

public class PageService {

	public static DealsPage dealsPage() {
		return new DealsPage();
	}
	
	public static ExplorePage explorePage() {
		return new ExplorePage();
	}
	
	public static HomePage homePage() {
		return new HomePage();
	}
	
	public static PassesPage passesPage() {
		return new PassesPage();
	}

	public static PlanTripPage planTripPage() {
		return new PlanTripPage();
	}

	public static SnowPage snowPage() {
		return new SnowPage();
	}

	public static StoriesPage storiesPage() {
		System.out.println("I AM IN stories SERVICE");
		return new StoriesPage();
	}
}
