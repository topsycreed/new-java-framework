package tests;

import io.qameta.allure.Story;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static constants.CommonConstants.UI_BASE_URL;
import static org.assertj.core.api.Assertions.assertThat;

@Story("UI tests")
@Tag("ui")
class UiTests extends BaseTest {
    @Test
    void submitWebFormTest() {
        driver.get(UI_BASE_URL);
        driver.findElement(By.linkText("Web form")).click();
        driver.findElement(By.id("my-text-id")).sendKeys("Text");
        driver.findElement(By.xpath("//button[@type = 'submit']")).click();
        longWait.until(ExpectedConditions.urlContains("submitted-form.html"));
        WebElement title = driver.findElement(By.className("display-6"));

        Assertions.assertEquals("Form submitted", title.getText());
    }

    @Test
    void loadingImagesImplicitWaitTest() {
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/loading-images.html");

        WebElement compass = driver.findElement(By.id("compass"));
        WebElement calendar = driver.findElement(By.id("calendar"));
        WebElement award = driver.findElement(By.id("award"));
        WebElement landscape = driver.findElement(By.id("landscape"));

        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(compass.getAttribute("src")).containsIgnoringCase("compass");
        softly.assertThat(calendar.getAttribute("src")).containsIgnoringCase("calendar");
        softly.assertThat(award.getAttribute("src")).containsIgnoringCase("award");
        softly.assertThat(landscape.getAttribute("src")).containsIgnoringCase("landscape");
        softly.assertAll();
    }

    @Test
    void loadingImagesExplicitWaitTest() {
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/loading-images.html");

        WebElement landscape = longWait.until(ExpectedConditions.presenceOfElementLocated(By.id("landscape")));
        assertThat(landscape.getAttribute("src")).containsIgnoringCase("landscape");
    }
}
