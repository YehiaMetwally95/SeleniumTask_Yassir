package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import yehiaEngine.assertions.CustomAssert;

public class RegisterConfirmationPage extends HomePage{
    //Variables

    //Constructor
    public RegisterConfirmationPage(WebDriver driver) {
        super(driver);
    }

    //Locators
    private final By successMessageLocator= By.xpath("//*[contains(@class,'page-title')]");
    private final By continueButton = By.linkText("Continue");

    //Actions
    @Step("Navigate to Dashboard Page")
    public DashboardPage openUserDashboardPage()   {
        bot.press(continueButton);
        return new DashboardPage(driver);
    }

    //Validations
    @Step("Verify Registration Success Message")
    public RegisterConfirmationPage verifyRegistrationSuccessMessage(String successMessage)   {
        String expectedMessage = bot.readText(successMessageLocator).trim();
        CustomAssert.assertEquals(expectedMessage,successMessage);
        return this;
    }
}
