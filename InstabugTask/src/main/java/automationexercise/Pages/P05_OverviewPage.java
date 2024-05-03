package automationexercise.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static automationexercise.Utilities.Utility.*;

public class P05_OverviewPage {
    private final WebDriver driver;
    private final By finishButton = By.id("finish");
    private final By inventory_item_price = By.className("inventory_item_price");
    private final By itemsTotalPrice = By.className("summary_subtotal_label");
    private final By tax = By.className("summary_tax_label");

    public P05_OverviewPage(WebDriver driver) {
        this.driver = driver;
    }

    public double getTotalPriceItems() {
        double totalPrice = 0.0;
        List<WebElement> itemsPrice = findWebElements(driver, inventory_item_price);
        for (WebElement element : itemsPrice) {
            String priceString = element.getText();
            double price = Double.parseDouble(priceString.substring(1));
            totalPrice += price;
        }
        return totalPrice;
    }

    public double assertTotalPriceItems() {
        return Double.parseDouble(getText(driver, itemsTotalPrice).substring(13));

    }

    public P06_CheckoutCompleteOrderPage pressFinishButton() {
        scrollToElement(driver, finishButton);
        clicking(driver, finishButton);
        return new P06_CheckoutCompleteOrderPage(driver);
    }
}
