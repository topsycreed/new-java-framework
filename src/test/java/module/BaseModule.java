package module;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import config.TestPropertiesConfig;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

public class BaseModule extends AbstractModule {
    @Provides
    public TestPropertiesConfig getConfigProperties() {
        return ConfigFactory.create(TestPropertiesConfig.class, System.getProperties());
    }

    @Provides
    public WebDriver provideWebDriver() {
        System.out.println("Created webdriver");
        String remoteUrl = System.getenv("SELENIUM_REMOTE_URL");
        WebDriver driver;
        if (remoteUrl != null) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless");
            options.addArguments("--disable-gpu");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.setCapability("goog:loggingPrefs", Map.of("browser", "ALL"));
            try {
                driver = new RemoteWebDriver(new URL(remoteUrl), options);
            } catch (MalformedURLException e) {
                throw new RuntimeException("Malformed URL for Selenium Remote WebDriver", e);
            }
        } else {
            driver = new ChromeDriver();
        }
        driver.manage().window().maximize();
        return driver;
    }
}
