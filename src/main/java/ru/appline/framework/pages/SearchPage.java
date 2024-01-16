package ru.appline.framework.pages;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

/**
 * 
 * Класс описывающий страничку оформления полиса страхования
 */
public class SearchPage extends BasePage {

    @FindBy(css = "div.page_title span")
    private WebElement resultTotalCount;

    @FindBy(xpath = "//section[.//span[.='Цена']]//input[@name='min']")
    private WebElement minPrice;
    @FindBy(xpath = "//section[.//span[.='Производитель']]//span[contains(.,'Ещё')]")
    private WebElement allManufacturers;

    @FindBy(xpath = "//input[contains(@class,'Search_searchWrap')]")
    private WebElement searchInput;

    @FindBy(xpath = "//*[contains(@class,'Search_searchIcon')]")
    private WebElement searchButton;

    @FindBy(xpath = "//div[@class='rendererWrapper']//div[contains(@class,'CardText_title')]")
    private List<WebElement> searchResults;

    @Step("Задать минимальную цену {price} рублей")
    public SearchPage setMinPrice(String price) {
        String count = resultTotalCount.getText();
        waitUtilElementToBeClickable(minPrice).sendKeys(price);
        wait.until(ExpectedConditions.textToBePresentInElementValue(minPrice, price));
        wait.until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElement(resultTotalCount, count)));
        wait.until(ExpectedConditions.textToBePresentInElement(resultTotalCount, "товар"));
        return this;
    }

    @Step("Задать производителя {manufacturer}")
    public SearchPage setManufacturer(String manufacturer) {
        String count = resultTotalCount.getText();
        allManufacturers.click();
        waitUtilElementToBeClickable(
                driverManager.getDriver().findElement(
                        By.xpath("//section[.//span[.='Производитель']]//label[contains(.,'" + manufacturer + "')]")
                )
        ).click();
        wait.until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElement(resultTotalCount, count)));
        return this;
    }

    @Step("Проверить, что на странице отображается не более {count} товаров")
    public SearchPage checkNoMoreResultsThan(int count) {
//        driverManager.getDriver().navigate().refresh();
        wait.until(d->searchResults.size()<=count);
        return this;
    }
    @Step("Получить название первого товара в результатах поиска")
    public String getFirstFoundProduct() {
        return searchResults.get(0).getAttribute("title");
    }

    @Step("Выполнить поиск по сохраненному названию товара {name}")
    public SearchPage searchByName(String name) {
        searchInput.sendKeys(name);
        wait.until(ExpectedConditions.textToBePresentInElementValue(searchInput,name));
        searchButton.click();
        return this;
    }
}
