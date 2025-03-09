package utils;

import com.google.inject.Inject;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.ByteArrayInputStream;

public class AllureSteps {
//    private final WebDriver driver;
//
//    @Inject
//    public AllureSteps(WebDriver driver) {
//        this.driver = driver;
//    }
//
//    @Step("Capture screenshot (spoiler)")
//    public void screenshotSpoiler() {
//        Allure.addAttachment("Screenshot", new ByteArrayInputStream(((TakesScreenshot)
//                driver).getScreenshotAs(OutputType.BYTES)));
//    }
//
//    @Attachment(value = "Screenshot", type = "image/png")
//    public byte[] screenshot() {
//        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
//    }
//
//    @Attachment(value = "HTML", type = "text/html")
//    public String sourceCode() {
//        return driver.getPageSource();
//    }
}
