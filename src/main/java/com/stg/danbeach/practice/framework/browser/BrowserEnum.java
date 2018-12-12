package com.stg.danbeach.practice.framework.browser;

public enum BrowserEnum {
	
	CHROME_2_45("Chrome", "webdriver.chrome.driver", "resources\\webdrivers\\chrome\\2.45\\chromedriver.exe");
	
	private String driver;
	private String location;
	private String name;
	
	private BrowserEnum(final String name, final String driver, final String location) {
		this.driver = driver;
		this.location = location;
		this.name = name;
	}

	public String getDriver() {
		return driver;
	}

	public String getLocation() {
		return location;
	}

	public String getName() {
		return name;
	}
	
	
}
