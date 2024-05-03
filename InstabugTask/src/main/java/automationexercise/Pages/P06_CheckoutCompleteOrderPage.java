package automationexercise.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static automationexercise.Utilities.Utility.getText;

public class P06_CheckoutCompleteOrderPage {

    private final WebDriver driver;

    private final By successMessage = By.className("complete-header");

    public P06_CheckoutCompleteOrderPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean assertCompletedOrderSuccessfully(String message) {
        return getText(driver, successMessage).contentEquals(message);
    }
}
