package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import yehiaEngine.assertions.CustomAssert;

import static yehiaEngine.utilities.RandomDataGenerator.*;

public class RegisterPage extends HomePage{

    //Variables

    //Constructor
    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    //Locators
    private final By firstNameLocator = By.id("input-firstname");
    private final By lastNameLocator = By.id("input-lastname");
    private final By emailLocator = By.id("input-email");
    private final By telephoneLocator = By.id("input-telephone");
    private final By passwordLocator = By.id("input-password");
    private final By confirmPasswordLocator = By.id("input-confirm");
    private final By subscribeYesLocator = By.xpath("//label[@for='input-newsletter-yes']");
    private final By subscribeNoLocator = By.xpath("//label[@for='input-newsletter-no']");
    private final By policyCheckboxLocator = By.xpath("//label[@for='input-agree']");
    private final By continueButtonLocator = By.xpath("//input[@value='Continue']");
    private final By registerHeaderLocator = By.xpath("//*[contains(@class,'page-title')]");

    //Actions
    @Step("Register New User With Random Info")
    public RegisterConfirmationPage registerNewUserWithRandomInfo()   {
        updatePersonalInfoByRandomData()
                .clickContinueButton();
        return new RegisterConfirmationPage(driver);
    }

    @Step("Register New User")
    public RegisterConfirmationPage registerNewUser(String firstName,String lastName, String email,String mobileNumber,String password)   {
        updatePersonalInfo(firstName,lastName,email,mobileNumber,password)
                .clickContinueButton();
        return new RegisterConfirmationPage(driver);
    }

    //Validations
    @Step("Verify Register Header is Displayed")
    public RegisterPage verifyRegisterHeaderIsDisplayed()   {
        CustomAssert.assertTrue(bot.isElementDisplayed(registerHeaderLocator));
        return this;
    }

    //Private Methods
    @Step("Update Personal Info With Random Data")
    private RegisterPage updatePersonalInfoByRandomData()   {
       String password = generateStrongPassword();
       bot
               .type(firstNameLocator,generateName())
               .type(lastNameLocator,generateName())
               .type(emailLocator,generateUniqueEmail())
               .type(telephoneLocator,generateMobileNumber())
               .type(passwordLocator,password)
               .type(confirmPasswordLocator,password)
               .press(subscribeYesLocator)
               .press(policyCheckboxLocator);

        return this;
    }

    @Step("Update Personal Info")
    private RegisterPage updatePersonalInfo(String firstName,String lastName, String email,String mobileNumber,String password)   {
        bot
                .type(firstNameLocator,firstName)
                .type(lastNameLocator,lastName)
                .type(emailLocator,email)
                .type(telephoneLocator,mobileNumber)
                .type(passwordLocator,password)
                .type(confirmPasswordLocator,password)
                .press(subscribeYesLocator)
                .press(policyCheckboxLocator);

        return this;
    }

    @Step("Click on Continue Button")
    private RegisterConfirmationPage clickContinueButton()   {
        bot.press(continueButtonLocator);
        return new RegisterConfirmationPage(driver);
    }
}
