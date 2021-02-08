package com.AutoPractice.step_definitions;

import com.AutoPractice.pages.DashBoard;
import com.AutoPractice.pages.SummerDresses;
import com.AutoPractice.utilities.BrowserUtils;
import com.AutoPractice.utilities.ConfigurationReader;
import com.AutoPractice.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class SummerDressRangeStep {
    SummerDresses summer = new SummerDresses();
    DashBoard dash = new DashBoard();

    @Given("User is on the {string} page")
    public void user_is_on_the_page(String string) {

        Driver.get().get(ConfigurationReader.get("url"));
        summer.navigationMenu("Dresses", string);

    }


    @When("User changes price range {string}-{string}")
    public void userChangesPriceRange(String arg0, String arg1) {
        BrowserUtils.scrollToElement(Driver.get().findElement(By.id("layered_price_range")));
        int x = 40;
        BrowserUtils.waitFor(3);
        WebElement slider = Driver.get().findElement(By.id("layered_price_range"));
        int width = slider.getSize().getWidth();
        Actions move = new Actions(Driver.get());
        move.moveToElement(slider, ((width * x) / 100), 30).click();
        move.build().perform();

        System.out.println("Slider moved");
        BrowserUtils.waitFor(5);


    }


    @When("User  hover on {string}")
    public void user_hover_on(String tab) {

        BrowserUtils.hover(dash.womenButton);

    }


    @Given("User is on  {string} page")
    public void user_is_on_page(String string) {
        Driver.get().get(ConfigurationReader.get("url"));
    }


    @Then("Sub navigation options appear")
    public void sub_navigation_options_appear(List<String> options) {
        for (String option : options) {

            Assert.assertTrue(Driver.get().findElement(By.xpath("//a[@title='" + option + "']")).isDisplayed());

        }
    }


}
