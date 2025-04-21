package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import yehiaEngine.assertions.CustomAssert;

public class DashboardPage extends HomePage{

    //Constructor
    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    //Locators
    By myAccountsHeader = By.xpath("//h2[.='My Account']");
    By myOrdersHeader = By.xpath("//h2[.='My Orders']");

    //Actions

    //Validations
    @Step("Verify DashboardPageIsDisplayed")
    public DashboardPage verifyDashboardPageIsDisplayed()   {
        CustomAssert.assertTrue(bot.isElementDisplayed(myAccountsHeader));
        CustomAssert.assertTrue(bot.isElementDisplayed(myOrdersHeader));
        return this;
    }
}
