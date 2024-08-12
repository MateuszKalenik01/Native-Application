package com.solvd.demoapp.components.products;

import com.solvd.demoapp.components.rating.RatingBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class ProductBase extends AbstractUIObject {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductBase.class);

    protected abstract RatingBase rating();
    protected abstract ExtendedWebElement productNameElement();
    protected abstract ExtendedWebElement productPriceElement();

    public ProductBase(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public abstract void submitProductRating();

    public String getProductName() {
        return productNameElement().getText();
    }

    public Double getPrice() {
        return Double.valueOf(productPriceElement().getText().replace("$", "").trim());
    }
}