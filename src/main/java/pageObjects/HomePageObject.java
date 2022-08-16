package pageObjects;

import commons.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pageUIs.BasePageUI;
import pageUIs.HomePageUI;

public class HomePageObject extends BasePage {
    private WebDriver driver;

    public HomePageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void clickToHeaderLinkByName(String linkText) {
        waitForElementClickable(driver, BasePageUI.HEADER_BY_NAME,linkText);
        clickToElement(driver, BasePageUI.HEADER_BY_NAME,linkText);
    }

}
