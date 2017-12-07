package org.eaworld.pages;

import com.google.inject.Inject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class EAWorldPage extends MainPage {
    WebDriver driver;

    @Inject
    public EAWorldPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(css = ".eaw-navigation__toggle")
    private WebElement menuButton;

    @FindBy(css = "a[title=Search]")
    private WebElement searchButton;

    public void searchButtonclick() {

        searchButton.click();
        System.out.println("Sitara!");
        try {
            Thread.sleep(5000); // This is for Hard wait on page for 5 secs
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
