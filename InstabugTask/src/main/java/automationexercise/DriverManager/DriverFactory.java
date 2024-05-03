package automationexercise.DriverManager;

import org.openqa.selenium.WebDriver;

import static automationexercise.DriverManager.DriverManager.setDriver;

public class DriverFactory {


    public static void createInstance(String browser) {
        WebDriver driver = BrowserFactory.valueOf(browser.toUpperCase()).createDriver();
        setDriver(driver);
    }

}
