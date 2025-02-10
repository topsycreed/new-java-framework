package pages;

import config.TestPropertiesConfig;
import io.qameta.allure.Step;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {
    TestPropertiesConfig configProperties = ConfigFactory.create(TestPropertiesConfig.class, System.getProperties());

    @FindBy(id = "username")
    private WebElement usernameInput;
    @FindBy(id = "password")
    private WebElement passwordInput;
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement loginButton;

    private static final String VALID_USER = "user";
    private static final String VALID_PASSWORD = "user";

    public LoginPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        driver.get(configProperties.getUiBaseUrl() + "login-form.html");
    }

    @Step("Login with valid user and password")
    public void login() {
        usernameInput.sendKeys(VALID_USER);
        passwordInput.sendKeys(VALID_PASSWORD);
        loginButton.click();
    }
}
