package pages;

import com.google.inject.Inject;
import config.TestPropertiesConfig;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    @FindBy(id = "username")
    private WebElement usernameInput;
    @FindBy(id = "password")
    private WebElement passwordInput;
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement loginButton;

    private static final String VALID_USER = "user";
    private static final String VALID_PASSWORD = "user";

    @Inject
    public LoginPage(WebDriver driver, TestPropertiesConfig configProperties) {
        super(driver, configProperties);
    }

    @Step("Login with valid user and password")
    public void login() {
        driver.get(configProperties.getUiBaseUrl() + "login-form.html");

        usernameInput.sendKeys(VALID_USER);
        passwordInput.sendKeys(VALID_PASSWORD);
        loginButton.click();
    }
}
