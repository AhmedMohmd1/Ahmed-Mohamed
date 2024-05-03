package Tests;

import automationexercise.DriverManager.DriverFactory;
import automationexercise.DriverManager.DriverManager;
import automationexercise.Pages.P01_LoginPage;
import automationexercise.Utilities.DataUtils;
import automationexercise.Utilities.Utility;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static automationexercise.DriverManager.DriverManager.getDriver;
import static automationexercise.Utilities.DataUtils.getJsonData;
import static automationexercise.Utilities.Utility.VerifyURL;

public class T01_LoginTests {
    @BeforeMethod
    public void setUp() {
        DriverFactory.createInstance(DataUtils.getEnvironmentPropertyValue("BROWSER"));
        Utility.openWebsite(DataUtils.getEnvironmentPropertyValue("BASE_URL"));
    }

    @Test
    public void verifyLoginSuccessfully() {
      
        new P01_LoginPage(getDriver())
                .enterUserName(getJsonData("userData", "userLoginData.user1"))
                .enterPassword(getJsonData("userData", "userLoginData.password"))
                .clickLoginButton();
        VerifyURL(getDriver(), DataUtils.getEnvironmentPropertyValue("HOME_URL"));
    }

    @AfterMethod
    public void tearDown() {
        DriverManager.quit();
    }
}
