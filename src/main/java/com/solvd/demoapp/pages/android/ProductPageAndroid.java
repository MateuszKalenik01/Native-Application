package com.solvd.demoapp.pages.android;

import com.solvd.demoapp.components.menu.AndroidMenu;
import com.solvd.demoapp.components.menu.BaseMenu;
import com.solvd.demoapp.components.quantity.QuantityAndroid;
import com.solvd.demoapp.components.rating.android.RatingAndroid;
import com.solvd.demoapp.pages.common.ProductBasePage;
import com.solvd.demoapp.utils.Constants;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import lombok.Getter;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Random;
@Getter
@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ProductBasePage.class)
public class ProductPageAndroid extends ProductBasePage {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductPageAndroid.class);
    @FindBy(id = "com.saucelabs.mydemoapp.android:id/cartBt")
    private ExtendedWebElement addToCartButton;
    @FindBy(id = "com.saucelabs.mydemoapp.android:id/closeBt")
    private ExtendedWebElement acceptButtonAndroid;

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/priceTV")
    private ExtendedWebElement price;

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/rattingV")
    private RatingAndroid rating;

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/colorRV")
    private ExtendedWebElement colorContainer;
    @FindBy(xpath = "//android.widget.LinearLayout[@resource-id=\"com.saucelabs.mydemoapp.android:id/addToCartLL\"]")
    private QuantityAndroid quantity;
    @FindBy(xpath = "//androidx.recyclerview.widget.RecyclerView[@content-desc='Displays available colors of selected product']//android.view.ViewGroup//android.widget.ImageView[contains(@content-desc, ' color')]")
    private List<ExtendedWebElement> colorOptions;

    @FindBy(id = Constants.Menu_Android)
    private AndroidMenu menu;

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/productTV")
    private ExtendedWebElement productNameElement;
    public ProductPageAndroid(WebDriver driver) {
        super(driver);
    }
    @Override
    public ExtendedWebElement addToCartButton() {
        return addToCartButton;
    }

    @Override
    protected ExtendedWebElement price() {
        return price;
    }

    @Override
    protected RatingAndroid rating() {
        return rating;
    }

    @Override
    protected ExtendedWebElement colorContainer() {
        return colorContainer;
    }

    @Override
    protected List<ExtendedWebElement> colorOptions() {
        return colorOptions;
    }

    @Override
    protected ExtendedWebElement productNameElement() {
        return productNameElement;
    }
    @Override
    public BaseMenu getBaseMenu() {
        return menu;
    }
    @Override
    public void clickBackButton() {
       return;
    }
    @Override
    protected ExtendedWebElement getOkButton(){
        return acceptButtonAndroid;
    }

    public BufferedImage takeScreenshotOfSelectedColor() {
        ExtendedWebElement selectedColorElement = getRandomColor();
        return takeScreenshot(selectedColorElement);
    }

    private BufferedImage takeScreenshot(ExtendedWebElement element) {
        try {
            byte[] screenshotBytes = element.getScreenshotAs(OutputType.BYTES);
            return ImageIO.read(new ByteArrayInputStream(screenshotBytes));
        } catch (IOException e) {
            LOGGER.error("Failed to capture the screenshot.", e);
            return null;
        }
    }
    @Override
    public boolean updateQuantityIncrement() {
        LOGGER.info("incrementRandomQuantity()");
        int incrementValue = new Random().nextInt(4) + 1;
        return getQuantity().incrementQuantity(incrementValue);
    }
    @Override
    public boolean updateQuantityDecrement() {
        LOGGER.info("decrementRandomQuantity()");
        int currentQuantity = Integer.parseInt(getQuantity().getQuantityElement().getText());

        if (currentQuantity > 0) {
            int decrementValue = new Random().nextInt(currentQuantity) + 1;
            return getQuantity().decrementQuantity(decrementValue);
        } else {
            LOGGER.info("Cannot decrement quantity below zero.");
            return false;
        }
    }
}