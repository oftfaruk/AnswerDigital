package com.AutoPractice.step_definitions;

import com.AutoPractice.pages.BasketPage;
import com.AutoPractice.pages.DashBoard;
import com.AutoPractice.utilities.BrowserUtils;
import com.AutoPractice.utilities.ConfigurationReader;
import com.AutoPractice.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class BasketStepDef {

         BasketPage basket = new BasketPage();
         DashBoard dash = new DashBoard();

    @Given("User has {int} item in the Basket")
    public void userHasItemInTheBasket(int count) throws InterruptedException {

        Driver.get().get(ConfigurationReader.get("url"));

     //   BrowserUtils.scrollToElement(dash.addToCart);

        dash.addToBasket(count);
        dash.cart.click();
        String text = basket.basketCountText.getText();
        System.out.println("text = " + text);
        String[] split = text.split(": ");
        String substring = split[1].substring(0, 1);
        int actualCount=Integer.parseInt(substring);
        System.out.println("actualCount = " + actualCount);
        Assert.assertEquals(count, actualCount);
    }

    @When("User deletes the item from the Basket")
    public void user_deletes_the_item_from_the_Basket() {
        BrowserUtils.scrollToElement(basket.delete);
        basket.deleteİtems();
        BrowserUtils.waitFor(2);

    }


    @Then("User should be able to see {string} message")
    public void userShouldBeAbleToSeeMessage(String expectedMessage) {
        BrowserUtils.scrollToElement(basket.emptyBasketText);
        String actualtext = basket.emptyBasketText.getText();
        System.out.println("actualtext = " + actualtext);
        Assert.assertEquals(expectedMessage, actualtext);
    }



}
