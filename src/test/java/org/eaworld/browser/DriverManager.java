package org.eaworld.browser;

import org.openqa.selenium.WebDriver;

public abstract class DriverManager {

    protected WebDriver driver;

    protected abstract void createDriver();

    protected abstract void startService();

    protected abstract void stopService();


    public WebDriver getDriver() {
        if (driver == null) {
            startService();
            createDriver();
        }
        return driver;
    }

    public void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

}
