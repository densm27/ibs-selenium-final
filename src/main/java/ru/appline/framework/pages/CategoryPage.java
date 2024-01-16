package ru.appline.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * 
 * Класс описывающий страничку страхование путешественников
 */
public class CategoryPage extends BasePage {



    @FindBy(xpath = "//*[text()='Оформить онлайн']/../../a[@data-test-id]")
    private WebElement buttonCheckoutOnline;

    public SearchPage selectSubcategory(String subcategory) {
        waitUtilElementToBeClickable(
                driverManager.getDriver().findElement(By.xpath("//p[contains(@class,'CardCategory_title')][text()='"+subcategory+"']"))
        ).click();
        waitForTitleToBe(subcategory);
        return pageManager.getSearchPage();
    }



}
