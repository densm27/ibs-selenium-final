package ru.appline.framework.managers;

import ru.appline.framework.pages.SearchPage;
import ru.appline.framework.pages.HomePage;
import ru.appline.framework.pages.CategoryPage;

/**
 * 
 * Класс для управления страничками
 */
public class PageManager {

    /**
     * Менеджер страничек
     */
    private static PageManager pageManager;

    /**
     * Стартовая страничка
     */
    private HomePage homePage;

    /**
     * Страничка страхование путешественников
     */
    private CategoryPage categoryPage;


    /**
     * Страничка оформления полиса страхования
     */
    private SearchPage searchPage;

    /**
     * Конструктор специально был объявлен как private (singleton паттерн)
     *
     * @see PageManager#getPageManager()
     */
    private PageManager() {
    }

    /**
     * Ленивая инициализация PageManager
     *
     * @return PageManager
     */
    public static PageManager getPageManager() {
        if (pageManager == null) {
            pageManager = new PageManager();
        }
        return pageManager;
    }

    /**
     * Ленивая инициализация {@link HomePage}
     *
     * @return StartPage
     */
    public HomePage getHomePage() {
        if (homePage == null) {
            homePage = new HomePage();
        }
        return homePage;
    }

    /**
     * Ленивая инициализация {@link CategoryPage}
     *
     * @return InsurancePage
     */
    public CategoryPage getCategoryPage() {
        if (categoryPage == null) {
            categoryPage = new CategoryPage();
        }
        return categoryPage;
    }

    /**
     * Ленивая инициализация {@link SearchPage}
     *
     * @return RegistrationFormPage
     */
    public SearchPage getSearchPage() {
        if (searchPage == null) {
            searchPage = new SearchPage();
        }
        return searchPage;
    }

    public static void quit(){
        pageManager = null;
    }
}
