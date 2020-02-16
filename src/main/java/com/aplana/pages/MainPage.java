package com.aplana.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MainPage extends BasePage {
    @FindBy(xpath = "//input[@name='search']")
    public WebElement search;

    @FindBy(xpath = "//button[@aria-label='Закрыть сообщение']")
    public WebElement closeDialogWindowButton;

}
