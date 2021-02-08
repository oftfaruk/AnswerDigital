package com.AutoPractice.pages;

import com.AutoPractice.utilities.BrowserUtils;
import com.AutoPractice.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashBoard extends BasePage {

    @FindBy(xpath = "(//span[contains(text(),'Add to cart')])")
    public WebElement addToCart;
    @FindBy(xpath = "//span[@title='Close window']")
    public WebElement closeWindow;


    public void addToBasket(int count) throws InterruptedException {

        for (int i = 1; i <= count; i++) {

            BrowserUtils.clickWithJS(Driver.get().findElement(By.xpath("(//span[contains(text(),'Add to cart')])["+i+"]")));
            BrowserUtils.waitFor(1);
            closeWindow.click();

        }


    }

}
