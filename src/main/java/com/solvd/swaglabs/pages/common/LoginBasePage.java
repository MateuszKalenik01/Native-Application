package com.solvd.swaglabs.pages.common;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class LoginBasePage extends AbstractPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoginBasePage.class);

    //@ExtendedFindBy(iosClassChain = "**/XCUIElementTypeTextField")
    public abstract ExtendedWebElement getUsername();

  //  @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeSecureTextField")
    public abstract ExtendedWebElement getPassword();

   // @ExtendedFindBy(iosPredicate = "name == \"test-LOGIN\"")
     public abstract ExtendedWebElement getLoginButton();

    public LoginBasePage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(getLoginButton());
    }
}
