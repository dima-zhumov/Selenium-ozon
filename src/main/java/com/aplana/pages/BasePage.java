package com.aplana.pages;

import com.aplana.steps.BasePageSteps;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    public BasePage(){
        PageFactory.initElements(BasePageSteps.getDriver(),this);
    }

    public void scroll(WebElement element) {
        ((JavascriptExecutor)BasePageSteps.getDriver()).executeScript("arguments[0].scrollIntoView(false);", element);
    }
}
