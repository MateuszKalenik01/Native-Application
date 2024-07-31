package com.solvd.pages.android;

import com.solvd.pages.common.MoreMenuBasePage;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = MoreMenuBasePage.class)
public class MoreMenuPage extends MoreMenuBasePage {
    private static final Logger LOGGER = LoggerFactory.getLogger(MoreMenuPage.class);

    public MoreMenuPage(WebDriver driver) {
        super(driver);
        LOGGER.info("RightMenuPage()");
    }
}