package com.solvd.demoapp.components.products.ios;

import com.solvd.demoapp.components.products.ProductBase;
import com.solvd.demoapp.components.rating.RatingBase;
import com.solvd.demoapp.components.rating.ios.RatingIOS;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = RatingBase.class)

public class ProductIos extends ProductBase {
    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther")
    private RatingIOS ratingIOS;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeStaticText[1]")
    private ExtendedWebElement productNameElement;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`name == \"ProductItem\"`]/**/XCUIElementTypeStaticText[`name CONTAINS '$'`]")
    private ExtendedWebElement productPriceElement;
    public ProductIos(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }
    @Override
    public void submitProductRating() {

        rating().selectRandomRating();
    }

    protected RatingIOS rating() {
        return ratingIOS;
    }

    @Override
    protected ExtendedWebElement productNameElement() {
        return productNameElement;
    }

    @Override
    protected ExtendedWebElement productPriceElement() {
        return productPriceElement;
    }

}