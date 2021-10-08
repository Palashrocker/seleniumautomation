package parallel;

import org.junit.Assert;
import com.factory.DriverFactory;
import com.pages.LoginPage;
import io.cucumber.java.en.*;

public class LoginPageSteps {

	private LoginPage lp = new LoginPage(DriverFactory.getdriver());
	private static String pageTitle;

	@Given("user is on the login page")
	public void user_is_on_the_login_page() {
		DriverFactory.getdriver()
				.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
	}

	@When("user gets the title of the page")
	public void user_gets_the_title_of_the_page() {
		pageTitle = lp.getPageTitle();
		System.out.println("Title of the Page: " + pageTitle);
	}

	@Then("page title should be {string}")
	public void page_title_should_be(String expectedPageTitle) {
		Assert.assertTrue(pageTitle.contains(expectedPageTitle));
	}

	@Then("forgot your password link should be displayed")
	public void forgot_your_password_link_should_be_displayed() {
		Assert.assertTrue(lp.isForgotPwdLinkExist());
	}

	@When("user enters username {string}")
	public void user_enters_username(String username) {
		lp.enterUserName(username);
	}

	@When("user enters password {string}")
	public void user_enters_password(String password) {
		lp.enterPassword(password);
	}

	@When("user clicks on login button")
	public void user_clicks_on_login_button() {
		lp.clickLoginBtn();
	}

}
