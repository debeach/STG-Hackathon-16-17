package com.stg.danbeach.practice.framework.service.v1;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

import com.stg.danbeach.practice.framework.browser.Browser;

public class UtilServiceV1 {

	private static HashSet<String> visitedUrl = new HashSet<>(); // links visited on previous pages
	private static HashSet<String> anchorSet = new HashSet<>(); // links visited on current page.
	private static int index = 0;
	private static int pageNumber = 0;
	private static Thread thread = new Thread();

	static LocalTime start;

	public static void crawl(final String baseUrl) {
		String url = "";
		start = LocalTime.now();
		try {

			System.out.println(++index + ": visiting " + baseUrl);

			// is baseUrl good?
			if (StringUtils.isBlank(baseUrl) || (!(UtilServiceV1.isSkiUtah(baseUrl)))) {
				System.out.println("base URL provided is not part of skiutah.com");
				throw new Exception("base URL provided is not part of skiutah.com " + baseUrl);
			}

			// visit home page
			UtilServiceV1.goTo(baseUrl);

			UtilServiceV1.parseUrlList(UtilServiceV1.findUrls());

			Iterator<String> iterator = anchorSet.iterator();

			while (anchorSet.iterator().hasNext()) {
				url = anchorSet.iterator().next();
				System.out.println((++index) + " visiting " + url);
				UtilServiceV1.processPage(url);
				visitedUrl.add(url);
				anchorSet.remove(url);
			}
		} catch (StaleElementReferenceException e) {
			System.out.println("EXCEPTION ON " + url);
			e.printStackTrace();
			Browser.close();
		} catch (Exception e) {
			System.out.println("EXCEPTION ON " + url);
			e.printStackTrace();
			Browser.close();
		} finally {
			LocalTime stop = LocalTime.now();
			DateTimeFormatter formatter = DateTimeFormatter.ISO_TIME;
			System.out.println("Run time is " + start.until(stop, ChronoUnit.MINUTES) + " minutes-ish");

		}

	}

	private static void processPage(final String url) {
		UtilServiceV1.goTo(url);
		List<WebElement> urls = UtilServiceV1.findUrls();
		System.out.println("new links " + urls.size() + " links");
		UtilServiceV1.parseUrlList(urls);
		anchorSet.remove(url);
		visitedUrl.add(url);

//		System.out.println("Visited " + visitedUrl.size() + " links");
		System.out.println("Anchors " + anchorSet.size() + " links");
	}

	private static List<WebElement> findUrls() {
		return Browser.getDriver().findElements(By.tagName("a"));
	}

	private static void goTo(final String url) {
		Browser.getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Browser.getDriver().get(url);
	}

	private static Boolean isSkiUtah(final String url) {
		if (StringUtils.isBlank(url) || url.contains("@@gotourl")) {
			return Boolean.FALSE;
		}
//		Pattern pattern = Pattern.compile("^.*?\\/+([^:\\/\\s]+)");
//		Matcher matcher = pattern.matcher(url);
//
//		while (matcher.find()) {
//			if (matcher.group(1).equals("www.skiutah.com")) {
//				return Boolean.TRUE;
//			}
//		}
		if (url.contains("https://www.skiutah.com")) {
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}

	private static void parseUrlList(List<WebElement> urlList) {
		if (urlList == null || urlList.isEmpty()) {
			return;
		}

//		HashSet<String> anchorCopy = new HashSet<>(anchorSet);

		for (WebElement element : urlList) {
			if (element == null || StringUtils.isBlank(element.getAttribute("href"))) {
				anchorSet.remove(element.getAttribute("href"));
//				urlList.remove(element.getAttribute("href"));
//				continue;
			} else if (element.getTagName().equalsIgnoreCase("link") 
					|| element.getTagName().equalsIgnoreCase("script")
					|| element.getTagName().equalsIgnoreCase("base")) {
				anchorSet.remove(element.getAttribute("href"));
			} else if (visitedUrl.contains(element.getAttribute("href"))) {
				anchorSet.remove(element.getAttribute("href"));
//				urlList.remove(element);
			} else if (UtilServiceV1.isSkiUtah(element.getAttribute("href"))) {
				anchorSet.add(element.getAttribute("href"));
//				urlList.add(element.getAttribute("href"));
			} else {
				anchorSet.remove(element.getAttribute("href"));
			}
		}

//		anchorSet = anchorCopy;
	}

}
