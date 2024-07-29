package com.solvd.pages.ios;

import com.solvd.pages.common.RightMenuPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = RightMenuPageBase.class)
public class RightMenuPage extends RightMenuPageBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(RightMenuPage.class);

    public RightMenuPage(WebDriver driver) {
        super(driver);
        LOGGER.info("RightMenuPage()");
    }
}