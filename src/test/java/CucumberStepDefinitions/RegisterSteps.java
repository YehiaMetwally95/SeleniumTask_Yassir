package CucumberStepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.DashboardPage;
import pages.HomePage;
import pages.RegisterConfirmationPage;
import pages.RegisterPage;

import static yehiaEngine.driverManager.BrowserFactory.getDriver;

public class RegisterSteps {

    //Dependency Injection
    BaseSteps basesteps;

    public RegisterSteps(BaseSteps baseSteps)
    {
        this.basesteps = baseSteps;
    }

    @Given("User navigates to Registration Page")
    public void user_navigates_to_registration_page() {
        new HomePage(getDriver(basesteps.isolatedDriver))
                .verifySiteLogoIsDisplayed()
                .openRegisterPage()
                .verifyRegisterHeaderIsDisplayed();
    }

    @When("User updates his personal data {string} {string} {string} {string} {string}")
    public void user_updates_his_personal_data(String firstName, String lastName, String email, String mobileNumber, String password) {
        new RegisterPage(getDriver(basesteps.isolatedDriver))
                .registerNewUser(firstName,lastName,email,mobileNumber,password);
    }

    @When("User updates random personal data and Submit")
    public void user_updates_random_personal_data_and_submit() {
        new RegisterPage(getDriver(basesteps.isolatedDriver))
                .registerNewUserWithRandomInfo();
    }

    @Then("Success Message {string} is displayed")
    public void success_message_is_displayed(String successMessage) {
        new RegisterConfirmationPage(getDriver(basesteps.isolatedDriver))
                .verifyRegistrationSuccessMessage(successMessage);

    }
    @Then("User is redirected to Dashboard Page")
    public void user_is_redirected_to_dashboard_page() {
        new RegisterConfirmationPage(getDriver(basesteps.isolatedDriver))
                .openUserDashboardPage()
                .verifyDashboardPageIsDisplayed();
    }
}
