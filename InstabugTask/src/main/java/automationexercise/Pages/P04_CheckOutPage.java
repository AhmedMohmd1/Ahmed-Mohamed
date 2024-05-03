package automationexercise.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static automationexercise.Utilities.Utility.clicking;
import static automationexercise.Utilities.Utility.sendData;

public class P04_CheckOutPage {
    private final WebDriver driver;
    private final By firstNameField = By.id("first-name");
    private final By lastNameField = By.id("last-name");
    private final By postalCodeField = By.id("postal-code");
    private final By continueButton = By.id("continue");


    public P04_CheckOutPage(WebDriver driver) {
        this.driver = driver;
    }

    public P04_CheckOutPage enterPersonalInfo(String firstName, String lastName, String postalCode) {
        sendData(driver, firstNameField, firstName);
        sendData(driver, lastNameField, lastName);
        sendData(driver, postalCodeField, postalCode);
        return this;
    }

    public P05_OverviewPage pressContinueButton() {
        clicking(driver, continueButton);
        return new P05_OverviewPage(driver);
    }

}
