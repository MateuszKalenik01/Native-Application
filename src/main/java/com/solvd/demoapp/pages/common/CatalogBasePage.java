package com.solvd.demoapp.pages.common;

import com.solvd.demoapp.components.products.ProductBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
@Getter
public abstract class CatalogBasePage extends BaseOkPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(CatalogBasePage.class);

    protected abstract ExtendedWebElement getCatalogScreen();

    protected abstract List<? extends ProductBase> getProducts();

    protected abstract ExtendedWebElement getSortButton();

    protected abstract ExtendedWebElement getSortByNameAscending();

    protected abstract ExtendedWebElement getSortByNameDescending();

    protected abstract ExtendedWebElement getSortByPriceAscending();

    protected abstract ExtendedWebElement getSortByPriceDescending();

    public CatalogBasePage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(getCatalogScreen());
    }

    private ProductBasePage openProductPage(int index) {
        getProducts().get(index).click();
        return initPage(getDriver(), ProductBasePage.class);
    }

    public ProductBasePage openRandomProductPage() {
        LOGGER.info("Open Random ProductPage");
        Random rand = new Random();
        int index = rand.nextInt(getProducts().size());
        return openProductPage(index);
    }

    public ExtendedWebElement rateRandomProduct() {
        Random rand = new Random();
        int index = rand.nextInt(getProducts().size());
        ProductBase productBase = getProducts().get(index);
        productBase.submitProductRating();
        return getOkButton();

    }

    public void sortByNameAscending() {
        LOGGER.info("Sorting by name in ascending order");
        getSortButton().click();
        getSortByNameAscending().click();
    }

    public void sortByNameDescending() {
        LOGGER.info("Sorting by name in descending order");
        getSortButton().click();
        getSortByNameDescending().click();
    }

    public void sortByPriceAscending() {
        LOGGER.info("Sorting by price in ascending order");
        getSortButton().click();
        getSortByPriceAscending().click();
    }

    public void sortByPriceDescending() {
        LOGGER.info("Sorting by price in descending order");
        getSortButton().click();
        getSortByPriceDescending().click();
    }

    public abstract List<String> getProductNames();

    public List<Double> getProductPrices() {
        return getProducts().stream().map(ProductBase::getPrice).collect(Collectors.toList());
    }

    public abstract boolean isSortedByNameAscending();

    public abstract boolean isSortedByNameDescending();

    public abstract  List<String> addTwoRandomProductsWithRandomColorsToCart();

}