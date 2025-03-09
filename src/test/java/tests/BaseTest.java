package tests;

import com.google.inject.Inject;
import extensions.GuiceExtension;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.ui.WebDriverWait;
import utils.AfterTestExtension;
import utils.AllureSteps;

import java.time.Duration;

//@ExtendWith({GuiceExtension.class, AfterTestExtension.class})
@ExtendWith(GuiceExtension.class)
public class BaseTest {
    @Inject
    protected WebDriver driver;
    protected WebDriverWait longWait;

    @BeforeEach
    void setup() {
        GuiceExtension.getInjector().injectMembers(this);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        longWait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
