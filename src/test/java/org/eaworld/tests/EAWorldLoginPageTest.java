package org.eaworld.tests;

import org.testng.annotations.Test;

import com.google.inject.Inject;

import org.eaworld.pageimpl.EAWorldHomePageImpl;



public class EAWorldLoginPageTest extends BaseTest {

    @Inject
    EAWorldHomePageImpl eaWorldHomePageImpl;

    @Test
    public void loginTest() 
    {
        //Assert.assertFalse(true);
        //mainPage.getEaWorldPage().menuButtonclick();
        eaWorldHomePageImpl.getEaWorldPage().searchButtonclick();
        eaWorldHomePageImpl.waitForSecs(5);

    }


}
