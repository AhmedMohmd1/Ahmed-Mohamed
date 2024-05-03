package automationexercise.Pages;

import automationexercise.Utilities.DataUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static automationexercise.Utilities.Utility.clicking;
import static automationexercise.Utilities.Utility.sendData;

public class P01_LoginPage {
    private final WebDriver driver;

    private final By userNameField = By.id("user-name");
    private final By passwordField = By.id("password");
    private final By loginButton = By.id("login-button");

    public P01_LoginPage(WebDriver driver) {
        this.driver = driver;
    }


    public P01_LoginPage enterUserName(String userName) {
        sendData(driver, userNameField, userName);
        return this;
    }

    public P01_LoginPage enterPassword(String password) {
        sendData(driver, passwordField, password);
        return this;
    }

    public P02_HomePage clickLoginButton() {
        clicking(driver, loginButton);
        return new P02_HomePage(driver);
    }
}