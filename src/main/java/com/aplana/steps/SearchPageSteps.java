package com.aplana.steps;

import com.aplana.pages.SearchPage;
import com.google.common.base.Function;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

import static com.aplana.steps.BasePageSteps.getDriver;

public class SearchPageSteps {
    SearchPage searchPage = new SearchPage();
    WebDriverWait wait = new WebDriverWait(getDriver(), 30);

    @Step("Ограничиваем цену до {0}")
    public void setPrice(String price){
        String s = searchPage.amountOfSearchProducts.getText();
        searchPage.priceTo.click();
        searchPage.priceTo.sendKeys(Keys.CONTROL+"a");
        searchPage.priceTo.sendKeys(price);
        searchPage.priceTo.sendKeys(Keys.ENTER);
        wait.until((Function<? super WebDriver, Boolean>) driver -> !(s.equals(searchPage.amountOfSearchProducts.getText())));
    }

    @Step("Отмечаем высокий рейтинг")
    public void highRating() {
        String s = searchPage.amountOfSearchProducts.getText();
        searchPage.scroll(searchPage.highRating);
        searchPage.highRating.click();
        wait.until((Function<? super WebDriver, Boolean>) driver -> !(s.equals(searchPage.amountOfSearchProducts.getText())));
    }

    @Step("Отмечаем {0} ГБ")
    public void selectRAM(String RAM) {
        String s = searchPage.amountOfSearchProducts.getText();
        searchPage.scroll(searchPage.RAM.get(0));
        searchPage.selectRAM(searchPage.RAM,RAM);
        wait.until((Function<? super WebDriver, Boolean>) driver -> !(s.equals(searchPage.amountOfSearchProducts.getText())));
    }

    @Step("Добавляем в корзину {0} нечетных товаров")
    public void addToCart(String amount){
        String s="";
        for(int i=0; i<Integer.parseInt(amount); i++){
            searchPage.scroll(searchPage.addToCartButtonList.get(i));
            searchPage.addToCartButtonList.get(i).click();
            String finalS = s;
            wait.until((Function<? super WebDriver, Boolean>) driver -> !(finalS.equals(searchPage.cartProductsAmount.getText())));
            s = searchPage.cartProductsAmount.getText();
        }
    }

    @Step("Запоминаем имена {0} добавленных товаров")
    public void saveSearchProducts(String amount){
        int size = Integer.parseInt(amount)*2;
        ArrayList<String> nameOfSearchProducts = new ArrayList<>();
        for(int i=0; i<size; i=i+2){
            nameOfSearchProducts.add(searchPage.searchList.get(i).getText());
        }
    }

    @Step("Переход в корзину")
    public void goToCart(){
        searchPage.cart.click();
    }



}
