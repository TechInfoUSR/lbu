package org.USRINFOTECH;

import org.USRINFOTECH.pageobjects.LoginPage;
import org.USRINFOTECH.utility.ConfigpropReader;
import org.USRINFOTECH.utility.ScrollHelper;
import org.USRINFOTECH.utility.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.Properties;


public class BaseTest {
    protected WebDriver driver;
    protected Properties prop;
    ConfigpropReader CR;


    @BeforeMethod
    public void setUp() {
        CR = new ConfigpropReader();
        prop=CR.initLangProp("NormalFlowTest");
        driver = DriverFactory.initDriver("chrome", prop);
        LoginPage loginPage = new LoginPage(driver);
        ScrollHelper ScrollHelper =new ScrollHelper(driver);
    }

    @AfterMethod
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}