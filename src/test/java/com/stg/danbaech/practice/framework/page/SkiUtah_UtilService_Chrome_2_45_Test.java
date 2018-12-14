package com.stg.danbaech.practice.framework.page;

import java.io.File;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.stg.danbeach.practice.framework.browser.Browser;
import com.stg.danbeach.practice.framework.browser.BrowserEnum;
import com.stg.danbeach.practice.framework.service.v1.UtilServiceV1;

public class SkiUtah_UtilService_Chrome_2_45_Test {

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
	public void crawl_HP_Test() throws InterruptedException {
		String baseUrl = "https://www.skiutah.com/";

		UtilServiceV1.crawl(baseUrl);
	}

}
