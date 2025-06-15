package appiumcucumber.kabum.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.WithTimeout;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class CartPage{

    private final AppiumDriver driver;

    public CartPage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
    }

    public WebElement getDescriptionProductLabel() {
        return driver.findElement(By.id("br.com.kabum.webviewapp:id/description"));
    }

}
