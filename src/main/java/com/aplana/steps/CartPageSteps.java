package com.aplana.steps;

import com.aplana.pages.CartPage;
import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.aplana.steps.BasePageSteps.getDriver;

public class CartPageSteps {
    CartPage cartPage = new CartPage();
    WebDriverWait wait = new WebDriverWait(getDriver(), 30);

    @Step("Проверяем, что корзина содержит {0} товаров")
    public void checkAmountOfCartProducts(String amount){
        if(!amount.equalsIgnoreCase("все"))
        Assert.assertTrue(cartPage.amountOfCartProducts.getText().contains(amount));
    }

    @Step("Удаляем все товары из корзины")
    public void deleteAllCartProducts(){
        cartPage.deleteCartProductsButton.click();
        wait.until(ExpectedConditions.visibilityOf(cartPage.confirmDeleteButton));
        cartPage.confirmDeleteButton.click();
    }

    @Step("Проверяем, что корзина пуста")
    public void checkEmptyCart(){
        wait.until(ExpectedConditions.visibilityOf(cartPage.checkCartText));
        Assert.assertTrue(cartPage.checkCartText.getText().contains("Корзина пуста"));
    }
}
