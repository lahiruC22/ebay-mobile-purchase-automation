package com.lahirucw.ebayautomation.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 *
 * @author lahirucw
 */
public class WebDriverFactory {
    
    public static WebDriver createDriver(String browser){
        
        if(browser.equalsIgnoreCase("firefox")){
            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver();
            
        } /**else if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            return new FirefoxDriver();
            
        }**/ else {
            throw new IllegalArgumentException("Unsupported browser: " + browser);
        }
    }
}
