package com.lahirucw.ebayautomation.utilities;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 *
 * @author lahirucw
 */
public class WaitUtil {

    private static final WebDriverWait wait;
    private static final long DEFAULT_TIMEOUT;

    static {
        Properties config = new Properties();
        try {
            config.load(WaitUtil.class.getClassLoader().getResourceAsStream("config.properties"));
            DEFAULT_TIMEOUT = Long.parseLong(config.getProperty("waitTimeout", "10"));
        } catch (IOException | NumberFormatException e) {
            throw new RuntimeException("Failed to load config.properties", e);
        }
        wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(DEFAULT_TIMEOUT));
    }

    public static WebElement waitForVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static WebElement waitForClickable(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static WebElement waitForClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static void waitForAllVisible(By locator) {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

}
