package org.sample.browser;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;

public class FirefoxDriverManager extends DriverManager {

    @Override
    protected void createDriver() {
        DesiredCapabilities desiredCapabilities=DesiredCapabilities.firefox();
        FirefoxProfile profile = new FirefoxProfile();
        desiredCapabilities.setCapability(FirefoxDriver.PROFILE, profile);
        System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"/binaries/geckodriver.exe");
        driver =  new FirefoxDriver(desiredCapabilities);

    }

    @Override
    protected void startService() {

    }

    @Override
    protected void stopService() {
        if(driver!=null) {
            driver.close();
        }

    }
}
