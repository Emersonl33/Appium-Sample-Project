package appiumcucumber;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;
import java.util.Collections;
import java.util.function.Supplier;

@Slf4j
public class Utils {

    private final AppiumDriver driver;
    private final WebDriverWait wait;

    public Utils(AppiumDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }


    public void waitForElement(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void scrollDownUntilVisible(Supplier<WebElement> elementSupplier) {
        if (!(driver instanceof AndroidDriver)) {
            throw new IllegalStateException("This method only works with AndroidDriver.");
        }

        Dimension size = driver.manage().window().getSize();
        int width = size.width;
        int height = size.height;

        int startX = width / 2;
        int startY = (int) (height * 0.8);
        int endY = (int) (height * 0.2);

        int maxSwipes = 15;

        for (int i = 0; i < maxSwipes; i++) {
            try {
                WebElement element = elementSupplier.get();
                wait.until(ExpectedConditions.visibilityOf(element));
                return;
            } catch (NoSuchElementException | TimeoutException e) {
                performScroll(startX, startY, startX, endY);
            }
        }

        throw new NoSuchElementException("Element not found after " + maxSwipes + " scroll attempts.");
    }


    private void performScroll(int startX, int startY, int endX, int endY) {
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence swipe = new Sequence(finger, 1);

        swipe.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY));
        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(500), PointerInput.Origin.viewport(), endX, endY));
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Collections.singletonList(swipe));
    }

    public void refreshByPullDown() {
        Dimension size = driver.manage().window().getSize();

        int startX = size.width / 2;
        int startY = (int) (size.height * 0.30);
        int endY = (int) (size.height * 0.70);

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence swipe = new Sequence(finger, 1);

        swipe.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY));
        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(500), PointerInput.Origin.viewport(), startX, endY));
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Collections.singletonList(swipe));

        System.out.println("Pull-to-refresh gesture performed.");
    }

    public void retrySendKeys(WebElement element, String text, Object pageObject) {
        int maxRetries = 2;

        for (int attempt = 1; attempt <= maxRetries; attempt++) {
            try {
                waitForElement(element);
                element.sendKeys(text);
                return;
            } catch (StaleElementReferenceException e) {
                log.info("Attempt " + attempt + " fail with StaleElementReferenceException.");
                if (attempt == maxRetries) throw e;

                PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), pageObject);
            }
        }
    }
}