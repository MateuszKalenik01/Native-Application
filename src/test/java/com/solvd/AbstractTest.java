package com.solvd;

import com.zebrunner.carina.core.IAbstractTest;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;

public abstract class AbstractTest implements IAbstractTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractTest.class);

    private WebDriver driver;

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
    public void takeScreenshot(){
        LOGGER.info("Screenshot");
        try{
            byte[] screenshotBytes = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
            long capturedAtMillis = System.currentTimeMillis();
            com.zebrunner.agent.core.registrar.Screenshot.upload(screenshotBytes, capturedAtMillis);
        } catch (Exception e) {
            LOGGER.error("Failed to take screenshot");
        }
    }
}