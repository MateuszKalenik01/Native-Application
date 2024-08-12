package com.solvd.demoapp.components.menu;

import com.solvd.demoapp.pages.common.CartBasePage;
import com.solvd.demoapp.pages.common.CatalogBasePage;
import com.solvd.demoapp.pages.common.MoreMenuBasePage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import lombok.Getter;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
@Getter
public class IOSMenu extends BaseMenu {
    @ExtendedFindBy(accessibilityId = "Cart-tab-item")
    private ExtendedWebElement cartButtonIOS;

    @ExtendedFindBy(accessibilityId = "More-tab-item")
    private ExtendedWebElement moreButtonIOS;



    @ExtendedFindBy(accessibilityId = "Catalog-tab-item")
    private ExtendedWebElement catalogButtonIOS;

    public IOSMenu(WebDriver driver,SearchContext searchContext) {

        super(driver, searchContext);
    }
    public CatalogBasePage navigateToCatalog() {
        catalogButtonIOS.click();
        return initPage(getDriver(), CatalogBasePage.class);
    }
    @Override
    protected ExtendedWebElement getCartButton() {
        return cartButtonIOS;
    }

    @Override
    protected ExtendedWebElement getMoreButton() {
        return moreButtonIOS;
    }

    @Override
    protected ExtendedWebElement getCatalogButton() {
        return catalogButtonIOS;
    }
    @Override
    public CartBasePage clickCartButton() {
        cartButtonIOS.click();
        return initPage(getDriver(), CartBasePage.class);
    }

    @Override
    public CatalogBasePage clickCatalogButton() {
        catalogButtonIOS.click();
        return initPage(getDriver(), CatalogBasePage.class);
    }

    @Override
    public MoreMenuBasePage clickMoreButton() {
        moreButtonIOS.click();
        return initPage(getDriver(), MoreMenuBasePage.class);
    }


}
