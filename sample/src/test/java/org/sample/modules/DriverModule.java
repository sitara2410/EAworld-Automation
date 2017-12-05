package org.sample.modules;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Scopes;
import com.google.inject.name.Names;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.sample.browser.ChromeDriverManager;
import org.sample.browser.DriverManager;
import org.sample.browser.FirefoxDriverManager;
import org.sample.browser.IEDriverManager;

import java.io.FileInputStream;
import java.util.Properties;

public class DriverModule extends AbstractModule {

    private Properties props;

    /*
        This is to inject instance of ChromeDriverManager.class into the DriverManager variable
         */
    @Override
    protected void configure() {
        /*
            To load Global Properties file
        */
        try {
            props = new Properties();
            props.load(new FileInputStream(System.getProperty("user.dir") + "/Data/GlobalProperties.properties"));
            Names.bindProperties(binder(), props);
        } catch (Exception e) {
                e.printStackTrace();
        }
        //Driver manager config
        String browserName=props.getProperty("browser.name");

        if(browserName.equalsIgnoreCase("chrome")) {
            bind(DriverManager.class).to(ChromeDriverManager.class).in(Scopes.SINGLETON);
        }

        else if(browserName.equalsIgnoreCase("firefox")) {
            bind(DriverManager.class).to(FirefoxDriverManager.class).in(Scopes.SINGLETON);
        }
        else if(browserName.equalsIgnoreCase("ie")) {
            bind(DriverManager.class).to(IEDriverManager.class).in(Scopes.SINGLETON);
        }
    }


    /*
      To get the WebDriver instance
     */

    @Provides
    public WebDriver getDriver(DriverManager driverManager) {

        return driverManager.getDriver();
    }

    /*
        To get instance of Actions
     */
    @Provides
    public Actions getActions(WebDriver driver) {
        return new Actions(driver);
    }

    /*
        To get instance of Java Script Executor
     */
    @Provides
    public JavascriptExecutor getExecutor(WebDriver driver) {
        return (JavascriptExecutor) (driver);
    }


}
