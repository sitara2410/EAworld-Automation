package org.eaworld.tests;

import org.eaworld.pageimpl.MainPageImpl;
import org.eaworld.pages.EAWorldPage;
import org.eaworld.pages.MainPage;
import org.testng.annotations.Test;

import com.google.inject.Inject;

import org.eaworld.pageimpl.EAWorldHomePageImpl;
import org.testng.internal.BaseTestMethod;


public class EAWorldLoginPageTest extends BaseTest {

    @Inject
    EAWorldHomePageImpl eaWorldHomePageImpl;

    @Test
    public void loginTest() 
    {

        eaWorldHomePageImpl.getEaWorldPage().searchButtonclick();
        eaWorldHomePageImpl.waitForSecs(5);

    }


}
