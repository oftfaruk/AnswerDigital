package com.AutoPractice.pages;

import com.AutoPractice.utilities.BrowserUtils;
import com.AutoPractice.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {
    public BasePage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath = "//b[contains(text(),'Cart')]")
    public WebElement cart;
    @FindBy(xpath = "(//a[@title='Dresses'])[2]")
    public WebElement dresses;
    @FindBy(xpath = "(//a[@title='T-shirts'])[2]")
    public WebElement tshirts;
    @FindBy(xpath = "(//a[@title='Summer Dresses'])[2]")
    public WebElement summerDresses;
    @FindBy(xpath = "//a[@title='Women']")
    public WebElement womenButton;
    @FindBy(xpath = "//span[contains(text(),'Add to cart')]")
    public WebElement addCart;
    @FindBy(xpath = "//a[contains(text(),'Our stores')]")
    public WebElement ourStores;
    @FindBy(css=("a[class='login']"))
    public WebElement signin;
    @FindBy(xpath = "//img[@class='replace-2x img-responsive']")
    public  WebElement image;




    public void navigationMenu(String tab, String module) {
        //first letters  must be capital
        if (tab.equals("Women")) {
            WebElement tabLocater = Driver.get().findElement(By.xpath("//a[@title='Women']"));
            BrowserUtils.hover(tabLocater);
            if (module.equals("Blouses")) {
                Driver.get().findElement(By.xpath("//a[@title='Blouses']")).click();
            } else {
                Driver.get().findElement(By.xpath("//a[@title='" + module + "']")).click();
            }

        } else if(tab.equals("Dresses")) {
            WebElement tabLocater = Driver.get().findElement(By.xpath("(//a[@title='" + tab + "'])[2]"));
            BrowserUtils.hover(tabLocater);
            WebElement moduleLocater = Driver.get().findElement(By.xpath("(//a[@title='" + module + "'])[2]"));
            BrowserUtils.hoverAndClick(moduleLocater);
        }

    }


}
