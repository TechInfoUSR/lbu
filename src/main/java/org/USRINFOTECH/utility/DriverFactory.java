package org.USRINFOTECH.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {



public void SelectBrowser()
{

    WebDriver driver= new ChromeDriver();

    driver.get("https://chatgpt.com/");

}

public static void main (String args[])
{
    DriverFactory s=  new DriverFactory();
    s.SelectBrowser();
}
}
