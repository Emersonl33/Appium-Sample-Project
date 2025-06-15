package appiumcucumber.kabum.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.WithTimeout;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class CartPage{

    public CartPage(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
    }

    @WithTimeout(time = 10, chronoUnit = java.time.temporal.ChronoUnit.SECONDS)
    @AndroidFindBy(id = "br.com.kabum.webviewapp:id/description")
    public WebElement descriptionProductLabel;

}
