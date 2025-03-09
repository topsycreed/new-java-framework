package tests;

import com.google.inject.Inject;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.LoginPage;

import static org.assertj.core.api.Assertions.assertThat;

@Story("UI POM tests")
@Tag("ui")
class UiPomTests extends BaseTest {
    @Inject
    private LoginPage loginPage;

    @Test
    void loginPomTest() {
        loginPage.login();

        assertThat(driver.getCurrentUrl()).contains("login-sucess");
    }
}
