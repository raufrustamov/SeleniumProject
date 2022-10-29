package page_object;

import com.it_academy.fraemwork.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public abstract class BasePage {


    public BasePage() {
        DriverManager.setDriver();
    }

    public WebElement waitForElementVisible(By by) {

        Wait<WebDriver> wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(60));
        return wait.until(visibilityOfElementLocated(by));
    }


    public WebElement waitForElementClickable(By by) {
        Wait<WebDriver> wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(60));
        return wait.until(elementToBeClickable(by));
    }
}
