package testcases;

import commons.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.PageGeneratorManager;
import pageObjects.RegisterPageObject;

import java.util.Random;


public class DemoClass extends BaseTest {
    public WebDriver driver;
    String firstName, lastname, email, password;

    @Parameters({"browserName", "appUrl"})
    @BeforeClass
    public void beforeClass(String browserName, String appUrl) {
        firstName = "Hieu";
        lastname = "Duong";
        password = "Minhhieu123";
        email = "automation" + getRandomNumber() + "@gmail.com";
        log.info("open  '" + browserName + "' browser");
        driver = getBrowserDriver(browserName, appUrl);
        homePage = PageGeneratorManager.getHomepage(driver);
    }


    @Test
    public void Login_01_Register_New_Account() {
        log.info("TC_01 - Step_01 : Click to Register link at header");
        homePage.clickToHeaderLinkByName("Register");
        registerPage =  PageGeneratorManager.getRegisterPage(driver);

        log.info("TC_01 - Step_02 : Enter FirstName");
        registerPage.enterFirstNameToTextBox(firstName);

        log.info("TC_01 - Step_03 : Enter LastName");
        registerPage.enterLastNameToTextBox(lastname);

        log.info("TC_01 - Step_04 : Enter Email");
        registerPage.enterEmailToTextBox(email);

        log.info("TC_01 - Step_05 : Enter Password");
        registerPage.enterPasswordToTextBox(password);

        log.info("TC_01 - Step_06 : Enter Confirm Password");
        registerPage.enterConfirmPasswordToTextBox(password);

        log.info("TC_01 - Step_07 : Click to REGISTER button");
        registerPage.clickToRegisterButton();

        log.info("TC_01 - Step_08 : Verify Success Message Displayed");
        verifyTrue(registerPage.isSuccessMessageDisplayed());


    }

    @Test
    public void Login_02_Login_New_Account() {
        log.info("TC_02 - Step_01 : logout to HomePage ");
        homePage = registerPage.clickToHeaderLinkByName("Log out");


        log.info("TC_02 - Step_02 : click To Login Link  ");
        homePage.clickToHeaderLinkByName("Log in");
        loginPage = PageGeneratorManager.getLoginPage(driver);

        log.info("TC_02 - Step_03 : Enter to Email ");
        loginPage.enterEmailTextBox(email);

        log.info("TC_02 - Step_04 : Enter to Password ");
        loginPage.enterPasswordTextBox(password);

        log.info("TC_02 - Step_04 : Click to Login Button ");
        loginPage.clickToLoginButton();


    }


    @AfterClass
    public void afterClass() {
        //driver.quit();
    }

    public int getRandomNumber() {
        Random random = new Random();
        return random.nextInt(999);
    }

    private HomePageObject homePage;
    private LoginPageObject loginPage;
    private RegisterPageObject registerPage;

}
