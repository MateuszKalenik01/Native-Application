package com.solvd;

import com.solvd.demoapp.pages.common.*;
import com.solvd.demoapp.service.DrawingService;
import com.solvd.demoapp.service.GeoLocationService;
import com.zebrunner.agent.core.annotation.TestCaseKey;
import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class NativeTests extends AbstractTest {
    @TestCaseKey("ANDT-41")
    @Test( description = "Validate user can delete product inside cart page")
    public void validateAddingToCart() {
        CatalogBasePage catalogPage = initPage(getDriver(), CatalogBasePage.class);
        ProductBasePage productPage = catalogPage.openRandomProductPage();
        CartBasePage cartPage = productPage.addToCartAndOpenCart();

        boolean removed = cartPage.deleteItemFromCart(cartPage.getRemoveItemButtons(), cartPage.getNoItemsMessage());
        takeScreenshot();
        Assert.assertTrue(removed, "Item was not removed successfully");
    }
    @TestCaseKey("ANDT-42")
    @Test( description = "Validate user can rate product on the catalog page")
    public void validateRatingOnCatalog() {
        CatalogBasePage catalogPage = initPage(getDriver(), CatalogBasePage.class);
        ExtendedWebElement okButtonCatalog = catalogPage.rateRandomProduct();
        Assert.assertTrue(okButtonCatalog.isDisplayed(), "OK button on catalog page is not displayed");
        takeScreenshot();
        okButtonCatalog.click();
    }
    @TestCaseKey("ANDT-43")
    @Test( description = "Validate user can rate product on the product page")
    public void validateRatingOnProductPage() {
        CatalogBasePage catalogPage = initPage(getDriver(), CatalogBasePage.class);
        ProductBasePage productPage = catalogPage.openRandomProductPage();
        ExtendedWebElement okButtonProduct = productPage.rateProduct();

        Assert.assertTrue(okButtonProduct.isDisplayed(), "OK button on product page is not displayed");
        takeScreenshot();

        okButtonProduct.click();
    }
    @TestCaseKey("ANDT-44")
    @Test( description = "Validate that something is drawn on the drawing page")
    public void validateIsSomethingDrawn() {
        CatalogBasePage catalogPage = initPage(getDriver(), CatalogBasePage.class);
        MoreMenuBasePage rightMenuPage = catalogPage.getBaseMenu().clickMoreButton();
        DrawingBasePage drawingPage = rightMenuPage.clickDrawingButton();

        DrawingService drawingService = new DrawingService(getDriver());
        boolean isDrawingChanged = drawingService.isDrawingChanged(drawingPage.getDrawingBackground());
        takeScreenshot();

        Assert.assertTrue(isDrawingChanged, "The drawing was not successfully changed.");
    }
    @TestCaseKey("ANDT-45")
    @Test( description = "Validation if GeoLocation is showing correct Longitude and Latitude")
    public void validateGeoLocation() {
        GeoLocationService geoLocationService = new GeoLocationService();

        CatalogBasePage catalogPage = initPage(getDriver(), CatalogBasePage.class);
        MoreMenuBasePage moreMenuPage = catalogPage.getBaseMenu().clickMoreButton();
        GeoLocationBasePage geoLocationPage = moreMenuPage.clickGeoLocationButton();

        String expectedLatitude = R.TESTDATA.get("latitude");
        String expectedLongitude = R.TESTDATA.get("longitude");

        String actualLatitude = geoLocationService.getLatitude(geoLocationPage.getLatitudeElement());
        String actualLongitude = geoLocationService.getLongitude(geoLocationPage.getLongitudeElement());
        takeScreenshot();

        Assert.assertEquals(actualLatitude, expectedLatitude, "Latitude does not match the expected value");
        Assert.assertEquals(actualLongitude, expectedLongitude, "Longitude does not match the expected value");
    }
    @TestCaseKey("ANDT-46")
    @Test(description = "Validation if Application reset works")
    public void validateResetting() {
        CatalogBasePage catalogPage = initPage(getDriver(), CatalogBasePage.class);
        MoreMenuBasePage moreMenuPage = catalogPage.getBaseMenu().clickMoreButton();
        boolean isPageReseted = moreMenuPage.resetApplication();
        takeScreenshot();

        Assert.assertTrue(isPageReseted, "Rested Application");
    }
    @TestCaseKey("ANDT-47")
    @Test( description = "Validate sorting by name and price in both ascending and descending order")
    public void validateSorting() {
        CatalogBasePage catalogPage = initPage(getDriver(), CatalogBasePage.class);

        catalogPage.sortByNameAscending();
        takeScreenshot();

        Assert.assertTrue(catalogPage.isSortedByNameAscending(), "Products are not sorted by name in ascending order");

        catalogPage.sortByNameDescending();
        takeScreenshot();

        Assert.assertTrue(catalogPage.isSortedByNameDescending(), "Products are not sorted by name in descending order");
    }

   @TestCaseKey("ANDT-48")
   @Test(description = "Validate that user increase the quantity of a product and add it to the cart")
   public void validateIncreasingProductQuantity() throws NoSuchFieldException, IllegalAccessException {
       SoftAssert softAssert = new SoftAssert();
       
       CatalogBasePage catalogPage = initPage(getDriver(), CatalogBasePage.class);
       ProductBasePage productPage = catalogPage.openRandomProductPage();

       boolean isQuantityIncreased = productPage.updateQuantityIncrement();
       softAssert.assertTrue(isQuantityIncreased, "Quantity was not increased successfully");

       String valueOnProductPage = productPage.getQuantity().getQuantityElement().getText();

       CartBasePage cartPage = productPage.addToCartAndOpenCart();

       String valueInTheCart = cartPage.getValue();
       boolean isQuantityTheSame = valueInTheCart.equals(valueOnProductPage);
       softAssert.assertTrue(isQuantityTheSame, "Quantity in the cart is not the same as on the product page");
       takeScreenshot();

       softAssert.assertAll();

   }
    @TestCaseKey("ANDT-49")
    @Test( description = "Validate that user can redirect from application to Web Page")
    public void validateRedirectToWeb() {
        CatalogBasePage catalogPage = initPage(getDriver(), CatalogBasePage.class);
        MoreMenuBasePage moreMenuPage = catalogPage.getBaseMenu().clickMoreButton();
        AboutBasePage aboutPage = moreMenuPage.clickAboutButton();
        WebBasePage webPage = aboutPage.clickLink();

        boolean pageOpened = webPage.isPageOpened();
        takeScreenshot();

        Assert.assertTrue(pageOpened, "Redirection was unsuccessful");
    }
    @TestCaseKey("ANDT-50")
    @Test( description = "Add 2 random products with random colors to the cart and check their presence")
    public void addTwoRandomProductsWithRandomColorsToCart() {
        CatalogBasePage catalogPage = initPage(getDriver(), CatalogBasePage.class);
        List<String> addedProducts = catalogPage.addTwoRandomProductsWithRandomColorsToCart();

        CartBasePage cartPage = catalogPage.getBaseMenu().clickCartButton();
        takeScreenshot();

        Assert.assertTrue(cartPage.areProductsInCart(cartPage.getProductNames(), addedProducts), "Not all products are present in the cart");
    }
}
