package Tests;

import automationexercise.DriverManager.DriverFactory;
import automationexercise.DriverManager.DriverManager;
import automationexercise.Pages.P01_LoginPage;
import automationexercise.Pages.P02_HomePage;
import automationexercise.Utilities.DataUtils;
import automationexercise.Utilities.Utility;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static automationexercise.DriverManager.DriverManager.getDriver;
import static automationexercise.Utilities.DataUtils.getJsonData;

public class T02_HomePageTests {

    SoftAssert soft = new SoftAssert();

    @BeforeMethod
    public void setUp() {
        DriverFactory.createInstance(DataUtils.getEnvironmentPropertyValue("BROWSER"));
        Utility.openWebsite(DataUtils.getEnvironmentPropertyValue("BASE_URL"));
    }

    @Test()
    public void verifyHomePageVisibility() {
        new P01_LoginPage(getDriver())
                .enterUserName(getJsonData("loginData", "userLoginData.user1"))
                .enterPassword(getJsonData("loginData", "userLoginData.password"))
                .clickLoginButton();
        soft.assertTrue(new P02_HomePage(getDriver()).verifyProductsHeader());
        soft.assertAll();

    }

    @Test()
    public void assertInventoryItemsCount() {
        new P01_LoginPage(getDriver())
                .enterUserName(getJsonData("loginData", "user1"))
                .enterPassword(getJsonData("loginData", "password"))
                .clickLoginButton();
        soft.assertEquals(new P02_HomePage(getDriver()).assertInventoryItemsCount(), 6);
        soft.assertAll();

    }


    @AfterMethod

    public void tearDown() {
        DriverManager.quit();
    }
}
