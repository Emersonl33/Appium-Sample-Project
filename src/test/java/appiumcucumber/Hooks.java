package appiumcucumber;

import io.appium.java_client.AppiumDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Hooks {

    private final TestContext context;

    public Hooks(TestContext context) {
        this.context = context;
    }

    @Before
    public void startAppium() throws Exception {
        AppiumBase base = new AppiumBase();
        AppiumDriver driver = base.setUpAppium();
        context.setDriver(driver);
        driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));
    }

    @After
    public void tearDown() {
        AppiumDriver driver = context.getDriver();
        if (driver != null) {
            driver.quit();
        }
    }
}

