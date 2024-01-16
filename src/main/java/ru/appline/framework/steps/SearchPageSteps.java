package ru.appline.framework.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.ru.И;
import org.junit.Assert;
import ru.appline.framework.managers.PageManager;

public class SearchPageSteps {

    private final PageManager pageManager = PageManager.getPageManager();

    @И("^Выбрать производителя \"(.+)\"$")
    public void selectManufacturer(String name) {
        pageManager.getSearchPage().setManufacturer(name);
    }

    @И("^Задать минимальную цену \"(.+)\" рублей$")
    public void setMinPrice(String minPrice) {
        pageManager.getSearchPage().setMinPrice(minPrice);
    }

    @И("^Проверить, что на странице отображается не более \"(.+)\" товаров$")
    public void checkNoMoreResultsThan(int count) {
        pageManager.getSearchPage().checkNoMoreResultsThan(count);
    }

    String firstFoundProduct;

    @И("^Запомнить наименование первого товара в списке$")
    public void saveFirstFoundProduct() {
        firstFoundProduct = pageManager.getSearchPage().getFirstFoundProduct();
    }

    @И("^Выполнить поиск по сохраненному названию товара$")
    public void searchByName() {
        pageManager.getSearchPage().searchByName(firstFoundProduct);
    }

    @И("^Сравнить результаты поиска по параметрам и по названию$")
    public void compareSearchResults() {
        Assert.assertEquals(firstFoundProduct,pageManager.getSearchPage().getFirstFoundProduct());
    }


}
