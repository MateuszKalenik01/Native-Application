package com.solvd.swaglabs.pages.android;

import com.solvd.swaglabs.pages.common.CatalogBasePage;
import com.solvd.swaglabs.pages.common.LoginBasePage;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@Getter
@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = LoginBasePage.class)
public class LoginPageAndroid extends LoginBasePage {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoginPageAndroid.class);
    @ExtendedFindBy(accessibilityId="test-Username")
    private ExtendedWebElement username;
    @ExtendedFindBy(accessibilityId = "test-Password")
    private ExtendedWebElement password;
    @ExtendedFindBy(accessibilityId = "test-LOGIN")
    private ExtendedWebElement loginButton;
    public LoginPageAndroid(WebDriver driver) {
        super(driver);
    }
}