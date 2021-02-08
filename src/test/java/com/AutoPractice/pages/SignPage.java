package com.AutoPractice.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignPage extends BasePage {

    @FindBy(id = "email_create")
    public WebElement emailBox;
    @FindBy(id = "SubmitCreate")
    public WebElement createAccountButton;
    @FindBy(xpath = "(//input[@class='is_required validate account_input form-control'])[3]")
    public WebElement passwordBox;
    @FindBy(xpath = "(//input[@class='is_required validate account_input form-control'])[2]")
    public WebElement emailForsigning;
    @FindBy(id = "SubmitLogin")
    public WebElement submitButton;


}
