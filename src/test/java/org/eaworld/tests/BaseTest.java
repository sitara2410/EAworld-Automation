package org.eaworld.tests;

import com.google.inject.Inject;
import org.eaworld.modules.DriverModule;
import org.eaworld.pageimpl.MainPageImpl;
import org.testng.ITestResult;
import org.testng.annotations.*;

@Guice(modules = {
        DriverModule.class
})

public class BaseTest {
    @Inject
    MainPageImpl mainPage;

    @BeforeTest(alwaysRun = true)
    public void begin() {

        mainPage.goTo();
        //mainPage.maximize();
    }

    @AfterMethod
    public void takeScreenshot(ITestResult iTestResult) {
        mainPage.onTestFailure(iTestResult);
    }

    @AfterTest
    public void tearDown() {
        mainPage.quitDriver();
    }
}
