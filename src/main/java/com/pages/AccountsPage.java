package com.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountsPage {

	private WebDriver driver;

	public AccountsPage(WebDriver driver) {
		this.driver = driver;
	}

	private By accountSection = By.xpath("//div[@class='row addresses-lists']//span");

	public int getAccountCount() {
		return driver.findElements(accountSection).size();
	}

	public String getAccountsPageTitle() {
		return driver.getTitle();
	}

	public List<String> getAccountList() {

		List<String> list = new ArrayList<>();
		List<WebElement> accountList = driver.findElements(accountSection);

		for (WebElement e : accountList) {
			String text = e.getText().trim();
			list.add(text);
		}
		return list;
	}

}
