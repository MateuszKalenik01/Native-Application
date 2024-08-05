package com.solvd.pages.common;

import com.solvd.components.products.Product;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public abstract class CatalogBasePage extends BasePage {
    private static final Logger LOGGER = LoggerFactory.getLogger(CatalogBasePage.class);

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`name == \"Catalog-screen\"`]")
    private ExtendedWebElement catalogScreen;

    @ExtendedFindBy(iosPredicate = "name == \"ProductItem\"")
    private List<Product> products;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`name == \"Button\"`]")
    private ExtendedWebElement sortButton;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`name == \"Name - Ascending\"`]")
    private ExtendedWebElement sortByNameAscending;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`name == \"Name - Descending\"`]")
    private ExtendedWebElement sortByNameDescending;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`name == \"Price - Ascending\"`]")
    private ExtendedWebElement sortByPriceAscending;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`name == \"Price - Descending\"`]")
    private ExtendedWebElement sortByPriceDescending;

    public CatalogBasePage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(catalogScreen);
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

    public void sortByNameAscending() {
        LOGGER.info("Sorting by name in ascending order");
        sortButton.click();
        sortByNameAscending.click();
    }

    public void sortByNameDescending() {
        LOGGER.info("Sorting by name in descending order");
        sortButton.click();
        sortByNameDescending.click();
    }

    public void sortByPriceAscending() {
        LOGGER.info("Sorting by price in ascending order");
        sortButton.click();
        sortByPriceAscending.click();
    }

    public void sortByPriceDescending() {
        LOGGER.info("Sorting by price in descending order");
        sortButton.click();
        sortByPriceDescending.click();
    }

    public List<String> getProductNames() {
        return products.stream().map(Product::getProductName).collect(Collectors.toList());
    }

    public List<Double> getProductPrices() {
        return products.stream().map(Product::getPrice).collect(Collectors.toList());
    }
    public boolean isSortedByNameAscending() {
        List<String> productNames = getProductNames();
        List<String> sortedNames = productNames.stream().sorted().toList();
        return productNames.equals(sortedNames);
    }

    public boolean isSortedByNameDescending() {
        List<String> productNames = getProductNames();
        List<String> sortedNames = productNames.stream().sorted(Comparator.reverseOrder()).toList();
        return productNames.equals(sortedNames);
    }

    public boolean isSortedByPriceAscending() {
        List<Double> productPrices = getProductPrices();
        List<Double> sortedPrices = productPrices.stream().sorted().toList();
        return productPrices.equals(sortedPrices);
    }

    public boolean isSortedByPriceDescending() {
        List<Double> productPrices = getProductPrices();
        List<Double> sortedPrices = productPrices.stream().sorted(Comparator.reverseOrder()).toList();
        return productPrices.equals(sortedPrices);
    }
    public List<String> addTwoRandomProductsWithRandomColorsToCart() {
        List<String> addedProducts = new ArrayList<>();

        for (int i = 0; i < 2; i++) {
            ProductBasePage productPage = openRandomProductPage();
            productPage.addToCartWithRandomColor();
            addedProducts.add(productPage.getProductName());
            navigateToCatalog();
        }

        return addedProducts;
    }
}