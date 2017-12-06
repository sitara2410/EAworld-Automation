package org.eaworld.pages;

import com.google.inject.Inject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

    @Inject
    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


}
