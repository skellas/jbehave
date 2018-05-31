package com.skellas.selenium;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class EdgeExample {

    public static final String WEBDRIVER_PROPERTY_NAME = "webdriver.ie.driver";
    public static final String DRIVER_PATH_NAME = "C:/tools/selenium-drivers/ie/";
    public static final String DRIVER_FILE_NAME = "MicrosoftWebDriver.exe";
    public static WebDriver driver;

    @Before
    public void setUp() {
        System.out.println("Launching Edge Browser");
        System.setProperty(WEBDRIVER_PROPERTY_NAME, DRIVER_PATH_NAME + DRIVER_FILE_NAME);
        driver = new InternetExplorerDriver();
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        if (null != driver) {
            System.out.println("Closing Browser");
            driver.quit();
        }
    }

    @Test
    public void testBrowserOpening() {
        driver.navigate().to("http://google.com");
    }

    @Test
    public void testGooglePageTitleInIEBrowser() {
        driver.navigate().to("http://www.google.com");
        String strPageTitle = driver.getTitle();
        System.out.println("Page title: - "+strPageTitle);
        Assert.assertTrue("Page title doesn't match", strPageTitle.equalsIgnoreCase("Google"));
    }

    @Test
    public void badAddressWillReturnAServerError() {
        driver.navigate().to("http://alskfjasldfkjaslfj.com/");
        Assert.assertTrue("This will return a server error",
                ((InternetExplorerDriver) driver).getErrorHandler().isIncludeServerErrors());
    }
}
