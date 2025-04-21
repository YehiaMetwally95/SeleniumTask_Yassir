package CucumberStepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.ProductsPage;
import pages.RegisterConfirmationPage;
import pages.RegisterPage;

import static yehiaEngine.driverManager.BrowserFactory.getDriver;

public class SearchProductsSteps {

    //Dependency Injection
    BaseSteps basesteps;

    public SearchProductsSteps(BaseSteps baseSteps)
    {
        this.basesteps = baseSteps;
    }

    @Given("User Navigates to Home Page")
    public void user_navigates_to_home_page() {
        new HomePage(getDriver(basesteps.isolatedDriver))
                .verifySiteLogoIsDisplayed()
                .openRegisterPage()
                .verifyRegisterHeaderIsDisplayed()
                .registerNewUserWithRandomInfo()
                .openUserDashboardPage()
                .verifyDashboardPageIsDisplayed()
                .openHomePage();
    }

    @When("User searches for product {string}")
    public void user_searches_for_product(String productName) {
        new HomePage(getDriver(basesteps.isolatedDriver))
                .searchForProductByName(productName);

        // Share product Name among Scenario Steps by Dependency Injection
        basesteps.productName = productName;
    }

    @Then("All Search Results shall matches this Product")
    public void all_search_results_shall_matches_this_product() {
        new ProductsPage(getDriver(basesteps.isolatedDriver))
                .switchToListView()
                .verifyAllProductsAreMatched(basesteps.productName);
    }

    @Then("Error Message is displayed {string}")
    public void error_message_is_displayed(String errorMessage) {
        new ProductsPage(getDriver(basesteps.isolatedDriver))
                .verifyErrorMessageNoProductsFound(errorMessage);    }
}
