package appiumcucumber;

import io.appium.java_client.AppiumDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Hooks {

    public static AppiumDriver driver;

    @Before
    public void startAppium() throws Exception {
        AppiumBase appiumBase = new AppiumBase();
        driver = appiumBase.setUpAppium();
        log.info("Appium session started");
    }

    @After
    public void quitAppium(){
        if(driver != null){
            driver.quit();
            log.info("Appium session closed");
        }
    }
}
