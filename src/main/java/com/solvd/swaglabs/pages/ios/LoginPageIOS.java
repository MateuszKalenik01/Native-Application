package com.solvd.swaglabs.pages.ios;


import com.solvd.swaglabs.pages.common.LoginBasePage;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@Getter
@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = LoginBasePage.class)
public class LoginPageIOS extends LoginBasePage {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoginPageIOS.class);

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeTextField")
    private ExtendedWebElement username;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeSecureTextField")
    private ExtendedWebElement password;

    @ExtendedFindBy(iosPredicate = "name == \"test-LOGIN\"")
    private ExtendedWebElement loginButton;


    public LoginPageIOS(WebDriver driver) {
        super(driver);
    }


}