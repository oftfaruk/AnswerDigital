package com.AutoPractice.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {

    @FindBy(id = "my-account")
    public WebElement accountOwnerName;
    @FindBy(xpath = "//h1")
    public WebElement MyaccountPageSubtitle;
    @FindBy(xpath = "//a[@title='View my customer account']")
    public WebElement accountowner;
}
