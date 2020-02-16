package com.aplana.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage {

    @FindBy(xpath = "//span[contains(text(),'Ваша корзина')]/..")
    public WebElement amountOfCartProducts;

    @FindBy(xpath = "//span[contains(text(),'Удалить выбранные')]")
    public WebElement deleteCartProductsButton;

    @FindBy(xpath = "//div[contains(text(),'Удаление товаров')]/..//button")
    public WebElement confirmDeleteButton;

    @FindBy(xpath = "//h1")
    public WebElement checkCartText;
}
