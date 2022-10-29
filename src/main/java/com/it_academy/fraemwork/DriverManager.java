package com.it_academy.fraemwork;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static void setDriver() {
        if (getDriver() == null) {
            WebDriverManager.chromedriver().setup();
            driver.set(new ChromeDriver());
        }
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void closeDriver() {
        driver.get().close();
        driver.remove();
    }
}
