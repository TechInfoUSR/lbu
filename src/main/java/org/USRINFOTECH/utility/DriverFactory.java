package org.USRINFOTECH.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import java.util.Objects;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

    private static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

    // Prevent external instantiation
    private DriverFactory() {}

    public static WebDriver initDriver(String browserName, Properties prop) {
        System.out.println("Browser name is: " + browserName);

        if (Objects.isNull(tlDriver.get())) {
            switch (browserName.toLowerCase()) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    tlDriver.set(new ChromeDriver());
                    break;

                case "edge":
                    WebDriverManager.edgedriver().setup();
                    tlDriver.set(new EdgeDriver());
                    break;

                default:
                    throw new IllegalArgumentException("Unsupported browser: " + browserName);
            }

            // Common browser settings
            WebDriver driver = tlDriver.get();
            driver.manage().deleteAllCookies();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));

            if (prop != null && prop.getProperty("url") != null) {
                driver.get(prop.getProperty("url"));
            } else {
                throw new IllegalArgumentException("URL property is missing!");
            }
        }

        return getDriver();
    }

    public static WebDriver getDriver() {
        return tlDriver.get();
    }

    public static void quitDriver() {
        if (tlDriver.get() != null) {
            tlDriver.get().quit();
            tlDriver.remove();
        }
    }
}

