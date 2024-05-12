package Tests;

import automationexercise.DriverManager.DriverFactory;
import automationexercise.DriverManager.DriverManager;
import automationexercise.Pages.P01_LoginPage;
import automationexercise.Pages.P05_OverviewPage;
import automationexercise.Pages.P06_CheckoutCompleteOrderPage;
import automationexercise.Utilities.DataUtils;
import automationexercise.Utilities.Utility;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static automationexercise.DriverManager.DriverManager.getDriver;
import static automationexercise.Utilities.DataUtils.getJsonData;

public class T03_PurchaseTests {
    SoftAssert soft = new SoftAssert();

    @BeforeMethod
    public void setUp() {
        DriverFactory.createInstance(DataUtils.getEnvironmentPropertyValue("BROWSER"));
        Utility.openWebsite(DataUtils.getEnvironmentPropertyValue("BASE_URL"));
    }

    @Test
    public void purchaseOrderTest() {
        new P01_LoginPage(getDriver())
                .enterUserName(getJsonData("userData", "user1"))
                .enterPassword(getJsonData("userData", "password"))
                .clickLoginButton()
                .pressAddToCartButtonOnFirst3Buttons()
                .pressShoppingCartIcon()
                .pressCheckoutButton()
                .enterPersonalInfo(
                        getJsonData("userData", "firstName"),
                        getJsonData("userData", "secondName"),
                        getJsonData("userData", "postalCode"))
                .pressContinueButton();

        soft.assertEquals(new P05_OverviewPage(getDriver()).getTotalPriceItems(),
                new P05_OverviewPage(getDriver()).assertTotalPriceItems());

        new P05_OverviewPage(getDriver()).pressFinishButton();
        soft.assertTrue(new P06_CheckoutCompleteOrderPage(getDriver())
                .assertCompletedOrderSuccessfully("Thank you for your order!"));


        soft.assertAll();
    }


    @AfterMethod
    public void tearDown() {
        DriverManager.quit();
    }
}
