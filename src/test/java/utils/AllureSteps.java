package utils;

import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import tests.BaseTest;

import java.io.ByteArrayInputStream;

public class AllureSteps {
    @Step("Capture screenshot (spoiler)")
    public static void screenshotSpoiler() {
        Allure.addAttachment("Screenshot", new ByteArrayInputStream(((TakesScreenshot)
                BaseTest.getDriver()).getScreenshotAs(OutputType.BYTES)));
    }

    @Attachment(value = "Screenshot", type = "image/png")
    public static byte[] screenshot() {
        return ((TakesScreenshot) BaseTest.getDriver()).getScreenshotAs(OutputType.BYTES);
    }

    @Attachment(value = "HTML", type = "text/html")
    public static String sourceCode() {
        return BaseTest.getDriver().getPageSource();
    }
}
