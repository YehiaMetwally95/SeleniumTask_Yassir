package CucumberStepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CartPage;
import pages.HomePage;
import pages.ProductsPage;

import static yehiaEngine.driverManager.BrowserFactory.getDriver;

public class AddToCartSteps {

    //Dependency Injection
    BaseSteps basesteps;

    public AddToCartSteps(BaseSteps baseSteps)
    {
        this.basesteps = baseSteps;
    }

    @Given("User Navigates to Products Page")
    public void user_navigates_to_products_page() {
        new HomePage(getDriver(basesteps.isolatedDriver))
                .verifySiteLogoIsDisplayed()
                .openRegisterPage()
                .verifyRegisterHeaderIsDisplayed()
                .registerNewUserWithRandomInfo()
                .openUserDashboardPage()
                .verifyDashboardPageIsDisplayed()
                .openProductsPage();
    }

    @When("User Add Products {string} {string} {string} to Cart")
    public void user_add_product_to_cart(String productName1 , String productName2 , String productName3) {
        new ProductsPage(getDriver(basesteps.isolatedDriver))
                .switchToListView()
                .filterProductsByInStock()
                .addProductToCart(productName1)
                .addProductToCart(productName2)
                .addProductToCart(productName3);

        // Share product Name among Scenario Steps by Dependency Injection
        basesteps.productNames.add(productName1);
        basesteps.productNames.add(productName2);
        basesteps.productNames.add(productName3);

    }

    @Then("The Product shall be Added in Cart Page")
    public void the_product_shall_be_added_in_cart_page() {
        new CartPage(getDriver(basesteps.isolatedDriver))
                .openCartPage()
                .verifyCartPageIsOpened()
                .verifyProductIsAddedToCart(basesteps.productNames.get(0))
                .verifyProductIsAddedToCart(basesteps.productNames.get(1))
                .verifyProductIsAddedToCart(basesteps.productNames.get(2));
    }
}
