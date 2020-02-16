package com.aplana.steps;

import com.aplana.pages.MainPage;
import com.sun.org.apache.bcel.internal.ExceptionConstants;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.aplana.steps.BasePageSteps.getDriver;

public class MainPageSteps {
    MainPage mainPage = new MainPage();
    WebDriverWait wait = new WebDriverWait(getDriver(), 30);

    @Step("Закрываем сообщение о cookies")
    public void closeDialogWindow() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(mainPage.closeDialogWindowButton));
        wait.until(ExpectedConditions.elementToBeClickable(mainPage.closeDialogWindowButton));
        Thread.sleep(1000);
        mainPage.closeDialogWindowButton.click();
    }

    @Step("Вбиваем в поиске {0}")
    public void search(String searchName){
        mainPage.search.click();
        mainPage.search.sendKeys(searchName);
        mainPage.search.sendKeys(Keys.ENTER);
    }
}
