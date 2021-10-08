package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	private WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	private By emailId = By.id("email");
	private By password = By.id("passwd");
	private By signIn = By.id("SubmitLogin");
	private By forgotPwdLink = By.linkText("Forgot your password?");

	public void enterUserName(String username) {
		driver.findElement(emailId).sendKeys(username);
	}

	public void enterPassword(String pwd) {
		driver.findElement(password).sendKeys(pwd);
	}

	public void clickLoginBtn() {
		driver.findElement(signIn).click();
	}

	public String getPageTitle() {
		return driver.getTitle();
	}

	public boolean isForgotPwdLinkExist() {
		return driver.findElement(forgotPwdLink).isDisplayed();
	}
	
	public AccountsPage doLogin(String uName, String pass) {
		driver.findElement(emailId).sendKeys(uName);
		driver.findElement(password).sendKeys(pass);
		driver.findElement(signIn).click();
		
		return new AccountsPage(driver);
	}

}
