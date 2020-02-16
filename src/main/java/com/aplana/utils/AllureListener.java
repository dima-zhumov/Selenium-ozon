package com.aplana.utils;

import com.aplana.steps.BasePageSteps;
import io.qameta.allure.Attachment;
import io.qameta.allure.junit4.AllureJunit4;
import org.junit.runner.notification.Failure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class AllureListener extends AllureJunit4 {

    @Override
    public void testFailure(Failure failure) {
        takeScreenshot();
        super.testFailure(failure);
}

    @Attachment(type = "image/png", value = "Screenshot")
    public byte[] takeScreenshot() {
        return ((TakesScreenshot) BasePageSteps.getDriver()).getScreenshotAs(OutputType.BYTES);
    }

}