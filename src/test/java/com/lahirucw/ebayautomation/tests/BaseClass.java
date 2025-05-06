package com.lahirucw.ebayautomation.tests;

import com.lahirucw.ebayautomation.utilities.DriverManager;
import com.lahirucw.ebayautomation.utilities.LoggerUtil;
import com.lahirucw.ebayautomation.utilities.WebDriverFactory;
import java.io.IOException;
import java.util.Properties;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

/**
 *
 * @author lahirucw
 */
public class BaseClass {
    private Properties config;

    @Parameters("browser")
    @BeforeMethod
    public void setup(String browser) throws IOException {
        config = new Properties();
        config.load(getClass().getClassLoader().getResourceAsStream("config.properties"));
        WebDriverFactory.createDriver(browser);
        DriverManager.getDriver().manage().window().maximize();
        DriverManager.getDriver().get(config.getProperty("baseUrl"));
        LoggerUtil.info("Browser initialized: " + browser);
    }

    @AfterMethod
    public void tearDown() {
        DriverManager.quitDriver();
        LoggerUtil.info("Browser closed");
    }
}
