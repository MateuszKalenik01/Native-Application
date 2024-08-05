package com.solvd;

import com.solvd.pages.common.*;
import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.testng.Assert;

import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertTrue;

public class NativeTests extends AbstractTest {

    @Test(testName = "#TC001", description = "Validate user can delete random product inside cart page")
    public void validateAddingToCart() {
        CatalogBasePage catalogPage = initPage(getDriver(), CatalogBasePage.class);
        ProductBasePage productPage = catalogPage.openRandomProductPage();
        CartBasePage cartPage = productPage.addToCartAndOpenCart();

        boolean removed = cartPage.deleteRandomItemFromCart();
        assertTrue(removed, "Item was not removed successfully");
    }

    @Test(testName = "#TC002", description = "Validate user can rate product on the catalog page")
    public void validateRatingOnCatalog() {
        CatalogBasePage catalogPage = initPage(getDriver(), CatalogBasePage.class);
        ExtendedWebElement okButtonCatalog = catalogPage.rateRandomProduct();

        assertTrue(okButtonCatalog.isDisplayed(), "OK button on catalog page is not displayed");

        okButtonCatalog.click();
    }

    @Test(testName = "#TC003", description = "Validate user can rate product on the product page")
    public void validateRatingOnProductPage() {
        CatalogBasePage catalogPage = initPage(getDriver(), CatalogBasePage.class);
        ProductBasePage productPage = catalogPage.openRandomProductPage();
        ExtendedWebElement okButtonProduct = productPage.rateProduct();

        assertTrue(okButtonProduct.isDisplayed(), "OK button on product page is not displayed");

        okButtonProduct.click();
    }

    @Test(testName = "#TC004", description = "Validate that something is drawn on the drawing page")
    public void validateIsSomethingDrawn() {
        CatalogBasePage catalogPage = initPage(getDriver(), CatalogBasePage.class);
        MoreMenuBasePage rightMenuPage = catalogPage.navigateToMore();
        DrawingBasePage drawingPage = rightMenuPage.clickDrawingButton();

        boolean isDrawingChanged = drawingPage.isDrawingChanged();

        Assert.assertTrue(isDrawingChanged, "The drawing was not successfully changed.");
    }

    @Test(testName = "TC005", description = "Validation if GeoLocation is showing correct Longitude and Latitude")
    public void validateGeoLocation() {

        CatalogBasePage catalogPage = initPage(getDriver(), CatalogBasePage.class);
        MoreMenuBasePage moreMenuPage = catalogPage.navigateToMore();
        GeoLocationBasePage geoLocationPage = moreMenuPage.clickGeoLocationButton();

        String expectedLatitude = R.TESTDATA.get("latitude");
        String expectedLongitude = R.TESTDATA.get("longitude");


        geoLocationPage.validateGeoLocation(expectedLatitude, expectedLongitude);
    }
    @Test(testName = "#TC006", description = "Validation if Application reset works")
    public void validateResetting(){
        CatalogBasePage catalogPage = initPage(getDriver(), CatalogBasePage.class);
        MoreMenuBasePage moreMenuPage = catalogPage.navigateToMore();
        MoreMenuBasePage resetPage = moreMenuPage.resetApplication();
        boolean pageOpened = resetPage.isPageOpened();
        assertTrue(pageOpened, "Rested Application");
    }
    @Test(testName = "#TC007", description = "Validate sorting by name and price in both ascending and descending order")
    public void validateSorting() {
        CatalogBasePage catalogPage = initPage(getDriver(), CatalogBasePage.class);

        // Validate sorting by name ascending
        catalogPage.sortByNameAscending();
        assertTrue(catalogPage.isSortedByNameAscending(), "Products are not sorted by name in ascending order");

        // Validate sorting by name descending
        catalogPage.sortByNameDescending();
        assertTrue(catalogPage.isSortedByNameDescending(), "Products are not sorted by name in descending order");
    }
    @Test(testName = "#TC008", description = "Add random product with random color to the cart")
    public void addRandomProductWithRandomColorToCart() {
        CatalogBasePage catalogPage = initPage(getDriver(), CatalogBasePage.class);
        ProductBasePage productPage = catalogPage.openRandomProductPage();

        productPage.addToCartWithRandomColor();
        String selectedColor = productPage.getSelectedColor();
        CartBasePage cartPage = productPage.navigateToCart();

        assertTrue(cartPage.isProductAddedToCartWithCorrectColor(selectedColor), "Product color in the cart does not match the selected color");
    }
    @Test(testName = "#TC009", description ="Validate that user can redirect from application to Web Page")
    public void validateRedirectToWeb() {
        CatalogBasePage catalogPage = initPage(getDriver(), CatalogBasePage.class);
        MoreMenuBasePage moreMenuPage = catalogPage.navigateToMore();
        AboutBasePage aboutPage= moreMenuPage.clickAboutButton();
        WebBasePage webPage= aboutPage.clickLink();
        boolean pageOpened = webPage.isPageOpened();
        assertTrue(pageOpened,"Redirection was unsuccessful");

    }
    @Test(testName = "#TC010", description = "Add 2 random products with random colors to the cart and check their presence")
    public void addTwoRandomProductsWithRandomColorsToCart() {
        CatalogBasePage catalogPage = initPage(getDriver(), CatalogBasePage.class);
        List<String> addedProducts = catalogPage.addTwoRandomProductsWithRandomColorsToCart();

        CartBasePage cartPage = catalogPage.navigateToCart();
        assertTrue(cartPage.areProductsInCart(addedProducts), "Not all products are present in the cart");
    }
}
