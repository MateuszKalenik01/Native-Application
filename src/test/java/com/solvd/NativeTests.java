package com.solvd;

import com.solvd.pages.common.*;
import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.testng.Assert;

import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class NativeTests extends AbstractTest {

    @Test(testName = "#TC001", description = "Validate that not logged user can add product to the cart and delete it")
    public void validateAddingToCart() {
        CatalogBasePage catalogPage = initPage(getDriver(), CatalogBasePage.class);
        ProductBasePage productPage = catalogPage.openRandomProductPage();
        CartBasePage cartPage = productPage.addToCartAndOpenCart();

        boolean removed = cartPage.deleteRandomItemFromCart();
        assertTrue(removed, "Item was not removed successfully");
    }

    @Test(testName = "#TC002", description = "Validate that not logged user can rate product on the catalog page")
    public void validateRatingOnCatalog() {
        CatalogBasePage catalogPage = initPage(getDriver(), CatalogBasePage.class);
        ExtendedWebElement okButtonCatalog = catalogPage.rateRandomProduct();

        assertTrue(okButtonCatalog.isDisplayed(), "OK button on catalog page is not displayed");

        okButtonCatalog.click();
    }

    @Test(testName = "#TC003", description = "Validate that not logged user can rate product on the product page")
    public void validateRatingOnProductPage() {
        CatalogBasePage catalogPage = initPage(getDriver(), CatalogBasePage.class);
        ProductBasePage productPage = catalogPage.openRandomProductPage();
        ExtendedWebElement okButtonProduct = productPage.rateProduct();

        assertTrue(okButtonProduct.isDisplayed(), "OK button on product page is not displayed");

        okButtonProduct.click();
    }

    @Test(testName = "#TC004", description = "Validate that a square is drawn on the drawing page")
    public void validateSquareDrawing() {
        CatalogBasePage catalogPage = initPage(getDriver(), CatalogBasePage.class);
        MoreMenuBasePage rightMenuPage = catalogPage.navigateToMore();
        DrawingBasePage drawingPage = rightMenuPage.clickDrawingButton();

        drawingPage.drawSquare();
        boolean isSquareDrawn = drawingPage.isSquareDrawn();

        Assert.assertTrue(isSquareDrawn, "The square was not drawn successfully.");
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
}
