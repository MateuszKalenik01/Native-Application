package com.solvd.pages.common;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.Augmenter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.awt.Color;
public abstract class DrawingBasePage extends BasePage {
    private static final Logger LOGGER = LoggerFactory.getLogger(DrawingBasePage.class);

    @ExtendedFindBy(accessibilityId = "DrawingBackground Icons")
    private ExtendedWebElement drawingBackground;

    @ExtendedFindBy(accessibilityId = "SaveButton Icons")
    private ExtendedWebElement saveButton;

    @ExtendedFindBy(accessibilityId = "ClearButton Icons")
    private ExtendedWebElement clearButton;

    public DrawingBasePage(WebDriver driver) {
        super(driver);
    }
    public void drawSquare() {
        LOGGER.info("Drawing a square on the drawing canvas.");
        Actions actions = new Actions(getDriver());
        int startX = drawingBackground.getLocation().getX()-100;
        int startY = drawingBackground.getLocation().getY()-300;
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

    public boolean isDrawingChanged() {
        LOGGER.info("Taking screenshot before drawing.");
        BufferedImage beforeImg = takeScreenshot();

        drawSquare();

        LOGGER.info("Taking screenshot after drawing.");
        BufferedImage afterImg = takeScreenshot();

        return !compareImages(beforeImg, afterImg);
    }

    private BufferedImage takeScreenshot() {
        try {
            byte[] screenshotBytes = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
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
