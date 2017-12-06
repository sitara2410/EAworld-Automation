package org.sample.pageimpl;

import com.google.inject.Inject;
import org.openqa.selenium.WebDriver;
import org.sample.pages.EAWorldPage;

public class EAWorldHomePageImpl extends MainPageImpl {

    @Inject
    public EAWorldHomePageImpl(WebDriver driver) {
        super(driver);
    }

    @Inject
    private EAWorldPage eaWorldPage;

    public EAWorldPage getEaWorldPage() {
        return eaWorldPage;
    }
}
