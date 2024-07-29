package com.solvd;

import com.solvd.pages.common.CartPageBase;
import com.solvd.pages.common.CatalogPageBase;
import com.solvd.pages.common.ProductPageBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.testng.annotations.Test;

import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

public class OpenAppTest extends AbstractTest {

    @Test(testName = "#TC001", description = "Validate that not logged user can add product to the cart and delete it")
    public void validateAddingToCart() {
        CatalogPageBase catalogPage = initPage(getDriver(), CatalogPageBase.class);
        ProductPageBase productPage = catalogPage.addRandomProductToCart();
        CartPageBase cartPage = productPage.addToCartAndOpenCart();

        boolean removed = cartPage.deleteRandomItemFromCart();
        assertTrue(removed, "Item was not removed successfully");
    }

    @Test(testName = "#TC002", description = "Validate that not logged user can rate product on the catalog page")
    public void validateRatingOnCatalog() {
        CatalogPageBase catalogPage = initPage(getDriver(), CatalogPageBase.class);
        ExtendedWebElement okButtonCatalog = catalogPage.rateRandomProduct();

        assertTrue(okButtonCatalog.isDisplayed(), "OK button on catalog page is not displayed");

        okButtonCatalog.click();
    }

    @Test(testName = "#TC003", description = "Validate that not logged user can rate product on the product page")
    public void validateRatingOnProductPage() {
        CatalogPageBase catalogPage = initPage(getDriver(), CatalogPageBase.class);
        ProductPageBase productPage = catalogPage.openRandomProductPage();
        ExtendedWebElement okButtonProduct = productPage.rateProduct();

        assertTrue(okButtonProduct.isDisplayed(), "OK button on product page is not displayed");

        okButtonProduct.click();
    }

    @Test(testName = "#TC004", description = "Validate that not logged user can add product to the cart")
    public void validateAddingProductToCartWithoutLoggingIn() {
        CatalogPageBase catalogPage = initPage(getDriver(), CatalogPageBase.class);
        ProductPageBase productPage = catalogPage.addRandomProductToCart();

        assertNotNull(productPage, "Product was not added to cart successfully");
    }
}