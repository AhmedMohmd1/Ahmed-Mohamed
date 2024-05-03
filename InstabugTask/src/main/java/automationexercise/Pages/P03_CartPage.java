package automationexercise.Pages;

import automationexercise.Utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P03_CartPage {
    private final WebDriver driver;
    private final By checkoutButton = By.id("checkout");

    public P03_CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public P04_CheckOutPage pressCheckoutButton() {
        Utility.scrollToElement(driver, checkoutButton);
        Utility.clicking(driver, checkoutButton);
        return new P04_CheckOutPage(driver);
    }
}
