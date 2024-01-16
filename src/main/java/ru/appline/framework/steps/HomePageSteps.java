package ru.appline.framework.steps;

import io.cucumber.java.ru.И;
import io.qameta.allure.Allure;
import io.qameta.allure.model.Status;
import ru.appline.framework.managers.PageManager;

public class HomePageSteps {
    private final PageManager pageManager = PageManager.getPageManager();

    @И("^Выбрать категорию \"(.+)\" в главном меню$")
    public void selectCategory(String nameMenu) {

        pageManager.getHomePage().selectCategory(nameMenu);
    }

}
