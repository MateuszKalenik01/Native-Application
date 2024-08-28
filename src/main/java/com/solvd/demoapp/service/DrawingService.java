package com.solvd.demoapp.service;

import com.zebrunner.carina.utils.factory.ICustomTypePageFactory;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;

public class DrawingService implements ICustomTypePageFactory {
    private static final Logger LOGGER = LoggerFactory.getLogger(DrawingService.class);

    private WebDriver driver;

    public DrawingService(WebDriver driver) {
        this.driver = driver;
    }
    public void drawSquare(ExtendedWebElement drawingBackground) {
        LOGGER.info("Drawing a square on the drawing canvas.");
        Actions actions = new Actions(driver);
        int startX = drawingBackground.getLocation().getX() - 100;
        int startY = drawingBackground.getLocation().getY() - 300;
        int sideLength = 100;
        LOGGER.info("Start drawing position: X={}, Y={}", startX, startY);

        WebElement canvas = drawingBackground.getElement();

        actions.moveToElement(canvas, startX, startY)
                .clickAndHold()
                .moveByOffset(sideLength, 0)  // Move right
                .moveByOffset(0, sideLength)  // Move down
                .moveByOffset(-sideLength, 0) // Move left
                .moveByOffset(0, -sideLength) // Move up
                .release()
                .perform();
    }

    public boolean isDrawingChanged(ExtendedWebElement drawingBackground) {
        LOGGER.info("Taking screenshot before drawing.");
        BufferedImage beforeImg = takeScreenshot();

        drawSquare(drawingBackground);

        LOGGER.info("Taking screenshot after drawing.");
        BufferedImage afterImg = takeScreenshot();

        return !compareImages(beforeImg, afterImg);
    }

    public void saveDrawing(ExtendedWebElement saveButton) {
        saveButton.click();
    }

    public void clearDrawing(ExtendedWebElement clearButton) {
        clearButton.click();
    }

    private BufferedImage takeScreenshot() {
        try {
            byte[] screenshotBytes = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            return ImageIO.read(new ByteArrayInputStream(screenshotBytes));
        } catch (IOException e) {
            LOGGER.error("Failed to capture the screenshot.", e);
            return null;
        }
    }

    private boolean compareImages(BufferedImage img1, BufferedImage img2) {
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
}

