package com.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	public WebDriver driver;

	/*
	 * This method is used to initialize the threadLocal driver on the basis of
	 * given browser
	 */
	public static ThreadLocal<WebDriver> tldriver = new ThreadLocal<>();

	public WebDriver init_Driver(String browser) {

		if (browser.equals("Chrome")) {
			WebDriverManager.chromedriver().setup();
			tldriver.set(new ChromeDriver());
		} else if (browser.equals("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			tldriver.set(new FirefoxDriver());
		} else {
			System.out.println("Please specify a correct Browser" + browser);
		}
		getdriver().manage().deleteAllCookies();
		getdriver().manage().window().maximize();
		return getdriver();
	}

	/*
	 * This method is used to get driver with threadLocal
	 */
	public static synchronized WebDriver getdriver() {
		return tldriver.get();
	}
}
