package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import yehiaEngine.assertions.CustomAssert;

public class CartPage extends HomePage{

    //Constructor
    public CartPage(WebDriver driver) {
        super(driver);
    }

    //Locators
    private final By cartHeaderLocator = By.xpath("//h1[contains(.,'Shopping Cart')]");
    private By getProduct(String productName){
        return By.partialLinkText(productName);
    }


    //Actions

    //Validations
    @Step("Verify Product is Added to Cart")
    public CartPage verifyProductIsAddedToCart(String productName)   {
        CustomAssert.assertTrue(bot.isElementDisplayed(getProduct(productName)));
        return this;
    }

    @Step("Verify Cart Page is Opened")
    public CartPage verifyCartPageIsOpened()   {
        CustomAssert.assertTrue(bot.isElementDisplayed(cartHeaderLocator));
        return this;
    }
}
