package parallel;

import io.cucumber.java.en.*;
import io.cucumber.datatable.DataTable;
import java.util.List;
import java.util.Map;
import org.junit.Assert;
import com.factory.DriverFactory;
import com.pages.AccountsPage;
import com.pages.LoginPage;

public class AccountsPageSteps {
	private AccountsPage accountsPage;
	private LoginPage lp = new LoginPage(DriverFactory.getdriver());

	@Given("user has already logged in to the application")
	public void user_has_already_logged_in_to_the_application(DataTable credTable) {
		DriverFactory.getdriver().
		get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		List<Map<String,String>> list = credTable.asMaps();
		String userName = list.get(0).get("username");
		String password = list.get(0).get("password");
		accountsPage = lp.doLogin(userName, password);
	}

	@Given("user is on Account Page")
	public void user_is_on_the_account_page() {
		accountsPage.getAccountsPageTitle();
	}

	@Then("user gets accounts section")
	public void user_gets_accounts_section(DataTable sectionTable) {
		
		List <String> actualAccountsSectionList = accountsPage.getAccountList();
		System.out.println(actualAccountsSectionList);
		List <String> expectedAccountsSectionList = sectionTable.asList();
		System.out.println(expectedAccountsSectionList);
		Assert.assertTrue(actualAccountsSectionList.containsAll(expectedAccountsSectionList));

	}
	
	@Then("account section count should be {int}")
	public void account_section_count_should_be (int expectedAccountSectionCount) {
		Assert.assertTrue(accountsPage.getAccountCount() == expectedAccountSectionCount);
		System.out.println("Total Count:" + accountsPage.getAccountCount());
	}

}
