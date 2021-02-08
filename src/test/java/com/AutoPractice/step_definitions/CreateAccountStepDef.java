package com.AutoPractice.step_definitions;

import com.AutoPractice.pages.*;
import com.AutoPractice.utilities.BrowserUtils;
import com.AutoPractice.utilities.ConfigurationReader;
import com.AutoPractice.utilities.Driver;
import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;

public class CreateAccountStepDef {
    SignPage sign = new SignPage();
    CreateAccountPage create = new CreateAccountPage();
    String pass = "123456of";
    String emailAdres;
    String name;
    String surname;
    String name_surname;
    MyAccountPage owner = new MyAccountPage();
    DashBoard dash = new DashBoard();
    BasketPage basket = new BasketPage();

    @When("User creates a new account")
    public void user_creates_a_new_account() {
        Driver.get().get(ConfigurationReader.get("url"));
        sign.signin.click();
        Faker faker = new Faker();
        emailAdres = faker.internet().emailAddress();
        sign.emailBox.sendKeys(emailAdres);
        sign.createAccountButton.click();
        name = faker.name().firstName();
        create.firstName.sendKeys(name);
        surname = faker.name().lastName();
        name_surname = name + " " + surname;
        create.lastName.sendKeys(surname);
        create.password.sendKeys(pass);
        create.dayBirth.click();
        Select select = new Select(create.dayBirth);
        select.selectByIndex(21);
        Select select1 = new Select(create.monthBirth);
        create.monthBirth.click();
        select1.selectByIndex(10);
        Select select2 = new Select(create.yearsBirth);
        create.yearsBirth.click();
        select2.selectByValue("1978");
        create.newsletter.click();
        create.speacialOffer.click();
        create.nameAdress.sendKeys(faker.name().firstName());
        create.lastNameAdres.sendKeys(faker.name().lastName());
        create.company.sendKeys("Digital");
        create.adress.sendKeys(faker.address().streetAddress());
        create.city.sendKeys(faker.address().city());
        Select select3 = new Select(create.state);
        select3.selectByValue("43");
        create.postcode.sendKeys("12345");
        create.addİnfo.sendKeys(faker.company().profession());
        //  create.phone.sendKeys(faker.phoneNumber().phoneNumber());
        create.mobilePhone.sendKeys(faker.phoneNumber().extension());
        create.submitButton.click();

        String createdName = owner.accountOwnerName.getText();

        //assert whether the same account owner page that we created

        Assert.assertEquals(owner.accountOwnerName.getText(), createdName);


    }

    @Then("User goes to {string} page")
    public void user_goes_to_page(String expectedSubtitle) {

        String actualPageSubtitle = owner.MyaccountPageSubtitle.getText();

        Assert.assertEquals(expectedSubtitle, actualPageSubtitle);


    }


    @Then("User buys {int} item from {string} {string}")
    public void user_buys_item_from(int count, String tab, String module) throws InterruptedException {

        sign.navigationMenu(tab, module);
        BrowserUtils.scrollToElement(dash.addToCart);
        BrowserUtils.scrollToElement(Driver.get().findElement(By.xpath("//a[@class='quick-view']")));
        dash.addToBasket(count);
        dash.cart.click();
        String text = basket.basketCountText.getText();
        String[] split = text.split(": ");
        String substring = split[1].substring(0, 1);
        int actualCount = Integer.parseInt(substring);
        Assert.assertEquals(count, actualCount);

    }


    @Then("User views {string} in the Your Shopping Cart Page")
    public void user_views_in_the_Your_Shopping_Cart_Page(String expected) {
        String actualText = basket.basketCountText.getText();
        Assert.assertEquals(expected, actualText);
    }


    @Given("User login with {string} email adress")
    public void userLoginWithEmailAdress(String email) {
        Driver.get().get(ConfigurationReader.get("url"));
        dash.signin.click();
        sign.emailForsigning.sendKeys(email);
        sign.passwordBox.sendKeys(pass);
        sign.submitButton.click();


    }

    @And("User views  {string} name in the Your Shopping Cart Page")
    public void userViewsNameInTheYourShoppingCartPage(String expectedName) {
        String actualName = owner.accountowner.getText();
        Assert.assertEquals(expectedName, actualName);

    }

    @Given("User is on the  {string}")
    public void user_is_on_the(String string) {
        Driver.get().get(ConfigurationReader.get("url"));
    }

    @When("User goes Shopping Cart Page")
    public void user_goes_Shopping_Cart_Page() {
        dash.cart.click();

    }

    @Then("{string} button is displayed")
    public void button_is_displayed(String string) {

        Assert.assertTrue(basket.delete.isDisplayed());
    }


    @Given("User is on {string}")
    public void user_is_on(String string) {
        Driver.get().get(ConfigurationReader.get("url"));
        dash.signin.click();
        Faker faker = new Faker();
        sign.emailBox.sendKeys(faker.internet().emailAddress());
        sign.createAccountButton.click();


    }


    @When("User tries to create account without filling all boxes")
    public void user_tries_to_create_account_without_filling_all_boxes() {

        create.city.sendKeys("Halifax");
        create.submitButton.click();


    }

    @Then("User takes {string} message")
    public void user_takes_message(String expected) {

        Assert.assertTrue(create.errorAlert.getText().contains(expected.toLowerCase()));

    }

}
