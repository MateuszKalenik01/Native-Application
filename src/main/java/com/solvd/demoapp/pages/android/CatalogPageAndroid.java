package com.solvd.demoapp.pages.android;

import com.solvd.demoapp.components.menu.AndroidMenu;
import com.solvd.demoapp.components.menu.BaseMenu;
import com.solvd.demoapp.components.products.ProductBase;
import com.solvd.demoapp.components.products.android.ProductAndroid;
import com.solvd.demoapp.pages.common.CatalogBasePage;
import com.solvd.demoapp.pages.common.MoreMenuBasePage;
import com.solvd.demoapp.pages.common.ProductBasePage;
import com.solvd.demoapp.utils.Constants;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = CatalogBasePage.class)
public class CatalogPageAndroid extends CatalogBasePage {
    private static final Logger LOGGER = LoggerFactory.getLogger(CatalogPageAndroid.class);

    @FindBy(xpath = "//androidx.recyclerview.widget.RecyclerView[@content-desc='Displays all products of catalog']")
    private ExtendedWebElement catalogScreenAndroid;
    @FindBy(id = "com.saucelabs.mydemoapp.android:id/closeBt")
    private ExtendedWebElement acceptButtonAndroid;
    @FindBy(xpath = "//androidx.recyclerview.widget.RecyclerView[@content-desc='Displays all products of catalog']/android.view.ViewGroup")
    private List<ProductAndroid> productsAndroid;

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/sortIV")
    private ExtendedWebElement sortButtonAndroid;

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/nameAscCL")
    private ExtendedWebElement sortByNameAscendingAndroid;

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/nameDesCL")
    private ExtendedWebElement sortByNameDescendingAndroid;

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/priceAscCL")
    private ExtendedWebElement sortByPriceAscendingAndroid;

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/priceDesCL")
    private ExtendedWebElement sortByPriceDescendingAndroid;
    @FindBy(id="com.saucelabs.mydemoapp.android:id/socialLL")
    private ExtendedWebElement footer;

    @FindBy(id = Constants.Menu_Android)
    private AndroidMenu menu;

    public CatalogPageAndroid(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(catalogScreenAndroid);

    }

    @Override
    protected ExtendedWebElement getCatalogScreen() {
        return catalogScreenAndroid;
    }

    @Override
    protected List<ProductAndroid> getProducts() {
        return productsAndroid;
    }
    @Override
    public List<String> getProductNames() {
        return getProducts().stream().map(ProductBase::getProductName).collect(Collectors.toList());
    }
    @Override
    protected ExtendedWebElement getSortButton() {
        return sortButtonAndroid;
    }

    @Override
    protected ExtendedWebElement getSortByNameAscending() {
        return sortByNameAscendingAndroid;
    }

    @Override
    protected ExtendedWebElement getSortByNameDescending() {
        return sortByNameDescendingAndroid;
    }

    @Override
    protected ExtendedWebElement getSortByPriceAscending() {
        return sortByPriceAscendingAndroid;
    }

    @Override
    protected ExtendedWebElement getSortByPriceDescending() {
        return sortByPriceDescendingAndroid;
    }
    @Override
    public BaseMenu getBaseMenu() {
        return menu;
    }
    @Override
    protected ExtendedWebElement getOkButton(){
        return acceptButtonAndroid;
    }
    @Override
    public List<String> addTwoRandomProductsWithRandomColorsToCart() {
        List<String> addedProducts = new ArrayList<>();

        for (int i = 0; i < 2; i++) {
            ProductBasePage productPage = openRandomProductPage();
            productPage.addToCartButton().click();
            addedProducts.add(productPage.getProductName());
            BaseMenu moreMenu = getBaseMenu();
            MoreMenuBasePage moreMenuPage = moreMenu.clickMoreButton();
            moreMenuPage.clickCatalogButton();
        }

        return addedProducts;
    }

    public boolean isSortedByNameAscending() {
        swipe(footer,Direction.UP);
        List<String> productNames = new ArrayList<>();
        for (ProductAndroid product : getProducts()) {
            productNames.add(product.getProductName());
        }

        List<String> sortedNames = productNames.stream().sorted().toList();
        return productNames.equals(sortedNames);
    }

    public boolean isSortedByNameDescending() {
        swipe(footer,Direction.UP);
        List<String> productNames = new ArrayList<>();
        for (ProductAndroid product : getProducts()) {
            productNames.add(product.getProductName());
        }

        List<String> sortedNames = productNames.stream().sorted(Comparator.reverseOrder()).toList();
        return productNames.equals(sortedNames);
    }
}