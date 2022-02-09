package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.LoginPageUI;

public class LoginPageObject extends BasePage {
    private WebDriver driver;

    public LoginPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void enterEmailTextBox(String value) {
        waitForElementVisible(driver, LoginPageUI.EMAIL_TEXT_BOX);
        sendKeysToElement(driver,LoginPageUI.EMAIL_TEXT_BOX,value);
    }

    public void enterPasswordTextBox(String password) {
        waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXT_BOX);
        sendKeysToElement(driver,LoginPageUI.PASSWORD_TEXT_BOX,password);
    }

    public void clickToLoginButton() {
        waitForElementClickable(driver,LoginPageUI.LOGIN_BUTTON);
        clickToElement(driver,LoginPageUI.LOGIN_BUTTON);
    }
}
