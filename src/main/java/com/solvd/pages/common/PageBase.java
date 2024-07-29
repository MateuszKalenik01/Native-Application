package com.solvd.pages.common;

import com.zebrunner.carina.utils.ios.IOSUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class PageBase extends AbstractPage implements IOSUtils {
    private static final Logger LOGGER = LoggerFactory.getLogger(PageBase.class);

    @ExtendedFindBy(accessibilityId = "Catalog-tab-item")
    private ExtendedWebElement catalogButton;

    @ExtendedFindBy(accessibilityId = "Cart-tab-item")
    private ExtendedWebElement cartButton;

    @ExtendedFindBy(accessibilityId = "More-tab-item")
    private ExtendedWebElement moreButton;

    public PageBase(WebDriver driver) {
        super(driver);
    }

    public CatalogPageBase navigateToCatalog() {
        LOGGER.info("navigateToCatalog()");
        catalogButton.click();
        return initPage(getDriver(), CatalogPageBase.class);
    }

    public CartPageBase navigateToCart() {
        LOGGER.info("navigateToCart()");
        cartButton.click();
        return initPage(getDriver(), CartPageBase.class);
    }

    public RightMenuPageBase navigateToMore() {
        LOGGER.info("navigateToMore()");
        moreButton.click();
        return initPage(getDriver(), RightMenuPageBase.class);
    }
}
