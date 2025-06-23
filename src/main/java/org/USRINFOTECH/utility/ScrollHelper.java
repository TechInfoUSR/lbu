package org.USRINFOTECH.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class ScrollHelper {
    WebDriver driver;
    public ScrollHelper(WebDriver driver) {
        this.driver =driver;
    }


    // Utility method
    public void scroll(int x, int y) {
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(arguments[0], arguments[1])", x, y);
    }

    public static void scrollUntilElementVisible(WebDriver driver, WebElement element) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView(true);", element);
        }


}
