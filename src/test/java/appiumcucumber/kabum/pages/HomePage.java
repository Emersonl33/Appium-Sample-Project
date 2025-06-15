package appiumcucumber.kabum.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.WithTimeout;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.time.temporal.ChronoUnit;


public class HomePage {

        private final AppiumDriver driver;

        public HomePage(AppiumDriver driver) {
                this.driver = driver;
                PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
        }

        @WithTimeout(time = 15, chronoUnit = ChronoUnit.SECONDS)
        @AndroidFindBy(id = "br.com.kabum.webviewapp:id/btn_close")
        public WebElement buildPcCloseButton;

        @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
        @AndroidFindBy(id = "br.com.kabum.webviewapp:id/search_edit_frame")
        public WebElement searchBarInput;

        @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
        @AndroidFindBy(id = "br.com.kabum.webviewapp:id/search_src_text")
        public WebElement searchBarTextInput;

        @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
        @AndroidFindBy(id = "br.com.kabum.webviewapp:id/fab_add_to_cart")
        public WebElement addGpuProductButton;

        @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
        @AndroidFindBy(id = "br.com.kabum.webviewapp:id/op_basket")
        public WebElement cartMenuButton;

        public WebElement getProductLabel(String partialText) {
                String xpath = "//android.widget.TextView[@resource-id='br.com.kabum.webviewapp:id/name' and contains(@text, '" + partialText + "')]";
                return driver.findElement(By.xpath(xpath));
        }
}
