package net.avantage.step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.avantage.pages.LoginPage;
import net.avantage.utils.BrowserUtils;
import net.avantage.utils.ConfigurationReader;
import net.avantage.utils.Driver;

public class LoginStepDefs {
    LoginPage loginPage = new LoginPage();
    String email = ConfigurationReader.get("email");
    @Given("the user navigates to the login page")
    public void theUserNavigatesToTheLoginPage() {
        Driver.get().get(ConfigurationReader.get("url_UI"));
    }
    @And("User accepts all cookies")
    public void userAcceptsAllCookies() {
        loginPage.acceptCookies();
    }
    @And("User accepts age question")
    public void userAcceptsAgeQuestion() {
        loginPage.acceptAge();
    }
    @When("User logs in with valid credentials")
    public void userLogsInWithValidCredentials() {
        loginPage.logIn(email);
    }
    @Then("the user views that avatar is visible")
    public void theUserViewsThatAvatarIsVisible() {
        BrowserUtils.waitForVisibility(loginPage.avatar, 15);
        loginPage.verifyAvatarOrAvatarInitials();
    }
}
