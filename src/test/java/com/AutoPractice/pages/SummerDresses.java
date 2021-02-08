package com.AutoPractice.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SummerDresses extends BasePage {
    @FindBy(xpath = "//span[@title='Close window']")
    public WebElement closeWindow;
    @FindBy(xpath = "(//a[@class='product-name'])[3]")
    public WebElement printedSummerDress;

}
