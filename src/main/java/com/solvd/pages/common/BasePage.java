package com.solvd.pages.common;

import com.zebrunner.carina.utils.ios.IOSUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class BasePage extends AbstractPage implements IOSUtils {
    private static final Logger LOGGER = LoggerFactory.getLogger(BasePage.class);

    @ExtendedFindBy(accessibilityId = "Catalog-tab-item")
    private ExtendedWebElement catalogButton;

    @ExtendedFindBy(accessibilityId = "Cart-tab-item")
    private ExtendedWebElement cartButton;

    @ExtendedFindBy(accessibilityId = "More-tab-item")
    private ExtendedWebElement moreButton;
    @ExtendedFindBy(accessibilityId = "OK")
    protected ExtendedWebElement acceptButton;
    public BasePage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(catalogButton);
    }

    public CatalogBasePage navigateToCatalog() {
        catalogButton.click();
        return initPage(getDriver(), CatalogBasePage.class);
    }

    public CartBasePage navigateToCart() {
        cartButton.click();
        return initPage(getDriver(), CartBasePage.class);
    }

    public MoreMenuBasePage navigateToMore() {
        moreButton.click();
        return initPage(getDriver(), MoreMenuBasePage.class);
    }
}
