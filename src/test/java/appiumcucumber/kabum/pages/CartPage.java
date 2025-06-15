package appiumcucumber.kabum.pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage{

    @AndroidFindBy(id = "br.com.kabum.webviewapp:id/description")
    public WebElement descriptionProductLabel;


}
