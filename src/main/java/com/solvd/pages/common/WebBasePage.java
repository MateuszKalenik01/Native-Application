package com.solvd.pages.common;

import com.zebrunner.carina.utils.ios.IOSUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;

public class WebBasePage extends AbstractPage implements IOSUtils {
    @ExtendedFindBy(iosClassChain="**/XCUIElementTypeOther[`name == \"banner\"`]")
    private ExtendedWebElement baner;
    public WebBasePage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(baner);
    }
}
