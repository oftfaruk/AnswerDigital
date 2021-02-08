package com.AutoPractice.pages;

import com.AutoPractice.utilities.BrowserUtils;
import com.AutoPractice.utilities.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;


public class BasketPage extends BasePage {
    @FindBy(xpath = "//i[@class='icon-trash']")
    public WebElement delete;
    @FindBy(xpath = "//span[@class='heading-counter']")
    public WebElement basketCountText;
    @FindBy(xpath = "//p[@class='alert alert-warning']")
    public WebElement emptyBasketText;

    public void deleteİtems() {
        List<WebElement> itemsİnTheBasket = Driver.get().findElements(By.xpath("//i[@class='icon-trash']"));
        for (int i = 0; i < itemsİnTheBasket.size(); i++) {
            delete.click();
            BrowserUtils.waitFor(2);
        }


    }


}
