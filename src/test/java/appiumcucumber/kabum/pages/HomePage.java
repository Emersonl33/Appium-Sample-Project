package appiumcucumber.kabum.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.WithTimeout;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class HomePage {

        public HomePage(AppiumDriver driver) {
                PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
        }

        @WithTimeout(time = 15, chronoUnit = java.time.temporal.ChronoUnit.SECONDS)
        @AndroidFindBy(id = "br.com.kabum.webviewapp:id/btn_close")
        public WebElement buildPcCloseButton;

        @WithTimeout(time = 10, chronoUnit = java.time.temporal.ChronoUnit.SECONDS)
        @AndroidFindBy(id = "br.com.kabum.webviewapp:id/search_edit_frame")
        public WebElement searchBarInput;

        @WithTimeout(time = 10, chronoUnit = java.time.temporal.ChronoUnit.SECONDS)
        @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"br.com.kabum.webviewapp:id/name\" and @text=\"Placa de Vídeo Gigabyte RTX 5070 AERO 12G NVIDIA GeForce, 12GB GDDR7, 192bits, RGB, DLSS, Ray Tracing - 9VN5070AO-00-G10\"]")
        public WebElement gpuProductLabel;

        @WithTimeout(time = 10, chronoUnit = java.time.temporal.ChronoUnit.SECONDS)
        @AndroidFindBy(xpath = "(//android.widget.ImageButton[@content-desc=\"Comprar\"])[4]")
        public WebElement addGpuProductButton;

        @WithTimeout(time = 10, chronoUnit = java.time.temporal.ChronoUnit.SECONDS)
        @AndroidFindBy(id = "br.com.kabum.webviewapp:id/op_basket")
        public WebElement cartMenuButton;

}
