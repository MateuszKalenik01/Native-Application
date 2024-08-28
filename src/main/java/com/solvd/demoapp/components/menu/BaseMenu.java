package com.solvd.demoapp.components.menu;

import com.solvd.demoapp.pages.common.CartBasePage;
import com.solvd.demoapp.pages.common.CatalogBasePage;
import com.solvd.demoapp.pages.common.MoreMenuBasePage;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import lombok.Getter;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
@Getter
public abstract class BaseMenu extends AbstractUIObject  implements IMobileUtils {

    public BaseMenu(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    protected abstract ExtendedWebElement getCartButton();
    protected abstract ExtendedWebElement getMoreButton();
    protected abstract ExtendedWebElement getCatalogButton();
    public abstract CartBasePage clickCartButton();
    public abstract CatalogBasePage clickCatalogButton();
    public abstract MoreMenuBasePage clickMoreButton();


}
