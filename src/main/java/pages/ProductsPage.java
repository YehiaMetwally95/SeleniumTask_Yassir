package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import yehiaEngine.assertions.CustomAssert;
import yehiaEngine.elementActions.WebElementsActions;

import java.util.ArrayList;
import java.util.List;

public class ProductsPage extends HomePage{

    //Variables
    List<WebElement> searchResults;

    //Constructor
    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    //Locators
    private By ProductTitleLocator = By.cssSelector(".title .text-ellipsis-2");
    private By listViewLocator = By.id("list-view");
    private By noProductsParagraph = By.xpath("//div[contains(@class,'content-products')]//p");
    private By inStockFilter = By.xpath("(//div[contains(@class,'stock_status')]//label[contains(.,'In stock')])[2]");
    private By addToCartButton(String productName){
        return By.xpath("//div[@class='product-thumb' and contains(.,'"+productName+"')] // button[@title='Add to Cart']");
    };

    //Actions
    @Step("Switch to List View")
    public ProductsPage switchToListView() {
        bot.press(listViewLocator);
        return this;
    }

    @Step("Filter Products by In Stock")
    public ProductsPage filterProductsByInStock() {
        bot.press(inStockFilter);
        return this;
    }

    @Step("Add Product To Cart")
    public ProductsPage addProductToCart(String productName) {
        bot.press(addToCartButton(productName));
        return this;
    }

    //Validations
    @Step("Verify All Products Are Matched")
    public ProductsPage verifyAllProductsAreMatched(String productName)   {
        searchResults = bot.getAllMatchedElements(ProductTitleLocator);

        for (WebElement element : searchResults) {
            CustomAssert.assertEquals(bot.readText(element),productName);
        }

        return this;
    }

    @Step("Verify Error Message of No Products Found")
    public ProductsPage verifyErrorMessageNoProductsFound(String errorMessage)   {
        CustomAssert.assertEquals(bot.readText(noProductsParagraph),errorMessage);
        return this;
    }
}
