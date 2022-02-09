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


public class DemoClass extends BaseTest {
    WebDriver driver;

    @Parameters({"browserName", "appUrl"})
    @BeforeClass
    public void beforeClass(String browserName, String appUrl) {
        log.info("open  '" + browserName + "' browser");
        driver = getBrowserDriver(browserName, appUrl);
    }


    @Test
    public void New_Customer_01_Validate_Name() {

        log.info("TC_01 - Step_01 : Validate email text box is displayed");
        Assert.assertTrue(driver.findElement(By.xpath("//input[@name ='uid']")).isDisplayed());
        log.info("TC_01 - Step_02 : Validate password text box is displayed");
        Assert.assertFalse(driver.findElement(By.xpath("//input[@name ='password']")).isDisplayed());

    }

    @Test
    public void New_Customer_02_Validate_Name() {
        log.info("TC_02 - Step_01 : SendKey to Email text box");
        driver.findElement(By.xpath("//input[@name ='uid']")).sendKeys("Minhhieu");
        log.info("TC_01 - Step_02 : SendKey to password text box ");
       driver.findElement(By.xpath("//input[@name ='password']")).sendKeys("123456");


    }


    @AfterClass
    public void afterClass() {
        driver.quit();
    }


}
