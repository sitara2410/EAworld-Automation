package org.sample.browser;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class IEDriverManager extends DriverManager {

    @Override
    protected void createDriver() {
        DesiredCapabilities dc=DesiredCapabilities.internetExplorer();
        dc.setCapability(InternetExplorerDriver.ENABLE_PERSISTENT_HOVERING,false);
        dc.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS, false);
        dc.setCapability(InternetExplorerDriver.UNEXPECTED_ALERT_BEHAVIOR, true);
        dc.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        dc.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
        dc.setJavascriptEnabled(true);
        System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"/binaries/IEDriverServer.exe");
        driver = new InternetExplorerDriver(dc);


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
