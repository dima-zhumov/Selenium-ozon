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

    @FindBy(xpath = "//div[@class='a2t2']//a[@data-test-id='tile-name']")
    public List<WebElement> searchList;

    @FindBy(xpath = "//button[contains(@qa-id,'buy')]")
    public List<WebElement> addToCartButtonList;

    @FindBy(xpath = "//span[contains(text(),'Корзина')]/..")
    public WebElement cart;

    @FindBy(xpath = "//div[contains(text(),'По запросу')]")
    public WebElement amountOfSearchProducts;

    @FindBy(xpath = "//span[contains(text(),'Интернет-магазин')]")
    public WebElement portView;

    @FindBy(xpath = "//span[contains(@class,'caption')]")
    public WebElement cartProductsAmount;

    public void selectRAM(List<WebElement> list, String amount) {
        for (WebElement element : list) {
            if (element.getText().contains(amount)){
                element.click();
                return;
            }
        }
    }
}
