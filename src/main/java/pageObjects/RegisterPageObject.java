package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.BasePageUI;
import pageUIs.RegisterPageUI;

public class RegisterPageObject extends BasePage {
    private WebDriver driver;

    public RegisterPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void enterFirstNameToTextBox(String firstName) {
        waitForElementVisible(driver, RegisterPageUI.FIRSTNAME_TEXT_BOX);
        sendKeysToElement(driver,RegisterPageUI.FIRSTNAME_TEXT_BOX,firstName);
    }

    public void enterLastNameToTextBox(String lastname) {
        waitForElementVisible(driver, RegisterPageUI.LASTNAME_TEXT_BOX);
        sendKeysToElement(driver,RegisterPageUI.LASTNAME_TEXT_BOX,lastname);
    }

    public void enterEmailToTextBox(String email) {
        waitForElementVisible(driver, RegisterPageUI.EMAIL_TEXT_BOX);
        sendKeysToElement(driver,RegisterPageUI.EMAIL_TEXT_BOX,email);
    }

    public void enterPasswordToTextBox(String password) {
        waitForElementVisible(driver, RegisterPageUI.PASSWORD_TEXT_BOX);
        sendKeysToElement(driver,RegisterPageUI.PASSWORD_TEXT_BOX,password);
    }

    public void enterConfirmPasswordToTextBox(String password) {
        waitForElementVisible(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXT_BOX);
        sendKeysToElement(driver,RegisterPageUI.CONFIRM_PASSWORD_TEXT_BOX,password);
    }

    public void clickToRegisterButton() {
        waitForElementClickable(driver,RegisterPageUI.REGISTER_BUTTON);
        clickToElement(driver,RegisterPageUI.REGISTER_BUTTON);
    }

    public boolean isSuccessMessageDisplayed() {
        waitForElementVisible(driver, RegisterPageUI.SUCCESS_MESSAGE_TEXT);
        return isElementDisplayed(driver, RegisterPageUI.SUCCESS_MESSAGE_TEXT) ;
    }

    public HomePageObject clickToHeaderLinkByName(String log_out) {
        waitForElementClickable(driver, BasePageUI.HEADER_BY_NAME,log_out);
        clickToElement(driver, BasePageUI.HEADER_BY_NAME,log_out);
        return PageGeneratorManager.getHomepage(driver);
    }
}
