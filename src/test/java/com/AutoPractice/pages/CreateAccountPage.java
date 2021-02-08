package com.AutoPractice.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateAccountPage extends BasePage {
    @FindBy(id = "id_gender1")
    public WebElement titleMr;
    @FindBy(id = "customer_firstname")
    public WebElement firstName;
    @FindBy(id = "customer_lastname")
    public WebElement lastName;
    @FindBy(css = "input[type='password']")
    public WebElement password;
    @FindBy(id = "days")
    public WebElement dayBirth;
    @FindBy(id = "months")
    public WebElement monthBirth;
    @FindBy(id = "years")
    public WebElement yearsBirth;
    @FindBy(id = "newsletter")
    public WebElement newsletter;
    @FindBy(id = "optin")
    public WebElement speacialOffer;
    @FindBy(xpath = "//input[@name='firstname']")
    public WebElement nameAdress;
    @FindBy(xpath = "//input[@name='lastname']")
    public WebElement lastNameAdres;
    @FindBy(css = "#company")
    public WebElement company;
    @FindBy(css = "#address1")
    public WebElement adress;
    @FindBy(css = "#city")
    public WebElement city;
    @FindBy(id = "id_state")
    public WebElement state;
    @FindBy(id = "postcode")
    public WebElement postcode;
    @FindBy(css = "#other")
    public WebElement addİnfo;
    @FindBy(css = "#phone")
    public WebElement phone;
    @FindBy(css = "#phone_mobile")
    public WebElement mobilePhone;
    @FindBy(id = "submitAccount")
    public WebElement submitButton;
    @FindBy(xpath = "//p[contains(text(),'errors')]")
    public WebElement errorAlert;


}
