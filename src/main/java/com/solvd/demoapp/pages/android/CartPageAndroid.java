package com.solvd.demoapp.pages.android;

import com.solvd.demoapp.components.menu.AndroidMenu;
import com.solvd.demoapp.components.menu.BaseMenu;
import com.solvd.demoapp.pages.common.CartBasePage;
import com.solvd.demoapp.utils.Constants;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = CartBasePage.class)
public class CartPageAndroid extends CartBasePage {
    private static final Logger LOGGER = LoggerFactory.getLogger(CartPageAndroid.class);

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/shoppingBt")
    private ExtendedWebElement goShoppingButtonAndroid;

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/noItemTitleTV")
    private ExtendedWebElement noItemsMessageAndroid;

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/scrollView")
    private ExtendedWebElement cartScreenAndroid;

    @FindBy(xpath = "//android.widget.TextView[@content-desc='Removes product from cart']")
    private List<ExtendedWebElement> removeItemButtonsAndroid;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.saucelabs.mydemoapp.android:id/titleTV']")
    private List<ExtendedWebElement> productNamesAndroid;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.saucelabs.mydemoapp.android:id/priceTV']")
    private ExtendedWebElement valueAndroid;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.saucelabs.mydemoapp.android:id/colorTV'][1]")
    private ExtendedWebElement productColorsAndroid;

    @FindBy(id = Constants.Menu_Android)
    private AndroidMenu menu;

    public CartPageAndroid(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(goShoppingButtonAndroid);
    }

    @Override
    protected ExtendedWebElement getGoShoppingButton() {
        return goShoppingButtonAndroid;
    }

    @Override
    public ExtendedWebElement getNoItemsMessage() {
        return noItemsMessageAndroid;
    }

    @Override
    protected ExtendedWebElement getCartScreen() {
        return cartScreenAndroid;
    }

    @Override
    public List<ExtendedWebElement> getRemoveItemButtons() {
        return removeItemButtonsAndroid;
    }
    @FindBy(id = "com.saucelabs.mydemoapp.android:id/noTV")
    private ExtendedWebElement value;
    @Override
    protected ExtendedWebElement getPlusButton() {
        return null;
    }

    @Override
    protected ExtendedWebElement getMinusButton() {
        return null;
    }

    @Override
    protected ExtendedWebElement getPrice() {
        return valueAndroid;
    }

    @Override
    public ExtendedWebElement getAddedProductColor() {
        return productColorsAndroid;
    }

    @Override
    public List<ExtendedWebElement> getProductNames() {
        return productNamesAndroid;
    }
    @Override
    public BaseMenu getBaseMenu() {
        return menu;
    }

    public boolean isProductAddedWithCorrectColor(ExtendedWebElement addedProductColor, ExtendedWebElement productPageColor) {
        BufferedImage cartColorIcon = takeScreenshot(addedProductColor);
        BufferedImage productPageColorIcon = takeScreenshot(productPageColor);

        return compareImages(cartColorIcon, productPageColorIcon);
    }

    private BufferedImage takeScreenshot(ExtendedWebElement element) {
        try {
            byte[] screenshotBytes = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
            return ImageIO.read(new ByteArrayInputStream(screenshotBytes));
        } catch (IOException e) {
            LOGGER.error("Failed to capture the screenshot.", e);
            return null;
        }
    }

    private boolean compareImages(BufferedImage img1, BufferedImage img2) {
        if (img1 == null || img2 == null) {
            return false;
        }

        if (img1.getWidth() != img2.getWidth() || img1.getHeight() != img2.getHeight()) {
            return false;
        }

        for (int y = 0; y < img1.getHeight(); y++) {
            for (int x = 0; x < img1.getWidth(); x++) {
                if (img1.getRGB(x, y) != img2.getRGB(x, y)) {
                    return false;
                }
            }
        }
        return true;
    }
    public boolean isProductAddedWithCorrectColor(ExtendedWebElement addedProductColor, String expectedColor) {
        String actualColor = addedProductColor.getText();
        LOGGER.info("Expected color: " + expectedColor + ", Actual color: " + actualColor);
        return actualColor.equalsIgnoreCase(expectedColor);
    }
    @Override
    public String getValue() {
        return value.getText();
    }
}