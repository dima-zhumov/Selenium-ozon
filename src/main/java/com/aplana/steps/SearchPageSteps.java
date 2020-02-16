package com.aplana.steps;

import com.aplana.pages.BasePage;
import com.aplana.pages.SearchPage;
import com.google.common.base.Function;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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

    @Step("Запоминаем имена и цену {0} добавленных товаров")
    public void saveSearchProducts(String amount) throws IOException {
        HashMap<String,Integer> searchProducts = new HashMap<>();
        int size = Integer.parseInt(amount)*2;
        for(int i=0; i<size; i=i+2){
            searchProducts.put(searchPage.searchNameList.get(i).getText(),
                    Integer.parseInt(searchPage.searchPriceList.get(i).getText().replaceAll("[^\\d]","")));
        }
        File file = new File ("text.txt");
        if (file.exists()) {
            file.delete();
        }
        FileWriter writer = new FileWriter(file);
        for (Map.Entry entry : searchProducts.entrySet()) {
            writer.write("Название: " + entry.getKey().toString()
                    + "; Цена: " + entry.getValue().toString() + "\n");
        }
        writer.close();
        new BasePageSteps().saveToFileAllure(file);
        }


    @Step("Переход в корзину")
    public void goToCart() throws InterruptedException {
        searchPage.cart.click();
    }



}
