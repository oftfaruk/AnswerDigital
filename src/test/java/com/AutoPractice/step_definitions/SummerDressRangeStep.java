package com.AutoPractice.step_definitions;

import com.AutoPractice.pages.DashBoard;
import com.AutoPractice.pages.SummerDresses;
import com.AutoPractice.utilities.BrowserUtils;
import com.AutoPractice.utilities.ConfigurationReader;
import com.AutoPractice.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.sl.In;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.Arrays;
import java.util.List;

public class SummerDressRangeStep {
    SummerDresses summer = new SummerDresses();
    DashBoard dash = new DashBoard();

    @Given("User is on the {string} page")
    public void user_is_on_the_page(String string) {

        Driver.get().get(ConfigurationReader.get("url"));
        summer.navigationMenu("Dresses", string);

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


    @When("User changes price range {int} to {int}")
    public void userChangesPriceRangeTo(int left, int right) {
        BrowserUtils.scrollToElement(summer.priceRange);

        WebElement slider = Driver.get().findElement(By.xpath("(//a[@class='ui-slider-handle ui-state-default ui-corner-all'])[2]"));
        for (int i = 0; i < 75; i++) {

            slider.sendKeys(Keys.ARROW_LEFT);

        }

        String text = summer.priceRange.getText();
        String[] rangeNums = text.split("-");
        String leftnum = rangeNums[0].substring(1, 3);
        String rightnum = rangeNums[1].substring(2, 4);

        Assert.assertEquals(left,Integer.parseInt(leftnum));
        Assert.assertEquals(right, Integer.parseInt(rightnum));




    }
}
