package com.cucumber.framework.helpers;
import org.openqa.selenium.WebDriver;

public class LocalDriverManager {

	/** The web driver. */
	private static ThreadLocal<WebDriver> webDriver = new ThreadLocal<WebDriver>();

	/**
	 * Gets the driver.
	 *
	 * @return the driver
	 */
	public static WebDriver getDriver() {
		return webDriver.get();
	}

	/**
	 * Sets the web driver.
	 *
	 * @param driver
	 *            the new web driver
	 */
	static void setWebDriver(WebDriver driver) {
		System.out.println("Setting Driver");
		webDriver.set(driver);
	}
} 
		 

