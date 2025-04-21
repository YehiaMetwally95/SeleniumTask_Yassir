package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import yehiaEngine.assertions.CustomAssert;
import yehiaEngine.elementActions.WebElementsActions;

public class HomePage {

    //Variables
    WebDriver driver;
    WebElementsActions bot;

    //Constructor
    public HomePage(WebDriver driver) {
        this.driver = driver;
        bot = new WebElementsActions(driver);
    }

    //Locators
    private final By myAccountMenu = By.xpath("//div[@id='main-navigation']//a[contains(.,'My account')]");
    private final By registerSubMenu = By.xpath("//a[contains(.,'Register')]");
    private final By siteLogo = By.xpath("//a[@title='Poco Electro']");
    private final By homeMenu = By.xpath("//*[contains(.,'Home') and @class='title']");
    private final By searchBox = By.xpath("//div[@id='main-header']//input[@name='search']");
    private final By searchButton = By.cssSelector("#main-header .search-button");
    private final By shopByCategory = By.xpath("//div[contains(@class,'shop-by-category')]");
    private final By componentsProducts = By.xpath("//ul[@class='navbar-nav vertical']//a[contains(.,'Components')]");
    private final By cartButton = By.xpath("//a[@aria-controls = 'cart-total-drawer']");
    private final By editCartButton = By.xpath("//a[contains(.,'Edit cart')]");

    //Actions
    @Step("Navigate To Register Page")
    public RegisterPage openRegisterPage()   {
        bot
                .hoverOnElement(myAccountMenu)
                .press(registerSubMenu);
        return new RegisterPage(driver);
    }

    @Step("Navigate To Home Page")
    public HomePage openHomePage()   {
        bot.press(homeMenu);
        return new HomePage(driver);
    }

    @Step("Navigate To Products Page")
    public ProductsPage openProductsPage()   {
        bot
                .press(shopByCategory)
                .press(componentsProducts);
        return new ProductsPage(driver);
    }

    @Step("Navigate To Cart Page")
    public CartPage openCartPage()   {
        bot
                .press(cartButton)
                .press(editCartButton);
        return new CartPage(driver);
    }

    @Step("Search for Product by Name")
    public ProductsPage searchForProductByName(String productName)   {
        bot
                .type(searchBox,productName)
                .press(searchButton);

        return new ProductsPage(driver);
    }

    //Validations
    @Step("Verify Site Logo is Displayed")
    public HomePage verifySiteLogoIsDisplayed()   {
        CustomAssert.assertTrue(bot.isElementDisplayed(siteLogo));
        return this;
    }
}
