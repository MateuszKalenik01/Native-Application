package com.solvd.pages.common;

import com.solvd.components.products.Product;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Random;

public abstract class CatalogPageBase extends PageBaseWithOkButton {
    private static final Logger LOGGER = LoggerFactory.getLogger(CatalogPageBase.class);

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`name == \"Catalog-screen\"`]")
    private ExtendedWebElement catalogScreen;

    @ExtendedFindBy(iosPredicate = "name == \"ProductItem\"")
    private List<Product> products;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`name == \"Button\"`]")
    private ExtendedWebElement sortButton;

    public CatalogPageBase(WebDriver driver) {
        super(driver);
        LOGGER.info("CatalogPageBase()");
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(this.catalogScreen);
    }

    private ProductPageBase openProductPage(int index) {
        products.get(index).click();
        return initPage(getDriver(), ProductPageBase.class);
    }

    public ProductPageBase openRandomProductPage() {
        LOGGER.info("openRandomProductPage()");
        Random rand = new Random();
        int index = rand.nextInt(products.size());
        LOGGER.info("openRandomProductPage(" + index + ")");
        return openProductPage(index);
    }

    public ProductPageBase addRandomProductToCart() {
        Random rand = new Random();
        int index = rand.nextInt(products.size());
        LOGGER.info("addRandomProductToCart(" + index + ")");
        return openProductPage(index);
    }

    public ExtendedWebElement rateRandomProduct() {
        Random rand = new Random();
        int index = rand.nextInt(products.size());
        LOGGER.info("rateRandomProduct(" + index + ")");
        Product product = products.get(index);
        product.submitProductRating();
        return okButton;
    }

}