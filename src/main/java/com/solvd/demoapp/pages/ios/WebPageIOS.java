package com.solvd.demoapp.pages.ios;

import com.solvd.demoapp.pages.common.WebBasePage;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = WebBasePage.class)
public class WebPageIOS extends WebBasePage {

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`name == \"banner\"`]")
    private ExtendedWebElement banner;

    public WebPageIOS(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(banner);
    }

    @Override
    protected ExtendedWebElement getBannerElement() {
        return banner;
    }

}
