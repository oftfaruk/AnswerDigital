package com.AutoPractice.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SummerDresses extends BasePage {
    @FindBy(xpath = "//span[@title='Close window']")
    public WebElement closeWindow;
    @FindBy(xpath = "(//a[@class='product-name'])[3]")
    public WebElement printedSummerDress;
    @FindBy(xpath = "(//a[@class='ui-slider-handle ui-state-default ui-corner-all'])[1]")
    public WebElement leftSlider;
    @FindBy(xpath = "(//a[@class='ui-slider-handle ui-state-default ui-corner-all'])[2]")
    public WebElement rightSlider;
    @FindBy(id = "layered_price_range")
    public WebElement priceRange;



}
