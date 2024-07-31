package com.solvd.pages.common;

import com.solvd.components.products.Product;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Random;

public abstract class CatalogBasePage extends BasePage {
    private static final Logger LOGGER = LoggerFactory.getLogger(CatalogBasePage.class);

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`name == \"Catalog-screen\"`]")
    private ExtendedWebElement catalogScreen;

    @ExtendedFindBy(iosPredicate = "name == \"ProductItem\"")
    private List<Product> products;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`name == \"Button\"`]")
    private ExtendedWebElement sortButton;

    public CatalogBasePage(WebDriver driver) {
        super(driver);
    }

    private ProductBasePage openProductPage(int index) {
        products.get(index).click();
        return initPage(getDriver(), ProductBasePage.class);
    }

    public ProductBasePage openRandomProductPage() {
        LOGGER.info("Open Random ProductPage");
        Random rand = new Random();
        int index = rand.nextInt(products.size());
        return openProductPage(index);
    }

    public ExtendedWebElement rateRandomProduct() {
        Random rand = new Random();
        int index = rand.nextInt(products.size());
        Product product = products.get(index);
        product.submitProductRating();
        return acceptButton;
    }

}