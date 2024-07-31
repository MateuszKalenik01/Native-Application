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

    public boolean isSquareDrawn() {
        LOGGER.info("Verifying if the square is drawn.");
        boolean squareDetected = false;
        try {
            WebDriver augmentedDriver = new Augmenter().augment(getDriver());
            File screenshot = ((TakesScreenshot) augmentedDriver).getScreenshotAs(OutputType.FILE);
            BufferedImage fullImg = ImageIO.read(screenshot);

            Point point = drawingBackground.getLocation();

            int eleWidth = drawingBackground.getSize().getWidth();
            int eleHeight = drawingBackground.getSize().getHeight();

            BufferedImage eleScreenshot = fullImg.getSubimage(point.getX(), point.getY(), eleWidth, eleHeight);

            ImageIO.write(eleScreenshot, "png", new File("drawingBoardScreenshot.png"));

            squareDetected = isSquareInImage(eleScreenshot);
        } catch (IOException e) {
            LOGGER.error("Failed to capture or process the screenshot.", e);
        }
        return squareDetected;
    }

    private boolean isSquareInImage(BufferedImage image) {
        int startX = -84;
        int startY = -112;
        int sideLength = 100;
        int blackRGB = Color.GREEN.getRGB();
        int tolerance = 100;
        int pixelChangeThreshold = 100;

        int changedPixels = 0;

        LOGGER.info("Checking pixel density for square detection.");
        for (int x = startX; x < startX + sideLength; x++) {
            for (int y = startY; y < startY + sideLength; y++) {
                int pixelColor = image.getRGB(x, y);
                if (isColorCloseToBlack(pixelColor, tolerance)) {
                    changedPixels++;
                }
            }
        }

        LOGGER.info("Changed pixels: {}", changedPixels);
        return changedPixels > pixelChangeThreshold;
    }

    private boolean isColorCloseToBlack(int rgb, int tolerance) {
        Color color = new Color(rgb);
        int red = color.getRed();
        int green = color.getGreen();
        int blue = color.getBlue();
        return (red <= tolerance && green <= tolerance && blue <= tolerance);
    }
}
