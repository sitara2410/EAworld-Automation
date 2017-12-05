package org.sample.pages;

import com.google.inject.Inject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

    @Inject
    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


}
