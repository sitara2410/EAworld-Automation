package org.sample.pageimpl;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.sample.pages.MainPage;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class MainPageImpl {

    private final WebDriver driver;

    @Inject
    @Named("application.url")
    private String url;

    @Inject
    private MainPage mainPage;

    @Inject
    private Actions actions;

    @Inject
    private JavascriptExecutor jsExecutor;

    @Inject
    public MainPageImpl(WebDriver driver) {
        this.driver = driver;
    }

    public void goTo() {
        driver.get(url);
    }

    public MainPage getMainPage() {
        return mainPage;
    }

    public Object execute(String script) {
        return jsExecutor.executeScript(script);
    }

    public Actions getActions() {return actions;}

    public void maximize() {
        driver.manage().window().maximize();
    }

    public void quitDriver() {
        driver.quit();
    }

    /**
     * This method takes the screenshot on test failure
     * @param iTestResult
     */
    public void onTestFailure(ITestResult iTestResult) {
        if(iTestResult.getStatus() == ITestResult.FAILURE) {
                System.out.println("***** Error " + iTestResult.getName() + " test has failed *****");
                String methodName = iTestResult.getName().trim();
                takeScreenShot(methodName);
            }
        }

    public void takeScreenShot(String methodName) {
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir")+"/Screenshots/"+methodName+".png"));
            System.out.println("***Placed screen shot in "+System.getProperty("user.dir")+"/Screenshots/"+" ***");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void waitForSecs(int sec) {
        driver.manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS);
    }
}
