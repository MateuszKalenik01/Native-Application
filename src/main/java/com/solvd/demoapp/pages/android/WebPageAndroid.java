package com.solvd.demoapp.pages.android;

import com.solvd.demoapp.pages.common.WebBasePage;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

    @DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = WebBasePage.class)
    public class WebPageAndroid extends WebBasePage {

        @FindBy(xpath = "//android.widget.Image[@text='Saucelabs']")
        private ExtendedWebElement banner;

        public WebPageAndroid(WebDriver driver) {
            super(driver);
            setUiLoadedMarker(banner);
        }

        @Override
        protected ExtendedWebElement getBannerElement() {
            return banner;
        }
    }