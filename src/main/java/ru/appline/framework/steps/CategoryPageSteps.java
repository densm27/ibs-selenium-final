package ru.appline.framework.steps;

import io.cucumber.java.ru.И;
import io.qameta.allure.Allure;
import io.qameta.allure.model.Status;
import ru.appline.framework.managers.PageManager;

public class CategoryPageSteps {

    private final PageManager pageManager = PageManager.getPageManager();

    @И("^Выбрать подкатегорию \"(.+)\" в списке$")
    public void selectSubcategory(String name) {
        pageManager.getCategoryPage().selectSubcategory(name);

    }


}
