package com.expedia.coreFunctions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverSetup extends GlobalDefinitions {
    public static WebDriver driverInstance = null;

    public static void initDriver(String url, String browserType) {
        if (driverInstance == null) {
            switch (browserType) {
                case "chrome":
                    System.out.println("Launching Chrome driver with new profile..");
                    System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH + "chromedriver.exe");
                    driverInstance = new ChromeDriver();
                    break;

                case "FF":
                    System.out.println("Launching FireFox driver with new profile...\n");
                    driverInstance = new FirefoxDriver();
                    break;

                default:
                    System.out.println("Invalid browser type specified.");
            }

            driverInstance.manage().window().maximize();
            driverInstance.navigate().to(url);
        }
    }
}