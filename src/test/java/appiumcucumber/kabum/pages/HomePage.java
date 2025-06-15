package appiumcucumber.kabum.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class HomePage {

        @FindBy(id = "br.com.kabum.webviewapp:id/btn_close")
        public WebElement buildPcCloseButton;

        @FindBy(id = "br.com.kabum.webviewapp:id/search_edit_frame")
        public WebElement searchBarInput;

        @FindBy(xpath = "//android.widget.TextView[@resource-id=\"br.com.kabum.webviewapp:id/name\" and @text=\"Placa de Vídeo Gigabyte RTX 5070 AERO 12G NVIDIA GeForce, 12GB GDDR7, 192bits, RGB, DLSS, Ray Tracing - 9VN5070AO-00-G10\"]")
        public WebElement gpuProductLabel;

        @FindBy(xpath = "(//android.widget.ImageButton[@content-desc=\"Comprar\"])[4]")
        public WebElement addGpuProductButton;

        @FindBy(id = "br.com.kabum.webviewapp:id/op_basket")
        public WebElement cartMenuButton;



}
