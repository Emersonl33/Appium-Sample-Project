package appiumcucumber;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Utils {
    WebDriver driver;

    public void waitForElement(WebElement element) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void scrollDownUntilVisible(WebElement element) {
        Dimension size = driver.manage().window().getSize();

        int startX = size.width / 2;
        int startY = (int) (size.height * 0.8);
        int endY = (int) (size.height * 0.2);

        int maxSwipes = 5;
        int attempts = 0;

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        while (attempts < maxSwipes) {
            try {
                wait.until(ExpectedConditions.visibilityOf(element));
                return;
            } catch (Exception e) {
                new TouchAction<>((AndroidDriver) driver)
                        .press(PointOption.point(startX, startY))
                        .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                        .moveTo(PointOption.point(startX, endY))
                        .release()
                        .perform();
                attempts++;
            }
        }
        throw new RuntimeException("Elemento não encontrado depois de " + maxSwipes + " tentativas.");
    }
}

