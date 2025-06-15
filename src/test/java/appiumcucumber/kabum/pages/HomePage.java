package appiumcucumber.kabum.pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class HomePage {

        @AndroidFindBy(id = "br.com.kabum.webviewapp:id/btn_close")
        public WebElement buildPcCloseButton;

        @AndroidFindBy(id = "br.com.kabum.webviewapp:id/search_edit_frame")
        public WebElement searchBarInput;

        @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"br.com.kabum.webviewapp:id/name\" and @text=\"Placa de Vídeo Gigabyte RTX 5070 AERO 12G NVIDIA GeForce, 12GB GDDR7, 192bits, RGB, DLSS, Ray Tracing - 9VN5070AO-00-G10\"]")
        public WebElement gpuProductLabel;

        @AndroidFindBy(xpath = "(//android.widget.ImageButton[@content-desc=\"Comprar\"])[4]")
        public WebElement addGpuProductButton;

        @AndroidFindBy(id = "br.com.kabum.webviewapp:id/op_basket")
        public WebElement cartMenuButton;



}
