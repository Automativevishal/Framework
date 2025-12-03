package com.Utility;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

    public static WebDriver driver;
    public static ConfigDataProvider config;
    public static ExelDataProvider exel;

    @BeforeSuite
    public void initializationSetup() {
        try {
            config = new ConfigDataProvider();
            exel = new ExelDataProvider();
            System.out.println("Config and Excel Data Providers initialized successfully.");
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to initialize Config or Excel Data Providers. Check file paths.");
        }
    }

    @Parameters({"BrowserName"})
    @BeforeClass
    public void setUp(String BrowserName) {
        try {
            if (BrowserName.equalsIgnoreCase("chrome")) {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            } else if (BrowserName.equalsIgnoreCase("edge")) {
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
            } else {
                throw new RuntimeException("Invalid Browser Name: " + BrowserName);
            }

            System.out.println(BrowserName + " browser launched successfully.");

            String url = config.getQAENV_1();
            if (url == null || url.isEmpty()) {
                throw new RuntimeException("URL from ConfigDataProvider is null or empty.");
            }

            System.out.println("Navigating to URL: " + url);
            driver.get(url);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Browser setup failed. Check WebDriver or URL configuration.");
        }
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            System.out.println("Browser closed successfully.");
        } else {
            System.out.println("Driver was not initialized; nothing to close.");
        }
    }
}
