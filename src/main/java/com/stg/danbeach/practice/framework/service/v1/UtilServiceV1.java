package com.stg.danbeach.practice.framework.service.v1;

import java.util.HashSet;
import java.util.List;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

import com.stg.danbeach.practice.framework.browser.Browser;

public class UtilServiceV1 {

	private static HashSet<String> visitedUrl = new HashSet<>();
	private static int index = 0;
	private static int pageNumber = 0;
	private static Thread thread = new Thread();

	public static void crawl(final String baseUrl) throws InterruptedException {
		String url = "";

		try {
			System.out.println(++index + ": " + baseUrl);

			if (visitedUrl.contains(baseUrl)) {
				return;
			}

			Browser.getDriver().get(baseUrl);
			Browser.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			String goodBaseUrl = UtilServiceV1.isSkiUtah(baseUrl);
			if (goodBaseUrl != null) {
				visitedUrl.add(baseUrl);
			}

			List<WebElement> anchorList = Browser.getDriver().findElements(By.tagName("a"));
			HashSet<WebElement> anchorSet = new HashSet<>(); // used to eliminate duplicates.
			
			// Parse any urls that are not part of the base url's domain or any urls already visited.
			for (WebElement element : anchorList) {
				if(element.getAttribute("href") == null || visitedUrl.contains(element.getAttribute("href"))){
					continue;
				}
				String goodUrl = UtilServiceV1.isSkiUtah(element.getAttribute("href"));
				// only if the url is part of the base url.
				if(goodUrl != null) {
					anchorSet.add(element);
				}
			}

			// Get all anchors on this page
//			for (WebElement element : anchorSet) {
//				Pattern pattern = Pattern.compile("^.*?\\/+([^:\\/\\s]+)");
//				Matcher matcher = pattern.matcher(element.getAttribute("href"));
//				
//				while (matcher.find()) {
//					if (!(matcher.group(1).equals("www.skiutah.com"))) {
//						System.out.println("NOT IN THE GAME " + url);
//						thread.wait(300);
//						continue;
//					}
//
//					url = element.getAttribute("href");
//					if (!(visitedUrl.contains(url))) {
//						visitedUrl.add(element.getAttribute("href"));
//						System.out.println("\t\tPAGE NUMBER: " + (++pageNumber));
//						UtilServiceV1.crawl(url);
//					}
//				}
//			}

			System.out.println("All anchors are " + anchorList.size());
			System.out.println("Visited Url has " + visitedUrl.size());
			System.out.println("Anchor Set has " + anchorSet.size());
		} catch (StaleElementReferenceException e) {
			System.out.println("EXCEPTION ON " + url);
			e.printStackTrace();
			Browser.close();
		}
//		for (String href : visitedUrl) {
//			System.out.println(++index + ": " + href);
//		}

//		System.out.println("list has " + anchorList.size() + " elements");
//		System.out.println("anchor set is " + anchorSet.size());
//		System.out.println("Set has " + visitedUrl.size());
//		
//		System.out.println();
//		System.out.println();
	}

	private static String isSkiUtah(final String url) {
		Pattern pattern = Pattern.compile("^.*?\\/+([^:\\/\\s]+)");
		Matcher matcher = pattern.matcher(url);

		while (matcher.find()) {
			if (matcher.group(1).equals("www.skiutah.com")) {
				System.out.println(url);
				return url;
//				thread.wait(300);
//				continue;
			}

//			url = element.getAttribute("href");

		}
		return null;
	}

	public void trash(String baseUrl) {
		String url = "";
		try {
			System.out.println(++index + ": " + baseUrl);

			Browser.getDriver().get(baseUrl);
			Browser.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			List<WebElement> anchorList = Browser.getDriver().findElements(By.tagName("a"));
			HashSet<WebElement> anchorSet = new HashSet<>(anchorList); // eliminate duplicates.

			// Get all anchors on this page
			for (WebElement element : anchorSet) {
				Pattern pattern = Pattern.compile("^.*?\\/+([^:\\/\\s]+)");
				Matcher matcher = pattern.matcher(element.getAttribute("href"));

				while (matcher.find()) {
					if (!(matcher.group(1).equals("www.skiutah.com"))) {
						System.out.println("NOT IN THE GAME " + url);
//						thread.wait(300);
						continue;
					}

					url = element.getAttribute("href");
					if (!(visitedUrl.contains(url))) {
						visitedUrl.add(element.getAttribute("href"));
						System.out.println("\t\tPAGE NUMBER: " + (++pageNumber));
//						UtilServiceV1.crawl(url);
					}
				}
			}
		} catch (StaleElementReferenceException e) {
			System.out.println("EXCEPTION ON " + url);
			e.printStackTrace();
			Browser.close();
		}
//		for (String href : visitedUrl) {
//			System.out.println(++index + ": " + href);
//		}

//		System.out.println("list has " + anchorList.size() + " elements");
//		System.out.println("anchor set is " + anchorSet.size());
//		System.out.println("Set has " + visitedUrl.size());
//		
//		System.out.println();
//		System.out.println();
	}
}
