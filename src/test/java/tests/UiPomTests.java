package tests;

import org.junit.jupiter.api.Test;
import pages.LoginPage;

import static org.assertj.core.api.Assertions.assertThat;

class UiPomTests extends BaseTest {
    @Test
    void loginPomTest() {
        LoginPage loginPage = new LoginPage(driver, longWait);
        loginPage.login();

        assertThat(driver.getCurrentUrl()).contains("login-sucess");
    }
}
