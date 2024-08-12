package com.solvd;

import com.solvd.swaglabs.pages.common.LoginBasePage;
import com.zebrunner.carina.utils.R;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.zebrunner.carina.utils.resources.L10N;

public class LocalizationTest extends AbstractTest {
    @Test
    public void validateGermanLanguage(){
        R.CONFIG.put("locale", "de_DE");
        L10N.setLocale(R.CONFIG.get("locale"));
        L10N.load();

        SoftAssert softAssert = new SoftAssert();

        LoginBasePage loginPage = initPage(getDriver(), LoginBasePage.class);
        String usernameFieldText = loginPage.getUsername().getAttribute("value");
        softAssert.assertEquals(usernameFieldText, L10N.getText("LoginPage.getUsername.text"), "Incorrect language in username field!");
        String passwordFieldText = loginPage.getPassword().getAttribute("value");
        softAssert.assertEquals(passwordFieldText, L10N.getText("LoginPage.getPassword.text"), "Incorrect language in password field!");
      //  takeScreenshot();
        softAssert.assertAll();

    }}
