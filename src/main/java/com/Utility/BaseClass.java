package com.Utility;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

    public static WebDriver driver;
    public static ConfigDataProvider config;
    public static ExelDataProvider exel;

    // ---------------- BEFORE SUITE ----------------
    @BeforeSuite
    public void initializationSetup() {
        try {
            config = new ConfigDataProvider();
            exel = new ExelDataProvider();
            System.out.println("Config & Excel initialized successfully");
        } catch (IOException e) {
            throw new RuntimeException("Failed to initialize Config/Excel files", e);
        }
    }

    // ---------------- BEFORE CLASS ----------------
    @Parameters({"BrowserName"})
    @BeforeMethod
    public void setUp(@Optional("chrome") String BrowserName) {

        System.out.println("Browser selected from XML : " + BrowserName);

        if (BrowserName.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();

        } else if (BrowserName.equalsIgnoreCase("edge")) {
        	System.setProperty("webdriver.edge.driver",
        	        "C:\\Users\\visha\\Downloads\\edgedriver_win64\\msedgedriver.exe");

        	    driver = new EdgeDriver();
        } else {
            throw new RuntimeException("Invalid BrowserName in XML : " + BrowserName);
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        String url = config.getQAENV_1();
        driver.get(url);

        System.out.println("Application launched : " + url);
    }

    // ---------------- AFTER METHOD ----------------
    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            System.out.println("Browser closed successfully");
        }
    }
}
