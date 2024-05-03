package automationexercise.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static automationexercise.Utilities.Utility.*;

public class P02_HomePage {

    private final WebDriver driver;

    public P02_HomePage(WebDriver driver) {
        this.driver = driver;
    }

    private final By productsHeader = By.className("title");
    private final By inventoryItems = By.className("inventory_item");
    private final By addToCartButtons = By.xpath("//button[contains(text(),'Add to cart')]");
    private final By shoppingCartIcon = By.className("shopping_cart_link");

    public boolean verifyProductsHeader() {
        String textHeader = getText(driver, productsHeader);
        return textHeader.equals("Products");
    }

    public int assertInventoryItemsCount() {
        return findWebElements(driver, inventoryItems).size();
    }


    public P02_HomePage pressAddToCartButtonOnFirst3Buttons() {
        List<WebElement> items = findWebElements(driver, addToCartButtons);
        // Click on the first three items
        for (int i = 0; i < Math.min(3, items.size()); i++) {
            items.get(i).click();
        }
        return this;
    }

    public boolean assertShoppingCart() {
        return getText(driver, shoppingCartIcon).equals(3);
    }

    public P03_CartPage pressShoppingCartIcon() {
        clicking(driver, shoppingCartIcon);
        return new P03_CartPage(driver);
    }

}

