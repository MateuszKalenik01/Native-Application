package com.solvd.demoapp.components.menu;

import com.solvd.demoapp.pages.common.CartBasePage;
import com.solvd.demoapp.pages.common.CatalogBasePage;
import com.solvd.demoapp.pages.common.MoreMenuBasePage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import lombok.Getter;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
@Getter
public class AndroidMenu extends BaseMenu{
    @FindBy(id = "com.saucelabs.mydemoapp.android:id/cartIV")
    private ExtendedWebElement cartButtonAndroid;

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/menuIV")
    private ExtendedWebElement moreButtonAndroid;

    public AndroidMenu(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }
    @Override
    protected ExtendedWebElement getCartButton() {
        return cartButtonAndroid;
    }

    @Override
    protected ExtendedWebElement getMoreButton() {
        return moreButtonAndroid;
    }

    @Override
    protected ExtendedWebElement getCatalogButton() {
        return null;
    }

    public CartBasePage clickCartButton() {
        cartButtonAndroid.click();
        return initPage(getDriver(), CartBasePage.class);
    }

    @Override
    public CatalogBasePage clickCatalogButton() {
        return null;
    }

    @Override
    public MoreMenuBasePage clickMoreButton() {
        moreButtonAndroid.click();
        return initPage(getDriver(), MoreMenuBasePage.class);
    }

}
