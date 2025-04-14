package pages;

import com.google.inject.Inject;
import config.TestPropertiesConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    protected final WebDriver driver;
    protected final TestPropertiesConfig configProperties;

    @Inject
    public BasePage(WebDriver driver, TestPropertiesConfig configProperties) {
        this.driver = driver;
        this.configProperties = configProperties;
        PageFactory.initElements(driver, this);
    }
}
