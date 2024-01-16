package ru.appline.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * 
 * Стартовая страница приложения
 */
public class HomePage extends BasePage {

    @FindBy(xpath = "//button/span[.='Каталог']")
    private WebElement btCatalog;


    public HomePage selectCategory(String category) {
        btCatalog.click();
        waitUtilElementToBeClickable(
                driverManager.getDriver().findElement(By.xpath("//ul/a/div[.='"+category+"']"))
        ).click();
        waitForTitleToBe(category);
        return this;
    }




}
