package org.sample.tests;

import com.google.inject.Inject;
import org.sample.modules.DriverModule;
import org.sample.pageimpl.MainPageImpl;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Guice;

@Guice(modules = {
        DriverModule.class
})
public class BaseTest {

    @Inject
    MainPageImpl mainPage;

    @BeforeMethod(alwaysRun = true)
    public void begin() {

        mainPage.goTo();
        mainPage.maximize();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult iTestResult) {
        mainPage.onTestFailure(iTestResult);
        mainPage.quitDriver();


    }
}