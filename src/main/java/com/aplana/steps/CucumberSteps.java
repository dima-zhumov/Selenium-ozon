package com.aplana.steps;

import cucumber.api.java.ru.Когда;

public class CucumberSteps {
    MainPageSteps mainPageSteps = new MainPageSteps();
    SearchPageSteps searchPageSteps = new SearchPageSteps();
    CartPageSteps cartPageSteps = new CartPageSteps();


    @Когда("^Закрыто сообщение о cookies$")
    public void closeDialogWindow() throws InterruptedException {
        mainPageSteps.closeDialogWindow();
    }

    @Когда("^Введено в поиске (.*)$")
    public void search(String searchName){
        mainPageSteps.search(searchName);
    }

    @Когда("^Ограничена цена до (.*)$")
    public void setPrice(String price) {
        searchPageSteps.setPrice(price);
    }

    @Когда("^Отмечен высокий рейтинг$")
    public void selectHighRating () {
        searchPageSteps.highRating();
    }

    @Когда("^Выбран объем оперативной памяти (.*)$")
    public void selectRAM(String RAM) {
        searchPageSteps.selectRAM(RAM);
    }

    @Когда("^Добавлены в корзину (.*) нечетных товаров$")
    public void addToCart(String amount) {
        searchPageSteps.addToCart(amount);
    }

    @Когда("^Сохранены названия (.*) добавленных товаров$")
    public void saveSearchProducts(String amount){
        searchPageSteps.saveSearchProducts(amount);
    }

    @Когда("^Перешли в корзину$")
    public void goToCart (){
        searchPageSteps.goToCart();
    }

    @Когда("^Проверили, что корзина содержит (.*) товаров$")
    public void checkAmountOfCartProducts(String amount){
        cartPageSteps.checkAmountOfCartProducts(amount);
    }

    @Когда("^Удалили все товары из корзины$")
    public void deleteAllProducts(){
        cartPageSteps.deleteAllCartProducts();
    }

    @Когда("^Проверили, что корзина пуста")
    public void checkEmptyCart() {
        cartPageSteps.checkEmptyCart();
    }

}
