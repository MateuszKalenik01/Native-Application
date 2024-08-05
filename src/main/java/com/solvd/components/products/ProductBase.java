package com.solvd.components.products;

import com.solvd.components.rating.Rating;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public abstract class ProductBase extends AbstractUIObject {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductBase.class);

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther")
    private Rating rating;
    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeStaticText[1]")
    private ExtendedWebElement productNameElement;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`name == \"ProductItem\"`]/**/XCUIElementTypeStaticText[`name CONTAINS '$'`]")
    private ExtendedWebElement productPriceElement;

    public ProductBase(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void submitProductRating() {
        LOGGER.info("rateProduct()");
        rating.selectRandomRating();
    }
    public String getProductName() {
        return productNameElement.getText();
    }

    public Double getPrice() {
        return Double.valueOf(productPriceElement.getText().replace("$", ""));
    }
}