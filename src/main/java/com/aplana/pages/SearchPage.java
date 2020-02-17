package com.aplana.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchPage extends BasePage{
    @FindBy(xpath = "//div[contains(text(),'Цена')]/..//label[text()='до']/..//input")
    public WebElement priceTo;

    @FindBy(xpath = "//div[@value='Высокий рейтинг']//label")
    public WebElement highRating;

    @FindBy(xpath = "//div[contains(text(),'Оперативная память')]/..//span")
    public List<WebElement> RAM;

    @FindBy(xpath = "//div[@class='am1']//a[@data-test-id='tile-name']")
    public List<WebElement> searchNameList;

    @FindBy(xpath = "//div[@class='am1']//span[@data-test-id='tile-price']")
    public List<WebElement> searchPriceList;


    @FindBy(xpath = "//button[contains(@qa-id,'buy')]")
    public List<WebElement> addToCartButtonList;

    @FindBy(xpath = "//span[contains(text(),'Корзина')]/..")
    public WebElement cart;

    @FindBy(xpath = "//div[contains(text(),'По запросу')]")
    public WebElement amountOfSearchProducts;

    @FindBy(xpath = "//span[contains(@class,'caption')]")
    public WebElement cartProductsAmount;

    @FindBy(xpath = "//p[text()='Найти']/..//input")
    public WebElement searchBrand;

    @FindBy(xpath = "//div[contains(text(),'Бренды')]/..//span[contains(text(),'Посмотреть все')]")
    public WebElement allBrands;

    @FindBy(xpath = "//div[contains(text(),'Бренды')]/..//span")
    public WebElement selectBrand;


    public void selectRAM(List<WebElement> list, String amount) {
        for (WebElement element : list) {
            if (element.getText().contains(amount)){
                element.click();
                return;
            }
        }
    }
}
