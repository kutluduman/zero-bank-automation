package step_Definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.modules.Login;
import utilities.Browser_Utils;
import utilities.ConfigurationReader;
import utilities.Driver;

public class LoginStepDefinitions {

    Login login = new Login();

    @Given("user in the login page")
    public void user_in_the_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        Browser_Utils.waitForPageToLoad(10);
    }

    @When("users logs in with valid credentials")
    public void users_logs_in_with_valid_credentials() {
        login.login();
    }


    @When("users try to log in with invalid username {string}")
    public void users_try_to_log_in_with_invalid_username(String string) {
        login.login(string, ConfigurationReader.getProperty("password"));
    }


    @When("users try to log in with invalid password {string}")
    public void users_try_to_log_in_with_invalid_password(String string) {
        login.login(ConfigurationReader.getProperty("username"), string);
    }

    @When("users try to log in with blank user name")
    public void users_try_to_log_in_with_blank_user_name() {
        login.login("", ConfigurationReader.getProperty("password"));
    }

    @When("users try to log in with blank password")
    public void users_try_to_log_in_with_blank_password() {
        login.login(ConfigurationReader.getProperty("username"), "");
    }


    @Then("user should verify that title is {string}")
    public void user_should_verify_that_title_is(String string) {
        Assert.assertEquals(string, Driver.getDriver().getTitle());
    }

    @Then("user should verify that error message is {string}")
    public void user_should_verify_that_error_message_is(String string) {
        Assert.assertEquals(string, login.getErrorMessage());
    }

}
