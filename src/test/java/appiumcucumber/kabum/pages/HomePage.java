package appiumcucumber.kabum.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {

    @FindBy (id = "br.com.kabum.webviewapp:id/btn_close")
    public WebElement buildPcCloseButton;

    @FindBy (id = "br.com.kabum.webviewapp:id/search_edit_frame")
    public WebElement searchBarInput;


}
